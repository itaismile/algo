package study.sort;

import java.util.TreeSet;

/**
 * @description: 220. 存在重复元素 III
 *
 * 在整数数组 nums 中，是否存在两个下标 i 和 j，使得 nums [i] 和 nums [j] 的差的绝对值小于等于 t ，且满足 i 和 j 的差的绝对值也小于等于 ķ 。
 *
 * 如果存在则返回 true，不存在返回 false。
 * 
 * @author: Xdp
 * @time: 2020/7/8
 */
public class Start4 {


    public static void main(String[] args) {
        int[] nums1 = new int[]{1,5,9,1,5,9};
        boolean b = containsNearbyAlmostDuplicate2(nums1,2, 3);
        System.out.println(b);
    }

    /**
     *
     *
     * @description: 219. 存在重复元素 II
     *
     * 暴力解 报超时
     *
     * @author: xiedp
     * @time: 2020/7/8
     * @return:
     */
    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums.length < 1){
            return false;
        }
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = i + 1; j < nums.length&& i!=j; j++) {
                long abs = Math.abs((long)nums[i] - (long)nums[j]);
                if (abs <= t){
                    if(j-i<=k){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     *
     *
     * @description: 219. 存在重复元素 II
     *
     *  利用 TreeSet ceiling函数 返回大于等于 key 的最小元素，如果不存在，返回空。
     *
     * @author: xiedp
     * @time: 2020/7/8
     * @return:
     */
    public static boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t) {
        int length = nums.length;
        if (length < 1 && k < 0 && t < 0){
            return false;
        }
        TreeSet<Long> set = new TreeSet<Long>();
        // 利用二叉树  查找数据是否存在 nums [i] - t的 数 没有就添加到TreeSet里面
        for (int i = 0; i < length-1; i++) {
            // TreeSet ceiling(key) 函数：返回大于等于 key 的最小元素，如果不存在，返回空
            Long ceiling = set.ceiling((long)nums [i] - (long)t);
            // ∣nums[i]−nums[j]∣<= t
            // 可以分解为   nums[i]−nums[j] <= t  nums[i] - nums[j] >= -t
            // 当 num[j] >= nums[i]+1时 且 num[j]  <= nums [i] + t 时，
            // ceiling就是num[j] ，ceiling在set中找到元素 就返回true
            if(ceiling != null && ceiling <= nums [i] + t){
                return true ;
            }
            set.add((long)nums [i]);
            //滑动窗口  删除条件外的元素
            if (set.size() == k + 1){
                set.remove((long)nums [i-k]);
            }
        }
        return false;
    }


}
