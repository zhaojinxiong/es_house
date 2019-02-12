package com.coder.es_house.config;

import com.coder.es_house.security.AuthProvider;
import com.coder.es_house.security.LoginUrlEntryPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author:apple
 * @date: 2019/2/9
 * @time: 下午8:26
 */
@EnableWebSecurity
@EnableGlobalMethodSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
        // 资源访问权限
        http.authorizeRequests()
                .antMatchers("/admin/login").permitAll()
                .antMatchers("/static/**").permitAll()
                .antMatchers("/user/login").permitAll()
                .antMatchers("/admin/**").hasRole("ADMIN")
                        .antMatchers("/user/**").hasAnyRole("ADMIN","USER")
                        .antMatchers("/api/user/**").hasAnyRole("ADMIN","USER")
                        .and()
                        .formLogin()
                        .loginProcessingUrl("/login") // 配置角色登录处理入口
                        .and()
                        .logout()
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/logout/page")
                        .deleteCookies("JESSIONID")
                        .invalidateHttpSession(true)
                        .and()
                        .exceptionHandling()
                        .authenticationEntryPoint(loginUrlEntryPoint())
                        .accessDeniedPage("/403");


        http.csrf().disable();
        http.headers().frameOptions().sameOrigin();
    }

    @Autowired
    public void configGlobal(AuthenticationManagerBuilder auth) throws Exception{
//        auth.inMemoryAuthentication().withUser("admin").password("admin")
//                .roles("ADMIN").and();

        auth.authenticationProvider(authProvider()).eraseCredentials(true);
    }

    @Bean
    public AuthProvider authProvider(){
        return  new AuthProvider();
    }

    @Bean
    public LoginUrlEntryPoint loginUrlEntryPoint(){
        return  new LoginUrlEntryPoint("user/login");
    }
}
