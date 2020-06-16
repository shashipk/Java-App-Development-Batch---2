package com.company;

public class Main {

    // First way of creating thread by extending java.lang Thread class

    public static void main(String[] args) throws InterruptedException {
        MyThread thread = new MyThread();

        thread.setDaemon(true);
        thread.start();
        Thread.sleep(3000);

//        thread.calculate();
//        System.out.println("I am in thread : " + Thread.currentThread().getName());
    }

    private static class MyThread extends Thread {

        @Override
        public void run() {
            System.out.println("I am in thread : " + currentThread().getName());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("I am in thread : " + currentThread().getName());

//            calculate();
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
