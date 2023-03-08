import java.awt.Color;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author balas
 */
public class PayForm extends javax.swing.JFrame {

    /**
     * Creates new form PayForm
     */
    
    course c = new course();
    student std = new student();
    Pay p = new Pay();
    private static String mail = "";
    
    DefaultTableModel model;
    public PayForm() {
        initComponents();
        c.fillCourseCombo(courseid_combobox);
        std.fillStudentJtable(jTable1, "");
        
        HideColumn(7);
        HideColumn(5);
        HideColumn(4);
        HideColumn(3);
        
        model = (DefaultTableModel)jTable1.getModel();
        jTable1.setRowHeight(40);
        jTable1.setShowGrid(true);
        jTable1.setGridColor(Color.gray);
        jTable1.setSelectionBackground(Color.black);
        
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        
    }

    private void HideColumn(int ColIndex){
        TableColumn col = jTable1.getColumnModel().getColumn(ColIndex);
        col.setMaxWidth(0);
        col.setMinWidth(0);
        col.setPreferredWidth(0);
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
        addstudent_label = new javax.swing.JLabel();
        email_label = new javax.swing.JLabel();
        coursename_label = new javax.swing.JLabel();
        pay_button = new javax.swing.JButton();
        hours_label = new javax.swing.JLabel();
        id_label = new javax.swing.JLabel();
        Close_button = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        pay_jComboBox = new javax.swing.JComboBox<>();
        courseid_combobox = new javax.swing.JComboBox<>();
        month_jComboBox = new javax.swing.JComboBox<>();
        description_label = new javax.swing.JLabel();
        studentid_textfield = new javax.swing.JTextField();
        email_textfield = new javax.swing.JTextField();
        amount_label = new javax.swing.JLabel();
        amount_textfield = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(200, 198, 75));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        addstudent_label.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        addstudent_label.setText("Cash Desk");
        jPanel1.add(addstudent_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 20, 270, 50));

        email_label.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        email_label.setText("Email               :");
        jPanel1.add(email_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, 200, 30));

        coursename_label.setBackground(new java.awt.Color(200, 198, 75));
        coursename_label.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        coursename_label.setText("Course Name    :");
        coursename_label.setOpaque(true);
        jPanel1.add(coursename_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, 30));

        pay_button.setBackground(new java.awt.Color(102, 102, 102));
        pay_button.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        pay_button.setText("Pay");
        pay_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pay_buttonActionPerformed(evt);
            }
        });
        jPanel1.add(pay_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 420, 100, -1));

        hours_label.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        hours_label.setText("Pay                 :");
        jPanel1.add(hours_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, -1, 30));

        id_label.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        id_label.setText("Id                   :");
        jPanel1.add(id_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, 30));

        Close_button.setBackground(new java.awt.Color(255, 0, 0));
        Close_button.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        Close_button.setText("Close");
        Close_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Close_buttonActionPerformed(evt);
            }
        });
        jPanel1.add(Close_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 420, 97, 31));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel1.setText("© Rafael Balaskas");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 480, 110, 20));

        pay_jComboBox.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        pay_jComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "YES", "NO" }));
        pay_jComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pay_jComboBoxActionPerformed(evt);
            }
        });
        jPanel1.add(pay_jComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(237, 200, 109, 37));

        courseid_combobox.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel1.add(courseid_combobox, new org.netbeans.lib.awtextra.AbsoluteConstraints(237, 145, 210, 36));

        month_jComboBox.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        month_jComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "January ", "February ", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));
        month_jComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                month_jComboBoxActionPerformed(evt);
            }
        });
        jPanel1.add(month_jComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 260, 210, 38));

        description_label.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        description_label.setText("Month              :");
        jPanel1.add(description_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, -1, 30));

        studentid_textfield.setEditable(false);
        studentid_textfield.setBackground(new java.awt.Color(255, 255, 255));
        studentid_textfield.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        studentid_textfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentid_textfieldActionPerformed(evt);
            }
        });
        jPanel1.add(studentid_textfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(237, 96, 210, 38));

        email_textfield.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        email_textfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                email_textfieldActionPerformed(evt);
            }
        });
        jPanel1.add(email_textfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 360, 210, 40));

        amount_label.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        amount_label.setText("Amount            :");
        jPanel1.add(amount_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, -1, 30));

        amount_textfield.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel1.add(amount_textfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 310, 210, 40));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Firstname", "Lastname", "Gender", "Birthdate", "Phone", "Email", "Address"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTable1KeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 100, 580, 340));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1094, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pay_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pay_buttonActionPerformed

       int yes_no = JOptionPane.showConfirmDialog(null, "Are you sure for Payment?","Confirmation Message",JOptionPane.YES_NO_OPTION,2);
        
       if(yes_no == JOptionPane.YES_OPTION){
           if(amount_textfield.getText().equals("")){
               JOptionPane.showMessageDialog(null, "One Or More Empty Field!");
           }
           else{
               mail = email_textfield.getText().toString();
           int stdid = Integer.valueOf(studentid_textfield.getText());
           int crsid = Integer.valueOf(c.getcourseid(courseid_combobox.getSelectedItem().toString()));
           String pay = String.valueOf(pay_jComboBox.getSelectedItem().toString());
           String month = String.valueOf(month_jComboBox.getSelectedItem().toString());
           int amnt = Integer.valueOf(amount_textfield.getText());
       
           p.insertUpdateDeleteStudent('i', stdid, crsid, pay, month,amnt);
           sendemail();
           studentid_textfield.setText("");
           amount_textfield.setText("");
           email_textfield.setText("");
           }
           
       }
       else{
           
       }
       
       
    }//GEN-LAST:event_pay_buttonActionPerformed

    private void Close_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Close_buttonActionPerformed
        this.dispose();
    }//GEN-LAST:event_Close_buttonActionPerformed

    private void pay_jComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pay_jComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pay_jComboBoxActionPerformed

    private void month_jComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_month_jComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_month_jComboBoxActionPerformed

    private void studentid_textfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentid_textfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_studentid_textfieldActionPerformed

    private void email_textfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_email_textfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_email_textfieldActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

       int rowindex = jTable1.getSelectedRow();
       studentid_textfield.setText(jTable1.getValueAt(rowindex, 0).toString());
       email_textfield.setText(jTable1.getValueAt(rowindex, 6).toString());

       

    }//GEN-LAST:event_jTable1MouseClicked

    private void jTable1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyReleased

       
    }//GEN-LAST:event_jTable1KeyReleased
    
    private void sendemail(){
        
       
        String host="smtp.gmail.com";  
        final String user = "k1fightclub2020@gmail.com";
        final String password="VaggelisK1!@";
        

        String to = mail;

    //imported code
        Properties props = new Properties(); 
        props.put("mail.smtp.host", "smtp.gmail.com"); 
        props.put("mail.smtp.auth", "true"); 
        props.put("mail.smtp.port", "587"); 
        props.put("mail.smtp.starttls.enable", "true"); 
        props.put("mail.smtp.ssl.trust", "*");

        Session session = Session.getDefaultInstance(props,  
        new javax.mail.Authenticator() {  
            protected PasswordAuthentication getPasswordAuthentication() {  
                return new PasswordAuthentication(user,password);  
            }  
        });  

        
        try {  
         MimeMessage message = new MimeMessage(session);  
         message.setFrom(new InternetAddress(user));  
         message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));  
         message.setSubject("Payment K1 Fight Club ( month : " + month_jComboBox.getSelectedItem().toString()+" )");  
         message.setText("Hello,\nYour payment has been processed successfully for the month of " + month_jComboBox.getSelectedItem().toString()+"!"+"\n\n"+"Vaggelis Moustakas,\n"+"K1 Figth Club!");  


         Transport.send(message);  

         System.out.println("message sent!");  

        } 
        catch (MessagingException mex) 
        {
            System.out.println("Error: unable to send message....");
            mex.printStackTrace();
        }
    }
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
            java.util.logging.Logger.getLogger(PayForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PayForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PayForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PayForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PayForm().setVisible(true);
            }
        });
        
      
     }  
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Close_button;
    private javax.swing.JLabel addstudent_label;
    private javax.swing.JLabel amount_label;
    private javax.swing.JTextField amount_textfield;
    private javax.swing.JComboBox<String> courseid_combobox;
    private javax.swing.JLabel coursename_label;
    private javax.swing.JLabel description_label;
    private javax.swing.JLabel email_label;
    private javax.swing.JTextField email_textfield;
    private javax.swing.JLabel hours_label;
    private javax.swing.JLabel id_label;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JTable jTable1;
    private javax.swing.JComboBox<String> month_jComboBox;
    private javax.swing.JButton pay_button;
    private javax.swing.JComboBox<String> pay_jComboBox;
    private javax.swing.JTextField studentid_textfield;
    // End of variables declaration//GEN-END:variables
}
