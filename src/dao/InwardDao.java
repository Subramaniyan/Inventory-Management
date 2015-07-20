package dao;

import java.sql.Connection;  
import java.sql.PreparedStatement;
import java.sql.SQLException;

import util.DbUtil;
import model.RawMaterials;

public class InwardDao {
	
	private Connection connection;
	
	 public InwardDao() {
		 connection =DbUtil.getConnection();
	}
	 
	 public boolean insert(RawMaterials rawMaterial) {
			
			boolean status = true;
			 
			try {
			 
					PreparedStatement preparedStatement = connection
		                    .prepareStatement("insert into rawmaterials(name,date1,inward,rejected,accepted,vendor,materialCost,expense,closing_stock) values (?, ?, ?, ?, ? ,?, ?, ?, ?)");
		            preparedStatement.setString(1, rawMaterial.getName());
		            preparedStatement.setDate(2, rawMaterial.getDate());
		            preparedStatement.setString(3, rawMaterial.getInward());
		            preparedStatement.setString(4, rawMaterial.getRejected());
		            preparedStatement.setString(5, rawMaterial.getAccepted());
		            preparedStatement.setString(6, rawMaterial.getVendor());
		            preparedStatement.setString(7,rawMaterial.getMaterialCost());
		            preparedStatement.setString(8, rawMaterial.getExpense());
		            preparedStatement.setString(9, rawMaterial.getAccepted());
		            preparedStatement.executeUpdate();
		            
		            preparedStatement = connection.prepareStatement("update raw_db set quantity = quantity + ? where name = ?");
		            preparedStatement.setString(1, rawMaterial.getAccepted());
		            preparedStatement.setString(2, rawMaterial.getName());
		            preparedStatement.executeUpdate();
				 
			 } catch (SQLException e) {
		           // e.printStackTrace();
		            status = false;
		       }
			return status;
	}

}
