package Inventory;

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


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author MUNESH
 */
public class InventoryMain extends javax.swing.JFrame {

    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    int log;
    String logname;

    public InventoryMain() {
        initComponents();
        con = dbconnect.connect();
        today.setText(showDate());
        showTime();
        expired();
        restaurent();
        party();
        wedding();
        ewedding();
        eparty();
        rawcount();
        ocount();
        excount();
        ecount();
        ccount();
        String pic = "/Inventory/imgs/user.png";
        ImageIcon II = new ImageIcon(getClass().getResource(pic));
        user.setIcon(II);
        title.setText("Inventory Main");
        if (dailytable() || eventtable()) {
            ImageIcon III = new ImageIcon(getClass().getResource("/Inventory/imgs/rawhandling_msg.png"));
            rawicon.setIcon(III);
        } else {
            ImageIcon III = new ImageIcon(getClass().getResource("/Inventory/imgs/rawhandling.png"));
            rawicon.setIcon(III);
        }
        if (equipmentoredr()) {
            ImageIcon III = new ImageIcon(getClass().getResource("/Inventory/imgs/equipmenthandling_msg.png"));
            eicon.setIcon(III);
        } else {
            ImageIcon III = new ImageIcon(getClass().getResource("/Inventory/imgs/equipmenthandling.png"));
            eicon.setIcon(III);
        }

        if (reachorder()) {
            ImageIcon III = new ImageIcon(getClass().getResource("/Inventory/imgs/rawmaterials_msg.png"));
            stockicon.setIcon(III);
        } else {
            ImageIcon III = new ImageIcon(getClass().getResource("/Inventory/imgs/rawmaterials.png"));
            stockicon.setIcon(III);
        }
    }
    

    public InventoryMain(int lg, String n) {
        log = lg;
        logname = n;
        initComponents();
        con = dbconnect.connect();
        today.setText(showDate());
        showTime();
        expired();
        restaurent();
        party();
        wedding();
        ewedding();
        eparty();
        rawcount();
        ocount();
        excount();
        ecount();
        ccount();
        name.setText(logname);
        welname.setText(logname);
        String pic = "/Inventory/imgs/user.png";
        
        try {
            String sql = "SELECT Photo FROM empdet where EID='" + logname + "'";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()) {
                byte[] ph=rs.getBytes("photo");
                ImageIcon im=new ImageIcon(ph);
                user.setIcon(im);
            }
        } catch (Exception e) {
        }
        ImageIcon II = new ImageIcon(getClass().getResource(pic));
        user.setIcon(II);
        title.setText("Inventory Main");
        if (dailytable() || eventtable()) {
            ImageIcon III = new ImageIcon(getClass().getResource("/Inventory/imgs/rawhandling_msg.png"));
            rawicon.setIcon(III);
        } else {
            ImageIcon III = new ImageIcon(getClass().getResource("/Inventory/imgs/rawhandling.png"));
            rawicon.setIcon(III);
        }
        if (equipmentoredr()) {
            ImageIcon III = new ImageIcon(getClass().getResource("/Inventory/imgs/equipmenthandling_msg.png"));
            eicon.setIcon(III);
        } else {
            ImageIcon III = new ImageIcon(getClass().getResource("/Inventory/imgs/equipmenthandling.png"));
            eicon.setIcon(III);
        }

        if (reachorder()) {
            ImageIcon III = new ImageIcon(getClass().getResource("/Inventory/imgs/rawmaterials_msg.png"));
            stockicon.setIcon(III);
        } else {
            ImageIcon III = new ImageIcon(getClass().getResource("/Inventory/imgs/rawmaterials.png"));
            stockicon.setIcon(III);
        }
    }

    public boolean dailytable() {
        boolean status = true;
        String today = showDate();
        try {
            String sql = "SELECT * FROM dailyorder where Status='Not send' AND RequiredDate = '" + today + "' ";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()) {
                status = true;
            } else {
                status = false;
            }

        } catch (Exception e) {
        }
        return status;
    }

    public boolean eventtable() {
        boolean status = true;
        String today = showDate();
        try {

            String sql = "SELECT * FROM eventorder where Status='Not send' AND RequiredDate = '" + today + "' ";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()) {
                status = true;
            } else {
                status = false;
            }

        } catch (Exception e) {
        }
        return status;
    }

    public boolean equipmentoredr() {
        boolean status = true;
        String today = showDate();
        try {
            String sql = "SELECT * FROM equipmentorder where Status='Not Send' and Date like '" + today + "'";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()) {
                status = true;
            } else {
                status = false;
            }
        } catch (Exception e) {

        }
        return status;
    }

    public boolean reachorder() {
        boolean status = true;
        try {
            String sql1 = "SELECT * FROM rawmaterials WHERE ReorderLevel >= Amount or ExpireDate < '" + showDate() + "'";
            pst = con.prepareStatement(sql1);
            rs = pst.executeQuery();
            if (rs.next()) {
                status = true;
            } else {
                status = false;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return status;
    }

    public void expired() {

        try {
            String sql = "UPDATE rawmaterials SET Status='Expired' WHERE ExpireDate <'" + showDate() + "'";
            pst = con.prepareStatement(sql);
            pst.execute();
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            String sql = "UPDATE rawmaterials SET Status='Good' WHERE ExpireDate >'" + showDate() + "'";
            pst = con.prepareStatement(sql);
            pst.execute();
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            String sql = "UPDATE rawmaterials SET Status='Today Expire' WHERE DATEDIFF(ExpireDate,'" + showDate() + "')=0";
            String sq2 = "UPDATE rawmaterials SET Status='Ex 1 Day' WHERE DATEDIFF(ExpireDate,'" + showDate() + "')=1";
            String sq3 = "UPDATE rawmaterials SET Status='Ex 2 Days' WHERE DATEDIFF(ExpireDate,'" + showDate() + "')=2";
            pst = con.prepareStatement(sql);
            pst.execute();
            pst = con.prepareStatement(sq2);
            pst.execute();
            pst = con.prepareStatement(sq3);
            pst.execute();
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }

    public void restaurent() {
        String today = showDate();
        try {
            String sql = "SELECT COUNT(ItemId) AS count FROM dailyorder where Status='Not send' AND RequiredDate = '" + today + "' ";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()) {
                if (rs.getString("count").equals("0")) {
                    restaurent.setText("Today you have no oredrs");
                    restaurent.setForeground(new Color(0, 153, 51));
                    ImageIcon III = new ImageIcon(getClass().getResource("/Inventory/imgs/good.png"));
                    ricon.setIcon(III);
                } else {
                    restaurent.setText("Today you have " + rs.getString("count") + " oredrs");
                    restaurent.setForeground(Color.red);
                    ImageIcon III = new ImageIcon(getClass().getResource("/Inventory/imgs/red.png"));
                    ricon.setIcon(III);
                }
            }
        } catch (Exception e) {
        }
    }

    public void party() {
        String today = showDate();
        try {
            String sql = "SELECT COUNT(ItemId) AS count FROM eventorder where Status='Not send' AND RequiredDate = '" + today + "' AND Type='Party' ";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()) {
                if (rs.getString("count").equals("0")) {
                    party.setText("Today you have no oredrs");
                    party.setForeground(new Color(0, 153, 51));
                    ImageIcon III = new ImageIcon(getClass().getResource("/Inventory/imgs/good.png"));
                    picon.setIcon(III);
                } else {
                    party.setText("Today you have " + rs.getString("count") + " oredrs");
                    party.setForeground(Color.red);
                    ImageIcon III = new ImageIcon(getClass().getResource("/Inventory/imgs/red.png"));
                    picon.setIcon(III);
                }
            }
        } catch (Exception e) {
        }
    }

    public void wedding() {
        String today = showDate();
        try {
            String sql = "SELECT COUNT(ItemId) AS count FROM eventorder where Status='Not send' AND RequiredDate = '" + today + "' AND Type='Wedding' ";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()) {
                if (rs.getString("count").equals("0")) {
                    wedding.setText("Today you have no oredrs");
                    wedding.setForeground(new Color(0, 153, 51));
                    ImageIcon III = new ImageIcon(getClass().getResource("/Inventory/imgs/good.png"));
                    wicon.setIcon(III);
                } else {
                    wedding.setText("Today you have " + rs.getString("count") + " oredrs");
                    wedding.setForeground(Color.red);
                    ImageIcon III = new ImageIcon(getClass().getResource("/Inventory/imgs/red.png"));
                    wicon.setIcon(III);
                }
            }
        } catch (Exception e) {
        }
    }

    public void ewedding() {
        String today = showDate();
        try {
            String sql = "SELECT COUNT(EquipmentId) AS count FROM equipmentorder where Status='Not send' AND Date = '" + today + "' AND Type='Wedding' ";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()) {
                if (rs.getString("count").equals("0")) {
                    ewedding.setText("Today you have no oredrs");
                    ewedding.setForeground(new Color(0, 153, 51));
                    ImageIcon III = new ImageIcon(getClass().getResource("/Inventory/imgs/good.png"));
                    ewicon.setIcon(III);
                } else {
                    ewedding.setText("Today you have " + rs.getString("count") + " oredrs");
                    ewedding.setForeground(Color.red);
                    ImageIcon III = new ImageIcon(getClass().getResource("/Inventory/imgs/red.png"));
                    ewicon.setIcon(III);
                }
            }
        } catch (Exception e) {
        }
    }

    public void eparty() {
        String today = showDate();
        try {
            String sql = "SELECT COUNT(EquipmentId) AS count FROM equipmentorder where Status='Not send' AND Date = '" + today + "' AND Type='Party' ";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()) {
                if (rs.getString("count").equals("0")) {
                    eparty.setText("Today you have no oredrs");
                    eparty.setForeground(new Color(0, 153, 51));
                    ImageIcon III = new ImageIcon(getClass().getResource("/Inventory/imgs/good.png"));
                    epicon.setIcon(III);
                } else {
                    eparty.setText("Today you have " + rs.getString("count") + " oredrs");
                    eparty.setForeground(Color.red);
                    ImageIcon III = new ImageIcon(getClass().getResource("/Inventory/imgs/red.png"));
                    epicon.setIcon(III);
                }
            }
        } catch (Exception e) {
        }
    }

    public void rawcount() {
        String today = showDate();
        try {
            String sql = "SELECT COUNT(ItemId) AS count FROM rawmaterials where Status='Good' ";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()) {
                if (rs.getString("count").equals("0")) {
                    rawcount.setText("Your stock have no Items");
                    rawcount.setForeground(Color.RED);
                    ImageIcon III = new ImageIcon(getClass().getResource("/Inventory/imgs/red.png"));
                    rricon.setIcon(III);
                } else {
                    rawcount.setText("Your stock have " + rs.getString("count") + " Items");
                    rawcount.setForeground(new Color(0, 153, 51));
                    ImageIcon III = new ImageIcon(getClass().getResource("/Inventory/imgs/good.png"));
                    rricon.setIcon(III);
                }
            }
        } catch (Exception e) {
        }
    }

    public void ocount() {
        String today = showDate();
        try {
            String sql = "SELECT COUNT(ItemId) AS count FROM rawmaterials where Amount<=ReorderLevel ";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()) {
                if (rs.getString("count").equals("0")) {
                    ostock.setText("Your stock status is good");
                    ostock.setForeground(new Color(0, 153, 51));
                    ImageIcon III = new ImageIcon(getClass().getResource("/Inventory/imgs/good.png"));
                    oicon.setIcon(III);
                } else {
                    ostock.setText("You have " + rs.getString("count") + " out of stock Items");
                    ostock.setForeground(Color.RED);
                    ImageIcon III = new ImageIcon(getClass().getResource("/Inventory/imgs/red.png"));
                    oicon.setIcon(III);
                }
            }
        } catch (Exception e) {
        }
    }

    public void excount() {
        String today = showDate();
        try {
            String sql = "SELECT COUNT(ItemId) AS count FROM rawmaterials where Status='Expired' ";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()) {
                if (rs.getString("count").equals("0")) {
                    exstock.setText("Your stock have no Expired Items");
                    exstock.setForeground(new Color(0, 153, 51));
                    ImageIcon III = new ImageIcon(getClass().getResource("/Inventory/imgs/good.png"));
                    exicon.setIcon(III);
                } else {
                    exstock.setText("Your stock have " + rs.getString("count") + " Expired Items");
                    exstock.setForeground(Color.RED);
                    ImageIcon III = new ImageIcon(getClass().getResource("/Inventory/imgs/bad.png"));
                    exicon.setIcon(III);
                }
            }
        } catch (Exception e) {
        }
    }

    public void ecount() {
        try {
            String sql = "SELECT COUNT(EquipmentId) AS count FROM equipmet";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()) {
                if (rs.getString("count").equals("0")) {
                    ecount.setText("Your stock have no Equipment");
                    ecount.setForeground(Color.RED);
                    ImageIcon III = new ImageIcon(getClass().getResource("/Inventory/imgs/red.png"));
                    eqicon.setIcon(III);
                } else {
                    ecount.setText("Your stock have " + rs.getString("count") + " Equipments");
                    ecount.setForeground(new Color(0, 153, 51));
                    ImageIcon III = new ImageIcon(getClass().getResource("/Inventory/imgs/good.png"));
                    eqicon.setIcon(III);
                }
            }
        } catch (Exception e) {
        }
    }

    public void ccount() {
        try {
            String sql = "SELECT COUNT(CheckID) AS count FROM equipmetout";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()) {
                if (rs.getString("count").equals("0")) {
                    ccount.setText("You have no Check out Equipments");
                    ccount.setForeground(new Color(0, 153, 51));
                    ImageIcon III = new ImageIcon(getClass().getResource("/Inventory/imgs/good.png"));
                    cicon.setIcon(III);
                } else {
                    ccount.setText("You have " + rs.getString("count") + " Check out Equipments");
                    ccount.setForeground(Color.red);
                    ImageIcon III = new ImageIcon(getClass().getResource("/Inventory/imgs/red.png"));
                    cicon.setIcon(III);
                }
            }
        } catch (Exception e) {
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

        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        hallname = new javax.swing.JLabel();
        title = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        logo = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        minimize = new javax.swing.JLabel();
        close = new javax.swing.JLabel();
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
        ehandling = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        eicon = new javax.swing.JLabel();
        rawhandling = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        rawicon = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        mainmenu = new javax.swing.JLabel();
        mainmenuicon = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        rawstock = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        stockicon = new javax.swing.JLabel();
        estock = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        purchasing = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        supplier = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        welname = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        party = new javax.swing.JLabel();
        wedding = new javax.swing.JLabel();
        picon = new javax.swing.JLabel();
        wicon = new javax.swing.JLabel();
        ricon = new javax.swing.JLabel();
        restaurent = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        ewedding = new javax.swing.JLabel();
        ewicon = new javax.swing.JLabel();
        epicon = new javax.swing.JLabel();
        eparty = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        rawcount = new javax.swing.JLabel();
        rricon = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        ostock = new javax.swing.JLabel();
        oicon = new javax.swing.JLabel();
        exstock = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        exicon = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        ecount = new javax.swing.JLabel();
        eqicon = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        ccount = new javax.swing.JLabel();
        cicon = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

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
        hallname.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        hallname.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hallnameMouseClicked(evt);
            }
        });
        jPanel1.add(hallname);
        hallname.setBounds(660, 40, 580, 50);

        title.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        title.setForeground(new java.awt.Color(255, 255, 255));
        title.setText("Inventory Main");
        title.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(title);
        title.setBounds(860, 110, 280, 30);
        jPanel1.add(jSeparator4);
        jSeparator4.setBounds(170, 22, 1580, 10);

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Inventory/imgs/logo.png"))); // NOI18N
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

        ovel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Inventory/imgs/logoutback.png"))); // NOI18N
        ovel.setText(" ");
        jPanel1.add(ovel);
        ovel.setBounds(1750, 30, 100, 100);

        user.setForeground(new java.awt.Color(255, 255, 255));
        user.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Inventory/imgs/munesh.png"))); // NOI18N
        user.setText(" ");
        user.setOpaque(true);
        jPanel1.add(user);
        user.setBounds(1750, 30, 100, 100);

        name.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        name.setForeground(new java.awt.Color(255, 255, 255));
        name.setText("G.G.M Tharinda");
        name.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(name);
        name.setBounds(1750, 130, 100, 20);

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
        home1.add(home);
        home.setBounds(130, 0, 70, 70);

        jPanel2.add(home1);
        home1.setBounds(0, 240, 320, 70);

        logout.setBackground(new java.awt.Color(0, 0, 0));
        logout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        logout.addMouseListener(new java.awt.event.MouseAdapter() {
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
        logout.setBounds(0, 980, 320, 70);

        ehandling.setBackground(new java.awt.Color(0, 0, 0));
        ehandling.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ehandling.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ehandlingMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ehandlingMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ehandlingMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                ehandlingMouseReleased(evt);
            }
        });
        ehandling.setLayout(null);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText(" Equipment Handling");
        ehandling.add(jLabel5);
        jLabel5.setBounds(73, 23, 165, 22);

        eicon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Inventory/imgs/equipmenthandling.png"))); // NOI18N
        eicon.setText(" ");
        ehandling.add(eicon);
        eicon.setBounds(10, 0, 64, 64);

        jPanel2.add(ehandling);
        ehandling.setBounds(0, 410, 320, 70);

        rawhandling.setBackground(new java.awt.Color(0, 0, 0));
        rawhandling.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rawhandling.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                rawhandlingMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                rawhandlingMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rawhandlingMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                rawhandlingMouseReleased(evt);
            }
        });
        rawhandling.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText(" Raw Materials Handling");
        rawhandling.add(jLabel1);
        jLabel1.setBounds(73, 23, 190, 22);

        rawicon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Inventory/imgs/rawhandling.png"))); // NOI18N
        rawicon.setText(" ");
        rawhandling.add(rawicon);
        rawicon.setBounds(10, 0, 64, 64);

        jPanel2.add(rawhandling);
        rawhandling.setBounds(0, 320, 320, 70);
        jPanel2.add(jSeparator1);
        jSeparator1.setBounds(0, 160, 320, 2);

        mainmenu.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        mainmenu.setForeground(new java.awt.Color(255, 255, 255));
        mainmenu.setText("MAIN MENU");
        jPanel2.add(mainmenu);
        mainmenu.setBounds(100, 180, 130, 30);

        mainmenuicon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Inventory/imgs/menu.png"))); // NOI18N
        mainmenuicon.setText(" ");
        jPanel2.add(mainmenuicon);
        mainmenuicon.setBounds(10, 180, 32, 32);
        jPanel2.add(jSeparator2);
        jSeparator2.setBounds(0, 228, 320, 2);

        rawstock.setBackground(new java.awt.Color(0, 0, 0));
        rawstock.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rawstock.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                rawstockMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                rawstockMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rawstockMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                rawstockMouseReleased(evt);
            }
        });
        rawstock.setLayout(null);

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Raw Materials Stock");
        rawstock.add(jLabel11);
        jLabel11.setBounds(80, 20, 163, 22);

        stockicon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Inventory/imgs/rawmaterials.png"))); // NOI18N
        stockicon.setText(" ");
        rawstock.add(stockicon);
        stockicon.setBounds(10, 0, 64, 64);

        jPanel2.add(rawstock);
        rawstock.setBounds(0, 500, 320, 70);

        estock.setBackground(new java.awt.Color(0, 0, 0));
        estock.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        estock.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                estockMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                estockMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                estockMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                estockMouseReleased(evt);
            }
        });
        estock.setLayout(null);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Equipment Stock");
        estock.add(jLabel9);
        jLabel9.setBounds(80, 20, 170, 22);

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Inventory/imgs/equipment.png"))); // NOI18N
        jLabel10.setText(" ");
        estock.add(jLabel10);
        jLabel10.setBounds(10, 0, 64, 64);

        jPanel2.add(estock);
        estock.setBounds(0, 590, 320, 70);

        purchasing.setBackground(new java.awt.Color(0, 0, 0));
        purchasing.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        purchasing.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                purchasingMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                purchasingMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                purchasingMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                purchasingMouseReleased(evt);
            }
        });
        purchasing.setLayout(null);

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Purchasing");
        purchasing.add(jLabel13);
        jLabel13.setBounds(80, 20, 163, 22);

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Inventory/imgs/purchase.png"))); // NOI18N
        jLabel14.setText(" ");
        purchasing.add(jLabel14);
        jLabel14.setBounds(10, 0, 64, 64);

        jPanel2.add(purchasing);
        purchasing.setBounds(0, 680, 320, 70);

        supplier.setBackground(new java.awt.Color(0, 0, 0));
        supplier.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        supplier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                supplierMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                supplierMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                supplierMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                supplierMouseReleased(evt);
            }
        });
        supplier.setLayout(null);

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Supplier");
        supplier.add(jLabel15);
        jLabel15.setBounds(80, 20, 163, 22);

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Inventory/imgs/supplier.png"))); // NOI18N
        jLabel22.setText(" ");
        supplier.add(jLabel22);
        jLabel22.setBounds(10, 0, 64, 64);

        jPanel2.add(supplier);
        supplier.setBounds(0, 770, 320, 70);

        jPanel4.add(jPanel2);
        jPanel2.setBounds(0, 0, 320, 1080);

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));
        jPanel3.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Trajan Pro", 0, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("WELCOME");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel3.add(jLabel2);
        jLabel2.setBounds(470, 10, 280, 50);

        welname.setFont(new java.awt.Font("Trajan Pro", 0, 56)); // NOI18N
        welname.setForeground(new java.awt.Color(255, 255, 255));
        welname.setText(" ");
        jPanel3.add(welname);
        welname.setBounds(820, 10, 410, 50);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(null);

        party.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        party.setForeground(new java.awt.Color(0, 204, 51));
        jPanel5.add(party);
        party.setBounds(210, 250, 300, 30);

        wedding.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        wedding.setForeground(new java.awt.Color(0, 204, 51));
        jPanel5.add(wedding);
        wedding.setBounds(210, 210, 300, 30);

        picon.setText(" ");
        jPanel5.add(picon);
        picon.setBounds(510, 250, 32, 32);

        wicon.setText(" ");
        jPanel5.add(wicon);
        wicon.setBounds(510, 210, 32, 32);

        ricon.setText(" ");
        jPanel5.add(ricon);
        ricon.setBounds(510, 170, 32, 32);

        restaurent.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        restaurent.setForeground(new java.awt.Color(0, 153, 51));
        jPanel5.add(restaurent);
        restaurent.setBounds(210, 170, 300, 30);

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 28)); // NOI18N
        jLabel4.setText("System Status");
        jPanel5.add(jLabel4);
        jLabel4.setBounds(720, 20, 170, 30);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Rawmaterials");
        jPanel5.add(jLabel6);
        jLabel6.setBounds(60, 310, 110, 30);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("Restaurent");
        jPanel5.add(jLabel8);
        jLabel8.setBounds(60, 170, 110, 30);

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setText("Wedding");
        jPanel5.add(jLabel12);
        jLabel12.setBounds(60, 210, 110, 30);

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 153));
        jLabel16.setText("Equipment");
        jPanel5.add(jLabel16);
        jLabel16.setBounds(850, 130, 170, 30);

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 0, 153));
        jLabel17.setText("Raw materials");
        jPanel5.add(jLabel17);
        jLabel17.setBounds(60, 120, 170, 30);

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel18.setText("Wedding");
        jPanel5.add(jLabel18);
        jLabel18.setBounds(850, 170, 110, 30);

        ewedding.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ewedding.setForeground(new java.awt.Color(0, 153, 51));
        jPanel5.add(ewedding);
        ewedding.setBounds(1000, 170, 330, 30);

        ewicon.setText(" ");
        jPanel5.add(ewicon);
        ewicon.setBounds(1330, 170, 32, 32);

        epicon.setText(" ");
        jPanel5.add(epicon);
        epicon.setBounds(1330, 210, 32, 32);

        eparty.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        eparty.setForeground(new java.awt.Color(0, 153, 51));
        jPanel5.add(eparty);
        eparty.setBounds(1000, 210, 330, 30);

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel20.setText("party");
        jPanel5.add(jLabel20);
        jLabel20.setBounds(60, 250, 110, 30);

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel19.setText("Party");
        jPanel5.add(jLabel19);
        jLabel19.setBounds(850, 210, 110, 30);

        rawcount.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        rawcount.setForeground(new java.awt.Color(0, 204, 51));
        jPanel5.add(rawcount);
        rawcount.setBounds(210, 310, 300, 30);

        rricon.setText(" ");
        jPanel5.add(rricon);
        rricon.setBounds(510, 310, 32, 32);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1600, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        jPanel5.add(jPanel6);
        jPanel6.setBounds(0, 80, 1600, 30);

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel23.setText("Out of stock");
        jPanel5.add(jLabel23);
        jLabel23.setBounds(60, 350, 110, 30);

        ostock.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ostock.setForeground(new java.awt.Color(0, 204, 51));
        jPanel5.add(ostock);
        ostock.setBounds(210, 350, 300, 30);

        oicon.setText(" ");
        jPanel5.add(oicon);
        oicon.setBounds(510, 350, 32, 32);

        exstock.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        exstock.setForeground(new java.awt.Color(0, 204, 51));
        jPanel5.add(exstock);
        exstock.setBounds(210, 390, 300, 30);

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel24.setText("Expired");
        jPanel5.add(jLabel24);
        jLabel24.setBounds(60, 390, 110, 30);

        exicon.setText(" ");
        jPanel5.add(exicon);
        exicon.setBounds(510, 390, 32, 32);

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel25.setText("Equipment");
        jPanel5.add(jLabel25);
        jLabel25.setBounds(850, 270, 110, 30);

        ecount.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ecount.setForeground(new java.awt.Color(0, 153, 51));
        jPanel5.add(ecount);
        ecount.setBounds(1000, 270, 330, 30);

        eqicon.setText(" ");
        jPanel5.add(eqicon);
        eqicon.setBounds(1330, 270, 32, 32);

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel26.setText("Check out");
        jPanel5.add(jLabel26);
        jLabel26.setBounds(850, 310, 110, 30);

        ccount.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ccount.setForeground(new java.awt.Color(0, 153, 51));
        jPanel5.add(ccount);
        ccount.setBounds(1000, 310, 330, 30);

        cicon.setText(" ");
        jPanel5.add(cicon);
        cicon.setBounds(1330, 310, 32, 32);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Inventory/imgs/body.jpg"))); // NOI18N
        jLabel3.setText(" ");
        jPanel5.add(jLabel3);
        jLabel3.setBounds(0, 0, 1600, 850);

        jPanel3.add(jPanel5);
        jPanel5.setBounds(0, 70, 1600, 850);

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

    private void rawhandlingMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rawhandlingMouseEntered
        rawhandling.setBackground(Color.BLUE);      
    }//GEN-LAST:event_rawhandlingMouseEntered

    private void rawhandlingMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rawhandlingMouseExited
        rawhandling.setBackground(Color.BLACK);
    }//GEN-LAST:event_rawhandlingMouseExited

    private void rawhandlingMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rawhandlingMousePressed
        rawhandling.setBackground(new Color(10, 122, 192));
    }//GEN-LAST:event_rawhandlingMousePressed

    private void rawhandlingMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rawhandlingMouseReleased
        rawhandling.setBackground(Color.BLACK);
        RawmaterialsHandling s = new RawmaterialsHandling();
        jDesktopPane1.removeAll();
        jDesktopPane1.add(s);
        s.show();
        title.setText("Rawmeterial Handling");
    }//GEN-LAST:event_rawhandlingMouseReleased

    private void ehandlingMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ehandlingMouseEntered
        ehandling.setBackground(Color.BLUE);
    }//GEN-LAST:event_ehandlingMouseEntered

    private void ehandlingMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ehandlingMouseExited
        ehandling.setBackground(Color.BLACK);
    }//GEN-LAST:event_ehandlingMouseExited

    private void ehandlingMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ehandlingMousePressed
        ehandling.setBackground(new Color(10, 122, 192));
    }//GEN-LAST:event_ehandlingMousePressed

    private void ehandlingMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ehandlingMouseReleased
        ehandling.setBackground(Color.BLACK);
        EquipmentHandling s = new EquipmentHandling();
        jDesktopPane1.removeAll();
        jDesktopPane1.add(s);
        s.show();
        title.setText("Equipment Handling");
    }//GEN-LAST:event_ehandlingMouseReleased

    private void rawstockMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rawstockMouseEntered
        rawstock.setBackground(Color.BLUE);
    }//GEN-LAST:event_rawstockMouseEntered

    private void rawstockMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rawstockMouseExited
        rawstock.setBackground(Color.BLACK);
    }//GEN-LAST:event_rawstockMouseExited

    private void rawstockMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rawstockMousePressed
        rawstock.setBackground(new Color(10, 122, 192));
    }//GEN-LAST:event_rawstockMousePressed

    private void rawstockMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rawstockMouseReleased
        rawstock.setBackground(Color.BLACK);
        RawmeterialsStock s = new RawmeterialsStock();
        jDesktopPane1.removeAll();
        jDesktopPane1.add(s);
        s.show();
        title.setText("Rawmeterial Stock Details");
    }//GEN-LAST:event_rawstockMouseReleased

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
        logout.setBackground(Color.BLUE);
    }//GEN-LAST:event_logoutMouseEntered

    private void logoutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutMouseExited
        logout.setBackground(Color.BLACK);
    }//GEN-LAST:event_logoutMouseExited

    private void logoutMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutMousePressed
        logout.setBackground(new Color(10, 122, 192));
    }//GEN-LAST:event_logoutMousePressed

    private void logoutMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutMouseReleased
        logout.setBackground(Color.BLACK);
        log = 0;
        Main.Main m = new Main.Main(0, null);
        m.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_logoutMouseReleased

    private void supplierMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_supplierMouseEntered
        supplier.setBackground(Color.BLUE);
    }//GEN-LAST:event_supplierMouseEntered

    private void supplierMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_supplierMouseExited
        supplier.setBackground(Color.BLACK);
    }//GEN-LAST:event_supplierMouseExited

    private void supplierMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_supplierMousePressed
        supplier.setBackground(new Color(10, 122, 192));
    }//GEN-LAST:event_supplierMousePressed

    private void supplierMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_supplierMouseReleased
        supplier.setBackground(Color.BLACK);
        Supplier s = new Supplier();
        jDesktopPane1.removeAll();
        jDesktopPane1.add(s);
        s.show();
        title.setText("Supplier Details");

    }//GEN-LAST:event_supplierMouseReleased

    private void estockMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_estockMouseEntered
        estock.setBackground(Color.BLUE);
    }//GEN-LAST:event_estockMouseEntered

    private void estockMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_estockMouseExited
        estock.setBackground(Color.BLACK);
    }//GEN-LAST:event_estockMouseExited

    private void estockMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_estockMousePressed
        estock.setBackground(new Color(10, 122, 192));
    }//GEN-LAST:event_estockMousePressed

    private void estockMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_estockMouseReleased
        estock.setBackground(Color.BLACK);
        Equipment s = new Equipment();
        jDesktopPane1.removeAll();
        jDesktopPane1.add(s);
        s.show();
        title.setText("Equipment Stock");
    }//GEN-LAST:event_estockMouseReleased

    private void purchasingMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_purchasingMouseEntered
        purchasing.setBackground(Color.BLUE);
    }//GEN-LAST:event_purchasingMouseEntered

    private void purchasingMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_purchasingMouseExited
        purchasing.setBackground(Color.BLACK);
    }//GEN-LAST:event_purchasingMouseExited

    private void purchasingMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_purchasingMousePressed
        purchasing.setBackground(new Color(10, 122, 192));
    }//GEN-LAST:event_purchasingMousePressed

    private void purchasingMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_purchasingMouseReleased
        purchasing.setBackground(Color.BLACK);
        Purchasing s = new Purchasing();
        jDesktopPane1.removeAll();
        jDesktopPane1.add(s);
        s.show();
        title.setText("Purchasing");
    }//GEN-LAST:event_purchasingMouseReleased

    private void homeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeMouseEntered
        ImageIcon III = new ImageIcon(getClass().getResource("/Inventory/imgs/homehover.png"));
        home.setIcon(III);
    }//GEN-LAST:event_homeMouseEntered

    private void homeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeMouseExited
        ImageIcon III = new ImageIcon(getClass().getResource("/Inventory/imgs/home.png"));
        home.setIcon(III);
    }//GEN-LAST:event_homeMouseExited

    private void homeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeMousePressed
        ImageIcon III = new ImageIcon(getClass().getResource("/Inventory/imgs/homepressed.png"));
        home.setIcon(III);
    }//GEN-LAST:event_homeMousePressed

    private void homeMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeMouseReleased
        ImageIcon II = new ImageIcon(getClass().getResource("/Inventory/imgs/home.png"));
        home.setIcon(II);
        expired();
        restaurent();
        party();
        wedding();
        ewedding();
        eparty();
        rawcount();
        ocount();
        excount();
        ecount();
        ccount();
        if (dailytable() || eventtable()) {
            ImageIcon III = new ImageIcon(getClass().getResource("/Inventory/imgs/rawhandling_msg.png"));
            rawicon.setIcon(III);
        } else {
            ImageIcon III = new ImageIcon(getClass().getResource("/Inventory/imgs/rawhandling.png"));
            rawicon.setIcon(III);
        }
        if (reachorder()) {
            ImageIcon III = new ImageIcon(getClass().getResource("/Inventory/imgs/rawmaterials_msg.png"));
            stockicon.setIcon(III);
        } else {
            ImageIcon III = new ImageIcon(getClass().getResource("/Inventory/imgs/rawmaterials.png"));
            stockicon.setIcon(III);
        }
        if (equipmentoredr()) {
            ImageIcon III = new ImageIcon(getClass().getResource("/Inventory/imgs/equipmenthandling_msg.png"));
            eicon.setIcon(III);
        } else {
            ImageIcon III = new ImageIcon(getClass().getResource("/Inventory/imgs/equipmenthandling.png"));
            eicon.setIcon(III);
        }
        jDesktopPane1.removeAll();
        jDesktopPane1.add(jPanel3);

        jPanel3.show();
        title.setText("Inventory Main");
    }//GEN-LAST:event_homeMouseReleased

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

    private void minimizeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeMouseEntered
        ImageIcon III = new ImageIcon(getClass().getResource("/Inventory/imgs/minimize_hover.png"));
        minimize.setIcon(III);
    }//GEN-LAST:event_minimizeMouseEntered

    private void minimizeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeMouseExited
        ImageIcon III = new ImageIcon(getClass().getResource("/Inventory/imgs/minimize.png"));
        minimize.setIcon(III);
    }//GEN-LAST:event_minimizeMouseExited

    private void minimizeMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeMouseReleased
        this.setState(InventoryMain.ICONIFIED);
    }//GEN-LAST:event_minimizeMouseReleased

    private void hallnameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hallnameMouseClicked
        Main.Main m = new Main.Main(5, logname);
        m.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_hallnameMouseClicked

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
            java.util.logging.Logger.getLogger(InventoryMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InventoryMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InventoryMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InventoryMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InventoryMain().setVisible(true);
//                try {
//                    UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
//                } catch (ClassNotFoundException ex) {
//                    Logger.getLogger(InventoryMain.class.getName()).log(Level.SEVERE, null, ex);
//                } catch (InstantiationException ex) {
//                    Logger.getLogger(InventoryMain.class.getName()).log(Level.SEVERE, null, ex);
//                } catch (IllegalAccessException ex) {
//                    Logger.getLogger(InventoryMain.class.getName()).log(Level.SEVERE, null, ex);
//                } catch (UnsupportedLookAndFeelException ex) {
//                    Logger.getLogger(InventoryMain.class.getName()).log(Level.SEVERE, null, ex);
//                }
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
    private javax.swing.JLabel ccount;
    private javax.swing.JLabel cicon;
    private javax.swing.JLabel close;
    private javax.swing.JLabel ecount;
    private javax.swing.JPanel ehandling;
    private javax.swing.JLabel eicon;
    private javax.swing.JLabel eparty;
    private javax.swing.JLabel epicon;
    private javax.swing.JLabel eqicon;
    private javax.swing.JPanel estock;
    private javax.swing.JLabel ewedding;
    private javax.swing.JLabel ewicon;
    private javax.swing.JLabel exicon;
    private javax.swing.JLabel exstock;
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
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
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
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel logo;
    private javax.swing.JPanel logout;
    private javax.swing.JLabel mainmenu;
    private javax.swing.JLabel mainmenuicon;
    private javax.swing.JLabel minimize;
    private javax.swing.JLabel name;
    private javax.swing.JLabel oicon;
    private javax.swing.JLabel ostock;
    private javax.swing.JLabel ovel;
    private javax.swing.JLabel party;
    private javax.swing.JLabel picon;
    private javax.swing.JPanel purchasing;
    private javax.swing.JLabel rawcount;
    private javax.swing.JPanel rawhandling;
    private javax.swing.JLabel rawicon;
    private javax.swing.JPanel rawstock;
    private javax.swing.JLabel restaurent;
    private javax.swing.JLabel ricon;
    private javax.swing.JLabel rricon;
    private javax.swing.JLabel stockicon;
    private javax.swing.JPanel supplier;
    private javax.swing.JLabel time;
    private javax.swing.JLabel title;
    private javax.swing.JLabel today;
    private javax.swing.JLabel user;
    private javax.swing.JLabel wedding;
    private javax.swing.JLabel welname;
    private javax.swing.JLabel wicon;
    // End of variables declaration//GEN-END:variables
}
