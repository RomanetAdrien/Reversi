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
    
    
    private int[][] plateau = new int[8][8];
    
    public void initPlateau(){
        for(int i=0; i<plateau.length; i++) {
            for(int j=0; j<plateau[i].length; j++)
                plateau[i][j]=0;
        }
        plateau[3][3]=1;
        plateau[4][4]=1;
        plateau[4][3]=2;
        plateau[3][4]=2;
    }
    
    public void displayplateau(){
        for(int i=0; i<plateau.length; i++) {
            System.out.println();
            for(int j=0; j<plateau[i].length; j++)
                System.out.print(" "+plateau[i][j]+" ");
        }
    }
    
}
