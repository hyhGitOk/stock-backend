package com.hyh.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hyh.dao.StockExchangeDao;
import com.hyh.entity.TStockExchange;

@Component
public class StockExchangeService {

	private Logger logger = Logger.getLogger(getClass());

	@Autowired
	private StockExchangeDao stockExchangeDao;

	/**
	 * find all stockExchanges
	 * 
	 * @return all stockExchange list
	 */
	public Iterable<TStockExchange> findAll() {

		logger.info(this.getClass().getName() + " findAll enter...");

		// get stockExchanges
		Iterable<TStockExchange> stockExchangeList = stockExchangeDao.findAll();

		logger.info(this.getClass().getName() + " findAll completed.");

		return stockExchangeList;
	}

	/**
	 * find stockExchange by id
	 * 
	 * @param id stockExchange id
	 * 
	 * @return TStockExchange
	 */
	public TStockExchange findById(Integer id) {

		logger.info(this.getClass().getName() + " findById enter...");

		// get stockExchanges
		TStockExchange stockExchangeList = stockExchangeDao.findOne(id);

		logger.info(this.getClass().getName() + " findById completed.");

		return stockExchangeList;
	}

	/**
	 * Create/Update stockExchange
	 * 
	 * @param stockExchangeEntity TStockExchange
	 */
	public void save(TStockExchange stockExchangeEntity) {

		logger.info(this.getClass().getName() + " save enter...");

		// save stockExchange
		stockExchangeDao.save(stockExchangeEntity);

		logger.info(this.getClass().getName() + " save completed.");
	}

	/**
	 * Delete stockExchange by id
	 * 
	 * @param id stockExchange id
	 * @return -1:failed; 1:success
	 */
	public int deleteById(int id) {

		logger.info(this.getClass().getName() + " deleteById enter...");

		// get stockExchange
		TStockExchange stockExchange = stockExchangeDao.findOne(id);

		if (stockExchange == null) {
			return -1;
		}

		// delete stockExchange
		stockExchangeDao.delete(id);

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
		Integer maxId = stockExchangeDao.getMaxId();
		if (maxId == null) {
			maxId = 0;
		}

		logger.info(this.getClass().getName() + " getNewId completed.");

		return maxId + 1;
	}
}
