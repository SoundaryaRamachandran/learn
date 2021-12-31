package com.springboot.employeemangconf.dao;

import java.sql.ResultSet;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import com.springboot.employeemangconf.model.SalaryInformation;


/**
 *  SalaryInformationDao is used to access from the database 
 * @author Soundarya
 * Since 20/12/2021
 * component is used to create a bean to the class
 */
@Component
public class SalaryInformationDao {

	/**
	 * Jdbc template is used to create the query for database
	 */
	@Autowired
	JdbcTemplate template;
	
	/**
	 * GET api
	 * @return
	 */
	public List<SalaryInformation> getSalaryInformationInfoFromDb(){
		List<SalaryInformation> salaryInformationList = new ArrayList<>();

		template.query("select * from salary_information", new ResultSetExtractor<List<SalaryInformation>>() {

			public List<SalaryInformation> extractData(ResultSet rs) throws SQLException, DataAccessException {

				while(rs.next()) {
					SalaryInformation s = new SalaryInformation();
					s.setEmployee_ID(rs.getInt("Employee_ID"));
					salaryInformationList.add(s);
				}
				return salaryInformationList;
			}
		});
		return salaryInformationList;
	}
	
	/**
	 * POST api
	 * @param employee_ID
	 * @return
	 */
	public List<SalaryInformation> getSalaryInformationInfoBasedOnId(int employee_ID) {

		String sql = "select * from salary_information where Employee_ID="+employee_ID;
		List<SalaryInformation> salaryInformationList = new ArrayList<>();
		template.query(sql, new ResultSetExtractor<List<SalaryInformation>>() {

			public List<SalaryInformation> extractData(ResultSet rs) throws SQLException, DataAccessException {

				while(rs.next()) {
					SalaryInformation s = new SalaryInformation();
					s.setEmployee_ID(rs.getInt( "Employee_ID"));
					salaryInformationList.add(s);
				}
				return salaryInformationList;
			}
		});
		return salaryInformationList;
	}
	
	/**
	 * PUT api
	 * @param salaryInformationObj
	 * @return
	 */
	public boolean insertSalaryInformationData(SalaryInformation salaryInformationObj) {
		boolean insertStatus = false;
		String sql = "insert into salary_information (Employee_ID,Monthly_Salary,Salary_Date) values("+salaryInformationObj.getEmployee_ID()+","+salaryInformationObj.getMonthly_Salary()+",'"+salaryInformationObj.getSalary_Date()+"')";

		try {
			template.execute(sql);
			insertStatus = true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return insertStatus;
	}
	
	/**
	 * PUT api
	 * @param salaryInformationObj
	 * @return
	 */
	public boolean updateSalaryInformationData(SalaryInformation salaryInformationObj) {

		boolean updatetStatus = false;
		String sql = "update salary_information set Monthly_Salary='"+salaryInformationObj.getMonthly_Salary()+"',Salary_Date='"+salaryInformationObj.getSalary_Date()+"'where Employee_ID="+salaryInformationObj.getEmployee_ID();

		try {
			template.execute(sql);
			updatetStatus = true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return updatetStatus;
	}
	
	/**
	 * DELETE api
	 * @param Employee_ID
	 * @return
	 */
	public boolean deleteSalaryInformationData(int Employee_ID) {

		boolean deleteStatus = false;
		String sql = "Delete from salary_information where Employee_ID ="+Employee_ID;

		try {
			template.execute(sql);
			deleteStatus = true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return deleteStatus;
	}
}


