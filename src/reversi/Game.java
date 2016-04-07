/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package reversi;

import java.util.Scanner;

/**
 *
 * @author p1307887
 */
public class Game {
    
    
    private int[][] board = new int[8][8];
    private int[] counter = new int[2];
    
    public void initBoard(){
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[i].length; j++)
                board[i][j]=0;
        }
        board[3][3]=1;
        board[4][4]=1;
        board[4][3]=2;
        board[3][4]=2;
        counter[0]=2;
        counter[1]=2;
    }
    
    public void displayBoard(){
        for(int i=0; i<board.length; i++) {
            System.out.println();
            for(int j=0; j<board[i].length; j++)
                System.out.print(" "+board[i][j]+" ");
        }
    }

    public int[][] getBoard() {
        return board;
    }

    public void setBoard(int[][] board) {
        this.board = board;
    }
    
    
    
    public int check(Player player, int x, int y, int incx ,int incy,boolean set){
        int opponent=player.getOpponent();
        int n_inc=0;
        if (board[x][y]!=0) return 0;
        x+=incx; y+=incy;
        if((x>=8) && (x<0) && (y>=8) && (y<0)) return 0;
        while ((x<8) && (x>=0) && (y<8) && (y>=0) && (board[x][y]==opponent)) {
			x+=incx; y+=incy;
			n_inc++;
		}
        if ((x<8) && (x>=0) && (y<8) && (y>=0) && (board[x][y]==player.getNumPlayer())) {
			
                        for (int j = 1 ; j <= n_inc ; j++) {
				x-=incx; y-=incy;
				 if(board[x][y]==1) board[x][y]=2;
                                 else if (board[x][y]==2) board[x][y]=1;
			 }
                        return n_inc;
		}
		return 0;
    }
    
    public boolean isValid(Move move, Player player){
        if( check(player,move.getX(),move.getY(),1,0,true) !=0 ) return true;
        if( check(player,move.getX(),move.getY(),-1,0,true) !=0 ) return true;
        if( check(player,move.getX(),move.getY(),0,1,true) !=0 ) return true;
        if( check(player,move.getX(),move.getY(),0,-1,true) !=0 ) return true;
        if( check(player,move.getX(),move.getY(),1,1,true) !=0 ) return true;
        if( check(player,move.getX(),move.getY(),-1,1,true) !=0 ) return true;
        if( check(player,move.getX(),move.getY(),1,-1,true) !=0 ) return true;
        if( check(player,move.getX(),move.getY(),-1,-1,true) !=0 ) return true;
        return false;
    }
    
    public int[] count(){
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[i].length; j++)
                if(board[i][j]==1){
                    counter[0]++;
                }
                else if(board[i][j]==2){
                    counter[1]++;
                }            
        }
        return counter;
    }
    
    public void turn(Player player){
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        Move move = new Move(x,y);
        isValid(move,player);
        displayBoard();
        testEndGame(player);
    }

    public int[] getCounter() {
        return counter;
    }
    
   
    public boolean testEndGame(Player player){        
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[i].length; j++)
                if (board[i][j]==0){
                    Move move = new Move(i,j);
                    if (!isValid(move,player)) return false;
                };
        }        
        return true;
    }
    
    public void victory(){
        System.out.println("player 1 score :" + counter[0] );
        System.out.println("player 2 score :" + counter[1] );
        if (counter[0]<counter[1]) System.out.println("player 2 Win" );
        else if (counter[1]<counter[0]) System.out.println("player 1 Win" );
        else System.out.println("equality" );
    }
    
}
