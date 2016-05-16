/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package reversi.players;

import java.util.Random;
import java.util.Vector;
import reversi.Board;
import reversi.Game;
import reversi.Move;
import reversi.Player;

/**
 *
 * @author p1307887
 */
public class MinMax extends Player {

    
    
    public MinMax(int numPlayer) {
        super(numPlayer);
    }
 
    
    
    //tableau des valeurs des positions
    private final int[][] tabEval = {{8,-2,3,3,3,3,-2,8},{-2,1,2,2,2,2,1,-2},{3, 2, 1, 1, 1, 1, 2, 3},{3, 2, 1, 1, 1, 1, 2, 3},{3, 2, 1, 1, 1, 1, 2, 3},{3, 2, 1, 1, 1, 1, 2, 3},{-2, 1, 2, 2, 2, 2, 1,-2},{8,-2, 3, 3, 3, 3,-2, 8}};


    
    //fonction d'évaluation
    public int eval(int x, int y, int player, Board board) {

        int eval = 0;
        int pos = 0;        
        pos = tabEval[x][y]; 
        eval=200*pos;
        return eval;
    }
    
    
    
    
    public Move minMaxPlay (Game game)
        {
            Vector<Move> possibilities = this.possibilities(game);
            int score = 0;
            int eval = 0;
            
            if(possibilities.isEmpty()){
                return null;
            }
            
            //initialisation du bestMov sur une valeurs random
            Random randomGenerator = new Random();
            int randomInt = randomGenerator.nextInt(possibilities.size());                
            Move bestMov = new Move(possibilities.get(randomInt).getX(),possibilities.get(randomInt).getY());
            
            //pour chaque possibilité, test des possiblités de l'adversaire et bestMov devient celle qui rapporte le moins de points a l'adversaire             
            for (int k=0; k<possibilities.size(); k++){
                Board subBoard = game.getBoard().clone();
                game.mouvementAction(bestMov, this, subBoard);
                Vector<Move>posAdverse = game.getPlayer(this.getOpponent()).possibilities(game);
                for (int l=0; l<posAdverse.size(); l++){
                    eval = eval(posAdverse.get(l).getX(),posAdverse.get(l).getY(), this.getOpponent(), subBoard);
                
                if (score>eval) {
                    score = eval ;
                    bestMov.setX(possibilities.get(k).getX());
                    bestMov.setY(possibilities.get(k).getY());
                }
                }    
            }
            this.play(bestMov.getX(), bestMov.getY(), game);
            return bestMov;
   
}
}
