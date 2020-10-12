package com.zsn;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Scanner;
import java.util.concurrent.locks.LockSupport;

public class test {
      /*static Thread a;
      static  Thread b;

    public static void main(String[] args) {
        a= new Thread(new Runnable(){
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    LockSupport.park();
                    System.out.println("b");
                    LockSupport.unpark(b);
                }
            }
        });
        b= new Thread(new Runnable(){
            @Override
            public void run(){
                for (int i = 0; i <10 ; i++) {
                    System.out.println("a");
                    LockSupport.unpark(a);
                    LockSupport.park();
                }
            };
        });
        a.start();
        b.start();
    }*/
   public static void main(String arg[]) {
       String s="abcdefg";
       System.out.println(s.substring(1,2));
      /* Scanner scanner =new Scanner (System.in);
       int N= scanner.nextInt();
       String[] strings=new String[N];
       for (int i = 0; i <N ; i++) {
           strings[i] =scanner.next();
       }
       for (String s:strings){
           System.out.println(indexString(s,strings));
       }*/
    }

    private static String indexString(String s, String[] ss) {
            String prefix = s.substring(0,1);
        for (String s1: ss) {
            if (s1.equals(s))
                continue;
            while (s1.indexOf(prefix)==0&&prefix.length()<s.length())
                prefix = s.substring(0,prefix.length()+1);
        }
        return prefix;

        }

/*  ● 请使用内部类实现线程设计4个线程，其中两个线程每次对j增加1，另外两个线程对j每次减少1。
    考察点：JAVA线程
    参考回答：*/

    /*private int j;

    public static void main(String args[]) {
        test tt = new test();
        Inc inc = tt.new Inc();
        Dec dec = tt.new Dec();
        for (int i = 0; i < 2; i++) {
            Thread t = new Thread(inc);
            t.start();
            t = new Thread(dec);
            t.start();
        }
    }
    private synchronized void inc() {
        j++;
        System.out.println(Thread.currentThread().getName() + "-inc:" + j);
    }

    private synchronized void dec() {
        j--;
        System.out.println(Thread.currentThread().getName() + "-dec:" + j);
    }

    class Inc implements Runnable {
        public void run() {
            for (int i = 0; i < 100; i++) {
                inc();
            }
        }
    }

    class Dec implements Runnable {
        public void run() {
            for (int i = 0; i < 100; i++) {
                dec();
            }
        }
    }
*/
//    public static void main(String[] args) {
//        int a=876;
//        int b=a/100;
//        int c=(a-b*100)/10;
//        System.out.println("百位是"+a/100);
//        System.out.println("十位是"+c);
//        System.out.println("个位是"+(a-b*100)%10);
//
//    }

 /*   public static void main(String[] args) {
        *//*String a = "ab";
        final String bb = "b";
        String b = "a" + bb;
        System.out.println((a == b));*//*

//        String a = "atrue";
//        String b = "a" + "true";
//        System.out.println((a == b));

       *//* String s1=new String("kvill");
        String s2=s1.intern();
        System.out.println( s1==s1.intern() );*//*


       *//* String s0 = "kvill";
        String s1 = "kvill";
        String s2 = "kv" + "ill";
        System.out.println(s0 == s1);*//*
    }*/
}
