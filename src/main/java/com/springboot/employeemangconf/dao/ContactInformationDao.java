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

import com.springboot.employeemangconf.model.ContactInformation;

/**
 * ContactInformationDao is used to access from the database 
 * @author Soundarya
 * Since 20/12/2021
 * component is used to create a bean to the class
 */
@Component
public class ContactInformationDao {
	
 /**
  * Jdbc template is used to create the query for database
  */
	@Autowired
	JdbcTemplate template;
	
/**
 * Get API
 * @return
 */
	public List<ContactInformation> getContactInformationInfoFromDb(){
		List<ContactInformation>  contactInformationList = new ArrayList<>();

		template.query("select * from contact_person_information", new ResultSetExtractor<List<ContactInformation>>() {

			public List<ContactInformation> extractData(ResultSet rs) throws SQLException, DataAccessException {

				while(rs.next()) {
					ContactInformation s = new ContactInformation();
					s.setEmployee_ID(rs.getInt("Employee_ID"));
					contactInformationList.add(s);
				}
				return contactInformationList;
			}
		});
		return contactInformationList;
	}
	
	/**
	 * POST API
	 * @param contactInformationId
	 * @return
	 */

	public List<ContactInformation> getContactInformationInfoBasedOnId(int contactInformationId) {

		String sql = "select * from contact_person_information where Employee_ID="+contactInformationId;
		List<ContactInformation> contactInformationList = new ArrayList<>();
		template.query(sql, new ResultSetExtractor<List<ContactInformation>>() {

			public List<ContactInformation> extractData(ResultSet rs) throws SQLException, DataAccessException {

				while(rs.next()) {
					ContactInformation s = new ContactInformation();
					s.setEmployee_ID(rs.getInt( "Employee_ID"));
					contactInformationList.add(s);
				}
				return contactInformationList;
			}
		});
		return contactInformationList;
	}
	
	/**
	 * PUT api
	 * @param contactInformationObj
	 * @return
	 */
	public boolean insertContactInformationData(ContactInformation contactInformationObj) {

		boolean insertStatus = false;
		String sql = "insert into contact_person_information (Employee_ID,c_First_Name,c_Last_Name) values("+contactInformationObj.getEmployee_ID()+","+contactInformationObj.getC_First_Name()+",'"+contactInformationObj.getC_last_Name()+"')";

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
	 * @param contactInformationObj
	 * @return
	 */
	public boolean updateContactInformationData(ContactInformation contactInformationObj) {

		boolean updatetStatus = false;
		String sql = "update contact_person_information set c_First_Name='"+contactInformationObj.getC_First_Name()+"',c_Last_Name='"+contactInformationObj.getC_last_Name()+"'where Employee_ID="+contactInformationObj.getEmployee_ID();

		try {
			template.execute(sql);
			updatetStatus = true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return updatetStatus;
	}

	/**
	 * Delete API
	 * @param Employee_ID
	 * @return
	 */
	public boolean deleteContactInformationData(int Employee_ID) {

		boolean deleteStatus = false;
		String sql = "Delete from contact_person_information where Employee_ID ="+Employee_ID;

		try {
			template.execute(sql);
			deleteStatus = true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return deleteStatus;
	}
}



