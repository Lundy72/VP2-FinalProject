/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package playmaker.model;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.Serializable;
import playmaker.ui.PlayAreaHandler;

/**
 *
 * @author carl
 */
public class DPlayer extends Player implements Serializable{
    
    public DPlayer(int x, int y, PlayAreaHandler handler) {
        this.playerX = x;
        this.playerY = y - (y % 20);
        path = new Path();
        side = "defense";
        listener = handler;
    }
    
    @Override
    public void paint(Graphics2D g2){
        g2.setStroke(new BasicStroke(4));
        
        // Drawing X shape for defensive player
        g2.setColor(color);
        g2.drawLine((int)(playerX - halfW), (int)(playerY - halfH), (int)(playerX + halfW), (int)(playerY + halfH));
        g2.drawLine((int)(playerX - halfW), (int)(playerY + halfH), (int)(playerX + halfW), (int)(playerY - halfH));
    }
    
}
