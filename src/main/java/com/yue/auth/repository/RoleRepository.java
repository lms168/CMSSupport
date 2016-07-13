package com.yue.auth.repository;

import com.yue.auth.bean.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by lms on 16-6-26.
 */
public interface RoleRepository extends JpaRepository<Role,Long>{
}
