package com.company;

public class ThreadRunnable {

    public static void main(String[]args){
        MyThread o = new MyThread();
        Thread thread = new Thread(o);
        thread.start();
        o.calculate();
        System.out.println("I am in thread : " + Thread.currentThread().getName());
    }

    private static class MyThread implements Runnable{

        @Override
        public void run() {
            System.out.println("I am in thread : " + Thread.currentThread().getName());
            calculate();
        }

        public void calculate(){

            int sum = 0;
            for(int i=1;i<=100;i++){
                sum += i;
            }
            System.out.println(sum);
        }
    }
}
