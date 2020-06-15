package com.hyh.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hyh.dao.IpoPlanDao;
import com.hyh.entity.TIpoPlan;

@Component
public class IpoPlanService {

	private Logger logger = Logger.getLogger(getClass());

	@Autowired
	private IpoPlanDao ipoPlanDao;

	/**
	 * find all ipoPlans
	 * 
	 * @return all ipoPlan list
	 */
	public Iterable<TIpoPlan> findAll() {

		logger.info(this.getClass().getName() + " findAll enter...");

		// get ipoPlans
		Iterable<TIpoPlan> ipoPlanList = ipoPlanDao.findAll();

		logger.info(this.getClass().getName() + " findAll completed.");

		return ipoPlanList;
	}

	/**
	 * find ipoPlan by id
	 * 
	 * @param id ipoPlan id
	 * 
	 * @return TIpoPlan
	 */
	public TIpoPlan findById(Integer id) {

		logger.info(this.getClass().getName() + " findById enter...");

		// get ipoPlans
		TIpoPlan ipoPlanList = ipoPlanDao.findOne(id);

		logger.info(this.getClass().getName() + " findById completed.");

		return ipoPlanList;
	}

	/**
	 * Create/Update ipoPlan
	 * 
	 * @param ipoPlanEntity TIpoPlan
	 */
	public void save(TIpoPlan ipoPlanEntity) {

		logger.info(this.getClass().getName() + " save enter...");

		// save ipoPlan
		ipoPlanDao.save(ipoPlanEntity);

		logger.info(this.getClass().getName() + " save completed.");
	}

	/**
	 * Delete ipoPlan by id
	 * 
	 * @param id ipoPlan id
	 * @return -1:failed; 1:success
	 */
	public int deleteById(int id) {

		logger.info(this.getClass().getName() + " deleteById enter...");

		// get ipoPlan
		TIpoPlan ipoPlan = ipoPlanDao.findOne(id);

		if (ipoPlan == null) {
			return -1;
		}

		// delete ipoPlan
		ipoPlanDao.delete(id);

		logger.info(this.getClass().getName() + " deleteById completed.");

		return 1;
	}

	/**
	 * get new id
	 * 
	 * @return id
	 */
	public int getNewId() {

		logger.info(this.getClass().getName() + " getNewId enter...");

		// get max id
		Integer maxId = ipoPlanDao.getMaxId();
		if (maxId == null) {
			maxId = 0;
		}

		logger.info(this.getClass().getName() + " getNewId completed.");

		return maxId + 1;
	}
}
