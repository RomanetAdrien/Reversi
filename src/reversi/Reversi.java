

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package reversi;

import java.util.logging.Level;
import java.util.logging.Logger;
import view.GameBoard;

/**
 *
 * @author p1307887
 */
public class Reversi {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here
            Game.run();
        } catch (InterruptedException ex) {
            Logger.getLogger(Reversi.class.getName()).log(Level.SEVERE, null, ex);
        }
           
    }
    
}

