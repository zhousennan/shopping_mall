package com.zsn;

import java.lang.reflect.Method;

public class Person {
//    String name;
//    public Person(String name) {
//        this.name = name;
//    }


    /*public static void found(int[] nums){

        int minPosition = 0;

        for (int i = 0; i < nums.length; i++) {
            minPosition=i;
            for (int j = i+1; j <nums.length ; j++) {
                if (nums[j]<nums[minPosition]){
                    minPosition=j;
                    int b=nums[minPosition];
                    nums[minPosition]=nums[i];
                    nums[i]=b;
                }
            }
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

*/
    public static Person person1=new Person();
    public static Person person2=new Person();
    {
        Boolean i=null;
        System.out.println("构造快");
    }
    static
    {
        System.out.println("静态快");
    }

    public static void main(String[] args) throws Exception{
//        Class<?> classType = Class.forName("java.lang.String");
//        Method[] methods = classType.getDeclaredMethods();
//        for (Method method : methods) {
//            System.out.println(method);
//        }
        Person person = new Person();



    }



}
