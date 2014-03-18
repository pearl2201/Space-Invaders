/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entities;

import Handler.FontConvert;
import Handler.ImageLoader;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 *
 * @author pearl
 */
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
public class HUD {
    
    
    private static final BufferedImage healthI = ImageLoader.healthI; 
    private static final BufferedImage scoreI = ImageLoader.scoreI;
    private static final int healthX = 10;
    private static final int healthY = 10;
    private static final int scoreX = 560;
    private static final int scoreY = 10;
    private static final int widthHealth = 35;
    private static final int heightHealth = 20;
    
    private static final int widthScore = 20;
    private static final int heightScore = 20;
    
  
    
    
    public static void draw(Graphics2D g)
    {
        g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
        g.setColor(Color.BLUE);
        for (int i=0; i<Health.getHealth(); i++)
        {
        g.drawImage(healthI, healthX + widthHealth*i, healthY, widthHealth, heightHealth, null);
        
        }
        g.drawImage(scoreI, scoreX, scoreY, widthScore, heightScore, null);
        
        g.drawImage(FontConvert.convertString2Image(Integer.toString( Score.instance .getScore()), false), scoreX +widthScore +10, scoreY,null);
        
    }
    
}
