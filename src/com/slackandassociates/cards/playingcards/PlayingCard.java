package com.slackandassociates.cards.playingcards;

import java.io.*;
import com.slackandassociates.cards.*;

/** 
 * Class defines a playing card type class and several constants used
 * by playing card support classes. <br>
 * Cards are assumed to be comparable to each other with the natural
 * order being ace - king, clubs, diamonds, hearts, spades.  The natural
 * order can be changed using the setCompMode method. <br>
 * Card values are a set of enumerations kept in the CardEnum class.  All card
 * values are defined there. <br><br>
 * <b>Changes:</b>
 * <ul>
 * <li> 2001/07/18 - Initial release.
 * <li> 2001/08/09 - Revised to use CardEnum class.
 * <li> 2004-08-19 - Modified to use Card interface definition.
 * </ul>
 * @see CardEnum
 * @author Michael G. Slack
 * @author slack@attglobal.net
 * @created 2001-07-18
 * @version Version 2.00 2004-08-19
*/
public class PlayingCard implements Card
{
    // public static return values
    /** Invalid value return (from most methods). */
    public static final int JPC_INVALID_RETURN = BlankCard.JC_INVALID_RETURN;

    /** Card is a red card (heart/diamond). */
    public static final int JPC_RED_CARD = 0;
    /** Card is a black card (club/spade). */
    public static final int JPC_BLACK_CARD = 1;

    /** Card suit is a club. */
    public static final int JPC_CLUBS = 0;
    /** Card suit is a diamond. */
    public static final int JPC_DIAMONDS = 1;
    /** Card suit is a heart. */
    public static final int JPC_HEARTS = 2;
    /** Card suit is a spade. */
    public static final int JPC_SPADES = 3;

    /** Card value - ace. */
    public static final int JPC_ACE = 1;
    /** Card value - two. */
    public static final int JPC_TWO = 2;
    /** Card value - three. */
    public static final int JPC_THREE = 3;
    /** Card value - four. */
    public static final int JPC_FOUR = 4;
    /** Card value - five. */
    public static final int JPC_FIVE = 5;
    /** Card value - six. */
    public static final int JPC_SIX = 6;
    /** Card value - seven. */
    public static final int JPC_SEVEN = 7;
    /** Card value - eight. */
    public static final int JPC_EIGHT = 8;
    /** Card value - nine. */
    public static final int JPC_NINE = 9;
    /** Card value - ten. */
    public static final int JPC_TEN = 10;
    /** Card value - jack. */
    public static final int JPC_JACK = 11;
    /** Card value - queen. */
    public static final int JPC_QUEEN = 12;
    /** Card value - king. */
    public static final int JPC_KING = 13;

    // private references
    private CardEnum cardValue = BlankCardEnum.NO_CARD;
    private int compMode = Card.JC_COMP_DEFAULT;

    // --------------------- Constructors --------------------------------
	
    /** Default constructor - no parameters.  Card has the value of 
     * BlankCardEnum.NO_CARD.
    */
    public PlayingCard()
    {
        // empty constructor
    }

    /** Constructor to create a card reference with a specific value.
     * @param ceCardVal CardEnum representing the card value to assign to the card
     * reference.
     * @see CardEnum
    */
    public PlayingCard(CardEnum ceCardVal)
    {
        cardValue = ceCardVal;
    }

    // ------------------ Public Methods --------------------------------

    /** Method used to return the value of the card instance as the
     * constant enumerated value.
     * @return CardEnum of the Card instance (value of the card).
     * @see PlayingCardEnum
    */
    public CardEnum getCardValue()
    {
        return cardValue;
    }

    /** Method used to set the card value.  Need to specify one of the
     * CardEnum values that will represent the value of this card.
     * @param ceCV CardEnum containing the new card value to set card instance to.
     * @throws CardInvalidEnumException when an CardEnum instance is passed in that
     * is not a PlayingCardEnum instance.
     * @see PlayingCardEnum
    */
    public void setCardValue(CardEnum ceCV) throws CardInvalidEnumException
    {
        if (ceCV instanceof PlayingCardEnum)
            cardValue = ceCV;
        else
            throw new CardInvalidEnumException("PlayingCard.setCardValue - expecting a PlayingCardEnum instance.");
    }

    /** Method used to return the color of the card (red/black).  Jokers are
     * valid cards for this method.
     * @return A JPC_color constant containing the color of the card value.
    */
    public int getCardColor()
    {
        int iRet = JPC_INVALID_RETURN;
        int ii = cardValue.getValue();

        if (((ii >= PlayingCardEnum.ACE_OF_DIAMONDS.getValue()) &&
             (ii <= PlayingCardEnum.KING_OF_HEARTS.getValue())) ||
            (ii == PlayingCardEnum.RED_JOKER.getValue()))
            iRet = JPC_RED_CARD;
        else if (((ii >= PlayingCardEnum.ACE_OF_CLUBS.getValue()) &&
                  (ii <= PlayingCardEnum.KING_OF_CLUBS.getValue())) ||
                 ((ii >= PlayingCardEnum.ACE_OF_SPADES.getValue()) &&
                  (ii <= PlayingCardEnum.KING_OF_SPADES.getValue())) ||
                 (ii == PlayingCardEnum.BLACK_JOKER.getValue()))
            iRet = JPC_BLACK_CARD;

        return iRet;
    }

    /** Method used to return the suit of the card.
     * @return A JPC_suit constant containing the suit of the card value.
    */
    public int getCardSuit()
    {
        int iRet = JPC_INVALID_RETURN;
        int ii = cardValue.getValue();

        if ((ii >= PlayingCardEnum.ACE_OF_CLUBS.getValue()) &&
            (ii <= PlayingCardEnum.KING_OF_CLUBS.getValue()))
            iRet = JPC_CLUBS;
        else if ((ii >= PlayingCardEnum.ACE_OF_DIAMONDS.getValue()) &&
                 (ii <= PlayingCardEnum.KING_OF_DIAMONDS.getValue()))
            iRet = JPC_DIAMONDS;
        else if ((ii >= PlayingCardEnum.ACE_OF_HEARTS.getValue()) &&
                 (ii <= PlayingCardEnum.KING_OF_HEARTS.getValue()))
            iRet = JPC_HEARTS;
        else if ((ii >= PlayingCardEnum.ACE_OF_SPADES.getValue()) &&
                 (ii <= PlayingCardEnum.KING_OF_SPADES.getValue()))
            iRet = JPC_SPADES;

        return iRet;
    }

    /** Method used to return the point value of the card value.  Returns
     * just to point value of the card (i.e., 1 - 13) without the suit. <br>
     * If the card instance is a joker, the card point value is returned
     * as zero.  It is up to the caller of the method to provide value to
     * jokers if using.
     * @return A JPC_xxx card value constant (ace .. king).
    */
    public int getCardPointValue()
    {
        int iRet = JPC_INVALID_RETURN;
        int ii = cardValue.getValue();

        // standardize on CLUB values (== JPC_ACE .. JPC_KING values)
        if ((ii >= PlayingCardEnum.ACE_OF_SPADES.getValue()) &&
            (ii <= PlayingCardEnum.KING_OF_SPADES.getValue()))
            ii -= PlayingCardEnum.KING_OF_HEARTS.getValue();
        else if ((ii >= PlayingCardEnum.ACE_OF_HEARTS.getValue()) &&
                 (ii <= PlayingCardEnum.KING_OF_HEARTS.getValue()))
            ii -= PlayingCardEnum.KING_OF_DIAMONDS.getValue();
        else if ((ii >= PlayingCardEnum.ACE_OF_DIAMONDS.getValue()) &&
                 (ii <= PlayingCardEnum.KING_OF_DIAMONDS.getValue()))
            ii -= PlayingCardEnum.KING_OF_CLUBS.getValue();

        // are we in the club range?
        if ((ii >= PlayingCardEnum.ACE_OF_CLUBS.getValue()) &&
            (ii <= PlayingCardEnum.KING_OF_CLUBS.getValue()))
            iRet = ii;

        // check for jokers - return 0 for point value of them...
        if ((cardValue == PlayingCardEnum.RED_JOKER) ||
            (cardValue == PlayingCardEnum.BLACK_JOKER))
            iRet = 0;

        return iRet;
    }

    /** Method used to get the point value of a card returning 10 for face
     * cards (jack, queen, king).
     * @return A value between 1 and 10 representing the point value of a card.
    */
    public int getCardPointValueFace10()
    {
        int iRet = getCardPointValue();

        if ((iRet >= PlayingCardEnum.JACK_OF_CLUBS.getValue()) &&
            (iRet <= PlayingCardEnum.KING_OF_CLUBS.getValue()))
            iRet = PlayingCardEnum.TEN_OF_CLUBS.getValue();

        return iRet;
    }

    /** Method used to return the card value (name) as a string.
     * @return String containing the name of the card.
    */
    public String getCardName()
    {
        return cardValue.toString();
    }

    /** Method used to return the currently set comparison mode for the
     * class instance.
     * @return A Card.JC_COMP_xxx constant of the current comparison mode.
    */
    public int getCompMode()
    {
        return compMode;
    }

    /** Method used to set the comparison mode (used by the compareTo method)
     * for the Card instance.
     * @param iCompModeFlag int flag specifying one of the Card.JC_COMP_xxx constants.
    */
    public void setCompMode(int iCompModeFlag)
    {
        if ((iCompModeFlag >= Card.JC_COMP_DEFAULT) &&
            (iCompModeFlag <= Card.JC_COMP_NOFACE))
            compMode = iCompModeFlag;
    }

    // -------------- interface/over-rode methods ----------------------------

    /** Method used to compare one card to another card.  When using the
     * default comparison mode, card backs, symbols and jokers compare
     * greater than the playing cards.  If using any other mode, card backs,
     * symbols and jokers compare less than the playing cards.
     * @param o Object to compare to the referenced object.
     * @return A 0 if equal, -1 if less than, 1 if greater than.
     * @throws ClassCastException If the specified object's type prevents it
     * from being compared to this Object.
    */
    public int compareTo(Object o)
    {
        if ((o == null) || (!(o instanceof Card)))
            throw new ClassCastException("PlayingCard: Invalid object being compared.");

        int iRet = 0; // assume equality (:))
        int iC1, iC2;

        switch (compMode) {
            case Card.JC_COMP_NOSUIT:
                iC1 = getCardPointValue();
                iC2 = ((Card) o).getCardPointValue();
                break;
            case Card.JC_COMP_NOFACE:
                iC1 = getCardPointValueFace10();
                iC2 = ((Card) o).getCardPointValueFace10();
                break;
            default:
                iC1 = getCardValue().getValue();
                iC2 = ((Card) o).getCardValue().getValue();
                break;
        }

        if (iC1 > iC2)
            iRet = 1;
        else if (iC1 < iC2)
            iRet = -1;
        // else iC1 == iC2

        return iRet;
    }

    /** Method used to return a hashcode value of a specific instance to
     * the caller.
     * @return An int containing the hashcode of a Card instance.
    */
    public int hashCode()
    {
        return getCardName().hashCode();
    }

    /** Method used to determine if this object instance is equivalent to
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

    /** Method used to return the class instance as a string value.  In
     * reality, returns the result of the 'getCardName()' method.
     * @return A String value representing the class instance.
    */
    public String toString()
    {
        return getCardName();
    }
}
