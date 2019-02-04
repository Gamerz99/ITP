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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author MUNESH
 */
public class Main extends javax.swing.JFrame {

    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    int log;
    String logname;
    String work;
    public Main() {
        log = 0;
        initComponents();
        con = dbconnect.connect();
        today.setText(showDate());
        showTime();
    }

    public Main(int lg,String n) {
        initComponents();
        log = lg;
        logname=n;
        con = dbconnect.connect();
        today.setText(showDate());
        showTime();
        if (this.log == 1) {
            work = "Receptionist";
        } else if (this.log == 2) {
            work = "Clerk";
        } else if (this.log == 3) {
            work = "HR Manager";
        } else if (this.log == 4) {
            work = "Accountant";
        } else if (this.log == 5) {
            work = "Stock Manager";
        } else if (this.log == 6) {
            work = "Transport Manager";
        } else if (this.log == 7) {
            work = "Cashier";
        } else if (this.log == 8) {
            work = "Maintanance Manager";
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        hallname = new javax.swing.JLabel();
        title = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        logo = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        minimize = new javax.swing.JLabel();
        close = new javax.swing.JLabel();
        time = new javax.swing.JLabel();
        today = new javax.swing.JLabel();
        finance = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        employee = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        event = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        customer = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        restaurent = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        inventory = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        transport = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        maintanance = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1920, 1080));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setLayout(null);

        hallname.setFont(new java.awt.Font("Trajan Pro", 0, 36)); // NOI18N
        hallname.setForeground(new java.awt.Color(255, 255, 255));
        hallname.setText("RAVINDRA RECEPTION HALL");
        jPanel2.add(hallname);
        hallname.setBounds(660, 40, 580, 50);

        title.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        title.setForeground(new java.awt.Color(255, 255, 255));
        title.setText("WELCOME");
        title.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel2.add(title);
        title.setBounds(900, 110, 110, 30);
        jPanel2.add(jSeparator4);
        jSeparator4.setBounds(170, 22, 1580, 10);

        logo.setIcon(new javax.swing.ImageIcon("C:\\Users\\MUNESH\\Documents\\NetBeansProjects\\ITP_new\\src\\Inventory\\imgs\\logo.png")); // NOI18N
        logo.setText(" ");
        jPanel2.add(logo);
        logo.setBounds(20, 10, 200, 160);
        jPanel2.add(jSeparator3);
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
        jPanel2.add(minimize);
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
        jPanel2.add(close);
        close.setBounds(1880, 10, 40, 32);

        time.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        time.setForeground(new java.awt.Color(255, 255, 255));
        time.setText("  ");
        jPanel2.add(time);
        time.setBounds(1480, 110, 210, 30);

        today.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        today.setForeground(new java.awt.Color(255, 255, 255));
        today.setText("  ");
        today.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jPanel2.add(today);
        today.setBounds(320, 110, 230, 30);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 1920, 160);

        finance.setBackground(new java.awt.Color(51, 51, 51));
        finance.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        finance.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        finance.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                financeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                financeMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                financeMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                financeMouseReleased(evt);
            }
        });
        finance.setLayout(null);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Finance Management");
        finance.add(jLabel7);
        jLabel7.setBounds(70, 210, 230, 40);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Main/img/finance.png"))); // NOI18N
        jLabel8.setText(" ");
        finance.add(jLabel8);
        jLabel8.setBounds(110, 50, 128, 128);

        jPanel1.add(finance);
        finance.setBounds(1420, 650, 350, 310);

        employee.setBackground(new java.awt.Color(51, 51, 51));
        employee.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        employee.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        employee.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                employeeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                employeeMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                employeeMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                employeeMouseReleased(evt);
            }
        });
        employee.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Employee Management");
        employee.add(jLabel1);
        jLabel1.setBounds(50, 210, 250, 40);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Main/img/employees.png"))); // NOI18N
        jLabel2.setText(" ");
        employee.add(jLabel2);
        jLabel2.setBounds(110, 50, 128, 128);

        jPanel1.add(employee);
        employee.setBounds(990, 270, 350, 310);

        event.setBackground(new java.awt.Color(51, 51, 51));
        event.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        event.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        event.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                eventMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                eventMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                eventMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                eventMouseReleased(evt);
            }
        });
        event.setLayout(null);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Event Management");
        event.add(jLabel3);
        jLabel3.setBounds(70, 210, 210, 40);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Main/img/event.png"))); // NOI18N
        jLabel4.setText(" ");
        event.add(jLabel4);
        jLabel4.setBounds(110, 50, 128, 128);

        jPanel1.add(event);
        event.setBounds(150, 270, 350, 310);

        customer.setBackground(new java.awt.Color(51, 51, 51));
        customer.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        customer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        customer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                customerMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                customerMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                customerMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                customerMouseReleased(evt);
            }
        });
        customer.setLayout(null);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Customer Management");
        customer.add(jLabel5);
        jLabel5.setBounds(50, 210, 250, 40);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Main/img/customer.png"))); // NOI18N
        jLabel6.setText(" ");
        customer.add(jLabel6);
        jLabel6.setBounds(110, 50, 128, 128);

        jPanel1.add(customer);
        customer.setBounds(570, 270, 350, 310);

        restaurent.setBackground(new java.awt.Color(51, 51, 51));
        restaurent.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        restaurent.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        restaurent.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                restaurentMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                restaurentMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                restaurentMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                restaurentMouseReleased(evt);
            }
        });
        restaurent.setLayout(null);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Restaurent");
        restaurent.add(jLabel9);
        jLabel9.setBounds(110, 210, 120, 40);

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Main/img/restaurent.png"))); // NOI18N
        jLabel10.setText(" ");
        restaurent.add(jLabel10);
        jLabel10.setBounds(110, 50, 128, 128);

        jPanel1.add(restaurent);
        restaurent.setBounds(1420, 270, 350, 310);

        inventory.setBackground(new java.awt.Color(51, 51, 51));
        inventory.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        inventory.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        inventory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                inventoryMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                inventoryMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                inventoryMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                inventoryMouseReleased(evt);
            }
        });
        inventory.setLayout(null);

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Inventory Management");
        inventory.add(jLabel11);
        jLabel11.setBounds(50, 210, 250, 40);

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Main/img/inventory.png"))); // NOI18N
        jLabel12.setText(" ");
        inventory.add(jLabel12);
        jLabel12.setBounds(110, 50, 128, 128);

        jPanel1.add(inventory);
        inventory.setBounds(150, 650, 350, 310);

        transport.setBackground(new java.awt.Color(51, 51, 51));
        transport.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        transport.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        transport.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                transportMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                transportMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                transportMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                transportMouseReleased(evt);
            }
        });
        transport.setLayout(null);

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Transport Management");
        transport.add(jLabel13);
        jLabel13.setBounds(50, 210, 250, 40);

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Main/img/transport.png"))); // NOI18N
        jLabel14.setText(" ");
        transport.add(jLabel14);
        jLabel14.setBounds(110, 50, 128, 128);

        jPanel1.add(transport);
        transport.setBounds(570, 650, 350, 310);

        maintanance.setBackground(new java.awt.Color(51, 51, 51));
        maintanance.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        maintanance.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        maintanance.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                maintananceMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                maintananceMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                maintananceMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                maintananceMouseReleased(evt);
            }
        });
        maintanance.setLayout(null);

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Maintanance");
        maintanance.add(jLabel15);
        jLabel15.setBounds(110, 210, 140, 40);

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Main/img/maintanance.png"))); // NOI18N
        jLabel16.setText(" ");
        maintanance.add(jLabel16);
        jLabel16.setBounds(110, 50, 128, 128);

        jPanel1.add(maintanance);
        maintanance.setBounds(990, 650, 350, 310);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 1920, 1080);

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

    private void employeeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_employeeMouseEntered
        employee.setBackground(new Color(0, 40, 192));
    }//GEN-LAST:event_employeeMouseEntered

    private void employeeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_employeeMouseExited
        employee.setBackground(new Color(51, 51, 51));
    }//GEN-LAST:event_employeeMouseExited

    private void employeeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_employeeMousePressed
        employee.setBackground(new Color(10, 122, 192));
    }//GEN-LAST:event_employeeMousePressed

    private void employeeMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_employeeMouseReleased
        employee.setBackground(new Color(51, 51, 51));
        Login lo1 = new Login(3, log);
        lo1.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_employeeMouseReleased

    private void eventMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eventMouseEntered
        event.setBackground(new Color(0, 40, 192));
    }//GEN-LAST:event_eventMouseEntered

    private void eventMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eventMouseExited
        event.setBackground(new Color(51, 51, 51));
    }//GEN-LAST:event_eventMouseExited

    private void eventMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eventMousePressed
        event.setBackground(new Color(10, 122, 192));
    }//GEN-LAST:event_eventMousePressed

    private void eventMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eventMouseReleased
        event.setBackground(new Color(51, 51, 51));
//        if (log == 0) {
            Login lo1 = new Login(1, log);
            lo1.setVisible(true);
            this.dispose();
//        } else if(log==1) {
//            event.event em = new event.event(1);
//            em.setVisible(true);
//            this.dispose();
//        }
//        else
//        {
//            JOptionPane.showMessageDialog(null, "You have logged in "+work);
//        }
    }//GEN-LAST:event_eventMouseReleased

    private void customerMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_customerMouseEntered
        customer.setBackground(new Color(0, 40, 192));
    }//GEN-LAST:event_customerMouseEntered

    private void customerMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_customerMouseExited
        customer.setBackground(new Color(51, 51, 51));
    }//GEN-LAST:event_customerMouseExited

    private void customerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_customerMousePressed
        customer.setBackground(new Color(10, 122, 192));
    }//GEN-LAST:event_customerMousePressed

    private void customerMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_customerMouseReleased
        customer.setBackground(new Color(51, 51, 51));
        Login lo1 = new Login(2, log);
        lo1.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_customerMouseReleased

    private void financeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_financeMouseEntered
        finance.setBackground(new Color(0, 40, 192));
    }//GEN-LAST:event_financeMouseEntered

    private void financeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_financeMouseExited
        finance.setBackground(new Color(51, 51, 51));
    }//GEN-LAST:event_financeMouseExited

    private void financeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_financeMousePressed
        finance.setBackground(new Color(10, 122, 192));
    }//GEN-LAST:event_financeMousePressed

    private void financeMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_financeMouseReleased
        finance.setBackground(new Color(51, 51, 51));
        Login lo1 = new Login(4, log);
        lo1.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_financeMouseReleased

    private void restaurentMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_restaurentMouseEntered
        restaurent.setBackground(new Color(0, 40, 192));
    }//GEN-LAST:event_restaurentMouseEntered

    private void restaurentMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_restaurentMouseExited
        restaurent.setBackground(new Color(51, 51, 51));
    }//GEN-LAST:event_restaurentMouseExited

    private void restaurentMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_restaurentMousePressed
        restaurent.setBackground(new Color(10, 122, 192));
    }//GEN-LAST:event_restaurentMousePressed

    private void restaurentMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_restaurentMouseReleased
        restaurent.setBackground(new Color(51, 51, 51));
        Login lo1 = new Login(7, log);
        lo1.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_restaurentMouseReleased

    private void inventoryMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inventoryMouseEntered
        inventory.setBackground(new Color(0, 40, 192));
    }//GEN-LAST:event_inventoryMouseEntered

    private void inventoryMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inventoryMouseExited
        inventory.setBackground(new Color(51, 51, 51));
    }//GEN-LAST:event_inventoryMouseExited

    private void inventoryMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inventoryMousePressed
        inventory.setBackground(new Color(10, 122, 192));
    }//GEN-LAST:event_inventoryMousePressed

    private void inventoryMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inventoryMouseReleased
        inventory.setBackground(new Color(51, 51, 51));
        if (log == 0) {
            Login lo1 = new Login(5, log);
            lo1.setVisible(true);
            this.dispose();
        } else if (log == 5) {
            Inventory.InventoryMain lo1 = new Inventory.InventoryMain(5,logname);
            lo1.setVisible(true);
            this.dispose();
        }
        else
        {
            JOptionPane.showMessageDialog(null, "You logged in "+work);
        }
    }//GEN-LAST:event_inventoryMouseReleased

    private void transportMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_transportMouseEntered
        transport.setBackground(new Color(0, 40, 192));
    }//GEN-LAST:event_transportMouseEntered

    private void transportMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_transportMouseExited
        transport.setBackground(new Color(51, 51, 51));
    }//GEN-LAST:event_transportMouseExited

    private void transportMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_transportMousePressed
        transport.setBackground(new Color(10, 122, 192));
    }//GEN-LAST:event_transportMousePressed

    private void transportMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_transportMouseReleased
        transport.setBackground(new Color(51, 51, 51));
        Login lo1 = new Login(6, log);
        lo1.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_transportMouseReleased

    private void maintananceMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_maintananceMouseEntered
        maintanance.setBackground(new Color(0, 40, 192));
    }//GEN-LAST:event_maintananceMouseEntered

    private void maintananceMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_maintananceMouseExited
        maintanance.setBackground(new Color(51, 51, 51));
    }//GEN-LAST:event_maintananceMouseExited

    private void maintananceMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_maintananceMousePressed
        maintanance.setBackground(new Color(10, 122, 192));
    }//GEN-LAST:event_maintananceMousePressed

    private void maintananceMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_maintananceMouseReleased
        maintanance.setBackground(new Color(51, 51, 51));
        Login lo1 = new Login(8, log);
        lo1.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_maintananceMouseReleased
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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel close;
    private javax.swing.JPanel customer;
    private javax.swing.JPanel employee;
    private javax.swing.JPanel event;
    private javax.swing.JPanel finance;
    private javax.swing.JLabel hallname;
    private javax.swing.JPanel inventory;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel logo;
    private javax.swing.JPanel maintanance;
    private javax.swing.JLabel minimize;
    private javax.swing.JPanel restaurent;
    private javax.swing.JLabel time;
    private javax.swing.JLabel title;
    private javax.swing.JLabel today;
    private javax.swing.JPanel transport;
    // End of variables declaration//GEN-END:variables
}
