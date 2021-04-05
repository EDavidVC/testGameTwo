package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

public class Player extends gameObjects{
    private int direction = 0;
    
    public boolean isShooting = false;
    //Ola
    //asdasd
    public Player(Position position, Dimension size, Color color) {
        super(position, size, color);
    }
        
    private void move(){
        if(KeyBoard.UP){
            direction = -4;
        }
        if(KeyBoard.DOWN){
            direction = +4;
        }
        position.setY(position.getY()+direction);
    } 
    
    //How Much Shot 2 second
    
    private long lastTimeShot = System.nanoTime();
    private double cantShotForSecond = 1000000000/10;
    
    double shotTime;
    double isNowShot = 0;
    private void shoting(){
      
      long nowTime = System.nanoTime();
      shotTime = nowTime - lastTimeShot;
      lastTimeShot = nowTime;
      
      isNowShot += shotTime/cantShotForSecond;
      if(isNowShot>=1){
          isShooting = true;
          isNowShot=0;
      }      
    }
    
    
    @Override
    public void update() {
        if(KeyBoard.DOWN || KeyBoard.UP || direction != 0) move();
        if(KeyBoard.SHOT) shoting();
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(this.position.getX(), this.position.getY(), (int)size.getWidth(), (int)size.getHeight());
    }
    
}
