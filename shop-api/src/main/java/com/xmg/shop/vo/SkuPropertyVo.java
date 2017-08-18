package com.xmg.shop.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author
 * @date 2017/8/15
 */
@Getter@Setter@ToString
public class SkuPropertyVo implements Serializable {
    private volatile Long id;
    private String name;
}
