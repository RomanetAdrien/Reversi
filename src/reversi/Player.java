/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package reversi;

import java.util.Vector;

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
    
    public Vector possibilities(Game game){
        
        Vector<Move> possibilities = new Vector<Move>();
        Move move;
        for(int i=0;i<game.getBoard().sizeX;i++){
            for(int j=0;j<game.getBoard().sizeY;j++){
                move = new Move(i,j);
                if(game.isValid(move,this)){
                    possibilities.add(new Move(i,j));
                }
            }
        }
        return possibilities;
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
        System.out.println("superman");
        this.decision = decision;
        this.setHasplayed(true);
    }
    
    public void resetplayer(){
        this.hasplayed=false;
        this.decision= new int[2];
    }
    
    
    public void play(Game game){
        if(!hasplayed){
            return;
        }
        System.out.println("wonderwoman");
        this.play(decision[0], decision[1], game);
    }
    
    public void play(int x, int y, Game game){
        
        System.out.println("flash");
        Move move = new Move(x,y);
        if(game.isValid(move,this)){
            System.out.println("batman");
            game.turn(move, this);
        }

    }
    
}
