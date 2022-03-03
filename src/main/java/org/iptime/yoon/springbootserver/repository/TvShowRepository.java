package org.iptime.yoon.springbootserver.repository;

import org.iptime.yoon.springbootserver.domain.TvShow;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author rival
 * @since 2022-03-03
 */
public interface TvShowRepository extends JpaRepository<TvShow,Long> {
}
