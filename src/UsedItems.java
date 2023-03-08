import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
public class UsedItems {
    
    public void insertUpdateDeleteStudent(char operation, Integer Sid, Integer Cid, String used_item, String date) {
			
		Connection con = MyConnection.getConnection();
		PreparedStatement ps;
		
		if(operation == 'i') {  //i for insert
			try {
				ps = con.prepareStatement("INSERT INTO `useditems`(`student_id`, `course_id`, `used_item`, `date` ) VALUES (? , ?, ?, ?)");
				
				ps.setInt(1, Sid);
				ps.setInt(2, Cid);
				ps.setString(3, used_item);
                                ps.setString(4, date);
				
                                if(ps.executeUpdate()>0) {
					JOptionPane.showMessageDialog(null, "New Used Item Added!");
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
                

                if(operation == 'u') {  //u for update
			try {
				ps = con.prepareStatement("UPDATE `useditems` SET `course_id`= ? ,`used_item`= ? ,`date`= ?  WHERE `id`= ?");
				
				ps.setInt(1, Sid);
				ps.setInt(2, Cid);
				ps.setString(3, used_item);
                                ps.setString(4, date);
				if(ps.executeUpdate()>0) {
					JOptionPane.showMessageDialog(null, "Used item Updated!");
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
            ps = con.prepareStatement("SELECT * FROM `useditems`");
            ResultSet rs = ps.executeQuery();
            DefaultTableModel model = (DefaultTableModel)table.getModel();		
			
            Object[] row;
			    
            while (rs.next()) {
                row = new Object[4];
		row[0] = rs.getInt(1);
		row[1] = rs.getInt(2);
		row[2] = rs.getString(3);
                row[3] = rs.getString(4);
                model.addRow(row);	    
            }		
	} 
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    
    public void showAllUsedItems(JTable table) {
		
        Connection con = MyConnection.getConnection();
	PreparedStatement ps;
		
        try {		
            
            
            ps = con.prepareStatement("SELECT `student_id`, first_name, last_name, course_name, used_item, date \n" +
                                        "FROM `useditems`\n" +
                                        "INNER JOIN student as stab on stab.id = `student_id`\n" +
                                        "INNER JOIN course as ctab on ctab.id = `course_id`");
            ResultSet rs = ps.executeQuery();
            DefaultTableModel model = (DefaultTableModel)table.getModel();		
			
            Object[] row;
			    
            while (rs.next()) {
                row = new Object[6];
		row[0] = rs.getInt(1);
		row[1] = rs.getString(2);
		row[2] = rs.getString(3);
                row[3] = rs.getString(4);
                row[4] = rs.getString(5);
                row[5] = rs.getString(6);
                
                model.addRow(row);	    
            }		
	} 
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}