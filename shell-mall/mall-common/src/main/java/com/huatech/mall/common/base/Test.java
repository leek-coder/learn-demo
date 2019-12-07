package com.huatech.mall.common.base;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试
 *
 * @author like
 * @date 2019-12-06 8:10 下午
 **/
public class Test {

    public static void main(String[] args) {

        List<Person> per = new ArrayList<>();
        per.add(new Person(10, "李苛"));
        per.add(new Person(29, "张三"));
        per.add(new Person(17, "王武"));


        Person person = per.stream().max((e1, e2) -> e1.getAge().compareTo(e2.getAge())).get();
        System.out.println(person.getName());

        String name = "122";
        System.out.println(name.substring(0,2)+"%");
    }
}