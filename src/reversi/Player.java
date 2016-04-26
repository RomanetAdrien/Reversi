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
    private boolean hasplayed;
    private int[] decision;

    public Player( int numPlayer) {        
        this.numPlayer = numPlayer;
        this.hasplayed=false;
        this.decision= new int[2];
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

    public boolean isHasplayed() {
        return hasplayed;
    }

    public void setHasplayed(boolean hasplayed) {
        this.hasplayed = hasplayed;
    }

    public int[] getDecision() {
        return decision;
    }

    public void setDecision(int[] decision) {
        this.decision = decision;
    }
    
    public void resetplayer(){
        this.hasplayed=false;
        this.decision= new int[2];
    }
    
      
    public void play(int x, int y, Game game){
        while(!this.isHasplayed()){
            
        }
        Move move = new Move(x,y);
        game.isValid(move,this);

    }
    
}
