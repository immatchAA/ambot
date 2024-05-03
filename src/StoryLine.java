
public class StoryLine extends javax.swing.JFrame {

    private Stage1 gameplay;
   
    public StoryLine(String characterName) {
        initComponents();
    }

    public StoryLine( Stage1 gameplay) {
        this.gameplay = gameplay;
        initComponents();
    }
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtLevel = new javax.swing.JTextField();
        btnlvl1Forest = new javax.swing.JButton();
        btnlvl2 = new javax.swing.JButton();
        btnlvl3 = new javax.swing.JButton();
        btnlvl4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtLevel.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtLevel.setText("CHOOSE LEVEL");
        txtLevel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLevelActionPerformed(evt);
            }
        });

        btnlvl1Forest.setText("lvl 1");
        btnlvl1Forest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlvl1ForestActionPerformed(evt);
            }
        });

        btnlvl2.setText("lvl2");
        btnlvl2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlvl2ActionPerformed(evt);
            }
        });

        btnlvl3.setText("lvl3");

        btnlvl4.setText("lvl4");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(447, 447, 447)
                        .addComponent(txtLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addComponent(btnlvl1Forest)
                        .addGap(70, 70, 70)
                        .addComponent(btnlvl2)
                        .addGap(61, 61, 61)
                        .addComponent(btnlvl3)
                        .addGap(46, 46, 46)
                        .addComponent(btnlvl4)))
                .addContainerGap(706, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(txtLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 381, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnlvl1Forest)
                    .addComponent(btnlvl2)
                    .addComponent(btnlvl3)
                    .addComponent(btnlvl4))
                .addGap(330, 330, 330))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtLevelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLevelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLevelActionPerformed

    private void btnlvl1ForestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlvl1ForestActionPerformed
        gameplay = new Stage1();
        gameplay.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnlvl1ForestActionPerformed

    private void btnlvl2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlvl2ActionPerformed
        gameplay = new Stage1();
        gameplay.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnlvl2ActionPerformed

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
            java.util.logging.Logger.getLogger(StoryLine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StoryLine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StoryLine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StoryLine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            private String characterName;
            public void run() {
                new StoryLine(characterName).setVisible(true);
                
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnlvl1Forest;
    private javax.swing.JButton btnlvl2;
    private javax.swing.JButton btnlvl3;
    private javax.swing.JButton btnlvl4;
    private javax.swing.JTextField txtLevel;
    // End of variables declaration//GEN-END:variables
}
