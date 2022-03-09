package com.slackandassociates.cards.milestonecards;

import java.io.*;
import com.slackandassociates.cards.*;

/** 
 * Class defines a milestone card type class and several constants used
 * by milestone card support classes.<br>
 * Cards are assumed to be comparable to each other with the natural
 * order being hazards, remedies, safeties and mileage cards (high to low).
 * Generally, milestone cards have no real order and are usually not sorted.<br>
 * Card values are a set of enumerations kept in the CardEnum class.  All card
 * values are defined there.<br><br>
 * <b>Changes:</b>
 * <ul>
 * <li> 2022-02-20 - Initial release.
 * </ul>
 * @see CardEnum
 * @author Michael G. Slack
 * @author mike.g.slack@gmail.com
 * @created 2022-02-20
 * @version Version 1.00 2022-02-20
*/
public class MilestoneCard implements Card
{
    // public static return values
    /** Invalid value return (from most methods). */
    public static final int JMC_INVALID_RETURN = BlankCard.JC_INVALID_RETURN;

    /** Card value - empty (not a valid card value). */
    public static final int JMC_EMPTY_CARD = 0;
    /** Card value - hazard, out of gas. */
    public static final int JMC_OUT_OF_GAS = 1;
    /** Card value - hazard, flat tire. */
    public static final int JMC_FLAT_TIRE = 2;
    /** Card value - hazard, accident. */
    public static final int JMC_ACCIDENT = 3;
    /** Card value - hazard, speed limit 50. */
    public static final int JMC_SPEED_LIMIT_50 = 4;
    /** Card value - hazard, stop. */
    public static final int JMC_STOP = 5;
    /** Card value - remedy, gas. */
    public static final int JMC_GAS = 6;
    /** Card value - remedy, spare tire. */
    public static final int JMC_SPARE_TIRE = 7;
    /** Card value - remedy, repairs. */
    public static final int JMC_REPAIRS = 8;
    /** Card value - remedy, end speed limit. */
    public static final int JMC_END_SPEED_LIMIT = 9;
    /** Card value - remedy, roll. */
    public static final int JMC_ROLL = 10;
    /** Card value - safety, extra tank. */
    public static final int JMC_EXTRA_TANK = 11;
    /** Card value - safety, permanent tire. */
    public static final int JMC_PERMANENT_TIRE = 12;
    /** Card value - safety, driving ace. */
    public static final int JMC_DRIVING_ACE = 13;
    /** Card value - safety, right of way. */
    public static final int JMC_RIGHT_OF_WAY = 14;
    /** Card value - mileage, 200 miles. */
    public static final int JMC_M200 = 15;
    /** Card value - mileage, 100 miles. */
    public static final int JMC_M100 = 16;
    /** Card value - mileage, 75 miles. */
    public static final int JMC_M75 = 17;
    /** Card value - mileage, 50 miles. */
    public static final int JMC_M50 = 18;
    /** Card value - mileage, 25 miles. */
    public static final int JMC_M25 = 19;
	
    /** Card type - Hazard. */
    public static final int JMC_HAZARD = 0;
    /** Card type - Remedy. */
    public static final int JMC_REMEDY = 1;
    /** Card type - Safety. */
    public static final int JMC_SAFETY = 2;
    /** Card type - Mileage. */
    public static final int JMC_MILEAGE = 3;

    // private references
    private CardEnum cardValue = BlankCardEnum.NO_CARD;
    private int compMode = Card.JC_COMP_DEFAULT; // only value allowed

    // --------------------- Constructors --------------------------------
	
    /**
     * Default constructor - no parameters.  Card has the value of 
     * BlankCardEnum.NO_CARD.
    */
    public MilestoneCard()
    {
        // empty constructor
    }

    /**
     * Constructor to create a card reference with a specific value.
     * @param ceCardVal CardEnum representing the card value to assign to the card
     * reference.
     * @see CardEnum
    */
    public MilestoneCard(CardEnum ceCardVal)
    {
        cardValue = ceCardVal;
    }

    // ------------------ Public Methods --------------------------------

    /**
     * Method used to return the value of the card instance as the
     * constant enumerated value.
     * @return CardEnum of the Card instance (value of the card).
     * @see MilestoneCardEnum
    */
    public CardEnum getCardValue()
    {
        return cardValue;
    }

    /**
     * Method used to set the card value.  Need to specify one of the
     * CardEnum values that will represent the value of this card.
     * @param ceCV CardEnum containing the new card value to set card instance to.
     * @throws CardInvalidEnumException when an CardEnum instance is passed in that
     * is not a MilestoneCardEnum instance.
     * @see MilestoneCardEnum
    */
    public void setCardValue(CardEnum ceCV) throws CardInvalidEnumException
    {
        if (ceCV instanceof MilestoneCardEnum)
            cardValue = ceCV;
        else
            throw new CardInvalidEnumException("MilestoneCard.setCardValue - expecting a MilestoneCardEnum instance.");
    }

    /**
     * Method used to return the color of the card. Returns an invalid code,
     * milestone cards don't have colors.
     * @return An int representing the color of the card value.
    */
    public int getCardColor()
    {
        return JMC_INVALID_RETURN;
    }

    /**
     * Method used to return the type of the Milestone card.  Milestone cards do
     * not have suits, but use this method to return the card type (JMC_type constant).
     * @return An int representing the type of the milestone card value.
    */
    public int getCardSuit()
    {
        int typ = JMC_INVALID_RETURN;

        if (cardValue.getValue() >= JMC_OUT_OF_GAS && cardValue.getValue() <= JMC_STOP)
            typ = JMC_HAZARD;
        else if (cardValue.getValue() >= JMC_GAS && cardValue.getValue() <= JMC_ROLL)
            typ = JMC_REMEDY;
        else if (cardValue.getValue() >= JMC_EXTRA_TANK && cardValue.getValue() <= JMC_RIGHT_OF_WAY)
            typ = JMC_SAFETY;
        else if (cardValue.getValue() >= JMC_M200 && cardValue.getValue() <= JMC_M25)
            typ = JMC_MILEAGE;

        return typ;
    }

    /**
     * Method used to return the point value of the card value.  Returns
     * just the raw point value of the card (i.e., 1 - 19).<br>
     * @return A JMC_xxx card value constant ('out of gas' .. '25 mile').
    */
    public int getCardPointValue()
    {
        return cardValue.getValue();
    }

    /**
     * Method used to get the point value of a card returning 10 for face
     * cards if the card implementation contains 'face' cards.  Milestone
     * cards do not have 'face' cards.
     * @return A int point value of the card with 'face' values set to 10.
    */
    public int getCardPointValueFace10()
    {
        return JMC_INVALID_RETURN;
    }

    /**
     * Method used to return the card value (name) as a string.
     * @return String containing the name of the card.
    */
    public String getCardName()
    {
        return cardValue.toString();
    }

    /**
     * Method used to return the currently set comparison mode for the
     * class instance.  Note, milestone cards will only have
     * Card.JC_COMP_DEFAULT set for comparison mode.
     * @return A Card.JC_COMP_xxx constant of the current comparison mode.
    */
    public int getCompMode()
    {
        return compMode;
    }

    /**
     * Method used to set the comparison mode (used by the compareTo method)
     * for the Card instance.  Milestone cards do not allow for any other value
     * than Card.JC_COMP_DEFAULT, so any value sent in is ignored (comp mode not
     * changed).
     * @param iCompModeFlag int flag specifying one of the Card.JC_COMP_xxx constants.
    */
    public void setCompMode(int iCompModeFlag)
    {
        // ignore input
    }

    // -------------- interface/over-rode methods ----------------------------

    /**
     * Method used to compare one card to another card.  Note, the placeholder
     * card values will be greater than any milestone card.
     * @param o Object to compare to the referenced object.
     * @return A 0 if equal, -1 if less than, 1 if greater than.
     * @throws ClassCastException If the specified object's type prevents it
     * from being compared to this Object.
    */
    public int compareTo(Object o)
    {
        if ((o == null) || (!(o instanceof Card)))
            throw new ClassCastException("MilestoneCard: Invalid object being compared.");

        int iRet = 0; // assume equality (:))
        // no real compmode, just compare point value
        int iC1 = getCardPointValue();
        int iC2 = ((Card) o).getCardPointValue();

        if (iC1 > iC2)
            iRet = 1;
        else if (iC1 < iC2)
            iRet = -1;
        // else iC1 == iC2

        return iRet;
    }

    /**
     * Method used to return a hashcode value of a specific instance to
     * the caller.
     * @return An int containing the hashcode of a Card instance.
    */
    public int hashCode()
    {
        return getCardName().hashCode();
    }

    /**
     * Method used to determine if this object instance is equivalent to
     * another.  Will return false if the object equaling is not a Card
     * instance.  Method uses the current comparison mode flag set to
     * determine equivalence.
     * @param obj Object to compare to see if equal or not.
     * @return A boolean value set to true if equal (equivalent), otherwise false.
    */
    public boolean equals(Object obj)
    {
        boolean bRet = false; // assume not equal

        if ((obj != null) && (obj instanceof Card)) {
            try {
                bRet = (compareTo(obj) == 0);
            }
            catch (Exception e) { }
        }

        return bRet;
    }

    /**
     * Method used to return the class instance as a string value.  In
     * reality, returns the result of the 'getCardName()' method.
     * @return A String value representing the class instance.
    */
    public String toString()
    {
        return getCardName();
    }
}
