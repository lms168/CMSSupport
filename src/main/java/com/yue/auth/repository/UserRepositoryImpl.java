package com.yue.auth.repository;

import com.yue.auth.bean.User;
import org.hibernate.criterion.CriteriaQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Root;

/**
 * Created by lms on 16-7-5.
 */
public class UserRepositoryImpl implements UserDaoCustomize {
    public Page<User> pageUsertest(User user, Pageable pageable) {
       return null;
    }


}
