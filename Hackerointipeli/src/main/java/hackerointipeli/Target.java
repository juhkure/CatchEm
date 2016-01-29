/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackerointipeli;

import java.awt.Graphics;

/**
 *
 * @author Johannes
 */
public class Target extends GameObject{

    private int hitpoints; //HP = hitpoints
    private String name;
    
    public Target(int x, int y, ID id){
        super(x, y, id);
        this.name = "target";
        this.hitpoints = 100;
    }

    public int getHitpoints() {
        return hitpoints;
    }

    public String getName() {
        return name;
    }

    public boolean removeHealth() {
        hitpoints--;
        if (hitpoints < 0) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Target: " + name + ", remaining hitpoints: " + hitpoints;
    }

    @Override
    public void tick() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void render(Graphics g) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
