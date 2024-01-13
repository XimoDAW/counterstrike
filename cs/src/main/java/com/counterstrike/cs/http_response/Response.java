package com.counterstrike.cs.http_response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Optional;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response {
    private Integer totalRecords;
    private Integer page;
    private Integer pageSize;
    private Integer totalPages;
    private String next;
    private String previous;
    private Object data;


    public Response(Object data, int totalRecords) {
        this.data = data;
        this.totalRecords = totalRecords;
        this.page = null;
        this.pageSize = null;
        this.totalPages = null;
        this.next = null;
        this.previous = null;
    }

    public Response(Object data) {
        this.data = data;
        this.totalRecords = null;
        this.page = null;
        this.pageSize = null;
        this.totalPages = null;
        this.next = null;
        this.previous = null;
    }

    public Response(Object data, int totalRecords, Optional<Integer> page, int pageSize) {
        this.data = data;
        this.totalRecords = totalRecords;
        if (page.isPresent()) {
            buildPaginationMetaData(totalRecords, pageSize, page.get());

        } else {
            buildPaginationMetaData(totalRecords, 10, 1);
        }
    }
    private void buildPaginationMetaData(int totalRecords, int pageSize, int page) {
        this.page = page;
        this.pageSize = pageSize;
        int totalPages = (int) (Math.ceil((double) totalRecords / pageSize));
        this.totalPages = totalPages;
        String url = ServletUriComponentsBuilder.fromCurrentContextPath().build().toString();

        if (page > 1 && totalPages > 1)
            this.previous = url + "/cs?page=" + (page - 1) + "&pageSize=" + pageSize;
        if (page < totalPages)
            this.next = url + "/cs?page=" + (page + 1) + "&pageSize=" + pageSize;
    }
}
