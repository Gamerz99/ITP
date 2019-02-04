package Employee;
import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import dbconnect.dbconnect;
import java.awt.event.KeyEvent;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import net.proteanit.sql.DbUtils;

public class Emp_Details extends javax.swing.JInternalFrame {
    //int row=0;
    FileInputStream fis=null;
    Connection conn=null;
    PreparedStatement pst=null;
    ResultSet rs=null;
    ImageIcon format=null;
    methods mm=new methods();//Calling the methods class
    public Emp_Details() {
        initComponents();
        conn=dbconnect.connect();
        show_table();
        psswrd.setVisible(false);
        jLabel18.setVisible(false);
        newpass.setVisible(false);
        conpass.setVisible(false);
        jLabel19.setVisible(false);
        chbttn.setVisible(false);
        cnbttn.setVisible(false);
    }
    private void clr()
    {
        eid.setText("");
        fname.setText("");
        surname.setText("");
        Baccount.setText("");
        address.setText("");
        nic.setText("");
        contact.setText("");
        type.setSelectedIndex(0);
        dep.setSelectedIndex(0);
        position.setSelectedIndex(0);
        dob.setDate(null);
        psswrd.setText("");
        grp.clearSelection();
        sala.setVisible(true);
        sala.setText("");   
        
        brcode.setText("");
        epf.setText("");
        etf.setText("");
        frame.setIcon(null);
        
    }
//    private void show_job(String job1)
//    {
//        try {
//                String a="select Type from charges where Department='"+job1+"'";
//                pst=conn.prepareStatement(a);
//                ResultSet rs1=pst.executeQuery();
//                while(rs1.next())
//                {
//                    position.addItem(rs1.getString("Type"));
//                }
//            } catch (SQLException ex) {
//                System.out.println(ex+"show_job");
//            }
//        
//        
//    }
    private boolean psswrd(String psw,String ppid)
    {
        String pass=null;
        try{
            String a="select * from empdet where EID='"+ppid+"'";
            pst=conn.prepareStatement(a);
            rs=pst.executeQuery();
            if(rs.next())
            {
                pass=rs.getString("Password");
                
            }
        } catch(Exception e)
        {
            System.out.println(e);
        }
        if(pass==null||psw==null)
        {
            return false;
        }
        else if(pass.compareTo(psw)!=0)
            return false;
        return true;
            
    }
    private void show_table()
    {
        try
        {
            String ta="select EID,FName,Surname,Department,Position,Salary from empdet";
            pst=conn.prepareStatement(ta);
            rs=pst.executeQuery();
            etable.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    private boolean check_date(String Dob)
    {
        
        if(Dob.compareTo(mm.dates)>=0)
            return false;
        else
            return true;
    }
    private boolean check_bank(String ba)
    {
        if(ba.compareTo("")!=0)
        {
            int x=ba.length();
            for(int i=0;i<x;i++)
            {
                char q=ba.charAt(i);
                if((x!=15)&&(Character.isLetter(q)))
                    return false;
            }
            return true;
        }
        else
            return false;
    }
    private boolean number(String no)
    {
        if(no.length()!=10)
            return false;
        else
        {
            if(!no.startsWith("0"))
            {
                return false;
            }
            else
            {
                for(int i=0;i<no.length();i++)
                {
                    char q=no.charAt(i);
                    if(Character.isLetter(q))
                        return false;
                }
            }
        }
        return true;            
    }
    
    private boolean check_password()
    {
        String pas=psswrd.getText();
        int i=pas.length();
        if((i<=6)&&(i>10))
            return false;
        else
        {
            for(int j=0;j<i;j++)
            {
                if(Character.isDigit(pas.charAt(j)))
                    return true;
                
            }
        }
        return false;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grp = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        etable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        eid = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        fname = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        surname = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        nic = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        Baccount = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        dob = new com.toedter.calendar.JDateChooser();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        contact = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        dep = new javax.swing.JComboBox();
        position = new javax.swing.JComboBox();
        male = new javax.swing.JRadioButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        address = new javax.swing.JTextArea();
        delete = new javax.swing.JButton();
        insert = new javax.swing.JButton();
        update = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        search = new javax.swing.JTextField();
        srch_surname = new javax.swing.JTextField();
        bttn_search = new javax.swing.JButton();
        srch_dep = new javax.swing.JComboBox();
        srch_job = new javax.swing.JComboBox();
        clear = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        type = new javax.swing.JComboBox();
        female = new javax.swing.JRadioButton();
        jLabel14 = new javax.swing.JLabel();
        psswrd = new javax.swing.JPasswordField();
        jLabel15 = new javax.swing.JLabel();
        sala = new javax.swing.JLabel();
        clear1 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        frame = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        chbttn = new javax.swing.JButton();
        conpass = new javax.swing.JPasswordField();
        newpass = new javax.swing.JPasswordField();
        jLabel20 = new javax.swing.JLabel();
        epf = new javax.swing.JTextField();
        cnbttn = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        brcode = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        etf = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1595, 893));
        setMinimumSize(new java.awt.Dimension(1595, 893));
        setPreferredSize(new java.awt.Dimension(1595, 893));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setPreferredSize(new java.awt.Dimension(1140, 545));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        etable.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        etable.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        etable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"", null, null, null, null, null, null, null, null},
                {"", null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "EID", "Fname", "Surname", "Depaertment", "NIC", "Gender", "Contact No", "Job Title", "Salary"
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
        jScrollPane1.setViewportView(etable);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 520, 1010, 320));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Employee ID");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, 110, 30));

        eid.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel1.add(eid, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 120, 190, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Fname");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 170, 110, 30));

        fname.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel1.add(fname, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 170, 190, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Surname");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 220, 110, 30));

        surname.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel1.add(surname, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 220, 190, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("NIC");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 270, 110, 30));

        nic.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel1.add(nic, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 270, 190, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Bank Account");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 520, 110, 30));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Position");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 470, 110, 30));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("Department");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 420, 110, 30));

        Baccount.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel1.add(Baccount, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 520, 190, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Date Of birth");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 370, 110, 30));

        dob.setDateFormatString("YYYY-MM-dd");
        dob.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jPanel1.add(dob, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 370, 190, 30));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setText("Gender");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 160, 102, 27));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setText("Address");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 200, 102, 27));

        contact.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel1.add(contact, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 120, 190, 30));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setText("Contact No");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 120, 102, 27));

        dep.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        dep.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "     Select", "Event Management", "Customer Management", "Employee Management", "Financial Management", "Inventory Management", "Transport Management", "Restaurant Management", "Maintenance" }));
        dep.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        dep.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                depMouseClicked(evt);
            }
        });
        dep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                depActionPerformed(evt);
            }
        });
        jPanel1.add(dep, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 420, 190, 30));

        position.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        position.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select", "Accountant", "Cashier", "Cleaner", "Clerk", "Cook", "Driver", "HR Manager", "Manager", "Photographer", "Receptionist", "Servant", "Stock Keeper", "Transport Manager", "Waiter", " " }));
        position.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        position.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                positionActionPerformed(evt);
            }
        });
        jPanel1.add(position, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 470, 190, 30));

        grp.add(male);
        male.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        male.setText("Male");
        male.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(male, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 160, 90, 28));

        address.setColumns(10);
        address.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        address.setRows(3);
        jScrollPane2.setViewportView(address);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 200, 242, 70));

        delete.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        delete.setText("Delete");
        delete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });
        jPanel1.add(delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 270, 180, 60));

        insert.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        insert.setText("Insert");
        insert.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        insert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertActionPerformed(evt);
            }
        });
        jPanel1.add(insert, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 110, 180, 60));

        update.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        update.setText("Update");
        update.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });
        jPanel1.add(update, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 190, 180, 60));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel9.setText("Search");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 460, 50, 30));

        search.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        search.setToolTipText("");
        jPanel1.add(search, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 460, 140, 30));

        srch_surname.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jPanel1.add(srch_surname, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 460, 130, 29));

        bttn_search.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        bttn_search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/if_icon-ios7-search-strong_211817 (1).png"))); // NOI18N
        bttn_search.setText("Search");
        bttn_search.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bttn_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttn_searchActionPerformed(evt);
            }
        });
        jPanel1.add(bttn_search, new org.netbeans.lib.awtextra.AbsoluteConstraints(1270, 459, 120, 30));

        srch_dep.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        srch_dep.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Department", "Event Management", "Customer Management", "Employee Management", "Financial Department", "Inventory Management", "Transport Management", "Restaurant Department", "Maintenance department" }));
        srch_dep.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        srch_dep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                srch_depActionPerformed(evt);
            }
        });
        jPanel1.add(srch_dep, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 460, 170, 29));

        srch_job.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        srch_job.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Job", "Cashier", "Cleaner", "Clerk", "Cook", "Driver", "Photographer", "Receptionist", "Waiter/Waitress", "Accountant", "HR Manager", "Maintenance Supervisor", "Stock Manager", "Transport Manager", "Manager" }));
        srch_job.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        srch_job.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                srch_jobActionPerformed(evt);
            }
        });
        jPanel1.add(srch_job, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 460, 170, 29));

        clear.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        clear.setText("Clear");
        clear.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });
        jPanel1.add(clear, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 350, 180, 60));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel13.setText("Type");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 320, 110, 30));

        type.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        type.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "     Select", "Permanant ", "Temporary", "Admin" }));
        type.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        type.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                typeActionPerformed(evt);
            }
        });
        jPanel1.add(type, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 320, 190, 30));

        grp.add(female);
        female.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        female.setText("Female");
        female.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(female, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 160, 90, 27));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel14.setText("Password");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 570, 110, 30));

        psswrd.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        psswrd.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                psswrdAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jPanel1.add(psswrd, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 570, 190, 30));

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel15.setText("Salary (Rs.)");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 280, 102, 27));

        sala.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel1.add(sala, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 280, 190, 30));

        clear1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        clear1.setText("Clear");
        clear1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        clear1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clear1ActionPerformed(evt);
            }
        });
        jPanel1.add(clear1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1400, 459, 90, 30));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 34)); // NOI18N
        jLabel16.setText("Employee Details");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 0, 310, 39));

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel17.setText("Surname");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 460, 70, 29));

        frame.setBackground(new java.awt.Color(204, 204, 255));
        frame.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/16_2.png"))); // NOI18N
        frame.setMaximumSize(new java.awt.Dimension(107, 100));
        frame.setMinimumSize(new java.awt.Dimension(107, 100));
        frame.setPreferredSize(new java.awt.Dimension(107, 100));
        jPanel1.add(frame, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 170, 100, 100));

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setText("choose a photo");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 110, 160, 40));

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton2.setText("Change password");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 620, 200, 40));

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel18.setText("New Password");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 690, 110, 30));

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel19.setText("Confirm");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 740, 110, 30));

        chbttn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        chbttn.setText("Change");
        chbttn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chbttnActionPerformed(evt);
            }
        });
        jPanel1.add(chbttn, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 790, 120, 50));
        jPanel1.add(conpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 740, 190, 30));
        jPanel1.add(newpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 690, 190, 30));

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel20.setText("Barcode Number");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 320, 120, 27));

        epf.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel1.add(epf, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 360, 190, 30));

        cnbttn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cnbttn.setText("Cancel");
        cnbttn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cnbttnActionPerformed(evt);
            }
        });
        jPanel1.add(cnbttn, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 790, 110, 50));

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel22.setText("EPF Number");
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 360, 102, 27));

        brcode.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        brcode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brcodeActionPerformed(evt);
            }
        });
        jPanel1.add(brcode, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 320, 190, 30));

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel23.setText("ETF Number");
        jPanel1.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 400, 102, 27));

        etf.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel1.add(etf, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 400, 190, 30));

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/body.jpg"))); // NOI18N
        jLabel21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel21MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1580, 890));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1587, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 890, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setBounds(0, 0, 1595, 920);
    }// </editor-fold>//GEN-END:initComponents

    private void insertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertActionPerformed
        String Fname=fname.getText();
        String Surname=surname.getText();
        String bank=Baccount.getText();
        String addrss=address.getText();
        String Nic=nic.getText();
        String Phone=contact.getText();
        String Type=(String) type.getSelectedItem();
        String Dep=(String) dep.getSelectedItem();
        String Pos=(String) position.getSelectedItem();
        String Epf=epf.getText();
        String Etf=etf.getText();
        String Password=null;
        char gender=0;
        double salary = 0;
        String bar=brcode.getText();
        if(female.isSelected())
            gender='f';
        else if(male.isSelected())
            gender='m';
        if(type.getSelectedIndex()==3)
            Password=psswrd.getText();
        if((Fname.compareTo("")!=0)&&(Surname.compareTo("")!=0)&&(addrss.compareTo("")!=0)&&(Nic.compareTo("")!=0)&&(Phone.compareTo("")!=0)&&(type.getSelectedIndex()!=0)&&(dep.getSelectedIndex()!=0)&&(position.getSelectedIndex()!=0)&&(dob.getDate()!=null))
        {
            String dates=mm.day.format(dob.getDate());
            if((Type.compareTo("Admin")==0)&&(check_password()==false))
            {
                JOptionPane.showMessageDialog(null, "Password is not valid. A password must contain 7 to 10 characters with at least 1 digit");
            }
            else
            {
                if(mm.check_names(Fname,Surname)==true)
                {
                        if(mm.check_nic(Nic)==true)
                        {
                            if(check_date(dates)==true)
                            {
                                if(number(Phone)==true)
                                {
                                    try
                                    {
                                        String ab="select Salary from charges where Type='"+Pos+"'";
                                        pst=conn.prepareStatement(ab);
                                        rs=pst.executeQuery();
                                        if(rs.next())
                                        {
                                            salary=Double.parseDouble(rs.getString("Salary"));
                                            int p=JOptionPane.showConfirmDialog(null, "Do you really need to add this record?");
                                            if(p==0)
                                            {
                                                if(type.getSelectedIndex()==1)
                                                {
                                                    if((check_bank(bank)==true)&&(Baccount.getText().compareTo("")!=0))
                                                    {
                                                        String a="INSERT INTO empdet(FName,Surname,BankAccount,Address,NIC,Department,Position,Gender,ContactNo,Salary,type,DOB,Photo,SerialNo,EPF,ETF) VALUES ('"+Fname+"','"+Surname+"','"+bank+"','"+addrss+"','"+Nic+"','"+Dep+"','"+Pos+"','"+gender+"','"+Phone+"','"+salary+"','"+Type+"','"+dates+"','"+format+"','"+bar+"','"+Epf+"','"+Etf+"')";
                                                        pst=conn.prepareStatement(a);
                                                        pst.execute();
                                                        String aa="select default(EPF),default(ETF) from perm_emp_salary";
                                                        pst=conn.prepareStatement(aa);
                                                        rs=pst.executeQuery();
                                                        double s1=0,s2=0,fin=0,ep1=0,et1=0;
                                                        if(rs.next())
                                                        {
                                                            s1=Double.parseDouble(rs.getString("default(EPF)"));
                                                            s2=Double.parseDouble(rs.getString("default(ETF)"));
                                                            ep1=salary*(s1/100);
                                                            et1=salary*(s2/100);
                                                            fin=salary-(ep1+et1);
                                                        }
                                                        String aaa="select * from empdet where NIC='"+Nic+"'";
                                                        pst=conn.prepareStatement(aaa);
                                                        rs=pst.executeQuery();
                                                        if(rs.next())
                                                        {
                                                            String e1=rs.getString("EID");
                                                            String aaaa="insert into perm_emp_salary(EID,Month,Basic_salary,Tot_salary,epfAmnt,etfAmnt,epfAccount,etfAccnt) values('"+e1+"','"+mm.year+"-"+mm.month+"','"+salary+"','"+fin+"','"+ep1+"','"+et1+"','"+Epf+"','"+Etf+"')";
                                                            pst=conn.prepareStatement(aaaa);
                                                            pst.execute();
                                                        }
                                                    }
                                                    else if((check_bank(bank)==false)&&(Baccount.getText().compareTo("")!=0))
                                                    {
                                                        JOptionPane.showMessageDialog(null, "Bank number is invalid");
                                                    }
                                                    else if((check_bank(bank)==false)&&(Baccount.getText().compareTo("")==0))
                                                    {
                                                        String a="INSERT INTO empdet(FName,Surname,Address,NIC,Department,Position,Gender,ContactNo,Salary,type,DOB,Photo,SerialNo) VALUES ('"+Fname+"','"+Surname+"','"+addrss+"','"+Nic+"','"+Dep+"','"+Pos+"','"+gender+"','"+Phone+"','"+salary+"','"+Type+"','"+dates+"','"+format+"','"+bar+"')";
                                                        pst=conn.prepareStatement(a);
                                                        pst.execute();
                                                        String aa="select default(EPF),default(ETF) from perm_emp_salary";
                                                        pst=conn.prepareStatement(aa);
                                                        rs=pst.executeQuery();
                                                        double s1=0,s2=0,fin=0,ep1=0,et1=0;
                                                        if(rs.next())
                                                        {
                                                            s1=Double.parseDouble(rs.getString("default(EPF)"));
                                                            s2=Double.parseDouble(rs.getString("default(ETF)"));
                                                            ep1=salary*(s1/100);
                                                            et1=salary*(s2/100);
                                                            fin=salary-(ep1+et1);
                                                        }
                                                        String aaa="select * from empdet where NIC='"+Nic+"'";
                                                        pst=conn.prepareStatement(aaa);
                                                        rs=pst.executeQuery();
                                                        if(rs.next())
                                                        {
                                                            String e1=rs.getString("EID");
                                                            String aaaa="insert into perm_emp_salary(EID,Month,Basic_salary,Tot_salary,epfAmnt,etfAmnt) values('"+e1+"','"+mm.year+"-"+mm.month+"','"+salary+"','"+fin+"','"+ep1+"','"+et1+"')";
                                                            pst=conn.prepareStatement(aaaa);
                                                            pst.execute();
                                                        }
                                                    }
                                                }
                                                else if(type.getSelectedIndex()==3)
                                                    {
                                                        if(check_bank(bank)==true)
                                                        {
                                                            String a="INSERT INTO empdet(FName,Surname,BankAccount,Address,NIC,Department,Position,Gender,ContactNo,Salary,type,DOB,photo,SerialNo,epf,etf,Password) VALUES ('"+Fname+"','"+Surname+"','"+bank+"','"+addrss+"','"+Nic+"','"+Dep+"','"+Pos+"','"+gender+"','"+Phone+"','"+salary+"','"+Type+"','"+dates+"','"+format+"','"+bar+"','"+Epf+"','"+Etf+"','"+Password+"')";
                                                            pst=conn.prepareStatement(a);
                                                            pst.execute();
                                                            String aa="select default(EPF),default(ETF) from perm_emp_salary";
                                                            pst=conn.prepareStatement(aa);
                                                            rs=pst.executeQuery();
                                                            double s1=0,s2=0,fin=0,ep1=0,et1=0;
                                                            if(rs.next())
                                                            {
                                                                s1=Double.parseDouble(rs.getString("default(EPF)"));
                                                                s2=Double.parseDouble(rs.getString("default(ETF)"));
                                                                ep1=salary*(s1/100);
                                                                et1=salary*(s2/100);
                                                                fin=salary-(ep1+et1);
                                                            }
                                                            String aaa="select * from empdet where NIC='"+Nic+"'";
                                                            pst=conn.prepareStatement(aaa);
                                                            rs=pst.executeQuery();
                                                            if(rs.next())
                                                            {
                                                                String e1=rs.getString("EID");
                                                                String aaaa="insert into perm_emp_salary(EID,Month,Basic_salary,Tot_salary,epfAmnt,etfAmnt,epfAccount,etfAccnt) values('"+e1+"','"+mm.year+"-"+mm.month+"','"+salary+"','"+fin+"','"+ep1+"','"+et1+"','"+Epf+"','"+Etf+"')";
                                                                pst=conn.prepareStatement(aaaa);
                                                                pst.execute();
                                                            }
                                                        }
                                                        else if((check_bank(bank)==false)&&(Baccount.getText()!=null))
                                                        {
                                                            JOptionPane.showMessageDialog(null, "Bank number is invalid");
                                                        }
                                                        else if(Baccount.getText()==null)
                                                        {
                                                            String a="insert into empdet (FName,Surname,Address,NIC,Department,Position,Gender,ContactNo,Salary,type,DOB,Photo,SerialNo,Password) VALUES ('"+Fname+"','"+Surname+"','"+addrss+"','"+Nic+"','"+Dep+"','"+Pos+"','"+gender+"','"+Phone+"','"+salary+"','"+Type+"','"+dates+"','"+format+"','"+bar+"','"+Password+"')";
                                                            pst=conn.prepareStatement(a);
                                                            pst.execute();
                                                            String aa="select default(EPF),default(ETF) from perm_emp_salary";
                                                            pst=conn.prepareStatement(aa);
                                                            rs=pst.executeQuery();
                                                            double s1=0,s2=0,fin=0,ep1=0,et1=0;
                                                            if(rs.next())
                                                            {
                                                                s1=Double.parseDouble(rs.getString("default(EPF)"));
                                                                s2=Double.parseDouble(rs.getString("default(ETF)"));
                                                                ep1=salary*(s1/100);
                                                                et1=salary*(s2/100);
                                                                fin=salary-(ep1+et1);
                                                            }
                                                            String aaa="select * from empdet where NIC='"+Nic+"'";
                                                            pst=conn.prepareStatement(aaa);
                                                            rs=pst.executeQuery();
                                                            if(rs.next())
                                                            {
                                                                String e1=rs.getString("EID");
                                                                String aaaa="insert into perm_emp_salary (EID,Month,Basic_salary,Tot_salary,epfAmnt,etfAmnt) values ('"+e1+"','"+mm.year+"-"+mm.month+"','"+salary+"','"+fin+"','"+ep1+"','"+et1+"')";
                                                                pst=conn.prepareStatement(aaaa);
                                                                pst.execute();
                                                            }
                                                        }
                                                    }
                                                    else if(type.getSelectedIndex()==2)
                                                    {
                                                        String a="INSERT INTO empdet(FName,Surname,Address,NIC,Department,Position,Gender,ContactNo,Salary,type,DOB,Photo) VALUES ('"+Fname+"','"+Surname+"','"+addrss+"','"+Nic+"','"+Dep+"','"+Pos+"','"+gender+"','"+Phone+"','"+salary+"','"+Type+"','"+dates+"','"+format+"')";
                                                        pst=conn.prepareStatement(a);
                                                        pst.execute();
                                                        /*String aaa="select * from empdet where NIC='"+Nic+"'";
                                                        pst=conn.prepareStatement(aaa);
                                                        rs=pst.executeQuery();
                                                        if(rs.next())
                                                        {
                                                            String e1=rs.getString("EID");
                                                            String aaaa="insert into temp_emp_salary(EID,Day,Day_salary,Salary) values('"+e1+"','"+dates1+"','"+salary+"','"+salary+"')";
                                                            pst=conn.prepareStatement(aaaa);
                                                            pst.execute();
                                                        }*/
                                                    }
                                                
                                                    show_table();
//                                                    
                                                    clr();
                                                    JOptionPane.showMessageDialog(null, "Added successfully");
                                            }
                                            }
                                        else
                                            JOptionPane.showMessageDialog(null, "Error in input");
                                        }
                                    catch(Exception e)
                                    {
                                        System.out.println(e);
                                    }
                                }
                                else
                                    JOptionPane.showMessageDialog(null,"Phone number is not valid");
                            }
                            else
                                JOptionPane.showMessageDialog(null,"Birth day is invalid");
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null, "NIC number is not valid");
                        }
                }
                else
                    JOptionPane.showMessageDialog(null, "Fname or surname is not valid");
            }
        }
        else
        {
               JOptionPane.showMessageDialog(null, "Fill all the fields");
        }
        
    }//GEN-LAST:event_insertActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        String Eid11=eid.getText();
        String Fname=fname.getText();
        String Surname=surname.getText();
        String bank=Baccount.getText();
        String addrss=address.getText();
        String Nic=nic.getText();
        String Password=psswrd.getText();
        String Phone=contact.getText();
        String Type=(String) type.getSelectedItem();
        String Dep=(String) dep.getSelectedItem();
        String Pos=(String) position.getSelectedItem();
        String epAc=epf.getText();
        String etAc=etf.getText();
        char gender=0;
        //String pswrd=psswrd.getText();
        double salary = 0;
        if(female.isSelected())
            gender='f';
        else if(male.isSelected())
            gender='m';
        if((Fname.compareTo("")!=0)&&(Surname.compareTo("")!=0)&&(addrss.compareTo("")!=0)&&(Nic.compareTo("")!=0)&&(Phone.compareTo("")!=0)&&(Type.compareTo("     Select")!=0)&&(Dep.compareTo("     Select")!=0)&&(Pos.compareTo("     Select")!=0)&&(mm.day.format(dob.getDate()).compareTo("")!=0))
        {
            String dates1=mm.day.format(dob.getDate());
            /*if((Type.compareTo("Admin")==0)&&(psswrd(Password,Eid11)==false))
            {
                JOptionPane.showMessageDialog(null, "Password is wrong");
            }
            else
            {*/
                    if(mm.check_names(Fname,Surname)==true)
                    {
                        if(Nic.length()==10)
                        {
                            if(check_date(dates1)==true)
                            {
                                if(contact.getText().length()==10)
                                {
                                    try
                                    {
                                        String ab="select Salary from charges where Type='"+Pos+"'";
                                        pst=conn.prepareStatement(ab);
                                        rs=pst.executeQuery();
                                        if(rs.next())
                                        {
                                            int p=JOptionPane.showConfirmDialog(null, "Do you really need to update this record?");
                                            if(p==0)
                                            {
                                                String id=eid.getText();
                                                String l1="select * from empdet where EID='"+id+"'";
                                                PreparedStatement pt=conn.prepareStatement(l1);
                                                ResultSet rr=pt.executeQuery();
                                                String oldtype=null;
                                                double sala=0;
                                                if(rr.next())
                                                {
                                                    oldtype=rr.getString("type");
                                                    sala=Double.parseDouble(rr.getString("Salary"));
                                                }
                                                String a = null;
                                                salary=Double.parseDouble(rs.getString("Salary"));
                                                if((Baccount.getText().compareTo("")!=0)&&(check_bank(bank)==true))
                                                    a="update empdet set FName='"+Fname+"',Surname='"+Surname+"',Department='"+Dep+"',Position='"+Pos+"',Address='"+addrss+"',ContactNo='"+Phone+"',type='"+Type+"',BankAccount='"+bank+"',Photo='"+format+"' where EID='"+id+"'";
                                                else if((check_bank(bank)==false)&&(Baccount.getText().compareTo(""))!=0)
                                                    JOptionPane.showMessageDialog(null, "Bank number is invalid");
                                                else
                                                    a="update empdet set FName='"+Fname+"',Surname='"+Surname+"',Department='"+Dep+"',Position='"+Pos+"',Address='"+addrss+"',ContactNo='"+Phone+"',type='"+Type+"',Photo='"+format+"' where EID='"+id+"'";
                                                pst=conn.prepareStatement(a);
                                                pst.execute();
                                                if(oldtype.compareTo(Type)==0&&Type.compareTo("temporary")==0)
                                                {
                                                    
                                                }
                                                else if(oldtype.compareTo(Type)==0&&(Type.compareTo("Admin")==0||Type.compareTo("Permanant")==0))
                                                {
                                                    String vv1="select default(EPF),default(ETF) from perm_emp_salary";
                                                    pst=conn.prepareStatement(vv1);
                                                    rs=pst.executeQuery();
                                                    double epf1=0;
                                                    double etf1=0;
                                                    if(rs.next())
                                                    {
                                                        epf1=Double.parseDouble(rs.getString("default(EPF)"));
                                                        etf1=Double.parseDouble(rs.getString("default(ETF)"));
                                                    }
                                                    double e11=(sala*(epf1/100));
                                                    double e12=(sala*(etf1/100));
                                                    String vv2="insert into perm_emp_salary(EID,Month,Basic_salary,epfAmnt,etfAmnt,Tot_salary,BankAccount,epfAccount,etfAccnt) values('"+id+"','"+mm.year+"-"+mm.month+"','"+sala+"','"+e11+"','"+e12+"','"+(sala-e11-e12)+",'"+bank+"','"+epAc+"','"+etAc+"')";
                                                    pst=conn.prepareStatement(vv2);
                                                    pst.execute();
                                                }
                                                JOptionPane.showMessageDialog(null, "Updated Successfully");
                                                show_table();
                                                clr();
                                            }
                                        }
                                    }
                                    catch(Exception e)
                                    {
                                        System.out.println(e);
                                    }
                                }
                                else
                                    JOptionPane.showMessageDialog(null,"Phone number is not valid");
                            }
                            else
                                JOptionPane.showMessageDialog(null,"Birth day is wrong");
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null, "NIC number is not valid");
                        }
                    }
                    else
                        JOptionPane.showMessageDialog(null, "Fname or surname is not valid");
            //}
        }
        else
        {
               JOptionPane.showMessageDialog(null, "Fill all the fields");
        }
    }//GEN-LAST:event_updateActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        if(eid.getText().compareTo("")!=0)
        {
            int p=JOptionPane.showConfirmDialog(null, "Do you really need to delete this record?");
            if(p==0)
            {
                try
                {
                    String id=eid.getText();
                    String b="delete from empdet where EID='"+id+"'";
                    pst=conn.prepareStatement(b);
                    pst.execute();
                    JOptionPane.showMessageDialog(null, " deleted successfully");
                    show_table();
                    clr();
                }
                catch(Exception e)
                {
                    System.out.println(e);
                }
            }
        }
        else
            JOptionPane.showMessageDialog(null, "First select an employee");
    }//GEN-LAST:event_deleteActionPerformed

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
        clr();
    }//GEN-LAST:event_clearActionPerformed

    private void bttn_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttn_searchActionPerformed
        clr();
        psswrd.setVisible(false);
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
                ta="select EID,FName,Surname,Department,NIC,Gender,ContactNo,Position,Salary from empdet where Position='"+a6+"'";
            else if((a1.compareTo("")==0)&&(a2.compareTo("")==0)&&(a3!=0)&&(a4==0))
                ta="select EID,FName,Surname,Department,NIC,Gender,ContactNo,Position,Salary from empdet where Department='"+a5+"'";
            else if((a1.compareTo("")==0)&&(a2.compareTo("")==0)&&(a3!=0)&&(a4!=0))
                ta="select EID,FName,Surname,Department,NIC,Gender,ContactNo,Position,Salary from empdet where Position='"+a6+"' and Department='"+a5+"'";
            else if((a1.compareTo("")==0)&&(a2.compareTo("")!=0)&&(a3==0)&&(a4==0))
                ta="select EID,FName,Surname,Department,NIC,Gender,ContactNo,Position,Salary from empdet where Surname like '"+a2+"%'";
            else if((a1.compareTo("")==0)&&(a2.compareTo("")!=0)&&(a3==0)&&(a4!=0))
                ta="select EID,FName,Surname,Department,NIC,Gender,ContactNo,Position,Salary from empdet where Surname like '"+a2+"%' and Position='"+a6+"'";
            else if((a1.compareTo("")==0)&&(a2.compareTo("")!=0)&&(a3!=0)&&(a4==0))
                ta="select EID,FName,Surname,Department,NIC,Gender,ContactNo,Position,Salary from empdet where Surname like '"+a2+"%' and Department='"+a5+"'";
            else if((a1.compareTo("")==0)&&(a2.compareTo("")!=0)&&(a3!=0)&&(a4!=0))
                ta="select EID,FName,Surname,Department,NIC,Gender,ContactNo,Position,Salary from empdet where Surname like '"+a2+"%' and Department='"+a5+"' and Position='"+a6+"'";
            else if((a1.compareTo("")!=0)&&(a2.compareTo("")==0)&&(a3==0)&&(a4==0))
                ta="select EID,FName,Surname,Department,NIC,Gender,ContactNo,Position,Salary from empdet where EID='"+a1+"'";
            else if((a1.compareTo("")!=0)&&(a2.compareTo("")==0)&&(a3==0)&&(a4!=0))
                ta="select EID,FName,Surname,Department,NIC,Gender,ContactNo,Position,Salary from empdet where EID='"+a1+"' and Position='"+a6+"'";
            else if((a1.compareTo("")!=0)&&(a2.compareTo("")==0)&&(a3!=0)&&(a4==0))
                ta="select EID,FName,Surname,Department,NIC,Gender,ContactNo,Position,Salary from empdet where EID='"+a1+"' and Department='"+a5+"'";
            else if((a1.compareTo("")!=0)&&(a2.compareTo("")==0)&&(a3!=0)&&(a4!=0))
                ta="select EID,FName,Surname,Department,NIC,Gender,ContactNo,Position,Salary from empdet where EID='"+a1+"' and Position='"+a6+"' and Position='"+a6+"'";
            else if((a1.compareTo("")!=0)&&(a2.compareTo("")!=0)&&(a3==0)&&(a4==0))
                ta="select EID,FName,Surname,Department,NIC,Gender,ContactNo,Position,Salary from empdet where EID='"+a1+"' and Surname like '"+a2+"%'";
            else if((a1.compareTo("")!=0)&&(a2.compareTo("")!=0)&&(a3==0)&&(a4!=0))
                ta="select EID,FName,Surname,Department,NIC,Gender,ContactNo,Position,Salary from empdet where EID='"+a1+"' and Surname like '"+a2+"%' and Position='"+a6+"'";
            else if((a1.compareTo("")!=0)&&(a2.compareTo("")!=0)&&(a3!=0)&&(a4==0))
                ta="select EID,FName,Surname,Department,NIC,Gender,ContactNo,Position,Salary from empdet where EID='"+a1+"' and Surname like '"+a2+"%' and Department='"+a5+"'";
            else
                ta="select EID,FName,Surname,Department,NIC,Gender,ContactNo,Position,Salary from empdet where EID='"+a1+"' and Surname like '"+a2+"%' and Position='"+a6+"' and Department='"+a5+"'";
            
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
    }//GEN-LAST:event_bttn_searchActionPerformed

    private void etableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_etableMouseClicked
        clr();
        psswrd.setVisible(false);
        try
        {
            int row=etable.getSelectedRow();
            String id=etable.getModel().getValueAt(row, 0).toString();
            String sql="select * from empdet where EID='"+id+"'";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            if(rs.next())
            {
                eid.setText(rs.getString("EID"));
                fname.setText(rs.getString("FName"));
                surname.setText(rs.getString("Surname"));
                sala.setText(rs.getString("Salary"));
                contact.setText(rs.getString("ContactNo"));
                type.setSelectedItem(rs.getString("type"));
                dob.setDate((Date)mm.day.parse(rs.getString("DOB")));
                Baccount.setText(rs.getString("BankAccount"));
                epf.setText(rs.getString("epf"));
                etf.setText(rs.getString("etf"));
                nic.setText(rs.getString("NIC"));
                brcode.setText(rs.getString("SerialNo"));
                //address.setText(rs.getString("Address"));
                
                address.setText(rs.getString("Address"));
                
                if(rs.getString("Gender").compareTo("m")==0)
                    male.setSelected(true);
                else
                    female.setSelected(true);
                dep.setSelectedItem(rs.getString("Department"));
                if(rs.getBytes("Photo")!=null)
                {
                    byte[] images=rs.getBytes("Photo");
                    ImageIcon forma=new ImageIcon(images);
                    frame.setIcon(forma);
                }
                position.setSelectedItem(rs.getString("Position"));
            }
            else
                JOptionPane.showMessageDialog(null, "No ID identified");
            
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_etableMouseClicked

    private void srch_depActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_srch_depActionPerformed
        clr();
        psswrd.setVisible(false);
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
                ta="select EID,FName,Surname,Department,NIC,Gender,ContactNo,Position,Salary,SerialNo from empdet where Position='"+a6+"'";
            else if((a1.compareTo("")==0)&&(a2.compareTo("")==0)&&(a3!=0)&&(a4==0))
                ta="select EID,FName,Surname,Department,NIC,Gender,ContactNo,Position,Salary,SerialNo from empdet where Department='"+a5+"'";
            else if((a1.compareTo("")==0)&&(a2.compareTo("")==0)&&(a3!=0)&&(a4!=0))
                ta="select EID,FName,Surname,Department,NIC,Gender,ContactNo,Position,Salary,SerialNo from empdet where Position='"+a6+"' and Department='"+a5+"'";
            else if((a1.compareTo("")==0)&&(a2.compareTo("")!=0)&&(a3==0)&&(a4==0))
                ta="select EID,FName,Surname,Department,NIC,Gender,ContactNo,Position,Salary,SerialNo from empdet where Surname like '"+a2+"%'";
            else if((a1.compareTo("")==0)&&(a2.compareTo("")!=0)&&(a3==0)&&(a4!=0))
                ta="select EID,FName,Surname,Department,NIC,Gender,ContactNo,Position,Salary,SerialNo from empdet where Surname like '"+a2+"%' and Position='"+a6+"'";
            else if((a1.compareTo("")==0)&&(a2.compareTo("")!=0)&&(a3!=0)&&(a4==0))
                ta="select EID,FName,Surname,Department,NIC,Gender,ContactNo,Position,Salary,SerialNo from empdet where Surname like '"+a2+"%' and Department='"+a5+"'";
            else if((a1.compareTo("")==0)&&(a2.compareTo("")!=0)&&(a3!=0)&&(a4!=0))
                ta="select EID,FName,Surname,Department,NIC,Gender,ContactNo,Position,Salary,SerialNo from empdet where Surname like '"+a2+"%' and Department='"+a5+"' and Position='"+a6+"'";
            else if((a1.compareTo("")!=0)&&(a2.compareTo("")==0)&&(a3==0)&&(a4==0))
                ta="select EID,FName,Surname,Department,NIC,Gender,ContactNo,Position,Salary,SerialNo from empdet where EID='"+a1+"'";
            else if((a1.compareTo("")!=0)&&(a2.compareTo("")==0)&&(a3==0)&&(a4!=0))
                ta="select EID,FName,Surname,Department,NIC,Gender,ContactNo,Position,Salary,SerialNo from empdet where EID='"+a1+"' and Position='"+a6+"'";
            else if((a1.compareTo("")!=0)&&(a2.compareTo("")==0)&&(a3!=0)&&(a4==0))
                ta="select EID,FName,Surname,Department,NIC,Gender,ContactNo,Position,Salary,SerialNo from empdet where EID='"+a1+"' and Department='"+a5+"'";
            else if((a1.compareTo("")!=0)&&(a2.compareTo("")==0)&&(a3!=0)&&(a4!=0))
                ta="select EID,FName,Surname,Department,NIC,Gender,ContactNo,Position,Salary,SerialNo from empdet where EID='"+a1+"' and Position='"+a6+"' and Position='"+a6+"'";
            else if((a1.compareTo("")!=0)&&(a2.compareTo("")!=0)&&(a3==0)&&(a4==0))
                ta="select EID,FName,Surname,Department,NIC,Gender,ContactNo,Position,Salary,SerialNo from empdet where EID='"+a1+"' and Surname like '"+a2+"%'";
            else if((a1.compareTo("")!=0)&&(a2.compareTo("")!=0)&&(a3==0)&&(a4!=0))
                ta="select EID,FName,Surname,Department,NIC,Gender,ContactNo,Position,Salary,SerialNo from empdet where EID='"+a1+"' and Surname like '"+a2+"%' and Position='"+a6+"'";
            else if((a1.compareTo("")!=0)&&(a2.compareTo("")!=0)&&(a3!=0)&&(a4==0))
                ta="select EID,FName,Surname,Department,NIC,Gender,ContactNo,Position,Salary,SerialNo from empdet where EID='"+a1+"' and Surname like '"+a2+"%' and Department='"+a5+"'";
            else
                ta="select EID,FName,Surname,Department,NIC,Gender,ContactNo,Position,Salary,SerialNo from empdet where EID='"+a1+"' and Surname like '"+a2+"%' and Position='"+a6+"' and Department='"+a5+"'";
            
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
        clr();
        psswrd.setVisible(false);
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
                ta="select EID,FName,Surname,Department,NIC,Gender,ContactNo,Position,Salary from empdet where Position='"+a6+"'";
            else if((a1.compareTo("")==0)&&(a2.compareTo("")==0)&&(a3!=0)&&(a4==0))
                ta="select EID,FName,Surname,Department,NIC,Gender,ContactNo,Position,Salary from empdet where Department='"+a5+"'";
            else if((a1.compareTo("")==0)&&(a2.compareTo("")==0)&&(a3!=0)&&(a4!=0))
                ta="select EID,FName,Surname,Department,NIC,Gender,ContactNo,Position,Salary from empdet where Position='"+a6+"' and Department='"+a5+"'";
            else if((a1.compareTo("")==0)&&(a2.compareTo("")!=0)&&(a3==0)&&(a4==0))
                ta="select EID,FName,Surname,Department,NIC,Gender,ContactNo,Position,Salary from empdet where Surname like '"+a2+"%'";
            else if((a1.compareTo("")==0)&&(a2.compareTo("")!=0)&&(a3==0)&&(a4!=0))
                ta="select EID,FName,Surname,Department,NIC,Gender,ContactNo,Position,Salary from empdet where Surname like '"+a2+"%' and Position='"+a6+"'";
            else if((a1.compareTo("")==0)&&(a2.compareTo("")!=0)&&(a3!=0)&&(a4==0))
                ta="select EID,FName,Surname,Department,NIC,Gender,ContactNo,Position,Salary from empdet where Surname like '"+a2+"%' and Department='"+a5+"'";
            else if((a1.compareTo("")==0)&&(a2.compareTo("")!=0)&&(a3!=0)&&(a4!=0))
                ta="select EID,FName,Surname,Department,NIC,Gender,ContactNo,Position,Salary from empdet where Surname like '"+a2+"%' and Department='"+a5+"' and Position='"+a6+"'";
            else if((a1.compareTo("")!=0)&&(a2.compareTo("")==0)&&(a3==0)&&(a4==0))
                ta="select EID,FName,Surname,Department,NIC,Gender,ContactNo,Position,Salary from empdet where EID='"+a1+"'";
            else if((a1.compareTo("")!=0)&&(a2.compareTo("")==0)&&(a3==0)&&(a4!=0))
                ta="select EID,FName,Surname,Department,NIC,Gender,ContactNo,Position,Salary from empdet where EID='"+a1+"' and Position='"+a6+"'";
            else if((a1.compareTo("")!=0)&&(a2.compareTo("")==0)&&(a3!=0)&&(a4==0))
                ta="select EID,FName,Surname,Department,NIC,Gender,ContactNo,Position,Salary from empdet where EID='"+a1+"' and Department='"+a5+"'";
            else if((a1.compareTo("")!=0)&&(a2.compareTo("")==0)&&(a3!=0)&&(a4!=0))
                ta="select EID,FName,Surname,Department,NIC,Gender,ContactNo,Position,Salary from empdet where EID='"+a1+"' and Position='"+a6+"' and Position='"+a6+"'";
            else if((a1.compareTo("")!=0)&&(a2.compareTo("")!=0)&&(a3==0)&&(a4==0))
                ta="select EID,FName,Surname,Department,NIC,Gender,ContactNo,Position,Salary from empdet where EID='"+a1+"' and Surname like '"+a2+"%'";
            else if((a1.compareTo("")!=0)&&(a2.compareTo("")!=0)&&(a3==0)&&(a4!=0))
                ta="select EID,FName,Surname,Department,NIC,Gender,ContactNo,Position,Salary from empdet where EID='"+a1+"' and Surname like '"+a2+"%' and Position='"+a6+"'";
            else if((a1.compareTo("")!=0)&&(a2.compareTo("")!=0)&&(a3!=0)&&(a4==0))
                ta="select EID,FName,Surname,Department,NIC,Gender,ContactNo,Position,Salary from empdet where EID='"+a1+"' and Surname like '"+a2+"%' and Department='"+a5+"'";
            else
                ta="select EID,FName,Surname,Department,NIC,Gender,ContactNo,Position,Salary from empdet where EID='"+a1+"' and Surname like '"+a2+"%' and Position='"+a6+"' and Department='"+a5+"'";
            
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

    private void etableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_etableKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_UP)
        {
            eid.setText("");
            fname.setText("");
            surname.setText("");
            Baccount.setText("");
            address.setText("");
            nic.setText("");
            contact.setText("");
            type.setSelectedIndex(0);
            dep.setSelectedIndex(0);
            dob.setDate(null);
            psswrd.setVisible(false);
            grp.clearSelection();
            sala.setText("");
            frame.setIcon(null);
            brcode.setText("");
            try
            {
                int row=etable.getSelectedRow();
                if(row==1)
                    row=1;
                String id=etable.getModel().getValueAt(row-1, 0).toString();
                String sql="select * from empdet where EID='"+id+"'";
                pst=conn.prepareStatement(sql);
                rs=pst.executeQuery();
                if(rs.next())
                {
                    eid.setText(rs.getString("EID"));
                    fname.setText(rs.getString("FName"));
                    surname.setText(rs.getString("Surname"));
                    dep.setSelectedItem(rs.getString("Department"));
                    nic.setText(rs.getString("NIC"));
                    address.setText(rs.getString("Address"));
                    sala.setText(rs.getString("Salary"));
                    contact.setText(rs.getString("ContactNo"));
                    type.setSelectedItem(rs.getString("type"));
                    dob.setDate((Date)mm.day.parse(rs.getString("DOB")));
                    Baccount.setText(rs.getString("BankAccount"));
                    brcode.setText(rs.getString("SerialNo"));
                    epf.setText(rs.getString("epf"));
                    etf.setText(rs.getString("etf"));
                    if(rs.getBytes("Photo")!=null)
                    {
                        byte[] images=rs.getBytes("Photo");
                        ImageIcon forma=new ImageIcon(images);
                        frame.setIcon(forma);
                    }
                    if(rs.getString("Gender").compareTo("m")==0)
                    {
                        male.setSelected(true);
                    }
                    else
                        female.setSelected(true);
                }
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, e);
            }
        }
        else if(evt.getKeyCode()==KeyEvent.VK_DOWN)
        {
            eid.setText("");
            fname.setText("");
            surname.setText("");
            Baccount.setText("");
            address.setText("");
            nic.setText("");
            contact.setText("");
            type.setSelectedIndex(0);
            dep.setSelectedIndex(0);
            dob.setDate(null);
            psswrd.setText("");
            grp.clearSelection();
            sala.setText("");
            frame.setIcon(null);
            try
            {
                int row=etable.getSelectedRow();
                String id=etable.getModel().getValueAt(row+1, 0).toString();
                String sql="select * from empdet where EID='"+id+"'";
                pst=conn.prepareStatement(sql);
                rs=pst.executeQuery();
                if(rs.next())
                {
                    eid.setText(rs.getString("EID"));
                    fname.setText(rs.getString("FName"));
                    surname.setText(rs.getString("Surname"));
                    dep.setSelectedItem(rs.getString("Department"));
                    nic.setText(rs.getString("NIC"));
                    address.setText(rs.getString("Address"));
                    sala.setText(rs.getString("Salary"));
                    contact.setText(rs.getString("ContactNo"));
                    type.setSelectedItem(rs.getString("type"));
                    dob.setDate((Date)mm.day.parse(rs.getString("DOB")));
                    Baccount.setText(rs.getString("BankAccount"));
                    brcode.setText(rs.getString("SerialNo"));
                    epf.setText(rs.getString("epf"));
                    etf.setText(rs.getString("etf"));
                    if(rs.getBytes("Photo")!=null)
                    {
                        byte[] images=rs.getBytes("Photo");
                        ImageIcon forma=new ImageIcon(images);
                        frame.setIcon(forma);
                    }
                    if(rs.getString("Gender").compareTo("m")==0)
                    {
                        male.setSelected(true);
                    }
                    else
                        female.setSelected(true);
                }
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
    }//GEN-LAST:event_etableKeyPressed

    private void clear1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clear1ActionPerformed
        search.setText("");
        srch_surname.setText("");
        srch_dep.setSelectedIndex(0);
        srch_job.setSelectedIndex(0);
        show_table();
    }//GEN-LAST:event_clear1ActionPerformed

    private void typeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_typeActionPerformed
        if(type.getSelectedIndex()!=3)
        {
            psswrd.setText("");
            psswrd.setVisible(false);
        }
        else
        {
            psswrd.setVisible(true);
        }
    }//GEN-LAST:event_typeActionPerformed

    private void depActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_depActionPerformed
       //String a=dep.getSelectedItem().toString();
       //show_job(a);
    }//GEN-LAST:event_depActionPerformed

    private void positionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_positionActionPerformed
        if(position.getSelectedIndex()!=0)
        {
            try {
                String Pos=position.getSelectedItem().toString();
                String ab="select Salary from charges where Type='"+Pos+"'";
                pst=conn.prepareStatement(ab);
                rs=pst.executeQuery();
                if(rs.next())
                {
                    double sal=Double.parseDouble(rs.getString("Salary"));
                    sala.setText(Double.toString(sal));
                }
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }
        else
            sala.setText("");
    }//GEN-LAST:event_positionActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JFileChooser chooser=new JFileChooser();
        chooser.showOpenDialog(null);
        File f=chooser.getSelectedFile();
        filename=f.getAbsolutePath();
        
        try{
            File img=new File(filename);
            FileInputStream fis=new FileInputStream(img);
            ByteArrayOutputStream bos=new ByteArrayOutputStream();
            byte[] buff=new byte[1024];
            for(int readNum; (readNum=fis.read(buff))!=-1;)
            {
                bos.write(buff,0,readNum);
            }
            
            personImage=bos.toByteArray();
            ImageIcon format=new ImageIcon(filename);
            frame.setIcon(format);
            String a="update empdet set Photo=? where EID='11138'";
            pst=conn.prepareStatement(a);
            pst.setBytes(1, personImage);
            pst.execute();
        } catch(Exception e)
        {
            System.out.println(e);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(eid.getText().compareTo("")==0)
        {
            JOptionPane.showMessageDialog(null, "select an employee");
        }
        else
        {
            String Eid=eid.getText();
            try 
            {
                String a1="select * from empdet where EID='"+Eid+"'";
                pst=conn.prepareStatement(a1);
                rs=pst.executeQuery();
                if(rs.next())
                {
                    String psd=rs.getString("Password");
                    if(psd==null)
                    {
                        JOptionPane.showMessageDialog(null, "Does not have a password");
                    }
                    else
                    {
                        String pss=JOptionPane.showInputDialog(null, "Enter the old password");
                        if(pss.compareTo(psd)==0)
                        {
                            psswrd.setText(pss);
                            jLabel18.setVisible(true);
                            newpass.setVisible(true);
                            jLabel19.setVisible(true);
                            conpass.setVisible(true);
                            chbttn.setVisible(true);
                            cnbttn.setVisible(true);
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null, "Wrong Password");
                        }
                    }
                }
            } catch(Exception e) 
            {
                System.out.println(e);
            }
                
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void chbttnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chbttnActionPerformed
        String new1=newpass.getText();
        String confirm=conpass.getText();
        String Eid=eid.getText();
        String psd=null;
        String a1="select Password from empdet where EID='"+Eid+"'";
        try 
        {
            pst=conn.prepareStatement(a1);
            rs=pst.executeQuery();
            if(rs.next())
                psd=rs.getString("Password");
        } catch(Exception e)
        {
            System.out.println(e);
        }
        if(new1!=null&&confirm!=null)
        {
            if(new1.compareTo(psd)!=0)
            {
                if(new1.compareTo(confirm)==0)
                {
                    try {
                        String b1="update empdet set Password='"+new1+"' where EID='"+Eid+"'";
                        pst=conn.prepareStatement(b1);
                        pst.execute();
                        psswrd.setText("");
                        jLabel18.setVisible(false);
                        newpass.setVisible(false);
                        jLabel19.setVisible(false);
                        conpass.setVisible(false);
                        chbttn.setVisible(false);
                        cnbttn.setVisible(false);
                        JOptionPane.showMessageDialog(null, "Changed the password successfully");
                    } catch(Exception e) {
                        System.out.println(e);
                    }
                }
                else
                    JOptionPane.showMessageDialog(null, "Cnfirm password is wrong");
            }
            else
                JOptionPane.showMessageDialog(null, "Password is invalid. Please enter another password");
        }
        else
            JOptionPane.showMessageDialog(null, "Password fields are empty");
    }//GEN-LAST:event_chbttnActionPerformed

    private void psswrdAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_psswrdAncestorAdded
        
    }//GEN-LAST:event_psswrdAncestorAdded

    private void cnbttnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cnbttnActionPerformed
        jLabel18.setVisible(false);
        newpass.setVisible(false);
        jLabel19.setVisible(false);
        conpass.setVisible(false);
        chbttn.setVisible(false);
        cnbttn.setVisible(false);
    }//GEN-LAST:event_cnbttnActionPerformed

    private void jLabel21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseClicked
        etable.clearSelection();
    }//GEN-LAST:event_jLabel21MouseClicked

    private void brcodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brcodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_brcodeActionPerformed

    private void depMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_depMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_depMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Baccount;
    private javax.swing.JTextArea address;
    private javax.swing.JTextField brcode;
    private javax.swing.JButton bttn_search;
    private javax.swing.JButton chbttn;
    private javax.swing.JButton clear;
    private javax.swing.JButton clear1;
    private javax.swing.JButton cnbttn;
    private javax.swing.JPasswordField conpass;
    private javax.swing.JTextField contact;
    private javax.swing.JButton delete;
    private javax.swing.JComboBox dep;
    private com.toedter.calendar.JDateChooser dob;
    private javax.swing.JLabel eid;
    private javax.swing.JTextField epf;
    private javax.swing.JTable etable;
    private javax.swing.JTextField etf;
    private javax.swing.JRadioButton female;
    private javax.swing.JTextField fname;
    private javax.swing.JLabel frame;
    private javax.swing.ButtonGroup grp;
    private javax.swing.JButton insert;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
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
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton male;
    private javax.swing.JPasswordField newpass;
    private javax.swing.JTextField nic;
    private javax.swing.JComboBox position;
    private javax.swing.JPasswordField psswrd;
    private javax.swing.JLabel sala;
    private javax.swing.JTextField search;
    private javax.swing.JComboBox srch_dep;
    private javax.swing.JComboBox srch_job;
    private javax.swing.JTextField srch_surname;
    private javax.swing.JTextField surname;
    private javax.swing.JComboBox type;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
private ImageIcon forr=null;
String filename=null;
int s=0;
byte[] personImage=null;
}

