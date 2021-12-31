package com.springboot.employeemangconf.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.employeemangconf.dao.EmployeeDetailsDao;
import com.springboot.employeemangconf.model.EmployeeDetails;

/**
 * Service is used to provide with classes that provide some business function
 * @author Soundarya
 *
 */
@Service
public class EmployeedetailsService {
	
	/**
	 * Autowired is used in setter methods to inject the value of the class properties. 
	 */
	@Autowired
	EmployeeDetailsDao dao;
	
	/**
	 * Get api calls
	 * @return
	 */
	public List<EmployeeDetails> getEmployeeDetailsInfo() {
		List <EmployeeDetails> employeeList=dao.getEmployeeDetailsInfoFromDb();
		return employeeList;
	}
	
	/**
	 * post api
	 * @param holidayInformationObj
	 * @return
	 */
	public List<EmployeeDetails> getEmployeedetails(int employeeDetailsObj) {
		return dao.getEmployeeDetailsInfoBasedOnId(employeeDetailsObj);
	}
	

	/**
	 * put api
	 * @param holidayInformationObj
	 * @return
	 */
	public boolean insertEmployeedetailsData(EmployeeDetails employeeDetailsObj) {
		return dao.insertEmployeeDetailsData(employeeDetailsObj);
	}
	
	/**
	 * PUT api
	 * @param holidayInformationObj
	 * @return
	 */
	public boolean updateEmployeedetails(EmployeeDetails employeeDetailsObj) {
		return dao.insertEmployeeDetailsData(employeeDetailsObj);
	}
	
	/**
	 * Delete api
	 * @param holidayInformationObj
	 * @return
	 */
	public boolean deleteEmployeedetails(int employeeDetailsObj) {
		return dao.deleteemployeeDetailsData(employeeDetailsObj);
	}

}





