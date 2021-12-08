package com.slackandassociates.cards;

/**
 * Exception class used to indicate that a generic exception took
 * place within the card library.  This exception class forms the
 * base of all card exceptions. <br><br>
 * <b>Changes:</b>
 * <ul>
 * <li> 2004-08-26 - Initial release.
 * </ul>
 * @author Michael G. Slack
 * @author slack@attglobal.net
 * @created 2004-08-26
 * @version Version 1.00 2004-08-26
*/
public class CardException extends Exception
{
    /** Default constructor. */
    public CardException()
    {
        super();
    }

    /** Constructor with message passed in.
     * @param msg String containing user message for exception.
    */
    public CardException(String msg)
    {
        super(msg);
    }
}
