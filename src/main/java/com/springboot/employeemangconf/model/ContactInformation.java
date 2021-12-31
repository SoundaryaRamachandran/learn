package com.springboot.employeemangconf.model;

/**
 * @author Soundarya
 */
public class ContactInformation {
	private int Employee_ID;
	private String c_First_Name;
	private String c_Middle_Name;
	private String c_Last_Name;
	private int Cellular_Phone;
	private int Home_Phone;
	private String City;
	private String Address;
	public int getEmployee_ID() {
		return Employee_ID;
	}
	public void setEmployee_ID(int employee_ID) {
		Employee_ID = employee_ID;
	}
	public String getC_First_Name() {
		return c_First_Name;
	}
	public void setC_First_Name(String c_First_Name) {
		this.c_First_Name = c_First_Name;
	}
	public String getC_Middle_Name() {
		return c_Middle_Name;
	}
	public void setC_Middle_Name(String c_Middle_Name) {
		this.c_Middle_Name = c_Middle_Name;
	}
	public String getC_last_Name() {
		return c_Last_Name;
	}
	public void setC_last_Name(String c_last_Name) {
		this.c_Last_Name = c_last_Name;
	}
	public int getCellular_Phone() {
		return Cellular_Phone;
	}
	public void setCellular_Phone(int cellular_Phone) {
		Cellular_Phone = cellular_Phone;
	}
	public int getHome_Phone() {
		return Home_Phone;
	}
	public void setHome_Phone(int home_Phone) {
		Home_Phone = home_Phone;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
}




