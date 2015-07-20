package model;

import java.sql.Date;

public class RawMaterials{

    private String id;
    private String name;
    private String vendor;
	private Date date;
    private String inward;
    private String rejected;
    private String accepted;
    private String materialCost;
    private String expense;
    private String outward;
    private String unit;
    private String category;
    private Date rejectedDate;
    private String closing_stock;
    private String reorder_level;
    
	public String getClosing_stock() {
		return closing_stock;
	}
	public void setClosing_stock(String closing_stock) {
		this.closing_stock = closing_stock;
	}
	public String getReorder_level() {
		return reorder_level;
	}
	public void setReorder_level(String reorder_level) {
		this.reorder_level = reorder_level;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getOutward() {
		return outward;
	}
	public void setOutward(String outward) {
		this.outward = outward;
	}
	public String getMaterialCost() {
		return materialCost;
	}
	public void setMaterialCost(String materialCost) {
		this.materialCost = materialCost;
	}
	public String getExpense() {
		return expense;
	}
	public void setExpense(String expense) {
		this.expense = expense;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getInward() {
		return inward;
	}
	public void setInward(String inward) {
		this.inward = inward;
	}
	public Date getDate() {
		return date;
	}
	public String getRejected() {
		return rejected;
	}
	public void setRejected(String rejected) {
		this.rejected = rejected;
	}
	public String getAccepted() {
		return accepted;
	}
	public void setAccepted(String accepted) {
		this.accepted = accepted;
	}
	public void setDate(Date date) {
		this.date = date;
	}
    public String getVendor() {
		return vendor;
	}
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
	public Date getRejectedDate() {
		return rejectedDate;
	}
	public void setRejectedDate(Date rejectedDate) {
		this.rejectedDate = rejectedDate;
	}  
   
}