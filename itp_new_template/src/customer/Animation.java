/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customer;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;

/**
 *
 * @author DELL
 */
public class Animation extends javax.swing.JInternalFrame {

    int x=0, y=250;
    
        public void paint(Graphics g)
        {
            super.paint(g);
            Graphics2D g2=(Graphics2D)g;
            Font font=new Font("Times New Roman",Font.BOLD+Font.PLAIN,80);
            g2.setFont(font);
            g2.setColor(Color.white);
            g2.drawString("          Welcome to", x, y);            
            g2.drawString(" Customer  Management", x, 400);
            
            try 
            {
                Thread.sleep(80);
            } 
            catch (Exception e) 
            {
                
            }
            
            x+=5;
            if(x>this.getWidth())
            {
                x=0;
            }
            repaint();
        }
        
         public static void main(String args[])
        {
            JFrame jf=new JFrame("Animation");
            jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            jf.setSize(700,200);
            jf.add(new Animation());
            jf.setVisible(true);
        }
        
         public Animation() 
        {
            initComponents();
        }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/customer/images/animation.jpg"))); // NOI18N
        jLabel2.setText(" ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1580, 890));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
private javax.swing.JLabel jLabel1;
}
