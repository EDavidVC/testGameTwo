package main;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import javax.swing.JFrame;

public class testGame implements Runnable{
    
    private Canvas board;
    private JFrame window;
    private boolean isRunning = false;
    private Thread thread;
    
    private StateGame stategame;
    private KeyBoard keyboard;
    
    private BufferStrategy bs;
    private Graphics g;
    public testGame(){
        thread = new Thread(this);
        window = new JFrame();
        board = new Canvas();
        stategame = new StateGame();
        keyboard = new KeyBoard();
        
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setTitle("Test Game");
        window.setLayout(new BorderLayout());
        window.setResizable(false);
        
        board.setPreferredSize(config.getSizeCanvas());
        board.setFocusable(true);
        board.addKeyListener(keyboard);
        window.add(board, null);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        
        
    }
    public static void main(String[] args) {
        testGame game;
        game = new testGame();
        game.start();
    }
    
    private void start(){
        thread.start();
        isRunning = true;
    }
    private void stop(){
        try {
            thread.join();
        } catch (InterruptedException ex) {
            System.out.println("Error en el JOIN");
        }
    }
    
    private void draw(){
        bs = board.getBufferStrategy();
        if(bs == null){
            board.createBufferStrategy(3);
            return;
        }
        
        g = bs.getDrawGraphics();
        g.clearRect(0, 0, 500, 500);
        g.setColor(Color.decode("#23021B"));
        g.fillRect(0, 0, 500, 500);
        
        //.---.-.
        
        stategame.draw(g);
        //,.,.,,.
        
        g.dispose();
        bs.show();
    }
    int x = 0;
    private void update(){
        stategame.update();
        keyboard.update();
    }
    
    @Override
    public void run() {
        final int nanoReference = 1000000000;
        final int FPS = 40;
        final double NANO_FPS = nanoReference / FPS;
        
        long nanoTime = System.nanoTime();
        
        double time;
        double delta = 0;
        
        while(isRunning){
            long initTime = System.nanoTime();
            time = initTime - nanoTime;
            nanoTime = initTime;
            
            delta += time/NANO_FPS;
            
            if(delta >= 1){
                update();
                delta -= 1;
            }
            draw();
        }
        stop();
    }
}
