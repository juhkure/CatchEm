/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackerointipeli;

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
public class TargetTest {

    Target t = new Target("ebin", 100);
    Target t2 = new Target("ebin", 5);

    public TargetTest() {
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
    public void healthIsZero(){
        t2.removeHealth();
        t2.removeHealth();
        t2.removeHealth();
        t2.removeHealth();
        assertEquals(true, t2.removeHealth());
    }
    
    @Test
    public void getHitpointsWorks() {
        assertEquals(100, t.getHitpoints());
    }
    
    @Test
    public void getNameWorks(){
        assertEquals("ebin", t.getName());
    }
    
    @Test
    public void toStringWorks(){
        assertEquals("Target: ebin, remaining hitpoints: 100" , t.toString());
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
