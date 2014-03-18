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
public class Enemy3 extends Enemy {

    public Enemy3() {

        super();

        setNameEnemy("Enemy3");
        setScoreEnemy(1);

        enemyIs = new BufferedImage[6];

        for (int i = 0; i < 3; i++) {
            enemyIs[i] = enemyI.getSubimage(i * width, height * 4, width, height);
        }

        for (int i = 0; i < 3; i++) {
            enemyIs[i + 3] = enemyIs[2 - i];
        }

        init();
    }

}
