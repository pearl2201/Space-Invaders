/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameStateManager;

import GameStateManager.LevelState.Level3State;
import GameStateManager.LevelState.Level2State;
import GameStateManager.LevelState.Level4State;
import GameStateManager.LevelState.Level1State;
import GameStateManager.LevelState.LevelFinalState;
import java.awt.Graphics2D;

/**
 *
 * @author pearl
 */
public class GameStateManager {

    private GameState[] gameState;
    private int currentState;
    private int oldState;
    private int numsGameState = 10;
    public static final int MENUSTATE = 0;
    public static final int LEVEL1STATE = 1;
    public static final int LEVEL2STATE = 2;
    public static final int LEVEL3STATE = 3;
    public static final int LEVEL4STATE = 4;
    public static final int LEVELFINALSTATE = 6;
    public static final int PAUSEDSTATE = 7;
    public static final int HIGHSCORESTATE = 8;
    public static final int FINALGAMESTATE = 9;


    public GameStateManager() {
        gameState = new GameState[numsGameState];
        currentState = MENUSTATE;
        loadState(currentState);

    }

    public void loadPausedState()
    {
        oldState = currentState;
        currentState = PAUSEDSTATE;
        loadState(PAUSEDSTATE);
    }
    
    public void unPausedState()
    {
        unloadState(currentState);
        currentState = oldState ;
    }
    
    
    public void loadState(int state) {
        if (state == MENUSTATE) {
            gameState[state] = new MenuState(this);
        }
        if (state ==  LEVEL1STATE) {

            gameState[state] = new Level1State(this);

        }
        if (state == LEVEL2STATE) {

            gameState[state] = new Level2State(this);

        }
        if (state == LEVEL3STATE) {

            gameState[state] = new Level3State(this);

        }
        if (state == LEVEL4STATE) {

            gameState[state] = new Level4State(this);

        }
        if (state == LEVELFINALSTATE) {

            gameState[state] = new LevelFinalState(this);

        }
        
         if (state == PAUSEDSTATE) {

            gameState[state] = new PausedState(this);

        }
         

         if (state == HIGHSCORESTATE) {

            gameState[state] = new HighScoreState(this);

        }


         if (state == FINALGAMESTATE) {

            gameState[state] = new FinalGameState(this);

        }
    }

    public void unloadState(int state) {
        gameState[state] = null;
    }

    public void setState(int state) {
        unloadState(currentState);
        currentState = state;
        loadState(state);
    }

    public void update() {
        try {
            gameState[currentState].update();

        } catch (Exception e) {
        }

    }

    public void draw(Graphics2D g) {
        
        try {
            gameState[currentState].draw(g);

        } catch (Exception e) {
        }
    }


}
