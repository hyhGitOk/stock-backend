package com.hyh.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import com.hyh.entity.TPerdayPrice;

public interface PerdayPriceDao extends CrudRepository<TPerdayPrice, Integer>, JpaSpecificationExecutor<TPerdayPrice> {

}
