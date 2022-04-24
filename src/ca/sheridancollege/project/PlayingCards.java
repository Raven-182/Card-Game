package ca.sheridancollege.project;
/**
 * 
 * This class describes the typical 52-card playing cards
 */
public class PlayingCards extends Card {
    int rank;
    Suits suit;

    public PlayingCards(int rank, Suits suit) {
        this.rank = rank;
        this.suit = suit;

    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public Suits getSuit() {
        return suit;
    }

    public void setSuit(Suits suit) {
        this.suit = suit;
    }
//Returns a string representation of a card
    @Override
    public String toString() {
        String faceCard = "";
        switch (this.rank) {
            case 11:
                faceCard = "Jack";

                return faceCard + " of " + suit.toString();
            case 12:
                faceCard = "Queen";

                return faceCard + " of " + suit.toString();
            case 13:
                faceCard = "King";

                return faceCard + " of " + suit.toString();
            case 14:
                faceCard = "Ace";

                return faceCard + " of " + suit.toString();

            default:
                return this.rank + " of " + suit.toString();
        }

    }

}
