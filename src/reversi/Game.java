/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package reversi;


import java.util.Scanner;
import java.util.Vector;

/**
 *
 * @author p1307887
 */
public class Game {
    
    
    private Board board;
    private int[] counter = new int[2];
    private Vector<Player> players;
    private int currentplayer;

    
  /*  public void initBoard2(){
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[i].length; j++)
                board.getSquare(i, j).content=0;
        }
        board[3][3]=1;
        board[4][4]=1;
        board[4][3]=2;
        board[3][4]=2;
        counter[0]=2;
        counter[1]=2;
    }*/
    
    public Board initBoard(){
        Board board = new Board(8,8);
        this.players = new Vector<Player>();
        this.players.add(new Human(1));
        this.players.add(new Human(2));

        board.getSquare(3, 3).setContent(1);
        board.getSquare(4, 4).setContent(1);
        board.getSquare(4, 3).setContent(2);
        board.getSquare(3, 4).setContent(2);
        
        this.counter[0]=2;
        this.counter[1]=2;
        this.currentplayer=1;
        
        this.board = board;
        return this.board;
    }
    
    public void displayBoard(){
        for(int i=0; i<board.sizeX; i++) {
            System.out.println();
            for(int j=0; j<board.sizeY; j++)
                System.out.print(" " + board.getSquare(i,j).getContent() +" ");
        }
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    
    public Vector getPlayers() {
        return players;
    }
    
    public Player getPlayer(int i){
        return this.players.get(i-1);
    }

    public void setPlayers(Vector players) {
        this.players = players;
    }

    public int getCurrentplayer() {
        return currentplayer;
    }

    public void setCurrentplayer(int currentplayer) {
        this.currentplayer = currentplayer;
    }
    
    
    public void nextplayer(){
        this.getPlayer(currentplayer).resetplayer();
        if(this.currentplayer==1){
            this.currentplayer=2;
        }
        else{
            this.currentplayer=1;
        }
    }
    
    
    
    public int check(Player player, int x, int y, int incx ,int incy, boolean set){
        int opponent=player.getOpponent();
        int n_inc=0;
        if (board.getSquare(x, y).content!=0) return 0;
        x+=incx; y+=incy;
        if((x>=8) && (x<0) && (y>=8) && (y<0)) return 0;
        while ((x<8) && (x>=0) && (y<8) && (y>=0) && (board.getSquare(x, y).content==opponent)) {
			x+=incx; y+=incy;
			n_inc++;
		}
        if ((x<8) && (x>=0) && (y<8) && (y>=0) && (board.getSquare(x, y).content==player.getNumPlayer())) {
			
                        for (int j = 0 ; j < n_inc ; j++) {
				x-=incx; y-=incy;
				if(board.getSquare(x, y).content==1) board.getSquare(x, y).content=2;
                                else if (board.getSquare(x, y).content==2) board.getSquare(x, y).content=1;
			}
                        board.getSquare(x-incx, y-incy).content=player.getNumPlayer();
                        return n_inc;
		}
		return 0;
    }
    
    public void isValid(Move move, Player player){
        check(player,move.getX(),move.getY(),1,0,true);
        check(player,move.getX(),move.getY(),-1,0,true);
        check(player,move.getX(),move.getY(),0,1,true);
        check(player,move.getX(),move.getY(),0,-1,true);
        check(player,move.getX(),move.getY(),1,1,true);
        check(player,move.getX(),move.getY(),-1,1,true);
        check(player,move.getX(),move.getY(),1,-1,true);
        check(player,move.getX(),move.getY(),-1,-1,true);       
    }
    
    public int[] count(){
        
        for(int i=0; i<board.sizeX; i++) {
            for(int j=0; j<board.sizeY; j++)
                if(board.getSquare(i, j).content==1){
                    counter[0]++;
                }
                else if(board.getSquare(i, j).content==2){
                    counter[1]++;
                }            
        }
        return counter;
        
    }
    
    public void turn(Player player,int x,int y){
        
        while(!player.isHasplayed()){
            
        }
        Move move = new Move(x,y);
        isValid(move,player);

    }

    public int[] getCounter() {
        return counter;
    }
    
   
    /*public boolean testEndGame(){        
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[i].length; j++)
                if (board.getSquare(i, j).content==0){
                    Move move = new Move(i,j);                    
                    if (isValid(move,new Player(1))) return false;
                    if (isValid(move,new Player(2))) return false;
                };
        }        
        return true;
    }*/
    
    public void victory(){
        count();
        System.out.println("player 1 score :" + counter[0] );
        System.out.println("player 2 score :" + counter[1] );
        if (counter[0]<counter[1]) System.out.println("player 2 Win" );
        else if (counter[1]<counter[0]) System.out.println("player 1 Win" );
        else System.out.println("equality" );
    }
    
}
