package org.jypj.dev.config.shiro;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;

/**
 * @author ChenYu
 * 通过hash加盐的方式认证 MD5加密
 */
public class CredentialsMatcher extends HashedCredentialsMatcher {

    /**
     * 对默认的密码匹配进行重写
     *
     * @param token
     * @param info
     * @return
     */
    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        UsernamePasswordToken uToken = (UsernamePasswordToken) token;
        //获得用户输入的密码:(可以采用MD5的方式去检验)
        String inPassword = new String(uToken.getPassword());
        //获得数据库中的密码
        String dbPassword = (String) info.getCredentials();
        //进行密码的比对
        return this.equals(inPassword, dbPassword);
    }


}