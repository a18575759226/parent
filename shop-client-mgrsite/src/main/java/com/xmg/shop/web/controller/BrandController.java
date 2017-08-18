package com.xmg.shop.web.controller;

import com.xmg.shop.domain.Brand;
import com.xmg.shop.service.IBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 品牌控制器
 *
 * @author dongc
 * @date 2017/8/11
 */
@Controller
public class BrandController {

    @Autowired
    private IBrandService brandService;

    @RequestMapping("/brandList.do")
    @ResponseBody
    public Brand getBrandList(){
        return brandService.get(1L);
    }

}