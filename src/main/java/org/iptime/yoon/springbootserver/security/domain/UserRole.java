package org.iptime.yoon.springbootserver.security.domain;

import lombok.*;
import org.iptime.yoon.springbootserver.security.domain.enums.Role;

import javax.persistence.*;

/**
 * @author rival
 * @since 2022-03-23
 */

@Entity
@Getter
@NoArgsConstructor
public class UserRole {

    public UserRole(Role role,UserEntity userEntity){
        this.role=role;
        this.userEntity=userEntity;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Role role;

    @ManyToOne
    @ToString.Exclude
    UserEntity userEntity;
}
