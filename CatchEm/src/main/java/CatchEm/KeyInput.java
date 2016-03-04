/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CatchEm;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *
 * @author Johannes
 */
public class KeyInput extends KeyAdapter {
//    W: 87    S: 83   A: 65   D: 68  SPACE: 32  
    
    private Handler handler;
    private Game game;
    private HUD hud;
    private int speedBoost;
    private int speed;
    
    
    public KeyInput(Handler handler, HUD hud, Game game){
        this.handler = handler;
        this.game = game;
        this.hud = hud;
        speedBoost = 3;
        speed = 4;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();
        
        for (int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);
            
            if(tempObject.getId() == ID.Player){
                
                if(key == KeyEvent.VK_UP){ tempObject.setVelY(-4); }
                if(key == KeyEvent.VK_DOWN){ tempObject.setVelY(4); }
                if(key == KeyEvent.VK_LEFT){ tempObject.setVelX(-4); }
                if(key == KeyEvent.VK_RIGHT){ tempObject.setVelX(4); }
            }
            
            if(tempObject.getId() == ID.Player2){
                
                if(key == KeyEvent.VK_W){ tempObject.setVelY(-4);}
                if(key == KeyEvent.VK_S){ tempObject.setVelY(4);}
                if(key == KeyEvent.VK_A){ tempObject.setVelX(-4);}
                if(key == KeyEvent.VK_D){ tempObject.setVelX(4);}
                
            }
        }
        
        if(key == KeyEvent.VK_ESCAPE){
            System.exit(0);
        }
        
        if(key == KeyEvent.VK_ENTER){
            hud.start();
            
            for (int i = 0; i < handler.object.size(); i++) {
                GameObject tempObject = handler.object.get(i);
                
                tempObject.resetScore();
                tempObject.resetStamina();
                
            }
        }
    }
    
    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode();
        
        for (int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);
            
            if(tempObject.getId() == ID.Player){
                
                if(key == KeyEvent.VK_UP){ tempObject.setVelY(0); }
                if(key == KeyEvent.VK_DOWN){ tempObject.setVelY(0); }
                if(key == KeyEvent.VK_LEFT){ tempObject.setVelX(0); }
                if(key == KeyEvent.VK_RIGHT){ tempObject.setVelX(0); }
            }
            
            if(tempObject.getId() == ID.Player2){
                
                if(key == KeyEvent.VK_W){ tempObject.setVelY(0);}
                if(key == KeyEvent.VK_S){ tempObject.setVelY(0);}
                if(key == KeyEvent.VK_A){ tempObject.setVelX(0);}
                if(key == KeyEvent.VK_D){ tempObject.setVelX(0);}
                
            }
        }
    }
}
