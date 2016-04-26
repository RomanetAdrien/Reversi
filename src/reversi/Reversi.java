
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package reversi;

import view.GameBoard;

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
   //Board board = new Board(8,8);
   game.displayBoard();
   System.out.println("");
   //game.displayBoard();
   Player player1 = new Player(1); 
   Player player2 = new Player(2);
   
   int[] counter = game.count();
   while (counter[0]+counter[1]<64){
       System.out.println("tour du joueur " + game.getCurrentplayer());
       game.turn(player1);
       System.out.println("tour du joueur " + player2.getNumPlayer());
       game.turn(player2);
   }
           
    }
    
}

