/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reversi.players;

import java.util.Random;
import java.util.Vector;
import javax.swing.JOptionPane;
import reversi.Game;
import reversi.Move;
import reversi.Player;

/**
 *
 * @author Malomek
 */
public class IAbronze extends Player{
    
    public IAbronze(int numPlayer) {
        super(numPlayer);
    }
    
    
    
    public void IAplay(Game game){
        
     Vector<Move> possibilities = this.possibilities(game);
     if(possibilities.isEmpty()){
         return;
     }
     Random randomGenerator = new Random();
     int randomInt = randomGenerator.nextInt(2);
     int[] decision = new int[2];
     if(randomInt==1){
        decision[0]=possibilities.firstElement().getX();
        decision[1]=possibilities.firstElement().getY(); 
     }
     else{
        decision[0]=possibilities.lastElement().getX();
        decision[1]=possibilities.lastElement().getY();
     }
     this.setDecision(decision);
     this.play(decision[0], decision[1], game);
    }
    
}
