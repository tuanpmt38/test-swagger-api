package com.example.springapitest.test;

public class exampleEqualDemo1 {
    public static void main(String[] args) {
        String s1 = new String ("This is a string");
        String s2 = new String ("This is a string");

        System.out.println("s1 == s2 " + (s1 == s2));

        System.out.println(" s1 equals s2 " + (s1.equals(s2)));
    }
}
