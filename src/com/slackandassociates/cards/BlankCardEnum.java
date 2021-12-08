package com.slackandassociates.cards;

/**
 * Class defines the card value enumerations to be used by the BlankCard, CardHand
 * and CardDeck classes.  The enumeration contains just one value (NO_CARD). <br><br>
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
public class BlankCardEnum implements CardEnum
{
    // public constants
    /** Card value - no card/invalid card */
    public static final CardEnum NO_CARD = new BlankCardEnum();

    // private value reference
    private int iValue = CardEnum.JC_NO_CARD_VALUE;

    // ---------------------- Constructor ---------------------------

    /** Constructor to create an enumeration object.  Kept private
     * because these shouldn't be created outside of this class.
    */
    private BlankCardEnum()
    {
        // empty
    }

    // ----------------------- Public Methods -----------------------

    /** Method used to return the value of this enumeration as a int.
     * @return The value of the card enumeration instance.
    */
    public int getValue()
    {
        return iValue;
    }

    /** Method used to return the value of the card enumeration instance
     * as a String.
     * @return String representation of the value of the card enumeration
     * instance.
    */
    public String toString()
    {
        return "Not a valid card/No card";
    }
}
