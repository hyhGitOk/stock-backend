package com.hyh.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hyh.dao.CompanyDao;
import com.hyh.entity.TCompany;

@Component
public class CompanyService {

	private Logger logger = Logger.getLogger(getClass());

	@Autowired
	private CompanyDao companyDao;

	/**
	 * find all companies
	 * 
	 * @return all company list
	 */
	public Iterable<TCompany> findAll() {

		logger.info(this.getClass().getName() + " findAll enter...");

		// get companies
		Iterable<TCompany> companyList = companyDao.findAll();

		logger.info(this.getClass().getName() + " findAll completed.");

		return companyList;
	}

	/**
	 * find company by id
	 * 
	 * @param id company id
	 * 
	 * @return TCompany
	 */
	public TCompany findById(Integer id) {

		logger.info(this.getClass().getName() + " findById enter...");

		// get companies
		TCompany companyList = companyDao.findOne(id);

		logger.info(this.getClass().getName() + " findById completed.");

		return companyList;
	}

	/**
	 * Create/Update company
	 * 
	 * @param companyEntity TCompany
	 */
	public void save(TCompany companyEntity) {

		logger.info(this.getClass().getName() + " save enter...");

		// save company
		companyDao.save(companyEntity);

		logger.info(this.getClass().getName() + " save completed.");
	}

	/**
	 * Delete company by id
	 * 
	 * @param id company id
	 * @return -1:failed; 1:success
	 */
	public int deleteById(int id) {

		logger.info(this.getClass().getName() + " deleteById enter...");

		// get company
		TCompany company = companyDao.findOne(id);

		if (company == null) {
			return -1;
		}

		// delete company
		companyDao.delete(id);

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
		Integer maxId = companyDao.getMaxId();
		if (maxId == null) {
			maxId = 0;
		}

		logger.info(this.getClass().getName() + " getNewId completed.");

		return maxId.intValue() + 1;
	}
}
