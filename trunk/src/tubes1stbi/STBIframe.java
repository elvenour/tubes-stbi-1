

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes1stbi;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;

/**
 *
 * @author Elfino
 */
public class STBIframe extends javax.swing.JFrame {

    /**
     * Creates new form STBIframe
     */
    public STBIframe() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    private File mInputFile;
    String doc="testcase/adi/adi.all";
    String query;
    String ret;
    String rel;
    rf a = new rf();
    InvertedFile chaos=null;
    feedback fb=null;
    /**asasdas
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        OptionButton = new javax.swing.JButton();
        IndexingPanel = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        BrowseDoc = new javax.swing.JButton();
        DoIndexing = new javax.swing.JButton();
        SaveInverted = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        BrowseRet = new javax.swing.JButton();
        BrowseRelev = new javax.swing.JButton();
        CountPerform = new javax.swing.JButton();
        SavePerform = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        SearchBar = new javax.swing.JTextField();
        Retrieve = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ArkSearcher");

        OptionButton.setText("Option");
        OptionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OptionButtonActionPerformed(evt);
            }
        });

        IndexingPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Indexing");

        jLabel1.setText("Document Collection");

        jLabel3.setText("Relevance Judgement");

        BrowseDoc.setText("Browse..");
        BrowseDoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BrowseDocActionPerformed(evt);
            }
        });

        DoIndexing.setText("Do Indexing");
        DoIndexing.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DoIndexingActionPerformed(evt);
            }
        });

        SaveInverted.setText("Save As");
        SaveInverted.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveInvertedActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout IndexingPanelLayout = new javax.swing.GroupLayout(IndexingPanel);
        IndexingPanel.setLayout(IndexingPanelLayout);
        IndexingPanelLayout.setHorizontalGroup(
            IndexingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(IndexingPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(IndexingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(IndexingPanelLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, IndexingPanelLayout.createSequentialGroup()
                        .addGroup(IndexingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(IndexingPanelLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 138, Short.MAX_VALUE)
                                .addComponent(BrowseDoc))
                            .addGroup(IndexingPanelLayout.createSequentialGroup()
                                .addComponent(DoIndexing)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(SaveInverted, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(68, 68, 68))
                    .addGroup(IndexingPanelLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        IndexingPanelLayout.setVerticalGroup(
            IndexingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(IndexingPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addGap(15, 15, 15)
                .addGroup(IndexingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(BrowseDoc))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(IndexingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DoIndexing)
                    .addComponent(SaveInverted))
                .addGap(40, 40, 40))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Experimental");

        jLabel4.setText("Retrieval Result");

        jLabel5.setText("Relevance Judgment");

        BrowseRet.setText("Browse..");
        BrowseRet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BrowseRetActionPerformed(evt);
            }
        });

        BrowseRelev.setText("Browse..");
        BrowseRelev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BrowseRelevActionPerformed(evt);
            }
        });

        CountPerform.setText("Count Performance");
        CountPerform.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CountPerformActionPerformed(evt);
            }
        });

        SavePerform.setText("Save As");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(CountPerform)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 112, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(BrowseRelev, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BrowseRet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(SavePerform, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(66, 66, 66))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(BrowseRet))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BrowseRelev)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CountPerform)
                    .addComponent(SavePerform))
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Interactive");

        SearchBar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchBarActionPerformed(evt);
            }
        });

        Retrieve.setText("Retrieve");
        Retrieve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RetrieveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(SearchBar)
                .addGap(18, 18, 18)
                .addComponent(Retrieve)
                .addGap(20, 20, 20))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addGap(4, 4, 4)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Retrieve)
                    .addComponent(SearchBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(IndexingPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(OptionButton)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(OptionButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(IndexingPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    
    private void OptionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OptionButtonActionPerformed
        // TODO add your handling code here:
       
        TFoption s = new TFoption();
        s.setVisible(true);
    }//GEN-LAST:event_OptionButtonActionPerformed

    private void SearchBarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchBarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchBarActionPerformed

    private void BrowseDocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BrowseDocActionPerformed
 
        JFileChooser tChooser = new JFileChooser();
        tChooser.setDialogTitle("Choose File");
        int tOption = tChooser.showOpenDialog(this);
        if (tOption == JFileChooser.APPROVE_OPTION) {
            mInputFile = tChooser.getSelectedFile();
            doc=mInputFile.getAbsolutePath();
            //inputFileText.setText(mInputFile.getName());
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_BrowseDocActionPerformed

    private void RetrieveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RetrieveActionPerformed
        try {
            // RetrieveResult st = new RetrieveResult();
            //        st.setVisible(true);
                    
                    a.hitungQuery("ibm maintain too", Setting.Singleton().getCodeQuery(), chaos, Setting.Singleton().getStopword(), Setting.Singleton().getStemming(), "testcase/stopwords/english");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(STBIframe.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(STBIframe.class.getName()).log(Level.SEVERE, null, ex);
        }
        a.createWeightTable(chaos);
        ArrayList<String> OutputFirstRetrieval = a.firstPhaseRetrieval(Setting.Singleton().getCodeQuery(), Setting.Singleton().getCodeDocument());

        fb=new feedback(OutputFirstRetrieval);
        ArrayList<String> OutputSecondRetrieval = a.secondPhaseRetrieval(Setting.Singleton().fb, Setting.Singleton().alpha, Setting.Singleton().beta, Setting.Singleton().ganma, Setting.Singleton().getCodeQuery(), Setting.Singleton().getCodeDocument());

        // TODO add your handling code here:
    }//GEN-LAST:event_RetrieveActionPerformed

    private void BrowseRetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BrowseRetActionPerformed
        // TODO add your handling code here:                             
 
        JFileChooser tChooser = new JFileChooser();
        tChooser.setDialogTitle("Choose File");
        int tOption = tChooser.showOpenDialog(this);
        if (tOption == JFileChooser.APPROVE_OPTION) {
            mInputFile = tChooser.getSelectedFile();
            ret=mInputFile.getAbsolutePath();
            //inputFileText.setText(mInputFile.getName());
        }
    }//GEN-LAST:event_BrowseRetActionPerformed

    private void BrowseRelevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BrowseRelevActionPerformed
        // TODO add your handling code here:                             
 
        JFileChooser tChooser = new JFileChooser();
        tChooser.setDialogTitle("Choose File");
        int tOption = tChooser.showOpenDialog(this);
        if (tOption == JFileChooser.APPROVE_OPTION) {
            mInputFile = tChooser.getSelectedFile();
            rel=mInputFile.getAbsolutePath();
            //inputFileText.setText(mInputFile.getName());
        }
    }//GEN-LAST:event_BrowseRelevActionPerformed

    private void DoIndexingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DoIndexingActionPerformed
        // TODO add your handling code here:
        
//        browser 
        ArrayList<TextData> zenki = Parser.parseFile(doc,"testcase/stopwords/english",Setting.Singleton().getStemming());
        chaos = new InvertedFile(zenki);
        chaos.countInvertedFile(Setting.Singleton().DocumentTf,Setting.Singleton().DocumentIdf);
    }//GEN-LAST:event_DoIndexingActionPerformed

    private void SaveInvertedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveInvertedActionPerformed
        // TODO add your handling code here:
        chaos.saveInvertedFile();
        chaos.saveListOfDocument();
    }//GEN-LAST:event_SaveInvertedActionPerformed

    private void CountPerformActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CountPerformActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_CountPerformActionPerformed

    /**/
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
            java.util.logging.Logger.getLogger(STBIframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(STBIframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(STBIframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(STBIframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new STBIframe().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BrowseDoc;
    private javax.swing.JButton BrowseRelev;
    private javax.swing.JButton BrowseRet;
    private javax.swing.JButton CountPerform;
    private javax.swing.JButton DoIndexing;
    private javax.swing.JPanel IndexingPanel;
    private javax.swing.JButton OptionButton;
    private javax.swing.JButton Retrieve;
    private javax.swing.JButton SaveInverted;
    private javax.swing.JButton SavePerform;
    private javax.swing.JTextField SearchBar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}
