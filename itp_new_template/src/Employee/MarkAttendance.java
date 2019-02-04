/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Employee;

import dbconnect.dbconnect;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import net.proteanit.sql.DbUtils;

public class MarkAttendance extends javax.swing.JInternalFrame {
    PreparedStatement pst=null;
    Connection conn=null;
    ResultSet rs=null;
    String EID=null;
    String DATE=null;
    methods mm=new methods();
    public MarkAttendance() {
        initComponents();
        conn=dbconnect.connect();
        show_table1();
        show_table2();
        showTime();
    }
    void showTime()
    {
        new Timer(0,new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Date d=new Date(); 
                 DateFormat time=new SimpleDateFormat("HH:mm:ss ");
               // Calendar cal=Calendar.getInstance();
               //  String ctime=time.format(cal.getTime());
            }
        }).start();
    }
    private void show_table1()
    {
        try {
            String a="select e.EID,e.FName,e.Surname,a.ArrivalTime,a.LeavingTime,a.Reason_to_early_leave,a.Status from empdet e,attendance a where e.EID=a.EID and Date='"+mm.dates+"'";
            pst=conn.prepareStatement(a);
            rs=pst.executeQuery();
            Atttable.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch (Exception ex) {
            System.out.println(ex);
        }
        
    }
    private void show_table2()
    {
        try {
            String a="select e.EID,e.FName,e.Surname,a.Date,a.Reason from empdet e,absentees a where e.EID=a.EID order by a.Date DESC";
            pst=conn.prepareStatement(a);
            rs=pst.executeQuery();
            etable2.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Aeid = new javax.swing.JTextField();
        mark1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        Atttable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        eid3 = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        reason3 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        date3 = new com.toedter.calendar.JDateChooser();
        jPanel3 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Leid = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        reason = new javax.swing.JTextArea();
        mark2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        etable2 = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        sid = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        sid1 = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1600, 925));
        setMinimumSize(new java.awt.Dimension(1600, 925));
        setPreferredSize(new java.awt.Dimension(1600, 925));

        jPanel1.setPreferredSize(new java.awt.Dimension(1140, 545));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Employee ID");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 190, 110, 29));

        Aeid.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Aeid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AeidActionPerformed(evt);
            }
        });
        jPanel1.add(Aeid, new org.netbeans.lib.awtextra.AbsoluteConstraints(207, 190, 140, 29));

        mark1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        mark1.setText("Mark");
        mark1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mark1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mark1ActionPerformed(evt);
            }
        });
        jPanel1.add(mark1, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 260, 110, 40));

        Atttable.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Atttable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "EID", "Fname", "Surname", "Arrival Time", "Leaving Time", "Reason to leave"
            }
        ));
        Atttable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Atttable.setGridColor(new java.awt.Color(0, 0, 0));
        Atttable.setSelectionBackground(new java.awt.Color(0, 0, 0));
        Atttable.setSelectionForeground(new java.awt.Color(204, 204, 204));
        jScrollPane2.setViewportView(Atttable);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(79, 490, 840, 320));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        jLabel2.setText("Mark Attendance");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, -2, 260, 50));

        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("Mark Arrival");
        jPanel2.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(74, 25, 135, 35));

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton3.setText("Clear");
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 160, 110, 40));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 290, 260));

        jPanel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Employee ID");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 109, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Leave date");
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 110, 30));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Reason");
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 80, 70, 30));

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("Get Employee Holiday");
        jPanel4.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 286, 35));

        eid3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel4.add(eid3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 140, 30));

        reason3.setColumns(20);
        reason3.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        reason3.setRows(5);
        jScrollPane3.setViewportView(reason3);

        jPanel4.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 80, 210, 80));

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setText("Add");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(117, 187, 130, 40));

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton2.setText("Clear");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 186, 130, 40));

        date3.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jPanel4.add(date3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, 140, 30));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 100, 580, 260));

        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("Mark Leaving");
        jPanel3.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, 286, 35));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel4.setText("Employee ID");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 85, 100, 30));

        Leid.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel3.add(Leid, new org.netbeans.lib.awtextra.AbsoluteConstraints(114, 86, 120, 29));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel5.setText("Reason");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(245, 85, 60, 30));

        reason.setColumns(20);
        reason.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        reason.setRows(3);
        jScrollPane1.setViewportView(reason);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(305, 85, 180, 67));

        mark2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        mark2.setText("Mark");
        mark2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mark2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mark2ActionPerformed(evt);
            }
        });
        jPanel3.add(mark2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 190, 140, 40));

        jButton4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton4.setText("Clear");
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 190, 150, 40));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 100, 520, 260));

        etable2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        etable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "EID", "Fname", "Surname", "Date", "Reason"
            }
        ));
        etable2.setGridColor(new java.awt.Color(0, 0, 0));
        etable2.setSelectionBackground(new java.awt.Color(0, 0, 0));
        etable2.setSelectionForeground(new java.awt.Color(204, 204, 204));
        etable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                etable2MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(etable2);

        jPanel1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(965, 493, 570, 320));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel8.setText("Employee ID");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 430, 100, 37));

        sid.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel1.add(sid, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 430, 140, 37));

        jButton5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/if_icon-ios7-search-strong_211817 (1).png"))); // NOI18N
        jButton5.setText("Search");
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1221, 430, -1, 37));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setText("Employee ID");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 420, 113, 37));

        sid1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel1.add(sid1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 420, 174, 37));

        jButton6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/if_icon-ios7-search-strong_211817 (1).png"))); // NOI18N
        jButton6.setText("Search");
        jButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 420, 140, 40));

        jButton7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton7.setText("Clear");
        jButton7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1340, 430, 90, 40));

        jButton8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton8.setText("Clear");
        jButton8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 420, 120, 40));

        jButton9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton9.setText("Delete");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1443, 430, 90, 40));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/body.jpg"))); // NOI18N
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1590, 900));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1590, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 900, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mark1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mark1ActionPerformed
        Date d=new Date();
        DateFormat time1=new SimpleDateFormat("HH:mm:ss");
            String Eid=Aeid.getText();
            if((Eid.compareTo("")!=0))
            {
                    try
                    {
                        String p="select * from empdet where EID='"+Eid+"'";
                        pst=conn.prepareStatement(p);
                        rs=pst.executeQuery();
                        if(rs.next())
                        {
                                String type=rs.getString("type");
                                double sala=Double.parseDouble(rs.getString("Salary"));
                                String b=null;
                                String c=null;
                                if(type.compareTo("Temporary")==0)
                                {
                                    String aa="select Temp from event_booking where Date='"+mm.dates+"'";
                                    pst=conn.prepareStatement(aa);
                                    ResultSet rs1=pst.executeQuery();
                                    String ab=null;
                                    if(rs1.next())
                                        ab=rs1.getString("Temp");
                                    StringTokenizer st=new StringTokenizer(ab,",");
                                    while(st.hasMoreTokens())
                                    {
                                        String w1=st.nextToken();
                                        if(w1.compareTo(Eid)==0)
                                        {
                                            try{
                                                if(time1.format(d).compareTo("09:00:00")<0)
                                                {
                                                    b="insert into attendance (EID,Date,ArrivalTime,status) values ('"+Eid+"','"+mm.dates+"','"+time1.format(d)+"','f')";
                                                    c="insert into temp_emp_salary (EID,Day,Day_salary,Salary) values ('"+Eid+"','"+mm.dates+"','"+sala+"','"+sala+"')";
                                                }
                                                else
                                                {
                                                    b="insert into attendance (EID,Date,ArrivalTime,status) values ('"+Eid+"','"+mm.dates+"','"+time1.format(d)+"','h')";
                                                    c="insert into temp_emp_salary (EID,Day,Day_salary,Salary) values ('"+Eid+"','"+mm.dates+"','"+sala*(3/4)+"','"+sala*(3/4)+"')";
                                                }
                                                pst=conn.prepareStatement(b);
                                                pst.execute();
                                                pst=conn.prepareStatement(c);
                                                pst.execute();
                                                JOptionPane.showMessageDialog(null, "Attendance Recorded");
                                                Aeid.setText("");
                                                show_table1();
                                            }
                                            catch(Exception e){
                                                JOptionPane.showMessageDialog(null, "This ID has been used earlier");
                                            }
                                        }
                                    }
                                }
                                else
                                {
                                    try{
                                        if(time1.format(d).compareTo("09:00:00")<0)
                                            b="insert into attendance (EID,Date,ArrivalTime,status) values ('"+Eid+"','"+mm.dates+"','"+time1.format(d)+"','f')";
                                        else
                                            b="insert into attendance (EID,Date,ArrivalTime,status) values ('"+Eid+"','"+mm.dates+"','"+time1.format(d)+"','h')";
                                        pst=conn.prepareStatement(b);
                                        pst.execute();
                                        JOptionPane.showMessageDialog(null, "Attendance Recorded");
                                        Aeid.setText("");
                                        show_table1();
                                    }
                                    catch(Exception e){
                                        JOptionPane.showMessageDialog(null, "This ID has been used earlier");
                                    }
                                }
                        } else {
                            JOptionPane.showMessageDialog(null, "ID not found");
                        }
                    }
                    catch(Exception e)
                    {
                        JOptionPane.showMessageDialog(null, e+" last");
                    }
        }
        else
            JOptionPane.showMessageDialog(null, "Please Enter an ID Number");
    }//GEN-LAST:event_mark1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        Aeid.setText("");
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void mark2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mark2ActionPerformed
        
        Date d=new Date();
        DateFormat time1=new SimpleDateFormat("HH:mm:ss");
        if(Leid.getText().compareTo("")!=0&&reason.getText().compareTo("")!=0)
        {
                String lid=Leid.getText();
                String Reason=reason.getText();

                    try
                    {
                        String zz="select * from attendance where EID='"+lid+"' and Date='"+mm.dates+"'";
                        pst=conn.prepareStatement(zz);
                        rs=pst.executeQuery();
                        if(rs.next())
                        {
                            String stat=rs.getString("Status");
                            if(rs.getString("LeavingTime")==null)
                            {
                                try
                                {
                                    String k=null;
                                    String b11="select * from event_booking where Date='"+mm.dates+"'";
                                    pst=conn.prepareStatement(b11);
                                    ResultSet f1=pst.executeQuery();
                                    if(f1.next())
                                    {
                                        if(time1.format(d).compareTo("22:00:00")<0)
                                        {
                                            k="update attendance set LeavingTime='"+time1.format(d)+"',Reason_to_early_leave='"+Reason+"',Status='h' where EID='"+lid+"' and Date='"+mm.dates+"'";
                                        }
                                        else
                                        {
                                            if(stat.compareTo("f")==0)
                                            {
                                                k="update attendance set LeavingTime='"+time1.format(d)+"',Reason_to_early_leave='"+Reason+"',Status='f' where EID='"+lid+"' and Date='"+mm.dates+"'";
                                            }
                                            else
                                                k="update attendance set LeavingTime='"+time1.format(d)+"',Reason_to_early_leave='"+Reason+"',Status='h' where EID='"+lid+"' and Date='"+mm.dates+"'";
                                        }
                                    }
                                    else
                                    {
                                        if(time1.format(d).compareTo("18:00:00")<0)
                                        {
                                            k="update attendance set LeavingTime='"+time1.format(d)+"',Reason_to_early_leave='"+Reason+"',Status='h' where EID='"+lid+"' and Date='"+mm.dates+"'";
                                        }
                                        else
                                        {
                                            if(stat.compareTo("f")==0)
                                            {
                                                k="update attendance set LeavingTime='"+time1.format(d)+"',Reason_to_early_leave='"+Reason+"',Status='f' where EID='"+lid+"' and Date='"+mm.dates+"'";
                                            }
                                            else
                                                k="update attendance set LeavingTime='"+time1.format(d)+"',Reason_to_early_leave='"+Reason+"',Status='h' where EID='"+lid+"' and Date='"+mm.dates+"'";
                                        }
                                    }
                                    pst=conn.prepareStatement(k);
                                    pst.execute();
                                    JOptionPane.showMessageDialog(null, "Recorded");
                                    Leid.setText("");
                                    reason.setText("");
                                    show_table1();
                                }
                                catch(Exception e)
                                {
                                    JOptionPane.showMessageDialog(null, "Error");
                                }
                            }
                            else
                                JOptionPane.showMessageDialog(null, "Already Marked");
                        }
                        else
                            JOptionPane.showMessageDialog(null, "There are no attendance by this employee");
                    }
                    catch(SQLException | HeadlessException e)
                    {
                        JOptionPane.showMessageDialog(null, e+" There is no attendance by this employee");
                    }
                
                
        }
        else
            JOptionPane.showMessageDialog(null, "Fields are empty");
    }//GEN-LAST:event_mark2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        Leid.setText("");
        reason.setText("");
    }//GEN-LAST:event_jButton4ActionPerformed

    private void AeidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AeidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AeidActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        if(sid.getText().compareTo("")!=0)
        {
            try {
                String a=sid.getText();
                String b="select e.EID,e.FName,e.Surname,a.Date,a.Reason from empdet e,absentees a where a.EID='"+a+"' and e.EID=a.EID order by a.Date desc";
                pst=conn.prepareStatement(b);
                rs=pst.executeQuery();
                etable2.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (SQLException ex) {
               JOptionPane.showMessageDialog(null, ex);
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Search field is empty");
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        if(sid1.getText().compareTo("")!=0)
        {
            try {
                String a=sid1.getText();
                String b="select e.EID,e.FName,e.Surname,a.ArrivalTime,a.LeavingTime,a.Reason_to_early_leave,a.Status from empdet e,attendance a where a.EID='"+a+"' and e.EID=a.EID and a.Date='"+mm.dates+"'";
                pst=conn.prepareStatement(b);
                rs=pst.executeQuery();
                Atttable.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
        else
        JOptionPane.showMessageDialog(null, "Search field is empty");

    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if((eid3.getText().compareTo("")!=0)&&(date3.getDate()!=null)&&(reason3.getText().compareTo("")!=0))
        {
            try {
                String rr="select * from empdet where EID='"+eid3.getText()+"'";
                pst=conn.prepareStatement(rr);
                rs=pst.executeQuery();
                if(rs.next())
                {

                        //String day=mm.day.format(mm.cal.getTime());  
                            String EID=eid3.getText();
                            String datee1=mm.day.format(date3.getDate());
                            //String datee2=mm.day.format(date4.getDate());
                            String Reason=reason3.getText();
                            if(datee1.compareTo(mm.dates)>0/*&&datee2.equals("")*/)
                                {
                                    String a="insert into absentees(EID,Date,Reason) values('"+EID+"','"+datee1+"','"+Reason+"')";
                                    pst=conn.prepareStatement(a);
                                    pst.execute();
                                    show_table2();
                                    JOptionPane.showMessageDialog(null, "Record added");
                                    eid3.setText("");
                                    reason3.setText("");
                                    date3.setDate(null);
                                }
//                                else if(datee1.compareTo(mm.dates)>0/*&&!datee2.equals("")*/)
//                                {
//                                    String a="insert into absentees(EID,Date,Reason) values('"+EID+"','"+datee1+"','"+Reason+"')";
//                                    pst=conn.prepareStatement(a);
//                                    pst.execute();
//                                    show_table2();
//                                    JOptionPane.showMessageDialog(null, "Record added");
//                                    eid3.setText("");
//                                    reason3.setText("");
//                                    date3.setDate(null);
//                                }
                                else
                                    JOptionPane.showMessageDialog(null, "Date is invalid");
               }
                else
                    JOptionPane.showMessageDialog(null, " ID is wrong");
            } catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,e+" 22");
            }
        }
        else
            JOptionPane.showMessageDialog(null, " Must fill all the fields");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
//        eid3.setText("");
//        date3.setDate(null);
//        reason3.setText("");
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        sid.setText("");
        show_table2();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        sid.setText("");
        show_table1();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        if(EID==null)
            JOptionPane.showMessageDialog(null, "Select an employee");
        else
        {
            try {
                String a="delete from absentees where EID='"+EID+"' and Date='"+DATE+"'";
                pst=conn.prepareStatement(a);
                pst.execute();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error");
            }
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void etable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_etable2MouseClicked
        int r=etable2.getSelectedRow();
        EID=etable2.getModel().getValueAt(r, 0).toString();
        DATE=etable2.getModel().getValueAt(r, 3).toString();
        sid.setText(EID);
    }//GEN-LAST:event_etable2MouseClicked

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        Atttable.clearSelection();
        etable2.clearSelection();
    }//GEN-LAST:event_jLabel10MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Aeid;
    private javax.swing.JTable Atttable;
    private javax.swing.JTextField Leid;
    private com.toedter.calendar.JDateChooser date3;
    private javax.swing.JTextField eid3;
    private javax.swing.JTable etable2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JButton mark1;
    private javax.swing.JButton mark2;
    private javax.swing.JTextArea reason;
    private javax.swing.JTextArea reason3;
    private javax.swing.JTextField sid;
    private javax.swing.JTextField sid1;
    // End of variables declaration//GEN-END:variables

}
