
package MarkAttendance;

public class marked extends javax.swing.JFrame {

    public marked() {
        initComponents();
        empNo.disable();
        fname.disable();
        sur.disable();
        stat.disable();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        empNo = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        fname = new javax.swing.JTextField();
        sur = new javax.swing.JTextField();
        stat = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        text = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 100, 100, 100));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("EMPLOYEE ID");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 260, 120, 30));

        empNo.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        empNo.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jPanel1.add(empNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 260, 190, 30));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("NAME");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 310, 120, 30));

        fname.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        fname.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jPanel1.add(fname, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 310, 190, 30));

        sur.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        sur.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jPanel1.add(sur, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 310, 210, 30));

        stat.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        stat.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jPanel1.add(stat, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 360, 190, 30));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Status");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 360, 120, 30));

        text.setForeground(new java.awt.Color(255, 255, 255));
        text.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                textAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jPanel1.add(text, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 460, 550, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/checked.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 64, 64));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 28)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("SUCCESSFULLY MARKED");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 20, 310, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 680, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void textAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_textAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_textAncestorAdded

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
            java.util.logging.Logger.getLogger(marked.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(marked.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(marked.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(marked.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new marked().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTextField empNo;
    public javax.swing.JTextField fname;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JLabel logo;
    public javax.swing.JTextField stat;
    public javax.swing.JTextField sur;
    public javax.swing.JLabel text;
    // End of variables declaration//GEN-END:variables
}
