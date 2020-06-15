package com.hyh.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hyh.dao.SectorDao;
import com.hyh.entity.TSector;

@Component
public class SectorService {

	private Logger logger = Logger.getLogger(getClass());

	@Autowired
	private SectorDao sectorDao;

	/**
	 * find all sectors
	 * 
	 * @return all sector list
	 */
	public Iterable<TSector> findAll() {

		logger.info(this.getClass().getName() + " findAll enter...");

		// get sectors
		Iterable<TSector> sectorList = sectorDao.findAll();

		logger.info(this.getClass().getName() + " findAll completed.");

		return sectorList;
	}

	/**
	 * find sector by id
	 * 
	 * @param id sector id
	 * 
	 * @return TSector
	 */
	public TSector findById(Integer id) {

		logger.info(this.getClass().getName() + " findById enter...");

		// get sectors
		TSector sectorList = sectorDao.findOne(id);

		logger.info(this.getClass().getName() + " findById completed.");

		return sectorList;
	}

	/**
	 * Create/Update sector
	 * 
	 * @param sectorEntity TSector
	 */
	public void save(TSector sectorEntity) {

		logger.info(this.getClass().getName() + " save enter...");

		// save sector
		sectorDao.save(sectorEntity);

		logger.info(this.getClass().getName() + " save completed.");
	}

	/**
	 * Delete sector by id
	 * 
	 * @param id sector id
	 * @return -1:failed; 1:success
	 */
	public int deleteById(int id) {

		logger.info(this.getClass().getName() + " deleteById enter...");

		// get sector
		TSector sector = sectorDao.findOne(id);

		if (sector == null) {
			return -1;
		}

		// delete sector
		sectorDao.delete(id);

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
		Integer maxId = sectorDao.getMaxId();
		if (maxId == null) {
			maxId = 0;
		}

		logger.info(this.getClass().getName() + " getNewId completed.");

		return maxId + 1;
	}
}
