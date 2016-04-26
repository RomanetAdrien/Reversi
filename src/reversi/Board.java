/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reversi;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
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
    
    public Board(String nomFichier) throws FileNotFoundException, IOException {
            int i;
            int j;
            byte[] Data;
            FileInputStream fichier = new FileInputStream(new File(nomFichier));
            Data = new byte[100];
            fichier.read(Data);
            this.sizeX=Data[0];
            this.sizeY=Data[1];
            this.board = new BoardPiece[sizeX][sizeY];
            for(i=0; i<sizeX; i++){
                for(j=0;j<sizeY;j++){
                    fichier.read(Data);
                    board[i][j]=new BoardPiece(Data[i*sizeX+j+2]);
                }
            }

    }
    
    public void save(){
        
        try{
            byte[] Data;
            FileOutputStream fichier = new FileOutputStream(new File("sauvegarde.txt"));
            Data = new byte[this.sizeX*this.sizeY+2];
            Data[0]=(byte)this.sizeX;
            Data[1]=(byte)this.sizeY;
            for(int i = 0; i<this.sizeX; i++){
                for(int j = 0; j<this.sizeY; j++){
                    Data[(i*this.sizeX+j)+2]=(byte)board[i][j].getContent();
                }
            }
            fichier.write(Data);
        }
        catch(FileNotFoundException e){
        }
        catch(IOException e){
        }
    }
    
    public void rewrite(Board board){
        this.board=board.getBoard();
        this.sizeX=board.sizeX;
        this.sizeY=board.sizeY;
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
