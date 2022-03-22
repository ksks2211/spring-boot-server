package org.iptime.yoon.springbootserver.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

/**
 * @author rival
 * @since 2022-03-22
 */
@Builder
@AllArgsConstructor
@Data
public class PageRequestDto {
    private int page;
    private int size;

    public PageRequestDto(){
        this.page=1;
        this.size=10;
    }

    public Pageable getPageable(Sort sort){
        return sort != null ? PageRequest.of(
            this.page <= 0 ? 0 : this.page-1,
            Math.min(this.size, 20),
            sort
        ) : PageRequest.of(
            this.page <= 0 ? 0 : this.page-1,
            Math.min(this.size, 20)
        ) ;
    }
}
