/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ap_project;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
/**
 *
 * @author dell
 */
public class ChangeTicket extends javax.swing.JFrame {

    /**
     * Creates new form ChangeTicket
     */
    
    ArrayList<Integer> arrList = new ArrayList<>();
    String email;
    dbConnectivity db;
    Connection con;
    Statement stmt;
    
    public ChangeTicket() {
        initComponents();
        
        email = AP_Project.userEmail;
        db = new dbConnectivity();
        con = db.getConnString();
        stmt = db.getStmt();
        
        addAction();
        setDetails();
    }
       
    public void setDetails(){
        
        try{
            
            String query = "select ticketID from ticket where userEmail = ?";
            PreparedStatement preparedStmt = (PreparedStatement) con.prepareStatement(query);
            preparedStmt.setString(1, email);
            ResultSet rs = preparedStmt.executeQuery();
            while(rs.next())
            {
                arrList.add(rs.getInt(1));
                //System.out.println(rs.getInt(1));
            }
            
            
        }
        catch (Exception e){
            System.out.println(e);
        }
        javax.swing.JList<String> movieList = new javax.swing.JList(arrList.toArray());
        jList1 = movieList;
        jList1.setBackground(new java.awt.Color(105, 105, 105));
        jList1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jList1.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jList1.setForeground(new java.awt.Color(240, 240, 240));
        
        jScrollPane1.setViewportView(jList1);
    }
    
    public boolean checkValidTicket(String ticket){
        
        int tick = Integer.parseInt(ticket);
        
        for (int i=0; i< arrList.size(); i++){
            if (tick == arrList.get(i))
                return true;
        }
        return false;
    }
    
    public boolean checkValidMovieSchedule(String movieField, String scheduleField){
        
        try{
            
            String query = "select scheduleID, movieID from schedule";
            PreparedStatement preparedStmt = (PreparedStatement) con.prepareStatement(query);
            ResultSet rs = preparedStmt.executeQuery();
            
            int movieID = Integer.parseInt(movieField);
            int scheduleID = Integer.parseInt(scheduleField);
            
            while(rs.next())
            {
                if (rs.getInt(2) == movieID && scheduleID == rs.getInt(1))
                    return true;
            }
            return false;
        }
        catch (Exception e){
            System.out.println(e);
        }
        return false;
    }
    
    public boolean seatTaken(String movieField, String scheduleField, String rowField, String seatField){
        
        try{
            String query = "select scheduleID, movieID, rowNumber, seatNumber from ticket";
            PreparedStatement preparedStmt = (PreparedStatement) con.prepareStatement(query);
            ResultSet rs = preparedStmt.executeQuery();
            
            int movieID = Integer.parseInt(movieField);
            int scheduleID = Integer.parseInt(scheduleField);
            int seatNumber = Integer.parseInt(seatField);
            
            while(rs.next())
            {
                if (rs.getInt(1) == scheduleID && rs.getInt(2) == movieID && rs.getString(3).equals(rowField) && rs.getInt(4) == seatNumber )
                    return true;
            }
            return false;
        }
        catch(Exception e){
            System.out.println(e);
        }
        return false;
    }
    
    public void editDB(){
        
        try{
            
            int ticketTypeID = Integer.parseInt(ticketTypeField.getText());
            int movieID = Integer.parseInt(movieField.getText());
            int scheduleID = Integer.parseInt(scheduleField.getText());
            int seatNumber = Integer.parseInt(seatField.getText());
            int ticketID = Integer.parseInt(ticketField.getText());
            
            String query = "update ticket set ticketTypeID = ? , movieID = ?, scheduleID = ?, rowNumber = ?, seatNumber = ? where (userEmail = ? and ticketID = ?)";
            PreparedStatement preparedStmt = (PreparedStatement) con.prepareStatement(query);
            
            preparedStmt.setInt (1, ticketTypeID);
            preparedStmt.setInt (2, movieID);
            preparedStmt.setInt (3, scheduleID);
            preparedStmt.setString (4, rowField.getText());
            preparedStmt.setInt (5, seatNumber);
            preparedStmt.setString (6, this.email);
            preparedStmt.setInt (7, ticketID);
            
            preparedStmt.executeUpdate();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    
    public boolean isInteger(String s){
       try {
            Integer.parseInt(s);
       }
       catch (NumberFormatException e) {
            //Not an integer
            System.out.println(e);
            return false;
       }
       return true; //is integer
    }

    public ActionListener createAction(JButton button){
        
        ActionListener a1 = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if (button.equals(jButton1)){
                    HomeScreen hs = new HomeScreen();
                    hs.setVisible(true);
                    setVisible(false);
                }
                else if (button.equals(jButton9)){
                    HomePage hp = new HomePage();
                    hp.setVisible(true);
                    setVisible(false);
                } 
                else if (button.equals(jButton3)){
                    
                    if (rowField.getText().equals("") || seatField.getText().equals("") || ticketField.getText().equals("") || ticketTypeField.getText().equals("")|| movieField.getText().equals("") || scheduleField.getText().equals("") ){
                        jLabel1.setText("Fill in all Fields");
                    }
                    else if (!isInteger(ticketField.getText())){
                        jLabel1.setText("Incorrect Ticket Number");
                    }
                    else if (isInteger(rowField.getText())){
                        jLabel1.setText("Incorrect Row");
                    }
                    else if (!isInteger(seatField.getText())){
                        jLabel1.setText("Incorrect Seat Number");
                    }
                    else if (!checkValidTicket(ticketField.getText())){
                        jLabel1.setText("Incorrect Ticket ID");
                    }
                    else if (!isInteger(ticketTypeField.getText()) ){
                        jLabel1.setText("Incorrect Ticket Type");
                    }
                    else if (!ticketTypeField.getText().equals("1") && !ticketTypeField.getText().equals("2")){
                        jLabel1.setText("Incorrect Ticket Type");
                    }
                    else if(rowField.getText().charAt(0) > 'F'){
                        jLabel1.setText("Incorrect Row");
                    }
                    else if (seatField.getText().charAt(0) > '9'){
                        jLabel1.setText("Incorrect Seat Number");
                    }
                    else if (!isInteger(movieField.getText())){
                        jLabel1.setText("Incorrect Movie ID");
                    }
                    else if (!isInteger(scheduleField.getText())){
                        jLabel1.setText("Incorrect Schedule ID");
                    }
                    else if (!checkValidMovieSchedule(movieField.getText(), scheduleField.getText())){
                        jLabel1.setText("Incorrect Schedule");
                    }
                    else if (seatTaken(movieField.getText(), scheduleField.getText(), rowField.getText(), seatField.getText())){
                        jLabel1.setText("Seat Taken");
                    }
                    else {
                        jLabel1.setText("Ticket Exchanged!");
                        editDB();
                    }
                }   
                
            }
                    
        };
        return a1;
    }
    public void addAction(){
         Component [] comps = jPanel1.getComponents();
            for (Component comp : comps){
                if (comp instanceof JButton){
                    JButton button = (JButton) comp;
                    button.addActionListener(createAction(button));
                }
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

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        ticketField = new javax.swing.JTextField();
        rowField = new javax.swing.JTextField();
        seatField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        ticketTypeField = new javax.swing.JTextField();
        movieField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        scheduleField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(500, 500));

        jPanel1.setBackground(new java.awt.Color(105, 105, 105));
        jPanel1.setPreferredSize(new java.awt.Dimension(500, 500));

        jButton1.setBackground(new java.awt.Color(211, 211, 211));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ap_project/multimedia-option.png"))); // NOI18N
        jButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.setBorderPainted(false);

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(240, 240, 240));
        jLabel1.setText("Change Ticket");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ap_project/ticket.png"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(240, 240, 240));
        jLabel3.setText("Ticket ID");

        jLabel4.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(240, 240, 240));
        jLabel4.setText("Movie Id");

        jLabel5.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(240, 240, 240));
        jLabel5.setText("Row Number");

        ticketField.setBackground(new java.awt.Color(240, 240, 240));
        ticketField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ticketField.setToolTipText("Eg 12");
        ticketField.setBorder(null);

        rowField.setBackground(new java.awt.Color(240, 240, 240));
        rowField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        rowField.setToolTipText("Eg G");
        rowField.setBorder(null);
        rowField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        rowField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rowFieldActionPerformed(evt);
            }
        });

        seatField.setBackground(new java.awt.Color(240, 240, 240));
        seatField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        seatField.setToolTipText("Eg 12");
        seatField.setBorder(null);
        seatField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seatFieldActionPerformed(evt);
            }
        });
        seatField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                seatFieldKeyPressed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(240, 240, 240));
        jLabel6.setText("Seat Number");

        jButton3.setBackground(new java.awt.Color(225, 173, 1));
        jButton3.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jButton3.setForeground(new java.awt.Color(240, 240, 240));
        jButton3.setText("CONFIRM");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton9.setText("SIGN OUT");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(240, 240, 240));
        jLabel7.setText("Ticket Type");

        ticketTypeField.setBackground(new java.awt.Color(240, 240, 240));
        ticketTypeField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ticketTypeField.setToolTipText("Eg 12");
        ticketTypeField.setBorder(null);
        ticketTypeField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ticketTypeFieldActionPerformed(evt);
            }
        });
        ticketTypeField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ticketTypeFieldKeyPressed(evt);
            }
        });

        movieField.setBackground(new java.awt.Color(240, 240, 240));
        movieField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        movieField.setToolTipText("Eg 12");
        movieField.setBorder(null);
        movieField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                movieFieldActionPerformed(evt);
            }
        });
        movieField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                movieFieldKeyPressed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(240, 240, 240));
        jLabel8.setText("Schedule Id");

        scheduleField.setBackground(new java.awt.Color(240, 240, 240));
        scheduleField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        scheduleField.setToolTipText("Eg 12");
        scheduleField.setBorder(null);
        scheduleField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scheduleFieldActionPerformed(evt);
            }
        });
        scheduleField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                scheduleFieldKeyPressed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(240, 240, 240));
        jLabel10.setText("Ticket ID");

        jList1.setBackground(new java.awt.Color(105, 105, 105));
        jList1.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jList1.setForeground(new java.awt.Color(240, 240, 240));
        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 167, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel9)
                                .addGap(42, 42, 42))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton9)
                .addGap(31, 31, 31))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ticketField)
                    .addComponent(rowField)
                    .addComponent(seatField, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ticketTypeField)
                    .addComponent(movieField, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(scheduleField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(179, 179, 179)
                .addComponent(jButton3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton9))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(115, 115, 115)
                                .addComponent(jLabel9)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel10))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(ticketField, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(rowField, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(seatField, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(ticketTypeField, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(movieField, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4)))
                            .addComponent(jLabel7)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(scheduleField, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jButton3)
                .addContainerGap(62, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rowFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rowFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rowFieldActionPerformed

    private void seatFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seatFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_seatFieldActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void seatFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_seatFieldKeyPressed
        
    }//GEN-LAST:event_seatFieldKeyPressed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        HomePage screen = new HomePage();
        screen.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_jButton9ActionPerformed

    private void ticketTypeFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ticketTypeFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ticketTypeFieldActionPerformed

    private void ticketTypeFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ticketTypeFieldKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_ticketTypeFieldKeyPressed

    private void movieFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_movieFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_movieFieldActionPerformed

    private void movieFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_movieFieldKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_movieFieldKeyPressed

    private void scheduleFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scheduleFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_scheduleFieldActionPerformed

    private void scheduleFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_scheduleFieldKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_scheduleFieldKeyPressed

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
            java.util.logging.Logger.getLogger(ChangeTicket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChangeTicket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChangeTicket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChangeTicket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChangeTicket().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField movieField;
    private javax.swing.JTextField rowField;
    private javax.swing.JTextField scheduleField;
    private javax.swing.JTextField seatField;
    private javax.swing.JTextField ticketField;
    private javax.swing.JTextField ticketTypeField;
    // End of variables declaration//GEN-END:variables
}
