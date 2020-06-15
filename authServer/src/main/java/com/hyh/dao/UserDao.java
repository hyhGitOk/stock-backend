package com.hyh.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.hyh.entity.TUser;

public interface UserDao extends CrudRepository<TUser, Integer>, JpaSpecificationExecutor<TUser> {

	@Query(value = "SELECT * FROM T_USER WHERE EMAIL = ?1 AND PASSWORD = ?2 LIMIT 1", nativeQuery = true)
	public TUser findByEmailPwd(String email, String password);
}
