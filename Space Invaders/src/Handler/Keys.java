/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Handler;

import java.awt.event.KeyEvent;

/**
 *
 * @author pearl
 */
public class Keys {
    
    public static final int NUMS_KEY = 7;
    
    public static boolean[] keyState = new boolean[NUMS_KEY];
    public static boolean[] prevKeyState = new boolean[NUMS_KEY];
    
    public static int ENTER = 0;
    public static int ESC = 1;
    public static int SPACE = 2;
    public static int UP = 3;
    public static int DOWN = 4;
    public static int RIGHT = 5;
    public static int LEFT = 6;
    
    public static void KeySet(int k, boolean b)
    {
        if ( k ==KeyEvent.VK_ENTER ) keyState[ENTER] = b;
        if ( k == KeyEvent.VK_ESCAPE) keyState[ESC] = b;
        if ( k == KeyEvent.VK_SPACE) keyState[SPACE] = b;
        if ( k == KeyEvent.VK_DOWN) keyState[DOWN] = b;
        if (k == KeyEvent.VK_UP) keyState[UP] = b;
        if (k == KeyEvent.VK_RIGHT) keyState[RIGHT] = b;
        if (k == KeyEvent.VK_LEFT) keyState[LEFT] = b;
    }
    
    public static void update()
    {
        for (int i =0; i<NUMS_KEY; i++)
        {
            prevKeyState[i] = keyState[i]; 
        }
    }
    
    // Tra ve true trong truong hop lien tuc giu phim
    public static boolean isPress(int k)
    {
        return keyState[k];
    }
    
    // Tra ve true trong truong hop nhan phim roi tha ra luon
      public static boolean isFirstPress(int k)
    {
        return keyState[k] && !prevKeyState[k];
    }
    
            
            
            }
