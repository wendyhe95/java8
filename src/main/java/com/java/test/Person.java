package com.java.test;


import java.lang.reflect.Method;

/**
 * Created by wendyhe on 2019/6/26.
 */
public class Person {

    private Gender gender;  // 性别
    private int age;        // 年龄
    private String name;    // 姓名


    public Person() {
        this("unknown",0,Gender.FEMALE);
    }

    public Person(String name,int age,Gender gender){
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    protected int getAge() {
        return age;
    }

    protected void setAge(int age) {
        this.age = age;
    }


    private Gender getGender() {
        return gender;
    }

    private void setGender(Gender gender) {
        this.gender = gender;
    }

    // getInner() 中有内部类InnerB，用来测试getEnclosingMethod()
    public void getInner(){

        // 内部类
        class InnerB{
        }
        // 获取InnerB的Class对象
        Class cls = InnerB.class;

        // 获取“封闭该内部类(InnerB)”的构造方法
        Method cst = cls.getEnclosingMethod();

        System.out.println("call--\"getInner()\" cst="+cst);
    }




    //        private Person() {
//            this.name = "unknown";
//            this.age = 0;
//            this.gender = Gender.FEMALE;
//            System.out.println("call--\"private Person()\"");
//        }
//        protected Person(String name) {
//            this.name = name;
//            this.age = 0;
//            this.gender = Gender.FEMALE;
//            System.out.println("call--\"protected Person(String name)\"");
//        }
//        public Person(String name, int age, Gender gender) {
//            this.name = name;
//            this.age = age;
//            this.gender = gender;
//            System.out.println("call--\"public Person(String name, int age, Gender gender)\"");
//        }

//    public Person(String name, int age) {
//        this.name = name;
//        this.age = age;
//        this.gender = Gender.FEMALE;
//        //内部类在构造方法中
//        class InnerA{
//        }
//        // 获取InnerA的Class对象
//        Class cls = InnerA.class;
//
//        // 获取“封闭该内部类(InnerA)”的构造方法
//        Constructor cst = cls.getEnclosingConstructor();
//
//        System.out.println("call--\"public Person(String name, int age)\" cst="+cst);
//    }
    @Override
    public String toString() {
            return "("+name+", "+age+", "+gender+")";
        }
}

