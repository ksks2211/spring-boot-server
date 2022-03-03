package org.iptime.yoon.springbootserver.repository;

import org.iptime.yoon.springbootserver.domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author rival
 * @since 2022-03-03
 */
@Repository
public interface MovieRepository extends JpaRepository<Movie,Long> {
}
