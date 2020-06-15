package com.hyh.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hyh.dao.StockDao;
import com.hyh.entity.TStock;

@Component
public class StockService {

	private Logger logger = Logger.getLogger(getClass());

	@Autowired
	private StockDao stockDao;

	/**
	 * find all stocks
	 * 
	 * @return all stock list
	 */
	public Iterable<TStock> findAll() {

		logger.info(this.getClass().getName() + " findAll enter...");

		// get stocks
		Iterable<TStock> stockList = stockDao.findAll();

		logger.info(this.getClass().getName() + " findAll completed.");

		return stockList;
	}

	/**
	 * find stock by id
	 * 
	 * @param id stock id
	 * 
	 * @return TStock
	 */
	public TStock findById(Integer id) {

		logger.info(this.getClass().getName() + " findById enter...");

		// get stocks
		TStock stockList = stockDao.findOne(id);

		logger.info(this.getClass().getName() + " findById completed.");

		return stockList;
	}

	/**
	 * Create/Update stock
	 * 
	 * @param stockEntity TStock
	 */
	public void save(TStock stockEntity) {

		logger.info(this.getClass().getName() + " save enter...");

		// save stock
		stockDao.save(stockEntity);

		logger.info(this.getClass().getName() + " save completed.");
	}

	/**
	 * Delete stock by id
	 * 
	 * @param id stock id
	 * @return -1:failed; 1:success
	 */
	public int deleteById(int id) {

		logger.info(this.getClass().getName() + " deleteById enter...");

		// get stock
		TStock stock = stockDao.findOne(id);

		if (stock == null) {
			return -1;
		}

		// delete stock
		stockDao.delete(id);

		logger.info(this.getClass().getName() + " deleteById completed.");

		return 1;
	}

	/**
	 * get new code
	 * 
	 * @return code
	 */
	public int getNewCode() {

		logger.info(this.getClass().getName() + " getNewCode enter...");

		// get max code
		Integer maxCode = stockDao.getMaxCode();
		if (maxCode == null) {
			maxCode = 0;
		}

		logger.info(this.getClass().getName() + " getNewCode completed.");

		return maxCode + 1;
	}
}
