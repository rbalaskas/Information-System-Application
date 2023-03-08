import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;
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
public class Pay {
    
    public void insertUpdateDeleteStudent(char operation, Integer Sid, Integer Cid, String pay, String description,Integer amount) {
			
		Connection con = MyConnection.getConnection();
		PreparedStatement ps;
		
		if(operation == 'i') {  //i for insert
			try {
				ps = con.prepareStatement("INSERT INTO `money`(`student_id`, `course_id`, `pay`, `description`,`amount` ) VALUES (? , ?, ?, ?, ?)");
				
				ps.setInt(1, Sid);
				ps.setInt(2, Cid);
				ps.setString(3, pay);
                                ps.setString(4, description);
                                ps.setInt(5, amount);
				
                                if(ps.executeUpdate()>0) {
					JOptionPane.showMessageDialog(null, "New Payment Added!");
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
                

                if(operation == 'u') {  //u for update
			try {
				ps = con.prepareStatement("UPDATE `money` SET `course_id`= ? ,`pay`= ? ,`description`= ? ,`amount`= ? WHERE `id`= ?");
				
				ps.setInt(1, Sid);
				ps.setInt(2, Cid);
				ps.setString(3, pay);
                                ps.setString(4, description);
                                ps.setInt(5, amount);
				if(ps.executeUpdate()>0) {
					JOptionPane.showMessageDialog(null, "Payment Data Updated!");
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
                
                             /*   
                if(operation == 'd') {  //d for delete
                    
                    int YesorNo = JOptionPane.showConfirmDialog(null, "The Scores will be also deleted", "Delete Score",JOptionPane.OK_CANCEL_OPTION,0);
                    
                    if (YesorNo == JOptionPane.OK_OPTION){
                    
                        try {
				ps = con.prepareStatement("DELETE FROM `course` WHERE `id` = ?");
                                ps.setInt(1, id);
			
				if(ps.executeUpdate()>0) {
					JOptionPane.showMessageDialog(null, "Course Deleted!");
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
                    
                    }
                    
		}*/
    }
    
     
    
    public void fillScoreJtable(JTable table) {
		
        Connection con = MyConnection.getConnection();
	PreparedStatement ps;
		
        try {		
            ps = con.prepareStatement("SELECT * FROM `money`");
            ResultSet rs = ps.executeQuery();
            DefaultTableModel model = (DefaultTableModel)table.getModel();		
			
            Object[] row;
			    
            while (rs.next()) {
                row = new Object[5];
		row[0] = rs.getInt(1);
		row[1] = rs.getInt(2);
		row[2] = rs.getString(3);
                row[3] = rs.getString(4);
                row[4] = rs.getInt(5);
                
                model.addRow(row);	    
            }		
	} 
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    
    public void showAllPayments(JTable table) {
		
        Connection con = MyConnection.getConnection();
	PreparedStatement ps;
		
        try {		
            
            ps = con.prepareStatement("SELECT `student_id`, first_name, last_name, course_name, pay, description, amount \n" +
                                        "FROM `money`\n" +
                                        "INNER JOIN student as stab on stab.id = `student_id`\n" +
                                        "INNER JOIN course as ctab on ctab.id = `course_id`");
            ResultSet rs = ps.executeQuery();
            DefaultTableModel model = (DefaultTableModel)table.getModel();		
			
            Object[] row;
			    
            while (rs.next()) {
                row = new Object[7];
		row[0] = rs.getInt(1);
		row[1] = rs.getString(2);
		row[2] = rs.getString(3);
                row[3] = rs.getString(4);
                row[4] = rs.getString(5);
                row[5] = rs.getString(6);
                row[6] = rs.getInt(7);
                
                model.addRow(row);	    
            }		
	} 
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    public void showAllboughtitems(JTable table,String valueToSearch) throws SQLException {
         
        Connection con = MyConnection.getConnection();
        PreparedStatement ps1;
         
       // Statement stmt = con.createStatement();
       // ResultSet rs1;
        try{
           //  rs1 = stmt.executeQuery("SELECT * FROM money WHERE student_id = '" + "%"+valueToSearch+"%" +"'");
            
    
            
            ps1 = con.prepareStatement("SELECT * FROM `money` WHERE CONCAT(`student_id`,`course_id`, `pay`, `description`, `amount`)LIKE ?");
           
            ps1.setString(1,"%"+valueToSearch+"%");
            ResultSet rs1 = ps1.executeQuery();
    
            DefaultTableModel model1 = (DefaultTableModel)table.getModel();		
			
            Object[] row1;
			    
            while (rs1.next()) {
                row1 = new Object[6];
		row1[0] = rs1.getInt(1);
		row1[1] = rs1.getInt(2);
		row1[2] = rs1.getString(3);
                row1[3] = rs1.getString(4);
                row1[4] = rs1.getString(5);
                
                model1.addRow(row1);	    
            }		
	} 
        catch (SQLException e) {
            e.printStackTrace();
        }
     }
    
}