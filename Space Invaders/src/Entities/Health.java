/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entities;

/**
 *
 * @author pearl
 */
public class Health {
    private static int health = 3;
    
    public static void addHealth()
    {
        health +=1;
    }
    
    public static void decHealth()
    {
        health -=1;
    }
    
    public static void setHealth(int h)
    {
    	health = h;
    }
    public static int getHealth()
    {
        return health;
    }
}
