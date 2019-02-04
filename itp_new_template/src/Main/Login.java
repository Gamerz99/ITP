/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import dbconnect.dbconnect;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author MUNESH
 */
public class Login extends javax.swing.JFrame {

    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    int a;
    int log;
    String name1;

    public Login() {
        initComponents();
        con = dbconnect.connect();
        today.setText(showDate());
        showTime();
    }

    public Login(int nid, int lg) {
        initComponents();
        a = nid;
        log = lg;
        con = dbconnect.connect();
        today.setText(showDate());
        showTime();
        if (this.a == 1) {
            title.setText("Receptionist Login");
        } else if (this.a == 2) {
            title.setText("Clerk Login");
        } else if (this.a == 3) {
            title.setText("HR Manager Login");
        } else if (this.a == 4) {
            title.setText("Accountant Login");
        } else if (this.a == 5) {
            title.setText("Stock Manager Login");
        } else if (this.a == 6) {
            title.setText("Transport Manager Login");
        } else if (this.a == 7) {
            title.setText("Cashier Login");
        } else if (this.a == 8) {
            title.setText("Maintanance Login");
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

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        hallname = new javax.swing.JLabel();
        title = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        logo = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        minimize = new javax.swing.JLabel();
        close = new javax.swing.JLabel();
        time = new javax.swing.JLabel();
        today = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        namebox = new javax.swing.JTextField();
        passwordbox = new javax.swing.JPasswordField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        login = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        back = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1920, 1080));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.setLayout(null);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(null);

        hallname.setFont(new java.awt.Font("Trajan Pro", 0, 36)); // NOI18N
        hallname.setForeground(new java.awt.Color(255, 255, 255));
        hallname.setText("RAVINDRA RECEPTION HALL");
        jPanel1.add(hallname);
        hallname.setBounds(660, 40, 580, 50);

        title.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        title.setForeground(new java.awt.Color(255, 255, 255));
        title.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(title);
        title.setBounds(820, 110, 280, 30);
        jPanel1.add(jSeparator4);
        jSeparator4.setBounds(170, 22, 1580, 10);

        logo.setIcon(new javax.swing.ImageIcon("C:\\Users\\MUNESH\\Documents\\NetBeansProjects\\ITP_new\\src\\Inventory\\imgs\\logo.png")); // NOI18N
        logo.setText(" ");
        jPanel1.add(logo);
        logo.setBounds(20, 10, 200, 160);
        jPanel1.add(jSeparator3);
        jSeparator3.setBounds(230, 92, 1460, 10);

        minimize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Inventory/imgs/minimize.png"))); // NOI18N
        minimize.setText(" ");
        minimize.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        minimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                minimizeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                minimizeMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                minimizeMouseReleased(evt);
            }
        });
        jPanel1.add(minimize);
        minimize.setBounds(1840, 10, 40, 32);

        close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Inventory/imgs/close.png"))); // NOI18N
        close.setText(" ");
        close.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                closeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                closeMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                closeMouseReleased(evt);
            }
        });
        jPanel1.add(close);
        close.setBounds(1880, 10, 40, 32);

        time.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        time.setForeground(new java.awt.Color(255, 255, 255));
        time.setText("  ");
        jPanel1.add(time);
        time.setBounds(1480, 110, 210, 30);

        today.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        today.setForeground(new java.awt.Color(255, 255, 255));
        today.setText("  ");
        today.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jPanel1.add(today);
        today.setBounds(320, 110, 230, 30);

        jPanel2.add(jPanel1);
        jPanel1.setBounds(0, 0, 1920, 160);

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Password");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(740, 740, 140, 40);

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("User Name");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(740, 660, 140, 40);

        namebox.setBackground(new java.awt.Color(51, 51, 51));
        namebox.setFont(new java.awt.Font("Yu Gothic Light", 0, 24)); // NOI18N
        namebox.setForeground(new java.awt.Color(255, 255, 255));
        namebox.setBorder(null);
        namebox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameboxActionPerformed(evt);
            }
        });
        namebox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nameboxKeyPressed(evt);
            }
        });
        jPanel2.add(namebox);
        namebox.setBounds(880, 650, 250, 40);

        passwordbox.setBackground(new java.awt.Color(51, 51, 51));
        passwordbox.setFont(new java.awt.Font("Yu Gothic Light", 0, 18)); // NOI18N
        passwordbox.setForeground(new java.awt.Color(255, 255, 255));
        passwordbox.setBorder(null);
        passwordbox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                passwordboxKeyPressed(evt);
            }
        });
        jPanel2.add(passwordbox);
        passwordbox.setBounds(880, 730, 250, 40);
        jPanel2.add(jSeparator1);
        jSeparator1.setBounds(880, 690, 250, 2);
        jPanel2.add(jSeparator2);
        jSeparator2.setBounds(880, 770, 250, 2);

        login.setBackground(new java.awt.Color(51, 51, 51));
        login.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        login.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        login.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                loginMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                loginMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                loginMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                loginMouseReleased(evt);
            }
        });
        login.setLayout(null);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Login");
        login.add(jLabel3);
        jLabel3.setBounds(90, 20, 60, 30);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Main/img/login.png"))); // NOI18N
        jLabel4.setText(" ");
        login.add(jLabel4);
        jLabel4.setBounds(10, 0, 70, 70);

        jPanel2.add(login);
        login.setBounds(880, 830, 170, 70);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Main/img/user.png"))); // NOI18N
        jLabel5.setText(" ");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(820, 320, 260, 256);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Main/img/login_body.png"))); // NOI18N
        jLabel6.setText(" ");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(520, 290, 840, 640);

        back.setBackground(new java.awt.Color(51, 51, 51));
        back.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        back.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                backMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                backMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                backMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                backMouseReleased(evt);
            }
        });
        back.setLayout(null);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Back");
        back.add(jLabel7);
        jLabel7.setBounds(60, 20, 50, 20);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Main/img/back.png"))); // NOI18N
        jLabel8.setText(" ");
        back.add(jLabel8);
        jLabel8.setBounds(10, 10, 40, 40);

        jPanel2.add(back);
        back.setBounds(20, 180, 120, 60);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 0, 1920, 1080);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void minimizeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeMouseEntered
        ImageIcon III = new ImageIcon(getClass().getResource("/Inventory/imgs/minimize_hover.png"));
        minimize.setIcon(III);
    }//GEN-LAST:event_minimizeMouseEntered

    private void minimizeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeMouseExited
        ImageIcon III = new ImageIcon(getClass().getResource("/Inventory/imgs/minimize.png"));
        minimize.setIcon(III);
    }//GEN-LAST:event_minimizeMouseExited

    private void minimizeMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeMouseReleased
        this.setState(Login.ICONIFIED);
    }//GEN-LAST:event_minimizeMouseReleased

    private void closeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMouseEntered
        ImageIcon III = new ImageIcon(getClass().getResource("/Inventory/imgs/close_hover.png"));
        close.setIcon(III);
    }//GEN-LAST:event_closeMouseEntered

    private void closeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMouseExited
        ImageIcon III = new ImageIcon(getClass().getResource("/Inventory/imgs/close.png"));
        close.setIcon(III);
    }//GEN-LAST:event_closeMouseExited

    private void closeMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMouseReleased
        System.exit(0);
    }//GEN-LAST:event_closeMouseReleased

    private void nameboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameboxActionPerformed

    private void loginMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginMouseEntered
        login.setBackground(Color.BLUE);
    }//GEN-LAST:event_loginMouseEntered

    private void loginMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginMouseExited
        login.setBackground(new Color(51, 51, 51));
    }//GEN-LAST:event_loginMouseExited

    private void loginMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginMousePressed
        login.setBackground(new Color(10, 122, 192));
    }//GEN-LAST:event_loginMousePressed

    private void loginMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginMouseReleased
        login.setBackground(new Color(51, 51, 51));

        name1 = namebox.getText();
        String password = passwordbox.getText();
        String work = null;
        String work2=null;
        if (this.a == 1) {
            work = "Receptionist";
            title.setText("Receptionist Login");
        } else if (this.a == 2) {
            work = "Clerk";
            title.setText("Clerk Login");
        } else if (this.a == 3) {
            work = "HR Manager";
            title.setText("HR Manager Login");
        } else if (this.a == 4) {
            work = "Accountant";
            title.setText("Accountant Login");
        } else if (this.a == 5) {
            work = "Stock Manager";
            title.setText("Stock Manager Login");
        } else if (this.a == 6) {
            work = "Transport Manager";
            title.setText("Transport Manager Login");
        } else if (this.a == 7) {
            work = "Cashier";
            work2="Kitchen Manager";
            title.setText("Cashier Login");
        } else if (this.a == 8) {
            work = "Maintenance Supervisor";
            title.setText("Maintanance Login");
        }
        try {
            String b = "select * from empdet where Position='" + work + "' or Position='"+work2+"'";
            pst = con.prepareStatement(b);
            rs = pst.executeQuery();
            if (rs.next()) {
                if (rs.getString("EID").compareTo(name1) == 0) {
                    if ((rs.getString("Password").compareTo(password) == 0)) {
                        if (this.a == 5) {
                            Inventory.InventoryMain em = new Inventory.InventoryMain(5, name1);
                            em.setVisible(true);
                            this.dispose();
                        } else if (this.a == 8) {
                            maintenancemanagement.main em = new maintenancemanagement.main(8, name1);
                            em.setVisible(true);
                            this.dispose();
                        }
                       else if(this.a==2)
                       {
                        customer.CustomerHome em=new customer.CustomerHome(2,name1);
                        em.setVisible(true);
                        this.dispose();
                       }
                       else if(this.a==3)
                       {
                        Employee.EmpMain em=new Employee.EmpMain();
                        em.setVisible(true);
                        this.dispose();
                       }
                       else if(this.a==8)
                       {
                        maintenancemanagement.main em=new maintenancemanagement.main();
                        em.setVisible(true);
                        this.dispose();
                       }
                       else if(this.a==1)
                       {
                        Event.EventMain em=new Event.EventMain();
                        em.setVisible(true);
                        this.dispose();
                       }
                       else if(this.a==7)
                       {
                           if(work.compareTo("Cashier")==0)
                           {
                                Resturant.InventoryMain em=new Resturant.InventoryMain();
                                em.setVisible(true);
                                this.dispose();
                           }
                           else if(work2.compareTo("Kitchen Manager")==0)
                           {
                               Resturant.kitchen_ k1=new Resturant.kitchen_();
                               k1.setVisible(true);
                               this.dispose();
                           }
                       }
//                       else
//                       {
//                        Emp_main em=new Emp_main();
//                        em.setVisible(true);
//                        this.dispose();
//                       }
                    } else {
                        JOptionPane.showMessageDialog(null, "Password is wrong");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Employee name is wrong");
                }

            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_loginMouseReleased

    private void backMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMousePressed
        back.setBackground(new Color(10, 122, 192));
    }//GEN-LAST:event_backMousePressed

    private void backMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseReleased
        back.setBackground(new Color(51, 51, 51));

        Main m = new Main(log, name1);
        m.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backMouseReleased

    private void backMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseEntered
        back.setBackground(Color.BLUE);
    }//GEN-LAST:event_backMouseEntered

    private void backMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseExited
        back.setBackground(new Color(51, 51, 51));
    }//GEN-LAST:event_backMouseExited

    private void nameboxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nameboxKeyPressed
        int key = evt.getKeyCode();
        if (key == KeyEvent.VK_ENTER) {
            passwordbox.requestFocusInWindow();
        } else {

        }
    }//GEN-LAST:event_nameboxKeyPressed

    private void passwordboxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordboxKeyPressed
        int key = evt.getKeyCode();
        if (key == KeyEvent.VK_ENTER) {
            name1 = namebox.getText();
            String password = passwordbox.getText();
            String work = null;
            if (this.a == 1) {
                work = "Receptionist";
            } else if (this.a == 2) {
                work = "Clerk";
            } else if (this.a == 3) {
                work = "HR Manager";
            } else if (this.a == 4) {
                work = "Accountant";
            } else if (this.a == 5) {
                work = "Stock Manager";
            } else if (this.a == 6) {
                work = "Transport Manager";
            } else if (this.a == 7) {
                work = "Cashier";
            } else if (this.a == 8) {
                work = "Maintanance Manager";
            }
            try {
                String b = "select * from login where position='" + work + "'";
                pst = con.prepareStatement(b);
                rs = pst.executeQuery();
                if (rs.next()) {
                    if (rs.getString("username").compareTo(name1) == 0) {
                        if ((rs.getString("password").compareTo(password) == 0)) {
                            if (this.a == 5) {
                                Inventory.InventoryMain em = new Inventory.InventoryMain(5, name1);
                                em.setVisible(true);
                                this.dispose();
                            } else if (this.a == 1) {
                                maintenancemanagement.main em = new maintenancemanagement.main(8, name1);
                                em.setVisible(true);
                                this.dispose();
                            }
//                       else if(this.a==3)
//                       {
//                        Emp_main em=new Emp_main();
//                        em.setVisible(true);
//                        this.dispose();
//                       }
//                       else if(this.a==4)
//                       {
//                        Emp_main em=new Emp_main();
//                        em.setVisible(true);
//                        this.dispose();
//                       }
//                       else if(this.a==5)
//                       {
//                        Emp_main em=new Emp_main();
//                        em.setVisible(true);
//                        this.dispose();
//                       }
//                       else if(this.a==6)
//                       {
//                        Emp_main em=new Emp_main();
//                        em.setVisible(true);
//                        this.dispose();
//                       }
//                       else if(this.a==7)
//                       {
//                        Emp_main em=new Emp_main();
//                        em.setVisible(true);
//                        this.dispose();
//                       }
//                       else
//                       {
//                        Emp_main em=new Emp_main();
//                        em.setVisible(true);
//                        this.dispose();
//                       }
                        } else {
                            JOptionPane.showMessageDialog(null, "Password is wrong");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Employee name is wrong");
                    }

                }
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        } else {

        }
    }//GEN-LAST:event_passwordboxKeyPressed
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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel back;
    private javax.swing.JLabel close;
    private javax.swing.JLabel hallname;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JPanel login;
    private javax.swing.JLabel logo;
    private javax.swing.JLabel minimize;
    private javax.swing.JTextField namebox;
    private javax.swing.JPasswordField passwordbox;
    private javax.swing.JLabel time;
    private javax.swing.JLabel title;
    private javax.swing.JLabel today;
    // End of variables declaration//GEN-END:variables
}
