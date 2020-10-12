package com.zsn;

import java.util.Arrays;

public class test2 {

    public static int firstMissingPositive (int[] nums) {
        // write code here
        for(int i=0;i<nums.length;i++){
            for (int j = 0; j <nums.length ; j++) {
                if (nums[i]>nums[j]){
                   int a= nums[j];
                   nums[j]=nums[i];
                   nums[i]=a;
                }
            }
        }
     //   [1,-1,2,-5,4]  -1 1 2 4 5
        int b=1;
        for (int i = 0; i <nums.length ; i++) {
           b=nums[i];
           if (b+1==nums[i+1] || b+1<0){

           }else
               return b+1;
        }
        return b;
    }

    public static void main(String[] args) {

    }
}
