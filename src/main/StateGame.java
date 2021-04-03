package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;

public class StateGame {
    private ArrayList<gameObjects> bullets;
    private Player player;
    //Este mensaje biene desde un lugar
    public StateGame(){
        bullets = new ArrayList<gameObjects>();
        player = new Player(new Position(20,20), new Dimension(20, 40), Color.BLUE);
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
    
    }
    public void draw(Graphics g){
        player.draw(g);
        for(int i=0;i<bullets.size();i++){
            bullets.get(i).draw(g);
        }
    }
}
