package com.slackandassociates.cards;

import java.io.*;

/**
 * Class defines the card value enumeration interface to be used by the Card, CardHand
 * and CardDeck interfaces.  The interface is used to enforce a correct value for
 * a card is given.  <b>Note:</b> The constructor of this class should be private so
 * no other instances can be created or the class extended. <br>
 * Implementations should contain the values of the card implementations and other special
 * cards, such as card back images, jokers or place holders (symbols) used within the
 * specific card implementation defined as CardEnum enumeration constants. <br><br>
 * <b>Changes:</b>
 * <ul>
 * <li> 2004-08-19 - Initial release.
 * </ul>
 * @see Card
 * @see CardHand
 * @see CardDeck
 * @author Michael G. Slack
 * @author slack@attglobal.net
 * @created 2004-08-19
 * @version Version 1.00 2004-08-19
*/
public interface CardEnum extends Serializable
{
    /** Constant (equaling -1) which should represent a 'no card' value. */
    public static final int JC_NO_CARD_VALUE = -1;

    // ----------------------- Public Methods -----------------------

    /** Method used to return the value of this enumeration as a int.
     * @return The value of the card enumeration instance.
    */
    public int getValue();

    /** Method used to return the value of the card enumeration instance
     * as a String.
     * @return String representation of the value of the card enumeration
     * instance.
    */
    public String toString();
}
