/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entities;

import java.io.Serializable;

/**
 *
 * @author pearl
 */
public class Score implements Serializable {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public static Score instance = new Score(0,"Anh Ngoc"); 
	
	public Score(int score, String player) {
		this.score = score;
		this.player = player;
	}

	private int score = 0;
    private String player = "";
    
    public void setPlayer(String name)
    {
    	player = name;
    }
    
    public String getPlayer()
    {
    	return player; 
    }
    
    public void addScore( int s)
    {
        score+=s;
    }
    
    public int getScore()
    {
        return score;
    }
    
    public void setScore(int s)
    {
    	score = s;
    }
    
}
