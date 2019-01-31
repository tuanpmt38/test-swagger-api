package com.example.springapitest.test;

public class ThreadSimple2 implements Runnable {

    @Override
    public void run() {

        System.out.println("Thread running ... !");
    }

    public static void main(String[] args) {
        ThreadSimple2 ts2 = new ThreadSimple2();
        Thread tr1 = new Thread(ts2);
        tr1.start();
    }
}
