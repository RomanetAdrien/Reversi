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
public class Game {
    
    
    private int[][] board = new int[8][8];
    
    
    public void initBoard(){
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[i].length; j++)
                board[i][j]=0;
        }
        board[3][3]=1;
        board[4][4]=1;
        board[4][3]=2;
        board[3][4]=2;
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
    
    
    
}
