package com.huatech.mall.address.impl;

import com.huatech.mall.address.IAddressService;
import com.huatech.mall.common.mapper.IBaseMapper;
import com.huatech.mall.common.service.impl.BaseServiceImpl;
import com.huatech.mall.entity.address.Address;
import com.huatech.mall.mapper.address.AddressMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 地址实现
 *
 * @author like
 * @date 2019-12-02 9:33 下午
 **/
@Service
public class AddressServiceImpl extends BaseServiceImpl<Address,Long> implements  IAddressService {

    @Autowired
    private AddressMapper addressMapper;


    @Override
    public IBaseMapper<Address, Long> getBaseMapper() {
        return this.addressMapper;
    }
}