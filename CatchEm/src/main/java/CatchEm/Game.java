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
    private final Handler handler;
    private final HUD hud;

    private Random random;

    public Game() {
        handler = new Handler();

        hud = new HUD(handler);

        this.addKeyListener(new KeyInput(handler, hud, this));

        Window window = new Window(width, height, "CatchEm", this);

        random = new Random();

        handler.addObject(new Player(width / 2 - 32 + 64, height / 2 - 32, ID.Player, handler, hud));
        handler.addObject(new Target(random.nextInt(width - 39), random.nextInt(height - 60), ID.Target));

//        handler.addObject(new Player(width/2-32 - 64, height/2-32, ID.Player2));
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
        this.requestFocus();

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
                this.render();
            }
            frames++;

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
//                System.out.println("FPS: " + frames);
                frames = 0;
            }
        }
        stop();
    }

    private void tick() {
        handler.tick();
        hud.tick();
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

            hud.render(g);

            g.dispose();

            bs.show();
        }
    }

    public static int clamp(int variable, int min, int max) {
        if (variable >= max) {
            return variable = max;
        } else if (variable <= min) {
            return variable = min;
        } else {
            return variable;
        }
    }

}
