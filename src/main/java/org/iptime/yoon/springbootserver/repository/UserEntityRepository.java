package org.iptime.yoon.springbootserver.repository;

import org.iptime.yoon.springbootserver.security.domain.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author rival
 * @since 2022-03-17
 */
@Repository
public interface UserEntityRepository extends JpaRepository<UserEntity,Long> {
    Optional<UserEntity> findByEmail(String email);
    boolean existsByEmail(String email);
}
