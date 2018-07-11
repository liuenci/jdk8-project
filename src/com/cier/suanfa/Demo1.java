package com.cier.suanfa;

/**
 * 递归算法
 * 简单来说就是自己调用自己
 * 5 * 4 * 3 * 2 * 1
 * 好处：不用知道递归次数
 * 弊端：次数过多会造成堆栈移除
 * 构造方法中不能使用递归调用
 *
 * 递归调用可以有返回值，可以没有递归调用
 */
public class Demo1 {

    public static void main(String[] args) {
        /*int result = 1;
        for (int i = 1; i < 6; i++) {
            result *= i;
        }
        System.out.println(result);*/
        System.out.println(fun(10));
    }


    public static int fun(int n){
        if (n == 1){
            return n;
        }
        return n * fun(n - 1);
    }

}
