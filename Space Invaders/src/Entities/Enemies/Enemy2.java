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
public class Enemy2 extends Enemy {

    public Enemy2() {

        super();

        
        setNameEnemy("Enemy2");
        setScoreEnemy(3);
        
        enemyIs = new BufferedImage[20];

        for (int i = 0; i < 10; i++) {
            enemyIs[i] = enemyI.getSubimage(i * width, height * 3, width, height);
        }

        for (int i = 0; i < 10; i++) {
            enemyIs[i + 10] = enemyIs[9 - i];
        }

        init();
    }
}
