package com.slackandassociates.cards.playingcards;

import java.util.*;
import java.io.*;
import java.awt.*;
import com.slackandassociates.cards.CardImageCache;

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
 * <li> 2022-02-24 - Modified to inheriet from the abstract image cache class.
 * </ul>
 * @author Michael G. Slack
 * @author slack@attglobal.net
 * @created 2001-07-23
 * @version Version 3.00 2022-02-24
*/
public class PlayingCardImageCache extends CardImageCache
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

    // --------------------------- Constructors -------------------------------

    /**
     * Constructor used to create a card image cache instance.  Will load
     * the card images up during construction.
    */
    public PlayingCardImageCache()
    {
        this(true);
    }

    /**
     * Constructor used to create a card image cache instance.  Accepts a 
     * parameter to either load the images into the cache at creation or
     * to wait until the caller calls the load images method.
     * @param bLoadNow If true, will load the images into the cache during
     * creation, else the image cache is created empty.
    */
    public PlayingCardImageCache(boolean bLoadNow)
    {
        super(bLoadNow, CIC_PATH, CIC_EXT);
    }

    // ------------------------- Protected Methods ----------------------------

    /**
     * Method used to loop through and get all playing card images loaded into
     * the image cache.<br>
     * Called by the parent abstract class to load the images.
    */
    protected void loopAndLoad()
    {
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
