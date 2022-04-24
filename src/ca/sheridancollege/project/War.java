package ca.sheridancollege.project;

import java.util.Scanner;

public class War extends Game {
    WarGamePlayer[] players = new WarGamePlayer[2];
    GroupOfCards deck = new GroupOfCards(52);
    int score;
 

    public War(String name) {
        super("War Game");
        

    }
    public GroupOfCards getDeck(){
        return this.deck;
    }
  
    /**
     * A method that gets player name
     * 
     * @param playerNumber
     * @return
     */
    public String getPlayer(WarGamePlayer[] players, int playerNumber) {

        switch (playerNumber) {
            case 1:
                return players[0].getName();
            case 2:
                return players[1].getName();
            default:
                return "Enter valid Player number, you entered:" + playerNumber;

        }

    }
    public WarGamePlayer[] getAllPlayers(){
        return players;
    }
    // declares the game winner

    @Override
    public String declareWinner(int player1size, int player2size) {
        if (player1size < player2size) {
            return "Player 2 wins the game!";
        } else if (player1size > player2size) {
           return ("Player 1 wins the game!");
        } else {
            return("The game resulted in a tie!");
        }
    }

    // resolves tie and returns a string
    public  String resolveTie(WarGamePlayer[] players) {

        deck.shuffle(players[0].getPlayerDeck());
        deck.shuffle(players[1].getPlayerDeck());
        return "It's a tie!";
    }

    @Override
    public void play() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter Player 1: ");
        players[0] = new WarGamePlayer(scan.nextLine());
        players[0].setPlayerDeck(deck.getCardsForPlayer1());// draw cards for player 1
        System.out.println("Cards drawn for " + players[0].getName());

        System.out.println("Enter Player 2: ");
        players[1] = new WarGamePlayer(scan.nextLine());
        players[1].setPlayerDeck(deck.getCardsForPlayer2());// draw cards for player 2
        System.out.println("Cards drawn " + players[1].getName());
        int userEntry = 0;
        do {
            System.out.println("Enter 0 to end game, enter any other number to play the round: ");

      
            userEntry = scan.nextInt();

            if (players[0].getPlayerDeck().isEmpty()) {
                  System.out.println(declareWinner(players[0].getPlayerDeck().size(),players[1].getPlayerDeck().size()));
                break;
            } else if (players[1].getPlayerDeck().isEmpty()) {
                  System.out.println(declareWinner(players[0].getPlayerDeck().size(),players[1].getPlayerDeck().size()));
                break;
            }
            PlayingCards player1card = players[0].getPlayerDeck().get(0);
            PlayingCards player2card = players[1].getPlayerDeck().get(0);

            System.out.println("Player 1 drew " + player1card);
            System.out.println("Player 2 drew " + player2card);

            if (player1card.getRank() > player2card.getRank()) {
                addToPlayer1Pile(this.players, player1card, player2card);// adds cards to player 1's pile
                System.out.println("Player 1 wins the round");
            }

            else if (player1card.getRank() < player2card.getRank()) {
                addToPlayer2Pile(this.players, player1card, player2card);// adds cards to player 2's pile
                System.out.println("Player 2 wins the round");
            }

            else if (player1card.getRank() == player2card.getRank()) {
                System.out.println(resolveTie(this.players));

            }

            System.out.println("Cards in player 1's pile " + players[0].getPlayerDeck().size());
            System.out.println("Cards in player 2's pile " + players[1].getPlayerDeck().size());
        } while (userEntry != 0);
        System.out.println(declareWinner(players[0].getPlayerDeck().size(),players[1].getPlayerDeck().size()));
    }

    public void addToPlayer1Pile(WarGamePlayer[] players, PlayingCards player1card, PlayingCards player2card) {
        players[0].getPlayerDeck().remove(player1card);
        players[1].getPlayerDeck().remove(player2card);
        players[0].getPlayerDeck().add(players[0].getPlayerDeck().size() - 1, player2card);
        players[0].getPlayerDeck().add(players[0].getPlayerDeck().size() - 1, player1card);

    }

    public void addToPlayer2Pile(WarGamePlayer[] players, PlayingCards player1card, PlayingCards player2card) {
        players[1].getPlayerDeck().remove(player2card);
        players[0].getPlayerDeck().remove(player1card);
        players[1].getPlayerDeck().add(players[1].getPlayerDeck().size() - 1, player1card);
        players[1].getPlayerDeck().add(players[1].getPlayerDeck().size() - 1, player2card);
    }
    
    

}
