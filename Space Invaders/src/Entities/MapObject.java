/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entities;

import java.awt.Graphics2D;
import java.awt.Rectangle;

import Main.GamePanel;

/**
 *
 * @author pearl
 */
public class MapObject {
    
    protected double x;
    protected double y;
    protected double dx;
    protected double dy;
    
    protected int width;
    protected int height;
    
    //collision
    protected int cwidth;
    protected int cheight;
    
    protected Animation animation;
    
    protected double xtemp;
    protected double ytemp;
    protected double xdest;
    protected double ydest;
    
    protected boolean left;
    protected boolean right;
    protected boolean down;
    public boolean firing;
    
    protected double moveSpeed;
    protected double downSpeed;
    
    protected static final int mapHeight = GamePanel.DEFAULT_HEIGHT;
    protected static final int mapWidth = GamePanel.DEFAULT_WIDTH;
    
   
    public boolean intersects(MapObject o)
    {
        Rectangle r1 = getRectangle();
        Rectangle r2 = o.getRectangle();
        return r1.intersects(r2);
    }
    
    public Rectangle getRectangle()
    {
        return new Rectangle((int) x-cwidth/2,(int)  y-cwidth/2, cwidth, cheight);
    }
    
 
    
     public void setPosition(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public double getX()
    {
        return x;
    }
    
    public double getY()
    {
        return y;
    }
    
    public int getWidth()
    {
        return width;
    }
    
    public int getHeight()
    {
        return height;
    }
    
    
    public void draw(Graphics2D g)
    {
        g.drawImage(animation.getImage(),(int) x-width/2,(int) y-height/2, width, height, null);
    }
    
    public void setFiring(boolean s) {
        firing = s;
    }
            
}
