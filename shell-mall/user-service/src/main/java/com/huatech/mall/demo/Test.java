package com.huatech.mall.demo;


import com.huatech.mall.common.utils.MD5Utils;
import com.huatech.mall.demo.proxy.Lee;
import com.huatech.mall.demo.proxy.ProxyHandle;
import com.huatech.mall.demo.proxy.Student;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 等分数据
 *
 * @author like
 * @date 2019-12-23 5:38 下午
 **/
public class Test {

    public static void main(String[] args) throws Exception {


        String s = MD5Utils.md5("111111");
        System.out.println(s);
        Student lee = new Lee();
        InvocationHandler proxyHandle = new ProxyHandle<Student>(lee);
        Student lee1 = (Student) Proxy.newProxyInstance(Student.class.getClassLoader(), new Class<?>[]{Student.class}, proxyHandle);
        lee1.findLove();
        /**
         * 原理：
         * 拿到被代理对象的引用，然后获取他的接口
         * JDK动态代理重新生成一个类，同时实现我们给的代理对象的接口
         * 把被代理对象的引用也拿到了
         * 重新动态生成一个class字节码
         *
         */
//        List<Person> persons = Arrays.asList(
//                new Person(101, "like", 20),
//                new Person(102, "张三", 21),
//                new Person(103, "李四", 40),
//                new Person(104, "王五", 33),
//                new Person(105, "孙琦", 28)
//        );
//
//        List<Person> collect = persons.stream().filter(e ->
//                e.getAge() > 28
//
//        ).sorted((e1, e2) -> {
//            return Integer.compare(e1.getAge(), e2.getAge());
//        }).skip(3).limit(3).collect(Collectors.toList());

//        System.out.println("collect=" + collect);

//        persons.stream().map(Person::getName).forEach(System.out::println);

//        List<String> strs = persons.stream().map(Person::getName).limit(2).collect(Collectors.toList());
//        System.out.println(strs);

//        Stream<Person> stream = persons.stream();
//        System.out.println("stream="+stream);
//        Arrays.
//        Optional<Person> first = persons.stream().filter(e ->
//                e.getAge() > 20
//        ).findFirst();
//        Person person = first.get();
//        System.out.println(person.getName());


    }

}