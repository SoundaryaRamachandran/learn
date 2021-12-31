package com.springboot.employeemangconf.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.employeemangconf.dao.SalaryInformationDao;
import com.springboot.employeemangconf.model.SalaryInformation;

/**
 * Service is used to provide with classes that provide some business function
 * @author Soundarya
 *
 */
@Service
public class SalaryInformationService {

	/**
	 * Autowired is used in setter methods to inject the value of the class properties. 
	 */
	@Autowired
	SalaryInformationDao dao;

	/**
	 * Get api calls
	 * @return
	 */
	public List<SalaryInformation> getSalaryInformationInfo() {
		List <SalaryInformation> SalaryInformationList=dao.getSalaryInformationInfoFromDb();
		return SalaryInformationList;
	}

	/**
	 * post api
	 * @param holidayInformationObj
	 * @return
	 */
	public List<SalaryInformation> getSalaryInformation(int salaryInformationObj) {
		return dao.getSalaryInformationInfoBasedOnId(salaryInformationObj);
	}

	/**
	 * put api
	 * @param holidayInformationObj
	 * @return
	 */
	public boolean insertSalaryInformation(SalaryInformation salaryInformationObj) {
		return dao.insertSalaryInformationData(salaryInformationObj);
	}

	/**
	 * put api
	 * @param holidayInformationObj
	 * @return
	 */
	public boolean updateSalaryInformation(SalaryInformation salaryInformationObj) {
		return dao.updateSalaryInformationData(salaryInformationObj);
	}

	/**
	 * Delete api
	 * @param holidayInformationObj
	 * @return
	 */
	public boolean deleteSalaryInformation(int salaryInformationObj) {
		return dao.deleteSalaryInformationData(salaryInformationObj);
	}
}



