package dao;

import java.sql.Connection;  
import java.sql.PreparedStatement;  
import java.sql.SQLException;

import util.DbUtil;
import model.User;

public class RegisterDao {

private Connection connection;
	
    public RegisterDao() {
    	connection =DbUtil.getConnection();
	}
    
    public boolean insert(User user) {
    	
    	boolean status = true;
    	
    	 try {
             PreparedStatement preparedStatement = connection
                     .prepareStatement("insert into user(name,password,email) values (?, ?, ? )");
             preparedStatement.setString(1, user.getUserName());
             preparedStatement.setString(2, user.getPassword());
             preparedStatement.setString(3, user.getEmail());
             preparedStatement.executeUpdate();

         } catch (SQLException e) {
             //e.printStackTrace();
        	 status=false;
         }
    	 
    	return status;
    }
		
}
