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

    /**
     *  Handler käy jokaisen tickin aikana pelin objektit läpi, päivittäen ne objektien
     * oman tick metodin kautta.
     */
    public void tick() {
        for (int i = 0; i < object.size(); i++) {
            GameObject tempObject = object.get(i);

            tempObject.tick();
        }
    }

    /**
     *  Renderoi objekteja.
     * @param g käytettävät grafiikat
     */
    public void render(Graphics g) {
        for (int i = 0; i < object.size(); i++) {
            GameObject tempObject = object.get(i);

            tempObject.render(g);
        }
    }

    /**
     *  Lisätään uusi GameObject olio listaan.
     * @param object
     */
    public void addObject(GameObject object) {
        this.object.add(object);
    }

    /**
     *  Poistetaan listasta GameObject
     * @param object
     */
    public void removeObject(GameObject object) {
        this.object.remove(object);
    }

    /**
     *  Kertoo pelaaja1 pistemäärän
     * @return player1 pisteet
     */
    public int player1Score() {
        for (int i = 0; i < object.size(); i++) {
            GameObject tempObject = object.get(i);

            if (tempObject.getId() == ID.Player) {
                return tempObject.getScore();
            }
        }
        return 0;
    }

    /**
     *  Kertoo pelaaja2 pistemäärän
     * @return player2 pisteet
     */
    
//    HUOM, pelistä ei löydy vielä pelaaja2!!!
    
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
