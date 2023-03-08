
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author balas
 */
public class student {
    
    
    public void insertUpdateDeleteStudent(char operation, Integer id, String fname, 
                                                String lname, String gender,
					        String birthday, String phone, String email, String address,String emergencyphone) {
			
		Connection con = MyConnection.getConnection();
		PreparedStatement ps;
		
		if(operation == 'i') {  //i for insert
			try {
				ps = con.prepareStatement("INSERT INTO student(first_name, last_name, gender, birthdate, phone, email , address, emergencyphone) VALUES (?,?,?,?,?,?,?,?)");
				
				ps.setString(1, fname);
				ps.setString(2, lname);
				ps.setString(3, gender);
				ps.setString(4, birthday);
				ps.setString(5, phone);
                                ps.setString(6, email);
				ps.setString(7, address);
                                ps.setString(8, emergencyphone);
                               
				
				if(ps.executeUpdate()>0) {
					JOptionPane.showMessageDialog(null, "New Student Added!");
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
                
                
                if(operation == 'u') {  //u for update
			try {
				ps = con.prepareStatement("UPDATE `student` SET `first_name`= ? , `last_name`= ? , `gender`= ? , `birthdate`= ? , `phone`= ? , `email`= ?,`address`= ? ,`emergencyphone`= ? WHERE `id`= ?");
				
				ps.setString(1, fname);
				ps.setString(2, lname);
				ps.setString(3, gender);
				ps.setString(4, birthday);
				ps.setString(5, phone);
                                ps.setString(6, email);
				ps.setString(7, address);
                                ps.setString(8, emergencyphone);
                                ps.setInt(9, id);
				
			
				if(ps.executeUpdate()>0) {
					JOptionPane.showMessageDialog(null, "Student Data Updated!");
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
                
                
                if(operation == 'd') {  //d for delete
                    
                    int YesorNo = JOptionPane.showConfirmDialog(null, "The Scores will be also deleted", "Delete Student",JOptionPane.OK_CANCEL_OPTION,0);
                    
                    if (YesorNo == JOptionPane.OK_OPTION){
                        try {
                                ps = con.prepareStatement("DELETE FROM `student` WHERE `id` = ?");
                                ps.setInt(1, id);
			
				if(ps.executeUpdate()>0) {
					JOptionPane.showMessageDialog(null, "Student Deleted!");
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
                    }
                    
		}
    }
    
    
    
    public void fillStudentJtable(JTable table,String valueToSearch) {
		
        Connection con = MyConnection.getConnection();
	PreparedStatement ps;
		
        try {
				
            ps = con.prepareStatement("SELECT * FROM `student` WHERE CONCAT(`first_name`,`last_name`, `gender` , `birthdate`, `phone`,`email`,`address`,`emergencyphone`)LIKE ?");
            ps.setString(1, "%"+valueToSearch+"%");
            ResultSet rs = ps.executeQuery();
            DefaultTableModel model = (DefaultTableModel)table.getModel();
				
			
            Object[] row;
			    
            while (rs.next()) {
                row = new Object[9];
		row[0] = rs.getInt(1);
		row[1] = rs.getString(2);  
		row[2] = rs.getString(3);
		row[3] = rs.getString(4);
		row[4] = rs.getString(5);
		row[5] = rs.getString(6);
                row[6] = rs.getString(7);
                row[7] = rs.getString(8);
                row[8] = rs.getString(9);
                
                model.addRow(row);
				    
            }		
	} 
        catch (SQLException e) {
            e.printStackTrace();
        }
		
		
    }
    
    public void fillPayJtable(JTable table) {
		
        Connection con = MyConnection.getConnection();
	PreparedStatement ps;
		
        try {		
            ps = con.prepareStatement("SELECT * FROM `money`");
            ResultSet rs = ps.executeQuery();
            DefaultTableModel model = (DefaultTableModel)table.getModel();		
			
            Object[] row;
			    
            while (rs.next()) {
                row = new Object[4];
		row[0] = rs.getInt(1);
		row[1] = rs.getString(2);
		row[2] = rs.getString(3);
                row[3] = rs.getString(4);
                
                model.addRow(row);	    
            }		
	} 
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
