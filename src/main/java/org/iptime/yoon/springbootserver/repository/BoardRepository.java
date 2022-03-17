package org.iptime.yoon.springbootserver.repository;

import org.iptime.yoon.springbootserver.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author rival
 * @since 2022-03-17
 */
public interface BoardRepository extends JpaRepository<Board,Long> {
}
