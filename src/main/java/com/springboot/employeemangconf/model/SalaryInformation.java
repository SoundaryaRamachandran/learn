package com.springboot.employeemangconf.model;

public class SalaryInformation {
	private int Employee_ID;
	private int Monthly_Salary ;
	private int Monthly_Taxes;
	private int Monthly_Insurances;
	private int Salary_Date;
	public int getEmployee_ID() {
		return Employee_ID;
	}
	public void setEmployee_ID(int employee_ID) {
		Employee_ID = employee_ID;
	}
	public int getMonthly_Salary() {
		return Monthly_Salary;
	}
	public void setMonthly_Salary(int monthly_Salary) {
		Monthly_Salary = monthly_Salary;
	}
	public int getMonthly_Taxes() {
		return Monthly_Taxes;
	}
	public void setMonthly_Taxes(int monthly_Taxes) {
		Monthly_Taxes = monthly_Taxes;
	}
	public int getMonthly_Insurances() {
		return Monthly_Insurances;
	}
	public void setMonthly_Insurances(int monthly_Insurances) {
		Monthly_Insurances = monthly_Insurances;
	}
	public int getSalary_Date() {
		return Salary_Date;
	}
	public void setSalary_Date(int salary_Date) {
		Salary_Date = salary_Date;
	}
	

}


