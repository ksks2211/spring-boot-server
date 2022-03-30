package org.iptime.yoon.springbootserver.security.repository;

import org.iptime.yoon.springbootserver.security.domain.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author rival
 * @since 2022-03-30
 */
public interface UserRoleRepository extends JpaRepository<UserRole,Long> {
}
