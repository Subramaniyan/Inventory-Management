package dao;

import java.sql.Connection;  
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

import util.DbUtil;
import model.Wip;

public class WipDao {
	
	private Connection connection;
	
	 public WipDao() {
		 connection =DbUtil.getConnection();
	}
	
	public boolean insertWip(Wip wip) {
		 
		 boolean status = true;
		 int bom_id=0;
		 int quans , reduceQuans=0 ;
		 String[] rawMaterial = new String[50] ;//{ "null","null","null","null","null"};
		 String[] quantity = new String[50]; // { "0", "0", "0", "0", "0" };
		 String[] words =new String[2];
		 Arrays.fill(rawMaterial, "null");
		 Arrays.fill(quantity, "0");
		 
		 try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into wip(name,quantity,date1) values (?, ?, ? )");
            preparedStatement.setString(1, wip.getName());
            preparedStatement.setString(2, wip.getQuantity());
            preparedStatement.setDate(3, wip.getDate1());
            preparedStatement.executeUpdate();
            
            preparedStatement = connection.prepareStatement("select bom_id from process where name=?");
            preparedStatement.setString(1,  wip.getName());
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()) {
           	 bom_id = rs.getInt("bom_id");
            }
            
            preparedStatement = connection.prepareStatement("select * from bom where id=?");
            preparedStatement.setInt(1,  bom_id);
            rs = preparedStatement.executeQuery();
            
            while(rs.next()) {
            	
            	for(int i=0;i<5;i++) {
            		rawMaterial[i] = "null";
            		quantity[i]="0";            		
            		words = rs.getString("raw"+(i+1)).split("\\-");
                   	if(words.length>0) {
                   		rawMaterial[i] = words[0];
                       	quantity[i] = words[1];
                   	}
                	    
            	}
            	
           	/*words = rs.getString("raw1").split("\\-");
           	if(words.length>0) {
           		rawMaterial[0] = words[0];
               	quantity[0] = words[1];
           	}
        	          	
           	words = rs.getString("raw2").split("\\-");
           	if(words.length>0) {
           		rawMaterial[1] = words[0];
               	quantity[1] = words[1];
           	}
           	           	
           	words = rs.getString("raw3").split("\\-");
           	if(words.length>0) {
           		rawMaterial[2] = words[0];
               	quantity[2] = words[1];
           	}
                      	
           	words = rs.getString("raw4").split("\\-");
           	if(words.length>0) {
           		rawMaterial[3] = words[0];
               	quantity[3] = words[1];
           	}
           	
           	words = rs.getString("raw5").split("\\-");
           	if(words.length>0) {
           		rawMaterial[4] = words[0];
               	quantity[4] = words[1];
           	}*/
           	
           	for(int i=0; i<rawMaterial.length; i++) {
           		
           		if(rawMaterial[i].equals(null)) {
           			i=rawMaterial.length;
           		} 
           		else {
            		preparedStatement = connection.prepareStatement("select id from raw_db where name=?");
                    preparedStatement.setString(1,  rawMaterial[i]);
                    rs = preparedStatement.executeQuery();

                    quans = Integer.parseInt(quantity[i]) * Integer.parseInt(wip.getQuantity());
                    
                    if(rs.next()) {               	
                    	while(quans>0) {
                    		preparedStatement = connection.prepareStatement("select closing_stock from rawmaterials where name= ? and closing_stock > 0 order by id limit 1");
                    		preparedStatement.setString(1, rawMaterial[i]);
                    		rs = preparedStatement.executeQuery();
                        
                    		if(rs.next()) {
                    			reduceQuans = Integer.parseInt(rs.getString("closing_stock"));
                    		if(reduceQuans >= quans)
                    			reduceQuans=quans;
                        	quans -= reduceQuans;
                        }
                         
                    	preparedStatement = connection.prepareStatement("update rawmaterials set closing_stock = closing_stock - ? where name= ? and closing_stock > 0 order by id limit 1");
                        preparedStatement.setInt(1, reduceQuans);
                        preparedStatement.setString(2, rawMaterial[i]);
                        preparedStatement.executeUpdate();
                        
                        preparedStatement = connection.prepareStatement("update raw_db set quantity = quantity - ? where name= ? ");
                        preparedStatement.setInt(1, reduceQuans);
                        preparedStatement.setString(2, rawMaterial[i]);
                        preparedStatement.executeUpdate();
                        
                        
                    	}
                    }
                    else {
                       	while(quans>0) {
                       	preparedStatement = connection.prepareStatement("select quantity from wip where name= ? and quantity > 0 order by id limit 1");
                       	preparedStatement.setString(1, rawMaterial[i]);
                        rs = preparedStatement.executeQuery();
                           
                        if(rs.next()) {
                        	reduceQuans = Integer.parseInt(rs.getString("quantity"));
                        	if(reduceQuans>=quans)
                        		reduceQuans=quans;
                           	quans -= reduceQuans;
                           }
                            
                       	preparedStatement = connection.prepareStatement("update wip set quantity = quantity - ? where name= ? and quantity > 0 order by id limit 1");
                        preparedStatement.setInt(1, reduceQuans);
                        preparedStatement.setString(2, rawMaterial[i]);
                        preparedStatement.executeUpdate();                           
                       	}
                    }
           		}
           	}
         }
	   } catch (SQLException e) {
            //e.printStackTrace();
           	status=false;
	   }
		 return status;
	 }
}
