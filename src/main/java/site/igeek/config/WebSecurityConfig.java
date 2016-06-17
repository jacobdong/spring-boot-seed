package site.igeek.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * Created by jacobdong on 16/5/5.
 */


@Configuration
@EnableGlobalMethodSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final Logger LOGGER = LoggerFactory.getLogger(WebSecurityConfig.class);

    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("user").password("abc123").roles("USER");
        auth.inMemoryAuthentication().withUser("admin").password("RootRoot!!!!---").roles("ADMIN");
        auth.inMemoryAuthentication().withUser("dba").password("root123").roles("ADMIN", "MT");//dba have two roles.
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/hello").access("hasRole('USER')")
                .antMatchers("/monitor/*").access("hasRole('ADMIN')")
                //.antMatchers("/users", "/users/**").access("hasRole('MT')")
                .and().formLogin().permitAll()

                .and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));

        LOGGER.info("=====> 配置权限完毕");
    }
}
