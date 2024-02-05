/*
 * ******************************************************************************
 *  This files was developed for CS4233: Object-Oriented Analysis & Design.
 *  The course was taken at Worcester Polytechnic Institute.
 *
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *
 *  * Copyright ©2016-2024 Gary F. Pollice
 *  *******************************************************************************
 *
 */
package knibble;

/**
 * This class contains static format strings to be used in creating
 * the message for the <code>KnibbleResponse</code>
 * YOU MAY NOT MODIFY THIS FILE
 */
public class ResponseMessageFormats {
    // The string is the player's name on the guess. It may be
    // a player who is already out, or a name that is not one of
    // the original players. This should be the first thing the
    // manager checks.
    public static String noPlayerMessage
        = "%s is not playing this game";

    // First string is the player in the guess, the second is
    // the player that it should have been.
    // This should be the second thing the manager checks.
    public static String wrongPlayerMessage
        = "It is not %s's turn, %s must make the guess";

    // The string is the player name and the integer is the total
    public static String exactGuessMessage
        = "%s guessed the correct total (%d) and is out";

    public static String noExactGuessMessage
        = "No one guessed the correct total";

    // The string is the player, the integer is the upper limit
    // of the guess.
    public static String invalidGuessMessage
        = "%s did not enter a guess in the range [0, %d]";

    // The first string is the player who made the correct guess
    // and the second is the player who lost.
    public static String loserMessage
        = "%s guessed correctly and %s is the loser and pays the bill";

    // The string is the (legal) player who tried to enter a guess
    // after the game is over. It must be one of the original players.
    public static String gameOverMessage
        = "%s cannot guess, the game is over";
 }
