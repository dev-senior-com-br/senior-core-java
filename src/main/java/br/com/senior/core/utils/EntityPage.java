package br.com.senior.core.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Array;

public class EntityPage<T> {


    private long totalPages;
    private long totalElements;
    private T[] contents;
    private Class<T> clz;

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

    public T[] getContents() {
        return contents;
    }

    public void setContents(T[] contents) {
        this.contents = contents;
    }
}
