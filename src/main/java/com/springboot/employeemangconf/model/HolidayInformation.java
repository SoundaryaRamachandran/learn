package com.springboot.employeemangconf.model;

public class HolidayInformation {

	private int Employee_ID;
	private String Holiday ;
	private int h_From_Date_Day;
	public String getHoliday() {
		return Holiday;
	}
	public void setHoliday(String holiday) {
		Holiday = holiday;
	}
	private String h_From_Date_Month;
	private int h_From_Date_Year;
	public int getEmployee_ID() {
		return Employee_ID;
	}
	public void setEmployee_ID(int employee_ID) {
		Employee_ID = employee_ID;
	}
	public int getH_From_Date_Day() {
		return h_From_Date_Day;
	}
	public void setH_From_Date_Day(int h_From_Date_Day) {
		this.h_From_Date_Day = h_From_Date_Day;
	}
	public String getH_From_Date_Month() {
		return h_From_Date_Month;
	}
	public void setH_From_Date_Month(String h_From_Date_Month) {
		this.h_From_Date_Month = h_From_Date_Month;
	}
	public int getH_From_Date_Year() {
		return h_From_Date_Year;
	}
	public void setH_From_Date_Year(int h_From_Date_Year) {
		this.h_From_Date_Year = h_From_Date_Year;
	}
	public int getH_To_Date_Day() {
		return h_To_Date_Day;
	}
	public void setH_To_Date_Day(int h_To_Date_Day) {
		this.h_To_Date_Day = h_To_Date_Day;
	}
	public String getH_To_Date_Month() {
		return h_To_Date_Month;
	}
	public void setH_To_Date_Month(String h_To_Date_Month) {
		this.h_To_Date_Month = h_To_Date_Month;
	}
	public int getH_To_Date_Year() {
		return h_To_Date_Year;
	}
	public void setH_To_Date_Year(int h_To_Date_Year) {
		this.h_To_Date_Year = h_To_Date_Year;
	}
	private int h_To_Date_Day;
	private String h_To_Date_Month;
	private int h_To_Date_Year;

}



