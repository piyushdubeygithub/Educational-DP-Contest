package dsalgo.array;

import java.util.Arrays;

/**
 * Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
 *
 * There is only one repeated number in nums, return this repeated number.
 *
 * Input: nums = [1,3,4,2,2]
 * Output: 2
 * */
public class FindDuplicates {
    public static void main(String[] args) {
        int[] nums = {1,3,4,2,2};
        Arrays.sort(nums);
        for(int i=1;i<nums.length;i++){
            if(nums[i] == nums[i-1]){
                System.out.println(nums[i]);
            }
        }
    }
}
