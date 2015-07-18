/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sgk;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Toolkit;


public class Dash extends javax.swing.JFrame implements ActionListener{
        Button btn = new Button("logout");
        Button btnIndi = new Button("Individual");
        // frame = new JFrame();     
        
        public Dash() {
            
            
            Action ac = new Action();
            Info in[] = ac.getInformation();

            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            Object rowData[][] = new String[in.length][in.length] ;

            for (int i = 0; i < in.length; i++) {
                for (int j = 0; j < 1; j++) {
                    rowData[i][j]= "" + in[i].getID();
                    
                    rowData[i][j+1]=in[i].getName();
                    rowData[i][j+2]= in[i].getGoneFor();
                    rowData[i][j+3] = in[i].getAvaible();
                    rowData[i][j+4] = in[i].getComment();
                    
                    
                }
            }

            Object columnNames[] = { "#ID" , "Name","Gone For","WillAvailableIn","Comment"};
            JTable table = new JTable(rowData, columnNames);
            
            table.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 51)));
            table.setFont(new java.awt.Font("Segoe UI", 0, 13));
            table.setGridColor(new java.awt.Color(51, 153, 255));
            table.setSelectionBackground(new java.awt.Color(0, 204, 102));
            table.setSelectionForeground(new java.awt.Color(255,255,255));
            table.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
            
            
            
            // Table Wrapper or pane            
            JScrollPane scrollPane = new JScrollPane(table);
            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 523, Short.MAX_VALUE)
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(200, 200, 200)
                    .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(130, Short.MAX_VALUE))
            );
            // End of the Table pane or 
            
            // Banner Image
           
            String  arg = "assets/dash.jpg";
            JPanel panel = new JPanel(); 
            panel.setSize(1366,200);
            ImageIcon icon=new ImageIcon(arg);
            JLabel label = new JLabel(); 
            label.setIcon(icon); 
            panel.add(label);
            //end of banner
            
            btn.addActionListener(this);
            btn.setSize(34,22);
            btn.setLocation(50,500);

            btnIndi.setActionCommand("indi");
            btnIndi.addActionListener(this);
            btnIndi.setSize(60,22);
            btnIndi.setLocation(150,500);
           // add(btn);
            //(btnIndi);
            add(scrollPane);         
            add(panel,BorderLayout.CENTER);
            setSize(700, 600);
            setExtendedState(JFrame.MAXIMIZED_BOTH);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setTitle("Admin dashboard");
            
            setVisible(true);
        }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 523, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 347, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    
   
    @Override   
    public void actionPerformed(ActionEvent ae) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        System.out.println("Yahooooo");
        
        String staus = ae.getActionCommand();
        
        switch(staus) {
            case "indi" :
                setVisible(false);
                UserDash ud = new UserDash(3);
                ud.setVisible(true);
                break;
            case "logout" :
                System.out.println("test");
                setVisible(false);
                Login lg = new Login();
                lg.setVisible(true);
                break;
        }
        
        
    }
    
    public static void main(String[] args) {
        new Dash();
        
    }
}   
