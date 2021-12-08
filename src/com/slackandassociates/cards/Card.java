package com.slackandassociates.cards;

import java.io.*;

/**
 * Class defines a card interface class used to define behaviors of
 * a card, like a playing card or another card game card. <br>
 * Card implementations should have a natural order and may have definable
 * orders in addition to the natural comparison order.
 * Card values are a set of enumerations defined by the CardEnum interface.  Each
 * card implementation should define a set of CardEnum's defining the value of
 * the cards in the set. <br>
 * NOTE: The card implementation must contain an empty constructor and a
 * constructor that takes a CardEnum parameter if the card is to be used
 * with the CardDeck. <br><br>
 * <b>Changes:</b>
 * <ul>
 * <li> 2004-08-19 - Interface created.
 * </ul>
 * @see CardEnum
 * @author Michael G. Slack
 * @author slack@attglobal.net
 * @created 2004-08-19
 * @version Version 1.00 2004-08-19
*/
public interface Card extends Serializable, Comparable
{
    /** Comparison mode flag - default comparison.  A straight compare of the
     * cards value.
    */
    public static final int JC_COMP_DEFAULT = 0;
    /** Comparison mode flag - compares only card point values (ignores suit). */
    public static final int JC_COMP_NOSUIT = 1;
    /** Comparison mode flag - compares only card point values (ignores suit
     * and compares as equivalent 10 through king).
    */
    public static final int JC_COMP_NOFACE = 2;

    // ------------------ Public Methods --------------------------------

    /** Method used to return the value of the card instance as the
     * constant enumerated value.
     * @return CardEnum of the Card instance (value of the card).
     * @see CardEnum
    */
    public CardEnum getCardValue();

    /** Method used to set the card value.  Need to specify one of the
     * CardEnum values that will represent the value of this card.
     * @param ceCV CardEnum containing the new card value to set card instance to.
     * @throws CardInvalidEnumException when an invalid CardEnum (per the implemented
     * card instance) is passed into the setCardValue method.
     * @see CardEnum
    */
    public void setCardValue(CardEnum ceCV) throws CardInvalidEnumException;

    /** Method used to return the color of the card.  The card implementation
     * may return a 'no' value for this method if the card implementation does
     * not include colors.
     * @return An int representing the color of the card value.
    */
    public int getCardColor();

    /** Method used to return the suit of the card.  Card implementations
     * may return a 'no' value for this method if the card implementation does
     * not include 'suits'.
     * @return An int representing the suit of the card value.
    */
    public int getCardSuit();

    /** Method used to return the point value of the card value.  Returns
     * just the point value of the card as defined by the card implementation.
     * @return An int value representing the point value of the card.
    */
    public int getCardPointValue();

    /** Method used to get the point value of a card returning 10 for face
     * cards if the card implementation contains 'face' cards.  This method
     * may be implemented to just return the value of the 'getCardPointValue'
     * method if 'face' cards are not pertainent to the card implementation.
     * @return A int point value of the card with 'face' values set to 10.
    */
    public int getCardPointValueFace10();

    /** Method used to return the card value (name) as a string.
     * @return String containing the name of the card.
    */
    public String getCardName();

    /** Method used to return the currently set comparison mode for the
     * class instance.  Mainly used when the card implementation has
     * several comparison orders.  Should use one of the JC_COMP_xxx statics,
     * but can define card implementation specific numbers.
     * @return An int representing the comparison mode of the card implementation.
    */
    public int getCompMode();

    /** Method used to set the comparison mode (used by the compareTo method)
     * for the Card instance.  Mainly used when the card implementation has more
     * than one comparison mode (order).  Should be set to one of the JS_COMP_xxx
     * statics, but can be used to set implementation specific values.
     * @param iCompModeFlag int representing implementation specific comparison mode.
    */
    public void setCompMode(int iCompModeFlag);

    // -------------- interface/over-rode methods ----------------------------

    /** Method used to compare one card to another card.  May be set up to use
     * multiple comparison modes (card ordering) if the card implementation
     * needs it.
     * @param o Object to compare to the referenced object.
     * @return A 0 if equal, -1 if less than, 1 if greater than.
     * @throws ClassCastException If the specified object's type prevents it
     * from being compared to this Object.
    */
    public int compareTo(Object o);

    /** Method used to return a hashcode value of a specific instance to
     * the caller.
     * @return An int containing the hashcode of a Card instance.
    */
    public int hashCode();

    /** Method used to determine if this object instance is equivalent to
     * another.  Will return false if the object equaling is not a Card
     * instance.  Method should use the current comparison mode flag set to
     * determine equivalence if used by the card implementation.
     * @param obj Object to compare to see if equal or not.
     * @return A boolean value set to true if equal (equivalent), otherwise false.
    */
    public boolean equals(Object obj);

    /** Method used to return the class instance as a string value.  Implementations
     * should return the result of 'getCardName()'.
     * @return A String value representing the card implementation instance.
    */
    public String toString();
}
