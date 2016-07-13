package com.yue.auth.repository;

import com.yue.auth.bean.Permission;
import org.hibernate.jpa.event.internal.core.JpaAutoFlushEventListener;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by lms on 16-6-26.
 */
public interface PermissionRepository extends JpaRepository<Permission,Long>{
}
