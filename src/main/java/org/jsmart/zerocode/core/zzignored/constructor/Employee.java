package org.jsmart.zerocode.core.zzignored.constructor;

public class Employee{
    String name;
    Integer age;

    public Employee(String name, Integer age){
        this.name=name;
        this.age=age;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }
}