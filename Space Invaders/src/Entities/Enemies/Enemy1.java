/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entities.Enemies;

import Entities.Enemy;
import java.awt.image.BufferedImage;
/**
 *
 * @author pearl
 */
public class Enemy1 extends Enemy{
    
    
    public Enemy1()
    {
        super();
        
        setNameEnemy("Enemy1");
        setScoreEnemy(5);
        enemyIs = new BufferedImage[20];
        
        for (int i =0; i<10; i++)
        {
            enemyIs[i] =  enemyI.getSubimage(i*width, 0, width, height);
        }
        
        for (int i = 0; i< 10 ; i ++)
        {
            enemyIs[i+10] =  enemyIs[9-i];
        }
   
        init();
    }
    
}
