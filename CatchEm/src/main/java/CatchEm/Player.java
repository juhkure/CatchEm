/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CatchEm;

import static CatchEm.Game.Height;
import static CatchEm.Game.Width;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Paint;
import java.awt.Rectangle;
import java.util.Random;

/**
 *
 * @author Johannes
 */
public class Player extends GameObject {

    private Random random;
    private Handler handler;
    private HUD hud;
    private Spawner spawner;

    public Player(int x, int y, ID id, Handler handler, HUD hud, Spawner spawner) {
        super(x, y, id);
        random = new Random();
        this.score = 0;
        this.handler = handler;
        this.hud = hud;
        this.stamina = 100;
        this.spawner = spawner;
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;

        x = Game.clamp(x, 0, Game.Width - 39);
        y = Game.clamp(y, 0, Game.Height - 60);

        collision();
    }

    private void collision() {
        for (int i = 0; i < handler.object.size(); i++) {

            GameObject tempObject = handler.object.get(i);

            if (tempObject.getId() == ID.Target) {
                if (getBounds().intersects(tempObject.getBounds())) {
                    this.addScore();
                    handler.removeObject(tempObject);
                    spawner.addTarget();
                    hud.addTime();
                }
            }
        }
    }

    @Override
    public void render(Graphics g) {
        if (getId() == ID.Player) {
            g.setColor(Color.blue);

            g.fillRect(x, y, 32, 32);
        }
        if (getId() == ID.Player2) {
            g.setColor(Color.green);
            g.fillRect(x, y, 32, 32);
        }
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x, y, 32, 32);
    }

}
