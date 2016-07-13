package com.yue.auth.repository;

import com.yue.auth.bean.PermissionRole;
import com.yue.auth.bean.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by lms on 16-6-26.
 */
public interface PermissionRoleRepository extends JpaRepository<PermissionRole,Long>{
    List<PermissionRole> findByRole(Role role);

}
