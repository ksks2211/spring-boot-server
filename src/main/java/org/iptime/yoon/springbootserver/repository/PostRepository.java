package org.iptime.yoon.springbootserver.repository;

import org.iptime.yoon.springbootserver.domain.Post;
import org.iptime.yoon.springbootserver.domain.security.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author rival
 * @since 2022-03-17
 */
@Repository
public interface PostRepository extends JpaRepository<Post,Long> {
    Page<Post> findByUser(UserEntity user, Pageable pageable);
    List<Post> findByUser(UserEntity user);
}