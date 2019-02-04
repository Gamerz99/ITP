
package Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import dbconnect.dbconnect;
import javax.swing.JOptionPane;

public class Update_salary extends javax.swing.JInternalFrame {

    Connection conn=null;
    PreparedStatement pst=null;
    ResultSet rs=null;
    ResultSet rs1=null;
    methods mm=new methods();
    public Update_salary() {
        initComponents();
        conn=dbconnect.connect();
    }
    private boolean check_amount(double x,double y)
    {
        if((x-y)>=0)
            return true;
        else
            return false;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jTextField14 = new javax.swing.JTextField();
        jButton23 = new javax.swing.JButton();
        jButton24 = new javax.swing.JButton();
        jLabel35 = new javax.swing.JLabel();
        manager_sal2 = new javax.swing.JLabel();
        manager_in2 = new javax.swing.JTextField();
        manager_in_bt2 = new javax.swing.JButton();
        manager_dec_bt2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        manager_sal5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        transport_sal = new javax.swing.JLabel();
        transport_in = new javax.swing.JTextField();
        transport_in_bt = new javax.swing.JButton();
        transport_dec_bt = new javax.swing.JButton();
        photographer_dec_bt = new javax.swing.JButton();
        photographer_in_bt = new javax.swing.JButton();
        photographer_in = new javax.swing.JTextField();
        photographer_sal = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        waiter_in = new javax.swing.JTextField();
        waiter_sal = new javax.swing.JLabel();
        clerk_sal = new javax.swing.JLabel();
        recep_sal = new javax.swing.JLabel();
        cook_sal = new javax.swing.JLabel();
        cleaner_sal = new javax.swing.JLabel();
        hr_sal = new javax.swing.JLabel();
        stock_sal = new javax.swing.JLabel();
        driver_sal = new javax.swing.JLabel();
        accountant_sal = new javax.swing.JLabel();
        manager_sal = new javax.swing.JLabel();
        cashier_sal = new javax.swing.JLabel();
        cashier_in = new javax.swing.JTextField();
        manager_in = new javax.swing.JTextField();
        accountant_in = new javax.swing.JTextField();
        driver_in = new javax.swing.JTextField();
        stock_in = new javax.swing.JTextField();
        hr_in = new javax.swing.JTextField();
        cleaner_in = new javax.swing.JTextField();
        cook_in = new javax.swing.JTextField();
        rec_in = new javax.swing.JTextField();
        clerk_in = new javax.swing.JTextField();
        waiter_in_bt = new javax.swing.JButton();
        waiter_dec_bt = new javax.swing.JButton();
        clerk_dec_bt = new javax.swing.JButton();
        clerk_in_bt = new javax.swing.JButton();
        rec_in_bt = new javax.swing.JButton();
        rec_dec_bt = new javax.swing.JButton();
        cook_dec_bt = new javax.swing.JButton();
        cook_in_bt = new javax.swing.JButton();
        cleaner_in_bt = new javax.swing.JButton();
        cleaner_dec_bt = new javax.swing.JButton();
        hr_dec_bt = new javax.swing.JButton();
        hr_in_bt = new javax.swing.JButton();
        stock_in_bt = new javax.swing.JButton();
        driver_in_bt = new javax.swing.JButton();
        accountant_in_bt = new javax.swing.JButton();
        manager_in_bt = new javax.swing.JButton();
        cashier_in_bt = new javax.swing.JButton();
        cashier_dec_bt = new javax.swing.JButton();
        manager_dec_bt = new javax.swing.JButton();
        accountant_dec_bt = new javax.swing.JButton();
        driver_dec_bt = new javax.swing.JButton();
        stock_dec_bt = new javax.swing.JButton();
        jLabel40 = new javax.swing.JLabel();
        transport_sal1 = new javax.swing.JLabel();
        ser = new javax.swing.JTextField();
        transport_in_bt1 = new javax.swing.JButton();
        transport_dec_bt1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        epf = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        etf = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        sh_epf = new javax.swing.JLabel();
        sh_etf = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        waiter_sal1 = new javax.swing.JLabel();
        waiter_in1 = new javax.swing.JTextField();
        waiter_in_bt1 = new javax.swing.JButton();
        waiter_dec_bt1 = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        cook_sal1 = new javax.swing.JLabel();
        cook_in1 = new javax.swing.JTextField();
        cook_in_bt1 = new javax.swing.JButton();
        cook_dec_bt1 = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        cleaner_sal1 = new javax.swing.JLabel();
        cleaner_in1 = new javax.swing.JTextField();
        cleaner_in_bt1 = new javax.swing.JButton();
        cleaner_dec_bt1 = new javax.swing.JButton();
        jLabel28 = new javax.swing.JLabel();
        driver_sal1 = new javax.swing.JLabel();
        driver_in1 = new javax.swing.JTextField();
        driver_in_bt1 = new javax.swing.JButton();
        driver_dec_bt1 = new javax.swing.JButton();
        jLabel38 = new javax.swing.JLabel();
        photographer_sal1 = new javax.swing.JLabel();
        photographer_in1 = new javax.swing.JTextField();
        photographer_in_bt1 = new javax.swing.JButton();
        photographer_dec_bt1 = new javax.swing.JButton();
        jLabel39 = new javax.swing.JLabel();
        photographer_sal2 = new javax.swing.JLabel();
        serv = new javax.swing.JTextField();
        photographer_in_bt2 = new javax.swing.JButton();
        photographer_dec_bt2 = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();

        jLabel31.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel31.setText("Other servants");

        jLabel32.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jTextField14.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jButton23.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton23.setText("+");

        jButton24.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton24.setText("-");

        jLabel35.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel35.setText("Manager");

        manager_sal2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        manager_sal2.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                manager_sal2AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        manager_in2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        manager_in_bt2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        manager_in_bt2.setText("+");
        manager_in_bt2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        manager_in_bt2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manager_in_bt2ActionPerformed(evt);
            }
        });

        manager_dec_bt2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        manager_dec_bt2.setText("-");
        manager_dec_bt2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        manager_dec_bt2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manager_dec_bt2ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1600, 925));
        setMinimumSize(new java.awt.Dimension(1600, 925));
        setPreferredSize(new java.awt.Dimension(1600, 925));

        jPanel1.setPreferredSize(new java.awt.Dimension(1140, 545));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        jLabel3.setText("Update Salary Details");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 0, 453, 41));

        manager_sal5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        manager_sal5.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                manager_sal5AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jPanel1.add(manager_sal5, new org.netbeans.lib.awtextra.AbsoluteConstraints(302, 546, 140, 27));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Permanant", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial Black", 0, 18), new java.awt.Color(0, 0, 0))); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel37.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel37.setText("Transport Manager");
        jPanel2.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 600, 150, 27));

        transport_sal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        transport_sal.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                transport_salAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jPanel2.add(transport_sal, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 600, 140, 27));

        transport_in.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel2.add(transport_in, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 600, 160, 27));

        transport_in_bt.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        transport_in_bt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/add (1).png"))); // NOI18N
        transport_in_bt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        transport_in_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transport_in_btActionPerformed(evt);
            }
        });
        jPanel2.add(transport_in_bt, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 600, 40, 27));

        transport_dec_bt.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        transport_dec_bt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/substract.png"))); // NOI18N
        transport_dec_bt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        transport_dec_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transport_dec_btActionPerformed(evt);
            }
        });
        jPanel2.add(transport_dec_bt, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 600, 40, 27));

        photographer_dec_bt.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        photographer_dec_bt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/substract.png"))); // NOI18N
        photographer_dec_bt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        photographer_dec_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                photographer_dec_btActionPerformed(evt);
            }
        });
        jPanel2.add(photographer_dec_bt, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 550, 40, 27));

        photographer_in_bt.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        photographer_in_bt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/add (1).png"))); // NOI18N
        photographer_in_bt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        photographer_in_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                photographer_in_btActionPerformed(evt);
            }
        });
        jPanel2.add(photographer_in_bt, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 550, 40, 27));

        photographer_in.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel2.add(photographer_in, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 550, 160, 27));

        photographer_sal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        photographer_sal.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                photographer_salAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jPanel2.add(photographer_sal, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 550, 140, 27));

        jLabel36.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel36.setText("Photographer");
        jPanel2.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 550, 150, 27));

        jLabel34.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel34.setText("Cashier");
        jPanel2.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 500, 150, 27));

        jLabel33.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel33.setText("Manager");
        jPanel2.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 450, 150, 27));

        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel29.setText("Accountant");
        jPanel2.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 400, 150, 27));

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel27.setText("Driver");
        jPanel2.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 356, 150, 27));

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel25.setText("Stock Manager");
        jPanel2.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 318, 150, 27));

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel16.setText("HR Manager");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, 150, 27));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel14.setText("Cleaners");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 242, 150, 27));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel13.setText("Cook");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 204, 150, 27));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setText("Receptionist");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 166, 150, 27));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("Clerk");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 128, 150, 27));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Waiter/Waitress");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 150, 27));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Occupation");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 140, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Basic Salary");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 50, 140, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Increment/Decrement");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 50, 220, 30));

        waiter_in.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel2.add(waiter_in, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 90, 160, 27));

        waiter_sal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        waiter_sal.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                waiter_salAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jPanel2.add(waiter_sal, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 90, 140, 27));

        clerk_sal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        clerk_sal.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                clerk_salAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jPanel2.add(clerk_sal, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 128, 140, 27));

        recep_sal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        recep_sal.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                recep_salAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jPanel2.add(recep_sal, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 166, 140, 27));

        cook_sal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cook_sal.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                cook_salAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jPanel2.add(cook_sal, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 204, 140, 27));

        cleaner_sal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cleaner_sal.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                cleaner_salAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jPanel2.add(cleaner_sal, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 242, 140, 27));

        hr_sal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        hr_sal.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                hr_salAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jPanel2.add(hr_sal, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 280, 140, 27));

        stock_sal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        stock_sal.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                stock_salAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jPanel2.add(stock_sal, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 318, 140, 27));

        driver_sal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        driver_sal.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                driver_salAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jPanel2.add(driver_sal, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 356, 140, 27));

        accountant_sal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        accountant_sal.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                accountant_salAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jPanel2.add(accountant_sal, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 400, 140, 27));

        manager_sal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        manager_sal.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                manager_salAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jPanel2.add(manager_sal, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 450, 140, 27));

        cashier_sal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cashier_sal.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                cashier_salAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jPanel2.add(cashier_sal, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 500, 140, 27));

        cashier_in.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel2.add(cashier_in, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 500, 160, 27));

        manager_in.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel2.add(manager_in, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 450, 160, 27));

        accountant_in.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel2.add(accountant_in, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 400, 160, 27));

        driver_in.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel2.add(driver_in, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 356, 160, 27));

        stock_in.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel2.add(stock_in, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 318, 160, 27));

        hr_in.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel2.add(hr_in, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 280, 160, 27));

        cleaner_in.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel2.add(cleaner_in, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 242, 160, 27));

        cook_in.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel2.add(cook_in, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 204, 160, 27));

        rec_in.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel2.add(rec_in, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 166, 160, 27));

        clerk_in.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel2.add(clerk_in, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 128, 160, 27));

        waiter_in_bt.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        waiter_in_bt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/add (1).png"))); // NOI18N
        waiter_in_bt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        waiter_in_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                waiter_in_btActionPerformed(evt);
            }
        });
        jPanel2.add(waiter_in_bt, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 90, 40, 27));

        waiter_dec_bt.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        waiter_dec_bt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/substract.png"))); // NOI18N
        waiter_dec_bt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        waiter_dec_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                waiter_dec_btActionPerformed(evt);
            }
        });
        jPanel2.add(waiter_dec_bt, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 90, 40, 27));

        clerk_dec_bt.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        clerk_dec_bt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/substract.png"))); // NOI18N
        clerk_dec_bt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        clerk_dec_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clerk_dec_btActionPerformed(evt);
            }
        });
        jPanel2.add(clerk_dec_bt, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 128, 40, 27));

        clerk_in_bt.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        clerk_in_bt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/add (1).png"))); // NOI18N
        clerk_in_bt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        clerk_in_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clerk_in_btActionPerformed(evt);
            }
        });
        jPanel2.add(clerk_in_bt, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 128, 40, 27));

        rec_in_bt.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        rec_in_bt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/add (1).png"))); // NOI18N
        rec_in_bt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rec_in_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rec_in_btActionPerformed(evt);
            }
        });
        jPanel2.add(rec_in_bt, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 166, 40, 27));

        rec_dec_bt.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        rec_dec_bt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/substract.png"))); // NOI18N
        rec_dec_bt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rec_dec_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rec_dec_btActionPerformed(evt);
            }
        });
        jPanel2.add(rec_dec_bt, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 166, 40, 27));

        cook_dec_bt.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cook_dec_bt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/substract.png"))); // NOI18N
        cook_dec_bt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cook_dec_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cook_dec_btActionPerformed(evt);
            }
        });
        jPanel2.add(cook_dec_bt, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 204, 40, 27));

        cook_in_bt.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cook_in_bt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/add (1).png"))); // NOI18N
        cook_in_bt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cook_in_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cook_in_btActionPerformed(evt);
            }
        });
        jPanel2.add(cook_in_bt, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 204, 40, 27));

        cleaner_in_bt.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cleaner_in_bt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/add (1).png"))); // NOI18N
        cleaner_in_bt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cleaner_in_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cleaner_in_btActionPerformed(evt);
            }
        });
        jPanel2.add(cleaner_in_bt, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 242, 40, 27));

        cleaner_dec_bt.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cleaner_dec_bt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/substract.png"))); // NOI18N
        cleaner_dec_bt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cleaner_dec_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cleaner_dec_btActionPerformed(evt);
            }
        });
        jPanel2.add(cleaner_dec_bt, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 242, 40, 27));

        hr_dec_bt.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        hr_dec_bt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/substract.png"))); // NOI18N
        hr_dec_bt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        hr_dec_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hr_dec_btActionPerformed(evt);
            }
        });
        jPanel2.add(hr_dec_bt, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 280, 40, 27));

        hr_in_bt.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        hr_in_bt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/add (1).png"))); // NOI18N
        hr_in_bt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        hr_in_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hr_in_btActionPerformed(evt);
            }
        });
        jPanel2.add(hr_in_bt, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 280, 40, 27));

        stock_in_bt.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        stock_in_bt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/add (1).png"))); // NOI18N
        stock_in_bt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        stock_in_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stock_in_btActionPerformed(evt);
            }
        });
        jPanel2.add(stock_in_bt, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 318, 40, 27));

        driver_in_bt.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        driver_in_bt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/add (1).png"))); // NOI18N
        driver_in_bt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        driver_in_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                driver_in_btActionPerformed(evt);
            }
        });
        jPanel2.add(driver_in_bt, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 356, 40, 27));

        accountant_in_bt.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        accountant_in_bt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/add (1).png"))); // NOI18N
        accountant_in_bt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        accountant_in_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accountant_in_btActionPerformed(evt);
            }
        });
        jPanel2.add(accountant_in_bt, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 400, 40, 27));

        manager_in_bt.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        manager_in_bt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/add (1).png"))); // NOI18N
        manager_in_bt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        manager_in_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manager_in_btActionPerformed(evt);
            }
        });
        jPanel2.add(manager_in_bt, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 450, 40, 27));

        cashier_in_bt.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cashier_in_bt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/add (1).png"))); // NOI18N
        cashier_in_bt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cashier_in_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cashier_in_btActionPerformed(evt);
            }
        });
        jPanel2.add(cashier_in_bt, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 500, 40, 27));

        cashier_dec_bt.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cashier_dec_bt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/substract.png"))); // NOI18N
        cashier_dec_bt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cashier_dec_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cashier_dec_btActionPerformed(evt);
            }
        });
        jPanel2.add(cashier_dec_bt, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 500, 40, 27));

        manager_dec_bt.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        manager_dec_bt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/substract.png"))); // NOI18N
        manager_dec_bt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        manager_dec_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manager_dec_btActionPerformed(evt);
            }
        });
        jPanel2.add(manager_dec_bt, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 450, 40, 27));

        accountant_dec_bt.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        accountant_dec_bt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/substract.png"))); // NOI18N
        accountant_dec_bt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        accountant_dec_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accountant_dec_btActionPerformed(evt);
            }
        });
        jPanel2.add(accountant_dec_bt, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 400, 40, 27));

        driver_dec_bt.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        driver_dec_bt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/substract.png"))); // NOI18N
        driver_dec_bt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        driver_dec_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                driver_dec_btActionPerformed(evt);
            }
        });
        jPanel2.add(driver_dec_bt, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 356, 40, 27));

        stock_dec_bt.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        stock_dec_bt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/substract.png"))); // NOI18N
        stock_dec_bt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        stock_dec_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stock_dec_btActionPerformed(evt);
            }
        });
        jPanel2.add(stock_dec_bt, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 318, 40, 27));

        jLabel40.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel40.setText("Servant");
        jPanel2.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 650, 150, 27));

        transport_sal1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        transport_sal1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                transport_sal1AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jPanel2.add(transport_sal1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 650, 140, 27));

        ser.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel2.add(ser, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 650, 160, 27));

        transport_in_bt1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        transport_in_bt1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/add (1).png"))); // NOI18N
        transport_in_bt1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        transport_in_bt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transport_in_bt1ActionPerformed(evt);
            }
        });
        jPanel2.add(transport_in_bt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 650, 40, 27));

        transport_dec_bt1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        transport_dec_bt1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/substract.png"))); // NOI18N
        transport_dec_bt1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        transport_dec_bt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transport_dec_bt1ActionPerformed(evt);
            }
        });
        jPanel2.add(transport_dec_bt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 650, 40, 27));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, 670, 740));

        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel17.setText("EPF Rate");
        jPanel3.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 5, 90, 27));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setText("EPF");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, 35, 30));

        epf.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel3.add(epf, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, 31, 30));

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel23.setText("%");
        jPanel3.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 50, 22, 30));

        jButton9.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/add (1).png"))); // NOI18N
        jButton9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 50, 40, 30));

        jButton10.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/substract.png"))); // NOI18N
        jButton10.setToolTipText("");
        jButton10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 50, 40, 30));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel19.setText("ETF Rate");
        jPanel3.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 80, 27));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setText("ETF");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, 35, 30));

        etf.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel3.add(etf, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, 31, 30));

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel24.setText("%");
        jPanel3.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 140, 22, 30));

        jButton11.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/add (1).png"))); // NOI18N
        jButton11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 140, 40, 30));

        jButton12.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/substract.png"))); // NOI18N
        jButton12.setToolTipText("");
        jButton12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 140, 40, 30));

        sh_epf.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        sh_epf.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                sh_epfAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jPanel3.add(sh_epf, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, 40, 32));

        sh_etf.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        sh_etf.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                sh_etfAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jPanel3.add(sh_etf, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, 40, 30));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 510, 400, 230));

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Temporary", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial Black", 1, 18), new java.awt.Color(0, 0, 0))); // NOI18N
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("Occupation");
        jPanel5.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 130, 30));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel12.setText("Increment/Decrement");
        jPanel5.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 40, 250, 30));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("Basic Salary");
        jPanel5.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 40, 140, 30));

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel15.setText("Waiter/Waitress");
        jPanel5.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 130, 27));

        waiter_sal1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        waiter_sal1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                waiter_sal1AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jPanel5.add(waiter_sal1, new org.netbeans.lib.awtextra.AbsoluteConstraints(165, 90, 140, 27));

        waiter_in1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel5.add(waiter_in1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 90, 160, 27));

        waiter_in_bt1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        waiter_in_bt1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/add (1).png"))); // NOI18N
        waiter_in_bt1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        waiter_in_bt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                waiter_in_bt1ActionPerformed(evt);
            }
        });
        jPanel5.add(waiter_in_bt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 90, 40, 30));

        waiter_dec_bt1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        waiter_dec_bt1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/substract.png"))); // NOI18N
        waiter_dec_bt1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        waiter_dec_bt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                waiter_dec_bt1ActionPerformed(evt);
            }
        });
        jPanel5.add(waiter_dec_bt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 90, 40, 30));

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel18.setText("Cook");
        jPanel5.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 130, 27));

        cook_sal1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cook_sal1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                cook_sal1AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jPanel5.add(cook_sal1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 130, 140, 27));

        cook_in1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel5.add(cook_in1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 130, 160, 27));

        cook_in_bt1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cook_in_bt1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/add (1).png"))); // NOI18N
        cook_in_bt1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cook_in_bt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cook_in_bt1ActionPerformed(evt);
            }
        });
        jPanel5.add(cook_in_bt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 130, 40, 30));

        cook_dec_bt1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cook_dec_bt1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/substract.png"))); // NOI18N
        cook_dec_bt1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cook_dec_bt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cook_dec_bt1ActionPerformed(evt);
            }
        });
        jPanel5.add(cook_dec_bt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 130, 40, 30));

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel20.setText("Cleaners");
        jPanel5.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 130, 27));

        cleaner_sal1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cleaner_sal1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                cleaner_sal1AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jPanel5.add(cleaner_sal1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 180, 140, 27));

        cleaner_in1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel5.add(cleaner_in1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 180, 160, 27));

        cleaner_in_bt1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cleaner_in_bt1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/add (1).png"))); // NOI18N
        cleaner_in_bt1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cleaner_in_bt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cleaner_in_bt1ActionPerformed(evt);
            }
        });
        jPanel5.add(cleaner_in_bt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 180, 40, 30));

        cleaner_dec_bt1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cleaner_dec_bt1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/substract.png"))); // NOI18N
        cleaner_dec_bt1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cleaner_dec_bt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cleaner_dec_bt1ActionPerformed(evt);
            }
        });
        jPanel5.add(cleaner_dec_bt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 180, 40, 30));

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel28.setText("Driver");
        jPanel5.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 130, 27));

        driver_sal1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        driver_sal1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                driver_sal1AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jPanel5.add(driver_sal1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 230, 140, 27));

        driver_in1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel5.add(driver_in1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 230, 160, 27));

        driver_in_bt1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        driver_in_bt1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/add (1).png"))); // NOI18N
        driver_in_bt1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        driver_in_bt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                driver_in_bt1ActionPerformed(evt);
            }
        });
        jPanel5.add(driver_in_bt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 230, 40, 30));

        driver_dec_bt1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        driver_dec_bt1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/substract.png"))); // NOI18N
        driver_dec_bt1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        driver_dec_bt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                driver_dec_bt1ActionPerformed(evt);
            }
        });
        jPanel5.add(driver_dec_bt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 230, 40, 30));

        jLabel38.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel38.setText("Photographer");
        jPanel5.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, 130, 27));

        photographer_sal1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        photographer_sal1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                photographer_sal1AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jPanel5.add(photographer_sal1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 280, 140, 27));

        photographer_in1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel5.add(photographer_in1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 280, 160, 27));

        photographer_in_bt1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        photographer_in_bt1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/add (1).png"))); // NOI18N
        photographer_in_bt1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        photographer_in_bt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                photographer_in_bt1ActionPerformed(evt);
            }
        });
        jPanel5.add(photographer_in_bt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 280, 40, 30));

        photographer_dec_bt1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        photographer_dec_bt1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/substract.png"))); // NOI18N
        photographer_dec_bt1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        photographer_dec_bt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                photographer_dec_bt1ActionPerformed(evt);
            }
        });
        jPanel5.add(photographer_dec_bt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 280, 40, 30));

        jLabel39.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel39.setText("Servant");
        jPanel5.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, 130, 27));

        photographer_sal2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        photographer_sal2.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                photographer_sal2AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jPanel5.add(photographer_sal2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 330, 140, 27));

        serv.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel5.add(serv, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 330, 160, 27));

        photographer_in_bt2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        photographer_in_bt2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/add (1).png"))); // NOI18N
        photographer_in_bt2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        photographer_in_bt2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                photographer_in_bt2ActionPerformed(evt);
            }
        });
        jPanel5.add(photographer_in_bt2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 330, 40, 30));

        photographer_dec_bt2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        photographer_dec_bt2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/substract.png"))); // NOI18N
        photographer_dec_bt2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        photographer_dec_bt2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                photographer_dec_bt2ActionPerformed(evt);
            }
        });
        jPanel5.add(photographer_dec_bt2, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 330, 40, 30));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 60, 650, 400));

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/body.jpg"))); // NOI18N
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1600, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1597, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 900, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void waiter_dec_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_waiter_dec_btActionPerformed
        if(waiter_in.getText().compareTo("")!=0)
        {
            double sal=Double.parseDouble(waiter_in.getText());
            try
            {
                String a="select Salary from charges where Type='Waiter'";
                pst=conn.prepareStatement(a);
                rs=pst.executeQuery();
                if(rs.next())
                {
                    if(JOptionPane.showConfirmDialog(null, "Do you really need to increase the salary")==0)
                    {
                    double salary=Double.parseDouble(rs.getString("Salary"));
                    double newSal=salary-sal;
                    if(check_amount(salary,sal)==true)
                    {
                        String b="update charges set Salary='"+newSal+"' where Type='Waiter'";
                        pst=conn.prepareStatement(b);
                        pst.execute();
                        waiter_sal.setText(Double.toString(newSal));
                        waiter_in.setText("");
                    }
                    else
                        JOptionPane.showMessageDialog(null, "Salary is not enough");
                    }
                }
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
        else if(waiter_in.getText().compareTo("")==0)
            JOptionPane.showMessageDialog(null, "Please Input a value to the data field");
    }//GEN-LAST:event_waiter_dec_btActionPerformed

    private void waiter_salAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_waiter_salAncestorAdded
        try {
            String a="select * from charges where Type='Waiter'";
            pst=conn.prepareStatement(a);
            rs=pst.executeQuery();
            if(rs.next())
            {
                double c=Double.parseDouble(rs.getString("Salary"));
                waiter_sal.setText(Double.toString(c));
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_waiter_salAncestorAdded

    private void waiter_in_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_waiter_in_btActionPerformed
        if(waiter_in.getText().compareTo("")!=0)
        {
            double sal=Double.parseDouble(waiter_in.getText());
            try
            {
                String a="select Salary from charges where Type='Waiter'";
                pst=conn.prepareStatement(a);
                rs=pst.executeQuery();
                if(rs.next())
                {
                    if(JOptionPane.showConfirmDialog(null, "Do you really need to increase the salary")==0)
                    {
                        double salary=Double.parseDouble(rs.getString("Salary"));
                        double newSal=salary+sal;
                        String b="update charges set Salary='"+newSal+"' where Type='Waiter'";
                        pst=conn.prepareStatement(b);
                        pst.execute();
                        waiter_sal.setText(Double.toString(newSal));
                        waiter_in.setText("");
                    }
                }
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
        else if(waiter_in.getText().compareTo("")==0)
            JOptionPane.showMessageDialog(null, "Please Input a value to the data field");
    }//GEN-LAST:event_waiter_in_btActionPerformed

    private void clerk_salAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_clerk_salAncestorAdded
        try {
            String a="select * from charges where Type='Clerk'";
            pst=conn.prepareStatement(a);
            rs=pst.executeQuery();
            if(rs.next())
            {
                double c=Double.parseDouble(rs.getString("Salary"));
                clerk_sal.setText(Double.toString(c));
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_clerk_salAncestorAdded

    private void recep_salAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_recep_salAncestorAdded
        try {
            String a="select * from charges where Type='Receptionist'";
            pst=conn.prepareStatement(a);
            rs=pst.executeQuery();
            if(rs.next())
            {
                double c=Double.parseDouble(rs.getString("Salary"));
                recep_sal.setText(Double.toString(c));
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_recep_salAncestorAdded

    private void cook_salAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_cook_salAncestorAdded
        try {
            String a="select * from charges where Type='Cook'";
            pst=conn.prepareStatement(a);
            rs=pst.executeQuery();
            if(rs.next())
            {
                double c=Double.parseDouble(rs.getString("Salary"));
                cook_sal.setText(Double.toString(c));
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_cook_salAncestorAdded

    private void cleaner_salAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_cleaner_salAncestorAdded
        try {
            String a="select * from charges where Type='Cleaner'";
            pst=conn.prepareStatement(a);
            rs=pst.executeQuery();
            if(rs.next())
            {
                double c=Double.parseDouble(rs.getString("Salary"));
                cleaner_sal.setText(Double.toString(c));
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_cleaner_salAncestorAdded

    private void hr_salAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_hr_salAncestorAdded
        try {
            String a="select * from charges where Type='HR Manager'";
            pst=conn.prepareStatement(a);
            rs=pst.executeQuery();
            if(rs.next())
            {
                double c=Double.parseDouble(rs.getString("Salary"));
                hr_sal.setText(Double.toString(c));
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_hr_salAncestorAdded

    private void stock_salAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_stock_salAncestorAdded
        try {
            String a="select * from charges where Type='Stock Keeper'";
            pst=conn.prepareStatement(a);
            rs=pst.executeQuery();
            if(rs.next())
            {
                double c=Double.parseDouble(rs.getString("Salary"));
                stock_sal.setText(Double.toString(c));
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_stock_salAncestorAdded

    private void driver_salAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_driver_salAncestorAdded
        try {
            String a="select * from charges where Type='Driver'";
            pst=conn.prepareStatement(a);
            rs=pst.executeQuery();
            if(rs.next())
            {
                double c=Double.parseDouble(rs.getString("Salary"));
                driver_sal.setText(Double.toString(c));
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_driver_salAncestorAdded

    private void accountant_salAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_accountant_salAncestorAdded
        try {
            String a="select * from charges where Type='Accountant'";
            pst=conn.prepareStatement(a);
            rs=pst.executeQuery();
            if(rs.next())
            {
                double c=Double.parseDouble(rs.getString("Salary"));
                accountant_sal.setText(Double.toString(c));
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_accountant_salAncestorAdded

    private void manager_salAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_manager_salAncestorAdded
        try {
            String a="select * from charges where Type='Manager'";
            pst=conn.prepareStatement(a);
            rs=pst.executeQuery();
            if(rs.next())
            {
                double c=Double.parseDouble(rs.getString("Salary"));
                manager_sal.setText(Double.toString(c));
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_manager_salAncestorAdded

    private void clerk_in_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clerk_in_btActionPerformed
        if(clerk_in.getText().compareTo("")!=0)
        {
            double sal=Double.parseDouble(clerk_in.getText());
            try
            {
                String a="select Salary from charges where Type='Clerk'";
                pst=conn.prepareStatement(a);
                rs=pst.executeQuery();
                if(rs.next())
                {
                    if(JOptionPane.showConfirmDialog(null, "Do you really need to increase the salary")==0)
                    {
                    
                    double salary=Double.parseDouble(rs.getString("Salary"));
                    double newSal=salary+sal;
                    String b="update charges set Salary='"+newSal+"' where Type='Clerk'";
                    pst=conn.prepareStatement(b);
                    pst.execute();
                    clerk_sal.setText(Double.toString(newSal));
                    clerk_in.setText("");
                    
                    }
                }
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
        else if(clerk_in.getText().compareTo("")==0)
            JOptionPane.showMessageDialog(null, "Please Input a value to the data field");
    }//GEN-LAST:event_clerk_in_btActionPerformed

    private void clerk_dec_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clerk_dec_btActionPerformed
        if(clerk_in.getText().compareTo("")!=0)
        {
            double sal=Double.parseDouble(clerk_in.getText());
            try
            {
                String a="select Salary from charges where Type='Clerk'";
                pst=conn.prepareStatement(a);
                rs=pst.executeQuery();
                if(rs.next())
                {
                    if(JOptionPane.showConfirmDialog(null, "Do you really need to increase the salary")==0)
                    {
                        double salary=Double.parseDouble(rs.getString("Salary"));
                        double newSal=salary-sal;
                        if(check_amount(salary,sal)==true)
                        {
                            String b="update charges set Salary='"+newSal+"' where Type='Clerk'";
                            pst=conn.prepareStatement(b);
                            pst.execute();
                            clerk_sal.setText(Double.toString(newSal));
                            clerk_in.setText("");
                        }
                        else
                            JOptionPane.showMessageDialog(null, "Salary is not enough");
                    }
                }
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
        else if(clerk_in.getText().compareTo("")==0)
            JOptionPane.showMessageDialog(null, "Please Input a value to the data field");
    }//GEN-LAST:event_clerk_dec_btActionPerformed

    private void rec_in_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rec_in_btActionPerformed
        if(rec_in.getText().compareTo("")!=0)
        {
            double sal=Double.parseDouble(rec_in.getText());
            try
            {
                String a="select Salary from charges where Type='Receptionist'";
                pst=conn.prepareStatement(a);
                rs=pst.executeQuery();
                if(rs.next())
                {
                    if(JOptionPane.showConfirmDialog(null, "Do you really need to increase the salary")==0)
                    {
                    double salary=Double.parseDouble(rs.getString("Salary"));
                    double newSal=salary+sal;
                    String b="update charges set Salary='"+newSal+"' where Type='Receptionist'";
                    pst=conn.prepareStatement(b);
                    pst.execute();
                    recep_sal.setText(Double.toString(newSal));
                    rec_in.setText("");
                    }
                }
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
        else if(rec_in.getText().compareTo("")==0)
            JOptionPane.showMessageDialog(null, "Please Input a value to the data field");
    }//GEN-LAST:event_rec_in_btActionPerformed

    private void rec_dec_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rec_dec_btActionPerformed
        if(rec_in.getText().compareTo("")!=0)
        {
            double sal=Double.parseDouble(rec_in.getText());
            try
            {
                String a="select Salary from charges where Type='Receptionist'";
                pst=conn.prepareStatement(a);
                rs=pst.executeQuery();
                if(rs.next())
                {
                    if(JOptionPane.showConfirmDialog(null, "Do you really need to increase the salary")==0)
                    {
                    double salary=Double.parseDouble(rs.getString("Salary"));
                    double newSal=salary-sal;
                    if(check_amount(salary,sal)==true)
                    {
                        String b="update charges set Salary='"+newSal+"' where Type='Receptionist'";
                        pst=conn.prepareStatement(b);
                        pst.execute();
                        recep_sal.setText(Double.toString(newSal));
                        rec_in.setText("");
                    }
                    else
                        JOptionPane.showMessageDialog(null, "Salary is not enough");
                    }
                }
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
        else if(rec_in.getText().compareTo("")==0)
            JOptionPane.showMessageDialog(null, "Please Input a value to the data field");
    }//GEN-LAST:event_rec_dec_btActionPerformed

    private void cook_in_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cook_in_btActionPerformed
        if(cook_in.getText().compareTo("")!=0)
        {
            double sal=Double.parseDouble(cook_in.getText());
            try
            {
                String a="select Salary from charges where Type='Cook'";
                pst=conn.prepareStatement(a);
                rs=pst.executeQuery();
                if(rs.next())
                {
                    if(JOptionPane.showConfirmDialog(null, "Do you really need to increase the salary")==0)
                    {
                    double salary=Double.parseDouble(rs.getString("Salary"));
                    double newSal=salary+sal;
                    String b="update charges set Salary='"+newSal+"' where Type='Cook'";
                    pst=conn.prepareStatement(b);
                    pst.execute();
                    cook_sal.setText(Double.toString(newSal));
                    cook_in.setText("");
                    }
                }
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
        else if(cook_in.getText().compareTo("")==0)
            JOptionPane.showMessageDialog(null, "Please Input a value to the data field");
    }//GEN-LAST:event_cook_in_btActionPerformed

    private void cook_dec_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cook_dec_btActionPerformed
        if(cook_in.getText().compareTo("")!=0)
        {
            double sal=Double.parseDouble(cook_in.getText());
            try
            {
                String a="select Salary from charges where Type='Cook'";
                pst=conn.prepareStatement(a);
                rs=pst.executeQuery();
                if(rs.next())
                {
                    if(JOptionPane.showConfirmDialog(null, "Do you really need to increase the salary")==0)
                    {
                        double salary=Double.parseDouble(rs.getString("Salary"));
                        double newSal=salary-sal;
                        if(check_amount(salary,sal)==true)
                        {
                            String b="update charges set Salary='"+newSal+"' where Type='Cook'";
                            pst=conn.prepareStatement(b);
                            pst.execute();
                            cook_sal.setText(Double.toString(newSal));
                            cook_in.setText("");
                        }
                        else
                            JOptionPane.showMessageDialog(null, "Salary is not enough");
                    }
                }
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
        else if(cook_in.getText().compareTo("")==0)
            JOptionPane.showMessageDialog(null, "Please Input a value to the data field");
    }//GEN-LAST:event_cook_dec_btActionPerformed

    private void cleaner_in_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cleaner_in_btActionPerformed
        if(cleaner_in.getText().compareTo("")!=0)
        {
            double sal=Double.parseDouble(cleaner_in.getText());
            try
            {
                String a="select Salary from charges where Type='Cleaner'";
                pst=conn.prepareStatement(a);
                rs=pst.executeQuery();
                if(rs.next())
                {
                    if(JOptionPane.showConfirmDialog(null, "Do you really need to increase the salary")==0)
                    {
                    double salary=Double.parseDouble(rs.getString("Salary"));
                    double newSal=salary+sal;
                    String b="update charges set Salary='"+newSal+"' where Type='Cleaner'";
                    pst=conn.prepareStatement(b);
                    pst.execute();
                    cleaner_sal.setText(Double.toString(newSal));
                    cleaner_in.setText("");
                    }
                }
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
        else if(cleaner_in.getText().compareTo("")==0)
            JOptionPane.showMessageDialog(null, "Please Input a value to the data field");
    }//GEN-LAST:event_cleaner_in_btActionPerformed

    private void cleaner_dec_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cleaner_dec_btActionPerformed
        if(cleaner_in.getText().compareTo("")!=0)
        {
            double sal=Double.parseDouble(cleaner_in.getText());
            try
            {
                String a="select Salary from charges where Type='Cleaner'";
                pst=conn.prepareStatement(a);
                rs=pst.executeQuery();
                if(rs.next())
                {
                    if(JOptionPane.showConfirmDialog(null, "Do you really need to increase the salary")==0)
                    {
                    double salary=Double.parseDouble(rs.getString("Salary"));
                    double newSal=salary-sal;
                    if(check_amount(salary,sal)==true)
                    {
                        String b="update charges set Salary='"+newSal+"' where Type='Cleaner'";
                        pst=conn.prepareStatement(b);
                        pst.execute();
                        cleaner_sal.setText(Double.toString(newSal));
                        cleaner_in.setText("");
                    }
                    else
                        JOptionPane.showMessageDialog(null, "Salary is not enough");
                    }
                }
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
        else if(cleaner_in.getText().compareTo("")==0)
            JOptionPane.showMessageDialog(null, "Please Input a value to the data field");
    }//GEN-LAST:event_cleaner_dec_btActionPerformed

    private void hr_in_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hr_in_btActionPerformed
        if(hr_in.getText().compareTo("")!=0)
        {
            double sal=Double.parseDouble(hr_in.getText());
            try
            {
                String a="select Salary from charges where Type='HR Manager'";
                pst=conn.prepareStatement(a);
                rs=pst.executeQuery();
                if(rs.next())
                {
                    if(JOptionPane.showConfirmDialog(null, "Do you really need to increase the salary")==0)
                    {
                    double salary=Double.parseDouble(rs.getString("Salary"));
                    double newSal=salary+sal;
                    String b="update charges set Salary='"+newSal+"' where Type='HR Manager'";
                    pst=conn.prepareStatement(b);
                    pst.execute();
                    hr_sal.setText(Double.toString(newSal));
                    hr_in.setText("");
                    }
                }
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
        else if(hr_in.getText().compareTo("")==0)
            JOptionPane.showMessageDialog(null, "Please Input a value to the data field");
    }//GEN-LAST:event_hr_in_btActionPerformed

    private void hr_dec_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hr_dec_btActionPerformed
        if(hr_in.getText().compareTo("")!=0)
        {
            double sal=Double.parseDouble(hr_in.getText());
            try
            {
                String a="select Salary from charges where Type='HR Manager'";
                pst=conn.prepareStatement(a);
                rs=pst.executeQuery();
                if(rs.next())
                {
                    if(JOptionPane.showConfirmDialog(null, "Do you really need to increase the salary")==0)
                    {
                        double salary=Double.parseDouble(rs.getString("Salary"));
                        double newSal=salary-sal;
                        if(check_amount(salary,sal)==true)
                        {
                            String b="update charges set Salary='"+newSal+"' where Type='HR Manager'";
                            pst=conn.prepareStatement(b);
                            pst.execute();
                            hr_sal.setText(Double.toString(newSal));
                            hr_in.setText("");
                        }
                        else
                            JOptionPane.showMessageDialog(null, "Salary is not enough");
                    }
                }
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
        else if(hr_in.getText().compareTo("")==0)
            JOptionPane.showMessageDialog(null, "Please Input a value to the data field");
    }//GEN-LAST:event_hr_dec_btActionPerformed

    private void stock_in_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stock_in_btActionPerformed
        if(stock_in.getText().compareTo("")!=0)
        {
            double sal=Double.parseDouble(stock_in.getText());
            try
            {
                String a="select Salary from charges where Type='Stock Manager'";
                pst=conn.prepareStatement(a);
                rs=pst.executeQuery();
                if(rs.next())
                {
                    if(JOptionPane.showConfirmDialog(null, "Do you really need to increase the salary")==0)
                    {
                    double salary=Double.parseDouble(rs.getString("Salary"));
                    double newSal=salary+sal;
                    String b="update charges set Salary='"+newSal+"' where Type='Stock Manager'";
                    pst=conn.prepareStatement(b);
                    pst.execute();
                    stock_sal.setText(Double.toString(newSal));
                    stock_in.setText("");
                    }
                }
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
        else if(stock_in.getText().compareTo("")==0)
            JOptionPane.showMessageDialog(null, "Please Input a value to the data field");
    }//GEN-LAST:event_stock_in_btActionPerformed

    private void stock_dec_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stock_dec_btActionPerformed
        if(stock_in.getText().compareTo("")!=0)
        {
            double sal=Double.parseDouble(stock_in.getText());
            try
            {
                String a="select Salary from charges where Type='Stock Manager'";
                pst=conn.prepareStatement(a);
                rs=pst.executeQuery();
                if(rs.next())
                {
                    if(JOptionPane.showConfirmDialog(null, "Do you really need to increase the salary")==0)
                    {
                    double salary=Double.parseDouble(rs.getString("Salary"));
                    double newSal=salary-sal;
                    if(check_amount(salary,sal)==true)
                    {
                        String b="update charges set Salary='"+newSal+"' where Type='Stock Manager'";
                        pst=conn.prepareStatement(b);
                        pst.execute();
                        stock_sal.setText(Double.toString(newSal));
                        stock_in.setText("");
                    }
                    else
                        JOptionPane.showMessageDialog(null, "Salary is not enough");
                    }
                }
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
        else if(stock_in.getText().compareTo("")==0)
            JOptionPane.showMessageDialog(null, "Please Input a value to the data field");
    }//GEN-LAST:event_stock_dec_btActionPerformed

    private void driver_in_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_driver_in_btActionPerformed
        if(driver_in.getText().compareTo("")!=0)
        {
            double sal=Double.parseDouble(driver_in.getText());
            try
            {
                String a="select Salary from charges where Type='Driver'";
                pst=conn.prepareStatement(a);
                rs=pst.executeQuery();
                if(rs.next())
                {
                    if(JOptionPane.showConfirmDialog(null, "Do you really need to increase the salary")==0)
                    {
                    double salary=Double.parseDouble(rs.getString("Salary"));
                    double newSal=salary+sal;
                    String b="update charges set Salary='"+newSal+"' where Type='Driver'";
                    pst=conn.prepareStatement(b);
                    pst.execute();
                    driver_sal.setText(Double.toString(newSal));
                    driver_in.setText("");
                    }
                }
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
        else if(driver_in.getText().compareTo("")==0)
            JOptionPane.showMessageDialog(null, "Please Input a value to the data field");
    }//GEN-LAST:event_driver_in_btActionPerformed

    private void driver_dec_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_driver_dec_btActionPerformed
        if(driver_in.getText().compareTo("")!=0)
        {
            double sal=Double.parseDouble(driver_in.getText());
            try
            {
                String a="select Salary from charges where Type='Driver'";
                pst=conn.prepareStatement(a);
                rs=pst.executeQuery();
                if(rs.next())
                {
                    if(JOptionPane.showConfirmDialog(null, "Do you really need to increase the salary")==0)
                    {
                    double salary=Double.parseDouble(rs.getString("Salary"));
                    double newSal=salary-sal;
                    if(check_amount(salary,sal)==true)
                    {
                        String b="update charges set Salary='"+newSal+"' where Type='Driver'";
                        pst=conn.prepareStatement(b);
                        pst.execute();
                        driver_sal.setText(Double.toString(newSal));
                        driver_in.setText("");
                    }
                    else
                        JOptionPane.showMessageDialog(null, "Salary is not enough");
                    }
                }
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
        else if(driver_in.getText().compareTo("")==0)
            JOptionPane.showMessageDialog(null, "Please Input a value to the data field");
    }//GEN-LAST:event_driver_dec_btActionPerformed

    private void accountant_in_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accountant_in_btActionPerformed
        if(accountant_in.getText().compareTo("")!=0)
        {
            double sal=Double.parseDouble(accountant_in.getText());
            try
            {
                String a="select Salary from charges where Type='Accountant'";
                pst=conn.prepareStatement(a);
                rs=pst.executeQuery();
                if(rs.next())
                {
                    if(JOptionPane.showConfirmDialog(null, "Do you really need to increase the salary")==0)
                    {
                        double salary=Double.parseDouble(rs.getString("Salary"));
                        double newSal=salary+sal;
                        String b="update charges set Salary='"+newSal+"' where Type='Accountant'";
                        pst=conn.prepareStatement(b);
                        pst.execute();
                        accountant_sal.setText(Double.toString(newSal));
                        accountant_in.setText("");
                    }
                }
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
        else if(accountant_in.getText().compareTo("")==0)
            JOptionPane.showMessageDialog(null, "Please Input a value to the data field");
    }//GEN-LAST:event_accountant_in_btActionPerformed

    private void accountant_dec_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accountant_dec_btActionPerformed
        if(accountant_in.getText().compareTo("")!=0)
        {
            double sal=Double.parseDouble(accountant_in.getText());
            try
            {
                String a="select Salary from charges where Type='Accountant'";
                pst=conn.prepareStatement(a);
                rs=pst.executeQuery();
                if(rs.next())
                {
                    if(JOptionPane.showConfirmDialog(null, "Do you really need to increase the salary")==0)
                    {
                        double salary=Double.parseDouble(rs.getString("Salary"));
                        double newSal=salary-sal;
                        if(check_amount(salary,sal)==true)
                        {
                            String b="update charges set Salary='"+newSal+"' where Type='Accountant'";
                            pst=conn.prepareStatement(b);
                            pst.execute();
                            accountant_sal.setText(Double.toString(newSal));
                            accountant_in.setText("");
                        }
                        else
                            JOptionPane.showMessageDialog(null, "Salary is not enough");
                    }
                }
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
        else if(accountant_in.getText().compareTo("")==0)
            JOptionPane.showMessageDialog(null, "Please Input a value to the data field");
    }//GEN-LAST:event_accountant_dec_btActionPerformed

    private void manager_in_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manager_in_btActionPerformed
        if(manager_in.getText().compareTo("")!=0)
        {
            double sal=Double.parseDouble(manager_in.getText());
            try
            {
                String a="select Salary from charges where Type='Manager'";
                pst=conn.prepareStatement(a);
                rs=pst.executeQuery();
                if(rs.next())
                {
                    if(JOptionPane.showConfirmDialog(null, "Do you really need to increase the salary")==0)
                    {
                        double salary=Double.parseDouble(rs.getString("Salary"));
                        double newSal=salary+sal;
                        String b="update charges set Salary='"+newSal+"' where Type='Manager'";
                        pst=conn.prepareStatement(b);
                        pst.execute();
                        manager_sal.setText(Double.toString(newSal));
                        manager_in.setText("");
                    }
                }
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
        else if(manager_in.getText().compareTo("")==0)
            JOptionPane.showMessageDialog(null, "Please Input a value to the data field");
    }//GEN-LAST:event_manager_in_btActionPerformed

    private void manager_dec_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manager_dec_btActionPerformed
        if(manager_in.getText().compareTo("")!=0)
        {
            double sal=Double.parseDouble(manager_in.getText());
            try
            {
                String a="select Salary from charges where Type='Manager'";
                pst=conn.prepareStatement(a);
                rs=pst.executeQuery();
                if(rs.next())
                {
                    if(JOptionPane.showConfirmDialog(null, "Do you really need to increase the salary")==0)
                    {
                        double salary=Double.parseDouble(rs.getString("Salary"));
                        double newSal=salary-sal;
                        if(check_amount(salary,sal)==true)
                        {
                            String b="update charges set Salary='"+newSal+"' where Type='Manager'";
                            pst=conn.prepareStatement(b);
                            pst.execute();
                            manager_sal.setText(Double.toString(newSal));
                            manager_in.setText("");
                        }
                        else
                            JOptionPane.showMessageDialog(null, "Salary is not enough");
                    }
                }
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, e);
            }
        }
        else if(manager_in.getText().compareTo("")==0)
            JOptionPane.showMessageDialog(null, "Please Input a value to the data field");
    }//GEN-LAST:event_manager_dec_btActionPerformed

    private void sh_epfAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_sh_epfAncestorAdded
        try {
            String a="select default(EPF) from perm_emp_salary";
            pst=conn.prepareStatement(a);
            rs=pst.executeQuery();
            if(rs.next())
            {
                sh_epf.setText(rs.getString("default(EPF)"));
            }
        } catch(Exception e)
        {
            System.out.println(e);
        }
    }//GEN-LAST:event_sh_epfAncestorAdded

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        if(etf.getText().compareTo("")!=0)
        {
            double Etf=Double.parseDouble(etf.getText());
            try {
                String a="select default(ETF) from perm_emp_salary";
                pst=conn.prepareStatement(a);
                ResultSet rs=pst.executeQuery();
                if(rs.next())
                {
                    double w=Double.parseDouble(rs.getString("default(ETF)"));
                    double tot=w+Etf;
                    String b="alter table perm_emp_salary alter ETF set default "+tot+"";
                    pst=conn.prepareStatement(b);
                    pst.execute();
                    JOptionPane.showMessageDialog(null, "Record Added");
                    sh_etf.setText(Double.toString(tot));
                    etf.setText("");

                }
                else
                    JOptionPane.showMessageDialog(null, "Error");
            } catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, e);
            }
        }
        else
            JOptionPane.showMessageDialog(null, "Fill the ETF rate");
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        if(epf.getText().compareTo("")!=0)
        {
            double Epf=Double.parseDouble(epf.getText());
            try {
                String a="select default(EPF) from perm_emp_salary";
                pst=conn.prepareStatement(a);
                ResultSet rs=pst.executeQuery();
                if(rs.next())
                {
                    double w=Double.parseDouble(rs.getString("default(EPF)"));
                    double tot=w+Epf;
                    String b="alter table perm_emp_salary alter EPF set default "+tot+"";
                    pst=conn.prepareStatement(b);
                    pst.execute();
                    JOptionPane.showMessageDialog(null, "Record Added");
                    sh_epf.setText(Double.toString(tot));
                    epf.setText("");

                }
                else
                    JOptionPane.showMessageDialog(null, "Error");
            } catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, e);
            }
        }
        else
            JOptionPane.showMessageDialog(null, "Fill the EPF rate");
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        if(etf.getText().compareTo("")!=0)
        {
            double Etf=Double.parseDouble(etf.getText());
            try {
                String a="select default(ETF) from perm_emp_salary";
                pst=conn.prepareStatement(a);
                ResultSet rs=pst.executeQuery();
                if(rs.next())
                {
                    double w=Double.parseDouble(rs.getString("default(ETF)"));
                    if((w-Etf)>0)
                    {
                        double tot=w-Etf;
                        String b="alter table perm_emp_salary alter ETF set default "+tot+"";
                        pst=conn.prepareStatement(b);
                        pst.execute();
                        JOptionPane.showMessageDialog(null, "Record Added");
                        sh_etf.setText(Double.toString(tot));
                        etf.setText("");
                    }
                    else
                        JOptionPane.showMessageDialog(null, "Value is invalid");
                }
                else
                    JOptionPane.showMessageDialog(null, "Error");
            } catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, e);
            }
        }
        else
            JOptionPane.showMessageDialog(null, "Fill the ETF rate");
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        if(epf.getText().compareTo("")!=0)
        {
            double Epf=Double.parseDouble(epf.getText());
            try {
                String a="select default(EPF) from perm_emp_salary";
                pst=conn.prepareStatement(a);
                ResultSet rs=pst.executeQuery();
                if(rs.next())
                {
                    double w=Double.parseDouble(rs.getString("default(EPF)"));
                    double tot=w-Epf;
                    String b="alter table perm_emp_salary alter EPF set default "+tot+"";
                    pst=conn.prepareStatement(b);
                    pst.execute();
                    JOptionPane.showMessageDialog(null, "Record Added");
                    sh_epf.setText(Double.toString(tot));
                    epf.setText("");

                }
                else
                    JOptionPane.showMessageDialog(null, "Error");
            } catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, e);
            }
        }
        else
            JOptionPane.showMessageDialog(null, "Fill the EPF rate");
    }//GEN-LAST:event_jButton10ActionPerformed

    private void cashier_salAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_cashier_salAncestorAdded
        try {
            String a="select * from charges where Type='Cashier'";
            pst=conn.prepareStatement(a);
            rs=pst.executeQuery();
            if(rs.next())
            {
                double c=Double.parseDouble(rs.getString("Salary"));
                cashier_sal.setText(Double.toString(c));
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_cashier_salAncestorAdded

    private void cashier_in_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cashier_in_btActionPerformed
        if(cashier_in.getText().compareTo("")!=0)
        {
            double sal=Double.parseDouble(cashier_in.getText());
            try
            {
                String a="select Salary from charges where Type='Cashier'";
                pst=conn.prepareStatement(a);
                rs=pst.executeQuery();
                if(rs.next())
                {
                    if(JOptionPane.showConfirmDialog(null, "Do you really need to increase the salary")==0)
                    {
                        double salary=Double.parseDouble(rs.getString("Salary"));
                        double newSal=salary+sal;
                        String b="update charges set Salary='"+newSal+"' where Type='Cashier'";
                        pst=conn.prepareStatement(b);
                        pst.execute();
                        cashier_sal.setText(Double.toString(newSal));
                        cashier_in.setText("");
                    }
                }
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
        else if(accountant_in.getText().compareTo("")==0)
            JOptionPane.showMessageDialog(null, "Please Input a value to the data field");
    }//GEN-LAST:event_cashier_in_btActionPerformed

    private void cashier_dec_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cashier_dec_btActionPerformed
        if(cashier_in.getText().compareTo("")!=0)
        {
            double sal=Double.parseDouble(cashier_in.getText());
            try
            {
                String a="select Salary from charges where Type='Cashier'";
                pst=conn.prepareStatement(a);
                rs=pst.executeQuery();
                if(rs.next())
                {
                    if(JOptionPane.showConfirmDialog(null, "Do you really need to decrease the salary")==0)
                    {
                        double salary=Double.parseDouble(rs.getString("Salary"));
                        double newSal=salary-sal;
                        String b="update charges set Salary='"+newSal+"' where Type='Cashier'";
                        pst=conn.prepareStatement(b);
                        pst.execute();
                        cashier_sal.setText(Double.toString(newSal));
                        cashier_in.setText("");
                    }
                }
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
        else if(accountant_in.getText().compareTo("")==0)
            JOptionPane.showMessageDialog(null, "Please Input a value to the data field");
    }//GEN-LAST:event_cashier_dec_btActionPerformed

    private void manager_sal2AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_manager_sal2AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_manager_sal2AncestorAdded

    private void manager_in_bt2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manager_in_bt2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_manager_in_bt2ActionPerformed

    private void manager_dec_bt2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manager_dec_bt2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_manager_dec_bt2ActionPerformed

    private void photographer_salAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_photographer_salAncestorAdded
        try {
            String a="select * from charges where Type='Photographer'";
            pst=conn.prepareStatement(a);
            rs=pst.executeQuery();
            if(rs.next())
            {
                double c=Double.parseDouble(rs.getString("Salary"));
                photographer_sal.setText(Double.toString(c));
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_photographer_salAncestorAdded

    private void photographer_in_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_photographer_in_btActionPerformed
        if(photographer_in.getText().compareTo("")!=0)
        {
            double sal=Double.parseDouble(photographer_in.getText());
            try
            {
                String a="select Salary from charges where Type='Photographer'";
                pst=conn.prepareStatement(a);
                rs=pst.executeQuery();
                if(rs.next())
                {
                    if(JOptionPane.showConfirmDialog(null, "Do you really need to increase the salary")==0)
                    {
                        double salary=Double.parseDouble(rs.getString("Salary"));
                        double newSal=salary+sal;
                        String b="update charges set Salary='"+newSal+"' where Type='Photographer'";
                        pst=conn.prepareStatement(b);
                        pst.execute();
                        photographer_sal.setText(Double.toString(newSal));
                        photographer_in.setText("");
                    }
                }
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
        else if(photographer_in.getText().compareTo("")==0)
            JOptionPane.showMessageDialog(null, "Please Input a value to the data field");
    }//GEN-LAST:event_photographer_in_btActionPerformed

    private void photographer_dec_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_photographer_dec_btActionPerformed
        if(photographer_in.getText().compareTo("")!=0)
        {
            double sal=Double.parseDouble(photographer_in.getText());
            try
            {
                String a="select Salary from charges where Type='Photographer'";
                pst=conn.prepareStatement(a);
                rs=pst.executeQuery();
                if(rs.next())
                {
                    if(JOptionPane.showConfirmDialog(null, "Do you really need to decrease the salary")==0)
                    {
                        double salary=Double.parseDouble(rs.getString("Salary"));
                        double newSal=salary-sal;
                        String b="update charges set Salary='"+newSal+"' where Type='Photographer'";
                        pst=conn.prepareStatement(b);
                        pst.execute();
                        photographer_sal.setText(Double.toString(newSal));
                        photographer_in.setText("");
                    }
                }
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
        else if(photographer_in.getText().compareTo("")==0)
            JOptionPane.showMessageDialog(null, "Please Input a value to the data field");
    }//GEN-LAST:event_photographer_dec_btActionPerformed

    private void transport_salAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_transport_salAncestorAdded
        try {
            String a="select * from charges where Type='Transport Manager'";
            pst=conn.prepareStatement(a);
            rs=pst.executeQuery();
            if(rs.next())
            {
                double c=Double.parseDouble(rs.getString("Salary"));
                transport_sal.setText(Double.toString(c));
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_transport_salAncestorAdded

    private void transport_in_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transport_in_btActionPerformed
       if(transport_in.getText().compareTo("")!=0)
        {
            double sal=Double.parseDouble(transport_in.getText());
            try
            {
                String a="select Salary from charges where Type='Transport Manager'";
                pst=conn.prepareStatement(a);
                rs=pst.executeQuery();
                if(rs.next())
                {
                    if(JOptionPane.showConfirmDialog(null, "Do you really need to increase the salary")==0)
                    {
                        double salary=Double.parseDouble(rs.getString("Salary"));
                        double newSal=salary+sal;
                        String b="update charges set Salary='"+newSal+"' where Type='Transport Manager'";
                        pst=conn.prepareStatement(b);
                        pst.execute();
                        transport_sal.setText(Double.toString(newSal));
                        transport_in.setText("");
                    }
                }
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
        else if(transport_in.getText().compareTo("")==0)
            JOptionPane.showMessageDialog(null, "Please Input a value to the data field");
    }//GEN-LAST:event_transport_in_btActionPerformed

    private void transport_dec_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transport_dec_btActionPerformed
        if(transport_in.getText().compareTo("")!=0)
        {
            double sal=Double.parseDouble(transport_in.getText());
            try
            {
                String a="select Salary from charges where Type='Transport Manager'";
                pst=conn.prepareStatement(a);
                rs=pst.executeQuery();
                if(rs.next())
                {
                    if(JOptionPane.showConfirmDialog(null, "Do you really need to increase the salary")==0)
                    {
                        double salary=Double.parseDouble(rs.getString("Salary"));
                        double newSal=salary-sal;
                        String b="update charges set Salary='"+newSal+"' where Type='Transport Manager'";
                        pst=conn.prepareStatement(b);
                        pst.execute();
                        transport_sal.setText(Double.toString(newSal));
                        transport_in.setText("");
                    }
                }
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
        else if(transport_in.getText().compareTo("")==0)
            JOptionPane.showMessageDialog(null, "Please Input a value to the data field");
    }//GEN-LAST:event_transport_dec_btActionPerformed

    private void manager_sal5AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_manager_sal5AncestorAdded
        /*try {
            String a="select * from charges where Type='Transport Manager'";
            pst=conn.prepareStatement(a);
            rs=pst.executeQuery();
            if(rs.next())
            {
                double c=Double.parseDouble(rs.getString("Salary"));
                transport_sal.setText(Double.toString(c));
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }*/
    }//GEN-LAST:event_manager_sal5AncestorAdded

    private void waiter_sal1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_waiter_sal1AncestorAdded
        try {
            String a="select * from charges where Type='Waiter'";
            pst=conn.prepareStatement(a);
            rs=pst.executeQuery();
            if(rs.next())
            {
                double c=Double.parseDouble(rs.getString("TempSal"));
                waiter_sal1.setText(Double.toString(c));
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_waiter_sal1AncestorAdded

    private void waiter_in_bt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_waiter_in_bt1ActionPerformed
        if(waiter_in1.getText().compareTo("")!=0)
        {
            double sal=Double.parseDouble(waiter_in1.getText());
            try
            {
                String a="select TempSal from charges where Type='Waiter'";
                pst=conn.prepareStatement(a);
                rs=pst.executeQuery();
                if(rs.next())
                {
                    if(JOptionPane.showConfirmDialog(null, "Do you really need to increase the salary")==0)
                    {
                        double salary=Double.parseDouble(rs.getString("TempSal"));
                        double newSal=salary+sal;
                        String b="update charges set TempSal='"+newSal+"' where Type='Waiter'";
                        pst=conn.prepareStatement(b);
                        pst.execute();
                        waiter_sal1.setText(Double.toString(newSal));
                        waiter_in1.setText("");
                    }
                }
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
        else if(waiter_in1.getText().compareTo("")==0)
            JOptionPane.showMessageDialog(null, "Please Input a value to the data field");
    }//GEN-LAST:event_waiter_in_bt1ActionPerformed

    private void waiter_dec_bt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_waiter_dec_bt1ActionPerformed
        if(waiter_in1.getText().compareTo("")!=0)
        {
            double sal=Double.parseDouble(waiter_in1.getText());
            try
            {
                String a="select TempSal from charges where Type='Waiter'";
                pst=conn.prepareStatement(a);
                rs=pst.executeQuery();
                if(rs.next())
                {
                    if(JOptionPane.showConfirmDialog(null, "Do you really need to increase the salary")==0)
                    {
                    double salary=Double.parseDouble(rs.getString("TempSal"));
                    double newSal=salary-sal;
                    if(check_amount(salary,sal)==true)
                    {
                        String b="update charges set TempSal='"+newSal+"' where Type='Waiter'";
                        pst=conn.prepareStatement(b);
                        pst.execute();
                        waiter_sal1.setText(Double.toString(newSal));
                        waiter_in1.setText("");
                    }
                    else
                        JOptionPane.showMessageDialog(null, "Salary is not enough");
                    }
                }
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
        else if(waiter_in1.getText().compareTo("")==0)
            JOptionPane.showMessageDialog(null, "Please Input a value to the data field");
    }//GEN-LAST:event_waiter_dec_bt1ActionPerformed

    private void cook_sal1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_cook_sal1AncestorAdded
        try {
            String a="select * from charges where Type='Cook'";
            pst=conn.prepareStatement(a);
            rs=pst.executeQuery();
            if(rs.next())
            {
                double c=Double.parseDouble(rs.getString("TempSal"));
                cook_sal1.setText(Double.toString(c));
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_cook_sal1AncestorAdded

    private void cook_in_bt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cook_in_bt1ActionPerformed
        if(cook_in1.getText().compareTo("")!=0)
        {
            double sal=Double.parseDouble(cook_in1.getText());
            try
            {
                String a="select TempSal from charges where Type='Cook'";
                pst=conn.prepareStatement(a);
                rs=pst.executeQuery();
                if(rs.next())
                {
                    if(JOptionPane.showConfirmDialog(null, "Do you really need to increase the salary")==0)
                    {
                    double salary=Double.parseDouble(rs.getString("TempSal"));
                    double newSal=salary+sal;
                    String b="update charges set TempSal='"+newSal+"' where Type='Cook'";
                    pst=conn.prepareStatement(b);
                    pst.execute();
                    cook_sal1.setText(Double.toString(newSal));
                    cook_in1.setText("");
                    }
                }
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
        else if(cook_in1.getText().compareTo("")==0)
            JOptionPane.showMessageDialog(null, "Please Input a value to the data field");
    }//GEN-LAST:event_cook_in_bt1ActionPerformed

    private void cook_dec_bt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cook_dec_bt1ActionPerformed
        if(cook_in1.getText().compareTo("")!=0)
        {
            double sal=Double.parseDouble(cook_in1.getText());
            try
            {
                String a="select TempSal from charges where Type='Cook'";
                pst=conn.prepareStatement(a);
                rs=pst.executeQuery();
                if(rs.next())
                {
                    double salary=Double.parseDouble(rs.getString("TempSal"));
                    double newSal=salary-sal;
                    if(check_amount(salary,sal)==true)
                    {
                        String b="update charges set TempSal='"+newSal+"' where Type='Cook'";
                        pst=conn.prepareStatement(b);
                        pst.execute();
                        cook_sal1.setText(Double.toString(newSal));
                        cook_in1.setText("");
                    }
                    else
                        JOptionPane.showMessageDialog(null, "Salary is not enough");
                }
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
        else if(cook_in1.getText().compareTo("")==0)
            JOptionPane.showMessageDialog(null, "Please Input a value to the data field");
    }//GEN-LAST:event_cook_dec_bt1ActionPerformed

    private void cleaner_sal1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_cleaner_sal1AncestorAdded
        try {
            String a="select * from charges where Type='Cleaner'";
            pst=conn.prepareStatement(a);
            rs=pst.executeQuery();
            if(rs.next())
            {
                double c=Double.parseDouble(rs.getString("TempSal"));
                cleaner_sal1.setText(Double.toString(c));
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_cleaner_sal1AncestorAdded

    private void cleaner_in_bt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cleaner_in_bt1ActionPerformed
        if(cleaner_in1.getText().compareTo("")!=0)
        {
            double sal=Double.parseDouble(cleaner_in1.getText());
            try
            {
                String a="select TempSal from charges where Type='Cleaner'";
                pst=conn.prepareStatement(a);
                rs=pst.executeQuery();
                if(rs.next())
                {
                    if(JOptionPane.showConfirmDialog(null, "Do you really need to increase the salary")==0)
                    {
                        double salary=Double.parseDouble(rs.getString("TempSal"));
                        double newSal=salary+sal;
                        String b="update charges set TempSal='"+newSal+"' where Type='Cleaner'";
                        pst=conn.prepareStatement(b);
                        pst.execute();
                        cleaner_sal1.setText(Double.toString(newSal));
                        cleaner_in1.setText("");
                    }
                }
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
        else if(cleaner_in1.getText().compareTo("")==0)
            JOptionPane.showMessageDialog(null, "Please Input a value to the data field");
    }//GEN-LAST:event_cleaner_in_bt1ActionPerformed

    private void cleaner_dec_bt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cleaner_dec_bt1ActionPerformed
        if(cleaner_in1.getText().compareTo("")!=0)
        {
            double sal=Double.parseDouble(cleaner_in1.getText());
            try
            {
                String a="select TempSal from charges where Type='Cleaner'";
                pst=conn.prepareStatement(a);
                rs=pst.executeQuery();
                if(rs.next())
                {
                    if(JOptionPane.showConfirmDialog(null, "Do you really need to increase the salary")==0)
                    {
                    double salary=Double.parseDouble(rs.getString("TempSal"));
                    double newSal=salary-sal;
                    if(check_amount(salary,sal)==true)
                    {
                        String b="update charges set TempSal='"+newSal+"' where Type='Cleaner'";
                        pst=conn.prepareStatement(b);
                        pst.execute();
                        cleaner_sal1.setText(Double.toString(newSal));
                        cleaner_in1.setText("");
                    }
                    else
                        JOptionPane.showMessageDialog(null, "Salary is not enough");
                    }
                }
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
        else if(cleaner_in1.getText().compareTo("")==0)
            JOptionPane.showMessageDialog(null, "Please Input a value to the data field");
    }//GEN-LAST:event_cleaner_dec_bt1ActionPerformed

    private void driver_sal1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_driver_sal1AncestorAdded
        try {
            String a="select * from charges where Type='Driver'";
            pst=conn.prepareStatement(a);
            rs=pst.executeQuery();
            if(rs.next())
            {
                double c=Double.parseDouble(rs.getString("TempSal"));
                driver_sal1.setText(Double.toString(c));
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_driver_sal1AncestorAdded

    private void driver_in_bt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_driver_in_bt1ActionPerformed
        if(driver_in1.getText().compareTo("")!=0)
        {
            double sal=Double.parseDouble(driver_in1.getText());
            try
            {
                String a="select TempSal from charges where Type='Driver'";
                pst=conn.prepareStatement(a);
                rs=pst.executeQuery();
                if(rs.next())
                {
                    if(JOptionPane.showConfirmDialog(null, "Do you really need to increase the salary")==0)
                    {
                    double salary=Double.parseDouble(rs.getString("TempSal"));
                    double newSal=salary+sal;
                    String b="update charges set TempSal='"+newSal+"' where Type='Driver'";
                    pst=conn.prepareStatement(b);
                    pst.execute();
                    driver_sal1.setText(Double.toString(newSal));
                    driver_in1.setText("");
                    }
                }
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
        else if(driver_in1.getText().compareTo("")==0)
            JOptionPane.showMessageDialog(null, "Please Input a value to the data field");
    }//GEN-LAST:event_driver_in_bt1ActionPerformed

    private void driver_dec_bt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_driver_dec_bt1ActionPerformed
        if(driver_in1.getText().compareTo("")!=0)
        {
            double sal=Double.parseDouble(driver_in1.getText());
            try
            {
                String a="select TempSal from charges where Type='Driver'";
                pst=conn.prepareStatement(a);
                rs=pst.executeQuery();
                if(rs.next())
                {
                    if(JOptionPane.showConfirmDialog(null, "Do you really need to increase the salary")==0)
                    {
                    double salary=Double.parseDouble(rs.getString("TempSal"));
                    double newSal=salary-sal;
                    if(check_amount(salary,sal)==true)
                    {
                        String b="update charges set TempSal='"+newSal+"' where Type='Driver'";
                        pst=conn.prepareStatement(b);
                        pst.execute();
                        driver_sal1.setText(Double.toString(newSal));
                        driver_in1.setText("");
                    }
                    else
                        JOptionPane.showMessageDialog(null, "Salary is not enough");
                    }
                }
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
        else if(driver_in1.getText().compareTo("")==0)
            JOptionPane.showMessageDialog(null, "Please Input a value to the data field");
    }//GEN-LAST:event_driver_dec_bt1ActionPerformed

    private void photographer_sal1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_photographer_sal1AncestorAdded
        try {
            String a="select * from charges where Type='Photographer'";
            pst=conn.prepareStatement(a);
            rs=pst.executeQuery();
            if(rs.next())
            {
                double c=Double.parseDouble(rs.getString("TempSal"));
                photographer_sal1.setText(Double.toString(c));
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_photographer_sal1AncestorAdded

    private void photographer_in_bt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_photographer_in_bt1ActionPerformed
        if(photographer_in1.getText().compareTo("")!=0)
        {
            double sal=Double.parseDouble(photographer_in1.getText());
            try
            {
                String a="select TempSal from charges where Type='Photographer'";
                pst=conn.prepareStatement(a);
                rs=pst.executeQuery();
                if(rs.next())
                {
                    if(JOptionPane.showConfirmDialog(null, "Do you really need to increase the salary")==0)
                    {
                        double salary=Double.parseDouble(rs.getString("TempSal"));
                        double newSal=salary+sal;
                        String b="update charges set TempSal='"+newSal+"' where Type='Photographer'";
                        pst=conn.prepareStatement(b);
                        pst.execute();
                        photographer_sal1.setText(Double.toString(newSal));
                        photographer_in1.setText("");
                    }
                }
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
        else if(photographer_in1.getText().compareTo("")==0)
            JOptionPane.showMessageDialog(null, "Please Input a value to the data field");
    }//GEN-LAST:event_photographer_in_bt1ActionPerformed

    private void photographer_dec_bt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_photographer_dec_bt1ActionPerformed
        if(photographer_in1.getText().compareTo("")!=0)
        {
            double sal=Double.parseDouble(photographer_in1.getText());
            try
            {
                String a="select TempSal from charges where Type='Photographer'";
                pst=conn.prepareStatement(a);
                rs=pst.executeQuery();
                if(rs.next())
                {
                    if(JOptionPane.showConfirmDialog(null, "Do you really need to decrease the salary")==0)
                    {
                        double salary=Double.parseDouble(rs.getString("TempSal"));
                        double newSal=salary-sal;
                        String b="update charges set TempSal='"+newSal+"' where Type='Photographer'";
                        pst=conn.prepareStatement(b);
                        pst.execute();
                        photographer_sal1.setText(Double.toString(newSal));
                        photographer_in1.setText("");
                    }
                }
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
        else if(photographer_in1.getText().compareTo("")==0)
            JOptionPane.showMessageDialog(null, "Please Input a value to the data field");
    }//GEN-LAST:event_photographer_dec_bt1ActionPerformed

    private void sh_etfAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_sh_etfAncestorAdded
        try {
            String a="select default(ETF) from perm_emp_salary";
            pst=conn.prepareStatement(a);
            rs=pst.executeQuery();
            if(rs.next())
            {
                sh_etf.setText(rs.getString("default(ETF)"));
            }
        } catch(Exception e)
        {
            System.out.println(e);
        }
    }//GEN-LAST:event_sh_etfAncestorAdded

    private void photographer_sal2AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_photographer_sal2AncestorAdded
        try {
            String a="select * from charges where Type='Servant'";
            pst=conn.prepareStatement(a);
            rs=pst.executeQuery();
            if(rs.next())
            {
                double c=Double.parseDouble(rs.getString("TempSal"));
                photographer_sal2.setText(Double.toString(c));
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_photographer_sal2AncestorAdded

    private void photographer_in_bt2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_photographer_in_bt2ActionPerformed
        if(serv.getText().compareTo("")!=0)
        {
            double sal=Double.parseDouble(serv.getText());
            try
            {
                String a="select TempSal from charges where Type='Servant'";
                pst=conn.prepareStatement(a);
                rs=pst.executeQuery();
                if(rs.next())
                {
                    if(JOptionPane.showConfirmDialog(null, "Do you really need to increase the salary")==0)
                    {
                        double salary=Double.parseDouble(rs.getString("TempSal"));
                        double newSal=salary+sal;
                        String b="update charges set TempSal='"+newSal+"' where Type='Servant'";
                        pst=conn.prepareStatement(b);
                        pst.execute();
                        photographer_sal2.setText(Double.toString(newSal));
                        serv.setText("");
                    }
                }
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
        else if(serv.getText().compareTo("")==0)
            JOptionPane.showMessageDialog(null, "Please Input a value to the data field");
    }//GEN-LAST:event_photographer_in_bt2ActionPerformed

    private void photographer_dec_bt2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_photographer_dec_bt2ActionPerformed
        if(serv.getText().compareTo("")!=0)
        {
            double sal=Double.parseDouble(serv.getText());
            try
            {
                String a="select TempSal from charges where Type='Servant'";
                pst=conn.prepareStatement(a);
                rs=pst.executeQuery();
                if(rs.next())
                {
                    if(JOptionPane.showConfirmDialog(null, "Do you really need to decrease the salary")==0)
                    {
                        double salary=Double.parseDouble(rs.getString("TempSal"));
                        double newSal=salary-sal;
                        String b="update charges set TempSal='"+newSal+"' where Type='Servant'";
                        pst=conn.prepareStatement(b);
                        pst.execute();
                        photographer_sal2.setText(Double.toString(newSal));
                        serv.setText("");
                    }
                }
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
        else if(serv.getText().compareTo("")==0)
            JOptionPane.showMessageDialog(null, "Please Input a value to the data field");
    }//GEN-LAST:event_photographer_dec_bt2ActionPerformed

    private void transport_sal1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_transport_sal1AncestorAdded
        try {
            String a="select * from charges where Type='Servant'";
            pst=conn.prepareStatement(a);
            rs=pst.executeQuery();
            if(rs.next())
            {
                double c=Double.parseDouble(rs.getString("Salary"));
                transport_sal1.setText(Double.toString(c));
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_transport_sal1AncestorAdded

    private void transport_in_bt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transport_in_bt1ActionPerformed
        if(ser.getText().compareTo("")!=0)
        {
            double sal=Double.parseDouble(ser.getText());
            try
            {
                String a="select Salary from charges where Type='Servant'";
                pst=conn.prepareStatement(a);
                rs=pst.executeQuery();
                if(rs.next())
                {
                    if(JOptionPane.showConfirmDialog(null, "Do you really need to increase the salary")==0)
                    {
                        double salary=Double.parseDouble(rs.getString("Salary"));
                        double newSal=salary+sal;
                        String b="update charges set Salary='"+newSal+"' where Type='Servant'";
                        pst=conn.prepareStatement(b);
                        pst.execute();
                        transport_sal1.setText(Double.toString(newSal));
                        ser.setText("");
                    }
                }
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
        else if(ser.getText().compareTo("")==0)
            JOptionPane.showMessageDialog(null, "Please Input a value to the data field");
    }//GEN-LAST:event_transport_in_bt1ActionPerformed

    private void transport_dec_bt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transport_dec_bt1ActionPerformed
        if(ser.getText().compareTo("")!=0)
        {
            double sal=Double.parseDouble(ser.getText());
            try
            {
                String a="select Salary from charges where Type='Servant'";
                pst=conn.prepareStatement(a);
                rs=pst.executeQuery();
                if(rs.next())
                {
                    if(JOptionPane.showConfirmDialog(null, "Do you really need to increase the salary")==0)
                    {
                        double salary=Double.parseDouble(rs.getString("Salary"));
                        double newSal=salary-sal;
                        String b="update charges set Salary='"+newSal+"' where Type='Servant'";
                        pst=conn.prepareStatement(b);
                        pst.execute();
                        transport_sal1.setText(Double.toString(newSal));
                        ser.setText("");
                    }
                }
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
        else if(ser.getText().compareTo("")==0)
            JOptionPane.showMessageDialog(null, "Please Input a value to the data field");
    }//GEN-LAST:event_transport_dec_bt1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton accountant_dec_bt;
    private javax.swing.JTextField accountant_in;
    private javax.swing.JButton accountant_in_bt;
    private javax.swing.JLabel accountant_sal;
    private javax.swing.JButton cashier_dec_bt;
    private javax.swing.JTextField cashier_in;
    private javax.swing.JButton cashier_in_bt;
    private javax.swing.JLabel cashier_sal;
    private javax.swing.JButton cleaner_dec_bt;
    private javax.swing.JButton cleaner_dec_bt1;
    private javax.swing.JTextField cleaner_in;
    private javax.swing.JTextField cleaner_in1;
    private javax.swing.JButton cleaner_in_bt;
    private javax.swing.JButton cleaner_in_bt1;
    private javax.swing.JLabel cleaner_sal;
    private javax.swing.JLabel cleaner_sal1;
    private javax.swing.JButton clerk_dec_bt;
    private javax.swing.JTextField clerk_in;
    private javax.swing.JButton clerk_in_bt;
    private javax.swing.JLabel clerk_sal;
    private javax.swing.JButton cook_dec_bt;
    private javax.swing.JButton cook_dec_bt1;
    private javax.swing.JTextField cook_in;
    private javax.swing.JTextField cook_in1;
    private javax.swing.JButton cook_in_bt;
    private javax.swing.JButton cook_in_bt1;
    private javax.swing.JLabel cook_sal;
    private javax.swing.JLabel cook_sal1;
    private javax.swing.JButton driver_dec_bt;
    private javax.swing.JButton driver_dec_bt1;
    private javax.swing.JTextField driver_in;
    private javax.swing.JTextField driver_in1;
    private javax.swing.JButton driver_in_bt;
    private javax.swing.JButton driver_in_bt1;
    private javax.swing.JLabel driver_sal;
    private javax.swing.JLabel driver_sal1;
    private javax.swing.JTextField epf;
    private javax.swing.JTextField etf;
    private javax.swing.JButton hr_dec_bt;
    private javax.swing.JTextField hr_in;
    private javax.swing.JButton hr_in_bt;
    private javax.swing.JLabel hr_sal;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JButton manager_dec_bt;
    private javax.swing.JButton manager_dec_bt2;
    private javax.swing.JTextField manager_in;
    private javax.swing.JTextField manager_in2;
    private javax.swing.JButton manager_in_bt;
    private javax.swing.JButton manager_in_bt2;
    private javax.swing.JLabel manager_sal;
    private javax.swing.JLabel manager_sal2;
    private javax.swing.JLabel manager_sal5;
    private javax.swing.JButton photographer_dec_bt;
    private javax.swing.JButton photographer_dec_bt1;
    private javax.swing.JButton photographer_dec_bt2;
    private javax.swing.JTextField photographer_in;
    private javax.swing.JTextField photographer_in1;
    private javax.swing.JButton photographer_in_bt;
    private javax.swing.JButton photographer_in_bt1;
    private javax.swing.JButton photographer_in_bt2;
    private javax.swing.JLabel photographer_sal;
    private javax.swing.JLabel photographer_sal1;
    private javax.swing.JLabel photographer_sal2;
    private javax.swing.JButton rec_dec_bt;
    private javax.swing.JTextField rec_in;
    private javax.swing.JButton rec_in_bt;
    private javax.swing.JLabel recep_sal;
    private javax.swing.JTextField ser;
    private javax.swing.JTextField serv;
    private javax.swing.JLabel sh_epf;
    private javax.swing.JLabel sh_etf;
    private javax.swing.JButton stock_dec_bt;
    private javax.swing.JTextField stock_in;
    private javax.swing.JButton stock_in_bt;
    private javax.swing.JLabel stock_sal;
    private javax.swing.JButton transport_dec_bt;
    private javax.swing.JButton transport_dec_bt1;
    private javax.swing.JTextField transport_in;
    private javax.swing.JButton transport_in_bt;
    private javax.swing.JButton transport_in_bt1;
    private javax.swing.JLabel transport_sal;
    private javax.swing.JLabel transport_sal1;
    private javax.swing.JButton waiter_dec_bt;
    private javax.swing.JButton waiter_dec_bt1;
    private javax.swing.JTextField waiter_in;
    private javax.swing.JTextField waiter_in1;
    private javax.swing.JButton waiter_in_bt;
    private javax.swing.JButton waiter_in_bt1;
    private javax.swing.JLabel waiter_sal;
    private javax.swing.JLabel waiter_sal1;
    // End of variables declaration//GEN-END:variables
}
