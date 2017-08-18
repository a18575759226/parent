package com.xmg.shop.util;

import lombok.Getter;
import lombok.Setter;

/**
 * @author
 * @date 2017/8/12
 */
@Setter@Getter
public class AjaxResult {
    private boolean success = true;
    private String msg;

    public AjaxResult() {
    }

    public AjaxResult(String msg) {
        this.success = false;
        this.msg = msg;
    }
}
