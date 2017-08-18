package com.xmg.shop.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;
@Getter
@Setter
@ToString
public class ProductSku implements Serializable{
    private Long id;

    private Product product;

    private String code;

    private BigDecimal price;

    private Long mods;

}