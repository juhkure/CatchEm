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
public class HUDTest {
    
    public HUDTest() {
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
    public void isRunningFalse(){
        Handler handler = new Handler();
        HUD hud = new HUD(handler);
        
        assertEquals(false, hud.isRunning());
    }
    
    @Test
    public void isRunningTrue(){
        Handler handler = new Handler();
        HUD hud = new HUD(handler);
        
        hud.start();
        
        assertEquals(true, hud.isRunning());
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
