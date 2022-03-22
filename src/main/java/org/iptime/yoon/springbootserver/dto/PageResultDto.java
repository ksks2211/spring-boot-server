package org.iptime.yoon.springbootserver.dto;

import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author rival
 * @since 2022-03-22
 */
@Data
public class PageResultDto<DTO, EN> {
    private List<DTO> dtoList;

    private int totalPage;


    // current_page
    private int page;

    //
    private int size;

    private int startPage, endPage;


    private boolean prev, next;

    private List<Integer> pageList;

    public PageResultDto(Page<EN> records, Function<EN, DTO> fn) {
        this.dtoList =
            records.stream().map(fn).collect(Collectors.toList());
        this.totalPage = records.getTotalPages();

        init(records.getPageable());
    }

    public void init(Pageable pageable) {
        this.page = pageable.getPageNumber() + 1;
        this.size = pageable.getPageSize();

        int expectedEndPage = (int) (Math.ceil((double)page / this.size)) * this.size;

        this.startPage = expectedEndPage - this.size + 1;
        this.prev = this.startPage > 1;
        this.endPage = Math.min(this.totalPage, expectedEndPage);
        this.next = this.totalPage > expectedEndPage;

        this.pageList = IntStream.rangeClosed(startPage, endPage).boxed().collect(Collectors.toList());
    }
}
