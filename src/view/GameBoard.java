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
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
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
    JMenuItem savegame;
    JMenuItem loadgame;
    
    
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
        
        savegame = new JMenuItem("Save Game");
        savegame.addActionListener(this);
        
        loadgame = new JMenuItem("Load Game");
        loadgame.addActionListener(this);
        
        menu.add(newgame);
        menu.add(savegame);
        menu.add(loadgame);
        
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
    @SuppressWarnings("empty-statement")
    public void update(Observable o, Object arg) {
        boolean findujeu = false;
        
        for(int i = 0; i < sizeX; i++){
            for(int j = 0; j< sizeY; j++){
                if(this.game.isValid(i, j, game.getPlayer(game.getCurrentplayer()))){
                    this.squares[i][j].setBackground(Color.blue);
                }
                else{
                    this.squares[i][j].setBackground(Color.yellow);
                }
                
                squares[i][j].validate();
                squares[i][j].repaint();   
            }
        }
      
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
            if(e.getSource() == newgame){
            
            this.setVisible(false);
            this.game.initBoard();
            GameBoard gameboard = new GameBoard(game.getBoard(),game);
            gameboard.setVisible(true);
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
            
            if(e.getSource() == savegame){
                gameboard.save();
                JOptionPane.showMessageDialog(rootPane, "The game has been saved"); 
                
            }
            
            if(e.getSource() == loadgame){
                this.setVisible(false);
                 GameBoard gameboard;
                 Game game = new Game();
                 this.game.initBoard();
                 String nomfichier = "sauvegarde.txt";
                try {
                    game.setBoard(new Board(nomfichier));
                } catch (IOException ex) {
                    Logger.getLogger(GameBoard.class.getName()).log(Level.SEVERE, null, ex);
                }
                 gameboard = new GameBoard(game.getBoard(),game);
                 gameboard.setVisible(true);
                 gameboard.update(gameboard.gameboard, gameboard);
            }
    
    
    }
    
    
}
    
