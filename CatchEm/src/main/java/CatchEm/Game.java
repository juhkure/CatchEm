/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CatchEm;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;

/**
 *
 * @author Johannes
 */
public class Game extends Canvas implements Runnable {

    private static final long serialVersionUID = 4552703084559473965L;

    public static final int width = 640, height = width / 12 * 9;
    private Thread thread;
    private boolean running = false;
    private Handler handler;

    private Random random;

    public Game() {
        handler = new Handler();

        Window window = new Window(width, height, "Hackerointipeli", this);

        random = new Random();

//        handler.addObject(new Player(100, 100, ID.Player));
//        handler.addObject(new Player(0, 0, ID.Player));
    }

    public synchronized void start() {

        running = true;
        thread = new Thread(this);
        thread.start();
    }

    public synchronized void stop() {
        try {
            thread.join();
            running = false;
        } catch (Exception e) {

        }
    }

    public final void run() {

        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;

        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                tick();
                delta--;
            }
            if (running) {
                render();
            }
            frames++;

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                System.out.println("FPS: " + frames);
                frames = 0;
            }
        }
        stop();
    }

    private void tick() {
        handler.tick();
    }

    private void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3);
        }

        if (bs != null) {
            Graphics g = bs.getDrawGraphics();

            g.setColor(Color.black);
            g.fillRect(0, 0, width, height);

            handler.render(g);

            g.dispose();
            bs.show();
        }

    }

}
