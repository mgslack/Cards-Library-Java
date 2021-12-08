package com.slackandassociates.cards;

/**
 * Exception class used to indicate that a card enumeration exception
 * happened when setting a CardEnum value into a Card instance.  This
 * exception is thrown when an invalid CardEnum type is passed into the
 * setCardValue method. <br><br>
 * <b>Changes:</b>
 * <ul>
 * <li> 2004-08-26 - Initial release.
 * </ul>
 * @author Michael G. Slack
 * @author slack@attglobal.net
 * @created 2004-08-26
 * @version Version 1.00 2004-08-26
*/
public class CardInvalidEnumException extends CardException
{
    /** Default constructor. */
    public CardInvalidEnumException()
    {
        this("Invalid CardEnum instance.");
    }

    /** Constructor with message passed in.
     * @param msg String containing user message for exception.
    */
    public CardInvalidEnumException(String msg)
    {
        super(msg);
    }
}
