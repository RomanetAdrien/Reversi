/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reversi.players;

import java.util.Vector;
import reversi.Game;
import reversi.Move;
import reversi.Player;

/**
 *
 * @author Malomek
 */
public class AlphaBeta extends Player{
    
    public AlphaBeta(int numplayer){
        super(numplayer);
    }
    
    
    public void IAplay(Game game){
        
      Vector<Move> possibilities = this.possibilities(game);
     if(possibilities.isEmpty()){
         return;
     }
    }
    
}
