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
public class PlayerDetails extends javax.swing.JPanel implements PlayListener {
    private PlayModel currentPlay;
    /**
     * Creates new form PlayerDetails
     */
    
    public PlayerDetails() {
        initComponents();
    }
    
    public PlayerDetails(PlayModel currentPlay) {
        this.currentPlay = currentPlay;
        this.currentPlay.addObserver(this);
        initComponents();
        jpanPlayerDetails.setVisible(true);
        jpanScoutView.setVisible(false);
    }
    
    @Override
    public void onUpdate() {
        if (currentPlay.getPlayerChosen() != null) {
            jtfName.setText(currentPlay.getPlayerChosen().getName());
            jtfNum.setText(currentPlay.getPlayerChosen().getNum());
            jtaHabit.setText(currentPlay.getPlayerChosen().getHabit());
            
            jtaJob.setText(currentPlay.getPlayerText());
            for (int i = 0; i < jcbPos.getItemCount(); ++i) {
                if (currentPlay.getPlayerPos() == jcbPos.getItemAt(i)) {
                    jcbPos.setSelectedIndex(i);
                    break;
                }
            }
                
            if (currentPlay.getPlayerChosen().isScoutView()) {
                jpanPlayerDetails.setVisible(false);
                jpanScoutView.setVisible(true);
            } else {
                jpanPlayerDetails.setVisible(true);
                jpanScoutView.setVisible(false);
            }
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlpPlayer = new javax.swing.JLayeredPane();
        jpanPlayerDetails = new javax.swing.JPanel();
        jlblHeader = new javax.swing.JLabel();
        jlblPosition = new javax.swing.JLabel();
        jlblJob = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtaJob = new javax.swing.JTextArea();
        jcbPos = new javax.swing.JComboBox<>();
        btnMovePlayer = new javax.swing.JButton();
        btnResetplayer = new javax.swing.JButton();
        btnRemovePath = new javax.swing.JButton();
        btnRemovePlayer = new javax.swing.JButton();
        btnScoutMode = new javax.swing.JButton();
        jpanScoutView = new javax.swing.JPanel();
        jlblScoutView = new javax.swing.JLabel();
        jlblHabit = new javax.swing.JLabel();
        btnDetailMode = new javax.swing.JButton();
        jlblName = new javax.swing.JLabel();
        jlblNum = new javax.swing.JLabel();
        jtfNum = new javax.swing.JTextField();
        jtfName = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtaHabit = new javax.swing.JTextArea();

        setMinimumSize(new java.awt.Dimension(250, 700));

        jlblHeader.setText("Player Details");

        jlblPosition.setText("Position:");

        jlblJob.setText("Job:");

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jtaJob.setColumns(20);
        jtaJob.setLineWrap(true);
        jtaJob.setRows(5);
        jtaJob.setWrapStyleWord(true);
        jtaJob.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                jtaJobInputMethodTextChanged(evt);
            }
        });
        jtaJob.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtaJobKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtaJobKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(jtaJob);

        jcbPos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<Select>", "QB", "RB", "WR", "TE", "OL", "DB", "LB", "DL" }));
        jcbPos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbPosItemStateChanged(evt);
            }
        });

        btnMovePlayer.setText("Move");
        btnMovePlayer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMovePlayerActionPerformed(evt);
            }
        });

        btnResetplayer.setText("Reset");
        btnResetplayer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetplayerActionPerformed(evt);
            }
        });

        btnRemovePath.setText("Remove Path");
        btnRemovePath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemovePathActionPerformed(evt);
            }
        });

        btnRemovePlayer.setText("Remove Player");
        btnRemovePlayer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemovePlayerActionPerformed(evt);
            }
        });

        btnScoutMode.setText("Scout Mode");
        btnScoutMode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnScoutModeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpanPlayerDetailsLayout = new javax.swing.GroupLayout(jpanPlayerDetails);
        jpanPlayerDetails.setLayout(jpanPlayerDetailsLayout);
        jpanPlayerDetailsLayout.setHorizontalGroup(
            jpanPlayerDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpanPlayerDetailsLayout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(jlblHeader, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                .addGap(72, 72, 72))
            .addGroup(jpanPlayerDetailsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpanPlayerDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jpanPlayerDetailsLayout.createSequentialGroup()
                        .addComponent(jlblJob)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpanPlayerDetailsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnScoutMode)
                .addContainerGap())
            .addGroup(jpanPlayerDetailsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlblPosition)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jcbPos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jpanPlayerDetailsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpanPlayerDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnMovePlayer)
                    .addComponent(btnResetplayer)
                    .addComponent(btnRemovePath)
                    .addComponent(btnRemovePlayer))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpanPlayerDetailsLayout.setVerticalGroup(
            jpanPlayerDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanPlayerDetailsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlblHeader)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpanPlayerDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblPosition)
                    .addComponent(jcbPos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jlblJob)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnMovePlayer)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnResetplayer)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRemovePath)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRemovePlayer)
                .addGap(18, 18, 18)
                .addComponent(btnScoutMode)
                .addContainerGap())
        );

        jlblScoutView.setText("Scout View");

        jlblHabit.setText("Habit/Weaknesses:");

        btnDetailMode.setText("Detail Mode");
        btnDetailMode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetailModeActionPerformed(evt);
            }
        });

        jlblName.setText("Name:");

        jlblNum.setText("Number:");

        jtfNum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfNumActionPerformed(evt);
            }
        });
        jtfNum.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfNumKeyReleased(evt);
            }
        });

        jtfName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfNameKeyReleased(evt);
            }
        });

        jtaHabit.setColumns(20);
        jtaHabit.setLineWrap(true);
        jtaHabit.setRows(5);
        jtaHabit.setWrapStyleWord(true);
        jtaHabit.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtaHabitKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(jtaHabit);

        javax.swing.GroupLayout jpanScoutViewLayout = new javax.swing.GroupLayout(jpanScoutView);
        jpanScoutView.setLayout(jpanScoutViewLayout);
        jpanScoutViewLayout.setHorizontalGroup(
            jpanScoutViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanScoutViewLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpanScoutViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpanScoutViewLayout.createSequentialGroup()
                        .addComponent(jlblNum)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfNum, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jpanScoutViewLayout.createSequentialGroup()
                        .addComponent(jlblHabit)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(jpanScoutViewLayout.createSequentialGroup()
                .addGroup(jpanScoutViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpanScoutViewLayout.createSequentialGroup()
                        .addGroup(jpanScoutViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpanScoutViewLayout.createSequentialGroup()
                                .addGap(83, 83, 83)
                                .addComponent(jlblScoutView))
                            .addGroup(jpanScoutViewLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jlblName)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtfName, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 72, Short.MAX_VALUE))
                    .addGroup(jpanScoutViewLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpanScoutViewLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnDetailMode)))
                .addContainerGap())
        );
        jpanScoutViewLayout.setVerticalGroup(
            jpanScoutViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanScoutViewLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlblScoutView)
                .addGap(13, 13, 13)
                .addGroup(jpanScoutViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlblName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpanScoutViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlblNum))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlblHabit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 104, Short.MAX_VALUE)
                .addComponent(btnDetailMode)
                .addContainerGap())
        );

        jlpPlayer.setLayer(jpanPlayerDetails, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jlpPlayer.setLayer(jpanScoutView, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jlpPlayerLayout = new javax.swing.GroupLayout(jlpPlayer);
        jlpPlayer.setLayout(jlpPlayerLayout);
        jlpPlayerLayout.setHorizontalGroup(
            jlpPlayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpanPlayerDetails, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jlpPlayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jlpPlayerLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jpanScoutView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jlpPlayerLayout.setVerticalGroup(
            jlpPlayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpanPlayerDetails, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jlpPlayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jlpPlayerLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jpanScoutView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlpPlayer)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlpPlayer)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnMovePlayerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMovePlayerActionPerformed
        
        
        if (btnMovePlayer.getText() == "Move") {
            currentPlay.movePlayer();
            this.btnMovePlayer.setText("Pause");
        } else {
            currentPlay.stopPlayer();
            this.btnMovePlayer.setText("Move");
        }
    }//GEN-LAST:event_btnMovePlayerActionPerformed

    private void btnResetplayerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetplayerActionPerformed
        currentPlay.resetPlayer();
    }//GEN-LAST:event_btnResetplayerActionPerformed

    private void btnRemovePathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemovePathActionPerformed
        currentPlay.removePlayerPath();
    }//GEN-LAST:event_btnRemovePathActionPerformed

    private void btnRemovePlayerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemovePlayerActionPerformed
        currentPlay.removePlayer();
    }//GEN-LAST:event_btnRemovePlayerActionPerformed

    private void btnScoutModeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnScoutModeActionPerformed
        jpanPlayerDetails.setVisible(false);
        jpanScoutView.setVisible(true);
        currentPlay.getPlayerChosen().setScoutView(true);
    }//GEN-LAST:event_btnScoutModeActionPerformed

    private void btnDetailModeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetailModeActionPerformed
        jpanPlayerDetails.setVisible(true);
        jpanScoutView.setVisible(false);
        currentPlay.getPlayerChosen().setScoutView(false);
    }//GEN-LAST:event_btnDetailModeActionPerformed

    private void jtaJobInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jtaJobInputMethodTextChanged
        // No idea how to get rid of this method.
    }//GEN-LAST:event_jtaJobInputMethodTextChanged

    private void jtaJobKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtaJobKeyTyped
        // No idea how to get rid of this method.
    }//GEN-LAST:event_jtaJobKeyTyped

    private void jtaJobKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtaJobKeyReleased
        currentPlay.setPlayerText(jtaJob.getText());
    }//GEN-LAST:event_jtaJobKeyReleased

    private void jcbPosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbPosItemStateChanged
        currentPlay.setPlayerPos(jcbPos.getItemAt(jcbPos.getSelectedIndex()));
    }//GEN-LAST:event_jcbPosItemStateChanged

    private void jtfNumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfNumActionPerformed
        // No idea how to get rid of this method.
    }//GEN-LAST:event_jtfNumActionPerformed

    private void jtfNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfNameKeyReleased
        currentPlay.getPlayerChosen().setName(jtfName.getText());
    }//GEN-LAST:event_jtfNameKeyReleased

    private void jtfNumKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfNumKeyReleased
        currentPlay.getPlayerChosen().setNum(jtfNum.getText());
    }//GEN-LAST:event_jtfNumKeyReleased

    private void jtaHabitKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtaHabitKeyReleased
        currentPlay.getPlayerChosen().setHabit(jtaHabit.getText());
    }//GEN-LAST:event_jtaHabitKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDetailMode;
    private javax.swing.JButton btnMovePlayer;
    private javax.swing.JButton btnRemovePath;
    private javax.swing.JButton btnRemovePlayer;
    private javax.swing.JButton btnResetplayer;
    private javax.swing.JButton btnScoutMode;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox<String> jcbPos;
    private javax.swing.JLabel jlblHabit;
    private javax.swing.JLabel jlblHeader;
    private javax.swing.JLabel jlblJob;
    private javax.swing.JLabel jlblName;
    private javax.swing.JLabel jlblNum;
    private javax.swing.JLabel jlblPosition;
    private javax.swing.JLabel jlblScoutView;
    private javax.swing.JLayeredPane jlpPlayer;
    private javax.swing.JPanel jpanPlayerDetails;
    private javax.swing.JPanel jpanScoutView;
    private javax.swing.JTextArea jtaHabit;
    private javax.swing.JTextArea jtaJob;
    private javax.swing.JTextField jtfName;
    private javax.swing.JTextField jtfNum;
    // End of variables declaration//GEN-END:variables

}
