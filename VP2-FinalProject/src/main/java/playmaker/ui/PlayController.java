/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package playmaker.ui;

import playmaker.model.PlayModel;

/**
 *
 * @author carl
 */
public class PlayController extends javax.swing.JPanel {
    private PlayModel currentPlay;
    /**
     * Creates new form PlayController
     */
    public PlayController() {
        this.currentPlay = PlayModel.getInstance();
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlblHeader = new javax.swing.JLabel();
        btnPlayPause = new javax.swing.JButton();
        btnEmpty = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnLoad = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();

        jlblHeader.setText("Play Controls");

        btnPlayPause.setText("Play");
        btnPlayPause.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlayPauseActionPerformed(evt);
            }
        });

        btnEmpty.setText("Empty");
        btnEmpty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmptyActionPerformed(evt);
            }
        });

        btnSave.setText("Save Play");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnLoad.setText("Load Play");
        btnLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadActionPerformed(evt);
            }
        });

        btnReset.setText("Reset All");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlblHeader)
                .addGap(23, 23, 23))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnEmpty)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(btnPlayPause))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSave)
                            .addComponent(btnLoad)
                            .addComponent(btnReset))))
                .addGap(13, 13, 13))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlblHeader)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPlayPause, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEmpty)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnReset)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSave)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLoad)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnPlayPauseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlayPauseActionPerformed
        
        if (btnPlayPause.getText() == "Play") {
            currentPlay.movePlayers();
            btnPlayPause.setText("Pause");
        } else {
            currentPlay.stopPlayers();
            btnPlayPause.setText("Play");
        }
    }//GEN-LAST:event_btnPlayPauseActionPerformed

    private void btnEmptyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmptyActionPerformed
        currentPlay.emptyPlay();
    }//GEN-LAST:event_btnEmptyActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        currentPlay.resetPlayers();
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        currentPlay.savePlay();
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadActionPerformed
        currentPlay.loadPlay();
    }//GEN-LAST:event_btnLoadActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEmpty;
    private javax.swing.JButton btnLoad;
    private javax.swing.JButton btnPlayPause;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel jlblHeader;
    // End of variables declaration//GEN-END:variables

}
