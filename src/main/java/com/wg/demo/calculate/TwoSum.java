package com.wg.demo.calculate;

import java.util.HashMap;

/**
 * @author wg
 * @date 2021/1/8
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 3, 4, 5, 6, 7, 8, 9};
        int target = 16;

        int[] indexs = new int[2];

        HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
//        for (int i = 0; i < nums.length; i++) {
//            if(hash.containsKey(nums[i])){
//                indexs[0] = i;
//                indexs[1] = hash.get(nums[i]);
//                System.out.println(indexs[0]);
//            }
//            // 将数据存入 key为补数 ，value为下标
//            hash.put(target-nums[i],i);
//        }

//        for (int i = 0; i < nums.length; i++) {
//            for (int j = nums.length - 1; j > i  ; j--) {
//                if ((nums[i] + nums[j]) == target){
//                    System.out.println(nums[i] + "---" + nums[j]);
//                }
//            }
//        }

        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            int sum = nums[i] + nums[j];
            if (sum == target) {
                System.out.println(nums[i] + "---" + nums[j]);
            } else if (sum < target) {
                i++;
            } else {
                j--;
            }
        }
    }
}