package org.iptime.yoon.springbootserver.repository;

import org.iptime.yoon.springbootserver.domain.Board;
import org.iptime.yoon.springbootserver.domain.security.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author rival
 * @since 2022-03-17
 */
@Repository
public interface BoardRepository extends JpaRepository<Board,Long> {
    List<Board> findByUser(UserEntity user);
}
