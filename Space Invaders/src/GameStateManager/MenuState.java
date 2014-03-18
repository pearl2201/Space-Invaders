/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameStateManager;

import Background.Background;
import Handler.FontConvert;
import Handler.ImageLoader;
import Handler.Keys;
import static Handler.Keys.DOWN;
import static Handler.Keys.ENTER;
import static Handler.Keys.UP;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 * 
 * @author pearl
 */
public class MenuState extends GameState {

	private Background bg;


	private static final BufferedImage logo = ImageLoader.logo;

	private int currentChoice = 0;

	private static final String[] opitions = { "Start", "High Scores", "Quit" };

	public MenuState(GameStateManager gsm) {
		super(gsm);
		init();
	}

	@Override
	public void init() {

		bg = new Background();

	}

	@Override
	public void update() {
		handleInput();
	}

	@Override
	public void draw(Graphics2D g) {
		bg.draw(g);
		g.drawImage(logo, 150, 10, null);

		for (int i = 0; i < opitions.length; i++) {
			if (i != currentChoice) {

				g.drawImage(FontConvert.convertString2Image(opitions[i], true),
						210, 200 + i * 40, null);

			} else {

				g.drawImage(
						FontConvert.convertString2Image(opitions[i], false),
						210, 200 + i * 40, null);
			}
		}
	}

	@Override
	public void handleInput() {
		if (Keys.isFirstPress(UP)) {
			currentChoice -= 1;

			if (currentChoice < 0) {
				currentChoice = opitions.length - 1;
			}
		}
		if (Keys.isFirstPress(DOWN)) {
			currentChoice += 1;

			if (currentChoice == opitions.length) {
				currentChoice = 0;

			}

		}
		if (Keys.isFirstPress(ENTER)) {
			selective();
		}
	}

	public void selective() {
		if (currentChoice == 0) {
			gsm.setState(GameStateManager.LEVEL1STATE);
		}
		if (currentChoice == 1) {
			gsm.setState(GameStateManager.HIGHSCORESTATE);
		}
		if (currentChoice == 2) {
			System.exit(0);
		}
	}

}
