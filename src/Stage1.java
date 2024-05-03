
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Hillary
 */


public class Stage1 extends javax.swing.JFrame {

    private int playerHealth = 100; // Player's health
    private int enemy1Health = 100; // Health of the first enemy
    private int enemy2Health = 100; // Health of the second enemy
    private boolean isEnemy1Turn = true;

    public Stage1(Stage1 gameplay) {
        initComponents();
        updateHealthBars(playerHealth, enemy1Health, enemy2Health);
    }

    public Stage1() {
        initComponents();
        updateHealthBars(100, 100, 100); // Initialize health bars with full health
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
        updateHealthBars(100, 100, 100); // Reset all health bars
    }

    private void showMessage(String message) {
        jLabel1.setText(message);
    }

    private void showMessage2(String message) {
        jLabel2.setText(message);
    }
    // Generated code for UI components
   
@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnRock = new javax.swing.JButton();
        btnPaper = new javax.swing.JButton();
        btnScissor = new javax.swing.JButton();
        jProgressBar1 = new javax.swing.JProgressBar();
        jProgressBar2 = new javax.swing.JProgressBar();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jProgressBar3 = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(709, 457, -1, -1));

        btnRock.setText("ROCK");
        btnRock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRockActionPerformed(evt);
            }
        });
        getContentPane().add(btnRock, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 470, -1, -1));

        btnPaper.setText("PAPER");
        btnPaper.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPaperActionPerformed(evt);
            }
        });
        getContentPane().add(btnPaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 470, -1, -1));

        btnScissor.setText("SCISSOR");
        btnScissor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnScissorActionPerformed(evt);
            }
        });
        getContentPane().add(btnScissor, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 470, -1, -1));
        getContentPane().add(jProgressBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 160, 54));
        getContentPane().add(jProgressBar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 120, 176, 54));

        jLabel1.setFont(new java.awt.Font("SimSun", 1, 12)); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 260, 30));

        jLabel2.setFont(new java.awt.Font("SimSun", 1, 12)); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 60, 390, 40));
        getContentPane().add(jProgressBar3, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 120, 190, 50));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void btnRockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRockActionPerformed
       handlePlayerMove("ROCK");
    }//GEN-LAST:event_btnRockActionPerformed

    private void btnPaperActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPaperActionPerformed
       handlePlayerMove("PAPER");
    }//GEN-LAST:event_btnPaperActionPerformed

    private void btnScissorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnScissorActionPerformed
        handlePlayerMove("SCISSOR");
    }//GEN-LAST:event_btnScissorActionPerformed

    /**
     * @param args the command line arguments
     */
  

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
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
            java.util.logging.Logger.getLogger(Stage1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Stage1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Stage1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Stage1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Stage1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPaper;
    private javax.swing.JButton btnRock;
    private javax.swing.JButton btnScissor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JProgressBar jProgressBar2;
    private javax.swing.JProgressBar jProgressBar3;
    // End of variables declaration//GEN-END:variables

    
}
