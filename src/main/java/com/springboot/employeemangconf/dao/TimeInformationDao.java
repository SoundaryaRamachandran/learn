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

import com.springboot.employeemangconf.model.TimeInformation;

/***
 * TimeInformationDao is used to access from the database
 * @author Soundarya
 * Since 20/12/2021
 * component is used to create a bean to the class
 */
@Component
public class TimeInformationDao {
	
	/**
	 * Jdbc template is used to create the query for database
	 */
	@Autowired
	JdbcTemplate template;

	/**
	 * GEI API call
	 * @return
	 */
	public List<TimeInformation> getTimeinformationInfoFromDb(){
		List<TimeInformation> timeInformationList = new ArrayList<>();

		template.query("select * from time_information", new ResultSetExtractor<List<TimeInformation>>() {

			public List<TimeInformation> extractData(ResultSet rs) throws SQLException, DataAccessException {

				while(rs.next()) {
					TimeInformation s = new TimeInformation();
					s.setEmployee_ID(rs.getInt("Employee_ID"));
					timeInformationList.add(s);
				}
				return timeInformationList;
			}
		});
		return timeInformationList;
	}
	
	/**
	 * POST API call
	 * @param timeinformationId
	 * @return
	 */
	public List<TimeInformation> getTimeinformationInfoBasedOnId(int timeinformationId) {

		String sql = "select * from time_information where Employee_ID="+timeinformationId;
		List<TimeInformation> timeInformationList = new ArrayList<>();
		template.query(sql, new ResultSetExtractor<List<TimeInformation>>() {

			public List<TimeInformation> extractData(ResultSet rs) throws SQLException, DataAccessException {

				while(rs.next()) {
					TimeInformation s = new TimeInformation();
					s.setEmployee_ID(rs.getInt( "Employee_ID"));
					timeInformationList.add(s);
				}
				return timeInformationList;
			}
		});
		return timeInformationList;
	}
	
	/**
	 * PUT API call
	 * @param timeInformationObj
	 * @return
	 */
	public boolean insertTimeinformationData(TimeInformation timeInformationObj) {

		boolean insertStatus = false;
		String sql = "insert into time_information (Employee_ID,Worked_Hours,Off_Hours) values("+timeInformationObj.getEmployee_ID()+","+timeInformationObj.getWorked_Hours()+","+timeInformationObj.getWorked_Hours()+")";

		try {
			template.execute(sql);
			insertStatus = true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return insertStatus;
	}
	
	/**
	 * PUT API call
	 * @param timeinformationObj
	 * @return
	 */
	public boolean updateTimeinformationData(TimeInformation timeinformationObj) {

		boolean updatetStatus = false;
		String sql = "update time_information set Worked_Hours='"+timeinformationObj.getWorked_Hours()+"',Off_Hours='"+timeinformationObj.getOff_Hours()+"'where Employee_ID="+timeinformationObj.getEmployee_ID();

		try {
			template.execute(sql);
			updatetStatus = true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return updatetStatus;
	}

	/**
	 * DELETE API call
	 * @param Employee_ID
	 * @return
	 */
	public boolean deleteTimeinformationData(int Employee_ID) {

		boolean deleteStatus = false;
		String sql = "Delete from ime_information where Employee_ID ="+Employee_ID;

		try {
			template.execute(sql);
			deleteStatus = true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return deleteStatus;
	}

}



