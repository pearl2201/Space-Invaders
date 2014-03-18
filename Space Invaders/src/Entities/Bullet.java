/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import Handler.ImageLoader;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 *
 * @author pearl
 */
// Do khong kiem duoc dan nen minh dung fireball cho chat choi :))
public class Bullet extends MapObject {

    public BufferedImage[] BulletImages;
    public BufferedImage[] BulletHitedImages;
    protected BufferedImage BulletI;

    public Bullet(double x, double y) {
        BulletI = ImageLoader.BulletI;
        width = 15;
        height = 15;
        cwidth = 10;
        cheight = 10;
        this.x = x;
        this.y = y;
        
         moveSpeed = 2;
        
        BulletImages = new BufferedImage[4];
        for (int i = 0; i < 4; i++) {
            BulletImages[i] = BulletI.getSubimage(i * width, 0, width, height);
        }
        BulletHitedImages = new BufferedImage[3];
        for (int i = 0; i < 3; i++) {
            BulletHitedImages[i] = BulletI.getSubimage(i * width, height, width, height);
        }

        animation = new Animation();

        animation.setFrames(BulletImages);
        animation.setDelay(90);
        
        

    }

    public boolean checkRemove()
    {
        if (y<0)
        {
            return true;
        }
        return false;
    }
    
    public void update() {
        animation.update();
        y = y - moveSpeed; 

    }

    @Override
	public void draw(Graphics2D g) {
        if (animation.getImage() == null)
        {
            System.out.println("Image is null");
        }
        super.draw(g);
    }
}
