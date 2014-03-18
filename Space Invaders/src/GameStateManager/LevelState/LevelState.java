/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameStateManager.LevelState;

import Entities.Enemy;
import Entities.HUD;
import Entities.Player;
import Entities.Score;
import Main.GamePanel;
import Background.Background;
import Entities.Health;
import GameStateManager.GameState;
import GameStateManager.GameStateManager;
import Handler.Keys;
import static Handler.Keys.ESC;
import static Handler.Keys.LEFT;
import static Handler.Keys.RIGHT;
import static Handler.Keys.SPACE;
import java.awt.Graphics2D;

/**
 * 
 * @author pearl
 */
public abstract class LevelState extends GameState {

	protected Background bg;
	protected Player player;
	protected Enemy[][] enemies;
	protected static int enemies_row_size;
	protected static int enemies_col_size;
	protected static int enemies_size;

	protected int rightEndEnemy;
	protected int leftEndEnemy;
	protected int rowLeftEndEnemy;
	protected int rowRightEndEnemy;

	protected int yOldDown;
	protected int yTempDown;

	protected boolean down = false;
	protected HUD hud;

	public LevelState(GameStateManager gsm) {
		super(gsm);
		init();
	}

	@Override
	public void init() {

		bg = new Background();
		player = Player.getInstance();

		player.setPosition(320, 440);

		setupEnemies();

	}

	@Override
	public void update() {

		handleInput();
		player.update();
		player.checkAttack(enemies, enemies_row_size, enemies_col_size);
		updateEnemy();
		if (checkWin()) {
			win();
		}
		if (checkLose()) {
			lose();
		}

	}

	@Override
	public void draw(Graphics2D g) {

		bg.draw(g);
		player.draw(g);
		HUD.draw(g);
		for (int i = 0; i < enemies_col_size; i++) {
			for (int j = 0; j < enemies_row_size; j++) {
				if (enemies[i][j] != null) {
					enemies[i][j].draw(g);
				}
			}
		}

	}

	@Override
	public void handleInput() {

		player.setLeft(Keys.isPress(LEFT));

		player.setRight(Keys.isPress(RIGHT));

		player.setFiring(Keys.isFirstPress(SPACE));

		if (Keys.isPress(ESC)) {
			gsm.loadPausedState();
		}

	}

	public abstract void setupEnemies();

	public void updateEnemy() {
		boolean left = false;
		boolean right = false;
		boolean turnLeft = false;
		boolean turnRight = false;
		boolean turnDown = false;

		for (int i = 0; i < enemies_col_size && left == false; i++) {
			for (int j = 0; j < enemies_row_size && left == false; j++) {

				if (enemies[i][j] != null) {
					leftEndEnemy = i;
					rowLeftEndEnemy = j;
					left = true;
				}
			}
		}

		for (int i = enemies_col_size - 1; i >= 0 && right == false; i--) {
			for (int j = 0; j < enemies_row_size && right == false; j++) {

				if (enemies[i][j] != null) {

					rightEndEnemy = i;
					rowRightEndEnemy = j;
					right = true;

				}
			}
		}

		if (down) {

			yTempDown = (int) enemies[leftEndEnemy][rowLeftEndEnemy].getY()
					- enemies[leftEndEnemy][rowLeftEndEnemy].getHeight() / 2;
			if ((yTempDown - yOldDown) >= enemies[leftEndEnemy][rowLeftEndEnemy]
					.getHeight()) {
				if ((enemies[leftEndEnemy][rowLeftEndEnemy].getX() - enemies[leftEndEnemy][rowLeftEndEnemy]
						.getWidth() / 2) <= 0) {
					turnRight = true;
					down = false;
				}

				if ((enemies[rightEndEnemy][rowRightEndEnemy].getX() + enemies[rightEndEnemy][rowRightEndEnemy]
						.getWidth() / 2) >= GamePanel.DEFAULT_WIDTH) {
					turnLeft = true;
					down = false;
				}
			} else {
				turnDown = true;
			}
		} else {
			if ((enemies[leftEndEnemy][rowLeftEndEnemy].getX() - enemies[leftEndEnemy][rowLeftEndEnemy]
					.getWidth() / 2) <= 0) {
				turnRight = false;
				turnLeft = false;
				turnDown = true;
				down = true;
				yOldDown = (int) (enemies[leftEndEnemy][rowLeftEndEnemy].getY() - enemies[leftEndEnemy][rowLeftEndEnemy]
						.getHeight() / 2);
			}

			if ((enemies[rightEndEnemy][rowRightEndEnemy].getX() + enemies[rightEndEnemy][rowRightEndEnemy]
					.getWidth() / 2) >= GamePanel.DEFAULT_WIDTH) {
				turnRight = false;
				turnLeft = false;
				turnDown = true;

				yOldDown = (int) (enemies[leftEndEnemy][rowLeftEndEnemy].getY() - enemies[leftEndEnemy][rowLeftEndEnemy]
						.getHeight() / 2);
				down = true;
			}
		}

		for (int j = 0; j < enemies_row_size; j++) {
			for (int i = 0; i < enemies_col_size; i++) {

				if (enemies[i][j] != null) {
					if (enemies[i][j].remove) {

						enemies_size--;
						Score.instance.addScore(enemies[i][j].getScoreEnemy());
						boolean first = false;
						for (int k = j - 1; k >= 0 && !first; k--) {
							if (enemies[i][k] != null) {
								enemies[i][k].setFirst();
								first = true;
							}
						}

						enemies[i][j] = null;

					} else {
						if (turnLeft) {
							enemies[i][j].setLeft(true);
						}
						if (turnRight) {
							enemies[i][j].setRight(true);
						}
						if (turnDown) {
							enemies[i][j].setDown(true);
						}

						enemies[i][j].update();
						enemies[i][j].checkAttack(player);

					}

				}
			}
		}
	}

	public boolean checkWin() {

		return enemies_size == 0;
	}

	public boolean checkLose() {

		if (Health.getHealth() <= 0) {
			return true;
		}
		for (int i = enemies_col_size - 1; i >= 0; i--) {
			for (int j = enemies_row_size - 1; j >= 0; j--) {
				if (enemies[i][j] != null) {
					if ((enemies[i][j].getY() + enemies[i][j].getHeight() / 2) >= GamePanel.DEFAULT_HEIGHT) {
						return true;
					}

				}
			}
		}
		return false;
	}

	public abstract void win();

	public void lose() {
		gsm.setState(GameStateManager.FINALGAMESTATE);
	}
}
