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

import com.springboot.employeemangconf.model.WorkHistory;


/**
 * WorkHistoryDao is used to access from the database
 * @author Soundarya
 * Since 20/12/2021
 * component is used to create a bean to the class
 */
@Component
public class WorkHistoryDao {
	
	/**
	 * Jdbc template is used to create the query for database
	 */
	@Autowired
	JdbcTemplate template;
	
	/**
	 * GET api call
	 * @return
	 */

	public List<WorkHistory> getWorkHistoryInfoFromDb(){
		List<WorkHistory> WorkHistoryList = new ArrayList<>();

		template.query("select * from working_hours", new ResultSetExtractor<List<WorkHistory>>() {

			public List<WorkHistory> extractData(ResultSet rs) throws SQLException, DataAccessException {

				while(rs.next()) {
					WorkHistory s = new WorkHistory();
					s.setEmployee_ID(rs.getInt("Employee_ID"));
					WorkHistoryList.add(s);
				}
				return WorkHistoryList;
			}
		});
		return WorkHistoryList;
	}
	
	/**
	 * POST api call
	 * @param WorkHistoryId
	 * @return
	 */
	
	public List<WorkHistory> getWorkHistoryInfoBasedOnId(int WorkHistoryId) {

		String sql = "select * from working_hours where Employee_ID="+WorkHistoryId;
		List<WorkHistory> workHistoryList = new ArrayList<>();
		template.query(sql, new ResultSetExtractor<List<WorkHistory>>() {

			public List<WorkHistory> extractData(ResultSet rs) throws SQLException, DataAccessException {
				while(rs.next()) {
					WorkHistory s = new WorkHistory();
					s.setEmployee_ID(rs.getInt( "Employee_ID"));
					workHistoryList.add(s);
				}
				return workHistoryList;
			}
		});
		return workHistoryList;
	}
	
	/**
	 * PUT api call
	 * @param WorkHistoryObj
	 * @return
	 */
	public boolean insertWorkHistoryData(WorkHistory WorkHistoryObj) {

		boolean insertStatus = false;
		String sql = "insert into working_hours (Employee_ID,Employer_Name) values("+WorkHistoryObj.getEmployee_ID()+","+WorkHistoryObj.getEmployer_Name()+"')";

		try {
			template.execute(sql);
			insertStatus = true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return insertStatus;
	}
	
	/**
	 * PUT api call
	 * @param WorkHistoryObj
	 * @return
	 */
	public boolean updateWorkHistoryData(WorkHistory WorkHistoryObj) {

		boolean updatetStatus = false;
		String sql = "update working_hours set Worked_Hours='"+WorkHistoryObj.getEmployer_Name()+"'where Employee_ID="+WorkHistoryObj.getEmployee_ID();

		try {
			template.execute(sql);
			updatetStatus = true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return updatetStatus;
	}
	
	/**
	 * DELETE api call
	 * @param Employee_ID
	 * @return
	 */

	public boolean deleteWorkHistoryData(int Employee_ID) {

		boolean deleteStatus = false;
		String sql = "Delete from working_hours where Employee_ID ="+Employee_ID;

		try {
			template.execute(sql);
			deleteStatus = true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return deleteStatus;
	}
}



