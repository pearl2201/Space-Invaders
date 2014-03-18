/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameStateManager;

import Background.Background;
import Entities.Score;
import Entities.ScoreIO;
import Handler.FontConvert;
import Handler.ImageLoader;
import Handler.Keys;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 *
 * @author pearl
 */
public class HighScoreState extends GameState {

    private Background bg;

	private static final BufferedImage logo = ImageLoader.logo;
    private Score[] player;
    public HighScoreState(GameStateManager gsm) {
        super(gsm);
        init();
    }

    @Override
    public void init() {

        bg = new Background();
        
        ScoreIO.instance.readScore();
        player = ScoreIO.instance.getPlayers();
    }

    @Override
    public void update() {
    	handleInput();
    }

    @Override
    public void draw(Graphics2D g) {
        bg.draw(g);

		g.drawImage(logo, 150, 10, null);
        int i =0;
        for (; i< player.length; i++)
        {
        	g.drawImage(FontConvert.convertString2Image(player[i].getPlayer(), false), 210,200+ i*40, null);
        	g.drawImage(FontConvert.convertString2Image(Integer.toString(player[i].getScore()), false), 
        			240 + FontConvert.convertString2Image(player[i].getPlayer(), false).getWidth() ,200+ i*40, null);
            
        	
        }
        g.drawImage(FontConvert.convertString2Image("Press ESC to return Menu Screen", true), 120,240+ i*40, null);
    	
        
        
        
    }

    @Override

    public void handleInput() {
    	
    	if (Keys.isPress(Keys.ESC))
    	{
    		gsm.setState(GameStateManager.MENUSTATE);
    	}

    }

}
