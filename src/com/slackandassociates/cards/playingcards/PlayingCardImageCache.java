package com.slackandassociates.cards.playingcards;

import java.util.*;
import java.io.*;
import java.awt.*;

/** 
 * Class used to load all card images and 'cache' them internally so as
 * to have them available for use by any 'playing card' type program.  Uses
 * images stored with the class (within the jar).  Allows the cache to be
 * loaded at a later point than construction. <br><br>
 * <b>Changes</b>
 * <ul>
 * <li> 2001/07/23 - Initial release.
 * <li> 2001/08/10 - Modified to use CardEnum class.
 * <li> 2001/09/15 - Added card image size constants.
 * <li> 2002/06/23 - Fixed a few minor issues with class (if image cache not
 * preloaded).  Change image load function to use a ByteArrayOutputStream
 * instead of a 'fixed' array.
 * <li> 2004-08-19 - Modified to use the PlayingCardEnum implementation.
 * <li> 2005-05-04 - Modified to load up two additional images.
 * <li> 2007-10-14 - Modified to load up the additional image.
 * </ul>
 * @author Michael G. Slack
 * @author slack@attglobal.net
 * @created 2001-07-23
 * @version Version 2.02 2007-10-14
*/
public class PlayingCardImageCache
{
    // private statics
    /** Path in 'jar' to images. */
    private static final String CIC_PATH = "/com/slackandassociates/cards/playingcards/images/";
    /** Image extension. */
    private static final String CIC_EXT = ".gif";

    // private references
    /** Hashtable containing the cached images. */
    private HashMap cardCache = new HashMap(70);
    /** Cache loaded flag. */
    private boolean bImagesLoaded = false;

    // public statics
    /** Width of card images (in pixels). */
    public static final int IMAGE_WIDTH = 71;
    /** Height of card images (in pixels). */
    public static final int IMAGE_HEIGHT = 96;
    /** Good offset value to use when laying cards on top of each other (in pixels). */
    public static final int IMAGE_OFFSET = 15;

    // ------------------------- Constructors -------------------------------

    /** Constructor used to create a card image cache instance.  Will load
     * the card images up during construction.
    */
    public PlayingCardImageCache()
    {
        this(true);
    }

    /** Constructor used to create a card image cache instance.  Accepts a 
     * parameter to either load the images into the cache at creation or
     * to wait until the caller calls the load images method.
     * @param bLoadNow If true, will load the images into the cache during
     * creation, else the image cache is created empty.
    */
    public PlayingCardImageCache(boolean bLoadNow)
    {
        if (bLoadNow) loadImageCache();
    }

    // ------------------------- Private Methods ---------------------------

    /** Method used to load the card image from the resource (jar file) and
     * save it as an 'Image' into the hashtable.
     * @param iCard Int containing the card to load and save in the cache.
     * Keys the cached on the int value of the card.
     * @param tk Toolkit used to create the image with.
    */
    private void loadImage(int iCard, Toolkit tk)
    {
        Image img = null;

        try {
            String ss = CIC_PATH + iCard + CIC_EXT;
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

    // -------------------------- Public Methods -------------------------

    /** Method used to load the image cache with the playing card images.
     * Will only allow the images to be loaded once.  If the images are loaded
     * during the construction stage, this method does nothing.
    */
    public void loadImageCache()
    {
        if (!bImagesLoaded) {
            bImagesLoaded = true;

            Toolkit tk = Toolkit.getDefaultToolkit();

            // load card images
            int ff = PlayingCardEnum.ACE_OF_CLUBS.getValue();
            int ll = PlayingCardEnum.KING_OF_SPADES.getValue();
            for (int i = ff; i <= ll; i++) {
                loadImage(i, tk);
            }
            // load back images
            ff = PlayingCardEnum.JC_CARDBACK_VAL1.getValue();
            ll = PlayingCardEnum.JC_CARDBACK_VAL8.getValue();
            for (int i = ff; i <= ll; i++) {
                loadImage(i, tk);
            }
            // load symbol images
            ff = PlayingCardEnum.JC_CARDSYMBOL_VAL1.getValue();
            ll = PlayingCardEnum.JC_CARDSYMBOL_VAL4.getValue();
            for (int i = ff; i <= ll; i++) {
                loadImage(i, tk);
            }
            // load jokers
            loadImage(PlayingCardEnum.RED_JOKER.getValue(), tk);
            loadImage(PlayingCardEnum.BLACK_JOKER.getValue(), tk);
        }
    }

    /** Method used to block the application and wait for the card images
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
            System.err.println("PlayingCard.waitForImages: " + e);
        }
    }

    /** Method used to return an Image to the caller of a given card.
     * @param c PlayingCard instance to get an image for (from the cache).
     * @return Image matching the card instance passed in.
    */
    public Image getCardImage(PlayingCard c)
    {
        return getCardImage((PlayingCardEnum) c.getCardValue());
    }

    /** Method used to return an Image to the caller of a given card
     * enumeration value.
     * @param ceCardValue A playing card value constant to get the image of.
     * @return An Image instance matching the given card value.
    */
    public Image getCardImage(PlayingCardEnum ceCardValue)
    {
        if (!bImagesLoaded) loadImageCache(); // load if not preloaded already

        return (Image) cardCache.get(""+ceCardValue.getValue());
    }
}
