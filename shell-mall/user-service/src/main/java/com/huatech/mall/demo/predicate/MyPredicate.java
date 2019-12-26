package com.huatech.mall.demo.predicate;

import com.huatech.mall.demo.Person;

/**
 * 策略模式接口
 *
 * @author like
 * @date 2019-12-25 10:21 上午
 **/
public interface MyPredicate {

    /**
     * 实例接口
     *
     * @param person
     * @return
     */
    boolean test(Person person);
}