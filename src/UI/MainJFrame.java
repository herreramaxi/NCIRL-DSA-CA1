/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import UI.WorkflowManager.WorkflowManager;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author Maximiliano Herrera
 */
public class MainJFrame extends javax.swing.JFrame {

    private final WorkflowManager _workflowManager;

    /**
     * Creates new form MainJFrame
     */
    public MainJFrame() {
        initComponents();

        UIMediator mediator = new UIMediator(this);
        _workflowManager = new WorkflowManager(this, mediator);
        _workflowManager.attach(new UIComponentObserverPull(() -> {
            jTextFieldStatus.setText(_workflowManager.getCurrrentPhase());
        }));

        _workflowManager.initialize();
        jTextFieldStatus.setText(_workflowManager.getCurrrentPhase());
    }

    public void resetIntputControls() {
        jTextFieldName.setText("");
        jTextFieldAge.setText("");
        jCheckBoxMedicalCondition.setSelected(false);
    }

    public void showErrorMessage(String errorMessage) {
        JOptionPane.showMessageDialog(null, errorMessage, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(null, message, "Information", JOptionPane.INFORMATION_MESSAGE);
    }

    public void appendTextToTextArea(String text) {
        jTextArea1.append(text + "\n");
    }

    public String getPatientName() {
        return jTextFieldName.getText();
    }

    public int getPatientAge() {
        try {
            return Integer.parseInt(jTextFieldAge.getText());
        } catch (Exception exception) {
            return 0;
        }
    }

    public boolean getMedicalCondition() {
        return jCheckBoxMedicalCondition.isSelected();
    }

    public void showMessageDialog(String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    public void showErrorMessageDialog(String message) {
        JOptionPane.showMessageDialog(this, message, "Dialog", JOptionPane.WARNING_MESSAGE);
    }

    public void priorityButtonSetEnable(boolean enabled) {
        jButtonAllocatePriorities.setEnabled(enabled);
    }

    public void addButtonSetEnable(boolean enabled) {
        jButtonAdd.setEnabled(enabled);
    }

    public void getNextGroupButtonSetEnable(boolean enabled) {
        jButtonGetNextGroup.setEnabled(enabled);
    }

    //The idea is from https://youtu.be/YA88rtqqtz0
    //But I simplified it
    private void FilterNumbersOnTextField(KeyEvent evt) {
        char input = evt.getKeyChar();

        try {
            Integer.parseInt(String.valueOf(input));
        } catch (Exception exception) {
            evt.consume();
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

        jLabel1 = new javax.swing.JLabel();
        jTextFieldName = new javax.swing.JTextField();
        jTextFieldAge = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jCheckBoxMedicalCondition = new javax.swing.JCheckBox();
        jButtonAdd = new javax.swing.JButton();
        jButtonAddShowHowManyRegistered = new javax.swing.JButton();
        jButtonListAll = new javax.swing.JButton();
        jButtonAllocatePriorities = new javax.swing.JButton();
        jButtonGetNextGroup = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButtonClear = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldStatus = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Vaccination schedule system");

        jLabel1.setText("Name");

        jTextFieldAge.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldAgeKeyTyped(evt);
            }
        });

        jLabel2.setText("Age");

        jCheckBoxMedicalCondition.setText("Medical condition");

        jButtonAdd.setText("Add");
        jButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddActionPerformed(evt);
            }
        });

        jButtonAddShowHowManyRegistered.setText("Show how many registered");
        jButtonAddShowHowManyRegistered.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddShowHowManyRegisteredActionPerformed(evt);
            }
        });

        jButtonListAll.setText("List all");
        jButtonListAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonListAllActionPerformed(evt);
            }
        });

        jButtonAllocatePriorities.setText("Set priorities");
        jButtonAllocatePriorities.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAllocatePrioritiesActionPerformed(evt);
            }
        });

        jButtonGetNextGroup.setText("Patients to be scheduled");
        jButtonGetNextGroup.setToolTipText("");
        jButtonGetNextGroup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGetNextGroupActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jButtonClear.setText("Clear text area");
        jButtonClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClearActionPerformed(evt);
            }
        });

        jLabel3.setText("Status");

        jTextFieldStatus.setEditable(false);
        jTextFieldStatus.setText("status");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButtonListAll, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonAllocatePriorities, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonClear))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonAddShowHowManyRegistered, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonGetNextGroup, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 209, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextFieldAge, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
                                    .addComponent(jTextFieldName))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCheckBoxMedicalCondition)
                                    .addComponent(jButtonAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextFieldStatus)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBoxMedicalCondition))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAdd))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonListAll)
                    .addComponent(jButtonAddShowHowManyRegistered))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAllocatePriorities)
                    .addComponent(jButtonGetNextGroup))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonClear)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldAgeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldAgeKeyTyped
        this.FilterNumbersOnTextField(evt);
    }//GEN-LAST:event_jTextFieldAgeKeyTyped

    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddActionPerformed
        _workflowManager.addPerson();
    }//GEN-LAST:event_jButtonAddActionPerformed

    private void jButtonAddShowHowManyRegisteredActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddShowHowManyRegisteredActionPerformed
        _workflowManager.patientsRegisteredCount();
    }//GEN-LAST:event_jButtonAddShowHowManyRegisteredActionPerformed

    private void jButtonAllocatePrioritiesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAllocatePrioritiesActionPerformed
        _workflowManager.setPriorities();
    }//GEN-LAST:event_jButtonAllocatePrioritiesActionPerformed

    private void jButtonGetNextGroupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGetNextGroupActionPerformed
        _workflowManager.getNextGroup();
    }//GEN-LAST:event_jButtonGetNextGroupActionPerformed

    private void jButtonListAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonListAllActionPerformed
        _workflowManager.list();
    }//GEN-LAST:event_jButtonListAllActionPerformed

    private void jButtonClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClearActionPerformed
        jTextArea1.setText("");
    }//GEN-LAST:event_jButtonClearActionPerformed

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
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonAddShowHowManyRegistered;
    private javax.swing.JButton jButtonAllocatePriorities;
    private javax.swing.JButton jButtonClear;
    private javax.swing.JButton jButtonGetNextGroup;
    private javax.swing.JButton jButtonListAll;
    private javax.swing.JCheckBox jCheckBoxMedicalCondition;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextFieldAge;
    private javax.swing.JTextField jTextFieldName;
    private javax.swing.JTextField jTextFieldStatus;
    // End of variables declaration//GEN-END:variables

}
