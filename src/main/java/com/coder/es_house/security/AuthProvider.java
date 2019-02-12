package com.coder.es_house.security;

import com.coder.es_house.entity.User;
import com.coder.es_house.service.IUserService;
import com.coder.es_house.service.user.UserServiceImpl;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.thymeleaf.spring4.SpringTemplateEngine;

/**
 * @author:apple
 * @date: 2019/2/9
 * @time: 下午8:44
 */
public class AuthProvider implements AuthenticationProvider {

    @Autowired
    private IUserService userService;

    private final Md5PasswordEncoder passwordEncoder = new Md5PasswordEncoder();

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String userName = authentication.getName();
        String inputPassword = (String)authentication.getCredentials();
        User user = userService.findUserByName(userName);
        if(user == null){
            throw new AuthenticationCredentialsNotFoundException("authError");
        }
        // 加盐
        if(this.passwordEncoder.isPasswordValid(user.getPassword(),inputPassword,user.getId())){
            return  new UsernamePasswordAuthenticationToken(user,user.getPassword(),user.getAuthorities());
        }
        throw new BadCredentialsException("密码错误或用户名不正确");
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
}
