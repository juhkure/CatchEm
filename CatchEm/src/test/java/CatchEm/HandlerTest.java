/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CatchEm;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Johannes
 */
public class HandlerTest {
    public HandlerTest() {
    }
    
    
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void player1ScoreIs0atStart(){
        Handler h = new Handler();
        h.addObject(new Player(120, 120, ID.Player, h, null, null));
        
        assertEquals(0, h.player1Score());
    }
    
    @Test
    public void player2ScoreIs0atStart(){
        Handler h = new Handler();
        h.addObject(new Player(120, 120, ID.Player2, h, null, null));
        
        assertEquals(0, h.player2Score());
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
