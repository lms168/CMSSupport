package com.yue.auth.service;

import com.yue.auth.bean.*;
import com.yue.auth.repository.*;
import com.yue.utils.StringUtil;
import com.yue.utils.StringUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

//Spring Bean的标识.
@Service("authService")
//类中所有public函数都纳入事务管理的标识.
public class AuthService{
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

	///////////////////////////////////保存用户信息///////////////////////////////////////////////////////



	/**
	 * 保存用户
	 * @param user
	 */
	public User saveUser(User user){
		return userRepository.save(user);
	}


	public void deleteUser(User user){
		userRepository.delete(user);
	}

	/**
	 * 用户分页
	 * @param pageable
	 * @return
	 */
	public Page<User> findAll(Pageable pageable){
		return (Page<User>) userRepository.findAll(pageable);
	}


	/**
	 * 根据用户名动态查询
	 * @param user
	 * @param pageable
	 */
	public Page<User> findAllDynatic(final User user,Pageable pageable){

		 return userRepository.findAll(new Specification<User>() {
			public Predicate toPredicate(Root<User> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {

				List<Predicate> list = new ArrayList<Predicate>();

				if (!StringUtils.isEmpty(user.getUsername())) {
					Predicate p1 = criteriaBuilder.like(root.get("username").as(String.class), "%" + user.getUsername() + "%");
					list.add(p1);
				}

				if (!StringUtils.isEmpty(user.getLoginName())) {
					Predicate p2 = criteriaBuilder.like(root.get("loginName").as(String.class), "%" + user.getLoginName() + "%");
					list.add(p2);
				}

				if (user.getLocked()!=null) {
					Predicate p3 = criteriaBuilder.equal(root.get("locked").as(Boolean.class), user.getLocked());
					list.add(p3);
				}

				Predicate[] p = new Predicate[list.size()];
				return criteriaBuilder.and(list.toArray(p));
			}
		},pageable);
	};









	/**
	 * 保存权限
	 * @param permission
	 * @return
	 */
	public Permission savePermission(Permission permission){
		return permissionRepository.save(permission);
	}

	////////////////////////////////////////role//////////////////////////////////////////////////////

	public Role saveRole(Role role){
		return roleRepository.save(role);
	}

	////////////////////////////////////role-permission//////////////////////////////////////////////////////////////
	public void addPermissionsToRole(final List<Permission> permissionList,final Role role){
		List<PermissionRole> permissionRoleList=new ArrayList<PermissionRole>();
		for (Permission permission:permissionList){
			PermissionRole permissionRole = new PermissionRole();
			permissionRole.setRole(role);
			permissionRole.setPermission(permission);
			permissionRoleList.add(permissionRole);
		}
		permissionRoleRepository.save(permissionRoleList);
	}

	public void deletePermissionFromRole(List<PermissionRole> permissionRoles){
		permissionRoleRepository.deleteInBatch(permissionRoles);
	}



   ////////////////////////////////////////保存用户角色//////////////////////////////////////////////////
	public void addRolesToUser(List<Role> roles,User user){
			List<UserRole> userRoles = new ArrayList<UserRole>();
			UserRole userRole =null;
			for (Role role:roles){
				userRole = new UserRole();
				userRole.setRole(role);
				userRole.setUser(user);
				userRoles.add(userRole);
			}
		userRoleRepository.save(userRoles);
	}


	public void deleteRolesFromUser(List<UserRole> userRoles ){
		userRoleRepository.deleteInBatch(userRoles);
	}




	public User findUserById(long id){
		return this.userRepository.findById(id);
	}



	public void checkLogin(Subject currentUser,String loginName,String password){
		//此处会调用myrelam中的  doGetAuthenticationInfo身份验证方法
		UsernamePasswordToken token = new UsernamePasswordToken(loginName, password);
		token.setRememberMe(false);
		currentUser.login(token);

	}

}
