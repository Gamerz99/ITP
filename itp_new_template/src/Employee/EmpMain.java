package Employee;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.Timer;

public class EmpMain extends javax.swing.JFrame {

    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    public EmpMain() {
        initComponents();
        jDesktopPane1.removeAll();
        Emp_Details ped1=new Emp_Details();
        jDesktopPane1.add(ped1).setVisible(true);
        //con = dbconnect.connect();
        today.setText(showDate());
        showTime();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        hallname = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        title = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        logo = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        ovel = new javax.swing.JLabel();
        user = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        time = new javax.swing.JLabel();
        today = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        home1 = new javax.swing.JPanel();
        home = new javax.swing.JLabel();
        logout = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        ViewAtt = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        empDetails = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        mainmenu = new javax.swing.JLabel();
        mainmenuicon = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        MarkAtt = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        PermEmp = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        TempEmp = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        AssEmp = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        GenRep = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        UpSal = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jPanel3 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1920, 1080));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel4.setBackground(new java.awt.Color(51, 51, 51));
        jPanel4.setLayout(null);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(null);

        hallname.setFont(new java.awt.Font("Trajan Pro", 0, 36)); // NOI18N
        hallname.setForeground(new java.awt.Color(255, 255, 255));
        hallname.setText("RAVINDRA RECEPTION HALL");
        jPanel1.add(hallname);
        hallname.setBounds(660, 40, 580, 50);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/cancel (3).png"))); // NOI18N
        jLabel8.setText("jLabel5");
        jLabel8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel8);
        jLabel8.setBounds(1890, 0, 30, 30);

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/minus.png"))); // NOI18N
        jLabel17.setText("jLabel5");
        jLabel17.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel17MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel17);
        jLabel17.setBounds(1860, 0, 30, 30);

        title.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        title.setForeground(new java.awt.Color(255, 255, 255));
        title.setText("Employee Management");
        jPanel1.add(title);
        title.setBounds(840, 110, 270, 30);
        jPanel1.add(jSeparator4);
        jSeparator4.setBounds(170, 22, 1580, 10);

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/logo.png"))); // NOI18N
        jPanel1.add(logo);
        logo.setBounds(20, 10, 200, 160);
        jPanel1.add(jSeparator3);
        jSeparator3.setBounds(230, 92, 1460, 10);

        ovel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Inventory/imgs/logoutback.png"))); // NOI18N
        ovel.setText(" ");
        jPanel1.add(ovel);
        ovel.setBounds(1800, 20, 100, 100);

        user.setForeground(new java.awt.Color(255, 255, 255));
        user.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/125.jpg"))); // NOI18N
        user.setText(" ");
        user.setOpaque(true);
        jPanel1.add(user);
        user.setBounds(1800, 20, 100, 100);

        name.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        name.setForeground(new java.awt.Color(255, 255, 255));
        name.setText("M.A.V.L.Gunathilaka");
        name.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(name);
        name.setBounds(1790, 130, 119, 20);

        time.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        time.setForeground(new java.awt.Color(255, 255, 255));
        time.setText("  ");
        jPanel1.add(time);
        time.setBounds(1480, 110, 210, 30);

        today.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        today.setForeground(new java.awt.Color(255, 255, 255));
        today.setText("  ");
        today.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jPanel1.add(today);
        today.setBounds(320, 110, 230, 30);

        jPanel4.add(jPanel1);
        jPanel1.setBounds(0, 0, 1920, 160);

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setLayout(null);

        home1.setBackground(new java.awt.Color(0, 0, 0));
        home1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        home1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                home1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                home1MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                home1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                home1MouseReleased(evt);
            }
        });
        home1.setLayout(null);

        home.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Inventory/imgs/home.png"))); // NOI18N
        home.setText(" ");
        home.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        home.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                homeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                homeMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                homeMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                homeMouseReleased(evt);
            }
        });
        home.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                homeAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        home1.add(home);
        home.setBounds(130, 0, 70, 60);

        jPanel2.add(home1);
        home1.setBounds(0, 225, 320, 70);

        logout.setBackground(new java.awt.Color(0, 0, 0));
        logout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                logoutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                logoutMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                logoutMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                logoutMouseReleased(evt);
            }
        });
        logout.setLayout(null);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Logout");
        logout.add(jLabel7);
        jLabel7.setBounds(120, 20, 80, 22);

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Inventory/imgs/logout.png"))); // NOI18N
        jLabel21.setText(" ");
        logout.add(jLabel21);
        jLabel21.setBounds(10, 0, 64, 64);

        jPanel2.add(logout);
        logout.setBounds(0, 985, 320, 70);

        ViewAtt.setBackground(new java.awt.Color(0, 0, 0));
        ViewAtt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ViewAtt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ViewAttMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ViewAttMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ViewAttMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ViewAttMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                ViewAttMouseReleased(evt);
            }
        });
        ViewAtt.setLayout(null);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("View Attendance");
        ViewAtt.add(jLabel5);
        jLabel5.setBounds(78, 23, 160, 22);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Inventory/imgs/equipment.png"))); // NOI18N
        jLabel6.setText(" ");
        ViewAtt.add(jLabel6);
        jLabel6.setBounds(10, 0, 64, 64);

        jPanel2.add(ViewAtt);
        ViewAtt.setBounds(0, 390, 320, 70);

        empDetails.setBackground(new java.awt.Color(0, 0, 0));
        empDetails.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        empDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                empDetailsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                empDetailsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                empDetailsMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                empDetailsMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                empDetailsMouseReleased(evt);
            }
        });
        empDetails.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                empDetailsAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        empDetails.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Employee Details");
        empDetails.add(jLabel1);
        jLabel1.setBounds(83, 23, 180, 22);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/businessman.png"))); // NOI18N
        jLabel2.setText(" ");
        empDetails.add(jLabel2);
        jLabel2.setBounds(10, 0, 64, 64);

        jPanel2.add(empDetails);
        empDetails.setBounds(0, 305, 320, 70);
        jPanel2.add(jSeparator1);
        jSeparator1.setBounds(0, 160, 320, 2);

        mainmenu.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        mainmenu.setForeground(new java.awt.Color(255, 255, 255));
        mainmenu.setText("MAIN MENU");
        jPanel2.add(mainmenu);
        mainmenu.setBounds(100, 170, 130, 30);

        mainmenuicon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Inventory/imgs/menu.png"))); // NOI18N
        mainmenuicon.setText(" ");
        jPanel2.add(mainmenuicon);
        mainmenuicon.setBounds(10, 170, 32, 32);
        jPanel2.add(jSeparator2);
        jSeparator2.setBounds(0, 210, 320, 2);

        MarkAtt.setBackground(new java.awt.Color(0, 0, 0));
        MarkAtt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        MarkAtt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MarkAttMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MarkAttMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MarkAttMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MarkAttMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                MarkAttMouseReleased(evt);
            }
        });
        MarkAtt.setLayout(null);

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Mark Attendance");
        MarkAtt.add(jLabel11);
        jLabel11.setBounds(80, 20, 163, 22);

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Inventory/imgs/rawmaterials.png"))); // NOI18N
        jLabel12.setText(" ");
        MarkAtt.add(jLabel12);
        jLabel12.setBounds(10, 0, 64, 64);

        jPanel2.add(MarkAtt);
        MarkAtt.setBounds(0, 475, 320, 70);

        PermEmp.setBackground(new java.awt.Color(0, 0, 0));
        PermEmp.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PermEmp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PermEmpMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PermEmpMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PermEmpMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                PermEmpMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                PermEmpMouseReleased(evt);
            }
        });
        PermEmp.setLayout(null);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Permanant Employee Salary");
        PermEmp.add(jLabel9);
        jLabel9.setBounds(80, 20, 230, 22);

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Inventory/imgs/equipment.png"))); // NOI18N
        jLabel10.setText(" ");
        PermEmp.add(jLabel10);
        jLabel10.setBounds(10, 0, 64, 64);

        jPanel2.add(PermEmp);
        PermEmp.setBounds(0, 560, 320, 70);

        TempEmp.setBackground(new java.awt.Color(0, 0, 0));
        TempEmp.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        TempEmp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TempEmpMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                TempEmpMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                TempEmpMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TempEmpMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                TempEmpMouseReleased(evt);
            }
        });
        TempEmp.setLayout(null);

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Temporary Employee Salary");
        TempEmp.add(jLabel13);
        jLabel13.setBounds(80, 20, 230, 22);

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Inventory/imgs/purchase.png"))); // NOI18N
        jLabel14.setText(" ");
        TempEmp.add(jLabel14);
        jLabel14.setBounds(10, 0, 64, 64);

        jPanel2.add(TempEmp);
        TempEmp.setBounds(0, 645, 320, 70);

        AssEmp.setBackground(new java.awt.Color(0, 0, 0));
        AssEmp.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        AssEmp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AssEmpMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                AssEmpMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                AssEmpMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                AssEmpMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                AssEmpMouseReleased(evt);
            }
        });
        AssEmp.setLayout(null);

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Assign Temporary Employees");
        AssEmp.add(jLabel15);
        jLabel15.setBounds(80, 20, 240, 22);

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Inventory/imgs/supplier.png"))); // NOI18N
        jLabel22.setText(" ");
        AssEmp.add(jLabel22);
        jLabel22.setBounds(10, 0, 64, 64);

        jPanel2.add(AssEmp);
        AssEmp.setBounds(0, 815, 320, 70);

        GenRep.setBackground(new java.awt.Color(0, 0, 0));
        GenRep.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        GenRep.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                GenRepMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                GenRepMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                GenRepMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                GenRepMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                GenRepMouseReleased(evt);
            }
        });
        GenRep.setLayout(null);

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Generate Reports");
        GenRep.add(jLabel16);
        jLabel16.setBounds(80, 20, 163, 22);

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Inventory/imgs/supplier.png"))); // NOI18N
        jLabel23.setText(" ");
        GenRep.add(jLabel23);
        jLabel23.setBounds(10, 0, 64, 64);

        jPanel2.add(GenRep);
        GenRep.setBounds(0, 900, 320, 70);

        UpSal.setBackground(new java.awt.Color(0, 0, 0));
        UpSal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        UpSal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UpSalMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                UpSalMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                UpSalMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                UpSalMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                UpSalMouseReleased(evt);
            }
        });
        UpSal.setLayout(null);

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Update Salary");
        UpSal.add(jLabel18);
        jLabel18.setBounds(80, 20, 163, 22);

        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Inventory/imgs/supplier.png"))); // NOI18N
        jLabel25.setText(" ");
        UpSal.add(jLabel25);
        jLabel25.setBounds(10, 0, 64, 64);

        jPanel2.add(UpSal);
        UpSal.setBounds(0, 730, 320, 70);

        jPanel4.add(jPanel2);
        jPanel2.setBounds(0, 0, 320, 1080);

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1600, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 920, Short.MAX_VALUE)
        );

        jDesktopPane1.setLayer(jPanel3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel4.add(jDesktopPane1);
        jDesktopPane1.setBounds(320, 160, 1600, 920);

        getContentPane().add(jPanel4);
        jPanel4.setBounds(0, 0, 1920, 1080);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void empDetailsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_empDetailsMouseEntered
        empDetails.setBackground(Color.BLUE);
    }//GEN-LAST:event_empDetailsMouseEntered

    private void empDetailsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_empDetailsMouseExited
        empDetails.setBackground(Color.BLACK);
    }//GEN-LAST:event_empDetailsMouseExited

    private void empDetailsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_empDetailsMousePressed
        empDetails.setBackground(new Color(10, 122, 192));
    }//GEN-LAST:event_empDetailsMousePressed

    private void empDetailsMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_empDetailsMouseReleased
        empDetails.setForeground(Color.BLACK);
    }//GEN-LAST:event_empDetailsMouseReleased

    private void ViewAttMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ViewAttMouseEntered
        ViewAtt.setBackground(Color.BLUE);
    }//GEN-LAST:event_ViewAttMouseEntered

    private void ViewAttMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ViewAttMouseExited
        ViewAtt.setBackground(Color.BLACK);
    }//GEN-LAST:event_ViewAttMouseExited

    private void ViewAttMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ViewAttMousePressed
        ViewAtt.setBackground(new Color(10, 122, 192));
    }//GEN-LAST:event_ViewAttMousePressed

    private void ViewAttMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ViewAttMouseReleased
        ViewAtt.setForeground(Color.BLACK);
    }//GEN-LAST:event_ViewAttMouseReleased

    private void MarkAttMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MarkAttMouseEntered
        MarkAtt.setBackground(Color.BLUE);
    }//GEN-LAST:event_MarkAttMouseEntered

    private void MarkAttMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MarkAttMouseExited
        MarkAtt.setBackground(Color.BLACK);
    }//GEN-LAST:event_MarkAttMouseExited

    private void MarkAttMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MarkAttMousePressed
        MarkAtt.setBackground(new Color(10, 122, 192));
    }//GEN-LAST:event_MarkAttMousePressed

    private void MarkAttMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MarkAttMouseReleased
        MarkAtt.setForeground(Color.BLACK);
    }//GEN-LAST:event_MarkAttMouseReleased

    private void home1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_home1MouseEntered
//        home1.setBackground(Color.BLUE);
    }//GEN-LAST:event_home1MouseEntered

    private void home1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_home1MouseExited
        //      home1.setBackground(Color.BLACK);
    }//GEN-LAST:event_home1MouseExited

    private void home1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_home1MousePressed
        //      home1.setBackground(new Color(10,122,192));
    }//GEN-LAST:event_home1MousePressed

    private void home1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_home1MouseReleased
        //      home1.setForeground(Color.BLACK);
    }//GEN-LAST:event_home1MouseReleased

    private void logoutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutMouseEntered
        logout.setBackground(Color.RED);
    }//GEN-LAST:event_logoutMouseEntered

    private void logoutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutMouseExited
        logout.setBackground(Color.BLACK);
    }//GEN-LAST:event_logoutMouseExited

    private void logoutMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutMousePressed
        logout.setBackground(new Color(10, 122, 192));
    }//GEN-LAST:event_logoutMousePressed

    private void logoutMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutMouseReleased
        logout.setForeground(Color.BLACK);
    }//GEN-LAST:event_logoutMouseReleased

    private void AssEmpMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AssEmpMouseEntered
        AssEmp.setBackground(Color.BLUE);
    }//GEN-LAST:event_AssEmpMouseEntered

    private void AssEmpMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AssEmpMouseExited
        AssEmp.setBackground(Color.BLACK);
    }//GEN-LAST:event_AssEmpMouseExited

    private void AssEmpMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AssEmpMousePressed
        AssEmp.setBackground(new Color(10, 122, 192));
    }//GEN-LAST:event_AssEmpMousePressed

    private void AssEmpMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AssEmpMouseReleased
        AssEmp.setForeground(Color.BLACK);
    }//GEN-LAST:event_AssEmpMouseReleased

    private void PermEmpMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PermEmpMouseEntered
        PermEmp.setBackground(Color.BLUE);
    }//GEN-LAST:event_PermEmpMouseEntered

    private void PermEmpMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PermEmpMouseExited
        PermEmp.setBackground(Color.BLACK);
    }//GEN-LAST:event_PermEmpMouseExited

    private void PermEmpMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PermEmpMousePressed
        PermEmp.setBackground(new Color(10, 122, 192));
    }//GEN-LAST:event_PermEmpMousePressed

    private void PermEmpMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PermEmpMouseReleased
        PermEmp.setForeground(Color.BLACK);
    }//GEN-LAST:event_PermEmpMouseReleased

    private void TempEmpMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TempEmpMouseEntered
        TempEmp.setBackground(Color.BLUE);
    }//GEN-LAST:event_TempEmpMouseEntered

    private void TempEmpMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TempEmpMouseExited
        TempEmp.setBackground(Color.BLACK);
    }//GEN-LAST:event_TempEmpMouseExited

    private void TempEmpMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TempEmpMousePressed
        TempEmp.setBackground(new Color(10, 122, 192));
    }//GEN-LAST:event_TempEmpMousePressed

    private void TempEmpMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TempEmpMouseReleased
        TempEmp.setForeground(Color.BLACK);
    }//GEN-LAST:event_TempEmpMouseReleased

    private void homeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeMouseEntered
        ImageIcon III = new ImageIcon(getClass().getResource("/pics/homehover.png"));
        home.setIcon(III);
    }//GEN-LAST:event_homeMouseEntered

    private void homeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeMouseExited
        ImageIcon III = new ImageIcon(getClass().getResource("/pics/home.png"));
        home.setIcon(III);
    }//GEN-LAST:event_homeMouseExited

    private void homeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeMousePressed
        ImageIcon III = new ImageIcon(getClass().getResource("/pics/homehover.png"));
        home.setIcon(III);
    }//GEN-LAST:event_homeMousePressed

    private void homeMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeMouseReleased
        ImageIcon III = new ImageIcon(getClass().getResource("/pics/home.png"));
        home.setIcon(III);
    }//GEN-LAST:event_homeMouseReleased

    private void GenRepMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GenRepMouseEntered
        GenRep.setBackground(Color.BLUE);
    }//GEN-LAST:event_GenRepMouseEntered

    private void GenRepMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GenRepMouseExited
        GenRep.setBackground(Color.BLACK);
    }//GEN-LAST:event_GenRepMouseExited

    private void GenRepMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GenRepMousePressed
        GenRep.setBackground(new Color(10, 122, 192));
    }//GEN-LAST:event_GenRepMousePressed

    private void GenRepMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GenRepMouseReleased
        GenRep.setForeground(Color.BLACK);
    }//GEN-LAST:event_GenRepMouseReleased

    private void empDetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_empDetailsMouseClicked
        jDesktopPane1.removeAll();
        Emp_Details ped1=new Emp_Details();
        jDesktopPane1.add(ped1).setVisible(true);
    }//GEN-LAST:event_empDetailsMouseClicked

    private void ViewAttMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ViewAttMouseClicked
        jDesktopPane1.removeAll();
        ViewAttendance va1=new ViewAttendance();
        jDesktopPane1.add(va1).setVisible(true);
    }//GEN-LAST:event_ViewAttMouseClicked

    private void MarkAttMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MarkAttMouseClicked
        jDesktopPane1.removeAll();
        MarkAttendance ma1=new MarkAttendance();
        jDesktopPane1.add(ma1).setVisible(true);
    }//GEN-LAST:event_MarkAttMouseClicked

    private void PermEmpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PermEmpMouseClicked
        jDesktopPane1.removeAll();
        Perm_emp_sal pes1=new Perm_emp_sal();
        jDesktopPane1.add(pes1).setVisible(true);
    }//GEN-LAST:event_PermEmpMouseClicked

    private void TempEmpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TempEmpMouseClicked
        jDesktopPane1.removeAll();
        Temp_emp_sal tes1=new Temp_emp_sal();
        jDesktopPane1.add(tes1).setVisible(true);
    }//GEN-LAST:event_TempEmpMouseClicked

    private void GenRepMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GenRepMouseClicked
        jDesktopPane1.removeAll();
        Gen_Reports us1=new Gen_Reports();
        jDesktopPane1.add(us1).setVisible(true);
    }//GEN-LAST:event_GenRepMouseClicked

    private void AssEmpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AssEmpMouseClicked
        jDesktopPane1.removeAll();
        AssignEmp am1=new AssignEmp();
        jDesktopPane1.add(am1).setVisible(true);
    }//GEN-LAST:event_AssEmpMouseClicked

    private void homeAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_homeAncestorAdded
        
    }//GEN-LAST:event_homeAncestorAdded

    private void empDetailsAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_empDetailsAncestorAdded
        
    }//GEN-LAST:event_empDetailsAncestorAdded

    private void UpSalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UpSalMouseClicked
        jDesktopPane1.removeAll();
        Update_salary us1=new Update_salary();
        jDesktopPane1.add(us1).setVisible(true);
    }//GEN-LAST:event_UpSalMouseClicked

    private void UpSalMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UpSalMouseEntered
        UpSal.setBackground(Color.BLUE);
    }//GEN-LAST:event_UpSalMouseEntered

    private void UpSalMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UpSalMouseExited
        UpSal.setBackground(Color.BLACK);
    }//GEN-LAST:event_UpSalMouseExited

    private void UpSalMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UpSalMousePressed
        UpSal.setBackground(new Color(10, 122, 192));
    }//GEN-LAST:event_UpSalMousePressed

    private void UpSalMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UpSalMouseReleased
        UpSal.setForeground(Color.BLACK);
    }//GEN-LAST:event_UpSalMouseReleased

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel8MouseClicked

    private void jLabel17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseClicked
        this.setState(this.ICONIFIED);
    }//GEN-LAST:event_jLabel17MouseClicked

    private void logoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutMouseClicked
        Main.Main m = new Main.Main();
        m.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_logoutMouseClicked

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
            java.util.logging.Logger.getLogger(EmpMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmpMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmpMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmpMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmpMain().setVisible(true);
                /*try {
                    UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(EmpMain.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                    Logger.getLogger(EmpMain.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(EmpMain.class.getName()).log(Level.SEVERE, null, ex);
                } catch (UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(EmpMain.class.getName()).log(Level.SEVERE, null, ex);
                }*/
            }
        });
    }

    String showDate() {
        java.util.Date d = new java.util.Date();
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
        return (s.format(d));
    }

    void showTime() {
        try {
            new Timer(0, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Date d = new Date();
                    SimpleDateFormat s = new SimpleDateFormat("hh:mm:ss a");
                    time.setText(s.format(d));
                }
            }
            ).start();
        } catch (Exception e) {
            System.out.print(e);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AssEmp;
    private javax.swing.JPanel GenRep;
    private javax.swing.JPanel MarkAtt;
    private javax.swing.JPanel PermEmp;
    private javax.swing.JPanel TempEmp;
    private javax.swing.JPanel UpSal;
    private javax.swing.JPanel ViewAtt;
    private javax.swing.JPanel empDetails;
    private javax.swing.JLabel hallname;
    private javax.swing.JLabel home;
    private javax.swing.JPanel home1;
    private javax.swing.JDesktopPane jDesktopPane1;
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel logo;
    private javax.swing.JPanel logout;
    private javax.swing.JLabel mainmenu;
    private javax.swing.JLabel mainmenuicon;
    private javax.swing.JLabel name;
    private javax.swing.JLabel ovel;
    private javax.swing.JLabel time;
    private javax.swing.JLabel title;
    private javax.swing.JLabel today;
    private javax.swing.JLabel user;
    // End of variables declaration//GEN-END:variables
}
