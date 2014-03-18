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
import java.awt.Graphics2D;

/**
 *
 * @author pearl
 */
public class Level2State extends LevelState {
    
    

    public Level2State(GameStateManager gsm) {
        
        
        super(gsm);
        Health.addHealth();
    }
    
    @Override
    public  void win() {
        gsm.setState(GameStateManager.LEVEL3STATE);
    }

    @Override
    public void setupEnemies() {
        
        int enemy1_row_size = 2; 
        int enemy2_row_size = 1;
        int enemy3_row_size = 1;
        
        enemies_row_size = enemy1_row_size + enemy2_row_size + enemy3_row_size;
        
        enemies_col_size =10;
        
        enemies_size = enemies_row_size * enemies_col_size;
        
        enemies = new Enemy[10][4];
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
    
    @Override
	public void update()
    {
        super.update();
    }
    
    @Override
	public void draw(Graphics2D g)
    {
        super.draw(g);
    }
}
