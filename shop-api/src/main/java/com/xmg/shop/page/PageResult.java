package com.xmg.shop.page;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class PageResult implements Serializable{

    private List<?> listData;
    private Integer totalCount;
    private Integer currentPage;
    private Integer pageSize;
    private Integer totalPage;
    private Integer prePage;
    private Integer nextPage;

    public PageResult() {}

    public PageResult(List<?> listData, Integer totalCount,
                      Integer currentPage, Integer pageSize) {
        super();
        this.listData = listData;
        this.totalCount = totalCount;
        this.currentPage = currentPage;
        this.pageSize = pageSize;

        this.totalPage = this.totalCount % this.pageSize == 0 ? this.totalCount
                / this.pageSize : this.totalCount / this.pageSize + 1;
        this.prePage = this.currentPage - 1 >= 1 ? this.currentPage - 1 : 1;
        this.nextPage = this.currentPage + 1 <= this.totalPage ? this.currentPage + 1
                : this.totalPage;
    }

    public Integer getTotalPage() {
        return totalPage == 0 ? 1 : totalPage;
    }

    // 如果总数据条数为0,返回一个空集
    public static PageResult empty(Integer pageSize) {
        return new PageResult(new ArrayList<>(), 0, 1, pageSize);
    }
}
