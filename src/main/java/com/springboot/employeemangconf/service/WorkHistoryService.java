package com.springboot.employeemangconf.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springboot.employeemangconf.dao.WorkHistoryDao;
import com.springboot.employeemangconf.model.WorkHistory;

/**
 * Service is used to provide with classes that provide some business function
 * @author Soundarya
 *
 */
@Service
public class WorkHistoryService {
	
	/**
	 * Autowired is used in setter methods to inject the value of the class properties. 
	 */
	@Autowired
	WorkHistoryDao dao;
	
	/**
	 * Get api calls
	 * @return
	 */
	public List<WorkHistory> getWorkHistroyInfo() {
		List <WorkHistory> workHistroyList=dao.getWorkHistoryInfoFromDb();
		return workHistroyList;
	}
	/**
	 * POST api calls
	 * @return
	 */
	public List<WorkHistory> getWorkHistoryInfoBasedOnId(int WorkHistroyObj) {
		return dao.getWorkHistoryInfoBasedOnId(WorkHistroyObj);
	}
	
	/**
	 * PUT api calls
	 * @return
	 */
	public boolean insertWorkHistroyData(WorkHistory WorkHistroyObj) {
		return dao.insertWorkHistoryData(WorkHistroyObj);
	}
	
	/**
	 * PUT api calls
	 * @return
	 */
	public boolean updateWorkHistory(WorkHistory WorkHistoryObj) {
		return dao.updateWorkHistoryData(WorkHistoryObj);
	}
	
	/**
	 * DELETE api calls
	 * @return
	 */
	public boolean deleteWorkHistory(int WorkHistoryObj) {
		return dao.deleteWorkHistoryData(WorkHistoryObj);
	}
}







