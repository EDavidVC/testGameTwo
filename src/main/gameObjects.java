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
    
    public boolean isColision(gameObjects gobject) {
    	Position relativePositionObj1 = gobject.getRelativePosition();
    	Position relativePositionObj2 = this.getRelativePosition();
    	int FarX = relativePositionObj1.getX() - relativePositionObj2.getX();//-1 or 1
    	int FarY = relativePositionObj1.getY() - relativePositionObj2.getY();
    	
    	int totalTwoHeight = this.getRadiusSize().height + gobject.getRadiusSize().height;
    	int totalTwoWidth = this.getRadiusSize().width + gobject.getRadiusSize().width;
    	
    	if((FarX <= totalTwoWidth && FarX >= (totalTwoWidth*-1))
    			&&(FarY <= totalTwoHeight && FarY >= (totalTwoHeight*-1))) {
    		return true;
    	}
    	
    	return false;
    }
    private Position getRelativePosition() {
    	int x = this.position.getX() + ((int)size.getWidth()/2);
    	int y = this.position.getY() + ((int)size.getHeight()/2);
    	return new Position(x,y);
    }
    private Dimension getRadiusSize() {
    	int x =(int) this.size.getWidth()/2;
    	int y =(int) this.size.getHeight()/2;
    	return new Dimension(x,y);
    }
    public Position getMidLeft(){
        double positionInY = this.position.getY();
        double heigthSize = this.size.getHeight();
        
        double midLeft = positionInY + (heigthSize/2);
        return new Position(position.getX(),(int) midLeft);
    }
}
