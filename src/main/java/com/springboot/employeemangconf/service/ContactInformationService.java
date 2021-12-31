package com.springboot.employeemangconf.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.employeemangconf.dao.ContactInformationDao;
import com.springboot.employeemangconf.model.ContactInformation;
/**
 * Service is used to provide with classes that provide some business function
 * @author Soundarya
 *
 */
@Service
public class ContactInformationService {

	/**
	 * Autowired is used in setter methods to inject the value of the class properties. 
	 */
	@Autowired
	ContactInformationDao dao;

	/**
	 * Get api calls
	 * @return
	 */
	public List<ContactInformation> getContactInfo() {
		List <ContactInformation> employeeList=dao.getContactInformationInfoFromDb();
		return employeeList;
	}

	/**
	 * post api
	 * @param holidayInformationObj
	 * @return
	 */

	public List<ContactInformation> getcontactInformation(int empId) {
		return dao.getContactInformationInfoBasedOnId(empId);
	}

	/**
	 * put api
	 * @param holidayInformationObj
	 * @return
	 */
	public boolean insertContactInformationData(ContactInformation empobj) {
		return dao.insertContactInformationData(empobj);
	}

	/**
	 * PUT api
	 * @param holidayInformationObj
	 * @return boolean
	 */
	public boolean updateContactData(ContactInformation empobj) {
		return dao.updateContactInformationData(empobj);
	}

	/**
	 * Delete api
	 * @param holidayInformationObj
	 * @return boolean
	 */
	public boolean deleteContactId(int empId) {

		return dao.deleteContactInformationData(empId);
	}
}


