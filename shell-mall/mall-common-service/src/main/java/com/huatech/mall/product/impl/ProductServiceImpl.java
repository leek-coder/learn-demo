package com.huatech.mall.product.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huatech.mall.common.enums.ApiBaseErrorCore;
import com.huatech.mall.common.exception.ExceptionCustomer;
import com.huatech.mall.common.mapper.IBaseMapper;
import com.huatech.mall.common.service.impl.BaseServiceImpl;
import com.huatech.mall.common.utils.BeanValidator;
import com.huatech.mall.entity.product.Product;
import com.huatech.mall.mapper.product.ProductMapper;
import com.huatech.mall.param.product.ProductParam;
import com.huatech.mall.product.IProductService;
import com.huatech.mall.res.product.ProductList;
import com.huatech.mall.res.product.ProductQueryRes;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * 商品实现类
 *
 * @author like
 * @date 2019-12-19 7:44 下午
 **/

@Service
public class ProductServiceImpl extends BaseServiceImpl<Product, String> implements IProductService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public IBaseMapper<Product, String> getBaseMapper() {
        return this.productMapper;
    }

    @Override
    public void saveOrUpdate(ProductParam param) {
        //检查参数是否合法
        BeanValidator.check(param);
        //更新
        if (StringUtils.isNotBlank(param.getProductId())) {
            Product product = productMapper.selectByPrimaryKey(param.getProductId());
            if (product == null) {
                throw new ExceptionCustomer(ApiBaseErrorCore.PRODUCT_NOT_EXISTS);
            }
            BeanUtils.copyProperties(param, product);
            product.setUpdateTime(new Date());
            product.setProductCreateUser(product.getProductCreateUser());
            productMapper.updateByPrimaryKey(product);
        } else {
            //增加商品不需要判断商品中是否存在同名的商品
            Product product = new Product();
            BeanUtils.copyProperties(param, product);
            //商品编号
            product.setProductId(UUID.randomUUID().toString());
            product.setCreateTime(new Date());
            productMapper.insertSelective(product);


        }
    }

    /**
     * 查询所有的商品数据
     *
     * @param param
     * @return
     */
    @Override
    public ProductQueryRes findProductList(ProductParam param) {
        PageHelper.startPage(param.getPage(), param.getSize());
        List<ProductList> products = productMapper.findProductList(param);
        PageInfo pageInfo = new PageInfo(products);
        return new ProductQueryRes(pageInfo.getTotal(), pageInfo.getList());
    }
}