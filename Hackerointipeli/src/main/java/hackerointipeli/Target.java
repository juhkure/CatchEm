/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackerointipeli;

/**
 *
 * @author Johannes
 */
public class Target {

    private int hitpoints; //HP = hitpoints
    private String name;

    public Target(String name, int hitpoints) {
        this.name = name;
        this.hitpoints = hitpoints;
    }

    public int getHitpoints() {
        return hitpoints;
    }

    public String getName() {
        return name;
    }

    public boolean removeHealth() {
        hitpoints--;
        if (hitpoints == 0) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Target: " + name + ", remaining hitpoints: " + hitpoints;
    }
}
