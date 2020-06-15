package com.hyh.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hyh.dao.PerdayPriceDao;
import com.hyh.entity.TPerdayPrice;

@Component
public class PerdayPriceService {

	private Logger logger = Logger.getLogger(getClass());

	@Autowired
	private PerdayPriceDao perdayPriceDao;

	/**
	 * find all perdayPrices
	 * 
	 * @return all perdayPrice list
	 */
	public Iterable<TPerdayPrice> findAll() {

		logger.info(this.getClass().getName() + " findAll enter...");

		// get perdayPrices
		Iterable<TPerdayPrice> perdayPriceList = perdayPriceDao.findAll();

		logger.info(this.getClass().getName() + " findAll completed.");

		return perdayPriceList;
	}

	/**
	 * find perdayPrice by id
	 * 
	 * @param id perdayPrice id
	 * 
	 * @return TPerdayPrice
	 */
	public TPerdayPrice findById(Integer id) {

		logger.info(this.getClass().getName() + " findById enter...");

		// get perdayPrices
		TPerdayPrice perdayPriceList = perdayPriceDao.findOne(id);

		logger.info(this.getClass().getName() + " findById completed.");

		return perdayPriceList;
	}

	/**
	 * Create/Update perdayPrice
	 * 
	 * @param perdayPriceEntity TPerdayPrice
	 */
	public void save(TPerdayPrice perdayPriceEntity) {

		logger.info(this.getClass().getName() + " save enter...");

		// save perdayPrice
		perdayPriceDao.save(perdayPriceEntity);

		logger.info(this.getClass().getName() + " save completed.");
	}

	/**
	 * Delete perdayPrice by id
	 * 
	 * @param id perdayPrice id
	 */
	public void deleteById(int id) {

		logger.info(this.getClass().getName() + " deleteById enter...");

		// delete perdayPrice
		perdayPriceDao.delete(id);

		logger.info(this.getClass().getName() + " deleteById completed.");
	}
}
