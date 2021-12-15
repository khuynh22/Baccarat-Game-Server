package BaccaratGame;

import java.util.ArrayList;

public class BaccaratGameLogic {
    // evaluate two hands at the end of the game and return a string
    // depending on the winner: “Player”, “Banker”, “Draw”
    public static String whoWon(ArrayList<Card> hand1, ArrayList<Card> hand2) {
        // initiate variables
        int bankerHand = handTotal(hand1);
        int playerHand = handTotal(hand2);
        int bankerDiff = 9 - bankerHand;
        int playerDiff = 9 - playerHand;

        // smaller the diff, higher the score
        if (playerDiff < bankerDiff) {
            return "Player";
        } else if (bankerDiff < playerDiff) {
            return "Banker";
        }
        return "Draw"; // draw case
    }

    //take a hand and return how many points that hand is worth
    public static int handTotal(ArrayList<Card> hand) {
        int value = 0;
        for (Card c : hand) {
            value += c.getValue();
        }

        // handle lesser than 10 cases
        if (value < 10) {
            return value;
        }
        return value % 10; // larger than 10 cases
    }

    // return true if either one should be dealt a third card, otherwise return false
    public static boolean evaluateBankerDraw(ArrayList<Card> hand, Card playerCard) {
        int bankerTotal = handTotal(hand);
        if (bankerTotal == 0 && playerCard != null)
            return true;
        return false;
    }

    // return true if either one should be dealt a third card, otherwise return false
    public static boolean evaluatePlayerDraw(ArrayList<Card> hand) {
        int playerTotal = handTotal(hand);
        return playerTotal <= 5;
    }
}
