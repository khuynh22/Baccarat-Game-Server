package BaccaratGame;

public class Card {
    // private members
    private String suite;
    private int value;

    // default constructor
    public Card() {
        suite = "";
        value = 0;
    }

    // 2 args constructor
    public Card(String theSuite, int theValue) {
        suite = theSuite;
        value = theValue;
    }

    // getters and setters
    public String getSuite() {
        return suite;
    }

    public void setSuite(String theSuite) {
        suite = theSuite;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int theValue) {
        value = theValue;
    }

    public String toString() {
        return value + " of " + suite;
    }

    // equal methods
    @Override
    public boolean equals(Object obj) {
        return (((Card) obj).getSuite().equals(suite) && ((Card) obj).getValue() == value);
    }
}
