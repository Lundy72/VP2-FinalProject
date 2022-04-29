/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package playmaker.ui;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.MouseInfo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;
import playmaker.model.DPlayer;
import playmaker.model.OPlayer;
import playmaker.model.PlayDetails;
import playmaker.model.PlaySerialization;
import playmaker.model.Player;

/**
 *
 * @author carl
 */
public class PlayAreaPanel extends javax.swing.JPanel implements PlayAreaHandler, ActionListener {
    private PlayDetails currentPlay;
    private PlaySerialization playIO;
    private boolean inPlayArea;
    private int cursorX, cursorY;
    private Timer tm = new Timer(33, this); // 33 for ~30 frames a second. 
                                            // The purpose for this timer is to update the drawing of the cursor.
    
    private ToolType toolType = ToolType.OFFENSE;

    public PlayAreaPanel() {
        currentPlay = new PlayDetails();
        inPlayArea = false;
        playIO = new PlaySerialization();
        initComponents();
    }

    @Override
    public void repaintArea() {
        repaint();
    }
    
    public enum ToolType {
        OFFENSE,
        DEFENSE,
        PATH,
        SELECT
    }
    
    public void setToolType(ToolType toolType) {
        this.toolType = toolType;
    }
    
    public void emptyArea() {
        currentPlay.emptyPlay();
        repaint();
    }
    
    public void startPlay() {
        currentPlay.movePlayers();
        repaint();
    }
    
    public void resetPlayers() {
        currentPlay.resetPlayers();
        repaint();
    }
    
    @Override
    public void savePlay() {
        try {
            playIO.savePlay(currentPlay);
        } catch (IOException ex) {
            System.out.println("IO Exception when trying to save play.");
        }
    }
    
    @Override
    public void loadPlay() {
        try {
            currentPlay = playIO.loadPlay();
        } catch (IOException ex) {
            System.out.println("IO Exception when trying to load play.");
        } catch (ClassNotFoundException ex) {
            System.out.println("Class Not Found Exception when trying to load play.");
        }
        
        repaint();
    }
    
    @Override
    public void movePlayer() {
        currentPlay.movePlayer();
        repaint();
    }
    
    @Override
    public void stopPlayer() {
        currentPlay.stopPlayer();
    }
    
    @Override
    public void resetPlayer() {
        currentPlay.resetPlayer();
        repaint();
    }
    
    public void removePlayer() {
        currentPlay.removePlayer();
        repaint();
    }
    
    public void removePlayerPath() {
        currentPlay.removePlayerPath();
        repaint();
    }
    
    public void startCursor() {
        inPlayArea = true;
        tm.start();
        repaint();
    }
    
    public void stopCursor() {
        inPlayArea = false;
        tm.stop();
        repaint();
    }
    
    public void actionPerformed(ActionEvent evt) {
        int mouseX = this.getMousePosition().x;
        int mouseY = this.getMousePosition().y;
        cursorX = mouseX;
        cursorY = mouseY - (mouseY % 20);
        repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        int mouseX = evt.getX();
        int mouseY = evt.getY();
        
        // 
        switch (toolType) {
            case OFFENSE:
                OPlayer tmpOP = new OPlayer(mouseX, mouseY, this);
                currentPlay.addOPlayer(tmpOP);
                break;
                
            case DEFENSE:
                DPlayer tmpDP = new DPlayer(mouseX, mouseY, this);
                currentPlay.addDPlayer(tmpDP);
                break;
                
            case PATH:
                currentPlay.addPathPoint(mouseX, mouseY);
                break;
                
            case SELECT:
                Player clickedPlayer = null;
                
                for(int i = currentPlay.getNumOPlayers()-1; i >= 0 ; i--){
                    OPlayer tmp = currentPlay.getOPlayer(i);
                    if(tmp.pointContainsMe(mouseX, mouseY)){
                        clickedPlayer = tmp;
                        currentPlay.onPlayerClicked(clickedPlayer);
                    break;
                    }
                }
                
                if (clickedPlayer == null) {
                    for(int i = currentPlay.getNumDPlayers()-1; i >= 0 ; i--){
                    DPlayer tmp = currentPlay.getDPlayer(i);
                    if(tmp.pointContainsMe(mouseX, mouseY)){
                        clickedPlayer = tmp;
                        currentPlay.onPlayerClicked(clickedPlayer);
                        break;
                        }
                    }
                }
                break;
                
        }

        repaint();
    }//GEN-LAST:event_formMouseClicked

    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        
        Graphics2D g2 = (Graphics2D) g;
        /* From https://stackoverflow.com/questions/1439022/get-mouse-position (stack overflow... sorry not sorry)
        PointerInfo mouse = MouseInfo.getPointerInfo();
        Point point = new Point(mouse.getLocation()); 
        double mouseX = point.getX();
        double mouseY = point.getY(); */
        
        if ((toolType == ToolType.OFFENSE) && (inPlayArea == true)) {
            g2.setColor(Color.DARK_GRAY);
            g2.setStroke(new BasicStroke(4));
            g2.drawOval(cursorX - 15, cursorY - 15, 30, 30);
        } else if ((toolType == ToolType.DEFENSE) && (inPlayArea == true)) {           
            g2.setStroke(new BasicStroke(4));
            g2.setColor(Color.DARK_GRAY);
            g2.drawLine(cursorX - 15, cursorY - 15, cursorX + 15, cursorY + 15);
            g2.drawLine(cursorX - 15, cursorY + 15, cursorX + 15, cursorY - 15);
        }
        
        currentPlay.drawPlayers(g2);
        currentPlay.drawPaths(g2);
        
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
