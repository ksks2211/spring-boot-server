package org.iptime.yoon.springbootserver.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author rival
 * @since 2022-03-23
 */
@Configuration
@EnableWebSecurity(
    debug = true
)
public class SecurityConfig extends WebSecurityConfigurerAdapter {


//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        super.configure(auth);
//        // userDetailsService 등록하기
//    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
            .requestMatchers(
                PathRequest.toStaticResources().atCommonLocations(),
                PathRequest.toH2Console()
            );
    }

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//
//        http
//            .formLogin()
//                .usernameParameter("email")
//                .passwordParameter("password")
//                .loginPage("/login").permitAll() // 로그인 페이지
//                .defaultSuccessUrl("/",false) // 로그인 성공후 리다이렉트 주소, false - 가려던 주소가 있으면 거기로
//                .successForwardUrl("/")
//                //.authenticationDetailsSource(AuthenticationDetailsSource)
//                .failureForwardUrl("/error")
//                .loginProcessingUrl("/login")
//                .failureUrl("/login-error").and() // 로그인 실패시 리다이렉트.and()
//            .logout()
//
//                .logoutSuccessUrl("/").and() // 로그아웃 성공후 리다이렉트 url
//                //.logoutSuccessHandler(LogoutSuccessHandle) // 로그아웃 핸들러 등록
//            .exceptionHandling()
//                .accessDeniedPage("/access-denied");
//                //.accessDeniedHandler(AccessDeniedHandler)
//
//    }
}
