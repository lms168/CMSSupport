package com.yue.auth.service;

import com.yue.auth.bean.PermissionRole;
import com.yue.auth.bean.Role;
import com.yue.auth.bean.User;
import com.yue.auth.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lms on 16-7-1.
 */
@Service
public class RealmService{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PermissionRoleRepository permissionRoleRepository;
    @Autowired
    private PermissionRepository permissionRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserRoleRepository userRoleRepository;


    //////////////////////////////////myrealm////////////////////////////////////////
    /**
     * 根据登陆名查找用户
     * @param loginName
     * @return
     */
    public User findUserByLoginName(String loginName){
        return userRepository.findByLoginName(loginName);
    }

    /**
     * 根据角色查找角色权限关联表
     * @param role
     */
    public List<PermissionRole> findPermissionRoleByRole(Role role){
        return permissionRoleRepository.findByRole(role);
    }



    }
