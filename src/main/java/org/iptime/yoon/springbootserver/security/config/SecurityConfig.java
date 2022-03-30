package org.iptime.yoon.springbootserver.security.config;

import lombok.RequiredArgsConstructor;
import org.iptime.yoon.springbootserver.security.service.UserEntityService;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author rival
 * @since 2022-03-23
 */
@Configuration
@EnableWebSecurity(
    debug = true
)
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserEntityService userEntityService;


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userEntityService);
        // userDetailsService 등록하기
    }


    @Bean
    PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }


    @Bean
    RoleHierarchy roleHierarchy(){
        RoleHierarchyImpl roleHierarchy = new RoleHierarchyImpl();
        roleHierarchy.setHierarchy("ROLE_ADMIN > ROLE_USER");
        return roleHierarchy;
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
            .requestMatchers(
                PathRequest.toStaticResources().atCommonLocations(),// static 허용
                PathRequest.toH2Console() // h2-console 허용
            );
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
            .authorizeRequests()
                .antMatchers("/").permitAll()
                .anyRequest().authenticated().and()
            .formLogin()
                .failureUrl("/login-error")
                .loginProcessingUrl("/login") // POST /login 요청시 로그인 처리
                .loginPage("/login").permitAll() // GET /login 로그인 페이지
                .usernameParameter("username")
                .passwordParameter("password")
                .defaultSuccessUrl("/",false) // 로그인 성공후 리다이렉트 주소, false - 가려던 주소가 있으면 거기로
                .and() // 로그인 실패시 리다이렉트.and()
            .logout()
                .logoutUrl("/logout") // POST /logout 요청시 로그아웃 처리
                .logoutSuccessUrl("/").and() // 로그아웃 성공후 리다이렉트 url
            .exceptionHandling()
                .accessDeniedPage("/access-denied");
    }
}
