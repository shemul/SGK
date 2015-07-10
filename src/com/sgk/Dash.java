/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sgk;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;



public class Dash extends javax.swing.JFrame implements ActionListener{
        Button btn = new Button("logout");
        Button btnIndi = new Button("Individual");
        JFrame frame = new JFrame();     
        public Dash() {
                
                
                Action ac = new Action();
                Info in[] = ac.getInformation();
                
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
                
                Object columnNames[] = { "#ID" , "Name","Gone For","AvailableIn","Comment"};
                JTable table = new JTable(rowData, columnNames);

                JScrollPane scrollPane = new JScrollPane(table);
                
                
                
                btn.addActionListener(this);
                btn.setSize(34,22);
                btn.setLocation(50,500);
                
                btnIndi.setActionCommand("indi");
                btnIndi.addActionListener(this);
                btnIndi.setSize(34,22);
                btnIndi.setLocation(80,500);
                
                
                frame.add(btn);
                frame.add(btnIndi);
                frame.add(scrollPane, BorderLayout.CENTER);
                frame.setSize(800, 600);
                frame.setVisible(true);
                
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
            .addGap(0, 353, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    
    public  void logOut() {
        
        
    }
    @Override   
    public void actionPerformed(ActionEvent ae) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        System.out.println("Yahooooo");
        
        String staus = ae.getActionCommand();
        
        switch(staus) {
            case "indi" :
                frame.setVisible(false);
                UserDash ud = new UserDash();
                ud.setVisible(true);
                break;
            case "logout" :
                System.out.println("test");
                frame.setVisible(false);
                Login lg = new Login();
                lg.setVisible(true);
                break;
        }
        logOut();
        
    }

}   
