
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

import java.util.LinkedList;
import java.util.List;
import static knibble.ResponseMessageFormats.*;
import static knibble.ResponseCode.*;
/**
 * Main class for managing Knibble games for the
 * TDD programming assignment.
 */
public class KnibbleGame
{
    protected List<String> players;
    private int coins = -1;
    private String firstPlayer;
    private boolean gameOver = false;
    private boolean inRound = false;
    /**
     * This is the only constructor for the game.
     * @param players the names of the players in the order 
     * of the first round of play and for when the holdings
     * and guesses are made.
     */
    public KnibbleGame(List<String> players)
    {
        this.players = new LinkedList<>(players);
    }

    /**
     * Start a new round
     * @param totalCoins the number of coins for the round
     */
    public void newRound(int totalCoins) {
        if(coins != -1) {
            rotatePlayers();
        }
        this.coins = totalCoins;
        this.firstPlayer = this.players.get(0);
        this.inRound = true;
    }

    //Put first player in order to the end
    private void rotatePlayers() {
        String p1 = this.players.get(0);
        this.players.remove(0);
        this.players.add(p1);
    }

    //Sequence when player makes a guess
    public KnibbleResponse makeGuess(Guess guess) {
        if (this.gameOver){
            return new KnibbleResponse(GAME_OVER, String.format(gameOverMessage, guess.playerName()));
        } else if (!this.players.contains(guess.playerName())){
            return new KnibbleResponse(NO_PLAYER, String.format(noPlayerMessage, guess.playerName()));
        } else if (!this.players.get(0).equals(guess.playerName())) {
            return new KnibbleResponse(WRONG_PLAYER, String.format(wrongPlayerMessage, guess.playerName(), this.players.get(0)));
        } else if (guess.guess() == getCoins()){
            return correctGuess(guess);
        } else if (guess.guess() > this.players.size()*3) {
            return new KnibbleResponse(INVALID_GUESS, String.format(invalidGuessMessage, guess.playerName(), this.players.size()*3));
        } else{
            return incorrectGuess(guess);
        }
    }

    //returns coins of round
    public int getCoins(){
        return this.coins;
    }

    //Sequence when a correct guess is achieved
    public KnibbleResponse correctGuess(Guess guess){
        String correct = this.players.get(0);
        this.players.remove(0);
        if(this.players.size() == 1){
            this.gameOver = true;
            return new KnibbleResponse(LOSER, String.format(loserMessage, guess.playerName(), this.players.get(0)));
        }
        else{
            this.inRound = false;
            if(!correct.equals(this.firstPlayer)){
                while(!this.firstPlayer.equals(this.players.get(0))){
                    rotatePlayers();
                }
            }
            return new KnibbleResponse(EXACT_GUESS, String.format(exactGuessMessage, guess.playerName(), guess.guess()));
        }
    }

    //Sequence for an incorrect guess
    public KnibbleResponse incorrectGuess(Guess guess){
        rotatePlayers();
        if(this.players.get(0).equals(this.firstPlayer)){
            this.inRound = false;
            return new KnibbleResponse(NO_EXACT_GUESS, String.format(noExactGuessMessage));
        }
        return null;
    }


}
