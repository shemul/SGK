/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * 
 * author Shemul 
 */

package com.sgk;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.FontUIResource;


public class Login extends JFrame {
    
    JLabel secureLoginLabel = new JLabel();
    JLabel usernameLabel = new JLabel();
    JTextField txtUsername = new JTextField();
    JLabel passwordLabel = new JLabel();
    JPasswordField txtPassword = new JPasswordField();
    JButton btnLogin = new JButton();
    JButton btnCancel = new JButton();
    JLabel status = new JLabel();
    JLabel versionLabel = new JLabel();

        
    public Login() {
        
        setContentPane(new JLabel(new ImageIcon("assets/login.jpg")));
        setLayout(null);
        initComp();        
	setSize(500,500);   
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Login");
        setAlwaysOnTop(true);
        setResizable(false);

        setLocationRelativeTo(null); //for centerized the frame
        
    }

    public void initComp() {

        secureLoginLabel.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        secureLoginLabel.setForeground(new ColorUIResource(Color.WHITE));
        secureLoginLabel.setHorizontalAlignment(SwingConstants.CENTER);
        secureLoginLabel.setText("secure login");
        secureLoginLabel.setBounds(148, 29, 176, 57);
        
        
        versionLabel.setForeground(new Color(255, 255, 255));
        versionLabel.setHorizontalAlignment(SwingConstants.CENTER);
        versionLabel.setText("version : 1.0");
        versionLabel.setBounds(201, 86, 70, 14);
        
        
        usernameLabel.setFont(new FontUIResource("Segoe UI Light", 0, 28)); // NOI18N
        usernameLabel.setForeground(new ColorUIResource(255, 255, 255));
        usernameLabel.setText("username");
        usernameLabel.setBounds(70, 130, 128, 32);
        
        txtUsername.setFont(new FontUIResource("Segoe UI Light", 0, 24)); // NOI18N
        txtUsername.setBounds(70, 173, 346, 50);
        
        
        passwordLabel.setFont(new FontUIResource("Segoe UI Light", 0, 28)); // NOI18N
        passwordLabel.setForeground(new ColorUIResource(255, 255, 255));
        passwordLabel.setText("password");
        passwordLabel.setBounds(70, 232, 161, 33);
        
        
        txtPassword.setFont(new FontUIResource("Segoe UI Light", 0, 24)); // NOI18N
        txtPassword.setBounds(70, 278, 341, 50);
        
        
        btnLogin.setForeground(new Color(225, 225, 225));
        btnLogin.setText("Login");
        btnLogin.setBounds(146, 358, 89, 42);           
        btnLogin.setBorder(BorderFactory.createTitledBorder(""));
        btnLogin.setOpaque(false);
        btnLogin.setContentAreaFilled(false);
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
               LoginBtn();
            }
        });

        btnCancel.setForeground(new Color(255, 255, 255));
        btnCancel.setText("Exit");
        btnCancel.setOpaque(false);
        btnCancel.setContentAreaFilled(false);
        btnCancel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        btnCancel.setBounds(251, 358, 89, 42);
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.exit(1);
            }
        });

        status.setFont(new FontUIResource("Segoe UI Light", 0, 12)); // NOI18N
        status.setHorizontalAlignment(SwingConstants.CENTER);
        status.setText("Status");
        status.setBounds(163, 436, 161, 14);
        status.setVisible(false);
        
        add(secureLoginLabel);
        add(versionLabel);
        add(usernameLabel);
        add(txtUsername);
        add(passwordLabel);
        add(txtPassword);
        add(btnLogin);
        add(btnCancel);
        add(status);
        
        
    }

    public void LoginBtn() {
        
        
        if(txtUsername.getText().equals("") || txtPassword.getText().equals("")){
            status.setForeground(Color.yellow);
            status.setText("Please input Details");
            status.setVisible(true);
            
        } else {
            Action ac = new Action();
            Info loggedInUser = new Info();
            try {
                loggedInUser = ac.getLoginData(txtUsername.getText(), txtPassword.getText());
                //System.out.println(loginStatus);
                if (ServiceHandler.exceptions != null ){
                    status.setVisible(true);
                    status.setForeground(Color.pink);
                    status.setText("Network communication unavailable");
                }
                switch(loggedInUser.getLoginStatusCode()){
                    case 1:
                        Dash ds = new Dash();
                        ds.setVisible(true);
                        this.setVisible(false);
                        break;
                    case 2 :
                       
                        UserDash ud = new UserDash(loggedInUser.getID());
                        ud.setVisible(true);
                        this.setVisible(false);
                        break;
                    case 3 :
                        status.setForeground(Color.red);
                        status.setText("User Blocked , contact service");
                        status.setVisible(true);
                        break;
                    case 4 :
                        status.setForeground(Color.red);
                        status.setText("Invalid login Details");
                        status.setVisible(true);
                        break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    public static void main(String args[]) {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());    
                } catch (Exception e) {
                }
                new Login().setVisible(true);
    }
   
}
