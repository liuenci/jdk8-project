package com.cier.ms;

public class OuterClass {
    class InnerClass{

    }
    static class StaticInnerClass{

    }

    public static void main(String[] args) {
        // InnerClass innerClass = new InnerClass();
        OuterClass outerClass = new OuterClass();
        InnerClass innerClass = outerClass.new InnerClass();
        StaticInnerClass staticInnerClass = new StaticInnerClass();
    }
}
