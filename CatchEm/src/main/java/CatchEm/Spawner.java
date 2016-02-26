/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CatchEm;

import static CatchEm.Game.height;
import static CatchEm.Game.width;

/**
 *
 * @author Johannes
 */
public class Spawner {

    private Handler handler;
    private HUD hud;
    private boolean playerExists;

    public Spawner(Handler handler, HUD hud) {
        this.handler = handler;
        this.hud = hud;
        playerExists = false;
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
                handler.addObject(new Player(width / 2 - 32 + 64, height / 2 - 32, ID.Player, handler, hud));
            }
        }
    }

}
