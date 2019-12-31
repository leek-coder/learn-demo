package com.huatech.mall.product.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huatech.mall.common.enums.ApiBaseErrorCore;
import com.huatech.mall.common.exception.ExceptionCustomer;
import com.huatech.mall.common.mapper.IBaseMapper;
import com.huatech.mall.common.service.impl.BaseServiceImpl;
import com.huatech.mall.common.utils.BeanValidator;
import com.huatech.mall.entity.product.ProductAttributeCategory;
import com.huatech.mall.mapper.product.ProductAttributeCategoryMapper;
import com.huatech.mall.param.product.ProductAttributeCategoryParam;
import com.huatech.mall.product.IProductAttributeCategoryService;
import com.huatech.mall.res.product.ProductAttributeCategoryList;
import com.huatech.mall.res.product.ProductAttributeCategoryQueryRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 商品类型实现类
 *
 * @author like
 * @date 2019-12-31 10:48 上午
 **/
@Service
public class ProductAttributeCategoryServiceImpl extends BaseServiceImpl<ProductAttributeCategory, Long> implements IProductAttributeCategoryService {


    @Autowired
    private ProductAttributeCategoryMapper productAttributeCategoryMapper;

    @Override
    public IBaseMapper<ProductAttributeCategory, Long> getBaseMapper() {
        return this.productAttributeCategoryMapper;
    }

    /**
     * 保存商品类型数据
     *
     * @param productAttributeCategoryParam
     */

    @Override
    public void saveProductAttributeCategory(ProductAttributeCategoryParam productAttributeCategoryParam) {
        //校验参数
        BeanValidator.check(productAttributeCategoryParam);
        if (productAttributeCategoryParam.getId() != null) {
            //先查询类目是否存在
            ProductAttributeCategory productAttributeCategory = productAttributeCategoryMapper.selectByPrimaryKey(productAttributeCategoryParam.getId());
            if (productAttributeCategory == null) {
                throw new ExceptionCustomer(ApiBaseErrorCore.PRODUCT_ATTRIBUTE_CATEGORY_NOT_EXISTS);
            }
            productAttributeCategory.setName(productAttributeCategoryParam.getName());
            productAttributeCategoryMapper.updateByPrimaryKey(productAttributeCategory);

        } else {
            //查询有没有同名的类目
            ProductAttributeCategory productBrandDb = findProductAttributeCategoryByName(productAttributeCategoryParam.getName());
            if (productBrandDb != null) {
                throw new ExceptionCustomer(ApiBaseErrorCore.PRODUCT_ATTRIBUTE_CATEGORY_EXISTS);
            }
            ProductAttributeCategory productBrand = ProductAttributeCategory.builder().name(productAttributeCategoryParam.getName()).createTime(new Date()).build();
            productAttributeCategoryMapper.insertSelective(productBrand);
        }

    }

    @Override
    public ProductAttributeCategory findProductAttributeCategoryByName(String name) {
        return productAttributeCategoryMapper.findProductAttributeCategoryByName(name);
    }

    @Override
    public ProductAttributeCategoryQueryRes findProductAttributeList(ProductAttributeCategoryParam productAttributeCategoryParam) {
        PageHelper.startPage(productAttributeCategoryParam.getPage(), productAttributeCategoryParam.getSize());
        List<ProductAttributeCategoryList> categoryLists = productAttributeCategoryMapper.findProductAttributeCategorys();
        PageInfo pageInfo = new PageInfo(categoryLists);
        return new ProductAttributeCategoryQueryRes(pageInfo.getTotal(), pageInfo.getList());
    }

    @Override
    public List<ProductAttributeCategoryList> queryProductAttributeList() {
        List<ProductAttributeCategoryList> categoryLists = productAttributeCategoryMapper.findProductAttributeCategorys();
        return categoryLists;
    }
}