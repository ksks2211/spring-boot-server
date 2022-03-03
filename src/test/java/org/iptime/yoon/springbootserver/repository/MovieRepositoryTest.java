package org.iptime.yoon.springbootserver.repository;

import org.iptime.yoon.springbootserver.domain.Movie;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.time.LocalDateTime;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author rival
 * @since 2022-03-03
 */
@DataJpaTest
class MovieRepositoryTest {

    @Autowired
    private TestEntityManager em;

    @Autowired
    private MovieRepository movieRepository;

    @DisplayName("1. Movie 등록하기")
    @Test
    public void register_test(){
        Movie movie1 = Movie.builder()
            .title("Avengers 1")
            .runtime(100)
            .build();
        em.persist(movie1);

        Movie movie2 = Movie.builder()
            .title("Avengers 2")
            .runtime(100)
            .build();
        em.persist(movie2);

        assertThat(movieRepository.findAll(),hasSize(2));
    }



}