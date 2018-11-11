package com.lzc.demo.dto;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author lzc 2018/11/11
 * @param <T> 泛型
 * 用于数据返回带分页信息的通用包装类
 */
public class UserList<T> {
    public List<T> records;
    public Integer pageNumber;
    public Integer pageSize;
    public Integer pageCount;
    public Integer recordCount;

    public UserList(List<T> records, Integer pageNumber, Integer pageSize, Integer pageCount, Integer recordCount) {
        this.records = records;
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
        this.pageCount = pageCount;
        this.recordCount = recordCount;

        if (recordCount != null && pageSize != null && pageSize != 0) {
            this.pageCount = (recordCount - 1) / pageSize + 1;
        }
    }
    public <O> UserList(List<O> records, Function<? super O,? extends T> mapper) {
        this(records.stream().map(mapper).collect(Collectors.toList()));
    }
    public UserList(List<T> records) {
        this.records = records;
    }

    public List<T> getRecords() {
        return records;
    }

    public void setRecords(List<T> records) {
        this.records = records;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public Integer getRecordCount() {
        return recordCount;
    }

    public void setRecordCount(Integer recordCount) {
        this.recordCount = recordCount;
    }
}
