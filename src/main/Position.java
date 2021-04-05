package main;

import java.awt.Dimension;
import java.util.Random;
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
    public Position generateEnemyAleatoriPosition() {
    	int y = (int) generateNumber(450, 0);
    	int x = 550;
    	Position tempPosition = new Position(x,y);
    	return tempPosition;
    }
    public void setX(int newX){this.x = newX;}
    public void setY(int newY){this.y = newY;}
    
    private double generateNumber(double max, double min) {
    	double tempNumber = (Math.random() * (max-min)+1)+min;
    	return tempNumber;
    }
    public Dimension getMidRigth(){return new Dimension(200,200);}
}
