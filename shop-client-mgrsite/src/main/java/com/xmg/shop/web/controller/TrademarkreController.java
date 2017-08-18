package com.xmg.shop.web.controller;

import com.xmg.shop.domain.Trademark;
import com.xmg.shop.service.ITrademarkService;
import com.xmg.shop.util.AjaxResult;
import com.xmg.shop.util.UploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;

/**
 * Created by liu on 2017/8/14.
 */
@Controller
public class TrademarkreController {
   @Autowired
    private ITrademarkService trademarkService;
    @Autowired
    private ServletContext ctx;
    @RequestMapping("trademark")
    public String insert(Model model){
        model.addAttribute("pageResult",trademarkService.selectAll());
        return  "/trademark/trademark";
    }

    @RequestMapping("/trademarkSave")
    @ResponseBody
    public AjaxResult productSave(Trademark trademark){
        System.out.println("ooooooooooooooo");
        System.out.println("**********************************************");
        try {
            trademarkService.saveOrUpdate(trademark);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new AjaxResult();
    }

    @RequestMapping("trademarkImgUpload")
    @ResponseBody
    public String realAuthUpload(MultipartFile file){
        String realName = UploadUtil.upload(file, ctx.getRealPath("/upload"));
        System.out.println(realName);
        return "/upload/"+realName;
    }

    /**
     * 分类删除操作
     *
     * @param
     * @return
     */
    @RequestMapping("deletetrademark.do")
    @ResponseBody
    public AjaxResult deletetrademark(int trademarkId) {
        AjaxResult result = null;
        try {
            System.out.println("**********************************************");
            System.out.println(trademarkId);
            trademarkService.deleteByPrimaryKey(trademarkId);
            result = new AjaxResult();
        } catch (Exception e) {
            e.printStackTrace();
            result = new AjaxResult(e.getMessage());
        }

        return result;
    }
}
