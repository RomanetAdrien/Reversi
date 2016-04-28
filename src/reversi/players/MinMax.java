/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reversi.players;


import java.util.Random;
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
            
            if(possibilities.isEmpty()){
                return null;
            }
            
            Move bestMov = new Move(0,0);
            
            
             
            for (int k=0; k<possibilities.size(); k++){
                eval = game.eval(possibilities.get(k).getX(),possibilities.get(k).getY(), MinMax.this.getNumPlayer());
                
                if (score<eval) {
                    score = eval ;
                    bestMov.setX(possibilities.get(k).getX());
                    bestMov.setY(possibilities.get(k).getY());
                }
                else{
                    Random randomGenerator = new Random();
                    int randomInt = randomGenerator.nextInt(possibilities.size());
                    bestMov.setX(possibilities.get(randomInt).getX());
                    bestMov.setY(possibilities.get(randomInt).getY());
                }
            }
            this.play(bestMov.getX(), bestMov.getY(), game);
            return bestMov;
   
}

    
}
