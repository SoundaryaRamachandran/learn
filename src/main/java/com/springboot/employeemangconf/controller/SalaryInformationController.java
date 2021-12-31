package com.springboot.employeemangconf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.employeemangconf.model.SalaryInformation;
import com.springboot.employeemangconf.service.SalaryInformationService;

/**
 * SalaryInformationController is used to perform crud ops
 * @author Soundarya
 * Since 20/12/2021
 * RestController is used to connect with api
 */
@RestController
public class SalaryInformationController {
	
	/**
	 * SalaryInformationService is to make call to service layer
	 */
	@Autowired
	SalaryInformationService service;
	
	/**
	 * Get is used to get all the SalaryInformation
	 * @return
	 */
	@RequestMapping(value="/getSalaryInformationinfo", method = RequestMethod.GET)
	public List<SalaryInformation>getSalaryInformationinfo(){
		List<SalaryInformation> salaryInformationList= service.getSalaryInformationInfo();
		return salaryInformationList;
	}
	
	/**
	 * Post is used to post the SalaryInformation using params id
	 * @param employee_ID
	 * @return
	 */
	@RequestMapping(value="/getSalaryInformationdataonid", method = RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	public List<SalaryInformation>getSalaryInformationInfoBasedOnId(@RequestParam("id") int employee_ID){
		List<SalaryInformation>SalaryInformationList= service.getSalaryInformation(employee_ID);
		return SalaryInformationList;
	}
	
	/**
	 * Insert is used to insert the SalaryInformation
	 * @param salaryInformationObj
	 * @return
	 */
	@RequestMapping(value="/insertSalaryInformationdata",method= RequestMethod.PUT,consumes=MediaType.APPLICATION_JSON_VALUE)
	public String updateSalaryInformationData(@RequestBody SalaryInformation salaryInformationObj) {

		boolean status = service.insertSalaryInformation(salaryInformationObj);
		if(status) {
			return "Data Inserted successfully..! ";
		}else {
			return "Data Insertion failed...! ";
		}
	}
	
	/**
	 * Update is used to update the SalaryInformation
	 * @param salaryInformationObj
	 * @return
	 */
	@RequestMapping(value="/updateSalaryInformationdata",method= RequestMethod.PUT,consumes=MediaType.APPLICATION_JSON_VALUE)
	public String updateSalaryInformationdData(@RequestBody SalaryInformation salaryInformationObj) {

		boolean status = service.updateSalaryInformation(salaryInformationObj);
		if(status) {
			return "Data updated successfully..! ";
		}else {
			return "Data updated failed...! ";
		}
	}
	
	/**
	 * Delete is uesd to delete the SalaryInformation by using params value
	 * @param Employee_ID
	 * @return
	 */
	@RequestMapping(value="/deleteSalaryInformationdata",method= RequestMethod.DELETE,produces=MediaType.APPLICATION_JSON_VALUE)
	public boolean deleteSalaryInformationData(@RequestParam("id") int Employee_ID) {

		boolean SalaryInformationList = service.deleteSalaryInformation(Employee_ID);
		return SalaryInformationList;

	}
}





