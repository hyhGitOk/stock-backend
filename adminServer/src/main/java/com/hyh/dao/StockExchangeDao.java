package com.hyh.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.hyh.entity.TStockExchange;

public interface StockExchangeDao
		extends CrudRepository<TStockExchange, Integer>, JpaSpecificationExecutor<TStockExchange> {

	@Query(value = "SELECT MAX(ID) FROM T_STOCK_EXCHANGE", nativeQuery = true)
	public Integer getMaxId();
}
