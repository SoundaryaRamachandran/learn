package com.springboot.employeemangconf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.employeemangconf.model.TimeInformation;
import com.springboot.employeemangconf.service.TimeInformationService;

/**
 * TimeInformationController is to perform the cruds ops
 * @author Soundarya
 * Since 20/12/2021
 * RestController is used to connect with api
 */
@RestController
public class TimeInformationController {
	/**
	 * TimeInformationservice is used to make a call to TimeInformation serive layer
	 */
	@Autowired
	TimeInformationService service;
	/**
	 * Get method is used to get the TimeInformation data
	 * @return
	 */

	@RequestMapping(value="/getTimeInformationinfo", method = RequestMethod.GET)
	public List<TimeInformation>getTimeInformationinfo(){
		List<TimeInformation> TimeInformationList= service.getTimeInformationInfo();
		return TimeInformationList;
	}
	/**
	 * Post is used to post the daata based in id from TimeInformation
	 * @param employee_ID
	 * @return
	 */

	@RequestMapping(value="/getTimeInformationdataonid", method = RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	public List<TimeInformation>getTimeInformationInfoBasedOnId(@RequestParam("id") int employee_ID){
		List<TimeInformation>TimeInformationList= service.getTimeInformation(employee_ID);
		return TimeInformationList;
	}
	/**
	 * Insert the used to insert the data to TimeInformation
	 * @param TimeInformationObj
	 * @return
	 */

	@RequestMapping(value="/insertTimeInformationdata",method= RequestMethod.PUT,consumes=MediaType.APPLICATION_JSON_VALUE)
	public String updateTimeInformationData(@RequestBody TimeInformation TimeInformationObj) {

		boolean status = service.insertTimeInformation(TimeInformationObj);
		if(status) {
			return "Data Inserted successfully..! ";
		}else {
			return "Data Insertion failed...! ";
		}
	}
	/**
	 * Update method is used to update the data to TimeInformation
	 * @param TimeInformationObj
	 * @return
	 */
	@RequestMapping(value="/updateTimeInformationdata",method= RequestMethod.PUT,consumes=MediaType.APPLICATION_JSON_VALUE)
	public String updateTimeInformationData1(@RequestBody TimeInformation TimeInformationObj) {

		boolean status = service.updateTimeInformation(TimeInformationObj);
		if(status) {
			return "Data updated successfully..! ";
		}else {
			return "Data updated failed...! ";
		}
	}
	/**
	 * Delete method is used to delete the data in TimeInformation
	 * @param Employee_ID
	 * @return
	 */

	@RequestMapping(value="/deleteTimeInformationdata",method= RequestMethod.DELETE,produces=MediaType.APPLICATION_JSON_VALUE)
	public boolean deleteTimeInformationData(@RequestParam("Employee_ID") int Employee_ID) {

		boolean TimeInformationList = service.deleteTimeInformation(Employee_ID);
		return TimeInformationList;

	}
}



