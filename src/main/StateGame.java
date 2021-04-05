package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;

public class StateGame {
    private ArrayList<gameObjects> bullets;
    private Player player;
    private ArrayList<gameObjects> enemies;
    
    //Este mensaje biene desde un lugar
    public StateGame(){
        bullets = new ArrayList<gameObjects>();
        enemies = new ArrayList<gameObjects>();
        player = new Player(new Position(20,20), new Dimension(20, 40), Color.decode("#1664C9"));
        
        enemies.add(new enemy(new Position(550, 70), new Dimension(50,50), Color.yellow));
    }
    
    private long lastTimeShot = System.nanoTime();
    private double cantShotForSecond = 1000000000/0.9;
    
    private double shotTime;
    private double isNowShot = 0;
    private void createEnemies() {
    	long nowTime = System.nanoTime();
        shotTime = nowTime - lastTimeShot;
        lastTimeShot = nowTime;
        
        isNowShot += shotTime/cantShotForSecond;
        if(isNowShot>=1){
        	isNowShot=0;
        	enemies.add(new enemy(new Position().generateEnemyAleatoriPosition(), new Dimension(50,50), Color.yellow));
        }
    }
    public void update(){
        player.update();

        if(player.isShooting){
            bullets.add(new Bullet(
                    new Position(player.getMidLeft().getX(),
                            player.getMidLeft().getY() - 5),
                    new Dimension(10, 10), Color.yellow));
            player.isShooting = false;
        }
        for(int i=0;i < bullets.size();i++){
            bullets.get(i).update();
            if(bullets.get(i).position.getX() > (config.getSizeCanvas().height+40)){
                bullets.remove(i);
            }
        }
        for(int e=0;e < enemies.size();e++){
            enemies.get(e).update();
            for(int i=0;i < bullets.size();i++){
                if(enemies.get(e).isColision(bullets.get(i))) {
                	enemies.remove(e);
                	bullets.remove(i);
                	player.addPoints(20);
                	break;
                }
            }
        }
        
        createEnemies();
    
    }
    public void draw(Graphics g){
        player.draw(g);
        for(int i=0;i<bullets.size();i++){
            bullets.get(i).draw(g);
        }
        for(int e=0;e < enemies.size();e++){
            enemies.get(e).draw(g);;
        }
    }
    
    
}
