package com.zsn;

import java.util.Scanner;

public class test3 {


    /*public void  found(){
        //如果现在有n个正整数（可能会存在一些重复的数字），
        // 要求从n个数中找出m个数，使得这m个数中任意两个数字之和都是k的整数倍。
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入t的值有多少组数");
        int t=scanner.nextInt();
        int[] arry=new int[3];
        for (int i = 0; i <t ; i++) {
            System.out.println("请输入第"+i+"组数的第一行");
            for (int j=0;j<arry.length;j++){
                arry[j]=scanner.nextInt();
            }
            System.out.println("请输入第"+i+"组数的第二行");
            int[] twoArry=new int [arry[0]];
            for (int j = 0; j <arry[0] ; j++) {
                twoArry[j]=scanner.nextInt();
            }// n m k
            for (int j = 0; j < twoArry.length; j++) {

            }

        }

    }*/
    public static void main(String[] args) {
        found();
    }
    public static void  found(){
//        有一只神奇的青蛙，它最擅长的是跳格子，而且每次它跳的格数都满足2^k（k>=0）。
//现在这只青蛙站在第1个格子里面，它如果想要跳到第N个格子，一共有多少种不同的跳法呢？
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个数");
        int a=scanner.nextInt();
        int count =0;
        for (int i = 1; i <= a; i++) {

        }

    }
}
