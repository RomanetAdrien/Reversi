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
   
   GameBoard gameboard = new GameBoard(game.getBoard(),8,8);
   gameboard.render();
    }
}
    

