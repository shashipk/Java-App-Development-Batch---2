package com.company;

import java.math.BigInteger;

public class MultiThreadedFactorial {

    public static void main(String[]args) throws InterruptedException {

        long start = System.currentTimeMillis();
        int[]arr = {10000, 20000, 30000, 12000, 50000, 15000, 40000, 19000, 17000, 26000, 14000};

        MyThread[]thread = new MyThread[arr.length];
        for(int i=0;i<thread.length;i++){
            thread[i] = new MyThread(arr[i]);
            thread[i].start();
        }

        // t1 -> 4s, t2 -> 3s, t3 -> 1s, t4 -> 2s

        for(int i=0;i<thread.length;i++){
            thread[i].join();
        }

        for(int i=0;i<thread.length;i++){
            System.out.println(thread[i].result);
        }
        System.out.println(System.currentTimeMillis() - start);
    }

    private static class MyThread extends Thread{

        private int num;
        private BigInteger result;

        public MyThread(int num) {
            this.num = num;
            this.result = BigInteger.ONE;
        }

        @Override
        public void run() {
            calculateFac();
        }

        public void calculateFac(){

            for(int i=2; i <= this.num; i++){
                this.result = this.result.multiply(BigInteger.valueOf(i));
            }
        }
    }
}
