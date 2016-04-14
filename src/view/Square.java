/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.BorderLayout;
import java.awt.Color;
import static java.awt.Color.BLACK;
import static java.awt.Color.WHITE;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;

/**
 *
 * @author Malomek
 */
public class Square extends JPanel{
    
    public int[] id;
    public GameBoard gameboard;
    
    
    public Square(int x, int y, GameBoard gameboard){
        super();
        this.id= new int[2];
        this.id[0]=x;
        this.id[1]=y;
        this.gameboard=gameboard;
        
        setBackground(Color.yellow);
        setLayout(new BorderLayout());
        
        addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent arg0) {
                super.mouseClicked(arg0);
                if (gameboard.gameboard.getSquare(id[0],id[1]).getContent()==0){}
            }

            @Override
            public void mouseExited(MouseEvent arg0) {
                super.mouseExited(arg0);
                //if (GameBoard.board.getCase(id).getEtat()!=0);
            }

            @Override
            public void mousePressed(MouseEvent arg0) {
                if (arg0.getButton() == 1) {
                   // paintComponent(null,1);
                    
                    getGameboard().game.getPlayer(getGameboard().game.getCurrentplayer()).play(id[0], id[1], getGameboard().game);
                    getGameboard().game.nextplayer();
                } else {
                    
                        
                }
            }
        });
        
    }

    public int[] getId() {
        return id;
    }

    public void setId(int[] id) {
        this.id = id;
    }

    public GameBoard getGameboard() {
        return gameboard;
    }

    public void setGameboard(GameBoard gameboard) {
        this.gameboard = gameboard;
    }
    
    
    public int getContent(){
        return this.gameboard.gameboard.getSquare(id[0], id[1]).getContent();
    }
    
    @Override
    protected void paintComponent(Graphics g) { 
    int h = getHeight();
    int w = getWidth();
    super.paintComponent(g); 
    switch(this.getContent()){
        case 1 :
            g.setColor(BLACK);
            g.fillOval(0, 0, w, h); 
            break;
            
        case 2 :
            g.setColor(WHITE);
            g.fillOval(0, 0, w, h);  
    }
 
    } 
    
        }

