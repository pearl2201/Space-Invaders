/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entities;

import Main.GamePanel;

/**
 *
 * @author pearl
 */
public class EnemyBullet extends Bullet {
    
    public EnemyBullet(double x, double y)
    {
        super(x,y);
    }
    
    public boolean checkRemove()
    {
        if (y>GamePanel.DEFAULT_HEIGHT)
        {
            return true;
        }
        return false;
    }
    
    public void update() {
        animation.update();
        y = y + moveSpeed; 

    }
}
