
package MarkAttendance;

import dbconnect.dbconnect;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.Timer;

public class AttMark extends javax.swing.JFrame {

    String dates;
    Date d=new Date();
    Connection conn=null;
    PreparedStatement pst=null;
    ResultSet f=null;
    String Time=null;
    String TimeNow=null;
    public AttMark() {
        initComponents();
        conn=dbconnect.connect();
        DateFormat date=new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal=Calendar.getInstance();
        dates=date.format(cal.getTime());
        date_.setText("Date :   "+dates);
        
       showTime();
    }
    private void waittxt()
    {
    Timer t = new Timer(1000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //jTextField1.setText(null);
            }
        });
        t.setRepeats(false);
        t.start();
    }
    void opn_err(String msg)
    {
        final errormsg em=new errormsg();
        em.setVisible(true);
        em.err.setText(msg);
        Timer t = new Timer(4000, new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                em.dispose();
            }
        });
        t.setRepeats(false);
        t.start();
    }
    void opn_marked(String Eid,String fName,String surname,ImageIcon format,String st)
    {
        final marked m=new marked();
        m.setVisible(true);
        m.empNo.setText(Eid);
        m.fname.setText(fName);
        m.sur.setText(surname);
        m.stat.setText(st);
        //m.logo.setIcon((Icon) format.getImage().getScaledInstance(100, 100,Image.SCALE_DEFAULT));
        m.logo.setIcon(format);
        Timer t = new Timer(4000, new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                m.dispose();
            }
        });
        t.setRepeats(false);
        t.start();
    }
    void showTime()
    {
        new Timer(0,new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                 Date d=new Date();
                 DateFormat time=new SimpleDateFormat("HH:mm:ss ");
               time_.setText("Time :   "+time.format(d));
               TimeNow=time.format(d);
            }
        }).start();
    }
    private void cleartxt()
    {
        Timer t = new Timer(5000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                eid.setText(null);
                
                //photo.setIcon(null);
            }
        });
        t.setRepeats(false);
        t.start();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        time_ = new javax.swing.JLabel();
        date_ = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        eid = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1920, 1080));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/coollogo_com-5196350.gif"))); // NOI18N
        jLabel1.setText("jLabel1");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 40, 1170, 100));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/logo.png"))); // NOI18N
        jLabel3.setText("jLabel3");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1640, 10, 200, 160));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/logo.png"))); // NOI18N
        jLabel4.setText("jLabel3");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 210, 160));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/minus.png"))); // NOI18N
        jLabel5.setText("jLabel5");
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1850, 10, 26, 26));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/cancel (3).png"))); // NOI18N
        jLabel6.setText("jLabel5");
        jLabel6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1880, 10, 26, 26));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1920, 180));

        jPanel3.setMinimumSize(new java.awt.Dimension(1920, 910));
        jPanel3.setPreferredSize(new java.awt.Dimension(1920, 910));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        time_.setFont(new java.awt.Font("Stencil", 0, 36)); // NOI18N
        jPanel3.add(time_, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 40, 370, 50));

        date_.setFont(new java.awt.Font("Stencil", 0, 36)); // NOI18N
        jPanel3.add(date_, new org.netbeans.lib.awtextra.AbsoluteConstraints(1540, 40, 350, 50));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/download (1).jpg"))); // NOI18N
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1920, 950));

        eid.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        eid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eidActionPerformed(evt);
            }
        });
        eid.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                eidAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        eid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                eidKeyTyped(evt);
            }
        });
        jPanel3.add(eid, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 190, 583, 48));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 1920, 950));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void eidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eidActionPerformed

    }//GEN-LAST:event_eidActionPerformed

    private void eidAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_eidAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_eidAncestorAdded

    private void eidKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_eidKeyTyped
        
        SimpleDateFormat date=new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal=Calendar.getInstance();
        dates=date.format(cal.getTime());
        DateFormat time=new SimpleDateFormat("HH:mm:ss");
        Time=time.format(d);
        //waittxt();
        String id=eid.getText();
        try
        {
            String a="select * from empdet";
            pst=conn.prepareStatement(a);
            f=pst.executeQuery();            
            while(f.next())
            {
                String ser=f.getString("SerialNo");
                String Eid=f.getString("EID");
                String fName=f.getString("FName");
                String surname=f.getString("Surname");
                byte[] image=f.getBytes("Photo");
//                if(ser!=null)
//                {
                    
                    if(id.compareTo(ser)==0)
                    {
                        ImageIcon format=new ImageIcon(image);
                        String c="select * from attendance where EID='"+Eid+"' and Date='"+dates+"'";
                        pst=conn.prepareStatement(c);
                        ResultSet f1=pst.executeQuery();
                        if(f1.next())
                        {
                            String status1=f1.getString("LeavingTime");
                            String c1="select * from event_booking where Event_Date='"+dates+"'";
                            PreparedStatement ps=conn.prepareStatement(c1);
                            ResultSet rr=ps.executeQuery();
                            if(rr.next())
                            {
                                if(status1 == null)
                                {
                                    if(time.format(d).compareTo("12:00:00")>=0&&time.format(d).compareTo("22:00:00")<0)
                                    {
                                        try {
                                            opn_marked(Eid,fName,surname,format,"Leaving");
                                            String g="update attendance set LeavingTime='"+time.format(d)+"',Status='h' where EID='"+Eid+"' and Date='"+dates+"'";
                                            pst=conn.prepareStatement(g);
                                            pst.execute();
                                            eid.setText("");
                                        } catch(Exception e) {
                                            opn_err("Error");
                                            eid.setText("");
                                        }
                                    }
                                    else if(time.format(d).compareTo("22:00:00")>=0)
                                    {
                                        try {
                                            opn_marked(Eid,fName,surname,format,"Leaving");
                                            String g="update attendance set LeavingTime='"+time.format(d)+"',Status='f' where EID='"+Eid+"' and Date='"+dates+"'";
                                            pst=conn.prepareStatement(g);
                                            pst.execute();
                                            eid.setText("");
                                        } catch(Exception e) {
                                            opn_err("Error");
                                            eid.setText("");
                                        }
                                    }
                                    else
                                        opn_err("Too early to leave");
                                }
                                else {
                                    opn_err("Already marked the leave");
                                    eid.setText("");
                                }
                            }
                            else
                            {
                                if(status1==null)
                                {
                                    if(time.format(d).compareTo("12:00:00")>=0&&time.format(d).compareTo("18:00:00")<0)
                                    {
                                        try {
                                            opn_marked(Eid,fName,surname,format,"Leaving");
                                            String g="update attendance set LeavingTime='"+time.format(d)+"',Status='h' where EID='"+Eid+"' and Date='"+dates+"'";
                                            pst=conn.prepareStatement(g);
                                            pst.execute();
                                            eid.setText("");

                                        } catch(Exception e) {
                                            opn_err("Error1");
                                            eid.setText("");
                                        }
                                    }
                                    else if(time.format(d).compareTo("18:00:00")>=0)
                                    {
                                        try {
                                            opn_marked(Eid,fName,surname,format,"Leaving");
                                            String g="update attendance set LeavingTime='"+time.format(d)+"',Status='f' where EID='"+Eid+"' and Date='"+dates+"'";
                                            pst=conn.prepareStatement(g);
                                            pst.execute();
                                            eid.setText("");
                                        } catch(Exception e) {
                                            opn_err("Error");
                                            eid.setText("");
                                        }
                                    }
                                    else
                                        opn_err("Too early to leave");
                                }
                                else {
                                    opn_err("Already marked the leave");
                                    eid.setText("");
                                }
                            }
                        }
                        else
                        {
                            if(time.format(d).compareTo("09:00:00")<0)
                            {
                                try{

                                    String b="insert into attendance (EID,Date,ArrivalTime,Status) values ('"+Eid+"','"+dates+"','"+time.format(d)+"','f')";
                                    pst=conn.prepareStatement(b);
                                    pst.execute();
                                    opn_marked(Eid,fName,surname,format,"Coming to work");
                                    eid.setText("");
                                }
                                catch(Exception e){
                                    opn_err("Error: Cannot mark the attendance");
                                    System.out.println(e);
                                    eid.setText("");
                                }
                            }
                            else if(time.format(d).compareTo("09:00:00")>=0&&time.format(d).compareTo("16:00:00")<0)
                            {
                                try{
                                    opn_marked(Eid,fName,surname,format,"ARRIVAL");
                                    String b="insert into attendance (EID,Date,ArrivalTime,Status) values ('"+Eid+"','"+dates+"','"+time.format(d)+"','h')";
                                    pst=conn.prepareStatement(b);
                                    pst.execute();
                                    eid.setText("");
                                }
                                catch(Exception e){
                                    opn_err("Error: Cannot mark the attendance");
                                    eid.setText("");
                                }
                            }
                            else if(time.format(d).compareTo("16:00:00")>=0)
                            {
                                opn_err("Cannot marked the attendance");
                                eid.setText("");
                            }
                        }
//                    }
                }
            }
////            else
////                JOptionPane.showMessageDialog(null, "kkkk");
        } catch (SQLException ex) {
            opn_err("Error");
            eid.setText("");
        }
    }//GEN-LAST:event_eidKeyTyped

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        this.setState(this.ICONIFIED);
    }//GEN-LAST:event_jLabel5MouseClicked

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
            java.util.logging.Logger.getLogger(AttMark.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AttMark.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AttMark.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AttMark.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AttMark().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel date_;
    private javax.swing.JTextField eid;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel time_;
    // End of variables declaration//GEN-END:variables
}
