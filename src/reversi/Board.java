/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reversi;

import java.util.Observable;

/**
 *
 * @author Malomek
 */
public class Board extends Observable{
    BoardPiece[][] board;
    int sizeX;
    int sizeY;

    public Board(int sizeX, int sizeY) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.board = new BoardPiece[sizeX][sizeY];
        
        for(int i=0;i<sizeX;i++){
            for(int j=0;j<sizeY;j++){
                this.board[i][j]= new BoardPiece();
            }
        }
    }

    public BoardPiece[][] getBoard() {
        return board;
    }
    public void setBoard(BoardPiece[][] board) {
        this.board = board;
    }
    public int getSizeX() {
        return sizeX;
    }
    public void setSizeX(int sizeX) {
        this.sizeX = sizeX;
    }
    public int getSizeY() {
        return sizeY;
    }
    public void setSizeY(int sizeY) {
        this.sizeY = sizeY;
    }
    
    public BoardPiece getSquare(int x, int y){
        return this.board[x][y];
    }
    
    public void callUpdate(){
        this.setChanged();
        this.notifyObservers();
    }
    
    
    
}
