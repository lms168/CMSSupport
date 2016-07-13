package com.yue.auth.repository;

import com.yue.auth.bean.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


/**
 * Created by lms on 16-7-5.
 */
public interface UserDaoCustomize{
    /**
     * 动态分页
     * @param user
     * @param pageable
     * @return
     */
    Page<User> pageUsertest(User user, Pageable pageable);




}
