package com.hyh.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import com.hyh.entity.TExchangeRecord;

public interface ExchangeRecordDao
		extends CrudRepository<TExchangeRecord, Integer>, JpaSpecificationExecutor<TExchangeRecord> {

}
