/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CatchEm;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

/**
 *
 * @author Johannes
 */
public class Player extends GameObject {
    
    Random random = new Random();
    

    public Player(int x, int y, ID id) {
        super(x, y, id);
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(x, y, 32, 32);
    }
    
}
