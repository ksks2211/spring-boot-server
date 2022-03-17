package org.iptime.yoon.springbootserver.domain.security;

import lombok.*;
import org.iptime.yoon.springbootserver.domain.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String password;
    private String username;
}
