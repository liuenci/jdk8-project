package com.cier.pattern;

public class Demo1 {

    public static void main(String[] args) {
        Programmer programmer = new Programmer(new Student());
        programmer.code();
    }
}

interface Coder {
    public void code();
}

class Student implements Coder{

    @Override
    public void code() {
        System.out.println("javase");
        System.out.println("javaweb");
    }
}

class Programmer implements Coder{
    // 获取被装饰类的引用
    private Student student;
    // 在构造方法中传入被装饰类的对象
    public Programmer(Student student){
        this.student = student;
    }
    // 对原有的功能进行升级
    @Override
    public void code() {
        student.code();
        System.out.println("ssh");
        System.out.println("大数据");
        System.out.println("人工智能");
    }
}