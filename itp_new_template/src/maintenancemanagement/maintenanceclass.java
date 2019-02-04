/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maintenancemanagement;

import dbconnect.dbconnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Shihan
 */
public class maintenanceclass {
    
    Connection con = dbconnect.connect();
    PreparedStatement pst = null;
    ResultSet rs = null;
   
    //////////////////////////////////////////vehicle//////////////////////////////////////////
    public void addvehicle(String vnmbr,String make,String model,String yr,String tyc,String seat)
    {
     String sqveh="INSERT INTO vehicledetails(VehicleNo,Make,Model,Year,Type,Seats) VALUES ('"+vnmbr+"','"+make+"','"+model+"','"+yr+"','"+tyc+"','"+seat+"')";
            
            try{
                    pst=con.prepareStatement(sqveh);
                    pst.execute();
                    //JOptionPane.showConfirmDialog(null, "Date Added");
    
            }
            catch(Exception e){
                    JOptionPane.showConfirmDialog(null, e);
            }
    }
    
    public void removevehicle(String VehicleNmbr)
    {
        try{
                    String sqdel="DELETE FROM vehicledetails WHERE VehicleNo='"+VehicleNmbr+"' "; 
                    pst=con.prepareStatement(sqdel);
                    pst.execute();
                    
    
            }
            catch(Exception e){
                    JOptionPane.showConfirmDialog(null, e);
            } 
    }
    
    public void addrepair(String vehno,String ty,String repdte,String dscrptn,String amount)
    {
        String sqveh="INSERT INTO vehiclerepair(VehicleNo,RepairType,Date,Descreption,Amount) VALUES ('"+vehno+"','"+ty+"','"+repdte+"','"+dscrptn+"','"+amount+"')";

            try{
                pst=con.prepareStatement(sqveh);
                pst.execute();
                //JOptionPane.showConfirmDialog(null, "Date Added");

            }
            catch(Exception e){
                JOptionPane.showConfirmDialog(null, e);
            }
    }
    
    public void updaterepair(String vehno,String ty,String repdte,String dscrptn, String amount,String aa)
    {
        try{
            String sqvrep="UPDATE vehiclerepair SET VehicleNo='"+vehno+"',RepairType='"+ty+"',Date='"+repdte+"',Descreption='"+dscrptn+"',Amount='"+amount+"' WHERE EntryID='"+aa+"' ";
            pst=con.prepareStatement(sqvrep);
            pst.execute();
            JOptionPane.showConfirmDialog(null, "Do you want to update a field?");

        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    
    }
    
    /////////////////////////////////////////////OtherMaintenance//////////////////////////////////////////
    public void addothrmaintenance(String ty,String dscrptn,String repdte, String amount)
    {
        String sqvehrep="INSERT INTO othermaintenance(RepairType,Descreption,Date,Amount) VALUES ('"+ty+"','"+dscrptn+"','"+repdte+"','"+amount+"')";
            
            try{
                    pst=con.prepareStatement(sqvehrep);
                    pst.execute();
                    //JOptionPane.showConfirmDialog(null, "Date Added");
    
            }
            catch(Exception e){
                    JOptionPane.showConfirmDialog(null, e);
            }
    }
    
    public void updtothrmaintenance(String ty,String dscrptn,String othrdte,String amount,String aa)
    {
            try{
            String sqvrep="UPDATE othermaintenance SET RepairType='"+ty+"',Descreption='"+dscrptn+"',Date='"+othrdte+"',Amount='"+amount+"' WHERE EntryID='"+aa+"' ";
            pst=con.prepareStatement(sqvrep);
            pst.execute();
            JOptionPane.showConfirmDialog(null, "Do you want to update a field?");

        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    /////////////////////////////////////////Further//////////////////////////////////////////////////
    public void frthradd(String dscrptn, String frthrcns,String bldrdtls, String amount)
    {
        String sqveh="INSERT INTO furtherconstructions(Descreption,Date,BuilderDetails,Amount) VALUES ('"+dscrptn+"','"+frthrcns+"','"+bldrdtls+"','"+amount+"')";
            
            try{
                    pst=con.prepareStatement(sqveh);
                    pst.execute();
                    //JOptionPane.showConfirmDialog(null, "Date Added");
    
            }
            catch(Exception e){
                    JOptionPane.showMessageDialog(null, e);
            }
    }
    
    public void frthrupdt(String dscrptn,String frthrdte,String bldrdtls,String amount,String aa)
    {
        try{
                    String sqfrthr="UPDATE furtherconstructions SET Descreption='"+dscrptn+"',Date='"+frthrdte+"',BuilderDetails='"+bldrdtls+"',Amount='"+amount+"' WHERE EntryID='"+aa+"' ";
                    pst=con.prepareStatement(sqfrthr);
                    pst.execute();
                    JOptionPane.showConfirmDialog(null, "Do you want to update this field?");
    
            }
            catch(Exception e){
                    JOptionPane.showMessageDialog(null, e);
            }
    }
    
    ////////////////////////////////////////////Cleaning/////////////////////////////////////////////////
    public void clnadd(String roomno,String ty,String status,String clean,String datecln,String nt)
    {
        String sqcln="INSERT INTO cleaning(RoomNo,RoomType,Status,CleanedBy,Date,Note) VALUES ('"+roomno+"','"+ty+"','"+status+"','"+clean+"','"+datecln+"','"+nt+"')";
            
            try{
                    pst=con.prepareStatement(sqcln);
                    pst.execute();
                    //JOptionPane.showConfirmDialog(null, "Date Added");
    
            }
            catch(Exception e){
                    JOptionPane.showConfirmDialog(null, e);
            }
    }
    
    public void clnupdt(String roomnmbr,String ty,String status,String cleanedby,String datecln,String nte,String aa)
    {
        try{
            String sqcln="UPDATE cleaning SET RoomNo='"+roomnmbr+"',RoomType='"+ty+"',Status='"+status+"',CleanedBy='"+cleanedby+"',Date='"+datecln+"',Note='"+nte+"' WHERE EntryID='"+aa+"' ";
            pst=con.prepareStatement(sqcln);
            pst.execute();
            JOptionPane.showConfirmDialog(null, "Do you want to update this field?");

        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    /////////////////////////////////////////////Building///////////////////////////////////////////////
    public void addbldn(String bnmbr,String stries,String area,String other)
    {
        String sqbuild="INSERT INTO buildingdetails(BuildingNo,Stories,Area,OtherRecords) VALUES ('"+bnmbr+"','"+stries+"','"+area+"','"+other+"')";
            
            try{
                    pst=con.prepareStatement(sqbuild);
                    pst.execute();
                    //JOptionPane.showConfirmDialog(null, "Item Added ");
    
            }
            catch(Exception e){
                    JOptionPane.showConfirmDialog(null, e);
            }
    }

    public void updtbldn(String bldnno,String stries,String area,String other)
    {
        try{
                    String sqaddbldn="UPDATE buildingdetails SET Stories='"+stries+"',Area='"+area+"',OtherRecords='"+other+"' WHERE BuildingNo='"+bldnno+"' ";
                    pst=con.prepareStatement(sqaddbldn);
                    pst.execute();
                    JOptionPane.showConfirmDialog(null, "Do you want to update this field?");
    
            }
            catch(Exception e){
                    JOptionPane.showMessageDialog(null, e+"hhhhh");
            }
    }

    public void addbldnrep(String bn,String dscrptn,String amount)
    {
        String sqbldrep="INSERT INTO buildingrepair(BuildingNo,Descreption,Amount) VALUES ('"+bn+"','"+dscrptn+"','"+amount+"')";
            
            try{
                    pst=con.prepareStatement(sqbldrep);
                    pst.execute();
                    //JOptionPane.showConfirmDialog(null, "Date Added");
    
            }
            catch(Exception e){
                    JOptionPane.showConfirmDialog(null, e);
            }
    }
    
    public void updtbldrep(String bnm,String dscrptn,String amount,String aa)
    {
        try{
                    String sqbldn="UPDATE buildingrepair SET BuildingNo='"+bnm+"',Descreption='"+dscrptn+"',Amount='"+amount+"' WHERE EntryID='"+aa+"' ";
                    pst=con.prepareStatement(sqbldn);
                    pst.execute();
                    JOptionPane.showConfirmDialog(null, "Do you want to update this field?");
    
            }
            catch(Exception e){
                    JOptionPane.showMessageDialog(null, e);
            }
    }
    
   /////////////////////////////////////////License///////////////////////////////////
    public void licnif(String licndate,String licndateex,String amntl,String vnmbr)
    {
        String sqlic="UPDATE license SET LicenseRenewedOn='"+licndate+"',LicenseExpiresOn='"+licndateex+"',Amount='"+amntl+"' WHERE VehicleNo='"+vnmbr+"'";

                try{
                    pst=con.prepareStatement(sqlic);
                    pst.execute();
                    

                }
                catch(Exception e){
                    JOptionPane.showMessageDialog(null, e);
                }
                
    }
    
    public void licnelse(String vnmbr,String licndate,String licndateex,String amntl)
    {
        String sqlic="INSERT INTO license(VehicleNo,LicenseRenewedOn,LicenseExpiresOn,Amount) VALUES ('"+vnmbr+"','"+licndate+"','"+licndateex+"','"+amntl+"')";

                try{
                    pst=con.prepareStatement(sqlic);
                    pst.execute();
                    //JOptionPane.showConfirmDialog(null, "License Details Inserted ");
                    
                }
                catch(Exception e){
                    JOptionPane.showConfirmDialog(null, e);
                }
                

    }
    
    ////////////////////////////insurance///////////////////////////
    public void insif(String insdate,String insdateex,String amntins,String vnmbrins)
    {
        String sqins="UPDATE insurance SET InsuranceRenewedOn='"+insdate+"',InsuranceExpiresOn='"+insdateex+"',Amount='"+amntins+"' WHERE VehicleNo='"+vnmbrins+"' ";

                try{
                    pst=con.prepareStatement(sqins);
                    pst.execute();
                    

                }
                catch(Exception e){
                    JOptionPane.showMessageDialog(null, e);
                }
    }
    
    public void inselse(String vnmbrins,String insdate,String insdateex,String amntins)
    {
                String sqins="INSERT INTO insurance(VehicleNo,InsuranceRenewedOn,InsuranceExpiresOn,Amount) VALUES ('"+vnmbrins+"','"+insdate+"','"+insdateex+"','"+amntins+"')";

                try{
                    pst=con.prepareStatement(sqins);
                    pst.execute();
                    

                }
                catch(Exception e){
                    JOptionPane.showConfirmDialog(null, e);
                }
    }
    
    
    
    


    
    
    
    
}
