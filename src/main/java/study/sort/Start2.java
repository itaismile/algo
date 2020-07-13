package study.sort;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 1、存在重复元素 2、只出现一次的数字
 * @author: Xdp
 * @time: 2020/7/6
 */
public class Start2 {


    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,1,2,6};
        int i = singleNumber(nums1);
        Boolean b = containsDuplicate(nums1);
        System.out.println(b);
    }

    /**
     *
     *
     * @description: 217. 存在重复元素
     *  给定一个整数数组，判断是否存在重复元素。
     *
     * 如果任意一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
     * @author: xiedp
     * @time: 2020/7/6
     * @return:
     */
    public static  Boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])){
               return true;
            }else{
                map.put(nums[i],1);
            }
        }
        return false;
    }

    /**
     *
     *
     * @description: 136. 只出现一次的数字
     *  给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
     *  说明：
     * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
     * @author: xiedp
     * @time: 2020/7/6
     * @return:
     */
    public static  int singleNumber(int[] nums) {
        Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(nums[i])){
                int m = hashMap.get(nums[i]);
                hashMap.put(nums[i],m+1);
            }else{
                hashMap.put(nums[i],1);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.get(nums[i]) == 1){
                return nums[i];
            }
        }
        return -1;
    }

    /**
     *
     * @description: 136. 只出现一次的数字
     *     用异或思想解决
     * 既满足时间复杂度又满足空间复杂度，就要提到位运算中的异或运算 XOR，主要因为异或运算有以下几个特点：
     * 一个数和 0 做 XOR 运算等于本身：a^0 = a
     * 一个数和其本身做 XOR 运算等于 0：a^a = 0
     * XOR 运算满足交换律和结合律：a^b^a = (a^a)^b = 0^b = b
     *
     * @author: xiedp
     * @time: 2020/7/6
     * @return:
     */
    public static  int singleNumber2(int[] nums) {
        int ans = nums[0];
        if (nums.length > 1) {
            for (int i = 1; i < nums.length; i++) {
                ans = ans ^ nums[i];
            }
        }
        return ans;
    }
}
