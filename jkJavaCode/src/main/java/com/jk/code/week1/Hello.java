package com.jk.code.week1;

/**
 * @description:
 * @author: junmo
 * @create: 2021-05-09 11:10
 **/

public class Hello {

    public void hello(int num) {
        int a = 1, b = 2;
        int add = a + b;
        int subtract = b - a;
        int multiply = a * b;
        int divide = b / a;

        if (a + num > b){
            System.out.println(true);
        }

        int sum = 0;
        for (int i = 0; i < 6; i++) {
            sum += i;
        }
    }


}
