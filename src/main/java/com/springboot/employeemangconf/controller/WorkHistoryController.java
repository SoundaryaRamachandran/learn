package com.springboot.employeemangconf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.employeemangconf.model.WorkHistory;
import com.springboot.employeemangconf.service.WorkHistoryService;

/**
 * WorkHistoryController is used to perform cruds ops
 * @author Soundarya
 * Since 20/12/2021
 * RestController is used to connect with api
 */
@RestController
public class  WorkHistoryController {

	/**
	 * WorkHistoryService is to make a call to WorkHistory service layer
	 */
	@Autowired
	WorkHistoryService service;

	/**
	 * Get is used to get all the WorkHistoryService data
	 * @return
	 */
	@RequestMapping(value="/getWorkHistoryinfo", method = RequestMethod.GET)
	public List<WorkHistory>getWorkHistoryinfo(){
		List<WorkHistory> workHistoryList= service.getWorkHistroyInfo();
		return  workHistoryList;
	}

	/**
	 * post is used to post the data to WorkHistory
	 * @param employee_ID
	 * @return
	 */
	@RequestMapping(value="/getWorkHistorydataonid", method = RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	public List<WorkHistory>getWorkHistoryInfoBasedOnId(@RequestParam("id") int employee_ID){
		List<WorkHistory>WorkHistoryList= service.getWorkHistoryInfoBasedOnId(employee_ID);
		return WorkHistoryList;
	}

	/**
	 * Insert is used to insert the WorkHistory
	 * @param WorkHistoryObj
	 * @return
	 */
	@RequestMapping(value="/insertWorkHistorydata",method= RequestMethod.PUT,consumes=MediaType.APPLICATION_JSON_VALUE)
	public String updateEmployeeDetailsData(@RequestBody WorkHistory WorkHistoryObj) {

		boolean status = service.insertWorkHistroyData(WorkHistoryObj);
		if(status) {
			return "Data Inserted successfully..! ";
		}else {
			return "Data Insertion failed...! ";
		}
	}

	/**
	 * Update is used to update WorkHistory
	 * @param WorkHistoryObj
	 * @return
	 */
	@RequestMapping(value="/updateWorkHistorydata",method= RequestMethod.PUT,consumes=MediaType.APPLICATION_JSON_VALUE)
	public String updateEmployeeDetailsData1(@RequestBody WorkHistory WorkHistoryObj) {

		boolean status = service.updateWorkHistory(WorkHistoryObj);
		if(status) {
			return "Data updated successfully..! ";
		}else {
			return "Data updated failed...! ";
		}
	}

	/**
	 * Delete is used to delete WorkHistory
	 * @param Employee_ID
	 * @return
	 */
	@RequestMapping(value="/deleteWorkHistorydata",method= RequestMethod.DELETE,produces=MediaType.APPLICATION_JSON_VALUE)
	public boolean deleteWorkHistoryData(@RequestParam("id") int Employee_ID) {
		boolean WorkHistoryList = service.deleteWorkHistory(Employee_ID);
		return WorkHistoryList;
	}
}








