/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import org.junit.Assert;
import static org.junit.Assert.assertTrue;
import org.junit.Test;


/**
 *
 * @author raven
 */
public class WarTest {
    
/**
 * This tests if the players are added correctly
 */
   @Test 
   public void goodTestGetPlayer() {
        War instance = new War("war");
        WarGamePlayer[] players = new WarGamePlayer[2];
        
        players[0] = new WarGamePlayer("p1");    
        
        assertTrue("p1".equals(instance.getPlayer(players, 1)));
       
   }
   /**
 * This tests if the players are added correctly
 */
   
   @Test 
   public void boundaryTestGetPlayer() {
        War instance = new War("war");
        WarGamePlayer[] players = new WarGamePlayer[2];
        
        players[0] = new WarGamePlayer("p1"); 
        players[1] = new WarGamePlayer("p2"); 
        
        assertTrue("p2".equals(instance.getPlayer(players, 2)));
       
   }
   /**
 * This tests if the players are added correctly
 */
   
   @Test 
   public void badTestGetPlayer() {
        War instance = new War("war");
        WarGamePlayer[] players = new WarGamePlayer[2];
        
        players[0] = new WarGamePlayer("p1"); 
        players[1] = new WarGamePlayer("p2"); 
        
        assertTrue("Enter valid Player number, you entered:10".equals(instance.getPlayer(players, 10)));
       
   }
/**
 * Tests if the winner is declared correctly
 */
   @Test
   public void goodTestDeclareWinner(){
        War instance =new War("War");     
      assertTrue("Player 2 wins the game!".equals(instance.declareWinner(23, 27)));
           
   }
   /**
 * Tests if the winner is declared correctly
 */
    @Test
   public void badTestDeclareWinner(){
        War instance =new War("War");     
      assertTrue("The game resulted in a tie!".equals(instance.declareWinner(23, 23)));
           
   }
   /**
 * Tests if the winner is declared correctly
 */
   @Test
   public void boundaryTestDeclareWinner(){
        War instance =new War("War");     
      assertTrue("Player 1 wins the game!".equals(instance.declareWinner(24, 23)));
           
   }
   
   /**
    * Test of resolveTie method, of class War.
    * has no boundary cases
    */
   @Test
   public void testResolveTie(){
           War instance =new War("War"); 
                WarGamePlayer[] players = new WarGamePlayer[2];
        players[0] = new WarGamePlayer("p1");    
        players[1] = new WarGamePlayer("p2");
        assertTrue("It's a tie!".equals(instance.resolveTie(players)));
           
   }
   
   
    /**
     * Test of addToPlayer1Pile method, of class War.
     */
    @Test
    public void goodTestAddToPlayer1Pile() {
        System.out.println("addToPlayer1Pile");
        PlayingCards player1card = new PlayingCards(5, Suits.SPADES);
        PlayingCards player2card = new PlayingCards(3, Suits.HEARTS);
        
        War instance = new War("war");
        WarGamePlayer[] players = new WarGamePlayer[2];
        
        players[0] = new WarGamePlayer("p1");    
        players[1] = new WarGamePlayer("p2");
        
        players[0].setPlayerDeck(instance.getDeck().getCardsForPlayer1());
        players[1].setPlayerDeck(instance.getDeck().getCardsForPlayer2());
        
        instance.addToPlayer1Pile(players, player1card, player2card);//checks the method
        
        PlayingCards firstCard = players[0].getPlayerDeck().get(players[0].getPlayerDeck().size() - 2);
        PlayingCards secondCard = players[0].getPlayerDeck().get(players[0].getPlayerDeck().size() - 3);
        
        String expected = player1card.getRank() + player1card.getSuit().toString() + "--" + player2card.getRank() + player2card.getSuit().toString();
        String result = firstCard.getRank() + firstCard.getSuit().toString() + "--" + secondCard.getRank() + secondCard.getSuit().toString();
        assertTrue(expected.equals(result));
    }
    /**
     * Test of addToPlayer1Pile method, of class War
     */
      public void badTestAddToPlayer1Pile() {
           System.out.println("addToPlayer1Pile");
        PlayingCards player1card = new PlayingCards(7, Suits.CLUBS);
        PlayingCards player2card = new PlayingCards(3, Suits.HEARTS);
        
        War instance = new War("war");
        WarGamePlayer[] players = new WarGamePlayer[2];
        
        players[0] = new WarGamePlayer("p1");    
        players[1] = new WarGamePlayer("p2");
        
        players[0].setPlayerDeck(instance.getDeck().getCardsForPlayer1());
        players[1].setPlayerDeck(instance.getDeck().getCardsForPlayer2());
        
        instance.addToPlayer1Pile(players, player1card, player2card);//checks the method
        
        PlayingCards firstCard = players[0].getPlayerDeck().get(players[0].getPlayerDeck().size() - 2);
        PlayingCards secondCard = players[0].getPlayerDeck().get(players[0].getPlayerDeck().size() - 3);
        
        String expected = player1card.getRank() + player1card.getSuit().toString() + "--" + player2card.getRank() + player2card.getSuit().toString();
        String result = firstCard.getRank() + firstCard.getSuit().toString() + "--" + secondCard.getRank() + secondCard.getSuit().toString();
        assertTrue(expected.equals(result));
      }
    
}
