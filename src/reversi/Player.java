/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package reversi;

/**
 *
 * @author p1307887
 */
public class Player {
    
    
    private int numPlayer;
    private int opponent;

    public Player( int numPlayer) {        
        this.numPlayer = numPlayer;
        switch(numPlayer){
            case 1 : this.opponent = 2  ;
                break;
            case 2 : this.opponent = 1;
                break;
        };
    }
 

    public int getNumPlayer() {
        return numPlayer;
    }

    public int getOpponent() {
        return opponent;
    }
    
    
    
    
    
    
}
