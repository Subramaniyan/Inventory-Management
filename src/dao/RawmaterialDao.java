package dao;

import java.sql.Connection;  
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.DbUtil;
import model.RawMaterials;
  
public class RawmaterialDao {
	
	private Connection connection;
	
	 public RawmaterialDao() {
		 connection =DbUtil.getConnection();
	}

	//@SuppressWarnings("resource")
	public boolean insert(RawMaterials rawMaterial) {
		
		boolean status = true;
		 
		 try {
			 PreparedStatement preparedStatement = connection
	                    .prepareStatement("select name from rawmaterials where name=?");
			 preparedStatement.setString(1, rawMaterial.getName());
	         ResultSet rs = preparedStatement.executeQuery();
	         
	         if (rs.next()) {
	            preparedStatement = connection
	                    .prepareStatement("update rawmaterials set quantity=quantity+?, inward= inward+?, outward=outward+?, rejection=rejection+?" + 
	                    										"where name=?");
	            //preparedStatement.setString(1, rawMaterial.getQuantity());
	            preparedStatement.setString(2, rawMaterial.getInward());
	           // preparedStatement.setString(3, rawMaterial.getOutward());
	          //  preparedStatement.setString(4, rawMaterial.getRejection());
	            preparedStatement.setString(5, rawMaterial.getName());
	            preparedStatement.executeUpdate();
	         }
	        /* else {
	        	 preparedStatement = connection
		                    .prepareStatement("insert into rawmaterials(name,quantity,unit,category,inward,outward,rejection) values (?, ?, ?, ?, ? ,?,?)");
		            preparedStatement.setString(1, rawMaterial.getName());
		            preparedStatement.setString(2, rawMaterial.getQuantity());
		            preparedStatement.setString(3, rawMaterial.getUnit());
		            preparedStatement.setString(4, rawMaterial.getCategory());
		            preparedStatement.setString(5, rawMaterial.getInward());
		            preparedStatement.setString(6, rawMaterial.getOutward());
		            preparedStatement.setString(7, rawMaterial.getRejection());
		            preparedStatement.executeUpdate();
	         }
			*/
	        } catch (SQLException e) {
	           // e.printStackTrace();
	            status = false;
	        }
		return status;  
		 
	 }
	        
}
