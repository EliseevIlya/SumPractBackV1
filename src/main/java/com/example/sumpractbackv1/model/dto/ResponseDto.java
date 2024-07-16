package com.example.sumpractbackv1.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.domain.Page;

import java.util.List;

@Getter
@Setter
@ToString
public class ResponseDto<T> {

    private Integer totalPages;
    private Long totalElements;
    private Integer size;
    private List<T> content;
    private Integer pageNumber;

    public ResponseDto(Page<T> page) {
        this.totalPages = page.getTotalPages();
        this.totalElements = page.getTotalElements();
        this.size = page.getSize();
        this.content = page.getContent();
        this.pageNumber = page.getNumber();
    }
}
