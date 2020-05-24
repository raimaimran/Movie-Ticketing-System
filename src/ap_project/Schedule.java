/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ap_project;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
/**
 *
 * @author noorishhassan
 */
public class Schedule extends javax.swing.JFrame {

    Connection con;
    Statement stmt;
    
    /**
     * Creates new form Schedule
     */
    public Schedule() {
        initComponents();
        
        dbConnectivity db = new dbConnectivity();
        con = db.getConnString();
        stmt = db.getStmt();
        
        populateDataInList1();
        populateDataInList2();
        populateDataInList3();
        populateDataInList4();
    }
    
    public void populateDataInList1(){
        
        ArrayList<String> arrList = new ArrayList<>();
        
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
        LocalDateTime today = LocalDateTime.now();  
        String strDate = "'" + dtf.format(today) + "'";
        
        try {
            ResultSet rs = stmt.executeQuery("SELECT * FROM cinema.schedule where cinema.schedule.scheduleDate=" + strDate);
            
            while (rs.next())
            {
                arrList.add(rs.getString(4) + " | Screen " + rs.getString(5) + " | " + rs.getString(6));
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        
        //will populate list from db here
        
        javax.swing.JList<String> movieList = new javax.swing.JList(arrList.toArray());
        jList1 = movieList;
        jList1.setBackground(new java.awt.Color(105, 105, 105));
        jList1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jList1.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jList1.setForeground(new java.awt.Color(240, 240, 240));
        
        jScrollPane1.setViewportView(jList1);
        
    }
    
    public void populateDataInList2(){
        
        ArrayList<String> arrList = new ArrayList<>();
        
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
        LocalDateTime today = LocalDateTime.now();
        LocalDateTime tomorrow = today.plusDays(1);
        String strDate = "'" + dtf.format(tomorrow) + "'";
        
        try {
            ResultSet rs = stmt.executeQuery("SELECT * FROM cinema.schedule where cinema.schedule.scheduleDate=" + strDate);
            
            while (rs.next())
            {
                arrList.add(rs.getString(4) + " | Screen " + rs.getString(5) + " | " + rs.getString(6));
            }
        }
        catch(Exception e){
            System.out.println(e);
        }

        
        //will populate list from db here
        
        javax.swing.JList<String> movieList = new javax.swing.JList(arrList.toArray());        
        jList2 = movieList;
        jList2.setBackground(new java.awt.Color(105, 105, 105));
        jList2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jList2.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jList2.setForeground(new java.awt.Color(240, 240, 240));
        
        jScrollPane2.setViewportView(jList2);
    }
    
    
    public void populateDataInList3(){
        
        ArrayList<String> arrList = new ArrayList<>();
        
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
        LocalDateTime today = LocalDateTime.now();
        LocalDateTime tomorrow = today.plusDays(2);
        String strDate = "'" + dtf.format(tomorrow) + "'";
        
        try {
            ResultSet rs = stmt.executeQuery("SELECT * FROM cinema.schedule where cinema.schedule.scheduleDate=" + strDate);
            
            while (rs.next())
            {
                arrList.add(rs.getString(4) + " | Screen " + rs.getString(5) + " | " + rs.getString(6));
            }
        }
        catch(Exception e){
            System.out.println(e);
        }

        
        //will populate list from db here
        
        javax.swing.JList<String> movieList = new javax.swing.JList(arrList.toArray());

        jList3 = movieList;
        jList3.setBackground(new java.awt.Color(105, 105, 105));
        jList3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jList3.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jList3.setForeground(new java.awt.Color(240, 240, 240));
        
        jScrollPane3.setViewportView(jList3);
        
    }
        
        
    public void populateDataInList4(){
        
        ArrayList<String> arrList = new ArrayList<>();
        
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
        LocalDateTime today = LocalDateTime.now();
        LocalDateTime tomorrow = today.plusDays(3);
        String strDate = "'" + dtf.format(tomorrow) + "'";
        
        try {
            ResultSet rs = stmt.executeQuery("SELECT * FROM cinema.schedule where cinema.schedule.scheduleDate=" + strDate);
            
            while (rs.next())
            {
                arrList.add(rs.getString(4) + " | Screen " + rs.getString(5) + " | " + rs.getString(6));
            }
        }
        catch(Exception e){
            System.out.println(e);
        }

        
        //will populate list from db here
        
        javax.swing.JList<String> movieList = new javax.swing.JList(arrList.toArray());
        jList4 = movieList;
        jList4.setBackground(new java.awt.Color(105, 105, 105));
        jList4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jList4.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jList4.setForeground(new java.awt.Color(240, 240, 240));
        jScrollPane4.setViewportView(jList4);
        
        
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        jList3 = new javax.swing.JList<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        jList4 = new javax.swing.JList<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel1.setText("SCHEDULE");

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        jList2.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jList2);

        jList3.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(jList3);

        jList4.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane4.setViewportView(jList4);

        jLabel2.setText("FRIDAY");

        jLabel3.setText("SATURDAY");

        jLabel4.setText("SUNDAY");

        jLabel5.setText("MONDAY");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ap_project/multimedia-option.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(140, 552, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        HomeScreen screen = new HomeScreen();
        screen.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Schedule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Schedule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Schedule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Schedule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Schedule().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JList<String> jList1;
    private javax.swing.JList<String> jList2;
    private javax.swing.JList<String> jList3;
    private javax.swing.JList<String> jList4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    // End of variables declaration//GEN-END:variables
}
