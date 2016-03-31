/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package reversi;

import java.util.Scanner;

/**
 *
 * @author p1307887
 */
public class Reversi {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Game game = new Game();
        game.initBoard();
        game.displayBoard();
        int[] counter = new int[2];
        Player player1 = new Player(1);
        Player player2 = new Player(2);
        
        do{
            counter = game.count();
            game.turn(player1);
            game.turn(player2);
            
        }while(counter[0]+counter[1]<64);
       
    }
}
    

