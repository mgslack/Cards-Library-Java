package com.slackandassociates.cards;

import java.io.*;
import java.util.*;
import java.lang.reflect.*;

/**
 * Collection-like class that defines a playing card deck class along with
 * several methods and constants.  Defines methods to set and get cards (of
 * the Card class) from the deck along with other support methods. <br>
 * The CardDeck class supports multi-deck games (up to seven decks) so that 
 * games such as blackjack (or 21) can be programmed. <br><br>
 * <b>Changes:</b>
 * <ul>
 * <li> 2001/07/21 - Initial release.
 * <li> 2001/08/10 - Modified to use the CardEnum class.
 * <li> 2001/10/10 - Modified the iterator method to return an inner-class iterator.
 * <li> 2001/10/11 - Whoops!  Forgot to remove protected classes used by external
 * iterator class now no longer needed.
 * <li> 2004-08-20 - Updated for new card library architecture (v2.00).
 * <li> 2005-01-05 - Fixed a minor issue with extra cards in constructor (forgot to
 * include length in creating card array).
 * <li> 2012-08-08 - Added in a serial version UID per Findbugs hint.
 * </ul>
 * @author Michael G. Slack
 * @author slack@attglobal.net
 * @created 2001-07-21
 * @version Version 2.02 2012-08-08
*/
public class CardDeck
    implements Serializable
{
    static final long serialVersionUID = 3016065368199845369L;

    // public constants
    /** Number of card decks. */
    public static final int JC_ONE_DECK = 1;
    /** Number of card decks. */
    public static final int JC_TWO_DECK = 2;
    /** Number of card decks. */
    public static final int JC_THREE_DECK = 3;
    /** Number of card decks. */
    public static final int JC_FOUR_DECK = 4;
    /** Number of card decks. */
    public static final int JC_FIVE_DECK = 5;
    /** Number of card decks. */
    public static final int JC_SIX_DECK = 6;
    /** Number of card decks. */
    public static final int JC_SEVEN_DECK = 7;

    // private references
    private int nextCard;
    private int lastCard;
    private int numDecks;
    private CardEnum[] cards;
    private boolean shuffled;
    private Class cardCls;
    private transient Constructor cardCons = null;

    // ------------------- Constructors ----------------------------------------

    /**
     * Constructor to create a card deck.  Initializes the cards in
     * the deck, but does not shuffle.  Will setup card deck with one deck of
     * cards initialized by the passed in deck array.
     * @param deck CardEnum array containing the set of cards that will be
     * used by the card deck instance.
     * @param cardImpl Class instance of the card implementation that will
     * be used to create cards retrieved from the card deck instance.
    */
    public CardDeck(CardEnum[] deck, Class cardImpl)
    {
        this(JC_ONE_DECK, deck, cardImpl);
    }

    /**
     * Constructor to create a card deck.  Initializes the cards in
     * the deck(s), but does not shuffle.  Will create a set of cards containing
     * up to 7 decks.  If an invalid number of decks is specified, 1 deck is used.
     * @param iNumDecks A value from 1 to 7 (JC_ONE_DECK to JC_SEVEN_DECK).
     * @param deck CardEnum array containing the set of cards that will be
     * used by the card deck instance.
     * @param cardImpl Class instance of the card implementation that will
     * be used to create cards retrieved from the card deck instance.
    */
    public CardDeck(int iNumDecks, CardEnum[] deck, Class cardImpl)
    {
        this(iNumDecks, deck, cardImpl, null);
    }

    /**
     * Constructor to create a card deck.  Initializes the cards in
     * the deck(s), but does not shuffle.  Will create a set of cards containing
     * up to 7 decks.  If an invalid number of decks is specified, 1 deck is used.
     * @param iNumDecks A value from 1 to 7 (JC_ONE_DECK to JC_SEVEN_DECK).
     * @param deck CardEnum array containing the set of cards that will be
     * used by the card deck instance.
     * @param cardImpl Class instance of the card implementation that will
     * be used to create cards retrieved from the card deck instance.
     * @param extraCards CardEnum array containing extra cards to add to the
     * card deck after the deck is initialized.  Will only be added to the deck
     * once.  Parameter can be null (no additional cards).
    */
    public CardDeck(int iNumDecks, CardEnum[] deck, Class cardImpl, CardEnum[] extraCards)
    {
        int ii = 0;

        cardCls = cardImpl;

        // number of decks ok?
        numDecks = iNumDecks;

        if ((numDecks < JC_ONE_DECK) || (numDecks > JC_SEVEN_DECK)) {
            numDecks = JC_ONE_DECK;
        }

        lastCard = (deck.length * numDecks);
        if (extraCards != null)
            lastCard += extraCards.length;

        // set other values needed (new deck(s))
        nextCard = 0;
        shuffled = false;
        cards = new CardEnum[lastCard];
        for (int i = 0; i < numDecks; i++) {
            for (int j = 0; j < deck.length; j++) {
                cards[ii++] = deck[j]; // put enum values in deck/repeat as necessary
            }
        }
        // extra cards? - if so, add once after all decks...
        if (extraCards != null) {
            for (int i = 0; i < extraCards.length; i++)
                cards[ii++] = extraCards[i];
        }
    }

    // ---------------------------- Private Methods ---------------------------

    private Card createNewCard(CardEnum ce)
    {
        try {
            // reflect to get constructor
            if (cardCons == null) {
                Class[] cPs = new Class[1];
                cPs[0] = CardEnum.class;
                cardCons = cardCls.getConstructor(cPs);
            }

            Object[] prms = new Object[1];
            prms[0] = ce;

            return (Card) cardCons.newInstance(prms);
        }
        catch (NoSuchMethodException nsme) {
            System.err.println("CardDeck: not a valid card class (missing constructor(CardEnum)).  " + nsme);
            return new BlankCard();
        }
        catch (InstantiationException ie) {
            System.err.println("CardDeck: could not create card requested.  " + ie);
            return new BlankCard();
        }
        catch (IllegalAccessException iae) {
            System.err.println("CardDeck: do not have permission to create new card.  " + iae);
            return new BlankCard();
        }
        catch (InvocationTargetException ite) {
            System.err.println("CardDeck: could not create new card.  " + ite);
            return new BlankCard();
        }
    }

    // ---------------------------- Public Methods ----------------------------

    /**
     * Method used to shuffle the deck of cards.  Resets the next card method
     * to pull from the top of the deck.
    */
    public void shuffle()
    {
        nextCard = 0;
        shuffled = true;

        // psuedo shuffle
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < lastCard; j++) {
                int p = (int) Math.floor(Math.random() * lastCard);
                // swap card at j with card at p
                CardEnum c = cards[j];
                cards[j] = cards[p];
                cards[p] = c;
            }
        }
    }

    /**
     * Method used to get if the CardDeck has been shuffled or not.
     * @return A boolean indicating the CardDeck's shuffled status.
    */
    public boolean isShuffled()
    {
        return shuffled;
    }

    /**
     * Method used to get the next available card from the deck of cards.
     * Allows for leaving the card in the deck (and still available as
     * the next card).
     * @param bLeaveInDeck A boolean value indicating to leave the card on the deck or not.
     * @return A Card instance if a card is available, else a null if not.
    */
    public Card getNextCard(boolean bLeaveInDeck)
    {
        if (hasMoreCards()) {
            CardEnum ceV = cards[nextCard];  // get value of card from deck

            if (!bLeaveInDeck) nextCard++;

            return createNewCard(ceV);
        }
        else {
            return null;
        }
    }

    /**
     * Method used to get the next available card from the deck of cards.
     * Method will remove the card from the deck.
     * @return A Card instance if a card is available, else a null if not.
    */
    public Card getNextCard()
    {
        return getNextCard(false);
    }

    /**
     * Method used to return if the card deck has more cards or not.
     * @return A boolean (true) if more cards available, else false.
    */
    public boolean hasMoreCards()
    {
        return nextCard < lastCard;
    }

    /**
     * Method used to return the number of decks used in this 'deck' of
     * cards (could be more than one).
     * @return A int with one of the JC_xxx_DECK values.
    */
    public int getNumberOfDecks()
    {
        return numDecks;
    }

    /**
     * Method returns an iterator to the current card deck (which may be
     * unshuffled!).  The iterator will always start with the first card
     * (even if some of the cards have been played)
     * @return An Iterator to use to 'walk' through the current CardDeck
     * (in it's current state).  The iterators 'next' method returns Card
     * instances.
    */
    public Iterator iterator()
    {
        // create an anonymous iterator to pass back to the caller
        return new Iterator() {
                       // private references
                       private int currentCard = 0;

                       /** Method used to return if there are more values in the
                        * iterator or not.
                        * @return A boolean indication more (true) or no more (false).
                       */
                       public boolean hasNext()
                       {
                           return (currentCard < lastCard);
                       }

                       /** Method returns the next Card in the CardDeck (if any are
                        * left).  Will throw an NoSuchElementException if no more
                        * cards are available.
                        * @return A Card instance with the next card in the deck.
                        * @throws NoSuchElementException if no more cards are available.
                       */
                       public Object next()
                       {
                           if (hasNext()) {
                               return createNewCard(cards[currentCard++]);
                           }
                           else {
                               throw new NoSuchElementException("No more cards in deck.");
                           }
                       }

                       /** Method is not implemented in this iterator (makes no sense
                        * for a deck of cards!!! - will always have all cards).
                        * @throws UnsupportedOperationException always.
                       */
                       public void remove()
                       {
                           throw new UnsupportedOperationException();
                       }
                   };
    }

    /**
     * Method used to return the class instance as a string value (for
     * printing, etc.).
     * @return A String value representing the class instance.
    */
    public String toString()
    {
        return "CardDeck: (Decks-" + numDecks + ", Number of Cards-" + lastCard + 
                ", CurrentCard-" + nextCard + ")";
    }
}
