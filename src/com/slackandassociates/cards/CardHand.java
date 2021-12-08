package com.slackandassociates.cards;

import java.io.*;

/**
 * Class defines a playing card hand (player) along with the methods to
 * manipulate a card hand.  The class allows a hand to be constructed with
 * any number of cards for the hand. <br>
 * Note: if the hand is sorted, the comparison mode is best set after the
 * CardHand instance is created. <br><br>
 * <b>Changes:</b>
 * <ul>
 * <li> 2001/07/29 - Initial release.
 * <li> 2001/08/10 - Modified to use CardEnum class.
 * <li> 2001/08/12 - Change comparison mode default value.
 * <li> 2001/08/13 - Added method to compress hand (logically).  Moves all cards in
 * hand to beginning slots and puts the EMPTY_CARDs last.
 * <li> 2004-08-20 - Modified to use Card/CardEnum interfaces.
 * <li> 2014-01-02 - Fixed a long standing bug in the Replace method in that
 * non-sorted hands would lose cards during the Replace call.
 * </ul>
 * @see Card
 * @see CardEnum
 * @author Michael G. Slack
 * @author slack@attglobal.net
 * @created 2001-07-29
 * @version Version 2.01 2014-01-02
*/
public class CardHand
    implements Serializable
{
    /** Default number of cards in a hand (5) if not specified during
     * construction.
    */
    public static final int CH_DEF_NUM_CARDS = 5;

    /** Minimum number of cards that a hand can be constructed to contain. */
    public static final int CH_MIN_NUM_CARDS = 1;

    /** Empty card constant (no card in slot).  The initial cards in a
     * hand and when cards are removed from the hand are set to this
     * value.  This static allows for "easy" '==' (equality) testing of
     * card hand values.
    */
    public static final Card EMPTY_CARD = new BlankCard();

    // private references
    private Card[] cards;       // card hand
    private int maxCards = 0;   // max cards in hand
    private int numCards;       // current number of cards in hand
    private boolean handSorted; // card hand is in sorted order
    private int compMode = Card.JC_COMP_NOSUIT; // sort comparison mode

    // -------------------------- Constructors ----------------------------

    /** Constructor creates a card hand with the default number of cards
     * for the hand.  The hand is stored in sorted order.
    */
    public CardHand()
    {
        this(CH_DEF_NUM_CARDS);
    }

    /** Constructor creates a card hand with the given number of cards in
     * it.  The hand is stored in sorted order.
     * @param iNumCards An int representing the maximum size (number of cards)
     * the hand can have.  Must be 1 or greater.
    */
    public CardHand(int iNumCards)
    {
        this(iNumCards, true);
    }

    /** Constructor creates a card hand with the default number of cards.  The
     * hand may or may not be stored in sorted order.
     * @param bSorted A boolean, if true, that sets the hand to be sorted.  If
     * false, the hand is stored unsorted.
    */
    public CardHand(boolean bSorted)
    {
        this(CH_DEF_NUM_CARDS, bSorted);
    }

    /** Constructor creates a card hand with the given number of cards and will
     * set the stored sort order to the given state.
     * @param iNumCards An int representing the maximum size (number of cards)
     * the hand can have.  Must be 1 or greater.
     * @param bSorted A boolean, if true, that sets the hand to be sorted.  If
     * false, the hand is stored unsorted.
    */
    public CardHand(int iNumCards, boolean bSorted)
    {
        // set up the references needed.
        if (iNumCards < CH_MIN_NUM_CARDS)
            maxCards = CH_MIN_NUM_CARDS;
        else
            maxCards = iNumCards;

        handSorted = bSorted;
        cards = new Card[maxCards];

        // initialize the cards in hand (setup initially empty)
        removeAll();
    }

    // ------------------------- Private Methods ----------------------------

    /** Method used to sort the hand (if the hand is stored in sorted order).
     * Method is called anytime a card is added to the hand (from add or replace).
     * Sort method is a simple bubble sort.  All empty cards (an no cards) are placed
     * in the hand last.
    */
    private void sortHand()
    {
        // only need to sort the hand if have more than one card...
        if (numCards > 1) {
            for (int i = 0; i < (maxCards-1); i++) {
                for (int j = (i+1); j < maxCards; j++) {
                    CardEnum cv = cards[i].getCardValue();
                    if ((cards[i].compareTo(cards[j]) < 0) || (cv == BlankCardEnum.NO_CARD)) {
                        Card t = cards[i]; // swap
                        cards[i] = cards[j];
                        cards[j] = t;
                    }
                }
            }
        }
    }

    // -------------------------- Public Methods ----------------------------

    /** Method adds a card to the hand.  Puts the card in the first available
     * slot (position).  Will return true if the card was successfully added
     * to the hand.  If the hand is stored in sorted order, the card is added
     * in sorted order. <br>
     * Adding cards to a hand that is sorted may change the positions of the
     * other cards and empty slots in the hand.
     * @param card Card instance to add to the hand.
     * @return A boolean value indicating success or failure of the add.
    */
    public boolean add(Card card)
    {
        boolean added = false;

        if ((numCards != maxCards) && (card != null)) {
            for (int i = 0; i < maxCards; i++) {
                if (cards[i] == EMPTY_CARD) {
                    numCards++;
                    cards[i] = card;
                    if (handSorted) cards[i].setCompMode(compMode);
                    added = true;
                    break;
                }
            }
        }

        // need to sort it in?
        if ((added) && (handSorted)) {
            sortHand();
        }

        return added;
    }

    /** Method used to remove a card from the hand (clear it) and return the
     * card to the caller.  Will return the empty card if the card has already
     * been removed.  May return null if the index is out of range for the hand. <br>
     * The remove method does not change the position of any other cards left in
     * the hand, even if the hand is sorted.
     * @param idx Index of card to get and remove from the hand.  Idx is zero based.
     * @return Card removed from the hand.
    */
    public Card remove(int idx)
    {
        if ((idx < 0) || (idx >= maxCards))
            return null;
        else {
            Card ret = cards[idx];
            cards[idx] = EMPTY_CARD;
            numCards--;
            return ret;
        }
    }

    /** Method used to remove (clear) the entire card hand of all cards
     * contained within.
    */
    public void removeAll()
    {
        numCards = 0;
        for (int i = 0; i < maxCards; i++) {
            cards[i] = EMPTY_CARD;
        }
    }

    /** Method used to logically compress a hand by putting all of the cards
     * in the hands first slots (starting at index 0) and putting all of the
     * EMPTY_CARDs last.
    */
    public void compressHand()
    {
        Card[] temp = new Card[maxCards];
        int j = 0;

        // initialize temporary hand
        for (int i = 0; i < maxCards; i++) {
            temp[i] = EMPTY_CARD;
        }
        // move good cards over to temp
        for (int i = 0; i < maxCards; i++) {
            if (cards[i] != EMPTY_CARD) {
                temp[j++] = cards[i];
            }
        }
        // replace hand with good hand
        for (int i = 0; i < maxCards; i++) {
            cards[i] = temp[i];
        }
    }

    /** Method used to return the card in the index position requested.
     * Method will leave the card in the hand.
     * @param idx Index of the card to get from the hand.  Idx is zero based.
     * @return Card contained at index position idx of the hand.  Will return
     * null if idx is out of bounds.
    */
    public Card cardAt(int idx)
    {
        if ((idx < 0) || (idx >= maxCards))
            return null;
        else {
            return cards[idx];
        }
    }

    /** Method used to replace a card with another at a given index.  Returns
     * the card that was replaced to the caller.
     * @param card Card to place into the given idx spot.  Note: if the hand
     * is stored in sorted order, the final position may not be idx.
     * @param idx A int value of the index to replace the card at with another.
     * Idx is zero based.
     * @return Card replaced by the new card.  May be null if idx is out of
     * range.
    */
    public Card replace(Card card, int idx)
    {
        Card ret = remove(idx); // let remove handle idx check

        if (card == null) ret = null;

        if (ret != null) { // have a good idx then
            if (handSorted) {
                add(card); // let add handle placement
            }
            else {
                cards[idx] = card; // replace it...
				numCards++; // remove decremented card count
            }
        }

        return ret;
    }

    /** Method returns if the hand contains an equivalent card to the card
     * passed in.  Uses the default comparison mode unless the hand is stored
     * sorted, in which case, uses the comparison mode set for the hand.
     * @param card Card to use to see if the hand contains an equivalent card.
     * @return True if the hand contains an equivalent card, else false.
    */
    public boolean contains(Card card)
    {
        boolean bRet = false;

        if (card != null) {
            for (int i = 0; i < maxCards; i++) {
                if (cards[i] != EMPTY_CARD) {
                    bRet = cards[i].equals(card);
                    if (bRet) break;
                }
            }
        }

        return bRet;
    }

    /** Method to return the current number of cards contained within the hand.
     * @return A int value representing the current number of cards in the hand.
    */
    public int getCardCount()
    {
        return numCards;
    }

    /** Method used to return the first available card in the hand to the caller.
     * If no more cards are available in the hand, it will return a null.  The card
     * is removed from the hand and returned if available.
     * @return The first available card in the hand or null if none are available.
    */
    public Card getFirstAvailableCard()
    {
        Card ret = null;

        if (numCards > 0) {
            for (int i = 0; i < maxCards; i++) {
                if (cards[i] != EMPTY_CARD) {
                    ret = remove(i);
                    break;
                }
            }
        }

        return ret;
    }

    /** Method used to return the maximum number of cards the hand can contain.
     * @return An int with the maximum number of cards the hand can contain.
    */
    public int getMaximumCardCount()
    {
        return maxCards;
    }

    /** Method returns if the hand is stored sorted or not.
     * @return A boolean representing the sorted storage state of the hand.
    */
    public boolean isSorted()
    {
        return handSorted;
    }

    /** Method used to return the currently set comparison mode for the
     * class instance.  This value is only valid if the hand is stored in sorted
     * order.  In addition, this may not equal a Card.JC_COMP_xxx value because
     * the set method does not validate the comp flag value.  It is validated
     * by the cards in the hand when used.
     * @return A Card.JC_COMP_xxx constant of the current comparison mode.
    */
    public int getCompMode()
    {
        return compMode;
    }

    /** Method used to set the comparison mode (used in storing the hand if sorting
     * was requested) for the CardHand instance.
     * @param iCompModeFlag int flag specifying one of the Card.JC_COMP_xxx constants.
    */
    public void setCompMode(int iCompModeFlag)
    {
        compMode = iCompModeFlag; // let the card itself validate the comp mode...

        // set the mode on each card already in the hand...
        if (handSorted) {
            for (int i = 0; i < maxCards; i++) {
                if (cards[i] != EMPTY_CARD) {
                    cards[i].setCompMode(compMode);
                }
            }
            sortHand(); // resort hand into new mode (possibly)
        }
    }

    // ----------------------- Over-rode methods ----------------------------

    /** Method used to return the class instance as a string value.  In
     * reality, returns the names of the card values in the hand.
     * @return A String value representing the class instance.
    */
    public String toString()
    {
        StringBuffer sbRet = new StringBuffer(500);

        sbRet.append("CardHand: [");
        for (int i = 0; i < maxCards; i++) {
            sbRet.append("("+i);
            sbRet.append(") ");
            if (cards[i] != EMPTY_CARD)
                sbRet.append(cards[i].toString());
            else
                sbRet.append("Empty");
            if (i < maxCards-1) sbRet.append(", ");
        }
        sbRet.append("]");

        return sbRet.toString();
    }
}
