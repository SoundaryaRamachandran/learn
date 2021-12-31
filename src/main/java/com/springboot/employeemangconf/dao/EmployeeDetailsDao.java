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

import com.springboot.employeemangconf.model.EmployeeDetails;

/**
 * EmployeeDetailsDao is used to access from the database
 * @author Soundarya
 * Since 20/12/2021
 * component is used to create a bean to the class
 */

@Component
public class EmployeeDetailsDao {

	/**
	 * JDBC template is used to fetch the datas from the database
	 */
	@Autowired
	JdbcTemplate template;

	/**
	 * GET api
	 */
	public List<EmployeeDetails> getEmployeeDetailsInfoFromDb(){
		List<EmployeeDetails> employeeDetailsList = new ArrayList<>();

		template.query("select * from employee_basic_details", new ResultSetExtractor<List<EmployeeDetails>>() {

			public List<EmployeeDetails> extractData(ResultSet rs) throws SQLException, DataAccessException {

				while(rs.next()) {
					EmployeeDetails s = new EmployeeDetails();
					s.setEmployee_ID(rs.getInt("Employee_ID"));
					employeeDetailsList.add(s);
				}
				return employeeDetailsList;
			}
		});
		return employeeDetailsList;
	}

	/**
	 * POST api
	 * @param employeeDetailsId
	 * @return
	 */
	public List<EmployeeDetails> getEmployeeDetailsInfoBasedOnId(int employeeDetailsId) {

		String sql = "select * from employee_basic_details where Employee_ID="+employeeDetailsId;
		List<EmployeeDetails> employeeDetailsList = new ArrayList<>();
		template.query(sql, new ResultSetExtractor<List<EmployeeDetails>>() {

			public List<EmployeeDetails> extractData(ResultSet rs) throws SQLException, DataAccessException {

				while(rs.next()) {
					EmployeeDetails s = new EmployeeDetails();
					s.setEmployee_ID(rs.getInt( "Employee_ID"));
					s.setEmployee_ID(rs.getInt( "Employee_ID"));
					s.setEmployee_ID(rs.getInt( "Employee_ID"));
					s.setEmployee_ID(rs.getInt( "Employee_ID"));
					employeeDetailsList.add(s);
				}
				return employeeDetailsList;
			}
		});
		return employeeDetailsList;
	}

	/**
	 * PUT api
	 * @param employeeDetailsObj
	 * @return
	 */
	public boolean insertEmployeeDetailsData(EmployeeDetails employeeDetailsObj) {

		boolean insertStatus = false;
		String sql = "insert into employee_basic_details (Employee_ID,Personal_id,First_name) values("+employeeDetailsObj.getEmployee_ID()+","+employeeDetailsObj.getPersonal_id()+",'"+employeeDetailsObj.getFirst_name()+"')";

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
	 * @param employeeDetailsObj
	 * @return
	 */
	public boolean updateEmployeeDetailsData(EmployeeDetails employeeDetailsObj) {

		boolean updatetStatus = false;
		String sql = "update into employee_basic_details set First_name='"+employeeDetailsObj.getFirst_name()+"'where Employee_ID="+employeeDetailsObj.getEmployee_ID();
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
	public boolean deleteemployeeDetailsData(int Employee_ID) {

		boolean deleteStatus = false;
		String sql = "Delete from employee_basic_details where Employee_ID ="+Employee_ID;

		try {
			template.execute(sql);
			deleteStatus = true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return deleteStatus;
	}
}


