

package com.sgk;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;



public class StudentDash extends JFrame implements ActionListener{
    
        Button logoutBtn ;
        Button addNewBtn ;
        
        public StudentDash() {
            
            Action ac   = new Action();
            Info in[]   = ac.getInformation();    
            
             
            Object rowData[][] = new String[in.length][in.length] ;
            
            // populating all data to a presentable array from data source
            try{
                for (int i = 0; i < in.length; i++) {
                    for (int j = 0; j < 1; j++) {
                        rowData[i][j]= "" + in[i].getID();
                        rowData[i][j+1]=in[i].getName();
                        rowData[i][j+2]= in[i].getGoneFor();
                        rowData[i][j+3] = in[i].getAvaible();
                        rowData[i][j+4] = in[i].getComment();
                    }
                }
            } catch(Exception e) {
                e.printStackTrace();
            }
            
            // Coloum header
            Object columnNames[] = { "#ID" , "Name","Gone For","WillAvailableIn","Comment"};

            // Table for showing all TSF info of facutly
            JTable table = new JTable(rowData, columnNames);
            table.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 153, 51)));
            table.setFont(new Font("Segoe UI", 0, 13));
            table.setGridColor(new Color(51, 153, 255));
            table.setSelectionBackground(new Color(0, 204, 102));
            table.setSelectionForeground(new Color(255,255,255));
            table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
            
            // scrollable view of table
            JScrollPane scrollPane = new JScrollPane(table);
            
            // Layout manager for Scroll pane presentation , N.B : I collect those code from internet , Will ask for help from teacher
            GroupLayout layout = new GroupLayout(getContentPane());
            setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(scrollPane,GroupLayout.Alignment.CENTER)
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(200, 200, 200)
                    .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(130, Short.MAX_VALUE))
            );

            // End of the Table pane or 
            


            // Banner Image
            JPanel panel = new JPanel(); 
            panel.setSize(1366,200);
            panel.setLocation(0, 0);
            
            JLabel label = new JLabel(new ImageIcon(ActionHelper.dashBannerStudent)); 
            panel.add(label);
            
            Button exit = new Button();
            exit.addActionListener(this);
            exit.setSize(200,50);
            exit.setLocation(50,600);
            exit.setLabel("Exit");
            
            
            add(exit);
            add(scrollPane);         
            add(panel);
            
            // view in full-screen mode
            setExtendedState(JFrame.MAXIMIZED_BOTH);
            setTitle("Student dashboard");
            setVisible(true);
            addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                    setVisible(false);
                    new Login().setVisible(true);
                }
            });
            
            
        }
            
        
    // Button Lisenter for both buttons        
    @Override   
    public void actionPerformed(ActionEvent ae) {
                    setVisible(false);
                    new Login().setVisible(true);
    }
    
    public static void main(String[] args) {
        new Dash();
    }
}   
