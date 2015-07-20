package model;

import java.sql.Date;

public class Wip {
	
	private int id;
	private String name;
	private String quantity;
	private Date date1;
	
	public Date getDate1() {
		return date1;
	}
	public void setDate1(Date sql) {
		this.date1 = sql;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	

}
