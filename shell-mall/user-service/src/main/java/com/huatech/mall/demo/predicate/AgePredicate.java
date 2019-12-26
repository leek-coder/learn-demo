package com.huatech.mall.demo.predicate;

import com.huatech.mall.demo.Person;

/**
 * 年龄实现
 *
 * @author like
 * @date 2019-12-25 10:23 上午
 **/
public class AgePredicate implements MyPredicate {

    @Override
    public boolean test(Person person) {

        return person.getAge() > 30;
    }
}