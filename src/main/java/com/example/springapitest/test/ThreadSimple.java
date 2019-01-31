package com.example.springapitest.test;

public class ThreadSimple extends Thread {

    @Override
    public void run() {
        super.run();
        System.out.println("thread running ...!");
    }

    public static void main(String[] args) {
        ThreadSimple ts1 = new ThreadSimple();
        ts1.start();
    }
}
