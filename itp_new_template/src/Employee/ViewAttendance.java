
package Employee;

import dbconnect.dbconnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

public class ViewAttendance extends javax.swing.JInternalFrame {

    Connection conn=null;
    PreparedStatement pst=null;
    ResultSet rs=null;
    methods mm=new methods();
    public ViewAttendance() {
        initComponents();
        conn=dbconnect.connect();
        today_perm_date();
        today_temp_date();
        today_attendance();
    }
    private void today_perm_date()
    {
        try {
            String a="select e.EID,e.FName,e.Surname,e.Department,e.Position,a.Date,a.ArrivalTime,a.LeavingTime,a.Reason_to_early_leave from empdet e,attendance a where a.EID=e.EID and a.Date='"+mm.dates+"' AND (e.type='Permanant' or e.type='Admin')";
            pst=conn.prepareStatement(a);
            rs=pst.executeQuery();
            table1.setModel(DbUtils.resultSetToTableModel(rs));
        } catch(Exception e) {
            System.out.println(e);
        }
    }
    private void today_temp_date()
    {
        try {
            String a="select e.EID,e.FName,e.Surname,a.Date,a.ArrivalTime,a.LeavingTime,a.Reason_to_early_leave from empdet e,attendance a where a.Date='"+mm.dates+"' AND e.type='Temporary' AND a.EID=e.EID";
            pst=conn.prepareStatement(a);
            rs=pst.executeQuery();
            table2.setModel(DbUtils.resultSetToTableModel(rs));
        } catch(Exception e) {
            System.out.println(e);
        }
    }
    private void today_attendance()
    {
        try {
            String a="select e.EID,e.FName,e.Surname,e.type,a.* from empdet e,attendance a where e.EID=a.EID and a.Date='"+mm.dates+"'";
            pst=conn.prepareStatement(a);
            rs=pst.executeQuery();
            table3.setModel(DbUtils.resultSetToTableModel(rs));
        } catch(Exception e) {
            System.out.println(e);
        }
    }
    private void search_table(String id,String name,String dep,String job,String type)
    {
        String Type=type;
        String a=id;
        String b=name;
        String c=dep;
        String d=job;
        String ta = null;
        if((a.compareTo("")!=0)&&(b.compareTo("")==0)&&(c.compareTo("")==0)&&(d.compareTo("")==0))
        {
            ta="select e.EID,e.FName,e.Surname,a.ArrivalTime,a.LeavingTime from empdet e,attendance a where e.EID='"+id+"' and e.EID=a.EID and e.type='"+Type+"' and a.Date='"+mm.dates+"'";
        }
        else if((a.compareTo("")!=0)&&(b.compareTo("")!=0)&&(c.compareTo("")==0)&&(d.compareTo("")==0))
        {
            ta="select e.EID,e.FName,e.Surname,a.ArrivalTime,a.LeavingTime from empdet e,attendance a where  e.EID=a.EID and e.type='"+Type+"' and e.EID='"+id+"' and e.Surname='"+b+"' and a.Date='"+mm.dates+"'";
        }
        else if((a.compareTo("")!=0)&&(b.compareTo("")!=0)&&(c.compareTo("")!=0)&&(d.compareTo("")==0))
        {
            ta="select e.EID,e.FName,e.Surname,a.ArrivalTime,a.LeavingTime from empdet e,attendance a where e.EID='"+id+"' and e.Surname='"+b+"' and e.Department='"+c+"' and e.EID=a.EID and e.type='"+Type+"' and a.Date='"+mm.dates+"'";
        }
        else if((a.compareTo("")!=0)&&(b.compareTo("")!=0)&&(c.compareTo("")!=0)&&(d.compareTo("")!=0))
        {
            ta="select e.EID,e.FName,e.Surname,a.ArrivalTime,a.LeavingTime from empdet e,attendance a where e.EID='"+id+"' and e.Surname='"+b+"' and e.Department='"+c+"' and e.Position='"+d+"' and e.EID=a.EID and e.type='"+Type+"' and a.Date='"+mm.dates+"'";
        }
        else if((a.compareTo("")==0)&&(b.compareTo("")!=0)&&(c.compareTo("")==0)&&(d.compareTo("")==0))
        {
            ta="select e.EID,e.FName,e.Surname,a.ArrivalTime,a.LeavingTime from empdet e,attendance a where e.Surname='"+b+"' and e.EID=a.EID and e.type='"+Type+"' and a.Date='"+mm.dates+"'";
        }
        else if((a.compareTo("")==0)&&(b.compareTo("")!=0)&&(c.compareTo("")!=0)&&(d.compareTo("")==0))
        {
            ta="select e.EID,e.FName,e.Surname,a.ArrivalTime,a.LeavingTime from empdet e,attendance a where e.Surname='"+b+"' and e.Department='"+c+"' and e.EID=a.EID and e.type='"+Type+"' and a.Date='"+mm.dates+"'";
        }
        else if((a.compareTo("")==0)&&(b.compareTo("")!=0)&&(c.compareTo("")!=0)&&(d.compareTo("")!=0))
        {
            ta="select e.EID,e.FName,e.Surname,a.ArrivalTime,a.LeavingTime from empdet e,attendance a where e.Surname='"+b+"' and e.Department='"+c+"' and e.Position='"+d+"' and e.EID=a.EID and e.type='"+Type+"' and a.Date='"+mm.dates+"'";
        }
        else if((a.compareTo("")==0)&&(b.compareTo("")==0)&&(c.compareTo("")!=0)&&(d.compareTo("")==0))
        {
            ta="select e.EID,e.FName,e.Surname,a.ArrivalTime,a.LeavingTime from empdet e,attendance a where e.Department='"+c+"' and e.EID=a.EID and e.type='"+Type+"' and a.Date='"+mm.dates+"'";
        }
        else if((a.compareTo("")==0)&&(b.compareTo("")==0)&&(c.compareTo("")!=0)&&(d.compareTo("")!=0))
        {
            ta="select e.EID,e.FName,e.Surname,a.ArrivalTime,a.LeavingTime from empdet e,attendance a where e.Department='"+c+"' and e.Position='"+d+"' and e.EID=a.EID and e.type='"+Type+"' and a.Date='"+mm.dates+"'";
        }
        else if((a.compareTo("")==0)&&(b.compareTo("")==0)&&(c.compareTo("")==0)&&(d.compareTo("")!=0))
        {
            ta="select e.EID,e.FName,e.Surname,a.ArrivalTime,a.LeavingTime from empdet e,attendance a where e.Position='"+d+"' and e.EID=a.EID and e.type='"+Type+"' and a.Date='"+mm.dates+"'";
        }
        try
        {
            pst=conn.prepareStatement(ta);
            rs=pst.executeQuery();
            table1.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        search = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        srch_surname = new javax.swing.JTextField();
        srch_dep = new javax.swing.JComboBox();
        srch_job = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table2 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        search1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        srch_surname1 = new javax.swing.JTextField();
        srch_dep1 = new javax.swing.JComboBox();
        srch_job1 = new javax.swing.JComboBox();
        jButton2 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        date1 = new com.toedter.calendar.JDateChooser();
        jScrollPane3 = new javax.swing.JScrollPane();
        table3 = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1600, 925));
        setMinimumSize(new java.awt.Dimension(1600, 925));
        setPreferredSize(new java.awt.Dimension(1600, 925));

        jPanel1.setPreferredSize(new java.awt.Dimension(1140, 545));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel25.setText("View Attendance");
        jPanel1.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(661, -2, 312, 50));

        jTabbedPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(0, 0, 0)));
        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel2MouseClicked(evt);
            }
        });
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        table1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Arrival Time", "Leaving Time"
            }
        ));
        table1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        table1.setGridColor(new java.awt.Color(0, 0, 0));
        table1.setSelectionBackground(new java.awt.Color(0, 0, 0));
        table1.setSelectionForeground(new java.awt.Color(204, 204, 204));
        jScrollPane1.setViewportView(table1);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 111, 1100, 440));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ID");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(91, 42, 40, 40));

        search.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel2.add(search, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 42, 140, 40));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Surname");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 42, 70, 40));

        srch_surname.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        srch_surname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                srch_surnameActionPerformed(evt);
            }
        });
        jPanel2.add(srch_surname, new org.netbeans.lib.awtextra.AbsoluteConstraints(358, 40, 160, 40));

        srch_dep.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        srch_dep.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Department", "Event Management", "Customer Management", "Employee Management", "Financial Department", "Inventory Management", "Transport Management", "Restaurant Department", "Maintenance department" }));
        srch_dep.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        srch_dep.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                srch_depMouseClicked(evt);
            }
        });
        srch_dep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                srch_depActionPerformed(evt);
            }
        });
        jPanel2.add(srch_dep, new org.netbeans.lib.awtextra.AbsoluteConstraints(543, 40, 190, 40));

        srch_job.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        srch_job.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Job", "Cashier", "Cleaner", "Clerk", "Cook", "Driver", "Photographer", "Receptionist", "Waiter/Waitress", "Accountant", "HR Manager", "Maintenance Supervisor", "Stock Manager", "Transport Manager", "Manager" }));
        srch_job.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        srch_job.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                srch_jobActionPerformed(evt);
            }
        });
        jPanel2.add(srch_job, new org.netbeans.lib.awtextra.AbsoluteConstraints(761, 40, 180, 40));

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/if_icon-ios7-search-strong_211817 (1).png"))); // NOI18N
        jButton1.setText("SEARCH");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(992, 40, 140, 40));

        jTabbedPane1.addTab("Permanant Employees", jPanel2);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel3MouseClicked(evt);
            }
        });
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        table2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        table2.setModel(new javax.swing.table.DefaultTableModel(
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
                "ID", "Fname", "Surname", "Arrival Time", "Leaving Time"
            }
        ));
        table2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        table2.setGridColor(new java.awt.Color(0, 0, 0));
        table2.setSelectionBackground(new java.awt.Color(0, 0, 0));
        table2.setSelectionForeground(new java.awt.Color(204, 204, 204));
        jScrollPane2.setViewportView(table2);

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(91, 118, 1100, 430));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("ID");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(91, 42, 42, 35));

        search1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel3.add(search1, new org.netbeans.lib.awtextra.AbsoluteConstraints(145, 42, 113, 35));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Surname");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(263, 42, 80, 35));

        srch_surname1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel3.add(srch_surname1, new org.netbeans.lib.awtextra.AbsoluteConstraints(341, 42, 130, 35));

        srch_dep1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        srch_dep1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Department", "Event Management", "Customer Management", "Employee Management", "Financial Department", "Inventory Management", "Transport Management", "Restaurant Department", "Maintenance department" }));
        srch_dep1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        srch_dep1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                srch_dep1ActionPerformed(evt);
            }
        });
        jPanel3.add(srch_dep1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 40, 190, 35));

        srch_job1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        srch_job1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Job", "Cashier", "Cleaner", "Clerk", "Cook", "Driver", "Photographer", "Receptionist", "Waiter/Waitress", "Accountant", "HR Manager", "Maintenance Supervisor", "Stock Manager", "Transport Manager", "Manager" }));
        srch_job1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        srch_job1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                srch_job1ActionPerformed(evt);
            }
        });
        jPanel3.add(srch_job1, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 40, 170, 35));

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/if_icon-ios7-search-strong_211817 (1).png"))); // NOI18N
        jButton2.setText("SEARCH");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 40, 130, 35));

        jTabbedPane1.addTab("Temporary Employees", jPanel3);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel4MouseClicked(evt);
            }
        });
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Date");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(91, 42, 62, 35));

        date1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                date1MouseClicked(evt);
            }
        });
        jPanel4.add(date1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 40, 230, 35));

        table3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        table3.setModel(new javax.swing.table.DefaultTableModel(
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
                "EID", "Fname", "Surname", "Arrival Time", "Leaving Time", "Type"
            }
        ));
        table3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        table3.setGridColor(new java.awt.Color(0, 0, 0));
        table3.setSelectionBackground(new java.awt.Color(0, 0, 0));
        table3.setSelectionForeground(new java.awt.Color(204, 204, 204));
        jScrollPane3.setViewportView(table3);

        jPanel4.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(87, 108, 1090, 450));

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/if_icon-ios7-search-strong_211817 (1).png"))); // NOI18N
        jButton3.setText("Click");
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 40, 140, 35));

        jTabbedPane1.addTab("View According to Date", jPanel4);

        jPanel1.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 110, 1310, 680));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/body.jpg"))); // NOI18N
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1590, 900));

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

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        DateFormat date=new SimpleDateFormat("yyyy-MM-dd");
        String a=date.format(date1.getDate());
        if(a.compareTo("")!=0)
        {
            try {
                String b="select * from attendance where Date='"+a+"'";
                pst=conn.prepareStatement(b);
                rs=pst.executeQuery();
                table3.setModel(DbUtils.resultSetToTableModel(rs));

            } catch(Exception e)
            {
                System.out.println(e);
            }
        }
        else
        JOptionPane.showMessageDialog(null, "Select a date");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void date1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_date1MouseClicked
        DateFormat date=new SimpleDateFormat("yyyy-MM-dd");
        String a=date.format(date1.getDate());
        System.out.println(a);
    }//GEN-LAST:event_date1MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String a1=search.getText();
        String a2=srch_surname.getText();
        int a3=srch_dep.getSelectedIndex();
        int a4=srch_job.getSelectedIndex();
        String a5=srch_dep.getSelectedItem().toString();
        String a6=srch_job.getSelectedItem().toString();
        String ta=null;
        if((a1.compareTo("")==0)&&(a2.compareTo("")==0)&&(a3==0)&&(a4==0))
        {
            JOptionPane.showMessageDialog(null, "Search fields are empty");
        }
        else
        {
            if((a1.compareTo("")==0)&&(a2.compareTo("")==0)&&(a3==0)&&(a4!=0))
            ta="select e.EID,e.FName,e.Surname,e.Department,e.Position,a.Date,a.ArrivalTime,a.LeavingTime,a.Reason_to_early_leave from empdet e,attendance a where a.EID=e.EID and a.Date='"+mm.dates+"' AND e.type='Temporary' and e.Position='"+a6+"'";
            else if((a1.compareTo("")==0)&&(a2.compareTo("")==0)&&(a3!=0)&&(a4==0))
            ta="select e.EID,e.FName,e.Surname,e.Department,e.Position,a.Date,a.ArrivalTime,a.LeavingTime,a.Reason_to_early_leave from empdet e,attendance a where a.EID=e.EID and a.Date='"+mm.dates+"' AND e.type='Temporary' and e.Department='"+a5+"'";
            else if((a1.compareTo("")==0)&&(a2.compareTo("")==0)&&(a3!=0)&&(a4!=0))
            ta="select e.EID,e.FName,e.Surname,e.Department,e.Position,a.Date,a.ArrivalTime,a.LeavingTime,a.Reason_to_early_leave from empdet e,attendance a where a.EID=e.EID and a.Date='"+mm.dates+"' AND e.type='Temporary' and e.Position='"+a6+"' and e.Department='"+a5+"'";
            else if((a1.compareTo("")==0)&&(a2.compareTo("")!=0)&&(a3==0)&&(a4==0))
            ta="select e.EID,e.FName,e.Surname,e.Department,e.Position,a.Date,a.ArrivalTime,a.LeavingTime,a.Reason_to_early_leave from empdet e,attendance a where a.EID=e.EID and a.Date='"+mm.dates+"' AND e.type='Temporary' and e.Surname like '"+a2+"%'";
            else if((a1.compareTo("")==0)&&(a2.compareTo("")!=0)&&(a3==0)&&(a4!=0))
            ta="select e.EID,e.FName,e.Surname,e.Department,e.Position,a.Date,a.ArrivalTime,a.LeavingTime,a.Reason_to_early_leave from empdet e,attendance a where a.EID=e.EID and a.Date='"+mm.dates+"' AND e.type='Temporary' and e.Surname like '"+a2+"%' and e.Position='"+a6+"'";
            else if((a1.compareTo("")==0)&&(a2.compareTo("")!=0)&&(a3!=0)&&(a4==0))
            ta="select e.EID,e.FName,e.Surname,e.Department,e.Position,a.Date,a.ArrivalTime,a.LeavingTime,a.Reason_to_early_leave from empdet e,attendance a where a.EID=e.EID and a.Date='"+mm.dates+"' AND e.type='Temporary' and e.Surname like '"+a2+"%' and e.Department='"+a5+"'";
            else if((a1.compareTo("")==0)&&(a2.compareTo("")!=0)&&(a3!=0)&&(a4!=0))
            ta="select e.EID,e.FName,e.Surname,e.Department,e.Position,a.Date,a.ArrivalTime,a.LeavingTime,a.Reason_to_early_leave from empdet e,attendance a where a.EID=e.EID and a.Date='"+mm.dates+"' AND e.type='Temporary' and e.Surname like '"+a2+"%' and e.Department='"+a5+"' and Position='"+a6+"'";
            else if((a1.compareTo("")!=0)&&(a2.compareTo("")==0)&&(a3==0)&&(a4==0))
            ta="select e.EID,e.FName,e.Surname,e.Department,e.Position,a.Date,a.ArrivalTime,a.LeavingTime,a.Reason_to_early_leave from empdet e,attendance a where a.EID=e.EID and a.Date='"+mm.dates+"' AND e.type='Temporary' and e.EID='"+a1+"'";
            else if((a1.compareTo("")!=0)&&(a2.compareTo("")==0)&&(a3==0)&&(a4!=0))
            ta="select e.EID,e.FName,e.Surname,e.Department,e.Position,a.Date,a.ArrivalTime,a.LeavingTime,a.Reason_to_early_leave from empdet e,attendance a where a.EID=e.EID and a.Date='"+mm.dates+"' AND e.type='Temporary' and e.EID='"+a1+"' and e.Position='"+a6+"'";
            else if((a1.compareTo("")!=0)&&(a2.compareTo("")==0)&&(a3!=0)&&(a4==0))
            ta="select e.EID,e.FName,e.Surname,e.Department,e.Position,a.Date,a.ArrivalTime,a.LeavingTime,a.Reason_to_early_leave from empdet e,attendance a where a.EID=e.EID and a.Date='"+mm.dates+"' AND e.type='Temporary' and e.EID='"+a1+"' and e.Department='"+a5+"'";
            else if((a1.compareTo("")!=0)&&(a2.compareTo("")==0)&&(a3!=0)&&(a4!=0))
            ta="select e.EID,e.FName,e.Surname,e.Department,e.Position,a.Date,a.ArrivalTime,a.LeavingTime,a.Reason_to_early_leave from empdet e,attendance a where a.EID=e.EID and a.Date='"+mm.dates+"' AND e.type='Temporary' and e.EID='"+a1+"' and e.Position='"+a6+"' and e.Position='"+a6+"'";
            else if((a1.compareTo("")!=0)&&(a2.compareTo("")!=0)&&(a3==0)&&(a4==0))
            ta="select e.EID,e.FName,e.Surname,e.Department,e.Position,a.Date,a.ArrivalTime,a.LeavingTime,a.Reason_to_early_leave from empdet e,attendance a where a.EID=e.EID and a.Date='"+mm.dates+"' AND e.type='Temporary' and e.EID='"+a1+"' and e.Surname like '"+a2+"%'";
            else if((a1.compareTo("")!=0)&&(a2.compareTo("")!=0)&&(a3==0)&&(a4!=0))
            ta="select e.EID,e.FName,e.Surname,e.Department,e.Position,a.Date,a.ArrivalTime,a.LeavingTime,a.Reason_to_early_leave from empdet e,attendance a where a.EID=e.EID and a.Date='"+mm.dates+"' AND e.type='Temporary' and e.EID='"+a1+"' and e.Surname like '"+a2+"%' and e.Position='"+a6+"'";
            else if((a1.compareTo("")!=0)&&(a2.compareTo("")!=0)&&(a3!=0)&&(a4==0))
            ta="select e.EID,e.FName,e.Surname,e.Department,e.Position,a.Date,a.ArrivalTime,a.LeavingTime,a.Reason_to_early_leave from empdet e,attendance a where a.EID=e.EID and a.Date='"+mm.dates+"' AND e.type='Temporary' and e.EID='"+a1+"' and e.Surname like '"+a2+"%' and e.Department='"+a5+"'";
            else
            ta="select e.EID,e.FName,e.Surname,e.Department,e.Position,a.Date,a.ArrivalTime,a.LeavingTime,a.Reason_to_early_leave from empdet e,attendance a where a.EID=e.EID and a.Date='"+mm.dates+"' AND e.type='Temporary' and e.EID='"+a1+"' and e.Surname like '"+a2+"%' and e.Position='"+a6+"' and e.Department='"+a5+"'";

            try
            {
                pst=conn.prepareStatement(ta);
                rs=pst.executeQuery();
                table2.setModel(DbUtils.resultSetToTableModel(rs));
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void srch_job1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_srch_job1ActionPerformed
        String a1=search.getText();
        String a2=srch_surname.getText();
        int a3=srch_dep.getSelectedIndex();
        int a4=srch_job.getSelectedIndex();
        String a5=srch_dep.getSelectedItem().toString();
        String a6=srch_job.getSelectedItem().toString();
        String ta=null;
        if((a1.compareTo("")==0)&&(a2.compareTo("")==0)&&(a3==0)&&(a4==0))
        {
            today_temp_date();
        }
        else
        {
            if((a1.compareTo("")==0)&&(a2.compareTo("")==0)&&(a3==0)&&(a4!=0))
            ta="select e.EID,e.FName,e.Surname,e.Department,e.Position,a.Date,a.ArrivalTime,a.LeavingTime,a.Reason_to_early_leave from empdet e,attendance a where a.EID=e.EID and a.Date='"+mm.dates+"' AND e.type='Temporary' and e.Position='"+a6+"'";
            else if((a1.compareTo("")==0)&&(a2.compareTo("")==0)&&(a3!=0)&&(a4==0))
            ta="select e.EID,e.FName,e.Surname,e.Department,e.Position,a.Date,a.ArrivalTime,a.LeavingTime,a.Reason_to_early_leave from empdet e,attendance a where a.EID=e.EID and a.Date='"+mm.dates+"' AND e.type='Temporary' and e.Department='"+a5+"'";
            else if((a1.compareTo("")==0)&&(a2.compareTo("")==0)&&(a3!=0)&&(a4!=0))
            ta="select e.EID,e.FName,e.Surname,e.Department,e.Position,a.Date,a.ArrivalTime,a.LeavingTime,a.Reason_to_early_leave from empdet e,attendance a where a.EID=e.EID and a.Date='"+mm.dates+"' AND e.type='Temporary' and e.Position='"+a6+"' and e.Department='"+a5+"'";
            else if((a1.compareTo("")==0)&&(a2.compareTo("")!=0)&&(a3==0)&&(a4==0))
            ta="select e.EID,e.FName,e.Surname,e.Department,e.Position,a.Date,a.ArrivalTime,a.LeavingTime,a.Reason_to_early_leave from empdet e,attendance a where a.EID=e.EID and a.Date='"+mm.dates+"' AND e.type='Temporary' and e.Surname like '"+a2+"%'";
            else if((a1.compareTo("")==0)&&(a2.compareTo("")!=0)&&(a3==0)&&(a4!=0))
            ta="select e.EID,e.FName,e.Surname,e.Department,e.Position,a.Date,a.ArrivalTime,a.LeavingTime,a.Reason_to_early_leave from empdet e,attendance a where a.EID=e.EID and a.Date='"+mm.dates+"' AND e.type='Temporary' and e.Surname like '"+a2+"%' and e.Position='"+a6+"'";
            else if((a1.compareTo("")==0)&&(a2.compareTo("")!=0)&&(a3!=0)&&(a4==0))
            ta="select e.EID,e.FName,e.Surname,e.Department,e.Position,a.Date,a.ArrivalTime,a.LeavingTime,a.Reason_to_early_leave from empdet e,attendance a where a.EID=e.EID and a.Date='"+mm.dates+"' AND e.type='Temporary' and e.Surname like '"+a2+"%' and e.Department='"+a5+"'";
            else if((a1.compareTo("")==0)&&(a2.compareTo("")!=0)&&(a3!=0)&&(a4!=0))
            ta="select e.EID,e.FName,e.Surname,e.Department,e.Position,a.Date,a.ArrivalTime,a.LeavingTime,a.Reason_to_early_leave from empdet e,attendance a where a.EID=e.EID and a.Date='"+mm.dates+"' AND e.type='Temporary' and e.Surname like '"+a2+"%' and e.Department='"+a5+"' and Position='"+a6+"'";
            else if((a1.compareTo("")!=0)&&(a2.compareTo("")==0)&&(a3==0)&&(a4==0))
            ta="select e.EID,e.FName,e.Surname,e.Department,e.Position,a.Date,a.ArrivalTime,a.LeavingTime,a.Reason_to_early_leave from empdet e,attendance a where a.EID=e.EID and a.Date='"+mm.dates+"' AND e.type='Temporary' and e.EID='"+a1+"'";
            else if((a1.compareTo("")!=0)&&(a2.compareTo("")==0)&&(a3==0)&&(a4!=0))
            ta="select e.EID,e.FName,e.Surname,e.Department,e.Position,a.Date,a.ArrivalTime,a.LeavingTime,a.Reason_to_early_leave from empdet e,attendance a where a.EID=e.EID and a.Date='"+mm.dates+"' AND e.type='Temporary' and e.EID='"+a1+"' and e.Position='"+a6+"'";
            else if((a1.compareTo("")!=0)&&(a2.compareTo("")==0)&&(a3!=0)&&(a4==0))
            ta="select e.EID,e.FName,e.Surname,e.Department,e.Position,a.Date,a.ArrivalTime,a.LeavingTime,a.Reason_to_early_leave from empdet e,attendance a where a.EID=e.EID and a.Date='"+mm.dates+"' AND e.type='Temporary' and e.EID='"+a1+"' and e.Department='"+a5+"'";
            else if((a1.compareTo("")!=0)&&(a2.compareTo("")==0)&&(a3!=0)&&(a4!=0))
            ta="select e.EID,e.FName,e.Surname,e.Department,e.Position,a.Date,a.ArrivalTime,a.LeavingTime,a.Reason_to_early_leave from empdet e,attendance a where a.EID=e.EID and a.Date='"+mm.dates+"' AND e.type='Temporary' and e.EID='"+a1+"' and e.Position='"+a6+"' and e.Position='"+a6+"'";
            else if((a1.compareTo("")!=0)&&(a2.compareTo("")!=0)&&(a3==0)&&(a4==0))
            ta="select e.EID,e.FName,e.Surname,e.Department,e.Position,a.Date,a.ArrivalTime,a.LeavingTime,a.Reason_to_early_leave from empdet e,attendance a where a.EID=e.EID and a.Date='"+mm.dates+"' AND e.type='Temporary' and e.EID='"+a1+"' and e.Surname like '"+a2+"%'";
            else if((a1.compareTo("")!=0)&&(a2.compareTo("")!=0)&&(a3==0)&&(a4!=0))
            ta="select e.EID,e.FName,e.Surname,e.Department,e.Position,a.Date,a.ArrivalTime,a.LeavingTime,a.Reason_to_early_leave from empdet e,attendance a where a.EID=e.EID and a.Date='"+mm.dates+"' AND e.type='Temporary' and e.EID='"+a1+"' and e.Surname like '"+a2+"%' and e.Position='"+a6+"'";
            else if((a1.compareTo("")!=0)&&(a2.compareTo("")!=0)&&(a3!=0)&&(a4==0))
            ta="select e.EID,e.FName,e.Surname,e.Department,e.Position,a.Date,a.ArrivalTime,a.LeavingTime,a.Reason_to_early_leave from empdet e,attendance a where a.EID=e.EID and a.Date='"+mm.dates+"' AND e.type='Temporary' and e.EID='"+a1+"' and e.Surname like '"+a2+"%' and e.Department='"+a5+"'";
            else
            ta="select e.EID,e.FName,e.Surname,e.Department,e.Position,a.Date,a.ArrivalTime,a.LeavingTime,a.Reason_to_early_leave from empdet e,attendance a where a.EID=e.EID and a.Date='"+mm.dates+"' AND e.type='Temporary' and e.EID='"+a1+"' and e.Surname like '"+a2+"%' and e.Position='"+a6+"' and e.Department='"+a5+"'";

            try
            {
                pst=conn.prepareStatement(ta);
                rs=pst.executeQuery();
                table2.setModel(DbUtils.resultSetToTableModel(rs));
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_srch_job1ActionPerformed

    private void srch_dep1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_srch_dep1ActionPerformed
        String a1=search.getText();
        String a2=srch_surname.getText();
        int a3=srch_dep.getSelectedIndex();
        int a4=srch_job.getSelectedIndex();
        String a5=srch_dep.getSelectedItem().toString();
        String a6=srch_job.getSelectedItem().toString();
        String ta=null;
        if((a1.compareTo("")==0)&&(a2.compareTo("")==0)&&(a3==0)&&(a4==0))
        {
            today_temp_date();
        }
        else
        {
            if((a1.compareTo("")==0)&&(a2.compareTo("")==0)&&(a3==0)&&(a4!=0))
            ta="select e.EID,e.FName,e.Surname,e.Department,e.Position,a.Date,a.ArrivalTime,a.LeavingTime,a.Reason_to_early_leave from empdet e,attendance a where a.EID=e.EID and a.Date='"+mm.dates+"' AND e.type='Temporary' and e.Position='"+a6+"'";
            else if((a1.compareTo("")==0)&&(a2.compareTo("")==0)&&(a3!=0)&&(a4==0))
            ta="select e.EID,e.FName,e.Surname,e.Department,e.Position,a.Date,a.ArrivalTime,a.LeavingTime,a.Reason_to_early_leave from empdet e,attendance a where a.EID=e.EID and a.Date='"+mm.dates+"' AND e.type='Temporary' and e.Department='"+a5+"'";
            else if((a1.compareTo("")==0)&&(a2.compareTo("")==0)&&(a3!=0)&&(a4!=0))
            ta="select e.EID,e.FName,e.Surname,e.Department,e.Position,a.Date,a.ArrivalTime,a.LeavingTime,a.Reason_to_early_leave from empdet e,attendance a where a.EID=e.EID and a.Date='"+mm.dates+"' AND e.type='Temporary' and e.Position='"+a6+"' and e.Department='"+a5+"'";
            else if((a1.compareTo("")==0)&&(a2.compareTo("")!=0)&&(a3==0)&&(a4==0))
            ta="select e.EID,e.FName,e.Surname,e.Department,e.Position,a.Date,a.ArrivalTime,a.LeavingTime,a.Reason_to_early_leave from empdet e,attendance a where a.EID=e.EID and a.Date='"+mm.dates+"' AND e.type='Temporary' and e.Surname like '"+a2+"%'";
            else if((a1.compareTo("")==0)&&(a2.compareTo("")!=0)&&(a3==0)&&(a4!=0))
            ta="select e.EID,e.FName,e.Surname,e.Department,e.Position,a.Date,a.ArrivalTime,a.LeavingTime,a.Reason_to_early_leave from empdet e,attendance a where a.EID=e.EID and a.Date='"+mm.dates+"' AND e.type='Temporary' and e.Surname like '"+a2+"%' and e.Position='"+a6+"'";
            else if((a1.compareTo("")==0)&&(a2.compareTo("")!=0)&&(a3!=0)&&(a4==0))
            ta="select e.EID,e.FName,e.Surname,e.Department,e.Position,a.Date,a.ArrivalTime,a.LeavingTime,a.Reason_to_early_leave from empdet e,attendance a where a.EID=e.EID and a.Date='"+mm.dates+"' AND e.type='Temporary' and e.Surname like '"+a2+"%' and e.Department='"+a5+"'";
            else if((a1.compareTo("")==0)&&(a2.compareTo("")!=0)&&(a3!=0)&&(a4!=0))
            ta="select e.EID,e.FName,e.Surname,e.Department,e.Position,a.Date,a.ArrivalTime,a.LeavingTime,a.Reason_to_early_leave from empdet e,attendance a where a.EID=e.EID and a.Date='"+mm.dates+"' AND e.type='Temporary' and e.Surname like '"+a2+"%' and e.Department='"+a5+"' and Position='"+a6+"'";
            else if((a1.compareTo("")!=0)&&(a2.compareTo("")==0)&&(a3==0)&&(a4==0))
            ta="select e.EID,e.FName,e.Surname,e.Department,e.Position,a.Date,a.ArrivalTime,a.LeavingTime,a.Reason_to_early_leave from empdet e,attendance a where a.EID=e.EID and a.Date='"+mm.dates+"' AND e.type='Temporary' and e.EID='"+a1+"'";
            else if((a1.compareTo("")!=0)&&(a2.compareTo("")==0)&&(a3==0)&&(a4!=0))
            ta="select e.EID,e.FName,e.Surname,e.Department,e.Position,a.Date,a.ArrivalTime,a.LeavingTime,a.Reason_to_early_leave from empdet e,attendance a where a.EID=e.EID and a.Date='"+mm.dates+"' AND e.type='Temporary' and e.EID='"+a1+"' and e.Position='"+a6+"'";
            else if((a1.compareTo("")!=0)&&(a2.compareTo("")==0)&&(a3!=0)&&(a4==0))
            ta="select e.EID,e.FName,e.Surname,e.Department,e.Position,a.Date,a.ArrivalTime,a.LeavingTime,a.Reason_to_early_leave from empdet e,attendance a where a.EID=e.EID and a.Date='"+mm.dates+"' AND e.type='Temporary' and e.EID='"+a1+"' and e.Department='"+a5+"'";
            else if((a1.compareTo("")!=0)&&(a2.compareTo("")==0)&&(a3!=0)&&(a4!=0))
            ta="select e.EID,e.FName,e.Surname,e.Department,e.Position,a.Date,a.ArrivalTime,a.LeavingTime,a.Reason_to_early_leave from empdet e,attendance a where a.EID=e.EID and a.Date='"+mm.dates+"' AND e.type='Temporary' and e.EID='"+a1+"' and e.Position='"+a6+"' and e.Position='"+a6+"'";
            else if((a1.compareTo("")!=0)&&(a2.compareTo("")!=0)&&(a3==0)&&(a4==0))
            ta="select e.EID,e.FName,e.Surname,e.Department,e.Position,a.Date,a.ArrivalTime,a.LeavingTime,a.Reason_to_early_leave from empdet e,attendance a where a.EID=e.EID and a.Date='"+mm.dates+"' AND e.type='Temporary' and e.EID='"+a1+"' and e.Surname like '"+a2+"%'";
            else if((a1.compareTo("")!=0)&&(a2.compareTo("")!=0)&&(a3==0)&&(a4!=0))
            ta="select e.EID,e.FName,e.Surname,e.Department,e.Position,a.Date,a.ArrivalTime,a.LeavingTime,a.Reason_to_early_leave from empdet e,attendance a where a.EID=e.EID and a.Date='"+mm.dates+"' AND e.type='Temporary' and e.EID='"+a1+"' and e.Surname like '"+a2+"%' and e.Position='"+a6+"'";
            else if((a1.compareTo("")!=0)&&(a2.compareTo("")!=0)&&(a3!=0)&&(a4==0))
            ta="select e.EID,e.FName,e.Surname,e.Department,e.Position,a.Date,a.ArrivalTime,a.LeavingTime,a.Reason_to_early_leave from empdet e,attendance a where a.EID=e.EID and a.Date='"+mm.dates+"' AND e.type='Temporary' and e.EID='"+a1+"' and e.Surname like '"+a2+"%' and e.Department='"+a5+"'";
            else
            ta="select e.EID,e.FName,e.Surname,e.Department,e.Position,a.Date,a.ArrivalTime,a.LeavingTime,a.Reason_to_early_leave from empdet e,attendance a where a.EID=e.EID and a.Date='"+mm.dates+"' AND e.type='Temporary' and e.EID='"+a1+"' and e.Surname like '"+a2+"%' and e.Position='"+a6+"' and e.Department='"+a5+"'";

            try
            {
                pst=conn.prepareStatement(ta);
                rs=pst.executeQuery();
                table2.setModel(DbUtils.resultSetToTableModel(rs));
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_srch_dep1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String a1=search.getText();
        String a2=srch_surname.getText();
        int a3=srch_dep.getSelectedIndex();
        int a4=srch_job.getSelectedIndex();
        String a5=srch_dep.getSelectedItem().toString();
        String a6=srch_job.getSelectedItem().toString();
        String ta=null;
        if((a1.compareTo("")==0)&&(a2.compareTo("")==0)&&(a3==0)&&(a4==0))
        {
            JOptionPane.showMessageDialog(null, "Search fields are empty");
        }
        else
        {
            if((a1.compareTo("")==0)&&(a2.compareTo("")==0)&&(a3==0)&&(a4!=0))
            ta="select e.EID,e.FName,e.Surname,e.Department,e.Position,a.Date,a.ArrivalTime,a.LeavingTime,a.Reason_to_early_leave from empdet e,attendance a where a.EID=e.EID and a.Date='"+mm.dates+"' AND (e.type='Permanant' or e.type='Admin') and e.Position='"+a6+"'";
            else if((a1.compareTo("")==0)&&(a2.compareTo("")==0)&&(a3!=0)&&(a4==0))
            ta="select e.EID,e.FName,e.Surname,e.Department,e.Position,a.Date,a.ArrivalTime,a.LeavingTime,a.Reason_to_early_leave from empdet e,attendance a where a.EID=e.EID and a.Date='"+mm.dates+"' AND (e.type='Permanant' or e.type='Admin') and e.Department='"+a5+"'";
            else if((a1.compareTo("")==0)&&(a2.compareTo("")==0)&&(a3!=0)&&(a4!=0))
            ta="select e.EID,e.FName,e.Surname,e.Department,e.Position,a.Date,a.ArrivalTime,a.LeavingTime,a.Reason_to_early_leave from empdet e,attendance a where a.EID=e.EID and a.Date='"+mm.dates+"' AND (e.type='Permanant' or e.type='Admin') and e.Position='"+a6+"' and e.Department='"+a5+"'";
            else if((a1.compareTo("")==0)&&(a2.compareTo("")!=0)&&(a3==0)&&(a4==0))
            ta="select e.EID,e.FName,e.Surname,e.Department,e.Position,a.Date,a.ArrivalTime,a.LeavingTime,a.Reason_to_early_leave from empdet e,attendance a where a.EID=e.EID and a.Date='"+mm.dates+"' AND (e.type='Permanant' or e.type='Admin') and e.Surname like '"+a2+"%'";
            else if((a1.compareTo("")==0)&&(a2.compareTo("")!=0)&&(a3==0)&&(a4!=0))
            ta="select e.EID,e.FName,e.Surname,e.Department,e.Position,a.Date,a.ArrivalTime,a.LeavingTime,a.Reason_to_early_leave from empdet e,attendance a where a.EID=e.EID and a.Date='"+mm.dates+"' AND (e.type='Permanant' or e.type='Admin') and e.Surname like '"+a2+"%' and e.Position='"+a6+"'";
            else if((a1.compareTo("")==0)&&(a2.compareTo("")!=0)&&(a3!=0)&&(a4==0))
            ta="select e.EID,e.FName,e.Surname,e.Department,e.Position,a.Date,a.ArrivalTime,a.LeavingTime,a.Reason_to_early_leave from empdet e,attendance a where a.EID=e.EID and a.Date='"+mm.dates+"' AND (e.type='Permanant' or e.type='Admin') and e.Surname like '"+a2+"%' and e.Department='"+a5+"'";
            else if((a1.compareTo("")==0)&&(a2.compareTo("")!=0)&&(a3!=0)&&(a4!=0))
            ta="select e.EID,e.FName,e.Surname,e.Department,e.Position,a.Date,a.ArrivalTime,a.LeavingTime,a.Reason_to_early_leave from empdet e,attendance a where a.EID=e.EID and a.Date='"+mm.dates+"' AND (e.type='Permanant' or e.type='Admin') and e.Surname like '"+a2+"%' and e.Department='"+a5+"' and Position='"+a6+"'";
            else if((a1.compareTo("")!=0)&&(a2.compareTo("")==0)&&(a3==0)&&(a4==0))
            ta="select e.EID,e.FName,e.Surname,e.Department,e.Position,a.Date,a.ArrivalTime,a.LeavingTime,a.Reason_to_early_leave from empdet e,attendance a where a.EID=e.EID and a.Date='"+mm.dates+"' AND (e.type='Permanant' or e.type='Admin') and e.EID='"+a1+"'";
            else if((a1.compareTo("")!=0)&&(a2.compareTo("")==0)&&(a3==0)&&(a4!=0))
            ta="select e.EID,e.FName,e.Surname,e.Department,e.Position,a.Date,a.ArrivalTime,a.LeavingTime,a.Reason_to_early_leave from empdet e,attendance a where a.EID=e.EID and a.Date='"+mm.dates+"' AND (e.type='Permanant' or e.type='Admin') and e.EID='"+a1+"' and e.Position='"+a6+"'";
            else if((a1.compareTo("")!=0)&&(a2.compareTo("")==0)&&(a3!=0)&&(a4==0))
            ta="select e.EID,e.FName,e.Surname,e.Department,e.Position,a.Date,a.ArrivalTime,a.LeavingTime,a.Reason_to_early_leave from empdet e,attendance a where a.EID=e.EID and a.Date='"+mm.dates+"' AND (e.type='Permanant' or e.type='Admin') and e.EID='"+a1+"' and e.Department='"+a5+"'";
            else if((a1.compareTo("")!=0)&&(a2.compareTo("")==0)&&(a3!=0)&&(a4!=0))
            ta="select e.EID,e.FName,e.Surname,e.Department,e.Position,a.Date,a.ArrivalTime,a.LeavingTime,a.Reason_to_early_leave from empdet e,attendance a where a.EID=e.EID and a.Date='"+mm.dates+"' AND (e.type='Permanant' or e.type='Admin') and e.EID='"+a1+"' and e.Position='"+a6+"' and e.Position='"+a6+"'";
            else if((a1.compareTo("")!=0)&&(a2.compareTo("")!=0)&&(a3==0)&&(a4==0))
            ta="select e.EID,e.FName,e.Surname,e.Department,e.Position,a.Date,a.ArrivalTime,a.LeavingTime,a.Reason_to_early_leave from empdet e,attendance a where a.EID=e.EID and a.Date='"+mm.dates+"' AND (e.type='Permanant' or e.type='Admin') and e.EID='"+a1+"' and e.Surname like '"+a2+"%'";
            else if((a1.compareTo("")!=0)&&(a2.compareTo("")!=0)&&(a3==0)&&(a4!=0))
            ta="select e.EID,e.FName,e.Surname,e.Department,e.Position,a.Date,a.ArrivalTime,a.LeavingTime,a.Reason_to_early_leave from empdet e,attendance a where a.EID=e.EID and a.Date='"+mm.dates+"' AND (e.type='Permanant' or e.type='Admin') and e.EID='"+a1+"' and e.Surname like '"+a2+"%' and e.Position='"+a6+"'";
            else if((a1.compareTo("")!=0)&&(a2.compareTo("")!=0)&&(a3!=0)&&(a4==0))
            ta="select e.EID,e.FName,e.Surname,e.Department,e.Position,a.Date,a.ArrivalTime,a.LeavingTime,a.Reason_to_early_leave from empdet e,attendance a where a.EID=e.EID and a.Date='"+mm.dates+"' AND (e.type='Permanant' or e.type='Admin') and e.EID='"+a1+"' and e.Surname like '"+a2+"%' and e.Department='"+a5+"'";
            else
            ta="select e.EID,e.FName,e.Surname,e.Department,e.Position,a.Date,a.ArrivalTime,a.LeavingTime,a.Reason_to_early_leave from empdet e,attendance a where a.EID=e.EID and a.Date='"+mm.dates+"' AND (e.type='Permanant' or e.type='Admin') and e.EID='"+a1+"' and e.Surname like '"+a2+"%' and e.Position='"+a6+"' and e.Department='"+a5+"'";

            try
            {
                pst=conn.prepareStatement(ta);
                rs=pst.executeQuery();
                table1.setModel(DbUtils.resultSetToTableModel(rs));
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void srch_jobActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_srch_jobActionPerformed
        DateFormat date=new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal=Calendar.getInstance();
        String dates=date.format(cal.getTime());
        String a1=search.getText();
        String a2=srch_surname.getText();
        int a3=srch_dep.getSelectedIndex();
        int a4=srch_job.getSelectedIndex();
        String a5=srch_dep.getSelectedItem().toString();
        String a6=srch_job.getSelectedItem().toString();
        String ta=null;
        if((a1.compareTo("")==0)&&(a2.compareTo("")==0)&&(a3==0)&&(a4==0))
        {
            today_perm_date();
        }
        else
        {
            if((a1.compareTo("")==0)&&(a2.compareTo("")==0)&&(a3==0)&&(a4!=0))
            ta="select e.EID,e.FName,e.Surname,e.Department,e.Position,a.Date,a.ArrivalTime,a.LeavingTime,a.Reason_to_early_leave from empdet e,attendance a where a.EID=e.EID and a.Date='"+dates+"' AND (e.type='Permanant' or e.type='Admin') and e.Position='"+a6+"'";
            else if((a1.compareTo("")==0)&&(a2.compareTo("")==0)&&(a3!=0)&&(a4==0))
            ta="select e.EID,e.FName,e.Surname,e.Department,e.Position,a.Date,a.ArrivalTime,a.LeavingTime,a.Reason_to_early_leave from empdet e,attendance a where a.EID=e.EID and a.Date='"+dates+"' AND (e.type='Permanant' or e.type='Admin') and e.Department='"+a5+"'";
            else if((a1.compareTo("")==0)&&(a2.compareTo("")==0)&&(a3!=0)&&(a4!=0))
            ta="select e.EID,e.FName,e.Surname,e.Department,e.Position,a.Date,a.ArrivalTime,a.LeavingTime,a.Reason_to_early_leave from empdet e,attendance a where a.EID=e.EID and a.Date='"+dates+"' AND (e.type='Permanant' or e.type='Admin') and e.Position='"+a6+"' and e.Department='"+a5+"'";
            else if((a1.compareTo("")==0)&&(a2.compareTo("")!=0)&&(a3==0)&&(a4==0))
            ta="select e.EID,e.FName,e.Surname,e.Department,e.Position,a.Date,a.ArrivalTime,a.LeavingTime,a.Reason_to_early_leave from empdet e,attendance a where a.EID=e.EID and a.Date='"+dates+"' AND (e.type='Permanant' or e.type='Admin') and e.Surname like '"+a2+"%'";
            else if((a1.compareTo("")==0)&&(a2.compareTo("")!=0)&&(a3==0)&&(a4!=0))
            ta="select e.EID,e.FName,e.Surname,e.Department,e.Position,a.Date,a.ArrivalTime,a.LeavingTime,a.Reason_to_early_leave from empdet e,attendance a where a.EID=e.EID and a.Date='"+dates+"' AND (e.type='Permanant' or e.type='Admin') and e.Surname like '"+a2+"%' and e.Position='"+a6+"'";
            else if((a1.compareTo("")==0)&&(a2.compareTo("")!=0)&&(a3!=0)&&(a4==0))
            ta="select e.EID,e.FName,e.Surname,e.Department,e.Position,a.Date,a.ArrivalTime,a.LeavingTime,a.Reason_to_early_leave from empdet e,attendance a where a.EID=e.EID and a.Date='"+dates+"' AND (e.type='Permanant' or e.type='Admin') and e.Surname like '"+a2+"%' and e.Department='"+a5+"'";
            else if((a1.compareTo("")==0)&&(a2.compareTo("")!=0)&&(a3!=0)&&(a4!=0))
            ta="select e.EID,e.FName,e.Surname,e.Department,e.Position,a.Date,a.ArrivalTime,a.LeavingTime,a.Reason_to_early_leave from empdet e,attendance a where a.EID=e.EID and a.Date='"+dates+"' AND (e.type='Permanant' or e.type='Admin') and e.Surname like '"+a2+"%' and e.Department='"+a5+"' and Position='"+a6+"'";
            else if((a1.compareTo("")!=0)&&(a2.compareTo("")==0)&&(a3==0)&&(a4==0))
            ta="select e.EID,e.FName,e.Surname,e.Department,e.Position,a.Date,a.ArrivalTime,a.LeavingTime,a.Reason_to_early_leave from empdet e,attendance a where a.EID=e.EID and a.Date='"+dates+"' AND (e.type='Permanant' or e.type='Admin') and e.EID='"+a1+"'";
            else if((a1.compareTo("")!=0)&&(a2.compareTo("")==0)&&(a3==0)&&(a4!=0))
            ta="select e.EID,e.FName,e.Surname,e.Department,e.Position,a.Date,a.ArrivalTime,a.LeavingTime,a.Reason_to_early_leave from empdet e,attendance a where a.EID=e.EID and a.Date='"+dates+"' AND (e.type='Permanant' or e.type='Admin') and e.EID='"+a1+"' and e.Position='"+a6+"'";
            else if((a1.compareTo("")!=0)&&(a2.compareTo("")==0)&&(a3!=0)&&(a4==0))
            ta="select e.EID,e.FName,e.Surname,e.Department,e.Position,a.Date,a.ArrivalTime,a.LeavingTime,a.Reason_to_early_leave from empdet e,attendance a where a.EID=e.EID and a.Date='"+dates+"' AND (e.type='Permanant' or e.type='Admin') and e.EID='"+a1+"' and e.Department='"+a5+"'";
            else if((a1.compareTo("")!=0)&&(a2.compareTo("")==0)&&(a3!=0)&&(a4!=0))
            ta="select e.EID,e.FName,e.Surname,e.Department,e.Position,a.Date,a.ArrivalTime,a.LeavingTime,a.Reason_to_early_leave from empdet e,attendance a where a.EID=e.EID and a.Date='"+dates+"' AND (e.type='Permanant' or e.type='Admin') and e.EID='"+a1+"' and e.Position='"+a6+"' and e.Position='"+a6+"'";
            else if((a1.compareTo("")!=0)&&(a2.compareTo("")!=0)&&(a3==0)&&(a4==0))
            ta="select e.EID,e.FName,e.Surname,e.Department,e.Position,a.Date,a.ArrivalTime,a.LeavingTime,a.Reason_to_early_leave from empdet e,attendance a where a.EID=e.EID and a.Date='"+dates+"' AND (e.type='Permanant' or e.type='Admin') and e.EID='"+a1+"' and e.Surname like '"+a2+"%'";
            else if((a1.compareTo("")!=0)&&(a2.compareTo("")!=0)&&(a3==0)&&(a4!=0))
            ta="select e.EID,e.FName,e.Surname,e.Department,e.Position,a.Date,a.ArrivalTime,a.LeavingTime,a.Reason_to_early_leave from empdet e,attendance a where a.EID=e.EID and a.Date='"+dates+"' AND (e.type='Permanant' or e.type='Admin') and e.EID='"+a1+"' and e.Surname like '"+a2+"%' and e.Position='"+a6+"'";
            else if((a1.compareTo("")!=0)&&(a2.compareTo("")!=0)&&(a3!=0)&&(a4==0))
            ta="select e.EID,e.FName,e.Surname,e.Department,e.Position,a.Date,a.ArrivalTime,a.LeavingTime,a.Reason_to_early_leave from empdet e,attendance a where a.EID=e.EID and a.Date='"+dates+"' AND (e.type='Permanant' or e.type='Admin') and e.EID='"+a1+"' and e.Surname like '"+a2+"%' and e.Department='"+a5+"'";
            else
            ta="select e.EID,e.FName,e.Surname,e.Department,e.Position,a.Date,a.ArrivalTime,a.LeavingTime,a.Reason_to_early_leave from empdet e,attendance a where a.EID=e.EID and a.Date='"+dates+"' AND (e.type='Permanant' or e.type='Admin') and e.EID='"+a1+"' and e.Surname like '"+a2+"%' and e.Position='"+a6+"' and e.Department='"+a5+"'";

            try
            {
                pst=conn.prepareStatement(ta);
                rs=pst.executeQuery();
                table1.setModel(DbUtils.resultSetToTableModel(rs));
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_srch_jobActionPerformed

    private void srch_depActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_srch_depActionPerformed
        DateFormat date=new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal=Calendar.getInstance();
        String dates=date.format(cal.getTime());
        String a1=search.getText();
        String a2=srch_surname.getText();
        int a3=srch_dep.getSelectedIndex();
        int a4=srch_job.getSelectedIndex();
        String a5=srch_dep.getSelectedItem().toString();
        String a6=srch_job.getSelectedItem().toString();
        String ta=null;
        if((a1.compareTo("")==0)&&(a2.compareTo("")==0)&&(a3==0)&&(a4==0))
        {
            today_perm_date();
        }
        else
        {
            if((a1.compareTo("")==0)&&(a2.compareTo("")==0)&&(a3==0)&&(a4!=0))
            ta="select e.EID,e.FName,e.Surname,e.Department,e.Position,a.Date,a.ArrivalTime,a.LeavingTime,a.Reason_to_early_leave from empdet e,attendance a where a.EID=e.EID and a.Date='"+dates+"' AND (e.type='Permanant' or e.type='Admin') and e.Position='"+a6+"'";
            else if((a1.compareTo("")==0)&&(a2.compareTo("")==0)&&(a3!=0)&&(a4==0))
            ta="select e.EID,e.FName,e.Surname,e.Department,e.Position,a.Date,a.ArrivalTime,a.LeavingTime,a.Reason_to_early_leave from empdet e,attendance a where a.EID=e.EID and a.Date='"+dates+"' AND (e.type='Permanant' or e.type='Admin') and e.Department='"+a5+"'";
            else if((a1.compareTo("")==0)&&(a2.compareTo("")==0)&&(a3!=0)&&(a4!=0))
            ta="select e.EID,e.FName,e.Surname,e.Department,e.Position,a.Date,a.ArrivalTime,a.LeavingTime,a.Reason_to_early_leave from empdet e,attendance a where a.EID=e.EID and a.Date='"+dates+"' AND (e.type='Permanant' or e.type='Admin') and e.Position='"+a6+"' and e.Department='"+a5+"'";
            else if((a1.compareTo("")==0)&&(a2.compareTo("")!=0)&&(a3==0)&&(a4==0))
            ta="select e.EID,e.FName,e.Surname,e.Department,e.Position,a.Date,a.ArrivalTime,a.LeavingTime,a.Reason_to_early_leave from empdet e,attendance a where a.EID=e.EID and a.Date='"+dates+"' AND (e.type='Permanant' or e.type='Admin') and e.Surname like '"+a2+"%'";
            else if((a1.compareTo("")==0)&&(a2.compareTo("")!=0)&&(a3==0)&&(a4!=0))
            ta="select e.EID,e.FName,e.Surname,e.Department,e.Position,a.Date,a.ArrivalTime,a.LeavingTime,a.Reason_to_early_leave from empdet e,attendance a where a.EID=e.EID and a.Date='"+dates+"' AND (e.type='Permanant' or e.type='Admin') and e.Surname like '"+a2+"%' and e.Position='"+a6+"'";
            else if((a1.compareTo("")==0)&&(a2.compareTo("")!=0)&&(a3!=0)&&(a4==0))
            ta="select e.EID,e.FName,e.Surname,e.Department,e.Position,a.Date,a.ArrivalTime,a.LeavingTime,a.Reason_to_early_leave from empdet e,attendance a where a.EID=e.EID and a.Date='"+dates+"' AND (e.type='Permanant' or e.type='Admin') and e.Surname like '"+a2+"%' and e.Department='"+a5+"'";
            else if((a1.compareTo("")==0)&&(a2.compareTo("")!=0)&&(a3!=0)&&(a4!=0))
            ta="select e.EID,e.FName,e.Surname,e.Department,e.Position,a.Date,a.ArrivalTime,a.LeavingTime,a.Reason_to_early_leave from empdet e,attendance a where a.EID=e.EID and a.Date='"+dates+"' AND (e.type='Permanant' or e.type='Admin') and e.Surname like '"+a2+"%' and e.Department='"+a5+"' and Position='"+a6+"'";
            else if((a1.compareTo("")!=0)&&(a2.compareTo("")==0)&&(a3==0)&&(a4==0))
            ta="select e.EID,e.FName,e.Surname,e.Department,e.Position,a.Date,a.ArrivalTime,a.LeavingTime,a.Reason_to_early_leave from empdet e,attendance a where a.EID=e.EID and a.Date='"+dates+"' AND (e.type='Permanant' or e.type='Admin') and e.EID='"+a1+"'";
            else if((a1.compareTo("")!=0)&&(a2.compareTo("")==0)&&(a3==0)&&(a4!=0))
            ta="select e.EID,e.FName,e.Surname,e.Department,e.Position,a.Date,a.ArrivalTime,a.LeavingTime,a.Reason_to_early_leave from empdet e,attendance a where a.EID=e.EID and a.Date='"+dates+"' AND (e.type='Permanant' or e.type='Admin') and e.EID='"+a1+"' and e.Position='"+a6+"'";
            else if((a1.compareTo("")!=0)&&(a2.compareTo("")==0)&&(a3!=0)&&(a4==0))
            ta="select e.EID,e.FName,e.Surname,e.Department,e.Position,a.Date,a.ArrivalTime,a.LeavingTime,a.Reason_to_early_leave from empdet e,attendance a where a.EID=e.EID and a.Date='"+dates+"' AND (e.type='Permanant' or e.type='Admin') and e.EID='"+a1+"' and e.Department='"+a5+"'";
            else if((a1.compareTo("")!=0)&&(a2.compareTo("")==0)&&(a3!=0)&&(a4!=0))
            ta="select e.EID,e.FName,e.Surname,e.Department,e.Position,a.Date,a.ArrivalTime,a.LeavingTime,a.Reason_to_early_leave from empdet e,attendance a where a.EID=e.EID and a.Date='"+dates+"' AND (e.type='Permanant' or e.type='Admin') and e.EID='"+a1+"' and e.Position='"+a6+"' and e.Position='"+a6+"'";
            else if((a1.compareTo("")!=0)&&(a2.compareTo("")!=0)&&(a3==0)&&(a4==0))
            ta="select e.EID,e.FName,e.Surname,e.Department,e.Position,a.Date,a.ArrivalTime,a.LeavingTime,a.Reason_to_early_leave from empdet e,attendance a where a.EID=e.EID and a.Date='"+dates+"' AND (e.type='Permanant' or e.type='Admin') and e.EID='"+a1+"' and e.Surname like '"+a2+"%'";
            else if((a1.compareTo("")!=0)&&(a2.compareTo("")!=0)&&(a3==0)&&(a4!=0))
            ta="select e.EID,e.FName,e.Surname,e.Department,e.Position,a.Date,a.ArrivalTime,a.LeavingTime,a.Reason_to_early_leave from empdet e,attendance a where a.EID=e.EID and a.Date='"+dates+"' AND (e.type='Permanant' or e.type='Admin') and e.EID='"+a1+"' and e.Surname like '"+a2+"%' and e.Position='"+a6+"'";
            else if((a1.compareTo("")!=0)&&(a2.compareTo("")!=0)&&(a3!=0)&&(a4==0))
            ta="select e.EID,e.FName,e.Surname,e.Department,e.Position,a.Date,a.ArrivalTime,a.LeavingTime,a.Reason_to_early_leave from empdet e,attendance a where a.EID=e.EID and a.Date='"+dates+"' AND (e.type='Permanant' or e.type='Admin') and e.EID='"+a1+"' and e.Surname like '"+a2+"%' and e.Department='"+a5+"'";
            else
            ta="select e.EID,e.FName,e.Surname,e.Department,e.Position,a.Date,a.ArrivalTime,a.LeavingTime,a.Reason_to_early_leave from empdet e,attendance a where a.EID=e.EID and a.Date='"+dates+"' AND (e.type='Permanant' or e.type='Admin') and e.EID='"+a1+"' and e.Surname like '"+a2+"%' and e.Position='"+a6+"' and e.Department='"+a5+"'";

            try
            {
                pst=conn.prepareStatement(ta);
                rs=pst.executeQuery();
                table1.setModel(DbUtils.resultSetToTableModel(rs));
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_srch_depActionPerformed

    private void srch_depMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_srch_depMouseClicked

    }//GEN-LAST:event_srch_depMouseClicked

    private void jPanel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseClicked
        table1.clearSelection();
    }//GEN-LAST:event_jPanel2MouseClicked

    private void jPanel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseClicked
        table2.clearSelection();
    }//GEN-LAST:event_jPanel3MouseClicked

    private void jPanel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseClicked
        table3.clearSelection();
    }//GEN-LAST:event_jPanel4MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        table1.clearSelection();
        table2.clearSelection();
        table3.clearSelection();
    }//GEN-LAST:event_jLabel6MouseClicked

    private void srch_surnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_srch_surnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_srch_surnameActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser date1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField search;
    private javax.swing.JTextField search1;
    private javax.swing.JComboBox srch_dep;
    private javax.swing.JComboBox srch_dep1;
    private javax.swing.JComboBox srch_job;
    private javax.swing.JComboBox srch_job1;
    private javax.swing.JTextField srch_surname;
    private javax.swing.JTextField srch_surname1;
    private javax.swing.JTable table1;
    private javax.swing.JTable table2;
    private javax.swing.JTable table3;
    // End of variables declaration//GEN-END:variables
}
