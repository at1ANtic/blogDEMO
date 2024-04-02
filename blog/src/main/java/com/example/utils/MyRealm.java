package com.example.utils;

import com.example.mapper.AdminMapper;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.realm.jdbc.JdbcRealm;

public class MyRealm extends JdbcRealm {

    private AdminMapper adminMapper;

    public void setAdminMapper(AdminMapper adminMapper) {
        this.adminMapper = adminMapper;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        // 从Token中获取用户名
        String adminname = (String) token.getPrincipal();

        // 从数据库中获取密码
        String adminpassword = adminMapper.getPasswordByAdminname(adminname);

        // 将用户名和密码封装到AuthenticationInfo对象中返回给Shiro
        return new SimpleAuthenticationInfo(adminname, adminpassword, getName());
    }
}
