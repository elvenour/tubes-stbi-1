/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tubes1stbi;
/**
 *
 * @author Elfino
 */
public class TFoption extends javax.swing.JFrame {

    /**
     * Creates new form TFoption
     */
    public TFoption() {
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

        StopwordRemovalG = new javax.swing.ButtonGroup();
        QueryTermFrequencyG = new javax.swing.ButtonGroup();
        StemmingG = new javax.swing.ButtonGroup();
        IDFG = new javax.swing.ButtonGroup();
        NormalizationG = new javax.swing.ButtonGroup();
        DocumentTermFrequencyG = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        stopword = new javax.swing.JCheckBox();
        stemming = new javax.swing.JCheckBox();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        qtf1 = new javax.swing.JRadioButton();
        qtf2 = new javax.swing.JRadioButton();
        qtf3 = new javax.swing.JRadioButton();
        jLabel8 = new javax.swing.JLabel();
        qidf = new javax.swing.JCheckBox();
        qnormal = new javax.swing.JCheckBox();
        Ok = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        dtf1 = new javax.swing.JRadioButton();
        dtf2 = new javax.swing.JRadioButton();
        dtf3 = new javax.swing.JRadioButton();
        jLabel12 = new javax.swing.JLabel();
        didf = new javax.swing.JCheckBox();
        dnormal = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Option");

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        stopword.setText("Stopword Removal");
        stopword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopwordActionPerformed(evt);
            }
        });

        stemming.setText("Stemming");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(stemming)
                    .addComponent(stopword))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(stopword)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(stemming)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Query");

        QueryTermFrequencyG.add(qtf1);
        qtf1.setSelected(true);
        qtf1.setText("Binary TF");

        QueryTermFrequencyG.add(qtf2);
        qtf2.setText("Logarithmic TF");

        QueryTermFrequencyG.add(qtf3);
        qtf3.setText("Augmented TF");

        jLabel8.setText("TF :");

        qidf.setText("IDF");

        qnormal.setText("Normalisasi");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 4, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(qtf1)
                                .addGap(18, 18, 18)
                                .addComponent(qtf2)
                                .addGap(18, 18, 18)
                                .addComponent(qtf3))
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(qnormal)
                            .addComponent(qidf))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(qtf1)
                    .addComponent(qtf2)
                    .addComponent(qtf3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(qidf)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(qnormal)
                .addContainerGap())
        );

        Ok.setText("Ok");
        Ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OkActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Vivaldi", 1, 36)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Setting");

        jPanel8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("Document");

        DocumentTermFrequencyG.add(dtf1);
        dtf1.setSelected(true);
        dtf1.setText("Binary TF");

        DocumentTermFrequencyG.add(dtf2);
        dtf2.setText("Logarithmic TF");

        DocumentTermFrequencyG.add(dtf3);
        dtf3.setText("Augmented TF");

        jLabel12.setText("TF :");

        didf.setText("IDF");

        dnormal.setText("Normalisasi");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(dtf1)
                                .addGap(18, 18, 18)
                                .addComponent(dtf2)
                                .addGap(18, 18, 18)
                                .addComponent(dtf3))
                            .addComponent(jLabel12))
                        .addGap(18, 18, 18))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dnormal)
                            .addComponent(didf))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dtf1)
                    .addComponent(dtf2)
                    .addComponent(dtf3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(didf)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(dnormal)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(Ok, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Ok))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void stopwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_stopwordActionPerformed

    private void OkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OkActionPerformed
        // TODO add your handling code here:
        
        if(stopword.isSelected())
        {
            Setting.Singleton().Stopword=Setting.stopwordYes;
        }
        else
        {
            Setting.Singleton().Stopword=Setting.stopwordNo;
        }
        
        if(stemming.isSelected())
        {
            Setting.Singleton().Stemming=Setting.stemmingYes;
        }
        else
        {
            Setting.Singleton().Stemming=Setting.stemmingNo;
        }
        
        if(qtf1.isSelected())
        {
            Setting.Singleton().QueryTf=Setting.queryTfBinary;
        }
        else if(qtf2.isSelected())
        {
            Setting.Singleton().QueryTf=Setting.queryTfLogaritmik;
        }
        else
        {
            Setting.Singleton().QueryTf=Setting.queryTfAugmented;
        }
        
        if(qidf.isSelected())
        {
            Setting.Singleton().QueryIdf=Setting.queryIdfYes;
        }
        else
        {
            Setting.Singleton().QueryIdf=Setting.queryIdfNo;
        }
        
        if(qnormal.isSelected())
        {
            Setting.Singleton().QueryNormalisasi=Setting.queryNormalisasiYes;
        }
        else
        {
            Setting.Singleton().QueryNormalisasi=Setting.queryNormalisasiNo;
        }
        
        if(dtf1.isSelected())
        {
            Setting.Singleton().DocumentTf=Setting.documentTfBinary;
        }
        else if(dtf2.isSelected())
        {
            Setting.Singleton().DocumentTf=Setting.documentTfLogaritmik;
        }
        else
        {
            Setting.Singleton().DocumentTf=Setting.documentTfAugmented;
        }
        
        if(didf.isSelected())
        {
            Setting.Singleton().DocumentIdf=Setting.documentIdfYes;
        }
        else
        {
            Setting.Singleton().DocumentIdf=Setting.documentIdfNo;
        }
        
        if(dnormal.isSelected())
        {
            Setting.Singleton().DocumentNormalisasi=Setting.documentNormalisasiYes;
        }
        else
        {
            Setting.Singleton().DocumentNormalisasi=Setting.documentNormalisasiNo;
        }
        
        
    }//GEN-LAST:event_OkActionPerformed

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
            java.util.logging.Logger.getLogger(TFoption.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TFoption.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TFoption.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TFoption.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TFoption().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup DocumentTermFrequencyG;
    private javax.swing.ButtonGroup IDFG;
    private javax.swing.ButtonGroup NormalizationG;
    private javax.swing.JButton Ok;
    private javax.swing.ButtonGroup QueryTermFrequencyG;
    private javax.swing.ButtonGroup StemmingG;
    private javax.swing.ButtonGroup StopwordRemovalG;
    private javax.swing.JCheckBox didf;
    private javax.swing.JCheckBox dnormal;
    private javax.swing.JRadioButton dtf1;
    private javax.swing.JRadioButton dtf2;
    private javax.swing.JRadioButton dtf3;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JCheckBox jCheckBox6;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JRadioButton jRadioButton15;
    private javax.swing.JRadioButton jRadioButton16;
    private javax.swing.JRadioButton jRadioButton8;
    private javax.swing.JCheckBox qidf;
    private javax.swing.JCheckBox qnormal;
    private javax.swing.JRadioButton qtf1;
    private javax.swing.JRadioButton qtf2;
    private javax.swing.JRadioButton qtf3;
    private javax.swing.JCheckBox stemming;
    private javax.swing.JCheckBox stopword;
    // End of variables declaration//GEN-END:variables
}