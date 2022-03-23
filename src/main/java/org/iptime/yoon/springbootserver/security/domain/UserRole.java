package org.iptime.yoon.springbootserver.security.domain;

import org.iptime.yoon.springbootserver.security.domain.enums.Role;

import javax.persistence.*;

/**
 * @author rival
 * @since 2022-03-23
 */

@Entity
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Enumerated(EnumType.STRING)
    private Role role;
}
