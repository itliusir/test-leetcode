package com.itliusir.array;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * problem.15
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 *
 * @author liugang
 * @since 2019/7/23
 */

@Slf4j
public class ThreeSum {

    public static void main(String[] args) {
        int[] a = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(a));
    }

    /**
     * method 1
     * <p>
     * 暴力求解
     *
     * @author liugang
     * @date 2019-10-19 16:27:50
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        // 去重
        Arrays.sort(nums);
        Map<String,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        if (map.get(nums[i] + "" + nums[j] + "" + nums[k] + "") == null) {
                            resultList.add(Arrays.asList(nums[i], nums[j], nums[k]));
                        }
                        map.put(nums[i] + "" + nums[j] + "" + nums[k] + "", 1);
                    }
                }
            }

        }
        return resultList;
    }

    public static List<List<Integer>> threeSumTwo(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }
        List<List<Integer>> resultList = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (i > 0 && (nums[i] == nums[i - 1])) {
                continue;
            }
            Map<Integer, Integer> targetMap = new HashMap<>();
            for (int j = i + 1; j < nums.length; j++) {
                if (targetMap.containsKey(nums[j])) {
                    if (targetMap.get(nums[j]) == 0) {
                        resultList.add(Arrays.asList(nums[i], nums[j], -nums[i] - nums[j]));
                        targetMap.put(nums[j], 1);
                    }
                } else {
                    targetMap.put(-nums[i] - nums[j], 0);
                }
            }
        }
        return resultList;
    }
}
