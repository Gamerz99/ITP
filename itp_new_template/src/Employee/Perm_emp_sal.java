
package Employee;

import dbconnect.dbconnect;
import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.PdfWriter;
import java.awt.event.KeyEvent;
import java.awt.print.PrinterException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentListener;
import javax.swing.event.UndoableEditListener;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.Element;
import javax.swing.text.Position;
import javax.swing.text.Segment;
import net.proteanit.sql.DbUtils;

public class Perm_emp_sal extends javax.swing.JInternalFrame {
    int year=Calendar.getInstance().get(Calendar.YEAR);
    int month=Calendar.getInstance().get(Calendar.MONTH)+1;
    Connection conn=null;
    PreparedStatement pst=null;
    ResultSet rs=null;
    methods mm=new methods();
    public Perm_emp_sal() {
        initComponents();
        conn=dbconnect.connect();
        show_table();
    }
    private void show_table() //To show the table content
    {
        try {
            String a="select e.EID,e.FName,e.Surname,p.Basic_salary,p.epfAmnt,p.etfAmnt,p.Bonus,p.OT_charge,p.Tot_salary,p.Status from empdet e,perm_emp_salary p where e.EID=p.EID and (e.Type='Admin' OR e.Type='Permanant') AND  p.Month='"+year+"-"+month+"'";
            pst=conn.prepareStatement(a);
            rs=pst.executeQuery();
            etable.setModel(DbUtils.resultSetToTableModel(rs));
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    private void update_sal(String eid,double y,String z)  //To increase and decrease the salary of an employee
    {
        double tot_val=0,tot_fin=0,ep=0,et=0,ot=0,bon=0,epAmnt=0,etAmnt=0;
        String Eid=eid;
        double value=y;
        String type=z;
        double tot=0;
        try
        {
            String b="select * from empdet where EID='"+Eid+"'";
            pst=conn.prepareStatement(b);
            rs=pst.executeQuery();
            double sal=0;
            if(rs.next())
            {
                sal=Double.parseDouble(rs.getString("Salary"));
            }
            String lp="select * from perm_emp_salary where EID='"+Eid+"' and Month='"+year+"-"+month+"'";
            pst=conn.prepareStatement(lp);
            rs=pst.executeQuery();
            if(rs.next())
            {
                ep=Double.parseDouble(rs.getString("EPF"));
                et=Double.parseDouble(rs.getString("ETF"));
                tot_val=Double.parseDouble(rs.getString("Tot_salary"));
            }
            if(type.compareTo("add")==0)
            {
                tot=sal+value;
                epAmnt=tot*(ep/100);
                etAmnt=tot*(et/100);
                tot_fin=tot-epAmnt-etAmnt;
            }
            else if(type.compareTo("sub")==0)
            {
                if(sal-value>0)
                {
                    tot=sal-value;
                    epAmnt=tot*(ep/100);
                    etAmnt=tot*(et/100);
                    tot_fin=tot-epAmnt-etAmnt;
                }
            }
            try
            {
                
                String a="update empdet set Salary='"+tot+"' where EID='"+Eid+"'";
                pst=conn.prepareStatement(a);
                pst.execute();
                String yu="update perm_emp_salary set Basic_salary='"+tot+"',Tot_salary='"+(tot_fin)+"',epfAmnt='"+epAmnt+"',etfAmnt='"+etAmnt+"' where EID='"+Eid+"' and Month='"+year+"-"+month+"'";
                pst=conn.prepareStatement(yu);
                pst.execute();
                show_table();
                basic_sal.setText(Double.toString(tot));
            } catch(Exception e)
            {
                System.out.println(e);
            }
            
        } catch(SQLException ex)
        {
            System.out.println(ex);
        }
    }
    private void update_ot(String eid1,double OT,String type,String pos) //To change the OT rate
    {
        String Eid=eid1;
        double ott=OT;
        String Type=type;
        try {
            String a="select * from charges where Type='"+pos+"'";
            pst=conn.prepareStatement(a);
            rs=pst.executeQuery();
            String a11="select * from perm_emp_salary where EID='"+Eid+"' and Month='"+year+"-"+month+"'";
            PreparedStatement pst2=conn.prepareStatement(a11);
            ResultSet rs2=pst2.executeQuery();
            if(rs.next()&&rs2.next())
            {
                double tot=Double.parseDouble(rs2.getString("Tot_salary"));
                double x=Double.parseDouble(rs.getString("OtCharge"));
                double y=Double.parseDouble(rs2.getString("OT_charge"));
                double ot_val = 0;
                double ot_am = 0;
                if(Type.compareTo("add")==0)
                {
                    ot_am=ott*x;
                    ot_val=y+ot_am;
                }
                else if(Type.compareTo("sub")==0)
                {
                    ot_am=ott*x;
                    ot_val=y-ot_am;
                    if(ot_val<0)
                        ot_val=0;
                    
                }
                String bb="update perm_emp_salary set OT_charge='"+ot_val+"',Tot_salary='"+(tot+ot_am)+"' where EID='"+Eid+"' and Month='"+year+"-"+month+"'";
                PreparedStatement pst1=conn.prepareStatement(bb);
                pst1.execute();
                show_table();
                msal.setText(Double.toString((tot+ot_am)));
            }
        } catch(Exception e)
        {
            System.out.println(e);
        }
    }
    private void update_bonus(String eid1,double Bonus,String type)
    {
        String Type=type;
        String Eid1=eid1;
        double bns=Bonus;
        double tot=0;
        double add=0;
        String b=null;
        try{
            String a="select * from perm_emp_salary where EID='"+Eid1+"' and Month='"+year+"-"+month+"'";
            pst=conn.prepareStatement(a);
            rs=pst.executeQuery();
            if(rs.next())
            {
                double fin_bon=0;
                double bn=Double.parseDouble(rs.getString("Bonus"));
                tot=Double.parseDouble(rs.getString("Tot_salary"));
                if(Type.compareTo("add")==0)
                    {
                        add=tot+bns;
                        fin_bon=bn+bns;
                    }
                    else
                    {
                        add=tot-bns;
                        fin_bon=bn-bns;
                    }
                    b="update perm_emp_salary set Tot_salary='"+add+"',Bonus='"+fin_bon+"' where EID='"+Eid1+"' and Month='"+year+"-"+month+"'";
                    pst=conn.prepareStatement(b);
                    pst.execute();
                    bonus.setText("");
                    show_table();
                    
                    msal.setText(Double.toString(add));
                    JOptionPane.showMessageDialog(null, "Bonus record added");
                }
                
            
        } catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        search = new javax.swing.JTextField();
        srch_surname = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        srch_dep = new javax.swing.JComboBox();
        srch_job = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        eid = new javax.swing.JLabel();
        surname = new javax.swing.JLabel();
        basic_sal = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        msal = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        sal = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        ot = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        bonus = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        clear1 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        amount1 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        etable = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        pic = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1600, 925));
        setMinimumSize(new java.awt.Dimension(1600, 925));
        setPreferredSize(new java.awt.Dimension(1600, 925));

        jPanel1.setPreferredSize(new java.awt.Dimension(1140, 545));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setText("EID");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 320, 50, 40));

        search.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        search.setToolTipText("");
        jPanel1.add(search, new org.netbeans.lib.awtextra.AbsoluteConstraints(172, 320, 160, 40));

        srch_surname.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel1.add(srch_surname, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 320, 190, 40));

        jButton4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/if_icon-ios7-search-strong_211817 (1).png"))); // NOI18N
        jButton4.setText("Search");
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 320, 130, 40));

        srch_dep.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        srch_dep.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Department", "Event Management", "Customer Management", "Employee Management", "Financial Department", "Inventory Management", "Transport Management", "Restaurant Department", "Maintenance department" }));
        srch_dep.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        srch_dep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                srch_depActionPerformed(evt);
            }
        });
        jPanel1.add(srch_dep, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 320, 210, 40));

        srch_job.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        srch_job.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Job", "Cashier", "Cleaner", "Clerk", "Cook", "Driver", "Photographer", "Receptionist", "Waiter/Waitress", "Accountant", "HR Manager", "Maintenance Supervisor", "Stock Manager", "Transport Manager", "Manager" }));
        srch_job.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        srch_job.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                srch_jobActionPerformed(evt);
            }
        });
        jPanel1.add(srch_job, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 320, 180, 40));

        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("EID");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 12, 110, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Surname");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 50, 110, 30));

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel22.setText("Basic Salary");
        jPanel2.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 88, 110, 30));

        eid.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        eid.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                eidAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jPanel2.add(eid, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 160, 30));

        surname.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel2.add(surname, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 50, 160, 30));

        basic_sal.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel2.add(basic_sal, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 160, 30));

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel23.setText("Month Salary");
        jPanel2.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 110, 30));

        msal.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel2.add(msal, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 160, 30));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 100, 320, 180));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Permanat Employee Details");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(639, 0, 428, 47));

        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Incrementation / Decrementation");
        jPanel3.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 2, 236, 27));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Salary");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 80, 27));

        sal.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel3.add(sal, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, 150, 30));

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/add (1).png"))); // NOI18N
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 40, 40, 30));

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/substract.png"))); // NOI18N
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 40, 40, 30));

        jButton6.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/substract.png"))); // NOI18N
        jButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 80, 40, 30));

        jButton5.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/add (1).png"))); // NOI18N
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 80, 40, 30));

        ot.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel3.add(ot, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, 150, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("OT Hours");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 80, 27));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Bonus");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 80, 27));

        bonus.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel3.add(bonus, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 120, 150, 30));

        jButton7.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/add (1).png"))); // NOI18N
        jButton7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 120, 40, 30));

        jButton8.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/substract.png"))); // NOI18N
        jButton8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 120, 40, 30));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 100, 380, 170));

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel20.setText("Surname");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 320, 70, 40));

        clear1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        clear1.setText("Clear");
        clear1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        clear1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clear1ActionPerformed(evt);
            }
        });
        jPanel1.add(clear1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 320, 130, 40));

        jPanel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setText("Fine Record");
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(77, 0, 120, 28));

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setText("Deduct");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(88, 100, 90, 30));

        amount1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel4.add(amount1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 140, 32));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 100, 270, 170));

        etable.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        etable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        etable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        etable.setGridColor(new java.awt.Color(0, 0, 0));
        etable.setSelectionBackground(new java.awt.Color(0, 0, 0));
        etable.setSelectionForeground(new java.awt.Color(204, 204, 204));
        etable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                etableMouseClicked(evt);
            }
        });
        etable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                etableKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(etable);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 400, 1380, 410));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/16_2.png"))); // NOI18N
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 100, 100));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/body.jpg"))); // NOI18N
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1590, 900));

        pic.setBackground(new java.awt.Color(204, 204, 255));
        pic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/logoutback.png"))); // NOI18N
        jPanel1.add(pic, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 100, 100, 100));

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

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
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
                ta="select e.EID,e.FName,e.Surname,p.Basic_salary,p.epfAmnt,p.etfAmnt,p.Bonus,p.OT_charge,p.Tot_salary,p.Status from empdet e,perm_emp_salary p where e.EID=p.EID and (e.type='Permanant' or e.type='Admin') and e.Position='"+a6+"'";
            else if((a1.compareTo("")==0)&&(a2.compareTo("")==0)&&(a3!=0)&&(a4==0))
                ta="select e.EID,e.FName,e.Surname,p.Basic_salary,p.epfAmnt,p.etfAmnt,p.Bonus,p.OT_charge,p.Tot_salary,p.Status from empdet e,perm_emp_salary p where e.EID=p.EID and (e.type='Permanant' or e.type='Admin') and e.Department='"+a5+"'";
            else if((a1.compareTo("")==0)&&(a2.compareTo("")==0)&&(a3!=0)&&(a4!=0))
                ta="select e.EID,e.FName,e.Surname,p.Basic_salary,p.epfAmnt,p.etfAmnt,p.Bonus,p.OT_charge,p.Tot_salary,p.Status from empdet e,perm_emp_salary p where e.EID=p.EID and (e.type='Permanant' or e.type='Admin') and e.Position='"+a6+"' and e.Department='"+a5+"'";
            else if((a1.compareTo("")==0)&&(a2.compareTo("")!=0)&&(a3==0)&&(a4==0))
                ta="select e.EID,e.FName,e.Surname,p.Basic_salary,p.epfAmnt,p.etfAmnt,p.Bonus,p.OT_charge,p.Tot_salary,p.Status from empdet e,perm_emp_salary p where e.EID=p.EID and (e.type='Permanant' or e.type='Admin') and e.Surname like '"+a2+"%'";
            else if((a1.compareTo("")==0)&&(a2.compareTo("")!=0)&&(a3==0)&&(a4!=0))
                ta="select e.EID,e.FName,e.Surname,p.Basic_salary,p.epfAmnt,p.etfAmnt,p.Bonus,p.OT_charge,p.Tot_salary,p.Status from empdet e,perm_emp_salary p where e.EID=p.EID and (e.type='Permanant' or e.type='Admin') and e.Surname like '"+a2+"%' and e.Position='"+a6+"'";
            else if((a1.compareTo("")==0)&&(a2.compareTo("")!=0)&&(a3!=0)&&(a4==0))
                ta="select e.EID,e.FName,e.Surname,p.Basic_salary,p.epfAmnt,p.etfAmnt,p.Bonus,p.OT_charge,p.Tot_salary,p.Status from empdet e,perm_emp_salary p where e.EID=p.EID and (e.type='Permanant' or e.type='Admin') and e.Surname like '"+a2+"%' and e.Department='"+a5+"'";
            else if((a1.compareTo("")==0)&&(a2.compareTo("")!=0)&&(a3!=0)&&(a4!=0))
                ta="select e.EID,e.FName,e.Surname,p.Basic_salary,p.epfAmnt,p.etfAmnt,p.Bonus,p.OT_charge,p.Tot_salary,p.Status from empdet e,perm_emp_salary p where e.EID=p.EID and (e.type='Permanant' or e.type='Admin') and e.Surname like '"+a2+"%' and e.Department='"+a5+"' and e.Position='"+a6+"'";
            else if((a1.compareTo("")!=0)&&(a2.compareTo("")==0)&&(a3==0)&&(a4==0))
                ta="select e.EID,e.FName,e.Surname,p.Basic_salary,p.epfAmnt,p.etfAmnt,p.Bonus,p.OT_charge,p.Tot_salary,p.Status from empdet e,perm_emp_salary p where e.EID=p.EID and (e.type='Permanant' or e.type='Admin') and e.EID='"+a1+"'";
            else if((a1.compareTo("")!=0)&&(a2.compareTo("")==0)&&(a3==0)&&(a4!=0))
                ta="select e.EID,e.FName,e.Surname,p.Basic_salary,p.epfAmnt,p.etfAmnt,p.Bonus,p.OT_charge,p.Tot_salary,p.Status from empdet e,perm_emp_salary p where e.EID=p.EID and (e.type='Permanant' or e.type='Admin') and e.EID='"+a1+"' and e.Position='"+a6+"'";
            else if((a1.compareTo("")!=0)&&(a2.compareTo("")==0)&&(a3!=0)&&(a4==0))
                ta="select e.EID,e.FName,e.Surname,p.Basic_salary,p.epfAmnt,p.etfAmnt,p.Bonus,p.OT_charge,p.Tot_salary,p.Status from empdet e,perm_emp_salary p where e.EID=p.EID and (e.type='Permanant' or e.type='Admin') and e.EID='"+a1+"' and e.Department='"+a5+"'";
            else if((a1.compareTo("")!=0)&&(a2.compareTo("")==0)&&(a3!=0)&&(a4!=0))
                ta="select e.EID,e.FName,e.Surname,p.Basic_salary,p.epfAmnt,p.etfAmnt,p.Bonus,p.OT_charge,p.Tot_salary,p.Status from empdet e,perm_emp_salary p where e.EID=p.EID and (e.type='Permanant' or e.type='Admin') and e.EID='"+a1+"' and e.Position='"+a6+"' and e.Department='"+a5+"'";
            else if((a1.compareTo("")!=0)&&(a2.compareTo("")!=0)&&(a3==0)&&(a4==0))
                ta="select e.EID,e.FName,e.Surname,p.Basic_salary,p.epfAmnt,p.etfAmnt,p.Bonus,p.OT_charge,p.Tot_salary,p.Status from empdet e,perm_emp_salary p where e.EID=p.EID and (e.type='Permanant' or e.type='Admin') and e.EID='"+a1+"' and e.Surname like '"+a2+"%'";
            else if((a1.compareTo("")!=0)&&(a2.compareTo("")!=0)&&(a3==0)&&(a4!=0))
                ta="select e.EID,e.FName,e.Surname,p.Basic_salary,p.epfAmnt,p.etfAmnt,p.Bonus,p.OT_charge,p.Tot_salary,p.Status from empdet e,perm_emp_salary p where e.EID=p.EID and (e.type='Permanant' or e.type='Admin') and e.EID='"+a1+"' and e.Surname like '"+a2+"%' and e.Position='"+a6+"'";
            else if((a1.compareTo("")!=0)&&(a2.compareTo("")!=0)&&(a3!=0)&&(a4==0))
                ta="select e.EID,e.FName,e.Surname,p.Basic_salary,p.epfAmnt,p.etfAmnt,p.Bonus,p.OT_charge,p.Tot_salary,p.Status from empdet e,perm_emp_salary p where e.EID=p.EID and (e.type='Permanant' or e.type='Admin') and e.EID='"+a1+"' and e.Surname like '"+a2+"%' and e.Department='"+a5+"'";
            else
                ta="select e.EID,e.FName,e.Surname,p.Basic_salary,p.epfAmnt,p.etfAmnt,p.Bonus,p.OT_charge,p.Tot_salary,p.Status from empdet e,perm_emp_salary p where e.EID=p.EID and (e.type='Permanant' or e.type='Admin') and e.EID='"+a1+"' and e.Surname like '"+a2+"%' and e.Position='"+a6+"' and e.Department='"+a5+"'";
            
            try
            {
                pst=conn.prepareStatement(ta);
                rs=pst.executeQuery();
                etable.setModel(DbUtils.resultSetToTableModel(rs));
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if(sal.getText().compareTo("")!=0)
        {
            if(mm.check_txt_field(sal.getText())==true)
            {
                if(eid.getText().compareTo("")!=0)
                {
                    String id=eid.getText();
                    double y=Double.parseDouble(sal.getText());
                    update_sal(id,y,"add");
                    JOptionPane.showMessageDialog(null, "Added Successfully");
                    sal.setText("");
                }
                else
                    JOptionPane.showMessageDialog(null, "Select an employee");
            }
            else
                JOptionPane.showMessageDialog(null, "Value is not a number");
        }
        else
            JOptionPane.showMessageDialog(null, "Fill salary field");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(sal.getText().compareTo("")!=0)
        {
            if(mm.check_txt_field(sal.getText())==true)
            {
                if(eid.getText().compareTo("")!=0)
                {
                    String id=eid.getText();
                    double y=Double.parseDouble(sal.getText());
                    update_sal(id,y,"sub");
                    JOptionPane.showMessageDialog(null, "decreased Successfully");
                    sal.setText("");
                }
                else
                    JOptionPane.showMessageDialog(null, "Select an employee");
            }
            else
                JOptionPane.showMessageDialog(null, "Value is not a number");
        }
        else
            JOptionPane.showMessageDialog(null, "Fill salary field");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
            if(ot.getText().compareTo("")!=0)
            {
                if(mm.check_txt_field(ot.getText())==true)
                {
                    if(eid.getText().compareTo("")!=0)
                    {
                        try {
                            String a="select * from empdet where EID='"+eid.getText()+"'";
                            pst=conn.prepareStatement(a);
                            rs=pst.executeQuery();
                            String pos=null;
                            if(rs.next())
                            {
                                pos=rs.getString("Position");
                            }
                            String eid1=eid.getText();
                            double OT=Double.parseDouble(ot.getText());
                            update_ot(eid1,OT,"add",pos);
                            ot.setText("");
                            JOptionPane.showMessageDialog(null, "OT record added");
                        } catch (SQLException ex) {
                            System.out.println(ex);
                        }
                    }
                    else
                        JOptionPane.showMessageDialog(null, "Select an employee");
                }
                else
                    JOptionPane.showMessageDialog(null, "Value is not a number");
            }
            else
                JOptionPane.showMessageDialog(null, "Fill OT field");
            
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        if(bonus.getText().compareTo("")!=0)
        {
            if(mm.check_txt_field(sal.getText())==true)
            {
                if(eid.getText().compareTo("")!=0)
                {
                    String eid1=eid.getText();
                    double bon=Double.parseDouble(bonus.getText());
                    update_bonus(eid1,bon,"add");
                }
                else
                    JOptionPane.showMessageDialog(null, "Select an employee");
                }
            else
                JOptionPane.showMessageDialog(null, "Value is not a number");
        }
        else
            JOptionPane.showMessageDialog(null, "Fill Bonus field");
          
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        if(ot.getText().compareTo("")!=0)
            {
                if(mm.check_txt_field(ot.getText())==true)
                {
                    if(eid.getText().compareTo("")!=0)
                    {
                        try {
                            String a="select * from empdet where EID='"+eid.getText()+"'";
                            pst=conn.prepareStatement(a);
                            rs=pst.executeQuery();
                            String pos=null;
                            if(rs.next())
                            {
                                pos=rs.getString("Position");
                            }
                            String eid1=eid.getText();
                            double OT=Double.parseDouble(ot.getText());
                            update_ot(eid1,OT,"sub",pos);
                            ot.setText("");
                            JOptionPane.showMessageDialog(null, "OT record added");
                        } catch (SQLException ex) {
                            System.out.println(ex);
                        }
                    }
                    else
                        JOptionPane.showMessageDialog(null, "Select an employee");
                    }
                else
                    JOptionPane.showMessageDialog(null, "Value is not a number");
            }
            else
                JOptionPane.showMessageDialog(null, "Fill OT field");
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        if(bonus.getText().compareTo("")!=0)
        {
            if(mm.check_txt_field(sal.getText())==true)
            {
                if(eid.getText().compareTo("")!=0)
                {
                    String eid1=eid.getText();
                    double bon=Double.parseDouble(bonus.getText());
                    update_bonus(eid1,bon,"sub");
                }
                else
                    JOptionPane.showMessageDialog(null, "Select an employee");
                }
            else
                JOptionPane.showMessageDialog(null, "Value is not a number");
        }
        else
            JOptionPane.showMessageDialog(null, "Fill Bonus field");
    }//GEN-LAST:event_jButton8ActionPerformed

    private void eidAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_eidAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_eidAncestorAdded

    private void srch_depActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_srch_depActionPerformed
        String a1=search.getText();
        String a2=srch_surname.getText();
        int a3=srch_dep.getSelectedIndex();
        int a4=srch_job.getSelectedIndex();
        String a5=srch_dep.getSelectedItem().toString();
        String a6=srch_job.getSelectedItem().toString();
        String ta=null;
        if((a1.compareTo("")==0)&&(a2.compareTo("")==0)&&(a3==0)&&(a4==0))
        {
            show_table();
        }
        else
        {
            if((a1.compareTo("")==0)&&(a2.compareTo("")==0)&&(a3==0)&&(a4!=0))
                ta="select e.EID,e.FName,e.Surname,p.Basic_salary,p.epfAmnt,p.etfAmnt,p.Bonus,p.OT_charge,p.Tot_salary,p.Status from empdet e,perm_emp_salary p where e.EID=p.EID and (e.type='Permanant' or e.type='Admin') and Position='"+a6+"'";
            else if((a1.compareTo("")==0)&&(a2.compareTo("")==0)&&(a3!=0)&&(a4==0))
                ta="select e.EID,e.FName,e.Surname,p.Basic_salary,p.epfAmnt,p.etfAmnt,p.Bonus,p.OT_charge,p.Tot_salary,p.Status from empdet e,perm_emp_salary p where e.EID=p.EID and (e.type='Permanant' or e.type='Admin') and Department='"+a5+"'";
            else if((a1.compareTo("")==0)&&(a2.compareTo("")==0)&&(a3!=0)&&(a4!=0))
                ta="select e.EID,e.FName,e.Surname,p.Basic_salary,p.epfAmnt,p.etfAmnt,p.Bonus,p.OT_charge,p.Tot_salary,p.Status from empdet e,perm_emp_salary p where e.EID=p.EID and (e.type='Permanant' or e.type='Admin') and Position='"+a6+"' and Department='"+a5+"'";
            else if((a1.compareTo("")==0)&&(a2.compareTo("")!=0)&&(a3==0)&&(a4==0))
                ta="select e.EID,e.FName,e.Surname,p.Basic_salary,p.epfAmnt,p.etfAmnt,p.Bonus,p.OT_charge,p.Tot_salary,p.Status from empdet e,perm_emp_salary p where e.EID=p.EID and (e.type='Permanant' or e.type='Admin') and Surname like '"+a2+"%'";
            else if((a1.compareTo("")==0)&&(a2.compareTo("")!=0)&&(a3==0)&&(a4!=0))
                ta="select e.EID,e.FName,e.Surname,p.Basic_salary,p.epfAmnt,p.etfAmnt,p.Bonus,p.OT_charge,p.Tot_salary,p.Status from empdet e,perm_emp_salary p where e.EID=p.EID and (e.type='Permanant' or e.type='Admin') and Surname like '"+a2+"%' and Position='"+a6+"'";
            else if((a1.compareTo("")==0)&&(a2.compareTo("")!=0)&&(a3!=0)&&(a4==0))
                ta="select e.EID,e.FName,e.Surname,p.Basic_salary,p.epfAmnt,p.etfAmnt,p.Bonus,p.OT_charge,p.Tot_salary,p.Status from empdet e,perm_emp_salary p where e.EID=p.EID and (e.type='Permanant' or e.type='Admin') and Surname like '"+a2+"%' and Department='"+a5+"'";
            else if((a1.compareTo("")==0)&&(a2.compareTo("")!=0)&&(a3!=0)&&(a4!=0))
                ta="select e.EID,e.FName,e.Surname,p.Basic_salary,p.epfAmnt,p.etfAmnt,p.Bonus,p.OT_charge,p.Tot_salary,p.Status from empdet e,perm_emp_salary p where e.EID=p.EID and (e.type='Permanant' or e.type='Admin') and Surname like '"+a2+"%' and Department='"+a5+"' and Position='"+a6+"'";
            else if((a1.compareTo("")!=0)&&(a2.compareTo("")==0)&&(a3==0)&&(a4==0))
                ta="select e.EID,e.FName,e.Surname,p.Basic_salary,p.epfAmnt,p.etfAmnt,p.Bonus,p.OT_charge,p.Tot_salary,p.Status from empdet e,perm_emp_salary p where e.EID=p.EID and (e.type='Permanant' or e.type='Admin') and EID='"+a1+"'";
            else if((a1.compareTo("")!=0)&&(a2.compareTo("")==0)&&(a3==0)&&(a4!=0))
                ta="select e.EID,e.FName,e.Surname,p.Basic_salary,p.epfAmnt,p.etfAmnt,p.Bonus,p.OT_charge,p.Tot_salary,p.Status from empdet e,perm_emp_salary p where e.EID=p.EID and (e.type='Permanant' or e.type='Admin') and EID='"+a1+"' and Position='"+a6+"'";
            else if((a1.compareTo("")!=0)&&(a2.compareTo("")==0)&&(a3!=0)&&(a4==0))
                ta="select e.EID,e.FName,e.Surname,p.Basic_salary,p.epfAmnt,p.etfAmnt,p.Bonus,p.OT_charge,p.Tot_salary,p.Status from empdet e,perm_emp_salary p where e.EID=p.EID and (e.type='Permanant' or e.type='Admin') and EID='"+a1+"' and Department='"+a5+"'";
            else if((a1.compareTo("")!=0)&&(a2.compareTo("")==0)&&(a3!=0)&&(a4!=0))
                ta="select e.EID,e.FName,e.Surname,p.Basic_salary,p.epfAmnt,p.etfAmnt,p.Bonus,p.OT_charge,p.Tot_salary,p.Status from empdet e,perm_emp_salary p where e.EID=p.EID and (e.type='Permanant' or e.type='Admin') and EID='"+a1+"' and Position='"+a6+"' and Position='"+a6+"'";
            else if((a1.compareTo("")!=0)&&(a2.compareTo("")!=0)&&(a3==0)&&(a4==0))
                ta="select e.EID,e.FName,e.Surname,p.Basic_salary,p.epfAmnt,p.etfAmnt,p.Bonus,p.OT_charge,p.Tot_salary,p.Status from empdet e,perm_emp_salary p where e.EID=p.EID and (e.type='Permanant' or e.type='Admin') and EID='"+a1+"' and Surname like '"+a2+"%'";
            else if((a1.compareTo("")!=0)&&(a2.compareTo("")!=0)&&(a3==0)&&(a4!=0))
                ta="select e.EID,e.FName,e.Surname,p.Basic_salary,p.epfAmnt,p.etfAmnt,p.Bonus,p.OT_charge,p.Tot_salary,p.Status from empdet e,perm_emp_salary p where e.EID=p.EID and (e.type='Permanant' or e.type='Admin') and EID='"+a1+"' and Surname like '"+a2+"%' and Position='"+a6+"'";
            else if((a1.compareTo("")!=0)&&(a2.compareTo("")!=0)&&(a3!=0)&&(a4==0))
                ta="select e.EID,e.FName,e.Surname,p.Basic_salary,p.epfAmnt,p.etfAmnt,p.Bonus,p.OT_charge,p.Tot_salary,p.Status from empdet e,perm_emp_salary p where e.EID=p.EID and (e.type='Permanant' or e.type='Admin') and EID='"+a1+"' and Surname like '"+a2+"%' and Department='"+a5+"'";
            else
                ta="select e.EID,e.FName,e.Surname,p.Basic_salary,p.epfAmnt,p.etfAmnt,p.Bonus,p.OT_charge,p.Tot_salary,p.Status from empdet e,perm_emp_salary p where e.EID=p.EID and (e.type='Permanant' or e.type='Admin') and EID='"+a1+"' and Surname like '"+a2+"%' and Position='"+a6+"' and Department='"+a5+"'";
            
            try
            {
                pst=conn.prepareStatement(ta);
                rs=pst.executeQuery();
                etable.setModel(DbUtils.resultSetToTableModel(rs));
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_srch_depActionPerformed

    private void srch_jobActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_srch_jobActionPerformed
        String a1=search.getText();
        String a2=srch_surname.getText();
        int a3=srch_dep.getSelectedIndex();
        int a4=srch_job.getSelectedIndex();
        String a5=srch_dep.getSelectedItem().toString();
        String a6=srch_job.getSelectedItem().toString();
        String ta=null;
        if((a1.compareTo("")==0)&&(a2.compareTo("")==0)&&(a3==0)&&(a4==0))
        {
            show_table();
        }
        else
        {
            if((a1.compareTo("")==0)&&(a2.compareTo("")==0)&&(a3==0)&&(a4!=0))
                ta="select e.EID,e.FName,e.Surname,p.Basic_salary,p.epfAmnt,p.etfAmnt,p.Bonus,p.OT_charge,p.Tot_salary,p.Status from empdet e,perm_emp_salary p where e.EID=p.EID and (e.type='Permanant' or e.type='Admin') and Position='"+a6+"'";
            else if((a1.compareTo("")==0)&&(a2.compareTo("")==0)&&(a3!=0)&&(a4==0))
                ta="select e.EID,e.FName,e.Surname,p.Basic_salary,p.epfAmnt,p.etfAmnt,p.Bonus,p.OT_charge,p.Tot_salary,p.Status from empdet e,perm_emp_salary p where e.EID=p.EID and (e.type='Permanant' or e.type='Admin') and Department='"+a5+"'";
            else if((a1.compareTo("")==0)&&(a2.compareTo("")==0)&&(a3!=0)&&(a4!=0))
                ta="select e.EID,e.FName,e.Surname,p.Basic_salary,p.epfAmnt,p.etfAmnt,p.Bonus,p.OT_charge,p.Tot_salary,p.Status from empdet e,perm_emp_salary p where e.EID=p.EID and (e.type='Permanant' or e.type='Admin') and Position='"+a6+"' and Department='"+a5+"'";
            else if((a1.compareTo("")==0)&&(a2.compareTo("")!=0)&&(a3==0)&&(a4==0))
                ta="select e.EID,e.FName,e.Surname,p.Basic_salary,p.epfAmnt,p.etfAmnt,p.Bonus,p.OT_charge,p.Tot_salary,p.Status from empdet e,perm_emp_salary p where e.EID=p.EID and (e.type='Permanant' or e.type='Admin') and Surname like '"+a2+"%'";
            else if((a1.compareTo("")==0)&&(a2.compareTo("")!=0)&&(a3==0)&&(a4!=0))
                ta="select e.EID,e.FName,e.Surname,p.Basic_salary,p.epfAmnt,p.etfAmnt,p.Bonus,p.OT_charge,p.Tot_salary,p.Status from empdet e,perm_emp_salary p where e.EID=p.EID and (e.type='Permanant' or e.type='Admin') and Surname like '"+a2+"%' and Position='"+a6+"'";
            else if((a1.compareTo("")==0)&&(a2.compareTo("")!=0)&&(a3!=0)&&(a4==0))
                ta="select e.EID,e.FName,e.Surname,p.Basic_salary,p.epfAmnt,p.etfAmnt,p.Bonus,p.OT_charge,p.Tot_salary,p.Status from empdet e,perm_emp_salary p where e.EID=p.EID and (e.type='Permanant' or e.type='Admin') and Surname like '"+a2+"%' and Department='"+a5+"'";
            else if((a1.compareTo("")==0)&&(a2.compareTo("")!=0)&&(a3!=0)&&(a4!=0))
                ta="select e.EID,e.FName,e.Surname,p.Basic_salary,p.epfAmnt,p.etfAmnt,p.Bonus,p.OT_charge,p.Tot_salary,p.Status from empdet e,perm_emp_salary p where e.EID=p.EID and (e.type='Permanant' or e.type='Admin') and Surname like '"+a2+"%' and Department='"+a5+"' and Position='"+a6+"'";
            else if((a1.compareTo("")!=0)&&(a2.compareTo("")==0)&&(a3==0)&&(a4==0))
                ta="select e.EID,e.FName,e.Surname,p.Basic_salary,p.epfAmnt,p.etfAmnt,p.Bonus,p.OT_charge,p.Tot_salary,p.Status from empdet e,perm_emp_salary p where e.EID=p.EID and (e.type='Permanant' or e.type='Admin') and EID='"+a1+"'";
            else if((a1.compareTo("")!=0)&&(a2.compareTo("")==0)&&(a3==0)&&(a4!=0))
                ta="select e.EID,e.FName,e.Surname,p.Basic_salary,p.epfAmnt,p.etfAmnt,p.Bonus,p.OT_charge,p.Tot_salary,p.Status from empdet e,perm_emp_salary p where e.EID=p.EID and (e.type='Permanant' or e.type='Admin') and EID='"+a1+"' and Position='"+a6+"'";
            else if((a1.compareTo("")!=0)&&(a2.compareTo("")==0)&&(a3!=0)&&(a4==0))
                ta="select e.EID,e.FName,e.Surname,p.Basic_salary,p.epfAmnt,p.etfAmnt,p.Bonus,p.OT_charge,p.Tot_salary,p.Status from empdet e,perm_emp_salary p where e.EID=p.EID and (e.type='Permanant' or e.type='Admin') and EID='"+a1+"' and Department='"+a5+"'";
            else if((a1.compareTo("")!=0)&&(a2.compareTo("")==0)&&(a3!=0)&&(a4!=0))
                ta="select e.EID,e.FName,e.Surname,p.Basic_salary,p.epfAmnt,p.etfAmnt,p.Bonus,p.OT_charge,p.Tot_salary,p.Status from empdet e,perm_emp_salary p where e.EID=p.EID and (e.type='Permanant' or e.type='Admin') and EID='"+a1+"' and Position='"+a6+"' and Position='"+a6+"'";
            else if((a1.compareTo("")!=0)&&(a2.compareTo("")!=0)&&(a3==0)&&(a4==0))
                ta="select e.EID,e.FName,e.Surname,p.Basic_salary,p.epfAmnt,p.etfAmnt,p.Bonus,p.OT_charge,p.Tot_salary,p.Status from empdet e,perm_emp_salary p where e.EID=p.EID and (e.type='Permanant' or e.type='Admin') and EID='"+a1+"' and Surname like '"+a2+"%'";
            else if((a1.compareTo("")!=0)&&(a2.compareTo("")!=0)&&(a3==0)&&(a4!=0))
                ta="select e.EID,e.FName,e.Surname,p.Basic_salary,p.epfAmnt,p.etfAmnt,p.Bonus,p.OT_charge,p.Tot_salary,p.Status from empdet e,perm_emp_salary p where e.EID=p.EID and (e.type='Permanant' or e.type='Admin') and EID='"+a1+"' and Surname like '"+a2+"%' and Position='"+a6+"'";
            else if((a1.compareTo("")!=0)&&(a2.compareTo("")!=0)&&(a3!=0)&&(a4==0))
                ta="select e.EID,e.FName,e.Surname,p.Basic_salary,p.epfAmnt,p.etfAmnt,p.Bonus,p.OT_charge,p.Tot_salary,p.Status from empdet e,perm_emp_salary p where e.EID=p.EID and (e.type='Permanant' or e.type='Admin') and EID='"+a1+"' and Surname like '"+a2+"%' and Department='"+a5+"'";
            else
                ta="select e.EID,e.FName,e.Surname,p.Basic_salary,p.epfAmnt,p.etfAmnt,p.Bonus,p.OT_charge,p.Tot_salary,p.Status from empdet e,perm_emp_salary p where e.EID=p.EID and (e.type='Permanant' or e.type='Admin') and EID='"+a1+"' and Surname like '"+a2+"%' and Position='"+a6+"' and Department='"+a5+"'";
            
            try
            {
                pst=conn.prepareStatement(ta);
                rs=pst.executeQuery();
                etable.setModel(DbUtils.resultSetToTableModel(rs));
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_srch_jobActionPerformed

    private void clear1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clear1ActionPerformed
        search.setText("");
        srch_surname.setText("");
        srch_dep.setSelectedIndex(0);
        srch_job.setSelectedIndex(0);
        show_table();
    }//GEN-LAST:event_clear1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(eid.getText().compareTo("")!=0)
        {
            if(mm.check_txt_field(amount1.getText())==true)
            {
                try {
                    String Eid=eid.getText();
                    double x=Double.parseDouble(amount1.getText());
                    String q1="select * from perm_emp_salary where EID='"+Eid+"'";
                    pst=conn.prepareStatement(q1);
                    rs=pst.executeQuery();
                    if(rs.next())
                    {
                        double q2=Double.parseDouble(rs.getString("Tot_salary"));
                        double q5=Double.parseDouble(rs.getString("fines"));
                        if((q2-x)>0)
                        {
                            double q3=q2-x;
                            String q4="update perm_emp_salary set Tot_salary='"+q3+"',fines='"+(q5+x)+"' where EID='"+Eid+"' and Month='"+year+"-"+month+"'";
                            pst=conn.prepareStatement(q4);
                            pst.execute();
                            show_table();
                            amount1.setText("");
                            JOptionPane.showMessageDialog(null, "Deducted");
                        }
                        else
                            JOptionPane.showMessageDialog(null, "Salary is not enough");
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
                }
            else
                JOptionPane.showMessageDialog(null, "Value is not a number");
        }
        else
            JOptionPane.showMessageDialog(null, "Select an employee");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void etableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_etableMouseClicked
        int row=etable.getSelectedRow();
        String id=etable.getModel().getValueAt(row, 0).toString();
        String Fname=etable.getModel().getValueAt(row, 1).toString();
        String Surname=etable.getModel().getValueAt(row, 2).toString();
        String Salary=etable.getModel().getValueAt(row, 3).toString();
        String mSalary=etable.getModel().getValueAt(row, 8).toString();
        eid.setText(id);
        surname.setText(Surname);
        basic_sal.setText(Salary);
        msal.setText(mSalary);
        try{
            String a="select Photo from empdet where EID='"+id+"'";
            pst=conn.prepareStatement(a);
            rs=pst.executeQuery();
            if(rs.next())
            {
                if(rs.getBytes("Photo") == null)
                {}
                else 
                {
                    byte[] image=rs.getBytes("Photo");
                    ImageIcon format=new ImageIcon(image);
                    jLabel12.setIcon(format);
                }
            }
        } catch(Exception e){
            System.out.println(e);
        }   
    }//GEN-LAST:event_etableMouseClicked

    private void etableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_etableKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_UP)
        {
            int row=etable.getSelectedRow();
            String id=etable.getModel().getValueAt(row-1, 0).toString();
            String Fname=etable.getModel().getValueAt(row, 1).toString();
            String Surname=etable.getModel().getValueAt(row, 2).toString();
            String Salary=etable.getModel().getValueAt(row, 3).toString();
            String mSalary=etable.getModel().getValueAt(row, 8).toString();
            eid.setText(id);
            surname.setText(Surname);
            basic_sal.setText(Salary);
            msal.setText(mSalary);
            try{
                String a="select Photo from empdet where EID='"+id+"'";
                pst=conn.prepareStatement(a);
                rs=pst.executeQuery();
                if(rs.next())
                {
                    if(rs.getBytes("Photo") == null)
                    {}
                    else 
                    {
                        byte[] image=rs.getBytes("Photo");
                        ImageIcon format=new ImageIcon(image);
                        pic.setIcon(format);
                    }
                }
            } catch(Exception e){
                System.out.println(e);
            }
        }
        if(evt.getKeyCode()==KeyEvent.VK_DOWN)
        {
            int row=etable.getSelectedRow();
            String id=etable.getModel().getValueAt(row+1, 0).toString();
            String Fname=etable.getModel().getValueAt(row, 1).toString();
            String Surname=etable.getModel().getValueAt(row, 2).toString();
            String Salary=etable.getModel().getValueAt(row, 3).toString();
            String mSalary=etable.getModel().getValueAt(row, 8).toString();
            eid.setText(id);
            surname.setText(Surname);
            basic_sal.setText(Salary);
            msal.setText(mSalary);
            try{
                String a="select Photo from empdet where EID='"+id+"'";
                pst=conn.prepareStatement(a);
                rs=pst.executeQuery();
                if(rs.next())
                {
                    if(rs.getBytes("Photo") == null)
                    {}
                    else 
                    {
                        byte[] image=rs.getBytes("Photo");
                        ImageIcon format=new ImageIcon(image);
                        pic.setIcon(format);
                    }
                }
            } catch(Exception e){
                System.out.println(e);
            }
        }
    }//GEN-LAST:event_etableKeyPressed

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        etable.clearSelection();
    }//GEN-LAST:event_jLabel10MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField amount1;
    private javax.swing.JLabel basic_sal;
    private javax.swing.JTextField bonus;
    private javax.swing.JButton clear1;
    private javax.swing.JLabel eid;
    private javax.swing.JTable etable;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel msal;
    private javax.swing.JTextField ot;
    private javax.swing.JLabel pic;
    private javax.swing.JTextField sal;
    private javax.swing.JTextField search;
    private javax.swing.JComboBox srch_dep;
    private javax.swing.JComboBox srch_job;
    private javax.swing.JTextField srch_surname;
    private javax.swing.JLabel surname;
    // End of variables declaration//GEN-END:variables
}
