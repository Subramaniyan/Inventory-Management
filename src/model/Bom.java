package model;

public class Bom {
	
	private int id;
	private String[] rawMaterial = new String[50];
	private String raw1;
	private String raw2;
	private String raw3;
	private String raw4;
	private String raw5;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRaw1() {
		return raw1;
	}
	public void setRaw1(String raw1) {
		this.raw1 = raw1;
	}
	public String getRaw2() {
		return raw2;
	}
	public void setRaw2(String raw2) {
		this.raw2 = raw2;
	}
	public String getRaw3() {
		return raw3;
	}
	public void setRaw3(String raw3) {
		this.raw3 = raw3;
	}
	public String getRaw4() {
		return raw4;
	}
	public void setRaw4(String raw4) {
		this.raw4 = raw4;
	}
	public String getRaw5() {
		return raw5;
	}
	public void setRaw5(String raw5) {
		this.raw5 = raw5;
	}
	public String[] getRawMaterial() {
		return rawMaterial;
	}
	public void setRawMaterial(String[] rawMaterial) {
		this.rawMaterial = rawMaterial;
	}
	

}
