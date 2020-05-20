package br.com.senior.core.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FilterBuilder {

    private static final char WHITE_CHARACTER = ' ';
    private StringBuilder filter = new StringBuilder();
    private String orderBy;
    private String size;
    private String offset;

    public FilterBuilder field(String fieldName) {
        filter.append(WHITE_CHARACTER).append(fieldName);
        return this;
    }

    public FilterBuilder or() {
        filter.append(WHITE_CHARACTER).append("or");
        return this;
    }

    public FilterBuilder equals(String value) {
        filter.append(WHITE_CHARACTER).append("eq").append(WHITE_CHARACTER).append(getField(value));
        return this;
    }

    public FilterBuilder notEquals(String value) {
        filter.append(WHITE_CHARACTER).append("ne").append(WHITE_CHARACTER).append(getField(value));
        return this;
    }

    public FilterBuilder lowerThan(String value) {
        filter.append(WHITE_CHARACTER).append("lt").append(WHITE_CHARACTER).append(value);
        return this;
    }

    public FilterBuilder greaterThan(String value) {
        filter.append(WHITE_CHARACTER).append("gt").append(WHITE_CHARACTER).append(value);
        return this;
    }

    public FilterBuilder lowerOrEquals(String value) {
        filter.append(WHITE_CHARACTER).append("le").append(WHITE_CHARACTER).append(value);
        return this;
    }

    public FilterBuilder greaterOrEquals(String value) {
        filter.append(WHITE_CHARACTER).append("ge").append(WHITE_CHARACTER).append(value);
        return this;
    }

    public FilterBuilder and() {
        filter.append(WHITE_CHARACTER).append("and");
        return this;
    }

    public FilterBuilder containing(String fieldName, String value) {
        filter.append(WHITE_CHARACTER).append("containing(").append(fieldName).append(",'").append(value).append("')");
        return this;
    }

    public FilterBuilder isNull() {
        filter.append(WHITE_CHARACTER).append("is null");
        return this;
    }

    public FilterBuilder orderBy(String orderBy) {
        this.orderBy = orderBy;
        return this;
    }

    public FilterBuilder size(int size) {
        this.size = String.valueOf(size);
        return this;
    }

    public FilterBuilder offset(int offset) {
        this.offset = String.valueOf(offset);
        return this;
    }

    public FilterBuilder withCustomFilter(String filter) {
        this.filter = new StringBuilder(filter);
        return this;
    }


    public String build() {
        List<String> values = new ArrayList<>();
        Optional.ofNullable(filter).ifPresent(a -> values.add(a.toString().trim()));
        Optional.ofNullable(offset).ifPresent(a -> values.add("offset=" + a));
        Optional.ofNullable(size).ifPresent(a -> values.add("size=" + a));
        Optional.ofNullable(orderBy).ifPresent(a -> values.add("orderby=" + a));
        StringBuilder filter = new StringBuilder();
        filter.append("?filter=");
        for (int i = 0; i < values.size(); i++) {
            filter.append(values.get(i));
            if (i < values.size() - 1) {
                filter.append("&");
            }
        }
        return filter.toString();
    }

    private static String getField(String value) {
        try {
            Integer.parseInt(value);
            return value;
        } catch (NumberFormatException ignored) {
            return "'" + value + "'";
        }
    }

}
