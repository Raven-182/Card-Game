/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;

/**
 * A concrete class that represents any grouping of cards for a Game. HINT, you
 * might want to subclass this more than
 * once. The group of cards has a maximum size attribute which is flexible for
 * reuse.
 *
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 */
public class GroupOfCards {

    // The group of cards, stored in an ArrayList
    private ArrayList<PlayingCards> cards = new ArrayList<>();
    private ArrayList<PlayingCards> Player1Deck = new ArrayList<>();
    private ArrayList<PlayingCards> Player2Deck = new ArrayList<>();

    private int size = 0;// the size of the grouping

    public GroupOfCards(int size) {
        this.size = size;

        // split the deck into two after shuffling
        addCardsToPlayerDeck();

    }

    public void addCardsToPlayerDeck() {
        for (int i = 2; i <= 14; i++) {
            for (Suits suit : Suits.values()) {
                PlayingCards addCard = new PlayingCards(i, suit);
                this.cards.add(addCard);
            }
        }
        shuffle(this.cards);
        for (int i = 0; i < 26; i++) {
            PlayingCards addCard = cards.get(i);
            this.Player1Deck.add(addCard);
        }
        for (int i = 26; i < cards.size(); i++) {
            PlayingCards addCard = cards.get(i);
            this.Player2Deck.add(addCard);
        }

    }

    /**
     * A method that will get the group of cards as an ArrayList for Player 1
     *
     * @return the group of cards.
     */
    public ArrayList<PlayingCards> getCardsForPlayer1() {

        return this.Player1Deck;
    }

    /**
     * A method that returns cards as an Arraylist for player 2
     * 
     * @return
     */

    public ArrayList<PlayingCards> getCardsForPlayer2() {

        return this.Player2Deck;
    }

    public void shuffle(ArrayList<PlayingCards> cards) {
        Collections.shuffle(cards);
    }

    /**
     * @return the size of the group of cards
     */
    public int getSize() {
        return size;
    }

    /**
     * @param size the max size for the group of cards
     */
    public void setSize(int size) {
        this.size = size;
    }

}// end class
