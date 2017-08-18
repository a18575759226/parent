package com.xmg.shop.web.controller;

import com.xmg.shop.domain.OrderInfo;
import com.xmg.shop.page.PageResult;
import com.xmg.shop.query.OrderQueryObject;
import com.xmg.shop.service.IOrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by JINZHAOYU on 2017/8/15.
 */
@Controller
public class OrderInfoController {

    @Autowired
    private IOrderInfoService orderInfoService;

    @RequestMapping("orderList.do")
    public String orderList(@ModelAttribute("qo")OrderQueryObject qo , Model model){
        PageResult result=  orderInfoService.query(qo);
        model.addAttribute("pageResult",result);
        return  "order/order_list";
    }
}
