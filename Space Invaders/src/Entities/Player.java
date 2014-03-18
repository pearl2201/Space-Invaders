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

/**
 * 
 * @author pearl
 */
public class Player extends MapObject {

	public BufferedImage playerI;

	private ArrayList<Bullet> bullets;
	private int health;
	private static final int bulletCost = 30;
	private int bulletM;
	private BufferedImage[] playerSpriteSheet;

	private static Player instance; 
	
	public static Player getInstance()
	{
		if (instance == null)
			instance = new Player();
		return instance;
	}
	
	private Player() {
		playerI = ImageLoader.playerI;

		width = 70;
		height = 40;
		cwidth = 40;
		cheight = 40;

		health = 3;
		moveSpeed = 1;
		bullets = new ArrayList<Bullet>();

		playerSpriteSheet = new BufferedImage[1];
		playerSpriteSheet[0] = playerI;

		bulletM = 30;
		animation = new Animation();
		animation.setFrames(playerSpriteSheet);

	}

	public void isHit() {
		Health.decHealth();
	}

	public void checkAttack(Enemy[][] enemies, int enemies_row_size,
			int enemies_col_sire) {
		for (int i = 0; i < enemies_col_sire; i++) {
			for (int j = 0; j < enemies_row_size; j++) {
				if (enemies[i][j] != null) {
					boolean isHit = false;
					if (enemies[i][j].intersects(this)) {
						isHit();
						enemies[i][j].getHit();
					} else {
						for (int k = 0; k < bullets.size(); k++) {
							if (bullets.get(k).intersects(enemies[i][j])) {
								isHit = true;
								bullets.remove(k);
							}
						}
						if (isHit) {
							enemies[i][j].getHit();
						}
					}
				}

			}
		}
	}

	public void setPosition(int i, int i0) {
		this.x = i;
		this.y = i0;
	}

	public void addHealth() {
		health++;
	}

	public void raiseSpeed() {
		moveSpeed += 0.05;
	}

	public void setLeft(boolean s) {
		left = s;
	}

	public void setRight(boolean s) {
		right = s;
	}

	private void getNextPosition() {
		if (left) {
			x = x - moveSpeed;
			if (x < width / 2) {
				x = width / 2;
			}

		}

		if (right) {
			x = x + moveSpeed;
			if (x > mapWidth - width / 2) {
				x = mapWidth - width / 2;
			}
		}

	}

	public void update() {
		getNextPosition();
		bulletM++;
		if (bulletM > bulletCost) {
			bulletM = bulletCost;
		}
		if (firing && bulletM == bulletCost) {
			bullets.add(new Bullet(x, y));
			firing = false;
			bulletM = bulletM - bulletCost;

		}

		for (int i = 0; i < bullets.size(); i++) {
			bullets.get(i).update();

			if (bullets.get(i).checkRemove()) {
				bullets.remove(i);
			}

		}

	}

	@Override
	public void draw(Graphics2D g) {
		super.draw(g);
		for (int i = 0; i < bullets.size(); i++) {
			bullets.get(i).draw(g);
		}

	}

}
