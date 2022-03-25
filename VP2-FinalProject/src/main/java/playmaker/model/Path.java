/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package playmaker.model;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.util.ArrayList;

/**
 *
 * @author carl
 */
public class Path {
    private ArrayList<Integer> pathXPoints;
    private ArrayList<Integer> pathYPoints;
    
    public Path() {
        pathXPoints = new ArrayList<>();
        pathYPoints = new ArrayList<>();
        
    }
    
    public void addXPoint(int x){pathXPoints.add(x);}
    public void addYPoint(int y){pathYPoints.add(y);}
    public int getListSize(){return pathXPoints.size();}
    
    public void paint(Graphics2D g2) {
        g2.setStroke(new BasicStroke(2));
        
        if (pathYPoints.size() > 1) {
            for (int i = 0; i < pathYPoints.size(); ++i) {
                if (i + 1 != pathYPoints.size()) {
                    g2.drawLine(pathXPoints.get(i), pathYPoints.get(i), pathXPoints.get(i+1), pathYPoints.get(i+1));
                }
            }
        }
    }
    
}