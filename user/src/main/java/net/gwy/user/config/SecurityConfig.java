package net.gwy.user.config;

import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author guoweiyang
 * @date 2019-05-26
 */
//@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.httpBasic().and()
//                .authorizeRequests().antMatchers("/actuator/**").authenticated()
//                .anyRequest().permitAll();
//    }
}