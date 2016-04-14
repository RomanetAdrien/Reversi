
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
   Board board = game.initBoard();
   //Board board = new Board(8,8);
   GameBoard gameboard = new GameBoard(board, game);
   gameboard.render();
   //game.displayBoard();
   Player player1 = new Player(1); 
   Player player2 = new Player(2);
   
   int[] counter = game.count();
   while (counter[0]+counter[1]<64){
       System.out.println(game.getCurrentplayer());
       game.turn(player1);
       game.turn(player2);
   }
           
    }
    
}
