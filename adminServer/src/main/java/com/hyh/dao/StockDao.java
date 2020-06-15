package com.hyh.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.hyh.entity.TStock;

public interface StockDao extends CrudRepository<TStock, Integer>, JpaSpecificationExecutor<TStock> {

	@Query(value = "SELECT MAX(CODE) FROM T_STOCK", nativeQuery = true)
	public Integer getMaxCode();
}
