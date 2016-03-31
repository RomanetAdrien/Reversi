/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.BorderLayout;
import java.awt.Color;
import static java.awt.Color.BLACK;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author Malomek
 */
public class Square extends JPanel{
    
    public int[] id;
    
    
    public Square(int x, int y){
        super();
        this.id= new int[2];
        this.id[0]=x;
        this.id[1]=y;
        
        setBackground(Color.yellow);
        setLayout(new BorderLayout());
        
    }
    
    @Override
    protected void paintComponent(Graphics g) { 
    int h = getHeight();
    int w = getWidth();
    super.paintComponent(g); 
    g.setColor(BLACK);
    g.fillOval(0, 0, w, h); 
} 
    
}
