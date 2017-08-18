package com.xmg.shop.query;

import com.xmg.shop.util.DateUtil;
import lombok.Getter;
import lombok.Setter;
import org.springframework.util.StringUtils;

import java.util.Date;

/**
 * Created by JINZHAOYU on 2017/8/15.
 */
@Getter
@Setter
public class OrderQueryObject extends  QueryObject {

    private String keyword ;

    private int state = -1 ;

    private Date beginDate ;

    private Date endDate ;

    //要对时间的处理
    public Date getBeginDate(){

        return DateUtil.getBeginDate(beginDate);
    }
    public Date getEndDate(){

        return DateUtil.getBeginDate(endDate);
    }
    //防止传空字符串
    public String getKeyword(){

        return StringUtils.hasLength(keyword)?keyword:null;
    }

}
