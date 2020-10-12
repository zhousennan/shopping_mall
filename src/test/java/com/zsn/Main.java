package com.zsn;

import java.util.HashSet;
import java.util.PriorityQueue;

public class Main implements Runnable{

    public static void main(String[] args) throws InterruptedException {
       Thread thread  = new Thread(new Main());
       thread.start();
        System.out.printf("%d",1);
        thread.join();
        System.out.printf("%d",2);
    }

    @Override
    public void run() {
        System.out.printf("%d",3);
    }
}

