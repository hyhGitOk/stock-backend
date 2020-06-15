package com.hyh.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.hyh.entity.TUser;

public interface UserDao extends CrudRepository<TUser, Integer>, JpaSpecificationExecutor<TUser> {

	@Query(value = "SELECT MAX(ID) FROM T_USER", nativeQuery = true)
	public Integer getMaxId();
}
