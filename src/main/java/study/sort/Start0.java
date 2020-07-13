package study.sort;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @description:  189. 旋转数组
 *
 * @author: Xdp
 * @time: 2020/7/7
 */
public class Start0 {


    public static void main(String[] args) {
        int a = 7 % 3 ;
        int[] nums1 = new int[]{1,2,3,4,5,6};
        rotate1(nums1,4);
        for (int i : nums1) {
            System.out.println(i);
        }
    }

    /**
     *
     *
     * @description: 189. 旋转数组
     *
     * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
     *
     * 暴力翻转  每次移动一个
     *
     * @author: xiedp
     * @time: 2020/7/7
     * @return:
     */
    public static void rotate1(int[] nums, int k) {
        int temp , move;
        k %= nums.length;
        for (int i = 0; i < k; i++) {
            move = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                temp = nums[j];
                nums[j] = move;
                move = temp;
            }
        }

    }

    /**
     *
     *
     * @description: 189. 旋转数组
     *
     * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
     *
     * 先把所有数字翻转 在翻转k个数字，最后翻转n-k个数字
     *
     * @author: xiedp
     * @time: 2020/7/7
     * @return:
     */
    public static void rotate2(int[] nums, int k) {
        k %= nums.length;
        //翻转所有数字
        reverse(nums, 0, nums.length - 1);
        //翻转前k个数字后
        reverse(nums, 0, k - 1);
        //反转后 n-k 个数字后
        reverse(nums, k, nums.length-1);
    }

    /**
    * @Description: TODO  旋转数组K次  翻转数组
    * @author: xiedp
    * @date: 2020/7/13
     * @param nums
     * @param start
     * @param end
    * @Return: void
    */
    public static void reverse(int[] nums, int start, int end) {
        while ( start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start ++ ;
            end --;
        }

    }



        /**
         *
         * @description: 219. 存在重复元素 II
         *
         * 利用HashSet 超过k也没有就把i-k之前的元素删除
         *
         * @author: xiedp
         * @time: 2020/7/7
         * @return:
         */
    public static boolean containsNearbyDuplicate2(int[] nums, int k) {
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])){
                return true;
            }
            set.add(nums[i]);
            if(set.size() == k+1){
                set.remove(nums[i-k]);
            }
        }
        return false;
    }

}
