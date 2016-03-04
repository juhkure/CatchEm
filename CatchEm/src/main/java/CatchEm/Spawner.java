/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CatchEm;

import static CatchEm.Game.Height;
import static CatchEm.Game.Width;
import java.util.Random;

/**
 *
 * @author Johannes
 */
public class Spawner {

    private Handler handler;
    private HUD hud;
    private boolean playerExists;
    private Random random;

    /**
     *
     * @param handler
     * @param hud
     */
    public Spawner(Handler handler, HUD hud) {
        this.handler = handler;
        this.hud = hud;
        playerExists = false;
        random = new Random();
    }

    public void tick() {
        if (hud.isRunning()) {
            for (int i = 0; i < handler.object.size(); i++) {
                GameObject tempObject = handler.object.get(i);
                if (tempObject.getId() == ID.Player) {
                    playerExists = true;
                }
            }
            if (!playerExists) {
                handler.addObject(new Player(Width / 2 - 32 + 64, Height / 2 - 32, ID.Player, handler, hud, this));
                playerExists = true;
            }
        }
    }

    public void addTarget() {
        handler.addObject(new Target(random.nextInt(Width - 39), random.nextInt(Height - 60), ID.Target));
    }

}
