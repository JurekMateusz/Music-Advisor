package com.example.musicadvisor.service;

import com.example.musicadvisor.api.model.albums.Albums;
import com.example.musicadvisor.model.pagination.Pagination;
import org.springframework.stereotype.Component;

@Component
public class PaginationBuilder {

    public Pagination createPagination(Albums albums) {
        int limit = albums.getLimit();
        int offset = albums.getOffset();
        int total = albums.getTotal();
        int currentPage = countCurrentPage(offset, limit);
        int totalPages = countTotalPages(total, limit);
        
        return Pagination.builder()
                .totalPages(totalPages)
                .pageSize(limit)
                .currentPage(currentPage)
                .build();
    }

    private int countCurrentPage(int offset, int limit) {
        return offset / limit;
    }

    private int countTotalPages(int totalPages, int limit) {
        int pages = totalPages / limit - 1;
        if (totalPages % limit != 0) pages += 1;
        return pages;
    }
}
