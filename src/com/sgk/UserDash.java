/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *
 * @author shemul
 */

package com.sgk;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author shemul
 */
public class UserDash extends javax.swing.JFrame {
    
        Info in;
        private javax.swing.JTextField available;
        private javax.swing.JLabel availableLabel;
        private javax.swing.JButton close;
        private javax.swing.JTextField comment;
        private javax.swing.JTextField goneFor;
        private javax.swing.JLabel goneForLabel;
        private javax.swing.JLabel header;
        private javax.swing.JLabel noteLabel;
        private javax.swing.JButton setStatus;
        private javax.swing.JLabel status;
        private javax.swing.JLabel user_id;
        private javax.swing.JLabel welcomeTxt;

    
        public UserDash(int id) {
            Action ac = new Action();
            in = ac.getIndividual(id);

            setContentPane(new JLabel(new ImageIcon("assets/userDash.jpg")));
            setLayout(null);
            setResizable(false);
            setTitle("Status Update");
            setSize(800, 600);
            initComp();

            setLocationRelativeTo(null);
            addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                        setVisible(false);
                        new Login().setVisible(true);
                    }
            });
    }
        
    public  void initComp() {
        
        header = new javax.swing.JLabel();
        welcomeTxt = new javax.swing.JLabel();
        user_id = new javax.swing.JLabel();
        availableLabel = new javax.swing.JLabel();
        goneFor = new javax.swing.JTextField();
        goneForLabel = new javax.swing.JLabel();
        available = new javax.swing.JTextField();
        noteLabel = new javax.swing.JLabel();
        comment = new javax.swing.JTextField();
        setStatus = new javax.swing.JButton();
        close = new javax.swing.JButton();
        status = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        header.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        header.setForeground(new java.awt.Color(255, 255, 255));
        header.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        header.setText("update your status");
        header.setBounds(580, 40, 186, 41);
        
        
        welcomeTxt.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        welcomeTxt.setForeground(new java.awt.Color(255, 255, 255));
        welcomeTxt.setText("welcome , you");
        welcomeTxt.setBounds(36, 106, 159, 31);
        welcomeTxt.setText("welcome , " + in.getName());
        
        
        user_id.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        user_id.setForeground(new java.awt.Color(255, 255, 255));
        user_id.setText("@id 2556");
        user_id.setBounds(37, 132, 46, 14);
        user_id.setText("@"+in.getID());
        
        
        goneForLabel.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        goneForLabel.setForeground(new java.awt.Color(255, 255, 255));
        goneForLabel.setText("I'm gone for");
        goneForLabel.setBounds(37, 167, 134, 31);
        
        goneFor.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        goneFor.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        goneFor.setBounds(36, 208, 730, 41);
        goneFor.setText(in.getGoneFor());
       
        
        availableLabel.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        availableLabel.setForeground(new java.awt.Color(255, 255, 255));
        availableLabel.setText("and I'll available at");
        availableLabel.setBounds(36, 265, 250, 31);
        
        
        available.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        available.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        available.setBounds(36, 304, 730, 41);
        available.setText(in.getAvaible());
        
        noteLabel.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        noteLabel.setForeground(new java.awt.Color(255, 255, 255));
        noteLabel.setText("note");
        noteLabel.setBounds(37, 366, 134, 31);

        comment.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        comment.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        comment.setBounds(36, 409, 730, 41);
        comment.setText(in.getComment());
        
        
        setStatus.setForeground(new Color(225, 225, 225));
        setStatus.setText("set status");
        setStatus.setActionCommand("");
        setStatus.setBorder(BorderFactory.createTitledBorder(""));
        setStatus.setOpaque(false);
        setStatus.setContentAreaFilled(false);
        setStatus.setBounds(259, 484, 105, 41);
        setStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setStatusActionPerformed(evt);
            }
        });

        close.setForeground(new java.awt.Color(255, 255, 255));
        close.setText("Exit");
        close.setBounds(374, 484, 105, 41);
        close.setActionCommand("");
        close.setBorder(BorderFactory.createTitledBorder(""));
        close.setOpaque(false);
        close.setContentAreaFilled(false);
       
        close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeActionPerformed(evt);
            }
        });

        status.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        status.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        status.setText("Status");
        status.setBounds(347, 536, 46, 14);
        status.setVisible(false);
        
        add(header);
        add(welcomeTxt);
        add(user_id);
        add(goneForLabel);
        add(goneFor);
        add(availableLabel);
        add(available);
        add(noteLabel);
        add(comment);
        add(setStatus);
        add(close);
        add(status);
        
    }
    private void closeActionPerformed(ActionEvent evt) {                                      
        
        setVisible(false);
        new Login().setVisible(true);
    }                                     

    private void setStatusActionPerformed(ActionEvent evt) {                                          
        Action ac = new Action() ;
        String updateStatus = ac.statusUpdate(in.getID(), goneFor.getText(), available.getText(), comment.getText());
        status.setVisible(true);
        status.setForeground(Color.GREEN);
        status.setText(updateStatus);
    }                                         
    public static void main(String[] args) {
        new UserDash(2).setVisible(true);
    }
}

