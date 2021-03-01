package br.com.senior.core.entity;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EntityFilter {

    private static final char WHITE_CHARACTER = ' ';

    private StringBuilder filter = new StringBuilder();
    private String orderBy;
    private String size;
    private String offset;

    private EntityFilter() {
    }

    public static EntityFilter builder() {
        return new EntityFilter();
    }

    private String getField(String value) {
        try {
            Integer.parseInt(value);
            return value;
        } catch (NumberFormatException ignored) {
            return "'" + value + "'";
        }
    }

    public EntityFilter field(String fieldName) {
        filter.append(WHITE_CHARACTER).append(fieldName);
        return this;
    }

    public EntityFilter or() {
        filter.append(WHITE_CHARACTER).append("or");
        return this;
    }

    public EntityFilter equals(String value) {
        filter.append(WHITE_CHARACTER).append("eq").append(WHITE_CHARACTER).append(getField(value));
        return this;
    }

    public EntityFilter notEquals(String value) {
        filter.append(WHITE_CHARACTER).append("ne").append(WHITE_CHARACTER).append(getField(value));
        return this;
    }

    public EntityFilter lowerThan(String value) {
        filter.append(WHITE_CHARACTER).append("lt").append(WHITE_CHARACTER).append(value);
        return this;
    }

    public EntityFilter greaterThan(String value) {
        filter.append(WHITE_CHARACTER).append("gt").append(WHITE_CHARACTER).append(value);
        return this;
    }

    public EntityFilter lowerOrEquals(String value) {
        filter.append(WHITE_CHARACTER).append("le").append(WHITE_CHARACTER).append(value);
        return this;
    }

    public EntityFilter greaterOrEquals(String value) {
        filter.append(WHITE_CHARACTER).append("ge").append(WHITE_CHARACTER).append(value);
        return this;
    }

    public EntityFilter and() {
        filter.append(WHITE_CHARACTER).append("and");
        return this;
    }

    public EntityFilter containing(String fieldName, String value) {
        filter.append(WHITE_CHARACTER).append("containing(").append(fieldName).append(",'").append(value).append("')");
        return this;
    }

    public EntityFilter isNull() {
        filter.append(WHITE_CHARACTER).append("is null");
        return this;
    }

    public EntityFilter orderBy(String orderBy) {
        this.orderBy = orderBy;
        return this;
    }

    public EntityFilter size(int size) {
        this.size = String.valueOf(size);
        return this;
    }

    public EntityFilter offset(int offset) {
        this.offset = String.valueOf(offset);
        return this;
    }

    public EntityFilter withCustomFilter(String filter) {
        this.filter = new StringBuilder(filter);
        return this;
    }

    public String build() {
        List<String> values = new ArrayList<>();
        Optional.ofNullable(filter).ifPresent(a -> values.add(a.toString().trim()));
        Optional.ofNullable(offset).ifPresent(a -> values.add("offset=" + a));
        Optional.ofNullable(size).ifPresent(a -> values.add("size=" + a));
        Optional.ofNullable(orderBy).ifPresent(a -> values.add("orderby=" + a));

        StringBuilder sb = new StringBuilder();
        sb.append("?sb=");

        for (int i = 0; i < values.size(); i++) {
            sb.append(URLEncoder.encode(values.get(i), StandardCharsets.US_ASCII));
            if (i < values.size() - 1) {
                sb.append("&");
            }
        }
        return sb.toString();
    }

}
