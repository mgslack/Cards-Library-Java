package com.slackandassociates.cards.playingcards;

import java.io.*;
import java.util.*;
import com.slackandassociates.cards.CardEnum;

/**
 * Class used to create array of playing card enumerations that will be used to
 * initialize the CardDeck instance with.  Represents a 'standard' deck of
 * pinochle cards (48 cards, 4 suits, 9 - Ace (x2)). <br>
 * NOTE: If needed, the jokers from PlayingCardDeck could be used as 'extra'
 * cards during a pinochle deck setup. <br><br>
 * <b>Changes:</b>
 * <ul>
 * <li> 2005-05-03 - Initial release.
 * </ul>
 * @author Michael G. Slack
 * @author slack@attglobal.net
 * @created 2005-05-03
 * @version Version 1.00 2005-05-03
 * @see com.slackandassociates.cards.playingcards.PlayingCardDeck
*/
public class PinochleCardDeck
    implements Serializable
{
    /** Array of PlayingCardEnum's.  Used to initialize a card deck instance with. */
    public static final CardEnum[] PCP_DECK = 
                          {PlayingCardEnum.NINE_OF_CLUBS, PlayingCardEnum.TEN_OF_CLUBS,
                           PlayingCardEnum.JACK_OF_CLUBS, PlayingCardEnum.QUEEN_OF_CLUBS,
                           PlayingCardEnum.KING_OF_CLUBS, PlayingCardEnum.ACE_OF_CLUBS,
                           PlayingCardEnum.NINE_OF_CLUBS, PlayingCardEnum.TEN_OF_CLUBS,
                           PlayingCardEnum.JACK_OF_CLUBS, PlayingCardEnum.QUEEN_OF_CLUBS,
                           PlayingCardEnum.KING_OF_CLUBS, PlayingCardEnum.ACE_OF_CLUBS,
                           PlayingCardEnum.NINE_OF_DIAMONDS, PlayingCardEnum.TEN_OF_DIAMONDS,
                           PlayingCardEnum.JACK_OF_DIAMONDS, PlayingCardEnum.QUEEN_OF_DIAMONDS,
                           PlayingCardEnum.KING_OF_DIAMONDS, PlayingCardEnum.ACE_OF_DIAMONDS,
                           PlayingCardEnum.NINE_OF_DIAMONDS, PlayingCardEnum.TEN_OF_DIAMONDS,
                           PlayingCardEnum.JACK_OF_DIAMONDS, PlayingCardEnum.QUEEN_OF_DIAMONDS,
                           PlayingCardEnum.KING_OF_DIAMONDS, PlayingCardEnum.ACE_OF_DIAMONDS,
                           PlayingCardEnum.NINE_OF_HEARTS, PlayingCardEnum.TEN_OF_HEARTS,
                           PlayingCardEnum.JACK_OF_HEARTS, PlayingCardEnum.QUEEN_OF_HEARTS,
                           PlayingCardEnum.KING_OF_HEARTS, PlayingCardEnum.ACE_OF_HEARTS,
                           PlayingCardEnum.NINE_OF_HEARTS, PlayingCardEnum.TEN_OF_HEARTS,
                           PlayingCardEnum.JACK_OF_HEARTS, PlayingCardEnum.QUEEN_OF_HEARTS,
                           PlayingCardEnum.KING_OF_HEARTS, PlayingCardEnum.ACE_OF_HEARTS,
                           PlayingCardEnum.NINE_OF_SPADES, PlayingCardEnum.TEN_OF_SPADES,
                           PlayingCardEnum.JACK_OF_SPADES, PlayingCardEnum.QUEEN_OF_SPADES,
                           PlayingCardEnum.KING_OF_SPADES, PlayingCardEnum.ACE_OF_SPADES,
                           PlayingCardEnum.NINE_OF_SPADES, PlayingCardEnum.TEN_OF_SPADES,
                           PlayingCardEnum.JACK_OF_SPADES, PlayingCardEnum.QUEEN_OF_SPADES,
                           PlayingCardEnum.KING_OF_SPADES, PlayingCardEnum.ACE_OF_SPADES};
}
