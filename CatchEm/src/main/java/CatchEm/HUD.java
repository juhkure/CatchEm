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
import static java.lang.Math.random;
import static java.lang.StrictMath.random;
import java.text.DecimalFormat;
import java.util.Random;

/**
 *
 * @author Johannes
 */
public class HUD {

    private int ticksInSecond;
    private double time;
    private double timeInOneTick;
    private DecimalFormat df;
    private Handler handler;
    private Random random;
    private boolean running;

    /**
     *
     * @param handler Handler luokka, jota käytetään myöhemmin
     */
    public HUD(Handler handler) {
        this.running = false;
        this.random = new Random();
        this.handler = handler;
        this.ticksInSecond = 600;
        this.time = 10.0;
        timeInOneTick = (double) time / ticksInSecond;
    }

    /**
     * HUD luokan tick metodi. Päivittää pelin ajan ja tarkistaa ettei Target -olioita löydy pelistä kun aika
     * on loppu.
     *
     */
    public void tick() {

        if (running) {
            time -= timeInOneTick;

            if (time <= 0.0) {
                time = 0.0;

                for (int i = 0; i < handler.object.size(); i++) {
                    GameObject tempObject = handler.object.get(i);

                    if (tempObject.getId() == ID.Target) {
                        handler.removeObject(tempObject);
                    }
                }
            }
        }
    }

    /**
     * Renderoidaan elementit ikkunalle
     *
     * @param g Käytettävät grafiikat
     */
    public void render(Graphics g) {

        String timeInString = String.format("%.1f", time);
        g.setColor(Color.white);
        g.drawString(timeInString, 15, 15);

        if (!running) {
            g.setColor(Color.green);
            g.drawString("Press enter to start", 255, 165);
        }

        if (time <= 0.0) {
            g.setColor(Color.red);
            g.fillRect(258, 149, 65, 15);

            g.setColor(Color.black);
            g.drawString("Game over", 260, 160);

            String scoreInString = Integer.toString(handler.player1Score());

            g.setColor(Color.white);
            g.drawString("Your score: " + scoreInString, 255, 185);

            g.setColor(Color.green);
            g.drawString("Press esc to close,", 255, 210);

            g.drawString("or press enter to try again", 255, 225);

        }
    }

    /** 
     * Lisätään aikaa 0.75 sekuntia.
     *
     */
    public void addTime() {
        time += 0.75;
    }

    /**
     * Käynnistää pelin graafiset elementit.
     *
     */
    public void start() {
        running = true;
        for (int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);

            if (tempObject.getId() == ID.Target) {
                handler.removeObject(tempObject);
            }
        }
        time = 10.0;
        handler.addObject(new Target(random.nextInt(Width - 39), random.nextInt(Height - 60), ID.Target));

    }

    /**
     * Kertoo mikäli peli on jo käynnissä.
     *
     * @return running Onko peli käynnissä
     */
    public boolean isRunning() {
        return running;
    }
}
