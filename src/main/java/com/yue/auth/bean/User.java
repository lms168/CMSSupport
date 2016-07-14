package com.yue.auth.bean;

import javax.persistence.*;

import com.yue.common.IdEntity;
import org.hibernate.validator.constraints.NotBlank;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="user")
public class User extends IdEntity {
	private String username;
	@Column(nullable = false,unique = true)
	private String loginName;
	private String password;

	@OneToMany(mappedBy = "user")
	private Set<UserRole> userRoleSet = new HashSet<UserRole>();

	public Set<UserRole> getUserRoleSet() {
		return userRoleSet;
	}

	public void setUserRoleSet(Set<UserRole> userRoleSet) {
		this.userRoleSet = userRoleSet;
	}


	/**
	 * 账号是否锁定，默认true
	 */
	private Boolean locked = true;
	
	@NotBlank
	public String getUsername() {
		return username;
	}
	public void setUsername(String userName) {
		this.username = userName;
	}
	@NotBlank
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public Boolean getLocked() {
		return locked;
	}

	public void setLocked(Boolean locked) {
		this.locked = locked;
	}
}
