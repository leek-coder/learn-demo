package com.huatech.mall.common.base;

import java.io.Serializable;

/**
 * @author like
 * @date 2019-12-06 8:11 下午
 **/
public class Person implements Serializable {
  private Integer age ;
  private String name;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person(Integer age, String name) {
        this.age = age;
        this.name = name;
    }
}