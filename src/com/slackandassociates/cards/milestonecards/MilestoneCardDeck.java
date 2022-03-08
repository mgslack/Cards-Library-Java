package com.slackandassociates.cards.milestonecards;

import java.io.*;
import java.util.*;
import com.slackandassociates.cards.CardEnum;

/**
 * Class used to create array of playing card enumerations that will be used to
 * initialize the CardDeck instance with.  Contains a set of milestone cards
 * with 106 cards in the deck.<br>
 * There are the following cards in the deck:
 * <ul>
 *  <li> 3 Out of Gas
 *  <li> 3 Flat Tire
 *  <li> 3 Accident
 *  <li> 4 Speed Limit 50
 *  <li> 5 Stop
 *  <li> 6 Gas
 *  <li> 6 Spare Tire
 *  <li> 6 Repairs
 *  <li> 6 End Speed Limit
 *  <li> 14 Roll
 *  <li> 1 Extra Tank
 *  <li> 1 Permanent Tire
 *  <li> 1 Driving Ace
 *  <li> 1 Right-of-Way
 *  <li> 4 200 Mile
 *  <li> 12 100 Mile
 *  <li> 10 75 Mile
 *  <li> 10 50 Mile
 *  <li> 10 25 Mile
 * </ul>
 * <br><br>
 * <b>Changes:</b>
 * <ul>
 * <li> 2022-02-20 - Initial release.
 * </ul>
 * @author Michael G. Slack
 * @author mike.g.slack@gmail.com
 * @created 2022-02-20
 * @version Version 1.00 2022-02-20
*/
public class MilestoneCardDeck
    implements Serializable
{
    /** Array of MilestoneCardEnum's.  Used to initialize a card deck instance with. */
    public static final CardEnum[] MC_DECK = 
    {
        MilestoneCardEnum.OUT_OF_GAS, MilestoneCardEnum.OUT_OF_GAS, MilestoneCardEnum.OUT_OF_GAS,
        MilestoneCardEnum.FLAT_TIRE, MilestoneCardEnum.FLAT_TIRE, MilestoneCardEnum.FLAT_TIRE,
        MilestoneCardEnum.ACCIDENT, MilestoneCardEnum.ACCIDENT, MilestoneCardEnum.ACCIDENT,
        MilestoneCardEnum.SPEED_LIMIT_50, MilestoneCardEnum.SPEED_LIMIT_50,
        MilestoneCardEnum.SPEED_LIMIT_50, MilestoneCardEnum.SPEED_LIMIT_50,
        MilestoneCardEnum.STOP, MilestoneCardEnum.STOP, MilestoneCardEnum.STOP,
        MilestoneCardEnum.STOP, MilestoneCardEnum.STOP,
        MilestoneCardEnum.GAS, MilestoneCardEnum.GAS, MilestoneCardEnum.GAS,
        MilestoneCardEnum.GAS, MilestoneCardEnum.GAS, MilestoneCardEnum.GAS,
        MilestoneCardEnum.SPARE_TIRE, MilestoneCardEnum.SPARE_TIRE, MilestoneCardEnum.SPARE_TIRE,
        MilestoneCardEnum.SPARE_TIRE, MilestoneCardEnum.SPARE_TIRE, MilestoneCardEnum.SPARE_TIRE,
        MilestoneCardEnum.REPAIRS, MilestoneCardEnum.REPAIRS, MilestoneCardEnum.REPAIRS,
        MilestoneCardEnum.REPAIRS, MilestoneCardEnum.REPAIRS, MilestoneCardEnum.REPAIRS,
        MilestoneCardEnum.END_SPEED_LIMIT, MilestoneCardEnum.END_SPEED_LIMIT,
        MilestoneCardEnum.END_SPEED_LIMIT, MilestoneCardEnum.END_SPEED_LIMIT,
        MilestoneCardEnum.END_SPEED_LIMIT, MilestoneCardEnum.END_SPEED_LIMIT,
        MilestoneCardEnum.ROLL, MilestoneCardEnum.ROLL, MilestoneCardEnum.ROLL,
        MilestoneCardEnum.ROLL, MilestoneCardEnum.ROLL, MilestoneCardEnum.ROLL,
        MilestoneCardEnum.ROLL, MilestoneCardEnum.ROLL, MilestoneCardEnum.ROLL,
        MilestoneCardEnum.ROLL, MilestoneCardEnum.ROLL, MilestoneCardEnum.ROLL,
        MilestoneCardEnum.ROLL, MilestoneCardEnum.ROLL,
        MilestoneCardEnum.EXTRA_TANK, MilestoneCardEnum.PERMANENT_TIRE,
        MilestoneCardEnum.DRIVING_ACE, MilestoneCardEnum.RIGHT_OF_WAY,
		MilestoneCardEnum.M200, MilestoneCardEnum.M200, MilestoneCardEnum.M200, MilestoneCardEnum.M200,
        MilestoneCardEnum.M100, MilestoneCardEnum.M100, MilestoneCardEnum.M100, MilestoneCardEnum.M100,
        MilestoneCardEnum.M100, MilestoneCardEnum.M100, MilestoneCardEnum.M100, MilestoneCardEnum.M100,
        MilestoneCardEnum.M100, MilestoneCardEnum.M100, MilestoneCardEnum.M100, MilestoneCardEnum.M100,
        MilestoneCardEnum.M75, MilestoneCardEnum.M75, MilestoneCardEnum.M75, MilestoneCardEnum.M75,
        MilestoneCardEnum.M75, MilestoneCardEnum.M75, MilestoneCardEnum.M75, MilestoneCardEnum.M75,
        MilestoneCardEnum.M75, MilestoneCardEnum.M75,
        MilestoneCardEnum.M50, MilestoneCardEnum.M50, MilestoneCardEnum.M50, MilestoneCardEnum.M50,
        MilestoneCardEnum.M50, MilestoneCardEnum.M50, MilestoneCardEnum.M50, MilestoneCardEnum.M50,
        MilestoneCardEnum.M50, MilestoneCardEnum.M50,
        MilestoneCardEnum.M25, MilestoneCardEnum.M25, MilestoneCardEnum.M25, MilestoneCardEnum.M25,
        MilestoneCardEnum.M25, MilestoneCardEnum.M25, MilestoneCardEnum.M25, MilestoneCardEnum.M25,
        MilestoneCardEnum.M25, MilestoneCardEnum.M25
    };
}
