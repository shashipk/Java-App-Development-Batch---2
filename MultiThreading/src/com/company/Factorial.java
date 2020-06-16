package com.company;

import java.math.BigInteger;

public class Factorial {

    public static void main(String[]args){

        int[]arr = {10000, 20000, 30000, 12000, 50000, 15000, 40000, 19000, 17000, 26000, 14000};

        long start = System.currentTimeMillis();
        for(int i = 0; i < arr.length; i++){
            System.out.println(calculate(arr[i]));
        }

        System.out.println(System.currentTimeMillis() - start);
    }

    public static BigInteger calculate(int num){
        BigInteger result = BigInteger.ONE;
        for(int i=2;i<=num;i++){
            result = result.multiply(BigInteger.valueOf(i));
        }

        return result;
    }
}
