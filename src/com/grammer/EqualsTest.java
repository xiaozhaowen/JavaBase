package com.grammer;


import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by knight on 16/12/30.
 */
public class EqualsTest {

    /**
     *
     *  有时候我们希望某些属性值相同则认为对象是相同的,这个时候就需要重写equals方法
     *
     *  */




    /**
     *  ==  运算符
     *  如果比较值类型则直接比较数据的值
     *  如果比较引用类型,则看是不是同一个引用。而不是看对象的内容。
     *
     *
     *  */


    //检查基本类型
    @Test
    public void doubleEqualsValueType(){
        int a=10;
        int b=10;
        System.out.println(a==b); //true


        char x ='a';
        char y ='a';
        System.out.println(x==y); //true
    }



    //一个对象如果有多个引用,那么会认为这些引用相同
    //二个对象,即便内容一模一样,也不会被认为是相同的
    @Test
    public void doubleEqualsSameObjectMultiRef(){
        Person kobe = new Person();
        kobe.setName("Kobe");
        kobe.setAge(38);

        Person kobe2 = new Person();
        kobe2.setName("Kobe");
        kobe2.setAge(38);


        Person anotherRef = kobe;
        System.out.println(kobe ==anotherRef); //true

        System.out.println(kobe==kobe2); //false


        //输出他们的hashCode
        System.out.println(kobe.hashCode());
        System.out.println(kobe2.hashCode());

    }



    @Test
    public void equalsInstance(){
        Person kobe = new Person();
        kobe.setId(30);
        kobe.setName("Kobe");
        kobe.setAge(38);

        Person kobe2 = new Person();
        kobe2.setId(30);
        kobe2.setName("Kobe");
        kobe2.setAge(38);

        //检查2个实例的hashCode值
        System.out.println(kobe.hashCode() == kobe2.hashCode());//true

        //检查equals
        System.out.println(kobe.equals(kobe2)); //false


        //HashSet中不应该出现重复的元素
        Set<Person> set = new HashSet<Person>();
        set.add(kobe);
        set.add(kobe2);

        //在没有重写equals方法之前会输出 [com.grammer.Person@0, com.grammer.Person@0]
        //重写equals方法之后会输出 [com.grammer.Person@0]
        System.out.println(set);

    }


}
