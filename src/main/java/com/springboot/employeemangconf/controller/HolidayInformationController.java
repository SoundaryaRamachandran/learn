package com.springboot.employeemangconf.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.employeemangconf.model.HolidayInformation;
import com.springboot.employeemangconf.service.HolidayInformationservice;

/**
 * HolidayInformationController is used to perform the crud ops
 * @author Soundarya
 * Since 20/12/2021
 * RestController is used to connect with api
 */
@RestController
public class HolidayInformationController {

	/**
	 * HolidayInformationService is used to make call to HolidayInformation service layer
	 */
	@Autowired
	HolidayInformationservice service;

	/**
	 * Get method is used to get all the HolidayInformation
	 * @return
	 */
	@RequestMapping(value="/getHolidayInformationinfo", method = RequestMethod.GET)
	public List<HolidayInformation>getHolidayInformationinfo(){
		List<HolidayInformation> holidayInformationList= service.getHolidayInformationInfo();
		return holidayInformationList;
	}

	/**
	 * Post is used to show the data from HolidayInformation
	 * @param employee_ID
	 * @return
	 */
	@RequestMapping(value="/getHolidayInformationonid", method = RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	public List<HolidayInformation>getHolidayInformationInfoBasedOnId(@RequestParam("id") int employee_ID){
		List<HolidayInformation> holidayInformationList= service.getHolidayInformation(employee_ID);
		return holidayInformationList;
	}

	/**
	 * Insert is uesd to insert it to the HolidayInformation
	 * @param holidayInformationObj
	 * @return
	 */
	@RequestMapping(value="/insertHolidayInformationdata",method= RequestMethod.PUT,consumes=MediaType.APPLICATION_JSON_VALUE)
	public String updateHolidayInformationData(@RequestBody HolidayInformation holidayInformationObj) {

		boolean status = service.insertHolidayInformation(holidayInformationObj);
		if(status) {
			return "Data Inserted successfully..! ";
		}else {
			return "Data Insertion failed...! ";
		}
	}

	/**
	 * Update is used to update the HolidayInformation
	 * @param holidayInformationObj
	 * @return
	 */
	@RequestMapping(value="/updateHolidayInformationdata",method= RequestMethod.PUT,consumes=MediaType.APPLICATION_JSON_VALUE)
	public String updateHolidayInformationData1(@RequestBody HolidayInformation holidayInformationObj) {

		boolean status = service.updateHolidayInformation(holidayInformationObj);
		if(status) {
			return "Data updated successfully..! ";
		}else {
			return "Data updated failed...! ";
		}
	}

	/**
	 * Delete is used to delete the HolidayInformation
	 * @param Employee_ID
	 * @return
	 */
	@RequestMapping(value="/deleteHolidayInformationdata",method= RequestMethod.DELETE,produces=MediaType.APPLICATION_JSON_VALUE)
	public boolean deleteHolidayInformationData(@RequestParam("id") int Employee_ID) {

		boolean holidayInformationList = service.deleteHolidayInformation(Employee_ID);
		return holidayInformationList;
	}
}


