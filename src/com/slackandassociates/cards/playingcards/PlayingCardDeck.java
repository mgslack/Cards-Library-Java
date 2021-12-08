package com.slackandassociates.cards.playingcards;

import java.io.*;
import java.util.*;
import com.slackandassociates.cards.CardEnum;

/**
 * Class used to create array of playing card enumerations that will be used to
 * initialize the CardDeck instance with.  Represents a 'standard' (poker/bridge)
 * deck of playing cards (52 cards, Ace - King, 4 suits). <br><br>
 * <b>Changes:</b>
 * <ul>
 * <li> 2004-08-20 - Initial release.
 * </ul>
 * @author Michael G. Slack
 * @author slack@attglobal.net
 * @created 2004-08-20
 * @version Version 1.00 2004-08-20
*/
public class PlayingCardDeck
    implements Serializable
{
    /** Array of PlayingCardEnum's.  Used to initialize a card deck instance with. */
    public static final CardEnum[] PC_DECK = 
                          {PlayingCardEnum.ACE_OF_CLUBS, PlayingCardEnum.TWO_OF_CLUBS,
                           PlayingCardEnum.THREE_OF_CLUBS, PlayingCardEnum.FOUR_OF_CLUBS,
                           PlayingCardEnum.FIVE_OF_CLUBS, PlayingCardEnum.SIX_OF_CLUBS,
                           PlayingCardEnum.SEVEN_OF_CLUBS, PlayingCardEnum.EIGHT_OF_CLUBS,
                           PlayingCardEnum.NINE_OF_CLUBS, PlayingCardEnum.TEN_OF_CLUBS,
                           PlayingCardEnum.JACK_OF_CLUBS, PlayingCardEnum.QUEEN_OF_CLUBS,
                           PlayingCardEnum.KING_OF_CLUBS,
                           PlayingCardEnum.ACE_OF_DIAMONDS, PlayingCardEnum.TWO_OF_DIAMONDS,
                           PlayingCardEnum.THREE_OF_DIAMONDS, PlayingCardEnum.FOUR_OF_DIAMONDS,
                           PlayingCardEnum.FIVE_OF_DIAMONDS, PlayingCardEnum.SIX_OF_DIAMONDS,
                           PlayingCardEnum.SEVEN_OF_DIAMONDS, PlayingCardEnum.EIGHT_OF_DIAMONDS,
                           PlayingCardEnum.NINE_OF_DIAMONDS, PlayingCardEnum.TEN_OF_DIAMONDS,
                           PlayingCardEnum.JACK_OF_DIAMONDS, PlayingCardEnum.QUEEN_OF_DIAMONDS,
                           PlayingCardEnum.KING_OF_DIAMONDS,
                           PlayingCardEnum.ACE_OF_HEARTS, PlayingCardEnum.TWO_OF_HEARTS,
                           PlayingCardEnum.THREE_OF_HEARTS, PlayingCardEnum.FOUR_OF_HEARTS,
                           PlayingCardEnum.FIVE_OF_HEARTS, PlayingCardEnum.SIX_OF_HEARTS,
                           PlayingCardEnum.SEVEN_OF_HEARTS, PlayingCardEnum.EIGHT_OF_HEARTS,
                           PlayingCardEnum.NINE_OF_HEARTS, PlayingCardEnum.TEN_OF_HEARTS,
                           PlayingCardEnum.JACK_OF_HEARTS, PlayingCardEnum.QUEEN_OF_HEARTS,
                           PlayingCardEnum.KING_OF_HEARTS,
                           PlayingCardEnum.ACE_OF_SPADES, PlayingCardEnum.TWO_OF_SPADES,
                           PlayingCardEnum.THREE_OF_SPADES, PlayingCardEnum.FOUR_OF_SPADES,
                           PlayingCardEnum.FIVE_OF_SPADES, PlayingCardEnum.SIX_OF_SPADES,
                           PlayingCardEnum.SEVEN_OF_SPADES, PlayingCardEnum.EIGHT_OF_SPADES,
                           PlayingCardEnum.NINE_OF_SPADES, PlayingCardEnum.TEN_OF_SPADES,
                           PlayingCardEnum.JACK_OF_SPADES, PlayingCardEnum.QUEEN_OF_SPADES,
                           PlayingCardEnum.KING_OF_SPADES};

    /** Extra cards to potentially add to the card deck instance.  For
     * playing cards, will just be the jokers.
    */
    public static final CardEnum[] JOKERS = {PlayingCardEnum.RED_JOKER,
                                             PlayingCardEnum.BLACK_JOKER};
}
