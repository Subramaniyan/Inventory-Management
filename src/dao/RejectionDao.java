package dao;

import java.sql.Connection;  
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import util.DbUtil;
import model.RawMaterials;

public class RejectionDao {
	
	private Connection connection;
	
	 public RejectionDao() {
		 connection =DbUtil.getConnection();
	}
	 
	 public boolean insert(RawMaterials rawMaterial) {
			
			boolean status = true;
			 
			try {
				
				PreparedStatement preparedStatement = connection.prepareStatement("insert into rejection(name,outward,inward_date,rejected_date) values(?, ?, ?, ?)");
				preparedStatement.setString(1, rawMaterial.getName());
				preparedStatement.setString(2, rawMaterial.getOutward());
				preparedStatement.setDate(3, rawMaterial.getDate());
				preparedStatement.setDate(4, rawMaterial.getRejectedDate());
				preparedStatement.executeUpdate();
				
		       	 preparedStatement = connection
			                    .prepareStatement("update rawmaterials set rejected=rejected-? where id = ?" );
		       	 
		       	 preparedStatement.setString(1,rawMaterial.getOutward());
		       	 preparedStatement.setString(2, rawMaterial.getId());
		       	 preparedStatement.executeUpdate();

			 } catch (SQLException e) {
		          e.printStackTrace();
		          status = false;
		       }
			return status;
	}

	public List<RawMaterials> getAllRawmaterial() {
        List<RawMaterials> rawMaterials = new ArrayList<RawMaterials>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from rawmaterials where rejected>0");
            while (rs.next()) {
            	RawMaterials rawMaterial = new RawMaterials();
            	rawMaterial.setId(rs.getString("id"));
            	rawMaterial.setName(rs.getString("name"));
            	rawMaterial.setDate(rs.getDate("date1"));
            	rawMaterial.setInward(rs.getString("inward"));
            	rawMaterial.setAccepted(rs.getString("accepted"));
            	rawMaterial.setRejected(rs.getString("rejected"));
            	rawMaterials.add(rawMaterial);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rawMaterials;
    }

}
