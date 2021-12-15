package BaccaratGame;

import java.util.ArrayList;

public class BaccaratGame {
    // private members
    private ArrayList<Card> playerHand;
    private ArrayList<Card> bankerHand;
    private BaccaratDealer theDealer;
    private double currentBet;
    private double totalWinnings;
    private String hand;

    // private helper to get the image name
    private String getImageFormatName(Card c) {
        return c.getValue() + "" + c.getSuite().substring(0, 1).toUpperCase();
    }

    // constructor
    public BaccaratGame(double currBet, String h) {
        theDealer = new BaccaratDealer();
        theDealer.generateDeck();
        playerHand = theDealer.dealHand();
        bankerHand = theDealer.dealHand();
        currentBet = currBet;
        hand = h;
    }

    // change the care to string style and return the array list of string
    public ArrayList<String> changeCardToStr(ArrayList<Card> cards) {
        ArrayList<String> stringCard = new ArrayList<>();
        for (Card c : cards) {
            stringCard.add(getImageFormatName(c));
        }
        return stringCard;
    }

    // determine if the user won or lost their bet and return the amount won or
    // lost based on the value in currentBet
    public double evaluateWinnings() {
        String winner = BaccaratGameLogic.whoWon(bankerHand, playerHand);
        if (winner.equals(hand)) {
            // if the banker won, charge 5% more
            if (hand.equals("Banker")) {
                return (currentBet * (1 - 0.05));
            }
            return currentBet;
        } else if (winner.equals("Draw")) {
            return 0.0; // double value
        }
        return (-1 * currentBet);
    }

    // getters beloew
    public ArrayList<Card> getPlayerHand() {
        return playerHand;
    }

    public ArrayList<Card> getBankerHand() {
        return bankerHand;
    }

    public BaccaratDealer getTheDealer() {
        return theDealer;
    }

    public double getCurrentBet() {
        return currentBet;
    }

    public double getTotalWinnings() {
        return totalWinnings;
    }

    public String getHand() {
        return hand;
    }
}