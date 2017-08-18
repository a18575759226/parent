package com.xmg.shop.service;

import com.xmg.shop.domain.SkuProperty;
import com.xmg.shop.page.PageResult;
import com.xmg.shop.query.SkuPropertyQueryObject;

import javax.swing.tree.TreeNode;
import java.util.List;

/**SKU属性
 * Created by JINZHAOYU on 2017/8/13.
 */
public interface ISkuPropertyService {

    int deleteByPrimaryKey(Long id);

    int insert(SkuProperty record);

    SkuProperty selectByPrimaryKey(Long id);

    List<SkuProperty> selectAll();

    int updateByPrimaryKey(SkuProperty record);



    PageResult query(SkuPropertyQueryObject qo);

    /**
     * 获取树节点
     * @param parentId
     * @return
     */
    List<TreeNode> getTreeNodes(String parentId);

    /**
     * 根据产品分类查询该分类的
     * @param id
     * @return
     */
    List<SkuProperty> listSkusByProductCatlog(Long id);

    /**
     * 根据分类查询sku
     * @param catalogId
     * @return
     */
    List<SkuProperty> getSkuProperty(Long catalogId);

    /**
     * sku编辑以及保存
     * @param skuProperty
     */
    void saveOrUpdate(SkuProperty skuProperty);

    /**
     * 删除
     * @param id
     */
    void delect(Long id);
}
