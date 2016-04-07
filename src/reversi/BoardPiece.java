/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reversi;

import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author Malomek
 */
public class BoardPiece extends Observable{
    
    int content;
    private Observer obs;

    public BoardPiece(int content) {
        this.content = content;
    }
    public BoardPiece() {
        this.content=0;
    }

    public int getContent() {
        return content;
    }
    public void setContent(int content) {
        this.content = content;
    }
    
    
    public void callUpdate(){
        this.setChanged();
        this.notifyObservers();
    }
    
    
    
    
}
