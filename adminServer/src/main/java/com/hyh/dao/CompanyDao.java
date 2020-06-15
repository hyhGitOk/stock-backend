package com.hyh.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.hyh.entity.TCompany;

public interface CompanyDao extends CrudRepository<TCompany, Integer>, JpaSpecificationExecutor<TCompany> {

	@Query(value = "SELECT MAX(ID) FROM T_COMPANY", nativeQuery = true)
	public Integer getMaxId();

}
