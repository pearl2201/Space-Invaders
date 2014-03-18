/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Main;

import javax.swing.JFrame;

/**
 *
 * @author pearl
 */
public class Game {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        JFrame gameF = new JFrame("Space Invader");
        gameF.setContentPane(new GamePanel());
        gameF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameF.setResizable(false);
        gameF.pack();
        gameF.setVisible(true);
    }
    
}
