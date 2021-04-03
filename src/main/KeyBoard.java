package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javafx.scene.input.KeyCode;

public class KeyBoard implements KeyListener {
    private boolean[] keys = new boolean[256];
    public static boolean UP, DOWN, SHOT;
    
    public KeyBoard(){
        UP = false;
        DOWN = false;
    }
    public void update(){
        UP = keys[KeyEvent.VK_W];
        DOWN = keys[KeyEvent.VK_S];
        SHOT = keys[KeyEvent.VK_F];
    }
    

    @Override
    public void keyTyped(KeyEvent ke) {
        
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        keys[ke.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        keys[ke.getKeyCode()] = false;
    }
    
}
