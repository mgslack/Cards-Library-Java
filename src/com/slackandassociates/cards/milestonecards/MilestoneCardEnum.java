package com.slackandassociates.cards.milestonecards;

import java.io.*;
import com.slackandassociates.cards.*;

/**
 * Class defines the card value enumerations to be used by the MilestoneCard, CardHand
 * and CardDeck classes.  The values enumerated by the class are milestone card
 * values. <br>
 * This class also contains values for special cards, just placeholders (symbols)
 * currently.  New specials/placeholders need to be added here in order to use within
 * the milestone cards. <br><br>
 * <b>Changes:</b>
 * <ul>
 * <li> 2022-02-20 - Initial release.
 * </ul>
 * @author Michael G. Slack
 * @author mike.g.slack@gmail.com
 * @created 2022-02-20
 * @version Version 1.00 2022-02-20
*/
public class MilestoneCardEnum implements CardEnum
{
    // public constants
    // The following numbers assigned to the card as the value of
    // the card enumeration match up to the name of the image file
    // representing the card.  For example, OUT_OF_GAS's image
    // file is named '1.gif'.  The numbers also match up to what
    // the cards native value is.  These numbers should not be
    // changed.
    /** Card value - out of gas */
    public static final CardEnum OUT_OF_GAS = new MilestoneCardEnum(MilestoneCard.JMC_OUT_OF_GAS);
    /** Card value - flat tire */
    public static final CardEnum FLAT_TIRE = new MilestoneCardEnum(MilestoneCard.JMC_FLAT_TIRE);
    /** Card value - accident */
    public static final CardEnum ACCIDENT = new MilestoneCardEnum(MilestoneCard.JMC_ACCIDENT);
    /** Card value - speed limit 50 */
    public static final CardEnum SPEED_LIMIT_50 = new MilestoneCardEnum(MilestoneCard.JMC_SPEED_LIMIT_50);
    /** Card value - stop */
    public static final CardEnum STOP = new MilestoneCardEnum(MilestoneCard.JMC_STOP);
    /** Card value - gas */
    public static final CardEnum GAS = new MilestoneCardEnum(MilestoneCard.JMC_GAS);
    /** Card value - spare tire */
    public static final CardEnum SPARE_TIRE = new MilestoneCardEnum(MilestoneCard.JMC_SPARE_TIRE);
    /** Card value - repairs */
    public static final CardEnum REPAIRS = new MilestoneCardEnum(MilestoneCard.JMC_REPAIRS);
    /** Card value - end speed limit */
    public static final CardEnum END_SPEED_LIMIT = new MilestoneCardEnum(MilestoneCard.JMC_END_SPEED_LIMIT);
    /** Card value - roll */
    public static final CardEnum ROLL = new MilestoneCardEnum(MilestoneCard.JMC_ROLL);
    /** Card value - extra tank */
    public static final CardEnum EXTRA_TANK = new MilestoneCardEnum(MilestoneCard.JMC_EXTRA_TANK);
    /** Card value - permanent tire */
    public static final CardEnum PERMANENT_TIRE = new MilestoneCardEnum(MilestoneCard.JMC_PERMANENT_TIRE);
    /** Card value - driving ace */
    public static final CardEnum DRIVING_ACE = new MilestoneCardEnum(MilestoneCard.JMC_DRIVING_ACE);
    /** Card value - right of way */
    public static final CardEnum RIGHT_OF_WAY = new MilestoneCardEnum(MilestoneCard.JMC_RIGHT_OF_WAY);
    /** Card value - 200 miles */
    public static final CardEnum M200 = new MilestoneCardEnum(MilestoneCard.JMC_M200);
    /** Card value - 100 miles */
    public static final CardEnum M100 = new MilestoneCardEnum(MilestoneCard.JMC_M100);
    /** Card value - 75 miles */
    public static final CardEnum M75 = new MilestoneCardEnum(MilestoneCard.JMC_M75);
    /** Card value - 50 miles */
    public static final CardEnum M50 = new MilestoneCardEnum(MilestoneCard.JMC_M50);
    /** Card value - 25 miles */
    public static final CardEnum M25 = new MilestoneCardEnum(MilestoneCard.JMC_M25);

    // card image values (backs / placeholder graphics)
	/** Card value (blank card, if needed), colored squares. */
    public static final CardEnum JMC_BLANK = new MilestoneCardEnum(MilestoneCard.JMC_EMPTY_CARD);
    /** Card value (players cards spot - placeholder), x w/purple strips. */
    public static final CardEnum JMC_PLAYERS_PLACEHOLDER = new MilestoneCardEnum(20);
    /** Card value (battle piles and discard placeholder), x with 'milestone in center. */
    public static final CardEnum JMC_NORMAL_PLACEHOLDER = new MilestoneCardEnum(21);

    // private value reference
    private int iValue = CardEnum.JC_NO_CARD_VALUE;

    // ---------------------- Constructor ---------------------------

    /**
     * Constructor to create an enumeration object.  Kept private
     * because these shouldn't be created outside of this class.
     * @param iVal The int value the card enumerator stands for.  This
     * value is used by the image cache routine to return a proper image
     * to the caller with.
    */
    private MilestoneCardEnum(int iVal)
    {
        iValue = iVal;
    }

    // ----------------------- Public Methods -----------------------

    /**
     * Method used to return the value of this enumeration as a int.
     * @return The value of the card enumeration instance.
    */
    public int getValue()
    {
        return iValue;
    }

    /**
     * Method used to return the value of the card enumeration instance
     * as a String.
     * @return String representation of the value of the card enumeration
     * instance.
    */
    public String toString()
    {
        String sRet = "Not a valid card/No card";

        if (iValue != CardEnum.JC_NO_CARD_VALUE)
        {
            // what is it...
            switch (iValue) {
                case MilestoneCard.JMC_EMPTY_CARD:
                    sRet = "Blank (placeholder)"; break;
                case MilestoneCard.JMC_OUT_OF_GAS:
                    sRet = "Out of Gas"; break;
                case MilestoneCard.JMC_FLAT_TIRE:
                    sRet = "Flat Tire"; break;
                case MilestoneCard.JMC_ACCIDENT:
                    sRet = "Accident"; break;
                case MilestoneCard.JMC_SPEED_LIMIT_50:
                    sRet = "Speed Limit 50"; break;
                case MilestoneCard.JMC_STOP:
                    sRet = "Stop"; break;
                case MilestoneCard.JMC_GAS:
                    sRet = "Gas"; break;
                case MilestoneCard.JMC_SPARE_TIRE:
                    sRet = "Spare Tire"; break;
                case MilestoneCard.JMC_REPAIRS:
                    sRet = "Repairs"; break;
                case MilestoneCard.JMC_END_SPEED_LIMIT:
                    sRet = "End Speed Limit"; break;
                case MilestoneCard.JMC_ROLL:
                    sRet = "Roll"; break;
                case MilestoneCard.JMC_EXTRA_TANK:
                    sRet = "Extra Tank"; break;
                case MilestoneCard.JMC_PERMANENT_TIRE:
                    sRet = "Permanent Tire"; break;
                case MilestoneCard.JMC_DRIVING_ACE:
                    sRet = "Driving Ace"; break;
                case MilestoneCard.JMC_RIGHT_OF_WAY:
                    sRet = "Right-of-Way"; break;
                case MilestoneCard.JMC_M200:
                    sRet = "200"; break;
                case MilestoneCard.JMC_M100:
                    sRet = "100"; break;
                case MilestoneCard.JMC_M75:
                    sRet = "75"; break;
                case MilestoneCard.JMC_M50:
                    sRet = "50"; break;
                case MilestoneCard.JMC_M25:
                    sRet = "25"; break;
                case 20: sRet = "Players cards (placeholder)"; break;
                case 21: sRet = "Normal (placeholder)"; break;
                default : sRet = "?"+iValue+"?"; break;
            }
        }

        return sRet;
    }
}
