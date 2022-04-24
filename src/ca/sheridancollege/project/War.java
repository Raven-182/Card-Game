package ca.sheridancollege.project;

import java.util.Scanner;

public class War extends Game {
    WarGamePlayer[] players = new WarGamePlayer[2];
    GroupOfCards deck = new GroupOfCards(52);
    int score;

    public War(String name) {
        super("War Game");
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter Player 1: ");
        players[0] = new WarGamePlayer(scan.nextLine());
        players[0].setPlayerDeck(deck.getCardsForPlayer1());// draw cards for player 1
        System.out.println("Cards drawn for " + players[0].getName());

        System.out.println("Enter Player 2: ");
        players[1] = new WarGamePlayer(scan.nextLine());
        players[1].setPlayerDeck(deck.getCardsForPlayer2());// draw cards for player 2
        System.out.println("Cards drawn " + players[1].getName());

    }

    /**
     * A method that gets player name
     * 
     * @param playerNumber
     * @return
     */
    public String getPlayer(int playerNumber) {

        switch (playerNumber) {
            case 1:
                return players[0].getName();
            case 2:
                return players[1].getName();
            default:
                return "Enter valid Player number, you entered:" + playerNumber;

        }

    }
    // declares the game winner

    @Override
    public void declareWinner() {
        if (players[0].getPlayerDeck().size() < players[1].getPlayerDeck().size()) {
            System.out.println("Player 2 wins the game!");
        } else if (players[0].getPlayerDeck().size() > players[1].getPlayerDeck().size()) {
            System.out.println("Player 1 wins the game!");
        } else {
            System.out.println("The game resulted in a tie!");
        }
    }

    // resolves tie and returns a string
    public String resolveTie() {

        deck.shuffle(players[0].getPlayerDeck());
        deck.shuffle(players[1].getPlayerDeck());
        return "It's a tie!";
    }

    @Override
    public void play() {
        int userEntry = 0;
        do {
            System.out.println("Enter 0 to end game, enter any other number to play the round: ");

            Scanner scan = new Scanner(System.in);
            userEntry = scan.nextInt();

            if (players[0].getPlayerDeck().isEmpty()) {
                declareWinner();
                break;
            } else if (players[1].getPlayerDeck().isEmpty()) {
                declareWinner();
                break;
            }
            PlayingCards player1card = players[0].getPlayerDeck().get(0);
            PlayingCards player2card = players[1].getPlayerDeck().get(0);

            System.out.println("Player 1 drew " + player1card);
            System.out.println("Player 2 drew " + player2card);

            if (player1card.getRank() > player2card.getRank()) {
                addToPlayer1Pile(player1card, player2card);// adds cards to player 1's pile
                System.out.println("Player 1 wins the round");
            }

            else if (player1card.getRank() < player2card.getRank()) {
                addToPlayer2Pile(player1card, player2card);// adds cards to player 2's pile
                System.out.println("Player 2 wins the round");
            }

            else if (player1card.getRank() == player2card.getRank()) {
                System.out.println(resolveTie());

            }

            System.out.println("Cards in player 1's pile " + players[0].getPlayerDeck().size());
            System.out.println("Cards in player 2's pile " + players[1].getPlayerDeck().size());
        } while (userEntry != 0);
        declareWinner();
    }

    public void addToPlayer1Pile(PlayingCards player1card, PlayingCards player2card) {
        players[0].getPlayerDeck().remove(player1card);
        players[1].getPlayerDeck().remove(player2card);
        players[0].getPlayerDeck().add(players[0].getPlayerDeck().size() - 1, player2card);
        players[0].getPlayerDeck().add(players[0].getPlayerDeck().size() - 1, player1card);

    }

    public void addToPlayer2Pile(PlayingCards player1card, PlayingCards player2card) {
        players[1].getPlayerDeck().remove(player2card);
        players[0].getPlayerDeck().remove(player1card);
        players[1].getPlayerDeck().add(players[1].getPlayerDeck().size() - 1, player1card);
        players[1].getPlayerDeck().add(players[1].getPlayerDeck().size() - 1, player2card);
    }

}
