package com.hyh.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hyh.dao.ExchangeRecordDao;
import com.hyh.entity.TExchangeRecord;

@Component
public class ExchangeRecordService {

	private Logger logger = Logger.getLogger(getClass());

	@Autowired
	private ExchangeRecordDao exchangeRecordDao;

	/**
	 * find all exchangeRecords
	 * 
	 * @return all exchangeRecord list
	 */
	public Iterable<TExchangeRecord> findAll() {

		logger.info(this.getClass().getName() + " findAll enter...");

		// get exchangeRecords
		Iterable<TExchangeRecord> exchangeRecordList = exchangeRecordDao.findAll();

		logger.info(this.getClass().getName() + " findAll completed.");

		return exchangeRecordList;
	}

	/**
	 * find exchangeRecord by id
	 * 
	 * @param id exchangeRecord id
	 * 
	 * @return TExchangeRecord
	 */
	public TExchangeRecord findById(Integer id) {

		logger.info(this.getClass().getName() + " findById enter...");

		// get exchangeRecords
		TExchangeRecord exchangeRecordList = exchangeRecordDao.findOne(id);

		logger.info(this.getClass().getName() + " findById completed.");

		return exchangeRecordList;
	}

	/**
	 * Create/Update exchangeRecord
	 * 
	 * @param exchangeRecordEntity TExchangeRecord
	 */
	public void save(TExchangeRecord exchangeRecordEntity) {

		logger.info(this.getClass().getName() + " save enter...");

		// save exchangeRecord
		exchangeRecordDao.save(exchangeRecordEntity);

		logger.info(this.getClass().getName() + " save completed.");
	}

	/**
	 * Delete exchangeRecord by id
	 * 
	 * @param id exchangeRecord id
	 */
	public void deleteById(int id) {

		logger.info(this.getClass().getName() + " deleteById enter...");

		// delete exchangeRecord
		exchangeRecordDao.delete(id);

		logger.info(this.getClass().getName() + " deleteById completed.");
	}
}
