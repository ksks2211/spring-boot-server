package org.iptime.yoon.springbootserver.dto;

import org.iptime.yoon.springbootserver.domain.Post;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.function.Function;

/**
 * @author rival
 * @since 2022-03-22
 */
public class PostsResultDto extends PageResultDto<PostDto, Post> {
    public PostsResultDto(Page<Post> records, Function<Post, PostDto> fn) {
        super(records, fn);
    }

    public List<PostDto> getPosts(){
        return this.getDtoList();
    }
}
