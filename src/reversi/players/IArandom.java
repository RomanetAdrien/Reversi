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
import java.util.Random;

/**
 *
 * @author Malomek
 */
public class IArandom extends Player{

    public IArandom(int numplayer) {
        super(numplayer);
    }
    
    
    
    public void IAplay(Game game){
        
     Vector<Move> possibilities = this.possibilities(game);
     if(possibilities.isEmpty()){
         return;
     }
     int[] decision = new int[2];
     Random randomGenerator = new Random();
     int randomInt = randomGenerator.nextInt(possibilities.size());
     decision[0]=possibilities.get(randomInt).getX();
     decision[1]=possibilities.get(randomInt).getY();
     
     this.setDecision(decision);
     this.play(decision[0], decision[1], game);
    }
}
