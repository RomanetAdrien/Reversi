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
 * @author SAM
 */
public class MinMax extends Player {
    public MinMax(int numPlayer) {
        super(numPlayer);
    }
    
    public Move minMaxPlay (Game game)
        {
            Vector<Move> possibilities = this.possibilities(game);
            int score = 0;
            int eval = 0;
            
            Move bestMov = null;
            
            
             
            for (int k=0; k<possibilities.size(); k++){
                eval = game.eval(possibilities.get(k).getX(),possibilities.get(k).getY(), MinMax.this.getNumPlayer());
                
                if (score<eval) {
                    score = eval ;
                    bestMov.setX(possibilities.get(k).getX());
                    bestMov.setY(possibilities.get(k).getY());
                }
            }
            return bestMov;
   
}

    
}
