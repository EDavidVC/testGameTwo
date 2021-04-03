package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

public abstract class gameObjects {
    protected Position position;
    protected Dimension size;
    protected Color color;
    
    
    public gameObjects(Position position, Dimension size, Color color){
        this.position = position;
        this.size = size;
        this.color = color;
    }
    public Position getPosition(){
        return this.position;
    }
    public abstract void update();
    public abstract void draw(Graphics g);
    
    public Position getMidLeft(){
        double positionInY = this.position.getY();
        double heigthSize = this.size.getHeight();
        
        double midLeft = positionInY + (heigthSize/2);
        return new Position(position.getX(),(int) midLeft);
    }
}
