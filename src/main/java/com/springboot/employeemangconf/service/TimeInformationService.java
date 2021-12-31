package com.springboot.employeemangconf.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.employeemangconf.dao.TimeInformationDao;
import com.springboot.employeemangconf.model.TimeInformation;
/**
 * Service is used to provide with classes that provide some business function
 * @author Soundarya
 *
 */
@Service
public class TimeInformationService {

	/**
	 * Autowired is used in setter methods to inject the value of the class properties. 
	 */
	@Autowired
	TimeInformationDao dao;

	/**
	 * Get api calls
	 * @return
	 */
	public List<TimeInformation> getTimeInformationInfo() {
		List <TimeInformation> employeeList=dao.getTimeinformationInfoFromDb();
		return employeeList;
	}

	/**
	 * post api
	 * @param holidayInformationObj
	 * @return
	 */
	public List<TimeInformation> getTimeInformation(int TimeInformationObj) {
		return dao.getTimeinformationInfoBasedOnId(TimeInformationObj);
	}

	/**
	 * put api
	 * @param TimeInformationObj
	 * @return
	 */
	public boolean insertTimeInformation(TimeInformation TimeInformationObj) {
		return dao.insertTimeinformationData(TimeInformationObj);
	}

	/**
	 * put api
	 * @param TimeInformationObj
	 * @return
	 */
	public boolean updateTimeInformation(TimeInformation TimeInformationObj) {
		return dao.updateTimeinformationData(TimeInformationObj);
	}

	/**
	 * Delete api
	 * @param TimeInformationObj
	 * @return
	 */
	public boolean deleteTimeInformation(int TimeInformationObj) {
		return dao.deleteTimeinformationData(TimeInformationObj);
	}
}





