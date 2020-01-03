package com.huatech.mall.product.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huatech.mall.common.enums.ApiBaseErrorCore;
import com.huatech.mall.common.exception.ExceptionCustomer;
import com.huatech.mall.common.mapper.IBaseMapper;
import com.huatech.mall.common.service.impl.BaseServiceImpl;
import com.huatech.mall.common.utils.BeanValidator;
import com.huatech.mall.entity.product.ProductAttribute;
import com.huatech.mall.entity.product.ProductAttributeCategory;
import com.huatech.mall.mapper.product.ProductAttributeMapper;
import com.huatech.mall.param.product.ProductAttributeParam;
import com.huatech.mall.param.product.ProductAttributeQueryParam;
import com.huatech.mall.product.IProductAttributeCategoryService;
import com.huatech.mall.product.IProductAttributeService;
import com.huatech.mall.res.product.ProductAttributeList;
import com.huatech.mall.res.product.ProductAttributeQueryRes;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 商品属性service实现
 *
 * @author like
 * @date 2020-01-02 3:04 下午
 **/
@Service
public class ProductAttributeServiceImpl extends BaseServiceImpl<ProductAttribute, Long> implements IProductAttributeService {


    @Autowired
    private ProductAttributeMapper productAttributeMapper;


    @Autowired
    private IProductAttributeCategoryService productAttributeCategoryService;

    @Override
    public IBaseMapper<ProductAttribute, Long> getBaseMapper() {
        return this.productAttributeMapper;
    }


    @Override
    public void saveProductAttribute(ProductAttributeParam productAttributeParam) {
        //校验参数
        BeanValidator.check(productAttributeParam);
        if (productAttributeParam.getId() != null) {
            //先查询商品属性是否存在
            List<ProductAttribute> attributes = findProductAttributeByNameAndCategoryId(productAttributeParam.getName(), productAttributeParam.getProductAttributeCategoryId());

            if (CollectionUtils.isEmpty(attributes)) {
                throw new ExceptionCustomer(ApiBaseErrorCore.PRODUCT_ATTRIBUTE_NOT_EXISTS);
            }

            ProductAttribute dbProductAttribute = attributes.get(0);
            dbProductAttribute.setName(productAttributeParam.getName());
            dbProductAttribute.setInputList(productAttributeParam.getInputList());
            dbProductAttribute.setSort(productAttributeParam.getSort());
            productAttributeMapper.updateByPrimaryKey(dbProductAttribute);

        } else {
            //查询有没有同名的类目
            List<ProductAttribute> attributes = findProductAttributeByNameAndCategoryId(productAttributeParam.getName(), productAttributeParam.getProductAttributeCategoryId());

            if (CollectionUtils.isNotEmpty(attributes)) {
                throw new ExceptionCustomer(ApiBaseErrorCore.PRODUCT_ATTRIBUTE_EXISTS);
            }
            ProductAttribute productAttribute = ProductAttribute.builder().name(productAttributeParam.getName()).createTime(new Date()).inputType(productAttributeParam.getInputType()).
                    inputList(productAttributeParam.getInputList()).selectType(productAttributeParam.getSelectType()).type(productAttributeParam.getType()).
                    sort(productAttributeParam.getSort()).productAttributeCategoryId(productAttributeParam.getProductAttributeCategoryId()).build();
            productAttributeMapper.insertSelective(productAttribute);
        }
    }

    @Override
    public List<ProductAttribute> findProductAttributeByNameAndCategoryId(String name, Long productCategoryId) {
        return productAttributeMapper.findProductAttributeByNameAndCategoryId(name, productCategoryId);
    }

    @Override
    public ProductAttributeQueryRes findProductAttributeLists(ProductAttributeQueryParam productAttributeQueryParam) {
        PageHelper.startPage(productAttributeQueryParam.getPage(), productAttributeQueryParam.getSize());
        List<ProductAttributeList> lists = productAttributeMapper.findProductAttributeLists(productAttributeQueryParam);
        PageInfo pageInfo = new PageInfo(lists);
        return new ProductAttributeQueryRes(pageInfo.getTotal(), pageInfo.getList());
    }
}