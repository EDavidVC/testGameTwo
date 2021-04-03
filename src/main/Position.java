package main;

import java.awt.Dimension;

public class Position {
    private int x;
    private int y;
    public Position(int x, int y){
        this.x = x;
        this.y = y;
    }
    public Position(){
        this.x = 0;
        this.y = 0;
    }
    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }
    public void setX(int newX){this.x = newX;}
    public void setY(int newY){this.y = newY;}
    
    public Dimension getMidRigth(){return new Dimension(200,200);}
}
