package dao;

import java.sql.Connection;  
 
import java.sql.PreparedStatement;  
import java.sql.ResultSet;  

import util.DbUtil;
import model.User;
  
public class LoginDao {  
	
	private Connection connection;
	
	
    public LoginDao() {
    	connection =DbUtil.getConnection();
	}


	public boolean validate(User user) {    
		
		boolean status = false;
        
        try {  
        	PreparedStatement preparedStatement = connection
                    .prepareStatement("select * from login where user=? and password=?");
           
        	preparedStatement.setString(1, user.getUserName());  
        	preparedStatement.setString(2, user.getPassword());  
  
        	ResultSet rs = preparedStatement.executeQuery();  
            status = rs.next();  
  
        } catch (Exception e) {  
            System.out.println(e);  
        } 
        return status;  
    }  
}  