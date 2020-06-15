package com.hyh.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.hyh.entity.TIpoPlan;

public interface IpoPlanDao extends CrudRepository<TIpoPlan, Integer>, JpaSpecificationExecutor<TIpoPlan> {

	@Query(value = "SELECT MAX(ID) FROM T_IPO_PLAN", nativeQuery = true)
	public Integer getMaxId();
}
