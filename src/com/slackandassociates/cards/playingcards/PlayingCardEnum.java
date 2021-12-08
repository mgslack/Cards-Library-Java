package com.slackandassociates.cards.playingcards;

import java.io.*;
import com.slackandassociates.cards.*;

/**
 * Class defines the card value enumerations to be used by the PlayingCard, CardHand
 * and CardDeck classes.  The values enumerated by the class are playing card
 * (standard 52 card deck) values. <br>
 * This class also contains values for special cards, such as card back images,
 * jokers or place holders (symbols).  New specials need to be added here in
 * order to use within the playing cards. <br><br>
 * <b>Changes:</b>
 * <ul>
 * <li> 2001/08/09 - Initial release.
 * <li> 2004-08-19 - Modified to use the CardEnum interface.
 * <li> 2005-05-04 - Added additional card back and card symbol (blank card).
 * <li> 2007-10-14 - Added additional card back.
 * </ul>
 * @author Michael G. Slack
 * @author slack@attglobal.net
 * @created 2001-08-09
 * @version Version 2.02 2007-10-14
*/
public class PlayingCardEnum implements CardEnum
{
    // public constants
    // The following numbers assigned to the card as the value of
    // the card enumeration match up to the name of the image file
    // representing the card.  For example, ACE_OF_CLUBS's image
    // file is named '1.gif'.  The numbers also match up to what
    // the cards native value is.  These numbers should not be
    // changed.
    /** Card value - ace of clubs */
    public static final CardEnum ACE_OF_CLUBS = new PlayingCardEnum(1);
    /** Card value - two of clubs */
    public static final CardEnum TWO_OF_CLUBS = new PlayingCardEnum(2);
    /** Card value - three of clubs */
    public static final CardEnum THREE_OF_CLUBS = new PlayingCardEnum(3);
    /** Card value - four of clubs */
    public static final CardEnum FOUR_OF_CLUBS = new PlayingCardEnum(4);
    /** Card value - five of clubs */
    public static final CardEnum FIVE_OF_CLUBS = new PlayingCardEnum(5);
    /** Card value - six of clubs */
    public static final CardEnum SIX_OF_CLUBS = new PlayingCardEnum(6);
    /** Card value - seven of clubs */
    public static final CardEnum SEVEN_OF_CLUBS = new PlayingCardEnum(7);
    /** Card value - eight of clubs */
    public static final CardEnum EIGHT_OF_CLUBS = new PlayingCardEnum(8);
    /** Card value - nine of clubs */
    public static final CardEnum NINE_OF_CLUBS = new PlayingCardEnum(9);
    /** Card value - ten of clubs */
    public static final CardEnum TEN_OF_CLUBS = new PlayingCardEnum(10);
    /** Card value - jack of clubs */
    public static final CardEnum JACK_OF_CLUBS = new PlayingCardEnum(11);
    /** Card value - queen of clubs */
    public static final CardEnum QUEEN_OF_CLUBS = new PlayingCardEnum(12);
    /** Card value - king of clubs */
    public static final CardEnum KING_OF_CLUBS = new PlayingCardEnum(13);
    /** Card value - ace of diamonds */
    public static final CardEnum ACE_OF_DIAMONDS = new PlayingCardEnum(14);
    /** Card value - two of diamonds */
    public static final CardEnum TWO_OF_DIAMONDS = new PlayingCardEnum(15);
    /** Card value - three of diamonds */
    public static final CardEnum THREE_OF_DIAMONDS = new PlayingCardEnum(16);
    /** Card value - four of diamonds */
    public static final CardEnum FOUR_OF_DIAMONDS = new PlayingCardEnum(17);
    /** Card value - five of diamonds */
    public static final CardEnum FIVE_OF_DIAMONDS = new PlayingCardEnum(18);
    /** Card value - six of diamonds */
    public static final CardEnum SIX_OF_DIAMONDS = new PlayingCardEnum(19);
    /** Card value - seven of diamonds */
    public static final CardEnum SEVEN_OF_DIAMONDS = new PlayingCardEnum(20);
    /** Card value - eight of diamonds */
    public static final CardEnum EIGHT_OF_DIAMONDS = new PlayingCardEnum(21);
    /** Card value - nine of diamonds */
    public static final CardEnum NINE_OF_DIAMONDS = new PlayingCardEnum(22);
    /** Card value - ten of diamonds */
    public static final CardEnum TEN_OF_DIAMONDS = new PlayingCardEnum(23);
    /** Card value - jack of diamonds */
    public static final CardEnum JACK_OF_DIAMONDS = new PlayingCardEnum(24);
    /** Card value - queen of diamonds */
    public static final CardEnum QUEEN_OF_DIAMONDS = new PlayingCardEnum(25);
    /** Card value - king of diamonds */
    public static final CardEnum KING_OF_DIAMONDS = new PlayingCardEnum(26);
    /** Card value - ace of hearts */
    public static final CardEnum ACE_OF_HEARTS = new PlayingCardEnum(27);
    /** Card value - two of hearts */
    public static final CardEnum TWO_OF_HEARTS = new PlayingCardEnum(28);
    /** Card value - three of hearts */
    public static final CardEnum THREE_OF_HEARTS = new PlayingCardEnum(29);
    /** Card value - four of hearts */
    public static final CardEnum FOUR_OF_HEARTS = new PlayingCardEnum(30);
    /** Card value - five of hearts */
    public static final CardEnum FIVE_OF_HEARTS = new PlayingCardEnum(31);
    /** Card value - six of hearts */
    public static final CardEnum SIX_OF_HEARTS = new PlayingCardEnum(32);
    /** Card value - seven of hearts */
    public static final CardEnum SEVEN_OF_HEARTS = new PlayingCardEnum(33);
    /** Card value - eight of hearts */
    public static final CardEnum EIGHT_OF_HEARTS = new PlayingCardEnum(34);
    /** Card value - nine of hearts */
    public static final CardEnum NINE_OF_HEARTS = new PlayingCardEnum(35);
    /** Card value - ten of hearts */
    public static final CardEnum TEN_OF_HEARTS = new PlayingCardEnum(36);
    /** Card value - jack of hearts */
    public static final CardEnum JACK_OF_HEARTS = new PlayingCardEnum(37);
    /** Card value - queen of hearts */
    public static final CardEnum QUEEN_OF_HEARTS = new PlayingCardEnum(38);
    /** Card value - king of hearts */
    public static final CardEnum KING_OF_HEARTS = new PlayingCardEnum(39);
    /** Card value - ace of spades */
    public static final CardEnum ACE_OF_SPADES = new PlayingCardEnum(40);
    /** Card value - two of spades */
    public static final CardEnum TWO_OF_SPADES = new PlayingCardEnum(41);
    /** Card value - three of spades */
    public static final CardEnum THREE_OF_SPADES = new PlayingCardEnum(42);
    /** Card value - four of spades */
    public static final CardEnum FOUR_OF_SPADES = new PlayingCardEnum(43);
    /** Card value - five of spades */
    public static final CardEnum FIVE_OF_SPADES = new PlayingCardEnum(44);
    /** Card value - six of spades */
    public static final CardEnum SIX_OF_SPADES = new PlayingCardEnum(45);
    /** Card value - seven of spades */
    public static final CardEnum SEVEN_OF_SPADES = new PlayingCardEnum(46);
    /** Card value - eight of spades */
    public static final CardEnum EIGHT_OF_SPADES = new PlayingCardEnum(47);
    /** Card value - nine of spades */
    public static final CardEnum NINE_OF_SPADES = new PlayingCardEnum(48);
    /** Card value - ten of spades */
    public static final CardEnum TEN_OF_SPADES = new PlayingCardEnum(49);
    /** Card value - jack of spades */
    public static final CardEnum JACK_OF_SPADES = new PlayingCardEnum(50);
    /** Card value - queen of spades */
    public static final CardEnum QUEEN_OF_SPADES = new PlayingCardEnum(51);
    /** Card value - king of spades */
    public static final CardEnum KING_OF_SPADES = new PlayingCardEnum(52);

    // card image values (backs / place graphics)
    /** Card value (first card back image value). */
    public static final CardEnum JC_CARDBACK_VAL1 = new PlayingCardEnum(200);
    /** Card value (second card back image value). */
    public static final CardEnum JC_CARDBACK_VAL2 = new PlayingCardEnum(201);
    /** Card value (third card back image value). */
    public static final CardEnum JC_CARDBACK_VAL3 = new PlayingCardEnum(202);
    /** Card value (forth card back image value). */
    public static final CardEnum JC_CARDBACK_VAL4 = new PlayingCardEnum(203);
    /** Card value (fifth card back image value). */
    public static final CardEnum JC_CARDBACK_VAL5 = new PlayingCardEnum(204);
    /** Card value (sixth card back image value). */
    public static final CardEnum JC_CARDBACK_VAL6 = new PlayingCardEnum(205);
    /** Card value (seventh card back image value). */
    public static final CardEnum JC_CARDBACK_VAL7 = new PlayingCardEnum(206);
    /** Card value (eighth card back image value). */
    public static final CardEnum JC_CARDBACK_VAL8 = new PlayingCardEnum(207);
    /** Card value (first card placement/symbol image value). */
    public static final CardEnum JC_CARDSYMBOL_VAL1 = new PlayingCardEnum(300);
    /** Card value (second card placement/symbol image value). */
    public static final CardEnum JC_CARDSYMBOL_VAL2 = new PlayingCardEnum(301);
    /** Card value (third card placement/symbol image value). */
    public static final CardEnum JC_CARDSYMBOL_VAL3 = new PlayingCardEnum(302);
    /** Card value (forth card placement/symbol image value - blank). */
    public static final CardEnum JC_CARDSYMBOL_VAL4 = new PlayingCardEnum(303);

    // joker values
    /** Card value of the red joker. */
    public static final CardEnum RED_JOKER = new PlayingCardEnum(400);
    /** Card value of the black joker. */
    public static final CardEnum BLACK_JOKER = new PlayingCardEnum(401);

    // private value reference
    private int iValue = CardEnum.JC_NO_CARD_VALUE;

    // ---------------------- Constructor ---------------------------

    /** Constructor to create an enumeration object.  Kept private
     * because these shouldn't be created outside of this class.
     * @param iVal The int value the card enumerator stands for.  This
     * value is used by the image cache routine to return a proper image
     * to the caller with.
    */
    private PlayingCardEnum(int iVal)
    {
        iValue = iVal;
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
        String sRet = "Not a valid card/No card";

        if ((iValue >= JC_CARDBACK_VAL1.getValue()) &&
            (iValue <= JC_CARDBACK_VAL7.getValue()))
            sRet = "Card back (" + iValue + ")";
        else if ((iValue >= JC_CARDSYMBOL_VAL1.getValue()) &&
                 (iValue <= JC_CARDSYMBOL_VAL4.getValue()))
            sRet = "Card symbol/place holder (" + iValue + ")";
        else if (iValue == RED_JOKER.getValue())
            sRet = "Red Joker";
        else if (iValue == BLACK_JOKER.getValue())
            sRet = "Black Joker";
        else if (iValue != -1) { //regular playing card - get name of it...
            int iS = (iValue - 1) / 13;
            int iV = (iValue - 1) % 13;

            // what is it...
            switch (iV) {
                case 0  : sRet = "Ace of "; break;
                case 1  : sRet = "Two of "; break;
                case 2  : sRet = "Three of "; break;
                case 3  : sRet = "Four of "; break;
                case 4  : sRet = "Five of "; break;
                case 5  : sRet = "Six of "; break;
                case 6  : sRet = "Seven of "; break;
                case 7  : sRet = "Eight of "; break;
                case 8  : sRet = "Nine of "; break;
                case 9  : sRet = "Ten of "; break;
                case 10 : sRet = "Jack of "; break;
                case 11 : sRet = "Queen of "; break;
                case 12 : sRet = "King of "; break;
                default : sRet = "?"+iV+"? of "; break;
            }
            // card suit ...
            switch (iS) {
                case 0 : sRet += "Clubs"; break;
                case 1 : sRet += "Diamonds"; break;
                case 2 : sRet += "Hearts"; break;
                case 3 : sRet += "Spades"; break;
                default : sRet += "?"+iS+"?"; break;
            }
        }

        return sRet;
    }
}
