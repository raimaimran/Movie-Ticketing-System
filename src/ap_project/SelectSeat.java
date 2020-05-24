/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ap_project;

import java.awt.Color;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.Statement;
/**
 *
 * @author noorishhassan
 */
public class SelectSeat extends javax.swing.JFrame {

    Connection con;
    Statement stmt;
    
    int scheduleID;
    int movieID;
    /**
     * Creates new form SelectSeat
     */
    public SelectSeat() {
        
        initComponents();
        
        dbConnectivity db = new dbConnectivity();
        con = db.getConnString();
        stmt = db.getStmt();
    }

    public SelectSeat(int scheduleID, int movieID) {
        
        this.scheduleID = scheduleID;
        this.movieID = movieID;
        
        dbConnectivity db = new dbConnectivity();
        con = db.getConnString();
        stmt = db.getStmt();
        
        initComponents();
        
        initSeating();
    }
    
    void bookSeat(String label){
        
        Color color = new Color(102,102,102);
        
        if (label.equalsIgnoreCase("1a"))
            jLabel13.setBackground(color);
        else if (label.equalsIgnoreCase("2a"))
            jLabel14.setBackground(color);
        else if (label.equalsIgnoreCase("3a"))
            jLabel15.setBackground(color);
        else if (label.equalsIgnoreCase("4a"))
            jLabel16.setBackground(color);
        else if (label.equalsIgnoreCase("5a"))
            jLabel17.setBackground(color);
        else if (label.equalsIgnoreCase("6a"))
            jLabel18.setBackground(color);
        else if (label.equalsIgnoreCase("7a"))
            jLabel19.setBackground(color);
        else if (label.equalsIgnoreCase("8a"))
            jLabel20.setBackground(color);
        else if (label.equalsIgnoreCase("9a"))
            jLabel21.setBackground(color);
        else if (label.equalsIgnoreCase("1b"))
            jLabel22.setBackground(color);
        else if (label.equalsIgnoreCase("2b"))
            jLabel23.setBackground(color);
        else if (label.equalsIgnoreCase("3b"))
            jLabel24.setBackground(color);
        else if (label.equalsIgnoreCase("4b"))
            jLabel25.setBackground(color);
        else if (label.equalsIgnoreCase("5b"))
            jLabel26.setBackground(color);
        else if (label.equalsIgnoreCase("6b"))
            jLabel27.setBackground(color);
        else if (label.equalsIgnoreCase("7b"))
            jLabel28.setBackground(color);
        else if (label.equalsIgnoreCase("8b"))
            jLabel29.setBackground(color);
        else if (label.equalsIgnoreCase("9b"))
            jLabel30.setBackground(color);
        else if (label.equalsIgnoreCase("1c"))
            jLabel31.setBackground(color);
        else if (label.equalsIgnoreCase("2c"))
            jLabel47.setBackground(color);
        else if (label.equalsIgnoreCase("3c"))
            jLabel45.setBackground(color);
        else if (label.equalsIgnoreCase("4c"))
            jLabel46.setBackground(color);
        else if (label.equalsIgnoreCase("5c"))
            jLabel44.setBackground(color);
        else if (label.equalsIgnoreCase("6c"))
            jLabel43.setBackground(color);
        else if (label.equalsIgnoreCase("7c"))
            jLabel42.setBackground(color);
        else if (label.equalsIgnoreCase("8c"))
            jLabel41.setBackground(color);
        else if (label.equalsIgnoreCase("9c"))
            jLabel40.setBackground(color);
        else if (label.equalsIgnoreCase("1d"))
            jLabel49.setBackground(color);
        else if (label.equalsIgnoreCase("2d"))
            jLabel48.setBackground(color);
        else if (label.equalsIgnoreCase("3d"))
            jLabel33.setBackground(color);
        else if (label.equalsIgnoreCase("4d"))
            jLabel35.setBackground(color);
        else if (label.equalsIgnoreCase("5d"))
            jLabel34.setBackground(color);
        else if (label.equalsIgnoreCase("6d"))
            jLabel36.setBackground(color);
        else if (label.equalsIgnoreCase("7d"))
            jLabel37.setBackground(color);
        else if (label.equalsIgnoreCase("8d"))
            jLabel38.setBackground(color);
        else if (label.equalsIgnoreCase("9d"))
            jLabel39.setBackground(color);
        else if (label.equalsIgnoreCase("1e"))
            jLabel51.setBackground(color);
        else if (label.equalsIgnoreCase("2e"))
            jLabel52.setBackground(color);
        else if (label.equalsIgnoreCase("3e"))
            jLabel58.setBackground(color);
        else if (label.equalsIgnoreCase("4e"))
            jLabel59.setBackground(color);
        else if (label.equalsIgnoreCase("5e"))
            jLabel57.setBackground(color);
        else if (label.equalsIgnoreCase("6e"))
            jLabel56.setBackground(color);
        else if (label.equalsIgnoreCase("7e"))
            jLabel55.setBackground(color);
        else if (label.equalsIgnoreCase("8e"))
            jLabel54.setBackground(color);
        else if (label.equalsIgnoreCase("9e"))
            jLabel53.setBackground(color);
        else if (label.equalsIgnoreCase("1f"))
            jLabel61.setBackground(color);
        else if (label.equalsIgnoreCase("2f"))
            jLabel60.setBackground(color);
        else if (label.equalsIgnoreCase("3f"))
            jLabel63.setBackground(color);
        else if (label.equalsIgnoreCase("4f"))
            jLabel73.setBackground(color);
        else if (label.equalsIgnoreCase("5f"))
            jLabel64.setBackground(color);
        else if (label.equalsIgnoreCase("6f"))
            jLabel65.setBackground(color);
        else if (label.equalsIgnoreCase("7f"))
            jLabel66.setBackground(color);
        else if (label.equalsIgnoreCase("8f"))
            jLabel68.setBackground(color);
        else if (label.equalsIgnoreCase("9f"))
            jLabel67.setBackground(color);
        else if (label.equalsIgnoreCase("1g"))
            jLabel3.setBackground(color);
        else if (label.equalsIgnoreCase("2g"))
            jLabel4.setBackground(color);
        else if (label.equalsIgnoreCase("3g"))
            jLabel6.setBackground(color);
        else if (label.equalsIgnoreCase("4g"))
            jLabel7.setBackground(color);
        else if (label.equalsIgnoreCase("5g"))
            jLabel8.setBackground(color);
        else if (label.equalsIgnoreCase("6g"))
            jLabel9.setBackground(color);
        else if (label.equalsIgnoreCase("7g"))
            jLabel10.setBackground(color);
        else if (label.equalsIgnoreCase("8g"))
            jLabel11.setBackground(color);
        else if (label.equalsIgnoreCase("9g"))
            jLabel12.setBackground(color);
        
    }
    
    void initSeating(){
        
        try {
            
            ResultSet rs = stmt.executeQuery("SELECT * FROM cinema.seating where seating.scheduleID = " + this.scheduleID);
            
            while (rs.next())
            {
                bookSeat(rs.getString(2));
               
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        jLabel81 = new javax.swing.JLabel();
        jLabel82 = new javax.swing.JLabel();
        jLabel83 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        jLabel5.setBackground(new java.awt.Color(204, 204, 204));
        jLabel5.setText("     ");
        jLabel5.setOpaque(true);

        jLabel32.setBackground(new java.awt.Color(204, 204, 204));
        jLabel32.setText("     ");
        jLabel32.setOpaque(true);

        jLabel74.setText("jLabel74");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("THE DARK PHOENIX RISES");

        jLabel3.setBackground(new java.awt.Color(204, 204, 204));
        jLabel3.setText("     ");
        jLabel3.setOpaque(true);

        jLabel4.setBackground(new java.awt.Color(204, 204, 204));
        jLabel4.setText("     ");
        jLabel4.setOpaque(true);

        jLabel6.setBackground(new java.awt.Color(204, 204, 204));
        jLabel6.setText("     ");
        jLabel6.setOpaque(true);

        jLabel7.setBackground(new java.awt.Color(204, 204, 204));
        jLabel7.setText("     ");
        jLabel7.setOpaque(true);

        jLabel8.setBackground(new java.awt.Color(204, 204, 204));
        jLabel8.setText("     ");
        jLabel8.setOpaque(true);

        jLabel9.setBackground(new java.awt.Color(204, 204, 204));
        jLabel9.setText("     ");
        jLabel9.setOpaque(true);

        jLabel10.setBackground(new java.awt.Color(204, 204, 204));
        jLabel10.setText("     ");
        jLabel10.setOpaque(true);

        jLabel11.setBackground(new java.awt.Color(204, 204, 204));
        jLabel11.setText("     ");
        jLabel11.setOpaque(true);

        jLabel12.setBackground(new java.awt.Color(204, 204, 204));
        jLabel12.setText("     ");
        jLabel12.setOpaque(true);

        jLabel13.setBackground(new java.awt.Color(204, 204, 204));
        jLabel13.setText("     ");
        jLabel13.setOpaque(true);

        jLabel14.setBackground(new java.awt.Color(204, 204, 204));
        jLabel14.setText("     ");
        jLabel14.setOpaque(true);

        jLabel15.setBackground(new java.awt.Color(204, 204, 204));
        jLabel15.setText("     ");
        jLabel15.setOpaque(true);

        jLabel16.setBackground(new java.awt.Color(204, 204, 204));
        jLabel16.setText("     ");
        jLabel16.setOpaque(true);

        jLabel17.setBackground(new java.awt.Color(204, 204, 204));
        jLabel17.setText("     ");
        jLabel17.setOpaque(true);

        jLabel18.setBackground(new java.awt.Color(204, 204, 204));
        jLabel18.setText("     ");
        jLabel18.setOpaque(true);

        jLabel19.setBackground(new java.awt.Color(204, 204, 204));
        jLabel19.setForeground(new java.awt.Color(102, 102, 102));
        jLabel19.setText("     ");
        jLabel19.setOpaque(true);

        jLabel20.setBackground(new java.awt.Color(204, 204, 204));
        jLabel20.setText("     ");
        jLabel20.setOpaque(true);

        jLabel21.setBackground(new java.awt.Color(204, 204, 204));
        jLabel21.setText("     ");
        jLabel21.setOpaque(true);

        jLabel22.setBackground(new java.awt.Color(204, 204, 204));
        jLabel22.setText("     ");
        jLabel22.setOpaque(true);

        jLabel23.setBackground(new java.awt.Color(204, 204, 204));
        jLabel23.setText("     ");
        jLabel23.setOpaque(true);

        jLabel24.setBackground(new java.awt.Color(204, 204, 204));
        jLabel24.setText("     ");
        jLabel24.setOpaque(true);

        jLabel25.setBackground(new java.awt.Color(204, 204, 204));
        jLabel25.setText("     ");
        jLabel25.setOpaque(true);

        jLabel26.setBackground(new java.awt.Color(204, 204, 204));
        jLabel26.setText("     ");
        jLabel26.setOpaque(true);

        jLabel27.setBackground(new java.awt.Color(204, 204, 204));
        jLabel27.setText("     ");
        jLabel27.setOpaque(true);

        jLabel28.setBackground(new java.awt.Color(204, 204, 204));
        jLabel28.setText("     ");
        jLabel28.setOpaque(true);

        jLabel29.setBackground(new java.awt.Color(204, 204, 204));
        jLabel29.setText("     ");
        jLabel29.setOpaque(true);

        jLabel30.setBackground(new java.awt.Color(204, 204, 204));
        jLabel30.setText("     ");
        jLabel30.setOpaque(true);

        jLabel31.setBackground(new java.awt.Color(204, 204, 204));
        jLabel31.setText("     ");
        jLabel31.setOpaque(true);

        jLabel33.setBackground(new java.awt.Color(204, 204, 204));
        jLabel33.setText("     ");
        jLabel33.setOpaque(true);

        jLabel34.setBackground(new java.awt.Color(204, 204, 204));
        jLabel34.setText("     ");
        jLabel34.setOpaque(true);

        jLabel35.setBackground(new java.awt.Color(204, 204, 204));
        jLabel35.setText("     ");
        jLabel35.setOpaque(true);

        jLabel36.setBackground(new java.awt.Color(204, 204, 204));
        jLabel36.setText("     ");
        jLabel36.setOpaque(true);

        jLabel37.setBackground(new java.awt.Color(204, 204, 204));
        jLabel37.setText("     ");
        jLabel37.setOpaque(true);

        jLabel38.setBackground(new java.awt.Color(204, 204, 204));
        jLabel38.setText("     ");
        jLabel38.setOpaque(true);

        jLabel39.setBackground(new java.awt.Color(204, 204, 204));
        jLabel39.setText("     ");
        jLabel39.setOpaque(true);

        jLabel40.setBackground(new java.awt.Color(204, 204, 204));
        jLabel40.setText("     ");
        jLabel40.setOpaque(true);

        jLabel41.setBackground(new java.awt.Color(204, 204, 204));
        jLabel41.setText("     ");
        jLabel41.setOpaque(true);

        jLabel42.setBackground(new java.awt.Color(204, 204, 204));
        jLabel42.setText("     ");
        jLabel42.setOpaque(true);

        jLabel43.setBackground(new java.awt.Color(204, 204, 204));
        jLabel43.setText("     ");
        jLabel43.setOpaque(true);

        jLabel44.setBackground(new java.awt.Color(204, 204, 204));
        jLabel44.setText("     ");
        jLabel44.setOpaque(true);

        jLabel45.setBackground(new java.awt.Color(204, 204, 204));
        jLabel45.setText("     ");
        jLabel45.setOpaque(true);

        jLabel46.setBackground(new java.awt.Color(204, 204, 204));
        jLabel46.setText("     ");
        jLabel46.setOpaque(true);

        jLabel47.setBackground(new java.awt.Color(204, 204, 204));
        jLabel47.setText("     ");
        jLabel47.setOpaque(true);

        jLabel48.setBackground(new java.awt.Color(204, 204, 204));
        jLabel48.setText("     ");
        jLabel48.setOpaque(true);

        jLabel49.setBackground(new java.awt.Color(204, 204, 204));
        jLabel49.setText("     ");
        jLabel49.setOpaque(true);

        jLabel50.setBackground(new java.awt.Color(0, 0, 0));
        jLabel50.setText("     ");
        jLabel50.setOpaque(true);

        jLabel51.setBackground(new java.awt.Color(204, 204, 204));
        jLabel51.setText("     ");
        jLabel51.setOpaque(true);

        jLabel52.setBackground(new java.awt.Color(204, 204, 204));
        jLabel52.setText("     ");
        jLabel52.setOpaque(true);

        jLabel53.setBackground(new java.awt.Color(204, 204, 204));
        jLabel53.setText("     ");
        jLabel53.setOpaque(true);

        jLabel54.setBackground(new java.awt.Color(204, 204, 204));
        jLabel54.setText("     ");
        jLabel54.setOpaque(true);

        jLabel55.setBackground(new java.awt.Color(204, 204, 204));
        jLabel55.setText("     ");
        jLabel55.setOpaque(true);

        jLabel56.setBackground(new java.awt.Color(204, 204, 204));
        jLabel56.setText("     ");
        jLabel56.setOpaque(true);

        jLabel57.setBackground(new java.awt.Color(204, 204, 204));
        jLabel57.setText("     ");
        jLabel57.setOpaque(true);

        jLabel58.setBackground(new java.awt.Color(204, 204, 204));
        jLabel58.setText("     ");
        jLabel58.setOpaque(true);

        jLabel59.setBackground(new java.awt.Color(204, 204, 204));
        jLabel59.setText("     ");
        jLabel59.setOpaque(true);

        jLabel60.setBackground(new java.awt.Color(204, 204, 204));
        jLabel60.setText("     ");
        jLabel60.setOpaque(true);

        jLabel61.setBackground(new java.awt.Color(204, 204, 204));
        jLabel61.setText("     ");
        jLabel61.setOpaque(true);

        jLabel62.setBackground(new java.awt.Color(204, 204, 204));
        jLabel62.setText("     ");
        jLabel62.setOpaque(true);

        jLabel63.setBackground(new java.awt.Color(204, 204, 204));
        jLabel63.setText("     ");
        jLabel63.setOpaque(true);

        jLabel64.setBackground(new java.awt.Color(204, 204, 204));
        jLabel64.setText("     ");
        jLabel64.setOpaque(true);

        jLabel65.setBackground(new java.awt.Color(204, 204, 204));
        jLabel65.setText("     ");
        jLabel65.setOpaque(true);

        jLabel66.setBackground(new java.awt.Color(204, 204, 204));
        jLabel66.setText("     ");
        jLabel66.setOpaque(true);

        jLabel67.setBackground(new java.awt.Color(204, 204, 204));
        jLabel67.setText("     ");
        jLabel67.setOpaque(true);

        jLabel68.setBackground(new java.awt.Color(204, 204, 204));
        jLabel68.setText("     ");
        jLabel68.setOpaque(true);

        jLabel70.setBackground(new java.awt.Color(102, 102, 102));
        jLabel70.setText("     ");
        jLabel70.setOpaque(true);

        jLabel71.setText("Available");

        jLabel72.setText("Booked");

        jLabel73.setBackground(new java.awt.Color(204, 204, 204));
        jLabel73.setText("     ");
        jLabel73.setOpaque(true);

        jLabel75.setText(" 1     2    3     4    5     6     7    8    9");

        jLabel76.setText("a");

        jLabel77.setText("b");

        jLabel78.setText("c");

        jLabel79.setText("d");

        jLabel80.setText("g");

        jLabel81.setText("e");

        jLabel82.setText("f");

        jLabel83.setText("Select your seat");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ap_project/multimedia-option.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("  ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel76)
                            .addComponent(jLabel77)
                            .addComponent(jLabel78)
                            .addComponent(jLabel79)
                            .addComponent(jLabel80)
                            .addComponent(jLabel82)
                            .addComponent(jLabel81))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel61)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel60)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel63)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel73)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel64)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel65)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel66)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel68)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel67))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel51)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel52)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel58)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel59)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel57)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel56)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel55)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel54)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel53))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel9))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel62)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel71)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel70)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel12))
                                    .addComponent(jLabel72)))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel49)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel48)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel33)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel35)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel34)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel36)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel37)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel38)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel39))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel13)
                                        .addComponent(jLabel22)
                                        .addComponent(jLabel31))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel23)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel24)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel25)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel26)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel27)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel28)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel29)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel30))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel47)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel45)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel46)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel44)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel43)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel42)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel41)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel40))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel14)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel15)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel16)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel17)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel18)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel19)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel20)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel21))))
                                .addComponent(jLabel50, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel75, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(104, 104, 104)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel1))
                    .addComponent(jLabel83)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(104, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel1))
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel75)
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18)
                    .addComponent(jLabel19)
                    .addComponent(jLabel20)
                    .addComponent(jLabel21)
                    .addComponent(jLabel76))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(jLabel23)
                    .addComponent(jLabel24)
                    .addComponent(jLabel25)
                    .addComponent(jLabel26)
                    .addComponent(jLabel27)
                    .addComponent(jLabel28)
                    .addComponent(jLabel29)
                    .addComponent(jLabel30)
                    .addComponent(jLabel77))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(jLabel47)
                    .addComponent(jLabel45)
                    .addComponent(jLabel46)
                    .addComponent(jLabel44)
                    .addComponent(jLabel43)
                    .addComponent(jLabel42)
                    .addComponent(jLabel41)
                    .addComponent(jLabel40)
                    .addComponent(jLabel78))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel39)
                    .addComponent(jLabel38)
                    .addComponent(jLabel37)
                    .addComponent(jLabel36)
                    .addComponent(jLabel34)
                    .addComponent(jLabel35)
                    .addComponent(jLabel33)
                    .addComponent(jLabel49)
                    .addComponent(jLabel48)
                    .addComponent(jLabel79))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel51)
                    .addComponent(jLabel52)
                    .addComponent(jLabel58)
                    .addComponent(jLabel59)
                    .addComponent(jLabel57)
                    .addComponent(jLabel56)
                    .addComponent(jLabel55)
                    .addComponent(jLabel54)
                    .addComponent(jLabel53)
                    .addComponent(jLabel81))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel61)
                    .addComponent(jLabel60)
                    .addComponent(jLabel68)
                    .addComponent(jLabel67)
                    .addComponent(jLabel66)
                    .addComponent(jLabel65)
                    .addComponent(jLabel64)
                    .addComponent(jLabel63)
                    .addComponent(jLabel73)
                    .addComponent(jLabel82))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jLabel80))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel62)
                    .addComponent(jLabel71)
                    .addComponent(jLabel70)
                    .addComponent(jLabel72))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel83)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
        
        if (AP_Project.userEmail == null)
        {
            jLabel2.setText("You need to login to book a movie.");
        }
        
        else if (jTextField1.getText().charAt(0) >= '0' && jTextField1.getText().charAt(0) <= '9' && ((jTextField1.getText().charAt(1) >= 'a' && jTextField1.getText().charAt(1) <= 'e') || (jTextField1.getText().charAt(1) >= 'A' && jTextField1.getText().charAt(1) <= 'E')))
        {
            String seat = null;
            try {

                ResultSet rs = stmt.executeQuery("SELECT * FROM cinema.seating where seating.scheduleID = " + this.scheduleID + " AND seating.seatID = '" + jTextField1.getText() + "'");

                while (rs.next())
                {
                    seat = rs.getString(2);
                }
            }
            catch(Exception e){
                System.out.println(e);
            }

            if (seat != null){
                if (seat.equalsIgnoreCase(jTextField1.getText())){
                    jLabel2.setText("Sorry that seat is already Booked.");
                }
            }
            else{
                
                int ticketID = 0;
                
                try {

                    ResultSet rs = stmt.executeQuery("SELECT * FROM cinema.ticket ORDER BY ticket.ticketID DESC LIMIT 1");

                    while (rs.next())
                    {
                        ticketID = rs.getInt(1);
                    }
                }
                catch(Exception e){
                    System.out.println(e);
                }
                
                ticketID++;
                
                int ticketTypeID;
                
                if (jTextField1.getText().charAt(1) == 'd' || jTextField1.getText().charAt(1) == 'e' || jTextField1.getText().charAt(1) == 'f')
                    ticketTypeID = 1;
                else
                    ticketTypeID = 2;
                
                char rowNumber = jTextField1.getText().charAt(1);
                int seatNumber = Integer.parseInt(String.valueOf(jTextField1.getText().charAt(0)));
                
                //insert in ticket
                try
                {
                    stmt.executeUpdate("INSERT INTO cinema.ticket VALUE (" + ticketID + ", " + ticketTypeID + ", " + this.movieID + ", " + this.scheduleID + ", '" + rowNumber + "'," + seatNumber + ", '" + AP_Project.userEmail + "')");
                }
                catch(Exception e)
                {
                    System.out.println(e);
                }

                //insert in seating
                try
                {
                    stmt.executeUpdate("INSERT INTO cinema.seating VALUE (" + this.scheduleID + ", '" + jTextField1.getText() + "')");
                }
                catch(Exception e)
                {
                    System.out.println(e);
                }
                jLabel2.setText("Seat Booked! Your Ticket ID is " + ticketID);
                
                bookSeat(jTextField1.getText());
            }
        }
        else
            jLabel2.setText("Invalid Seat Number");
            
            
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        BookMovie screen = new BookMovie(this.movieID);
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
            java.util.logging.Logger.getLogger(SelectSeat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SelectSeat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SelectSeat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SelectSeat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SelectSeat().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
