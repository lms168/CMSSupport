package com.yue.auth.repository;

import com.yue.auth.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;


public interface UserRepository extends JpaRepository<User, Long>,JpaSpecificationExecutor<User>,UserDaoCustomize{

	public User findByLoginName(String loginName);

	@Query(value = "SELECT * FROM user WHERE id = ?1", nativeQuery = true)
	public User findById(long id);



}
