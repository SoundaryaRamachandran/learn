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

import com.springboot.employeemangconf.model.HolidayInformation;


/**
 * HolidayInformationDao is used to access from the database
 * @author Soundarya
 * Since 20/12/2021
 * component is used to create a bean to the class
 */
@Component
public class HolidayInformationDao {
	
	/**
	 * Jdbc template is used to create the query for database
	 */
	@Autowired
	JdbcTemplate template;
 
	/**
	 * GET api
	 * @return
	 */
	public List<HolidayInformation> getHolidayInformationInfoFromDb(){
		List<HolidayInformation> holidayInformationList = new ArrayList<>();
		template.query("select * From holiday_information", new ResultSetExtractor<List<HolidayInformation>>() {
			
			public List<HolidayInformation> extractData(ResultSet rs) throws SQLException, DataAccessException {

				while(rs.next()) {
					HolidayInformation s = new HolidayInformation();
					s.setEmployee_ID(rs.getInt("employee_id"));
					s.setHoliday(rs.getString("Holiday"));
					s.setH_From_Date_Day(rs.getInt("h_From_Date_Day"));
					s.setH_From_Date_Month(rs.getString("h_From_Date_Month"));
					s.setH_From_Date_Year(rs.getInt("h_From_Date_Year"));
					s.setH_To_Date_Day(rs.getInt("h_To_Date_Day"));
					holidayInformationList.add(s);
				}
				return holidayInformationList;
			}
		});
		return holidayInformationList;
	}

	/**
	 * POST api
	 * @param holidayInformationId
	 * @return
	 */
	public List<HolidayInformation> getHolidayInformationInfoBasedOnId(int holidayInformationId) {

		String sql = "select * from holiday_information where Employee_ID="+holidayInformationId;
		List<HolidayInformation> holidayInformationList = new ArrayList<>();
		template.query(sql, new ResultSetExtractor<List<HolidayInformation>>() {

			public List<HolidayInformation> extractData(ResultSet rs) throws SQLException, DataAccessException {

				while(rs.next()) {
					HolidayInformation s = new HolidayInformation();
					s.setEmployee_ID(rs.getInt( "Employee_ID"));
					holidayInformationList.add(s);
				}
				return holidayInformationList;
			}
		});
		return holidayInformationList;
	}
	
	/**
	 * PUT api
	 * @param holidayInformationObj
	 * @return
	 */
	public boolean insertHolidayInformationData(HolidayInformation holidayInformationObj) {

		boolean insertStatus = false;
		String sql = "insert into holiday_information (Employee_ID,h_From_Date_Day,h_From_Date_Month)values("+holidayInformationObj.getEmployee_ID()+","+holidayInformationObj.getH_From_Date_Day()+",'"+holidayInformationObj.getH_From_Date_Month()+"')";

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
	 * @param holidayInformationObj
	 * @return
	 */
	public boolean updateHolidayInformationData(HolidayInformation holidayInformationObj) {

		boolean updatetStatus = false;
		String sql = "update holiday_information set h_From_Date_Day='"+holidayInformationObj.getH_From_Date_Day()+"',h_From_Date_Month='"+holidayInformationObj.getH_From_Date_Month()+"'where Employee_ID="+holidayInformationObj.getEmployee_ID();

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
	public boolean deleteeHolidayInformationData(int Employee_ID) {

		boolean deleteStatus = false;
		String sql = "Delete from holiday_information where Employee_ID ="+Employee_ID;

		try {
			template.execute(sql);
			deleteStatus = true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return deleteStatus;
	}
}


