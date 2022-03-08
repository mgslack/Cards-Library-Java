package com.slackandassociates.cards.milestonecards;

import java.util.*;
import java.io.*;
import java.awt.*;
import com.slackandassociates.cards.CardImageCache;

/** 
 * Class used to load all milestone card images and 'cache' them internally so
 * as to have them available for use by any program using the milestone cards.
 * Uses images stored with the class (within the jar).  Allows the cache to be
 * loaded at a later point than construction, by default will load the cache
 * during construction. <br><br>
 * <b>Changes</b>
 * <ul>
 * <li> 2022-02-20 - Initial release.
 * </ul>
 * @author Michael G. Slack
 * @author mike.g.slack@gmail.com
 * @created 2022-02-20
 * @version Version 1.00 2022-02-20
*/
public class MilestoneCardImageCache extends CardImageCache
{
    // private statics
    /** Path in 'jar' to images. */
    private static final String CIC_PATH = "/com/slackandassociates/cards/milestonecards/images/";
    /** Image extension. */
    private static final String CIC_EXT = ".bmp";

    // public statics
    /** Width of card images (in pixels). */
    public static final int IMAGE_WIDTH = 60;
    /** Height of card images (in pixels). */
    public static final int IMAGE_HEIGHT = 90;
    /** Good offset value to use when laying cards on top of each other (in pixels). */
    public static final int IMAGE_OFFSET = 12;

    // --------------------------- Constructors -------------------------------

    /**
     * Constructor used to create a card image cache instance.  Will load
     * the card images up during construction.
    */
    public MilestoneCardImageCache()
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
    public MilestoneCardImageCache(boolean bLoadNow)
    {
        super(bLoadNow, CIC_PATH, CIC_EXT);
    }

    // --------------------- Implemented Protected Methods --------------------

    /**
     * Method used to loop through and get all milestone card images loaded into
     * the image cache.<br>
     * Called by the parent abstract class to load the images.
    */
    protected void loopAndLoad()
    {
        Toolkit tk = Toolkit.getDefaultToolkit();

        // load card images along with place holders, not blank probably not used...
        int ff = MilestoneCardEnum.JMC_BLANK.getValue();
        int ll = MilestoneCardEnum.JMC_NORMAL_PLACEHOLDER.getValue();
        for (int i = ff; i <= ll; i++) {
            loadImage(i, tk);
        }
    }
}
