package com.springboot.employeemangconf.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.employeemangconf.dao.HolidayInformationDao;
import com.springboot.employeemangconf.model.HolidayInformation;
/**
 * Service is used to provide with classes that provide some business function
 * @author Soundarya
 *
 */
@Service
public class HolidayInformationservice {

	/**
	 * Autowired is used in setter methods to inject the value of the class properties. 
	 */
	@Autowired
	HolidayInformationDao dao;

	/**
	 * Get api calls
	 * @return
	 */
	public List<HolidayInformation> getHolidayInformationInfo() {
		List <HolidayInformation> employeeList=dao.getHolidayInformationInfoFromDb();
		return employeeList;
	}

	/**
	 * post api
	 * @param holidayInformationObj
	 * @return
	 */
	public List<HolidayInformation> getHolidayInformation(int holidayInformationObj) {
		return dao.getHolidayInformationInfoBasedOnId(holidayInformationObj);
	}

	/**
	 * put api
	 * @param holidayInformationObj
	 * @return
	 */
	public boolean insertHolidayInformation(HolidayInformation holidayInformationObj) {
		return dao.insertHolidayInformationData(holidayInformationObj);
	}

	/**
	 * put api
	 * @param holidayInformationObj
	 * @return
	 */
	public boolean updateHolidayInformation(HolidayInformation holidayInformationObj) {
		return dao.updateHolidayInformationData(holidayInformationObj);
	}

	/**
	 * Delete api
	 * @param holidayInformationObj
	 * @return
	 */
	public boolean deleteHolidayInformation(int holidayInformationObj) {
		return dao.deleteeHolidayInformationData(holidayInformationObj);
	}
}


