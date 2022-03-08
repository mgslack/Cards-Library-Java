package com.slackandassociates.cards;

import java.util.*;
import java.io.*;
import java.awt.*;

/** 
 * Abstract class used to load card images and 'cache' them internally so
 * as to have them available for use by any program using the card implementations.
 * Assumes images stored with the class (within the jar).  Allows the cache to be
 * loaded at a later point than construction.<br>
 * Implementations should contain needed constants to define the images loaded into
 * the image cache (width, height, path, extension, etc.).<br><br>
 * <b>Changes</b>
 * <ul>
 * <li> 2022-02-21 - Initial release.
 * </ul>
 * @author Michael G. Slack
 * @author mike.g.slack@gmail.com
 * @created 2022-02-21
 * @version Version 1.00 2022-02-20
*/
public abstract class CardImageCache
{
    // private static
    private static final int INIT_CACHE_SIZE = 70;

    // private references
    /** Hashtable containing the cached images. */
    private HashMap cardCache = new HashMap(INIT_CACHE_SIZE);
    /** Cache loaded flag. */
    private boolean bImagesLoaded = false;
    /** Path to image to be loaded. */
    private String imgPath = "";
    /** Image extension of image to be loaded. */
    private String imgExt = "";

    // ------------------------- Constructors -------------------------------

    /**
     * Constructor used to create a card image cache instance.  Will load
     * the card images up during construction.
     * @param imagePath String with path to images, should have path separator at
     * end if used ('/').
     * @param imageExt String containing extension of image file in jar.  Should
     * have the '.' at the beginning.
    */
    protected CardImageCache(String imagePath, String imageExt)
    {
        this(true, imagePath, imageExt);
    }

    /**
     * Constructor used to create a card image cache instance.  Accepts a 
     * parameter to either load the images into the cache at creation or
     * to wait until the caller calls the load images method.
     * @param bLoadNow If true, will load the images into the cache during
     * creation, else the image cache is created empty.
     * @param imagePath String with path to images, should have path separator at
     * end if used ('/').
     * @param imageExt String containing extension of image file in jar.  Should
     * have the '.' at the beginning.
    */
    protected CardImageCache(boolean bLoadNow, String imagePath, String imageExt)
    {
        if (imagePath != null) imgPath = imagePath;
        if (imageExt != null) imgExt = imageExt;
        if (bLoadNow) loadImageCache();
    }

    // ------------------------- Protected Methods ----------------------------

    /**
     * Method used to load the card image from the resource (jar file) and
     * save it as an 'Image' into the hashtable.<br>
     * Assumption is that the images are stored within the jar containing the
     * card implementation image cache class and that generally, they will be
     * the numeric value of the implemented card - i.e., '/path/1.gif', etc.
     * @param iCard Int containing the card to load and save in the cache.
     * Keys the cached on the int value of the card.
     * @param tk Toolkit used to create the image with.
    */
    protected void loadImage(int iCard, Toolkit tk)
    {
        Image img = null;

        try {
            String ss = imgPath + iCard + imgExt;
            InputStream in = this.getClass().getResourceAsStream(ss);
            BufferedInputStream bs = new BufferedInputStream(in);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            int r = 0;

            do {
                r = bs.read();
                if (r != -1) {
                    bos.write(r);
                }
            } while (r != -1);
            bs.close();

            img = tk.createImage(bos.toByteArray());
            if (img != null) {
                cardCache.put(""+iCard, img);
            }
            else {
                System.out.println("Image failed to load: "+ss);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Abstact method used to by the implementing image cache class to load
     * the specific implemented card images.  Should loop through and load all
     * images associated by the implemented cards, for instance, if playing
     * cards, load jokers (if implemented, card back images, placeholder images,
     * etc., by calling loadImage() for each image to store in the cache.<br>
     * Should not be called directly, but will be called by the loadImageCache()
     * method so that the cache is loaded with all card images used.
    */
    protected abstract void loopAndLoad();

    // -------------------------- Public Methods -------------------------

    /**
     * Method used to load the image cache with the implemented card images.
     * Will only allow the images to be loaded once.  If the images are loaded
     * during the construction stage, this method does nothing.<br>
     * Method will be called automatically when one of the getCardImage() methods
     * are called, will just return if image cache is already loaded, either by
     * the constuctor or by direct call.
    */
    public void loadImageCache()
    {
        if (!bImagesLoaded) {
            bImagesLoaded = true;
            loopAndLoad();
        }
    }

    /**
     * Method used to block the application and wait for the card images
     * to finish loading.  Note: if this method is not called, the images
     * will complete loading when displayed for the first time which may
     * lead to display delays.
     * @param comp Component used to create the MediaTracker with.
    */
    public void waitForImages(Component comp)
    {
        MediaTracker tracker = new MediaTracker(comp);
        Iterator itr = cardCache.keySet().iterator();

        while (itr.hasNext()) {
            String key = (String) itr.next();
            tracker.addImage((Image) cardCache.get(key), 0);
        }

        // Block and wait for all images to be loaded
        try {
            tracker.waitForID(0);
        }
        catch (InterruptedException e) {
            System.err.println("CardImageCache.waitForImages: " + e);
        }
    }

    /**
     * Method used to return an Image to the caller of a given card.
     * @param c Card instance to get an image for (from the cache).
     * @return Image matching the card instance passed in.
    */
    public Image getCardImage(Card c)
    {
        return getCardImage((CardEnum) c.getCardValue());
    }

    /**
     * Method used to return an Image to the caller of a given card
     * enumeration value.
     * @param ceCardValue A card value constant to get the image of.
     * @return An Image instance matching the given card value.
    */
    public Image getCardImage(CardEnum ceCardValue)
    {
        if (!bImagesLoaded) loadImageCache(); // load if not preloaded already

        return (Image) cardCache.get(""+ceCardValue.getValue());
    }
}
