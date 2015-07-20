package dao;

import java.sql.Connection;  
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.DbUtil;
import model.Bom;
import model.RawMaterials;
import model.Units;
import model.Process;

public class MasterDao {

	private Connection connection;
	
	 public MasterDao() {
		 connection =DbUtil.getConnection();
	}
	 
	 public boolean insertUnit(Units unit) {
		 boolean status = true;
		 
		 try {
             PreparedStatement preparedStatement = connection
                     .prepareStatement("insert into units(name,unit) values (?, ? )");
             preparedStatement.setString(1, unit.getName());
             preparedStatement.setString(2, unit.getUnit());
             preparedStatement.executeUpdate();

         } catch (SQLException e) {
             //e.printStackTrace();
             status=false;
         }
		 
		 return status;
	 }
	 
	 public boolean insertRawMaterial(RawMaterials rawMaterials) {
		 boolean status = true;
		 
		 try {
             PreparedStatement preparedStatement = connection
                     .prepareStatement("insert into raw_db(name,unit,category) values (?, ?, ? )");
             preparedStatement.setString(1, rawMaterials.getName());
             preparedStatement.setString(2, rawMaterials.getUnit());
             preparedStatement.setString(3, rawMaterials.getCategory());
             preparedStatement.executeUpdate();

         } catch (SQLException e) {
            // e.printStackTrace();
             status=false;
         }
		 
		 return status;
	 }
	 
	 public boolean insertBom(String[] bom) {
		 boolean status = true;
		 
		 try {
             PreparedStatement preparedStatement = connection
                     .prepareStatement("insert into bom(raw1,raw2,raw3,raw4,raw5) values (?, ?, ?, ?, ? )");
             preparedStatement.setString(1, bom[1]);
             preparedStatement.setString(2, bom[2]);
             preparedStatement.setString(3, bom[3]);
             preparedStatement.setString(4, bom[4]);
             preparedStatement.setString(5,bom[5]);
             preparedStatement.executeUpdate();

         } catch (SQLException e) {
            // e.printStackTrace();
             status=false;
         }
		 
		 return status;
		 
	 }
	 
	 public boolean insertProcess(Process process1) {
		 
		 boolean status = true;
		 
		 try {
             PreparedStatement preparedStatement = connection
                     .prepareStatement("insert into process(name,partno,unit,category,bom_id) values (?, ?, ?, ?, ? )");
             preparedStatement.setString(1, process1.getName() );
             preparedStatement.setString(2, process1.getPartno());
             preparedStatement.setString(3, process1.getUnit());
             preparedStatement.setString(4, process1.getCategory());
             preparedStatement.setInt(5, process1.getBomId());
             preparedStatement.executeUpdate();

         } catch (SQLException e) {
            e.printStackTrace();
             status=false;
         }
		 
		 return status;
	 }
	 
	 public int selectBom() {
		 
		 int bom_id = 0;
		 
		 try {
			 PreparedStatement statement = connection.prepareStatement("select id from bom");
			 ResultSet rs = statement.executeQuery();
			 while(rs.next()) {
				 bom_id = rs.getInt("id");
			 }

         } catch (SQLException e) {
             e.printStackTrace();
         }
		 
		 return bom_id;
	 }
}
