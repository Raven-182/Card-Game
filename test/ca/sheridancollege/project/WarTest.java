/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package ca.sheridancollege.project;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author raven
 */
public class WarTest {
    
    public WarTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getPlayer method, of class War.
     */
    @Test
    public void testGetPlayer() {
        System.out.println("getPlayer");
        int playerNumber = 0;
        War instance = null;
        String expResult = "";
        String result = instance.getPlayer(playerNumber);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of declareWinner method, of class War.
     */
    @Test
    public void testDeclareWinner() {
        System.out.println("declareWinner");
        War instance = null;
        instance.declareWinner();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of resolveTie method, of class War.
     */
    @Test
    public void testResolveTie() {
        System.out.println("resolveTie");
        War instance = null;
        String expResult = "";
        String result = instance.resolveTie();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of play method, of class War.
     */
    @Test
    public void testPlay() {
        System.out.println("play");
        War instance = null;
        instance.play();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addToPlayer1Pile method, of class War.
     */
    @Test
    public void testAddToPlayer1Pile() {
        System.out.println("addToPlayer1Pile");
        PlayingCards player1card = null;
        PlayingCards player2card = null;
        War instance = null;
        instance.addToPlayer1Pile(player1card, player2card);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addToPlayer2Pile method, of class War.
     */
    @Test
    public void testAddToPlayer2Pile() {
        System.out.println("addToPlayer2Pile");
        PlayingCards player1card = null;
        PlayingCards player2card = null;
        War instance = null;
        instance.addToPlayer2Pile(player1card, player2card);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
