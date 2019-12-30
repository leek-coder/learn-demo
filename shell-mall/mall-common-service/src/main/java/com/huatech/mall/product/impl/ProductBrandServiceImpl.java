package com.huatech.mall.product.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huatech.mall.common.enums.ApiBaseErrorCore;
import com.huatech.mall.common.exception.ExceptionCustomer;
import com.huatech.mall.common.mapper.IBaseMapper;
import com.huatech.mall.common.service.impl.BaseServiceImpl;
import com.huatech.mall.common.utils.BeanValidator;
import com.huatech.mall.entity.product.ProductBrand;
import com.huatech.mall.mapper.product.ProductBrandMapper;
import com.huatech.mall.param.product.ProductBrandParam;
import com.huatech.mall.param.product.ProductBrandQueryParam;
import com.huatech.mall.product.IProductBrandService;
import com.huatech.mall.res.product.ProductBrandList;
import com.huatech.mall.res.product.ProductBrandQueryRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 商品品牌service实现类
 *
 * @author like
 * @date 2019-12-30 1:59 下午
 **/
@Service
public class ProductBrandServiceImpl extends BaseServiceImpl<ProductBrand, Long> implements IProductBrandService {


    @Autowired
    private ProductBrandMapper productBrandMapper;

    @Override
    public IBaseMapper<ProductBrand, Long> getBaseMapper() {
        return this.productBrandMapper;
    }

    @Override
    public void saveProductBrand(ProductBrandParam productBrandParam) {

        //验证参数的合法性
        BeanValidator.check(productBrandParam);

        if (productBrandParam.getId() != null) {
            //先查询类目是否存在
            ProductBrand productBrand = productBrandMapper.selectByPrimaryKey(productBrandParam.getId());
            if (productBrand == null) {
                throw new ExceptionCustomer(ApiBaseErrorCore.PRODUCT_BRAND_NOT_EXISTS);
            }
            productBrand.setUpdateTime(new Date());
            productBrand.setLogo(productBrand.getLogo());
            productBrandMapper.updateByPrimaryKey(productBrand);

        } else {
            //查询有没有同名的类目
            ProductBrand productBrandDb = findProductBrandByName(productBrandParam.getName());
            if (productBrandDb != null) {
                throw new ExceptionCustomer(ApiBaseErrorCore.PRODUCT_BRAND_EXISTS);
            }
            ProductBrand productBrand = ProductBrand.builder().name(productBrandParam.getName()).status(productBrandParam.getStatus()).logo(productBrandParam.getLogo()).
                    firstLetter(productBrandParam.getFirstLetter()).sort(productBrandParam.getSort() == null ? 1 : productBrandParam.getSort()).bigPic(productBrandParam.getBigPic()).description(productBrandParam.getDescription()).
                    createTime(new Date()).build();
            productBrandMapper.insertSelective(productBrand);
        }
    }


    @Override
    public ProductBrand findProductBrandByName(String name) {
        return productBrandMapper.findProductBrandByName(name);
    }

    /**
     * 查找商品品类列表
     *
     * @return
     */
    @Override
    public ProductBrandQueryRes findProductBrandList(ProductBrandQueryParam productBrandQueryParam) {
        PageHelper.startPage(productBrandQueryParam.getPage(), productBrandQueryParam.getSize());
        List<ProductBrandList> productBrandLists = productBrandMapper.findProductBrandList();
        PageInfo pageInfo = new PageInfo(productBrandLists);
        return  new ProductBrandQueryRes(pageInfo.getTotal(),pageInfo.getList());
    }
}