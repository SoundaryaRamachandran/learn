package com.springboot.employeemangconf.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.employeemangconf.model.ContactInformation;
import com.springboot.employeemangconf.service.ContactInformationService;

/**
 * @author Soundarya
 * since 20/12/2021
 * ContactInformationController is to perform contactInformation crud operations 
 * RestController is used to built with api
 */
@RestController
public class ContactInformationController {

	/**
	 * ContactInformationService is to make call to contactInformation layer
	 */
	@Autowired
	ContactInformationService service;

	/**
	 * JmsTemplate is used to get message 
	 */
	@Autowired
	JmsTemplate jmsTemplate;

	/**
	 * get is used to get all the ContactInformation data
	 * @return
	 */
	@RequestMapping(value="/getContactInformationinfo", method = RequestMethod.GET)
	public List<ContactInformation>getContactInformationinfo(){
		System.out.println( "Message sending.....");
		//		jmsTemplate.convertAndSend("learn", "Hello,This from springboot jms application..");
		System.out.println("Message sent.....");
		List<ContactInformation> contactInformationList= service.getContactInfo();
		return contactInformationList;
	}

	/**
	 * Post is use to post the data from the ContactInformation data
	 * @param employee_ID
	 * @return
	 */
	@RequestMapping(value="/getContactInformationdataonid", method = RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	public List<ContactInformation>getContactInformationInfoBasedOnId(@RequestParam("id") int employee_ID){
		List<ContactInformation>contactInformationList= service.getcontactInformation(employee_ID);
		return contactInformationList;
	}

	/**
	 * Put is used to insert the data to the ContactInformation data
	 * @param contactInformationObj
	 * @return
	 */
	@RequestMapping(value="/insertContactInformationdata",method= RequestMethod.PUT,consumes=MediaType.APPLICATION_JSON_VALUE)
	public String updateContactInformationData(@RequestBody ContactInformation contactInformationObj) {

		boolean status = service.insertContactInformationData(contactInformationObj);
		if(status) {
			return "Data Inserted successfully..! ";
		}else {
			return "Data Insertion failed...! ";
		}
	}

	/**
	 * Update is used to update the data in ContactInformation data
	 * @param contactInformationObj
	 * @return
	 */
	@RequestMapping(value="/updateContactInformationdata",method= RequestMethod.PUT,consumes=MediaType.APPLICATION_JSON_VALUE)
	public String updateContactInformationData1(@RequestBody ContactInformation contactInformationObj) {

		boolean status = service.updateContactData(contactInformationObj);
		if(status) {
			return "Data updated successfully..! ";
		}else {
			return "Data updated failed...! ";

		}
	}
	/**
	 * Delete is used to delete the data in ContactInformation data
	 * @param Employee_ID
	 * @return
	 */

	@RequestMapping(value="/deleteContactInformationdata",method= RequestMethod.DELETE,produces=MediaType.APPLICATION_JSON_VALUE)
	public boolean deleteContactInformationData(@RequestParam("id") int Employee_ID) {

		boolean contactInformationList = service.deleteContactId(Employee_ID);
		return contactInformationList;

	}
}




