package br.com.senior.core.entity;

import java.util.List;

public class EntityPage<T> {

    private long totalPages;
    private long totalElements;
    private List<T> contents;
    private Class<T> clz;

    public EntityPage() {
    }

    public EntityPage(long totalPages, long totalElements, List<T> contents, Class<T> clz) {
        this.totalPages = totalPages;
        this.totalElements = totalElements;
        this.contents = contents;
        this.clz = clz;
    }

    public void setClz(Class<T> clz) {
        this.clz = clz;
    }

    public long getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(long totalPages) {
        this.totalPages = totalPages;
    }

    public long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(long totalElements) {
        this.totalElements = totalElements;
    }

    public List<T> getContents() {
        return contents;
    }

    public void setContents(List<T> contents) {
        this.contents = contents;
    }
}
