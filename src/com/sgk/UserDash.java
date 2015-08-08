/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *
 * @author shemul
 * 
 */

package com.sgk;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * This is the class of individual's , this class handle gui of Faculty Status update operations
 * @author shemul
 * @version 1.2.3
 */
public class UserDash extends JFrame {
    
        Info in;
        private JTextField available;
        private JLabel availableLabel;
        private JButton close;
        private JTextField comment;
        private JTextField goneFor;
        private JLabel goneForLabel;
        private JLabel header;
        private JLabel noteLabel;
        private JButton setStatus;
        private JLabel status;
        private JLabel user_id;
        private JLabel welcomeTxt;

    public UserDash(int id) {
            
            /**
            * Public Constructor of UserDash Class 
            * 
            */
            
            Action ac = new Action();
            in = ac.getIndividual(id);

            setContentPane(new JLabel(new ImageIcon("assets/userDash.jpg")));
            setLayout(null);
            setResizable(false);
            setTitle("Status Update");
            setSize(800, 600);
            initComp();

            setLocationRelativeTo(null);
            
            addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent windowEvent) {
                        setVisible(false);
                        new Login().setVisible(true);
                    }
            });
    }
        
    /**
     *
     */
    public void initComp() {
       
        /**
        *  This method will initialize and add proper Swing/Awt component 
        * 
        *  
        */       
        
        header          = new JLabel();
        welcomeTxt      = new JLabel();
        user_id         = new JLabel();
        availableLabel  = new JLabel();
        goneFor         = new JTextField();
        goneForLabel    = new JLabel();
        available       = new JTextField();
        noteLabel       = new JLabel();
        comment         = new JTextField();
        setStatus       = new JButton();
        close           = new JButton();
        status          = new JLabel();
        
        
        header.setFont(new Font("Segoe UI Light", 0, 24)); // NOI18N
        header.setForeground(new Color(255, 255, 255));
        header.setHorizontalAlignment(SwingConstants.CENTER);
        header.setText("update your status");
        header.setBounds(580, 40, 186, 41);
        
        
        welcomeTxt.setFont(new Font("Segoe UI Light", 0, 24)); // NOI18N
        welcomeTxt.setForeground(new Color(255, 255, 255));
        welcomeTxt.setText("welcome , you");
        welcomeTxt.setBounds(36, 90, 250, 31);
        welcomeTxt.setText("welcome , " + in.getName());
        
        
        user_id.setFont(new Font("Segoe UI", 0, 12)); // NOI18N
        user_id.setForeground(new Color(255, 255, 255));
        user_id.setText("@id 2556");
        user_id.setBounds(37, 132, 46, 14);
        user_id.setText("@"+in.getID());
        
        
        goneForLabel.setFont(new Font("Segoe UI Light", 0, 24)); // NOI18N
        goneForLabel.setForeground(new Color(255, 255, 255));
        goneForLabel.setText("I'm gone for");
        goneForLabel.setBounds(37, 167, 134, 31);
        
        goneFor.setFont(new Font("Segoe UI Light", 0, 24)); // NOI18N
        goneFor.setBorder(BorderFactory.createTitledBorder(""));
        goneFor.setBounds(36, 208, 730, 41);
        goneFor.setText(in.getGoneFor());
       
        
        availableLabel.setFont(new Font("Segoe UI Light", 0, 24)); // NOI18N
        availableLabel.setForeground(new Color(255, 255, 255));
        availableLabel.setText("and I'll available at");
        availableLabel.setBounds(36, 265, 250, 31);
        
        
        available.setFont(new Font("Segoe UI Light", 0, 24)); // NOI18N
        available.setBorder(BorderFactory.createTitledBorder(""));
        available.setBounds(36, 304, 730, 41);
        available.setText(in.getAvaible());
        
        noteLabel.setFont(new Font("Segoe UI Light", 0, 24)); // NOI18N
        noteLabel.setForeground(new Color(255, 255, 255));
        noteLabel.setText("note");
        noteLabel.setBounds(37, 366, 134, 31);

        comment.setFont(new Font("Segoe UI Light", 0, 24)); // NOI18N
        comment.setBorder(BorderFactory.createTitledBorder(""));
        comment.setBounds(36, 409, 730, 41);
        comment.setText(in.getComment());
        
        
        setStatus.setForeground(new Color(225, 225, 225));
        setStatus.setText("set status");
        setStatus.setActionCommand("");
        setStatus.setBorder(BorderFactory.createTitledBorder(""));
        setStatus.setOpaque(false);
        setStatus.setContentAreaFilled(false);
        setStatus.setBounds(259, 484, 105, 41);
        setStatus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                setStatusActionPerformed(evt);
            }
        });

        close.setForeground(new Color(255, 255, 255));
        close.setText("Exit");
        close.setBounds(374, 484, 105, 41);
        close.setActionCommand("");
        close.setBorder(BorderFactory.createTitledBorder(""));
        close.setOpaque(false);
        close.setContentAreaFilled(false);
       
        close.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                    setVisible(false);
                    new Login().setVisible(true);
            }
        });

        status.setFont(new Font("Segoe UI Light", 0, 12)); // NOI18N
        status.setHorizontalAlignment(SwingConstants.CENTER);
        status.setText("Status");
        status.setBounds(347, 536, 200, 14);
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
    
    private void setStatusActionPerformed(ActionEvent evt) {                 
        
        Action ac = new Action() ;
        String updateStatus = ac.statusUpdate(in.getID(), goneFor.getText(), available.getText(), comment.getText());
        status.setVisible(true);
        status.setForeground(Color.GREEN);
        status.setText(updateStatus);
    }                                         
    
}

