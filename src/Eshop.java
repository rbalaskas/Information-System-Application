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
public class Eshop{
    
    public void insertUpdateDeleteStudent(char operation, Integer Sid, String item, Integer price, String size, String date, String Promitheutis, String Code) {
			
		Connection con = MyConnection.getConnection();
		PreparedStatement ps;
		
		if(operation == 'i') {  //i for insert
			try {
				ps = con.prepareStatement("INSERT INTO `eshop`(`student_id`, `Item`, `Price`, `Size`,`Date`, `Promitheutis`, `Code`) VALUES (? , ?, ?, ?, ?, ?, ?)");
				
				ps.setInt(1, Sid);
				ps.setString(2, item);
				ps.setInt(3, price);
                                ps.setString(4, size);
                                ps.setString(5, date);
                                ps.setString(6, Promitheutis);
                                ps.setString(7, Code);
				
                                if(ps.executeUpdate()>0) {
					JOptionPane.showMessageDialog(null, "Bought Item Added!");
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
                

                if(operation == 'u') {  //u for update
			try {
				ps = con.prepareStatement("UPDATE `eshop` SET `item`= ? ,`price`= ? ,`size`= ? ,`date`= ?,`Promitheutis`= ?, `Code`= ? WHERE `id`= ?");
				
				ps.setInt(1, Sid);
				ps.setString(2, item);
				ps.setInt(3, price);
                                ps.setString(4, size);
                                ps.setString(5, date);
                                ps.setString(6, Promitheutis);
                                ps.setString(7, Code);
                                
				if(ps.executeUpdate()>0) {
					JOptionPane.showMessageDialog(null, "Bought Item Updated!");
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
            ps = con.prepareStatement("SELECT * FROM `eshop`");
            ResultSet rs = ps.executeQuery();
            DefaultTableModel model = (DefaultTableModel)table.getModel();		
			
            Object[] row;
			    
            while (rs.next()) {
                row = new Object[5];
		row[0] = rs.getInt(1);
		row[1] = rs.getString(2);
		row[2] = rs.getInt(3);
                row[3] = rs.getString(4);
                row[4] = rs.getString(5);
                
                model.addRow(row);	    
            }		
	} 
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    
    public void showAllPayments(JTable table,String valueToSearch) {
		
        Connection con = MyConnection.getConnection();
	PreparedStatement ps;
		
        try {		
            
            ps = con.prepareStatement("SELECT `student_id`, first_name, last_name, Item, Price, Date \n" +
                                        "FROM `eshop`\n" +
                                        "INNER JOIN student as stab on stab.id = `student_id`\n");
            ResultSet rs = ps.executeQuery();
            DefaultTableModel model = (DefaultTableModel)table.getModel();		
			
            Object[] row;
			    
            while (rs.next()) {
                row = new Object[6];
		row[0] = rs.getInt(1);
		row[1] = rs.getString(2);
		row[2] = rs.getString(3);
                row[3] = rs.getString(4);
                row[4] = rs.getInt(5);
                row[5] = rs.getString(6);
                
                model.addRow(row);	    
            }		
	} 
        catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
    
     public void showAllboughtitems(JTable table,String valueToSearch) {
         
        Connection con = MyConnection.getConnection();
        PreparedStatement ps1;
         
        try{
            ps1 = con.prepareStatement("SELECT * FROM `eshop` WHERE CONCAT(`student_id`, `Item`, `Price`, `Size`, `Date`, `Promitheutis`, `Code`)LIKE ?");
            ps1.setString(1,"%"+valueToSearch+"%");
            ResultSet rs1 = ps1.executeQuery();
            DefaultTableModel model1 = (DefaultTableModel)table.getModel();		
			
            Object[] row1;
			    
            while (rs1.next()) {
                row1 = new Object[7];
		row1[0] = rs1.getInt(1);
		row1[1] = rs1.getString(2);
		row1[2] = rs1.getInt(3);
                row1[3] = rs1.getString(4);
                row1[4] = rs1.getString(5);
                row1[5] = rs1.getString(6);
                row1[6] = rs1.getString(7);
                
                model1.addRow(row1);	    
            }		
	} 
        catch (SQLException e) {
            e.printStackTrace();
        }
     }
    
    
}