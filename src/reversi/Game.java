/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reversi;


import reversi.players.Human;
import java.util.Scanner;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import reversi.players.IAbronze;
import reversi.players.IArandom;
import reversi.players.IAsilver;
import reversi.players.MinMax;
import view.GameBoard;

/**
 *
 * @author p1307887
 */
public class Game {

    private Board board;
    private int[] counter = new int[2];
    private Vector<Player> players;
    private int currentplayer;

    public void initBoard() {
        Board board = new Board(8, 8);
        this.players = new Vector<Player>();
        this.players.add(new Human(1));
        this.players.add(new Human(2));

        board.getSquare(3, 3).setContent(1);
        board.getSquare(4, 4).setContent(1);
        board.getSquare(4, 3).setContent(2);
        board.getSquare(3, 4).setContent(2);

        this.counter[0] = 2;
        this.counter[1] = 2;
        this.currentplayer = 1;

        this.board = board;

    }

    public static void run() throws InterruptedException {
        Game game = new Game();
        game.initBoard();
        boolean cursor = true;

        GameBoard gameboard = new GameBoard(game.getBoard(), game);
        gameboard.render();
        Player player1 = new Player(1);
        game.players.add(player1);
        IAbronze playerbronze = null;
        IArandom playerrandom = null;
        IAsilver playersilver = null;
        MinMax playerminmax = null;
        String choixdujoueur;
        int choix;
        String Texte = "Choisissez votre adversaire : \n";
        Texte += "1 : Humain \n";
        Texte += "2 : IArandom \n";
        Texte += "3 : IAbronze \n";
        Texte += "4 : IAsilver\n";
        Texte += "5 : MinMax";
        do {
            choixdujoueur = JOptionPane.showInputDialog(Texte);
            choix = Integer.parseInt(choixdujoueur);
        } while (choix != 1 && choix != 2 && choix != 3 && choix != 4 && choix != 5);
        switch (choix) {
            case 1:
                Player player2 = new Player(2);
                game.players.add(player2);
                break;

            case 3:
                playerbronze = new IAbronze(2);
                game.players.add(playerbronze);
                break;

            case 2:
                playerrandom = new IArandom(2);
                game.players.add(playerrandom);
                break;
                
            case 4:
                playersilver = new IAsilver(2);
                game.players.add(playersilver);
                break;
                
            case 5:
                playerminmax = new MinMax(2);
                game.players.add(playerminmax);
                break;
        }

        int[] counter = game.count();
        while (game.testEndGame(game.getCurrentplayer())) {
            game.board.callUpdate();
            System.out.println(game.getCurrentplayer());

            if (choix == 1 || game.getCurrentplayer() == 1) {
                game.getPlayer(game.getCurrentplayer()).play(game);
                if (game.getPlayer(game.getCurrentplayer()).isHasplayed()) {
                }
            } else {
                switch (choix) {
                    case 3:
                        playerbronze.IAplay(game);
                        break;
                    case 2:
                        playerrandom.IAplay(game);
                        break;                        
                    case 4:
                        playersilver.minMaxPlay(game);
                        break;
                    case 5:
                        playerminmax.minMaxPlay(game);
                        break;
                }

            }

        }
        game.victory();
    }

    public void displayBoard() {
        for (int i = 0; i < board.sizeX; i++) {
            System.out.println();
            for (int j = 0; j < board.sizeY; j++) {
                System.out.print(" " + board.getSquare(i, j).getContent() + " ");
            }
        }
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public void rewriteBoard(Board board) {
        this.board.rewrite(board);
    }  

    public void nextplayer() {
        this.getPlayer(currentplayer).resetplayer();
        if (this.currentplayer == 1) {
            this.currentplayer = 2;
        } else {
            this.currentplayer = 1;
        }
    }

    public int check(Player player, int x, int y, int incx, int incy, boolean set) {
        int opponent = player.getOpponent();
        int n_inc = 0;
        if (board.getSquare(x, y).content != 0) {
            return 0;
        }
        x += incx;
        y += incy;
        if ((x >= 8) && (x < 0) && (y >= 8) && (y < 0)) {
            return 0;
        }
        while ((x < 8) && (x >= 0) && (y < 8) && (y >= 0) && (board.getSquare(x, y).content == opponent)) {
            x += incx;
            y += incy;
            n_inc++;
        }
        if ((x < 8) && (x >= 0) && (y < 8) && (y >= 0) && (board.getSquare(x, y).content == player.getNumPlayer())) {

            return n_inc;
        }
        return 0;
    }

    public boolean isValid(int x, int y, Player player) {
        Move move = new Move(x, y);
        return this.isValid(move, player);
    }

    public boolean isValid(Move move, Player player) {
        if (check(player, move.getX(), move.getY(), 1, 0, true) != 0) {
            return true;
        }
        if (check(player, move.getX(), move.getY(), -1, 0, true) != 0) {
            return true;
        }
        if (check(player, move.getX(), move.getY(), 0, 1, true) != 0) {
            return true;
        }
        if (check(player, move.getX(), move.getY(), 0, -1, true) != 0) {
            return true;
        }
        if (check(player, move.getX(), move.getY(), 1, 1, true) != 0) {
            return true;
        }
        if (check(player, move.getX(), move.getY(), -1, 1, true) != 0) {
            return true;
        }
        if (check(player, move.getX(), move.getY(), 1, -1, true) != 0) {
            return true;
        }
        if (check(player, move.getX(), move.getY(), -1, -1, true) != 0) {
            return true;
        }
        return false;
    }

    public int[] count() {

        for (int i = 0; i < board.sizeX; i++) {
            for (int j = 0; j < board.sizeY; j++) {
                if (board.getSquare(i, j).content == 1) {
                    counter[0]++;
                } else if (board.getSquare(i, j).content == 2) {
                    counter[1]++;
                }
            }
        }
        return counter;

    }

    public void turn(Player player) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        Move move = new Move(x, y);
        if (isValid(move, player)) {
            mouvementAction(move, player, board);
            displayBoard();
        } else {
            System.out.println("case incorrecte, reessayez");
            turn(player);
        }

    }

    public void turn(Move move, Player player) {
        mouvementAction(move, player, board);

    }

    

    public void mouvementAction(Move move, Player player, Board board) {
        action(player, move.getX(), move.getY(), 1, 0,board, true);
        action(player, move.getX(), move.getY(), -1, 0,board, true);
        action(player, move.getX(), move.getY(), 0, 1,board, true);
        action(player, move.getX(), move.getY(), 0, -1,board, true);
        action(player, move.getX(), move.getY(), 1, 1,board, true);
        action(player, move.getX(), move.getY(), -1, 1,board, true);
        action(player, move.getX(), move.getY(), 1, -1,board, true);
        action(player, move.getX(), move.getY(), -1, -1,board, true);

        this.nextplayer();
    }

    public void action(Player player, int x, int y, int incx, int incy, Board board, boolean set) {
        int opponent = player.getOpponent();
        int n_inc = 0;
        

        x += incx;
        y += incy;

        while ((x < 8) && (x >= 0) && (y < 8) && (y >= 0) && (board.getSquare(x, y).content == opponent)) {
            x += incx;
            y += incy;
            n_inc++;
        }
        if ((x < 8) && (x >= 0) && (y < 8) && (y >= 0) && (board.getSquare(x, y).content == player.getNumPlayer())) {
            for (int j = 0; j < n_inc; j++) {
                x -= incx;
                y -= incy;
                if (board.getSquare(x, y).content == 1) {
                    board.getSquare(x, y).setContent(2);
                } else if (board.getSquare(x, y).content == 2) {
                    board.getSquare(x, y).setContent(1);
                }
            }
            board.getSquare(x - incx, y - incy).setContent(player.getNumPlayer());
        }
    }

    public boolean testEndGame(int numPlayer) {
        Vector<Move> pos1 = this.getPlayer(numPlayer).possibilities(this);
        
        
        if(pos1.isEmpty()){
            return false;
        }
        return true;
    }

    public void victory() {
        count();
        String Texte="";
        Texte+="player 1 score :" + Integer.toString(counter[0])+"\n";
        Texte+="player 2 score :" + Integer.toString(counter[1])+"\n";
        if (counter[0] < counter[1]) {
            Texte +="\n\nPlayer 2 Wins !!!";
        } else if (counter[1] < counter[0]) {
            Texte +="\n\nPlayer 1 Wins !!!";
        } else {
            Texte +="\n\nEquality...";
        }
        JOptionPane.showMessageDialog(null, Texte);
    }

    public int eval(int x, int y, int player, Board board) {

        int eval = 0;
        int pos = 0;
        if (x == 0 & y == 0 || x == 0 & y == board.sizeY-1 || x == board.sizeX-1 & y == 0 || x == board.sizeX-1 & y == board.sizeY-1) {
            pos += 500;
        }
        if (x==0||y==0||x==board.sizeX-1||y==board.sizeY-1) pos+=250;
        
        
        eval=1*pos;

        return eval;
    }
    
    public Vector getPlayers() {
        return players;
    }

    public Player getPlayer(int i) {
        return this.players.get(i - 1);
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
    
    public int[] getCounter() {
        return counter;
    }
}
