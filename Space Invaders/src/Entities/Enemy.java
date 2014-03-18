/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import Handler.ImageLoader;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author pearl
 */
public class Enemy extends MapObject {

    private String nameEnemy;
    
    private int scoreEnemy; 

    public String getNameEnemy() {
        return nameEnemy;
    }

    public void setNameEnemy(String nameEnemy) {
        this.nameEnemy = nameEnemy;
    }

    public int getScoreEnemy() {
        return scoreEnemy;
    }

    public void setScoreEnemy(int scoreEnemy) {
        this.scoreEnemy = scoreEnemy;
    }
    
    protected ArrayList<EnemyBullet> bullets;

    protected BufferedImage enemyI;

    protected BufferedImage[] enemyIs;
    
    public boolean remove;
    
    protected boolean first = false;

    protected Random randG;

    protected Enemy()
    {
        
        width = 32;
        height = 32;
        cwidth = 16;
        cheight = 32;
        enemyI = ImageLoader.enemyI;
    }
    
    protected void init() {

        animation = new Animation();

        animation.setFrames(enemyIs);
        animation.setDelay(70);

        moveSpeed = 0.5;
        downSpeed = 0.3;
        remove = false;

        bullets = new ArrayList<EnemyBullet>();

        randG = new Random();
    }

    public void setFirst() {
        first = true;
    }

    public void checkAttack(Player player) {
        for (int i = 0; i < bullets.size(); i++) {
            if (player.intersects(bullets.get(i))) {
                player.isHit();
                bullets.remove(i);
            }
        }
    }

    public boolean isFirst() {
        return first;
    }

    public void getHit() {
        remove = true;
    }

    public void setPosition(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void setLeft(boolean s) {
        left = s;
        right = (s != true);
        down = (s != true);

    }

    public void setRight(boolean s) {
        right = s;
        left = (s != true);
        down = (s != true);
    }

    public void setDown(boolean s) {
        down = s;
        right = (s != true);
        left = (s != true);
    }

    public void getNextPosition() {
        if (left) {
            x = x - moveSpeed;
        }

        if (right) {
            x = x + moveSpeed;
        }

        if (down) {
            y = y + downSpeed;
        }
    }

    public void setSpeed(double moveSpeed)
    {
        this.moveSpeed = moveSpeed;
    }
    public void update() {
        getNextPosition();
        
        if (isFirst()) {
            if ((randG.nextInt(200) % 200) == 1) {
                setFiring(true);
                
            }

        }
        if (firing) {
            bullets.add(new EnemyBullet(x, y));
            firing = false;
        }
        animation.update();
        for (int i = 0; i < bullets.size(); i++) {
            bullets.get(i).update();

            if (bullets.get(i).checkRemove()) {
                bullets.remove(i);
            }

        }
    }

    public void draw(Graphics2D g) {

        for (int i = 0; i < bullets.size(); i++) {
            bullets.get(i).draw(g);
        }
        super.draw(g);
    }

}
