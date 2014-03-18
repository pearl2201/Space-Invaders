/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameStateManager.LevelState;

import Entities.Enemies.Enemy1;
import Entities.Enemies.Enemy2;
import Entities.Enemies.Enemy3;
import Entities.Enemy;
import Entities.Health;
import GameStateManager.GameStateManager;
import Entities.Score;

/**
 *
 * @author pearl
 */
public class Level1State extends LevelState {

    public Level1State(GameStateManager gsm) {

        super(gsm);
        init();
    }
    
    @Override
    public void init()
    {
    	
        super.init();
        Health.setHealth(3);
        Score.instance.setPlayer("Anh Ngoc");
        Score.instance.setScore(0);
    }
    public void win() {
        gsm.setState(GameStateManager.LEVEL2STATE);
    }

    public void setupEnemies() {
        int enemy1_row_size = 1; 
        int enemy2_row_size = 1;
        int enemy3_row_size = 1;
        
        enemies_row_size = enemy1_row_size + enemy2_row_size + enemy3_row_size;
        
        enemies_col_size =10;
        
        enemies_size = enemies_row_size * enemies_col_size;
        
        enemies = new Enemy[10][3];
        for (int i = 0; i < enemies_col_size; i++) {
            for (int j = 0; j < enemy1_row_size; j++) {
                 
                enemies[i][j] = new Enemy1();
                enemies[i][j].setPosition(40 + i * 40, 56 + j * 40);
                enemies[i][j].setRight(true);
            }
            for (int k = enemy1_row_size; k < enemy1_row_size+enemy2_row_size; k++) {
                enemies[i][k] = new Enemy2();
                enemies[i][k].setPosition(40 + i * 40, 56 + k * 40);
                enemies[i][k].setRight(true);
            }
            for (int k = enemy1_row_size + enemy2_row_size; k < enemy1_row_size+enemy2_row_size+enemy3_row_size; k++) {
                enemies[i][k] = new Enemy3();
                enemies[i][k].setPosition(40 + i * 40, 56 + k * 40);
                enemies[i][k].setRight(true);
            }
        }

        for (int i = 0; i < enemies_col_size; i++) {
          
            enemies[i][enemies_row_size - 1].setFirst();
    }
    }
}
