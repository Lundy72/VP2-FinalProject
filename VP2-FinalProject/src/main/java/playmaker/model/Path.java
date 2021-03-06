/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package playmaker.model;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author carl
 */
public class Path implements Serializable {
    // Need to separate the x and y values in order to draw the path lines more efficiently.
    private ArrayList<Integer> pathXPoints;
    private ArrayList<Integer> pathYPoints;
    
    public Path() {
        pathXPoints = new ArrayList<>();
        pathYPoints = new ArrayList<>();
        
    }
    
    public void addXPoint(int x){pathXPoints.add(x);}
    public void addYPoint(int y){pathYPoints.add(y);}
    public int getListSize(){return pathXPoints.size();}
    
    public ArrayList getPathXPoints() {
        return pathXPoints;
    }
    
    public ArrayList getPathYPoints() {
        return pathYPoints;
    }
    
    public int getStartX() {
        return pathXPoints.get(0);
    }
    
    // Clears the path points but also makes sure to save the first point. Easier to redraw a path this way if need be.
    public void clearPath() {
       int tmpX = this.getStartX();
       int tmpY = this.getStartY();
       pathXPoints.clear();
       pathYPoints.clear();
       pathXPoints.add(tmpX);
       pathYPoints.add(tmpY);
       
    }
    
    public int getStartY() {
        return pathYPoints.get(0);
    }
    
    public void paint(Graphics2D g2) {
        g2.setStroke(new BasicStroke(2));
        g2.setColor(Color.BLACK);
        
        // Essentially, if there's more than two points in the path, then draw a line between each point until you reach the end of the path.
        if (pathYPoints.size() > 1) {
            for (int i = 0; i < pathYPoints.size(); ++i) {
                if (i + 1 != pathYPoints.size()) {
                    g2.drawLine(pathXPoints.get(i), pathYPoints.get(i), pathXPoints.get(i+1), pathYPoints.get(i+1));
                }
            }
        }
    }
}
