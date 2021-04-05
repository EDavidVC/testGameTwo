package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

public class Player extends gameObjects{
    private int direction = 0;
    private int points;
    public boolean isShooting = false;
    public Player(Position position, Dimension size, Color color) {
        super(position, size, color);
        points = 0;
    }
        
    private void move(){
        if(KeyBoard.UP){
            direction = -3;
        }
        if(KeyBoard.DOWN){
            direction = +3;
        }
        position.setY(position.getY()+direction);
    } 
    //How Much Shot 2 second
    
    private long lastTimeShot = System.nanoTime();
    private double cantShotForSecond = 1000000000/2;
    
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
    
    public void addPoints(int cantPoint) {
    	this.points = this.points + cantPoint;
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
        g.setColor(Color.WHITE);
        g.drawString("TOTAL POINT: "+points , 20, 20);
    }
    
}
