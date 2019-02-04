/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customer;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author DELL
 */
public class GMailclient {
    private String user = "";
    private String pass= ""; 

     GMailclient(String to, String sub,String mseg)
    {
        Properties prop = new Properties();
        prop.put("mail.smtp.ssl.trust","smtp.gmail.com");
        prop.put("mail.smtp.auth",true);
        prop.put("mail.smtp.starttls.enable",true);
        prop.put("mail.smtp.host","smtp.gmail.com");
        prop.put("mail.smtp.port","587");
    
        Session ses = Session.getInstance(prop,new javax.mail.Authenticator()
        {
            protected javax.mail.PasswordAuthentication getPasswordAuthentication()
            {
            return new javax.mail.PasswordAuthentication(user,pass); 
            
            }
            
        });
        
    try
    {
        Message msg = new MimeMessage(ses);
        msg.setFrom(new InternetAddress("no-reply@gmail.com"));
    
        msg.setRecipients(Message.RecipientType.TO,InternetAddress.parse(to) );
        msg.setSubject(sub);
        msg.setText(mseg);
        Transport.send(msg);
    
        System.out.print("Message Sent");
    
    }
    catch(MessagingException e)
    {    System.out.print(e);
         throw new RuntimeException(e);
    
    }
    }
    
}
