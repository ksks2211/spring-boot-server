package org.iptime.yoon.springbootserver.security.domain;

import lombok.*;
import org.iptime.yoon.springbootserver.domain.BaseEntity;

import javax.persistence.*;

/**
 * @author rival
 * @since 2022-03-09
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class UserEntity extends BaseEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String username;

    @Column(unique = true)
    private String email;

    private String password;

    // 소셜 로그인
    private boolean fromSocial;
}
