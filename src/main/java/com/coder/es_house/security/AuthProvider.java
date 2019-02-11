package com.coder.es_house.security;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.thymeleaf.spring4.SpringTemplateEngine;

/**
 * @author:apple
 * @date: 2019/2/9
 * @time: 下午8:44
 */
public class AuthProvider implements AuthenticationProvider {


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String userName = authentication.getName();
        String inputPassword = (String)authentication.getCredentials();


        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
}
