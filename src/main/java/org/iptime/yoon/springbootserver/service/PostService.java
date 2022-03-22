package org.iptime.yoon.springbootserver.service;

import org.iptime.yoon.springbootserver.domain.Post;
import org.iptime.yoon.springbootserver.dto.PageRequestDto;
import org.iptime.yoon.springbootserver.dto.PostDto;
import org.iptime.yoon.springbootserver.dto.PostsResultDto;


/**
 * @author rival
 * @since 2022-03-17
 */
public interface PostService {

     PostsResultDto findPosts(PageRequestDto pageable);
     PostDto findPost(Long id);
     Long register(Post post);
     
     
     
     default PostDto entityToDto(Post post){
          return PostDto.builder()
              .postType(post.getPostType().getValue())
              .content(post.getContent())
              .subTitle(post.getSubTitle())
              .id(post.getId())
              .title(post.getTitle())
              //.writer(post.getUser().getUsername())
              .build();           
     }

}
