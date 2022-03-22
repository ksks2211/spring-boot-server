package org.iptime.yoon.springbootserver.dto;

import lombok.Builder;
import lombok.Data;

/**
 * @author rival
 * @since 2022-03-22
 */
@Data
@Builder
public class PostDto {

    private Long id;
    private String title;
    private String subTitle;
    private String content;
    private String postType;
    private String writer;

}
