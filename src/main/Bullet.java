package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

public class Bullet extends gameObjects { 

    public Bullet(Position position, Dimension size, Color color) {
        super(position, size, color);
    }
    
    @Override
    public void update() {
        this.position.setX(this.position.getX() + 15);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.yellow);
        g.fillRect(position.getX(), position.getY(), 10, 10);
    }
    
}
