package com.xmg.shop.query;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * 查询对象父类
 *
 * @date 2017/8/12
 */
@Getter
@Setter
@ToString
public class QueryObject implements Serializable{
    private Integer currentPage = 1;//当前页,默认为1
    private Integer pageSize = 5;//每页显示条数,默认为5

    /**
     * 获取分页查询的开始索引
     * @return
     */
    public int getStart() {
        return (currentPage - 1) * pageSize;
    }
}
