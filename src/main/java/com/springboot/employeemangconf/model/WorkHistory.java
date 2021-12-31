package com.springboot.employeemangconf.model;

public class WorkHistory {
	private int Employee_ID;
	private  String Company_Name ;
	private String Employer_Name;
	private String Company_Employer_Address;
	private int Company_Employer_Cellular_Phone;
	private int Company_Employer_Office_Phone;
	private String Previous_Qualication;
	private String Previous_Experience;
	public int getEmployee_ID() {
		return Employee_ID;
	}
	public void setEmployee_ID(int employee_ID) {
		Employee_ID = employee_ID;
	}
	public String getCompany_Name() {
		return Company_Name;
	}
	public void setCompany_Name(String company_Name) {
		Company_Name = company_Name;
	}
	public String getEmployer_Name() {
		return Employer_Name;
	}
	public void setEmployer_name(String Employer_Name) {
		this.Employer_Name = Employer_Name;
	}
	public String getCompany_Employer_Address() {
		return Company_Employer_Address;
	}
	public void setCompany_Employer_Address(String company_Employer_Address) {
		Company_Employer_Address = company_Employer_Address;
	}
	public int getCompany_Employer_Cellular_Phone() {
		return Company_Employer_Cellular_Phone;
	}
	public void setCompany_Employer_Cellular_Phone(int company_Employer_Cellular_Phone) {
		Company_Employer_Cellular_Phone = company_Employer_Cellular_Phone;
	}
	public int getCompany_Employer_Office_Phone() {
		return Company_Employer_Office_Phone;
	}
	public void setCompany_Employer_Office_Phone(int company_Employer_Office_Phone) {
		Company_Employer_Office_Phone = company_Employer_Office_Phone;
	}
	public String getPrevious_Qualication() {
		return Previous_Qualication;
	}
	public void setPrevious_Qualication(String previous_Qualication) {
		Previous_Qualication = previous_Qualication;
	}
	public String getPrevious_Experience() {
		return Previous_Experience;
	}
	public void setPrevious_Experience(String previous_Experience) {
		Previous_Experience = previous_Experience;
	}
	
}


