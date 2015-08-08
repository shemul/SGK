
package com.sgk;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author shemul
 *  
 */
public class AddNew extends javax.swing.JFrame {
    
    Random randomIDGenerator = new Random();
    private JButton close;
    private JComboBox isActive;
    private JComboBox isAdmin;
    private JLabel usernameLabel;
    private JLabel genUserId;
    private JLabel passwordLabel;
    private JLabel header;
    private JLabel isAdminLabel;
    private JLabel activeNowLabel;
    private JPasswordField password;
    private JButton setStatus;
    private JLabel status;
    private JTextField user_id;
    private JTextField username;
    
    
    public AddNew() {
        
        int ranId= randomIDGenerator.nextInt(9999);
	setContentPane(new JLabel(new ImageIcon("assets/userDash.jpg")));
        setLayout(null);
        initComponents();
        
        String[] bool = { "No", "Yes"};
        
        isAdmin.removeAllItems();
        isAdmin.addItem(bool[0]);
        isAdmin.addItem(bool[1]);
        isAdmin.setSelectedIndex(0);
        
        isActive.removeAllItems();
        isActive.addItem(bool[0]);
        isActive.addItem(bool[1]);
        isActive.setSelectedIndex(0);
            
        user_id.setText(ranId + "");
        
        setStatus.setOpaque(false);
        setStatus.setContentAreaFilled(false);
        close.setOpaque(false);
        close.setContentAreaFilled(false);
        status.setVisible(false);
        
        
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Status Update");
        setSize(800, 570);
        setLocationRelativeTo(null);
        setVisible(true);
        addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent windowEvent) {
                    setVisible(false);
                    new Login().setVisible(true);
                }
        });
        
        
        
    }
    
    
    private void initComponents() {

        header =   new JLabel();
        usernameLabel =   new JLabel();
        user_id =   new JTextField();
        genUserId =   new JLabel();
        username =  new JTextField();
        passwordLabel =   new JLabel();
        password =  new JPasswordField();
        setStatus = new JButton();
        close =     new JButton();
        status =    new JLabel();
        isAdminLabel =   new JLabel();
        activeNowLabel =   new JLabel();
        isAdmin =   new JComboBox();
        isActive =  new JComboBox();


        header.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        header.setForeground(new java.awt.Color(255, 255, 255));
        header.setText("add new faculty");
        header.setBounds(610, 30, 159, 32);

        usernameLabel.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        usernameLabel.setForeground(new java.awt.Color(255, 255, 255));
        usernameLabel.setText("choose a username");
        usernameLabel.setBounds(34, 162, 196, 32);
        
        
        user_id.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        user_id.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        user_id.setBounds(34, 105, 730, 46);
         
         
        genUserId.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        genUserId.setForeground(new java.awt.Color(255, 255, 255));
        genUserId.setText("generated id");
        genUserId.setBounds(34, 67, 127, 32);
        
        
        username.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); 
        username.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        username.setBounds(34, 200, 330, 46);
        
        
        passwordLabel.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        passwordLabel.setForeground(new java.awt.Color(255, 255, 255));
        passwordLabel.setText("choose a password too");
        passwordLabel.setBounds(423, 160, 180, 32);
        
        
        password.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        password.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        password.setBounds(420, 200, 340, 46);
        
        
        setStatus.setForeground(new java.awt.Color(255, 255, 255));
        setStatus.setText("add");
        setStatus.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        setStatus.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setStatusActionPerformed(evt);
            }
        });
        setStatus.setBounds(270, 410, 119, 44);

        close.setForeground(new java.awt.Color(255, 255, 255));
        close.setText("Exit");
        close.setBorder(BorderFactory.createTitledBorder(""));
        close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                closeActionPerformed(ae);
            }
        });
        close.setBounds(400, 410, 120, 45);
        
        
        status.setFont(new Font("Segoe UI Light", 0, 12)); // NOI18N
        status.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        status.setText("Status");
        status.setBounds(130, 470, 527, 16);
        
        
        isAdminLabel.setFont(new Font("Segoe UI Light", 0, 24)); // NOI18N
        isAdminLabel.setForeground(new Color(255, 255, 255));
        isAdminLabel.setText("admin account ?");
        isAdminLabel.setBounds(34, 264, 167, 32);
        
        
        activeNowLabel.setFont(new Font("Segoe UI Light", 0, 24)); // NOI18N
        activeNowLabel.setForeground(new Color(255, 255, 255));
        activeNowLabel.setText("activate now ?");
        activeNowLabel.setBounds(420, 260, 213, 32);
        
        
        isAdmin.setFont(new Font("Segoe UI Light", 0, 24)); // NOI18N
        isAdmin.setBounds(34, 302, 330, 46);
        
         
        isActive.setFont(new Font("Segoe UI Light", 0, 24)); // NOI18N
        isActive.setBounds(420, 300, 340, 46);
        
        add(header);
        add(genUserId);
        add(user_id);
        add(usernameLabel);
        add(username);
        add(passwordLabel);
        add(password);
        add(isAdmin);
        add(isAdmin);
        add(activeNowLabel);
        add(isAdminLabel);
        add(isActive);
        add(setStatus);
        add(close);
    }             

    private void closeActionPerformed(ActionEvent evt) {                                      
        // TODO add your handling code here:
        setVisible(false);
        new Login().setVisible(true);
    }                                     

    private void setStatusActionPerformed(ActionEvent evt) {                                          
        // TODO add your handling code here:
        
        Action ac = new Action() ;
        
        int IntisAdmin ;
        int intIsActivate;
        
        String StrIsAdmin = isAdmin.getSelectedItem().toString();
        String StrIsActivate = isActive.getSelectedItem().toString();
        
        IntisAdmin = tellMeBool(StrIsAdmin);
        intIsActivate = tellMeBool(StrIsActivate);
        
        
        String updateStatus = ac.addFaculty(user_id.getText(),username.getText(),password.getText(),IntisAdmin,intIsActivate); 
    
        status.setVisible(true);
        status.setForeground(Color.GREEN);
        status.setText(updateStatus);
        user_id.setText(randomIDGenerator.nextInt(9999) + "");
    }                                         
    
    private int tellMeBool(String s) {
        int a =0;
        switch(s) {
            case "Yes" :
                a =  1;
                break ;
            case "No" :
                a = 0;
                break;
        }
        return a ;
    }
   

}

