package com.yue.auth.service;

import com.yue.auth.bean.PermissionRole;
import com.yue.auth.bean.Role;
import com.yue.auth.bean.User;
import com.yue.auth.bean.UserRole;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Created by lms on 16-6-27.
 */
public class MyRealm extends AuthorizingRealm{
    @Autowired
    RealmService realmService;
    /**
     * 授权操作
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("是否有进来");
       String loginName= (String) principals.getPrimaryPrincipal();

        Set<UserRole> userRoles = realmService.findUserByLoginName(loginName).getUserRoleSet();
        //角色名的集合
        Set<String> roles = new HashSet<String>();
        //权限名的集合
        Set<String> permissions = new HashSet<String>();


        Iterator<UserRole> it = userRoles.iterator();

        while (it.hasNext()){
            UserRole userRole = it.next();
            Role role = userRole.getRole();
            roles.add(role.getRoleName());
            List<PermissionRole> permissionRoleList = realmService.findPermissionRoleByRole(role);
            if (permissionRoleList!=null&&permissionRoleList.size()>0){
                for (PermissionRole permissionRole:permissionRoleList){
                    permissions.add(permissionRole.getPermission().getPermissRight()); //将权限填充到角色列表中
                }
            }
        }



        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.addRoles(roles);
        authorizationInfo.addStringPermissions(permissions);
        return authorizationInfo;
    }

    /**BOo
     * 身份验证
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String loginName= (String) token.getPrincipal();
        User user = (User) realmService.findUserByLoginName(loginName);
        if (user==null){
            throw  new UnknownAccountException("没有找到该账号");
        }

//        if (Boolean.TRUE.equals(user.getLocked())){
//            throw new LockedAccountException("账号处于锁定状态");
//        }



        /**
         * 交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配，如果觉得人家的不好可以在此判断或自定义实现
         */
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user.getLoginName(),user.getPassword(),getName());

        return info;
    }


    @Override
    public String getName() {
        return getClass().getName();
    }

}
