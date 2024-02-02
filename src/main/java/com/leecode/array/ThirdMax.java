package com.leecode.array;


import java.util.Arrays;
import java.util.HashSet;

/**
 * 414. 第三大的数
 * 给你一个非空数组，返回此数组中 第三大的数 。如果不存在，则返回数组中最大的数
 * 进阶：你能设计一个时间复杂度 O(n) 的解决方案吗？
 * <br/><a href="https://leetcode.cn/problems/third-maximum-number/description/">leeCode题目描述</a>
 */
public class ThirdMax {

    public static void main(String[] args) {
        System.out.println(thirdMaxSort(new int[]{2,2,3,1}));
        System.out.println(thirdMax(new int[]{2,2,3,1}));
    }

    /**
     * 排序法
     * 时间复杂度：O(nlogn)，其中 n 是数组 nums 的长度。排序需要 O(nlogn) 的时间。
     * 空间复杂度：O(logn)。排序需要的栈空间为 O(logn)。
     * @param nums
     * @return
     */
    public static int thirdMaxSort(int[] nums) {
        Arrays.sort(nums);
        if(nums.length < 3){
            return nums[nums.length-1];
        }
        HashSet<Integer> hashSet = new HashSet<Integer>();
        for (int i = nums.length - 1; i >= 0; i--) {
            hashSet.add(nums[i]);
            if(hashSet.size() == 3){
                return nums[i];
            }
        }
        return nums[nums.length-1];
    }

    /**
     * 遍历法<br/>
     * 时间复杂度：O(n)，其中 n 是数组 nums 的长度<br/>
     * 空间复杂度：O(1)。<br/>
     * @param nums
     * @return
     */
    public static int thirdMax(int[] nums) {
        Integer a = null, b = null, c = null;
        for (int num : nums) {
            if (a == null || num > a) {
                c = b;
                b = a;
                a = num;
            } else if (a > num && (b == null || num > b)) {
                c = b;
                b = num;
            } else if (b != null && b > num && (c == null || num > c)) {
                c = num;
            }
        }
        return c == null ? a : c;
    }
}
