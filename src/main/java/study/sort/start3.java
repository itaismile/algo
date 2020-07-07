package study.sort;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 存在重复元素 II
 * @author: Xdp
 * @time: 2020/7/7
 */
public class start3 {


    public static void main(String[] args) {
        int[] nums1 = new int[]{1,0,1,1};
        boolean b = containsNearbyDuplicate(nums1,1);
        System.out.println(b);
    }

    /**
     *
     *
     * @description: 219. 存在重复元素 II
     *
     * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的 绝对值 至多为 k。
     *
     * @author: xiedp
     * @time: 2020/7/7
     * @return:
     */
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])){
                if(i-map.get(nums[i])<=k){
                    return true;
                }
            }
             map.put(nums[i],i);
        }
        return false;
    }

}
