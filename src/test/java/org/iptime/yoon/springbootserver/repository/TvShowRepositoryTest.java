package org.iptime.yoon.springbootserver.repository;

import org.iptime.yoon.springbootserver.domain.Movie;
import org.iptime.yoon.springbootserver.domain.TvShow;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author rival
 * @since 2022-03-03
 */
@DataJpaTest
class TvShowRepositoryTest {

    @Autowired
    private TvShowRepository tvShowRepository;

    @Autowired
    private TestEntityManager em;

    @DisplayName("1. TvShow 등록하기")
    @Test
    public void register_test(){
        TvShow tvShow1 = TvShow.builder()
            .title("Desperate Housewives")
            .season(1)
            .numOfSeasons(1)
            .episode(100)
            .build();
        em.persist(tvShow1);

        TvShow tvShow2 = TvShow.builder()
            .title("KKUTK")
            .season(1)
            .numOfSeasons(1)
            .episode(100)
            .build();
        em.persist(tvShow2);

        assertThat(tvShowRepository.findAll(),hasSize(2));
    }

}