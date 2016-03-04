/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CatchEm;

import java.awt.Graphics;
import java.util.LinkedList;

/**
 *
 * @author Johannes
 */
public class Handler {

    public LinkedList<GameObject> object;

    public Handler() {
        this.object = new LinkedList<>();
    }

    public void tick() {
        for (int i = 0; i < object.size(); i++) {
            GameObject tempObject = object.get(i);

            tempObject.tick();
        }
    }

    public void render(Graphics g) {
        for (int i = 0; i < object.size(); i++) {
            GameObject tempObject = object.get(i);

            tempObject.render(g);
        }
    }

    public void addObject(GameObject object) {
        this.object.add(object);
    }

    public void removeObject(GameObject object) {
        this.object.remove(object);
    }

    public int player1Score() {
        for (int i = 0; i < object.size(); i++) {
            GameObject tempObject = object.get(i);

            if (tempObject.getId() == ID.Player) {
                return tempObject.getScore();
            }
        }
        return 0;
    }

    public int player2Score() {
        for (int i = 0; i < object.size(); i++) {
            GameObject tempObject = object.get(i);

            if ((tempObject.getId() == ID.Player2)) {
                return tempObject.getScore();
            }
        }
        return 0;
    }
}
