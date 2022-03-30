package org.iptime.yoon.springbootserver.security.service;

import org.iptime.yoon.springbootserver.security.domain.UserRole;
import org.iptime.yoon.springbootserver.security.domain.enums.Privilege;
import org.iptime.yoon.springbootserver.security.domain.enums.Role;
import org.iptime.yoon.springbootserver.security.repository.UserEntityRepository;
import org.iptime.yoon.springbootserver.security.domain.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author rival
 * @since 2022-03-30
 */
@Service
public class UserEntityService implements UserDetailsService {

    @Autowired
    private UserEntityRepository userEntityRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userEntityRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(username));
        return new User(
            userEntity.getUsername(),
            userEntity.getPassword(),
            getAuthorities(userEntity.getRoles())
        );
    }

    static Set<GrantedAuthority> getAuthorities(Set<UserRole> roles) {
        return roles.stream().map(UserRole::getRole).map(role -> {
            Set<GrantedAuthority> authorities = role.getPrivileges()
                .stream()
                .map(Privilege::getPrivilege)
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toSet());
            authorities.add(new SimpleGrantedAuthority(role.getRole()));
            return authorities;
        }).flatMap(Set::stream).collect(Collectors.toSet());
    }

    // add user

    // remove user

    // ...
}
