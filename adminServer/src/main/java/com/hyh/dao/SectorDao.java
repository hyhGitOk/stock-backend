package com.hyh.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.hyh.entity.TCompany;
import com.hyh.entity.TSector;

public interface SectorDao extends CrudRepository<TSector, Integer>, JpaSpecificationExecutor<TCompany> {

	@Query(value = "SELECT MAX(ID) FROM T_SECTOR", nativeQuery = true)
	public Integer getMaxId();
}
