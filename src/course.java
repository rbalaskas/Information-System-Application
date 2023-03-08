
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
public class course {
    
    
    public void insertUpdateDeleteStudent(char operation, Integer id, String label, String teacher) {
			
		Connection con = MyConnection.getConnection();
		PreparedStatement ps;
		
		if(operation == 'i') {  //i for insert
			try {
				ps = con.prepareStatement("INSERT INTO `course`(`course_name`, `Teacher`) VALUES (?,?)");
				
				ps.setString(1, label);
				ps.setString(2, teacher);
				
                                if(ps.executeUpdate()>0) {
					JOptionPane.showMessageDialog(null, "New Course Added!");
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
                
                
                if(operation == 'u') {  //u for update
			try {
				ps = con.prepareStatement("UPDATE `course` SET `course_name`= ? ,`Teacher`= ? WHERE `id`= ?");
				
				ps.setString(1, label);
				ps.setString(2, teacher);
                                ps.setInt(4, id);
				if(ps.executeUpdate()>0) {
					JOptionPane.showMessageDialog(null, "Course Data Updated!");
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
                
                
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
                    
		}
    }
    
    
    public boolean isExist(String courseName){
        
        boolean exist = false;
        Connection con = MyConnection.getConnection();
        PreparedStatement ps;
        try {
				
            ps = con.prepareStatement("SELECT * FROM `course` WHERE `course_name` = ? ");
            ps.setString(1, courseName);
            ResultSet rs = ps.executeQuery();
			    
            if(rs.next()) {
               exist = false;
            }		
            else{
               exist = false;
           } 
	} 
        catch (SQLException e) {
            e.printStackTrace();
        }
        
        
        return exist;
    }
    
    
     
    public void fillCourseJtable(JTable table) {
		
        Connection con = MyConnection.getConnection();
	PreparedStatement ps;
		
        try {
				
            ps = con.prepareStatement("SELECT * FROM `course`");
            ResultSet rs = ps.executeQuery();
            DefaultTableModel model = (DefaultTableModel)table.getModel();
				
			
            Object[] row;
			    
            while (rs.next()) {
                row = new Object[3];
		row[0] = rs.getInt(1);
		row[1] = rs.getString(2);
		row[2] = rs.getString(3);
                
                model.addRow(row);
				    
            }		
	} 
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    public int getcourseid(String courselabel){
       
        int courseid = 0;
        
        Connection con = MyConnection.getConnection();
        PreparedStatement ps;
        try {
				
            ps = con.prepareStatement("SELECT * FROM `course` WHERE `course_name` = ? ");
            ps.setString(1, courselabel);
            
            ResultSet rs = ps.executeQuery();
			    
            if(rs.next()) {
               courseid = rs.getInt("id");
            }		
            
	} 
        catch (SQLException e) {
            e.printStackTrace();
        }
        
        return courseid;
        
    }
    
    
    
    public void fillCourseCombo(JComboBox combo) {
		
        Connection con = MyConnection.getConnection();
	PreparedStatement ps;
		
        try {
				
            ps = con.prepareStatement("SELECT * FROM `course`");
            ResultSet rs = ps.executeQuery();
			    
            while (rs.next()) {
				    
                combo.addItem(rs.getString(2));
            }		
	} 
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
