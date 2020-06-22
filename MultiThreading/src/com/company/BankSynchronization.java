package com.company;

public class BankSynchronization {

    public static void main(String[] args) throws InterruptedException {

        BankObject obj1 = new BankObject(1, 100);

        BankObject obj2 = new BankObject(2, 300);

        Factorial fact_obj = new Factorial();

        MyThread[] threads = new MyThread[6];

        long start = System.currentTimeMillis();

        threads[0] = new MyThread(obj1, true, 50, null);
        threads[1] = new MyThread(obj1, false, 100, null);
        threads[2] = new MyThread(obj1, true, 250, null);

        // 300 fr obj 1


        threads[3] = new MyThread(obj2, false, 100, null);
        threads[4] = new MyThread(obj2, true, 300, null);
        threads[5] = new MyThread(obj2, false, 150, null);

        // 350 for obj 2

        MyThread thread = new MyThread(null, false, 300, fact_obj);

        thread.start();


        for(int i=0;i<=5;i++){
            threads[i].start();
        }

        for(int i=0;i<6;i++){
            threads[i].join();
        }

        System.out.println("Balance of account 1: " + obj1.getBalance() + ", balance of account 2: " + obj2.getBalance());

        System.out.println("time taken to execute : " +(System.currentTimeMillis() - start));

    }

    private static class MyThread extends Thread{

        private BankObject obj;
        private Factorial factorial;
        private boolean isDeposit;
        private int amount;

        public MyThread(BankObject obj, boolean isDeposit, int amount, Factorial obj2) {
            this.obj = (BankObject) obj;
            this.isDeposit = isDeposit;
            this.amount = amount;
            this.factorial = obj2;
        }

        @Override
        public void run() {
            if(this.isDeposit){
                try {
                    deposit();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else{
                try {
                    withdraw();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public void deposit() throws InterruptedException {
            synchronized (BankObject.class) {
                System.out.println("In deposit function : obj is " + this.obj + ", thread = " + currentThread().getName());
                Thread.sleep(3000);
                int balance = this.obj.getBalance();
                this.obj.setBalance(balance + this.amount);
            }
        }

        public void withdraw() throws InterruptedException {
            synchronized (BankObject.class) {
                System.out.println("In withdraw function : obj is " + this.obj + ", fact obj = " + this.factorial + ", thread = " + currentThread().getName());
                Thread.sleep(3000);
                if (obj != null) {
                    int balance = this.obj.getBalance();
                    this.obj.setBalance(balance - this.amount);
                }
            }
        }
    }
}
