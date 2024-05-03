
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Hillary
 */
public class GamePlayS2 extends javax.swing.JFrame {
    
    private int playerHealth = 100; // Player's health
    private int enemy1Health = 200; // Health of the first enemy
    private int enemy2Health = 200; // Health of the second enemy
    private boolean isEnemy1Turn = true;
    
    public GamePlayS2() {
        initComponents();
        updateHealthBars(100, 200, 200);
        
    }
    private void updateHealthBars(int playerHealth, int opponent1Health, int opponent2Health) {
        jProgressBar1.setValue(playerHealth); // Update player's health bar
        jProgressBar2.setValue(opponent1Health); // Update first opponent's health bar
        jProgressBar3.setValue(opponent2Health); // Update second opponent's health bar
    }
    private void handlePlayerMove(String playerMove) {
    String[] options = {"ROCK", "PAPER", "SCISSORS"};
    String computerMove = options[(int)(Math.random() * options.length)];

    String playerResult;
    String opponentResult;
    
    int enemyHealth;
    if (isEnemy1Turn) {
        enemyHealth = enemy1Health;
    } else {
        enemyHealth = enemy2Health;
    }
    
    if (playerMove.equals(computerMove)) {
        playerResult = "It's a draw!";
        opponentResult = "It's a draw!";
    } else if ((playerMove.equals("ROCK") && computerMove.equals("SCISSORS")) ||
               (playerMove.equals("PAPER") && computerMove.equals("ROCK")) ||
               (playerMove.equals("SCISSORS") && computerMove.equals("PAPER"))) {
        playerResult = "You won!";
        opponentResult = isEnemy1Turn ? "Computer 1 lost!" : "Computer 2 lost!";
        if (isEnemy1Turn) {
            updateHealthBars(jProgressBar1.getValue(), jProgressBar2.getValue() - 100, jProgressBar3.getValue());
        } else {
            updateHealthBars(jProgressBar1.getValue(), jProgressBar2.getValue(), jProgressBar3.getValue() - 100);
        }
    } else {
        playerResult = "You lost!";
        opponentResult = isEnemy1Turn ? "Computer 1 won!" : "Computer 2 won!";
        updateHealthBars(jProgressBar1.getValue() - 10, jProgressBar2.getValue(), jProgressBar3.getValue());
    }
    
    // Show the appropriate messages
    showMessage("You choose " + playerMove + ". " + playerResult);
    showMessage2("\n Enemy chose " + computerMove + ". " + opponentResult);
    
    // Switch to the next opponent if the current one is defeated
    if (enemyHealth <= 0) {
        isEnemy1Turn = !isEnemy1Turn;
    }

    checkGameOver(); 
}
    private void checkGameOver() {
    if (jProgressBar1.getValue() <= 0) {
        JOptionPane.showMessageDialog(null, "YOU LOST!", "SAD", JOptionPane.INFORMATION_MESSAGE);
        resetGame();
    } else if (jProgressBar2.getValue() <= 0 && jProgressBar3.getValue() <= 0) {
        // Both enemies are defeated
        JOptionPane.showMessageDialog(this, "Congratulations! You defeated both opponents!");
        
        // Transition to the next stage or level by creating and displaying a new JFrame
        // Replace MyNextStageJFrame with the name of your next JFrame class
        GamePlayS2 nextStageFrame = new GamePlayS2();
        nextStageFrame.setVisible(true);
       
        dispose();
    } else if (jProgressBar2.getValue() <= 0) {
        // Player defeated the first opponent
        JOptionPane.showMessageDialog(this, "You defeated the first opponent!");
        jProgressBar2.setVisible(false); // Hide the first opponent's progress bar
        jProgressBar3.setVisible(true); // Show the second opponent's progress bar
        isEnemy1Turn = false; // Set the turn to the second opponent
        updateHealthBars(playerHealth, enemy2Health, 100); // Update health bars for the second opponent
    } else if (jProgressBar3.getValue() <= 0) {
        // Player defeated the second opponent
        JOptionPane.showMessageDialog(this, "Congratulations! You defeated the second opponent!");
         GamePlayS2 nextStageFrame = new GamePlayS2();
        nextStageFrame.setVisible(true);
        dispose();
    }
}
    private void resetGame() {
        updateHealthBars(100, 200, 200); // Reset all health bars
    }

    private void showMessage(String message) {
        jLabel1.setText(message);
    }

    private void showMessage2(String message) {
        jLabel2.setText(message);
    }

    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jProgressBar1 = new javax.swing.JProgressBar();
        jProgressBar2 = new javax.swing.JProgressBar();
        jProgressBar3 = new javax.swing.JProgressBar();
        btnRock2 = new javax.swing.JButton();
        btnPaper2 = new javax.swing.JButton();
        btnScissor2 = new javax.swing.JButton();
        lblWelcome = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnRock2.setText("Rock");
        btnRock2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRock2ActionPerformed(evt);
            }
        });

        btnPaper2.setText("Paper");
        btnPaper2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPaper2ActionPerformed(evt);
            }
        });

        btnScissor2.setText("Scissor");
        btnScissor2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnScissor2ActionPerformed(evt);
            }
        });

        lblWelcome.setText("WELCOME");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(405, 405, 405)
                        .addComponent(lblWelcome))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(138, 138, 138)
                        .addComponent(btnRock2)
                        .addGap(90, 90, 90)
                        .addComponent(btnPaper2)
                        .addGap(104, 104, 104)
                        .addComponent(btnScissor2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(228, 228, 228)
                                .addComponent(jProgressBar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(jProgressBar3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(160, 160, 160)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(669, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(lblWelcome)
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jProgressBar3, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jProgressBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 277, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnRock2)
                            .addComponent(btnPaper2)
                            .addComponent(btnScissor2))
                        .addGap(330, 330, 330))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRock2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRock2ActionPerformed
        handlePlayerMove("ROCK");
    }//GEN-LAST:event_btnRock2ActionPerformed

    private void btnPaper2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPaper2ActionPerformed
        handlePlayerMove("PAPER");
    }//GEN-LAST:event_btnPaper2ActionPerformed

    private void btnScissor2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnScissor2ActionPerformed
       handlePlayerMove("SCISSORS");
    }//GEN-LAST:event_btnScissor2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String [] args) {
 
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GamePlayS2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GamePlayS2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GamePlayS2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GamePlayS2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GamePlayS2().setVisible(true);
            }
        });
    }
               

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPaper2;
    private javax.swing.JButton btnRock2;
    private javax.swing.JButton btnScissor2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JProgressBar jProgressBar2;
    private javax.swing.JProgressBar jProgressBar3;
    private javax.swing.JLabel lblWelcome;
    // End of variables declaration//GEN-END:variables
}

