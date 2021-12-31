package com.springboot.employeemangconf.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.employeemangconf.model.EmployeeDetails;
import com.springboot.employeemangconf.service.EmployeedetailsService;

/**
 * EmployeeDetailsController is to perform the crud ops
 * @author Soundarya
 * Since 20/12/2021
 * RestController is used to connect with api
 */
@RestController
public class EmployeeDetailsController {

	/**
	 * EmployeeDetailsService is to make call to EmployeeDetails service layer
	 */
	@Autowired
	EmployeedetailsService service;

	/**
	 * Get method is used to get all the EmployeeDetails
	 * @return
	 */
	@RequestMapping(value="/getEmployeeDetailsinfo", method = RequestMethod.GET)
	public List<EmployeeDetails>getEmployeeDetailsinfo(){
		List<EmployeeDetails> employeeDetailsList= service.getEmployeeDetailsInfo();
		return employeeDetailsList;
	}

	/**
	 * Post is used to display the param value of EmployeeDetails
	 * @param employee_ID
	 * @return
	 */
	@RequestMapping(value="/getEmployeedataonid", method = RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	public List<EmployeeDetails>getEmployeeDetailsInfoBasedOnId(@RequestParam("id") int employee_ID){
		List<EmployeeDetails>employeeDetailsList= service.getEmployeedetails(employee_ID);
		return employeeDetailsList;
	}

	/**
	 * Put is used the insert the data in to EmployeeDetails
	 * @param employeeDetailsObj
	 * @return
	 */
	@RequestMapping(value="/insertEmployeeDetailsdata",method= RequestMethod.PUT,consumes=MediaType.APPLICATION_JSON_VALUE)
	public String updateEmployeeDetailsData(@RequestBody EmployeeDetails employeeDetailsObj) {

		boolean status = service.insertEmployeedetailsData(employeeDetailsObj);
		if(status) {
			return "Data Inserted successfully..! ";
		}else {
			return "Data Insertion failed...! ";
		}
	}

	/**
	 * Update is used to alter the EmployeeDetails
	 * @param employeeDetailsObj
	 * @return
	 */
	@RequestMapping(value="/updateEmployeeDetailsdata",method= RequestMethod.PUT,consumes=MediaType.APPLICATION_JSON_VALUE)
	public String updateEmployeeDetailsData1(@RequestBody EmployeeDetails employeeDetailsObj) {

		boolean status = service.updateEmployeedetails(employeeDetailsObj);
		if(status) {
			return "Data updated successfully..! ";
		}else {
			return "Data updated failed...! ";
		}
	}

	/**
	 * Delete is used the delete the data in EmployeeDetails
	 * @param Employee_ID
	 * @return
	 */
	@RequestMapping(value="/deleteEmployeeDetailsdata",method= RequestMethod.DELETE,produces=MediaType.APPLICATION_JSON_VALUE)
	public boolean deleteEmployeeDetailsData(@RequestParam("id") int employeeDetailsObj) {
		boolean EmployeeDetailsList = service.deleteEmployeedetails(employeeDetailsObj);
		return EmployeeDetailsList;
	}
}



