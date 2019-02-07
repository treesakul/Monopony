/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopony;

import java.util.*;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author visio
 */
public class Dices extends javax.swing.JPanel {

    private ImageIcon default_img;
    ImageIcon img1 = new ImageIcon("C:\\Users\\visio\\Documents\\NetBeansProjects\\Monopony\\src\\Pic\\d1.png");
        ImageIcon img2 = new ImageIcon("C:\\Users\\visio\\Documents\\NetBeansProjects\\Monopony\\src\\Pic\\d2.png");
        ImageIcon img3 = new ImageIcon("C:\\Users\\visio\\Documents\\NetBeansProjects\\Monopony\\src\\Pic\\d3.png");
        ImageIcon img4 = new ImageIcon("C:\\Users\\visio\\Documents\\NetBeansProjects\\Monopony\\src\\Pic\\d4.png");
        ImageIcon img5 = new ImageIcon("C:\\Users\\visio\\Documents\\NetBeansProjects\\Monopony\\src\\Pic\\d5.png");
        ImageIcon img6 = new ImageIcon("C:\\Users\\visio\\Documents\\NetBeansProjects\\Monopony\\src\\Pic\\d6.png");
        ImageIcon[] imgSet = {img1, img2, img3, img4, img5, img6};
    /**
     * Creates new form Dices
     */
    private Player player = null;

    public Dices(Player a) {
        initComponents();
        default_img = new ImageIcon("C:\\Users\\visio\\Documents\\NetBeansProjects\\Monopony\\src\\Pic\\d0.png");
        this.player = a;
        dice1.setIcon(default_img);
        dice2.setIcon(default_img);
        
    }

    public Dices() {
        initComponents();
        default_img = new ImageIcon("C:\\Users\\visio\\Documents\\NetBeansProjects\\Monopony\\src\\Pic\\d0.png");
        this.player = null;
        dice1.setIcon(default_img);
        dice2.setIcon(default_img);
    }

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dice1 = new javax.swing.JLabel();
        dice2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setLayout(null);

        dice1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dice1.setPreferredSize(new java.awt.Dimension(50, 50));
        add(dice1);
        dice1.setBounds(10, 80, 160, 160);

        dice2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dice2.setPreferredSize(new java.awt.Dimension(50, 50));
        add(dice2);
        dice2.setBounds(180, 80, 160, 160);

        jButton1.setText("ROLL");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1);
        jButton1.setBounds(130, 30, 73, 23);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here
        Random rand = new Random();
        int n = rand.nextInt(6) + 1;
        int n1 = rand.nextInt(6) + 1;

        Thread t = new Thread(new Runnable() {
            int i = 0;

            @Override
            public void run() {
                    int n2 = rand.nextInt(6) + 1;
                    for (i = 0; i<15;i++) {
                        n2 = rand.nextInt(6) + 1;
                        dice1.setIcon(imgSet[n2 - 1]);
                        
                        
                        try {
                            Thread.sleep(200);
                        } catch (Exception e) {
                            System.out.println("");
                        }
                       
                    }
                    dice1.setIcon(imgSet[n - 1]);
                }
            

        });
        Thread t1 = new Thread(new Runnable() {
            int j = 0;

            @Override
            public void run() {
                    int n3 = rand.nextInt(6) + 1;
                    while (j < 15) {
                        n3 = rand.nextInt(6) + 1;
                        dice2.setIcon(imgSet[n3 - 1]);
                        try {
                            Thread.sleep(200);
                        } catch (Exception e) {
                            System.out.println("");
                        }
                        j++;

                    }
                    dice2.setIcon(imgSet[n1 - 1]);
                    //sum.setVisible(true);
                    //sum.setText("The total sum is " + (n + n1));
                    player.walk(n + n1);
                    System.out.println(player.getIndex());

                }
            

        });
        t.start();
        t1.start();
        //t.join();
        //t1.join();
    }//GEN-LAST:event_jButton1ActionPerformed
    

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel dice1;
    private javax.swing.JLabel dice2;
    private javax.swing.JButton jButton1;
    // End of variables declaration//GEN-END:variables
}