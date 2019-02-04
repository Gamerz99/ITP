/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inventory;

import dbconnect.dbconnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author MUNESH
 */
public class Inventory {

    Connection con = dbconnect.connect();
    PreparedStatement pst = null;
    ResultSet rs = null;

    public void supplieradd(String fnamae, String lname, String address1, String address2, String city, String accnum, String bank, String contactnum) {
        String sql3 = "INSERT INTO supplier (FName,LName,AddressLine1,AddressLine2,City,AcountNum,Bank,ContactNum) VALUES ('" + fnamae + "','" + lname + "','" + address1 + "','" + address2 + "','" + city + "','" + accnum + "','" + bank + "','" + contactnum + "')";
        try {
            pst = con.prepareStatement(sql3);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Supplier added", "Good", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void supplierupdate(String supid, String fnamae, String lname, String address1, String address2, String city, String accnum, String bank, String contactnum) {
        String sql3 = "UPDATE supplier SET FName='" + fnamae + "',LName='" + lname + "',AddressLine1='" + address1 + "',AddressLine2='" + address2 + "',City='" + city + "',AcountNum='" + accnum + "',Bank='" + bank + "',ContactNum='" + contactnum + "' WHERE SuplierID='" + supid + "'";
        try {
            pst = con.prepareStatement(sql3);
            pst.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void supplierdelete(String supid) {
        String sql3 = "DELETE FROM supplier WHERE SuplierID='" + supid + "'";
        try {
            pst = con.prepareStatement(sql3);
            pst.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public ResultSet suppliersearch(String search) {
        try {
            String sql4 = "SELECT * FROM supplier where FName like '" + search + "%' ";
            pst = con.prepareStatement(sql4);
            rs = pst.executeQuery();
        } catch (Exception e) {
            System.out.println(e);
        }
        return rs;
    }

    public void rawupdate(String itemname, String amount, String rate, String reorder, String exdate, String nvalue, String itemid, String sid) {
        String sql3 = "UPDATE rawmaterials SET ItemName='" + itemname + "',Amount='" + amount + "',rate='" + rate + "',ReorderLevel='" + reorder + "',ExpireDate='" + exdate + "',TotalValue='" + nvalue + "' WHERE ItemId='" + itemid + "' and SuplierID='" + sid + "'";
        try {
            pst = con.prepareStatement(sql3);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Your Item updated");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void rawdelete(String itemid, String sid) {
        String sql3 = "DELETE FROM rawmaterials WHERE ItemID='" + itemid + "' AND SuplierID ='" + sid + "'";
        try {
            pst = con.prepareStatement(sql3);
            pst.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public ResultSet rawsearch(String search) {
        try {
            String sql4 = "SELECT * FROM rawmaterials WHERE ItemName like '%" + search + "%' ";
            pst = con.prepareStatement(sql4);
            rs = pst.executeQuery();
        } catch (Exception e) {
            System.out.println(e);
        }
        return rs;
    }

    public void rawhandlingresconfirm(String itemid, String nqty, String value, String itemname, String qty, String date, String senddate, String type) {
        String sql1 = "UPDATE dailyorder SET Status='Send' WHERE ItemId = '" + itemid + "'";
        String sql2 = "UPDATE rawmaterials SET Amount='" + nqty + "',TotalValue='" + value + "' WHERE ItemId = '" + itemid + "' AND (Status ='Good' OR Status='Today Expire' OR Status='Ex 1 Day' OR Status='Ex 2 Days')";
        String sql3 = "INSERT INTO orderrecord (ItemId, ItemName,Qty,Date,SendDate,Type,Status) VALUES ('" + itemid + "','" + itemname + "','" + qty + "','" + date + "','" + senddate + "','" + type + "','Send')";
        try {
            pst = con.prepareStatement(sql1);
            pst.execute();
            pst = con.prepareStatement(sql2);
            pst.execute();
            pst = con.prepareStatement(sql3);
            pst.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void rawhandlingwedconfirm(String itemid, String nqty, String value, String itemname, String qty, String date, String senddate, String type) {
        String sql1 = "UPDATE eventorder SET Status='Send' WHERE ItemId = '" + itemid + "'";
        String sql2 = "UPDATE rawmaterials SET Amount='" + nqty + "',TotalValue='" + value + "' WHERE ItemId = '" + itemid + "' AND (Status ='Good' OR Status='Today Expire' OR Status='Ex 1 Day' OR Status='Ex 2 Days')";
        String sql3 = "INSERT INTO orderrecord (ItemId, ItemName,Qty,Date,SendDate,Type,Status) VALUES ('" + itemid + "','" + itemname + "','" + qty + "','" + date + "','" + senddate + "','" + type + "','Send')";
        try {
            pst = con.prepareStatement(sql1);
            pst.execute();
            pst = con.prepareStatement(sql2);
            pst.execute();
            pst = con.prepareStatement(sql3);
            pst.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    public ResultSet rawhandlingsearch(String search) {
        try {
            String sql4 = "SELECT ItemId, ItemName, Qty, Date,SendDate,Type, Status FROM orderrecord where SendDate like '%" + search + "%' ";
            pst = con.prepareStatement(sql4);
            rs = pst.executeQuery();

        } catch (Exception e) {
            System.out.println(e);
        }
        return rs;
    }

    public void addequipment(String eqname, String brand, String qty, String rate, String value, String senddate) {
        String sql3 = "INSERT INTO equipmet ( EquipmentName,Manufacture,Qty,PriceRate,TotalValue,Date) VALUES ('" + eqname + "','" + brand + "','" + qty + "','" + rate + "','" + value + "','" + senddate + "')";
        try {
            pst = con.prepareStatement(sql3);
            pst.execute();
            JOptionPane.showMessageDialog(null, "New Equipment added");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void updateequipment(String eqid, String eqname, String brand, String qty, String rate, String value, String senddate) {
        String sql3 = "UPDATE equipmet SET EquipmentName='" + eqname + "' ,Manufacture='" + brand + "',Qty='" + qty + "',PriceRate='" + rate + "',TotalValue='" + value + "' WHERE EquipmentId='" + eqid + "'";
        try {
            pst = con.prepareStatement(sql3);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Your Equipment updated");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void deleteequipment(String eqid) {
        String sql = "DELETE FROM equipmet WHERE EquipmentId='" + eqid + "' ";
        try {
            pst = con.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Your Equipment Deleted");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public ResultSet searchequipment(String search) {
        try {
            String sql4 = "SELECT * FROM equipmet WHERE EquipmentName like '" + search + "%' ";
            pst = con.prepareStatement(sql4);
            rs = pst.executeQuery();

        } catch (Exception e) {
            System.out.println(e);
        }
        return rs;
    }

    public void confirmeqhandling(String eqid, String eqname, String qty, String senddate, String time, String type, String nqty, String nvalue) {
        String sql1 = "UPDATE equipmentorder SET Status='Send' WHERE EquipmentId = '" + eqid + "' and Date='" + senddate + "' and Time='" + time + "'";
        String sql2 = "INSERT INTO equipmetout (EquipmentId, EquipmentName,Qty,Date,Time ,Type) VALUES ('" + eqid + "','" + eqname + "','" + qty + "','" + senddate + "','" + time + "','" + type + "')";
        String sql3 = "INSERT INTO eorderrecord (EquipmentId, EquipmentName,Qty,Date,SendDate,Time ,Type,Status) VALUES ('" + eqid + "','" + eqname + "','" + qty + "','" + senddate + "','" + senddate + "','" + time + "','" + type + "','Send')";
        String sql4 = "UPDATE equipmet SET Qty='" + nqty + "',TotalValue='" + nvalue + "' WHERE EquipmentId = '" + eqid + "' AND EquipmentName ='" + eqname + "'";
        try {
            pst = con.prepareStatement(sql1);
            pst.execute();
            pst = con.prepareStatement(sql2);
            pst.execute();
            pst = con.prepareStatement(sql3);
            pst.execute();
            pst = con.prepareStatement(sql4);
            pst.execute();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    
}
