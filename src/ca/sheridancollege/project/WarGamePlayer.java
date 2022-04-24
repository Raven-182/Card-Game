package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collection;
/**
 * This class describes a war game player
 *
 */
public class WarGamePlayer {
    static String name;

    private ArrayList<PlayingCards> playerDeck = new ArrayList<>();

    public WarGamePlayer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<PlayingCards> getPlayerDeck() {
        return playerDeck;
    }

    public void setPlayerDeck(ArrayList<PlayingCards> playerDeck) {
        this.playerDeck = playerDeck;
    }

}
