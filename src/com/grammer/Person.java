package com.grammer;

/**
 * Created by knight on 16/12/30.
 */
public class Person {


    private int id;
    private String name;
    private  int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        return this.id % 10;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj ==null)
            return  false;
        if(obj ==this)
            return true;
        if(!(obj instanceof Person))
            return  false;

        Person person = (Person)obj;
        if(person.getId() == this.id){
            return  true;
        }
        return  false;
    }
}
