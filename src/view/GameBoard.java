/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.Border;
import reversi.Board;
import reversi.Game;

/**
 *
 * @author Malomek
 */
public class GameBoard extends JFrame implements Observer, ActionListener{
    
    Board gameboard;
    Game game;
    int sizeX;
    int sizeY;
    
    Square[][] squares;
    
    JMenuItem newgame;
    
    
    public GameBoard(Board board, Game game){
        this.game=game;
        this.gameboard=board;
        this.sizeX=board.getSizeX();
        this.sizeY=board.getSizeY();
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Reversi");
        setSize(sizeX*38, sizeY*38 + 30);
        
        JMenuBar menubar = new JMenuBar();
        JMenu menu = new JMenu("Game");
        JMenu options = new JMenu("Colors");
        
        newgame = new JMenuItem("New Game");
        newgame.addActionListener(this);
        
        menu.add(newgame);
        
        menubar.add(menu);
        setJMenuBar(menubar);
        
        
        JComponent jc = new JPanel (new GridLayout(sizeY, sizeX));
        Border limite = BorderFactory.createLineBorder(Color.black,1);
        
        squares = new Square[sizeX][sizeY];
        
        for(int i = 0; i < sizeX; i++){
            for(int j = 0; j< sizeY; j++){
                Square s = new Square(i,j,this);
                board.getSquare(i, j).addObserver(this);
                squares[i][j]=s;
                s.setBorder(limite);
                jc.add(s);
            }
        }  
       // squares[1][1].paintComponent(Graphics g);
        //squares[1][1].setBackground(Color.red);
        
                
        jc.setBorder(limite);
        add(jc);
        setContentPane(jc);
        gameboard.addObserver(this);
    }
    
    public void render(){
        this.setVisible(true);
    }

    @Override
    public void update(Observable o, Object arg) {
        
        boolean findujeu = false;
        
        for(int i = 0; i < sizeX; i++){
            for(int j = 0; j< sizeY; j++){
                squares[i][j].validate();
                squares[i][j].repaint();
            }
        }
        
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
            if(e.getSource() == newgame){
            this.setVisible(false);
            
            
            Board board = new Board(8,8);
            GameBoard gameboard = new GameBoard(board, game);
            gameboard.setVisible(true);
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
        }
    
    
    }
    
    
}
