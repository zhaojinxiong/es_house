package com.coder.es_house.security;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * 基于角色的应用控制器
 * @author:apple
 * @date: 2019/2/12
 * @time: 上午11:55
 */
public class LoginUrlEntryPoint extends LoginUrlAuthenticationEntryPoint {

    // 权限访问的登录如何 对应的登录如何 是如何访问的
    private final Map<String,String> authEntryPointMap;
    private PathMatcher pathMatcher = new AntPathMatcher();

    public LoginUrlEntryPoint(String loginFormUrl) {
        super(loginFormUrl);
        authEntryPointMap = new HashMap<>();

        authEntryPointMap.put("/user/**","/user/login");
        authEntryPointMap.put("/admin/**","/admin/login");
    }

    /**
     *  根据请求跳转指定页面 ，父类默认使用 logiformurl
     * @param request
     * @param response
     * @param exception
     * @return
     */
    @Override
    protected String determineUrlToUseForThisRequest(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) {
        String uri = request.getRequestURI().replace(request.getContextPath(),"");
        for (Map.Entry<String,String> authEntry : this.authEntryPointMap.entrySet()){
            if(this.pathMatcher.match(authEntry.getKey(),uri)){
                return authEntry.getValue();
            }
        }

        return super.determineUrlToUseForThisRequest(request, response, exception);
    }
}
