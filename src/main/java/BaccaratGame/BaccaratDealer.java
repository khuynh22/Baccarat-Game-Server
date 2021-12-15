package BaccaratGame;

import java.util.ArrayList;
import java.util.Random;

// implement class BaccaratDealer
public class BaccaratDealer {
    // private
    private String[] suits;
    // helper function to generateRandomDeck
    private void generateRandomDeck(int size) {
        final int numSuits = suits.length;
        final int numVals = 13;

        // loop through the deck size
        for (int i = 0; i < size; i++) {
            boolean isInDeck = true;
            Card c = null;

            while (isInDeck) {
                // create random card
                Random rand = new Random();
                String suit = suits[rand.nextInt(numSuits)];
                int v = rand.nextInt(numVals) + 1;

                c = new Card(suit, v);
                isInDeck = deck.contains(c);
            }
            this.deck.add(c);
        }
    }

    public ArrayList<Card> deck;
    // default constructor
    public BaccaratDealer() {
        deck = new ArrayList<>();
        suits = new String[] { "clubs", "diamonds", "hearts", "spades" };
    }

    // constructor with one string
    public BaccaratDealer(String[] s) {
        suits = s;
    }

    // method to generate a new Deck
    public void generateDeck() {
        generateRandomDeck(52);
    }

    // draw one card
    public Card drawOne() {
        Random rand = new Random();
        int i = rand.nextInt(this.deck.size());
        return this.deck.remove(i);
    }

    // deal hand for player/banker
    public ArrayList<Card> dealHand() {
        ArrayList<Card> hand = new ArrayList<>();
        hand.add(drawOne());
        hand.add(drawOne());
        return hand;
    }

    // shuffle a deck
    public void shuffleDeck() {
        // basically generate a new deck
        generateRandomDeck(52);
    }

    // Deck size getter
    public int deckSize() {
        // return the size of the deck
        return deck.size();
    }

    // suits getter
    public String[] getSuits() {
        return suits;
    }

    // main method
    public static void main(String[] args) {
        // generate new deck
        BaccaratDealer b = new BaccaratDealer();
        b.generateDeck();
        // display the deck
        System.out.println(b.deck);
    }
}
