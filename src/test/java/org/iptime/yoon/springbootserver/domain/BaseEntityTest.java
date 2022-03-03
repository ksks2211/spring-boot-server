package org.iptime.yoon.springbootserver.domain;

import org.iptime.yoon.springbootserver.repository.MovieRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author rival
 * @since 2022-03-03
 */
@SpringBootTest
public class BaseEntityTest {
    @Autowired
    private MovieRepository movieRepository;

    @Test
    @Rollback
    public void test_BaseEntity(){
        Movie movie1 = Movie.builder()
            .title("Avengers 1")
            .releasedAt(LocalDateTime.now())
            .runtime(100)
            .build();
        movieRepository.save(movie1);

        Movie movie2 = Movie.builder()
            .title("Avengers 2")
            .releasedAt(LocalDateTime.now())
            .runtime(100)
            .build();
        movieRepository.save(movie2);
        List<Movie> movies = movieRepository.findAll();
        movies.forEach(movie->{
            assertThat(movie.getCreatedAt()).isBefore(LocalDateTime.now());
        });
    }
}
