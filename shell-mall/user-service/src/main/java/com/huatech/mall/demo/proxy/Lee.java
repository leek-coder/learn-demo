package com.huatech.mall.demo.proxy;

/**
 * lee
 *
 * @author like
 * @date 2019-12-25 4:13 下午
 **/
public class Lee implements  Student {

    private String name = "leek";
    private String sex = "男";

    @Override
    public void findLove() {
        System.out.println("理科");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}