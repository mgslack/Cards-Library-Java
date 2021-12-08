package com.slackandassociates.cards;

/**
 * Class defines the 'blank' (or no) card enumeration to be used within the
 * card hand and card deck implementations (i.e., set to EMPTY_CARD).  The card
 * implementation contains one card (a blank/empty/no card implementation). <br><br>
 * <b>Changes:</b>
 * <ul>
 * <li> 2004-08-20 - Initial release.
 * </ul>
 * @see CardEnum
 * @author Michael G. Slack
 * @author slack@attglobal.net
 * @created 2004-08-20
 * @version Version 1.00 2004-08-20
*/
public class BlankCard implements Card
{
    // public static return values
    /** Invalid value return (from most methods). */
    public static final int JC_INVALID_RETURN = BlankCardEnum.NO_CARD.getValue();

    // private references
    private CardEnum cardValue = BlankCardEnum.NO_CARD;
    private int compMode = Card.JC_COMP_DEFAULT;

    // --------------------- Constructors --------------------------------
	
    /** Default constructor - no parameters.  Card has the value of 
     * BlankCardEnum.NO_CARD.
    */
    public BlankCard()
    {
        // empty constructor
    }

    // ------------------ Public Methods --------------------------------

    /** Method used to return the value of the card instance as the
     * constant enumerated value.
     * @return CardEnum of the Card instance (value of the card).
     * @see BlankCardEnum
    */
    public CardEnum getCardValue()
    {
        return cardValue;
    }

    /** Method used to set the card value.  This method ignores input (blank
     * card value cannot be changed).
     * @param ceCV CardEnum containing the new card value to set card instance to.
     * @throws CardInvalidEnumException when an invalid CardEnum type is passed in.
    */
    public void setCardValue(CardEnum ceCV) throws CardInvalidEnumException
    {
        // ignored
    }

    /** Method used to return the color of the card.  Returns JC_INVALID_RETURN.
     * @return An int representing the color of the card value.
    */
    public int getCardColor()
    {
        return JC_INVALID_RETURN;
    }

    /** Method used to return the suit of the card.  Returns JC_INVALID_RETURN.
     * @return An int representing the suit of the card value.
    */
    public int getCardSuit()
    {
        return JC_INVALID_RETURN;
    }

    /** Method used to return the point value of the card value.  Returns
     * JC_INVALID_RETURN.
     * @return An int representing the card value constant.
    */
    public int getCardPointValue()
    {
        return JC_INVALID_RETURN;
    }

    /** Method used to get the point value of a card returning 10 for face
     * cards.  Method return JC_INVALID_RETURN.
     * @return A value between 1 and 10 representing the point value of a card.
    */
    public int getCardPointValueFace10()
    {
        return JC_INVALID_RETURN;
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
        compMode = iCompModeFlag;
    }

    // -------------- interface/over-rode methods ----------------------------

    /** Method used to compare one card to another card.  Method only compares
     * the cards enum value to determine comparison.
     * @param o Object to compare to the referenced object.
     * @return A 0 if equal, -1 if less than, 1 if greater than.
     * @throws ClassCastException If the specified object's type prevents it
     * from being compared to this Object.
    */
    public int compareTo(Object o)
    {
        if ((o == null) || (!(o instanceof Card)))
            throw new ClassCastException("BlankCard: Invalid object being compared.");

        int iRet = 0;
        int iC1 = getCardValue().getValue();
        int iC2 = ((Card) o).getCardValue().getValue();        

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
