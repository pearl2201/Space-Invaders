package Entities;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ScoreIO {

	public static ScoreIO instance = new ScoreIO();
	
	private static final String path = "/Resources/Score/score.txt";
	private static Score[] players = new Score[3];
	
	
	public Score[] getPlayers() {

		for (int i = 0; i < players.length; i++) {
			if (players[i] == null) {
				players[i] = new Score(0, "Anh Ngoc");
			}
		}
		return players;
	}

	
	public Score[] readScore() {
		players = getPlayers();
		/**
		try {
			ObjectInputStream in = new ObjectInputStream(
					new BufferedInputStream(
							ScoreIO.class
									.getResourceAsStream("/Score/score.txt")));
			for (int i = 0; i < players.length; i++) {
				players[i] = (Score) in.readObject();
			}
			in.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		**/
		return players;

	}

	public void writeScore() {
		
		System.out.println("Ghi pplayer ");
		try {

			File testFile = new File("");
			String currentPath = testFile.getAbsolutePath() + path;
			ObjectOutputStream out = new ObjectOutputStream(
					new FileOutputStream(currentPath));
			for (int i = 0; i < 3; i++) {
				out.writeObject(players[i]);
				System.out.println("player " + i +" :" + players[i].getPlayer() + " " +players[i].getScore());
				
			}
			out.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void swap(Score p1, Score p2)
	{
		p1.setPlayer(p2.getPlayer());
		p1.setScore(p2.getScore());
	}
	public void addPlayer() {

		Score tempP = new Score(0,"Anh Ngoc");
		Score newP = Score.instance;
		players= getPlayers();
		for (int i = 0; i < players.length; i++) {
			if (newP.getScore() > players[i].getScore()) {
				swap(tempP, players[i]);
				swap(players[i],newP);
				swap(newP, tempP);
							
			}
			for (int j =0; j<players.length; j++)
			{
				System.out.println("players["+j+"] " + players[j].getPlayer() + " " + players[j].getScore());
				
			}
		}
		
		this.writeScore();
	}
}
