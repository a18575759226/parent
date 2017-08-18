package com.xmg.shop.query;

import lombok.Getter;
import lombok.Setter;

/**
 * 产品查询对象
 * @author dongc
 * @date 2017/8/13
 */
@Getter
@Setter
public class ProductQueryObject extends QueryObject {
    private String keyword;
}
