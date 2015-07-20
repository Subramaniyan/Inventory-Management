package dao;

import java.sql.Connection;  
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.DbUtil;
import model.RawMaterials;

public class DisplayDao {

	private Connection connection;
	
	 public DisplayDao() {
		 connection =DbUtil.getConnection();
	}
	 
	 @SuppressWarnings("resource")
	public List<RawMaterials> getAllRawmaterial(String category) {
	        List<RawMaterials> rawMaterials = new ArrayList<RawMaterials>();
	        try {
	        	
	        	PreparedStatement preparedStatement = connection.prepareStatement("select name from raw_db where category = ? ");
	            preparedStatement.setString(1, category);
	            ResultSet rs = preparedStatement.executeQuery();
	            
	            while (rs.next()) {
	            	
	            	String name = rs.getString("name");
	                preparedStatement = connection.prepareStatement("select * from rawmaterials where name = ? ");
		            preparedStatement.setString(1, name);
		            rs = preparedStatement.executeQuery();
		            
		            while (rs.next()) {
		            	RawMaterials rawMaterial = new RawMaterials();
		            	rawMaterial.setName(rs.getString("name"));
		            	rawMaterial.setDate(rs.getDate("date1"));
		            	rawMaterial.setInward(rs.getString("inward"));
		            	rawMaterial.setAccepted(rs.getString("accepted"));
		            	rawMaterial.setRejected(rs.getString("rejected"));
		            	rawMaterial.setVendor(rs.getString("vendor"));
		            	rawMaterial.setClosing_stock(rs.getString("closing_stock"));
		            	rawMaterials.add(rawMaterial);
		            }
	            	
	            }
	            
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return rawMaterials;
	    }
	 
	 public List<RawMaterials> getAllRawmaterial(Date date) {
	        List<RawMaterials> rawMaterials = new ArrayList<RawMaterials>();
	        try {
	        	
	        	PreparedStatement preparedStatement = connection.prepareStatement("select * from rawmaterials where date = ? ");
	            preparedStatement.setDate(1, date);
	            ResultSet rs = preparedStatement.executeQuery();
	            
	            while (rs.next()) {
	            	RawMaterials rawMaterial = new RawMaterials();
	            	rawMaterial.setName(rs.getString("name"));
	            	rawMaterial.setDate(rs.getDate("date1"));
	            	rawMaterial.setInward(rs.getString("inward"));
	            	rawMaterial.setAccepted(rs.getString("accepted"));
	            	rawMaterial.setRejected(rs.getString("rejected"));
	            	rawMaterial.setVendor(rs.getString("vendor"));
	            	rawMaterial.setClosing_stock(rs.getString("closing_stock"));
	            	rawMaterials.add(rawMaterial);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return rawMaterials;
	    }
	
	 
	 public List<RawMaterials> getRawmaterial(String name) {
	        List<RawMaterials> rawMaterials = new ArrayList<RawMaterials>();
	        try {
	        	
	        	PreparedStatement preparedStatement = connection.prepareStatement("select * from rawmaterials where name = ? ");
	            preparedStatement.setString(1, name);
	            ResultSet rs = preparedStatement.executeQuery();
	            
	            while (rs.next()) {
	            	RawMaterials rawMaterial = new RawMaterials();
	            	rawMaterial.setName(rs.getString("name"));
	            	rawMaterial.setDate(rs.getDate("date1"));
	            	rawMaterial.setInward(rs.getString("inward"));
	            	rawMaterial.setAccepted(rs.getString("accepted"));
	            	rawMaterial.setRejected(rs.getString("rejected"));
	            	rawMaterial.setVendor(rs.getString("vendor"));
	            	rawMaterial.setClosing_stock(rs.getString("closing_stock"));
	            	rawMaterials.add(rawMaterial);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return rawMaterials;
	    }
}
