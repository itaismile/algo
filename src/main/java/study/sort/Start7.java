package study.sort;

/**
 * @description: 724. 寻找数组的中心索引
 *
 * 给定一个整数类型的数组 nums，请编写一个能够返回数组 “中心索引” 的方法。
 *
 * 我们是这样定义数组 中心索引 的：数组中心索引的左侧所有元素相加的和等于右侧所有元素相加的和。
 *
 * 如果数组不存在中心索引，那么我们应该返回 -1。如果数组有多个中心索引，那么我们应该返回最靠近左边的那一个。
 *
 * @author: Xdp
 * @time: 2020/7/13
 */
public class Start7 {


    public static void main(String[] args) {
        int[] nums1 = new int[]{-1,7,3,2,1,3};
        int i = pivotIndex(nums1);
        System.out.println(i);
    }


    /**
     *
     *
     * @description: 寻找数组的中心索引
     *
     *  理解中心索引，左边元素之和 = 右边元素之和
     *  leftSum + rightSum + num[i] = sum
     *  即 2 * leftSum = sum - num[i]
     *
     * @author: xiedp
     * @time: 2020/7/13
     * @return:
     */
    public static  int pivotIndex(int[] nums) {
        int sum = 0;
        int leftSum = 0;
        for (int num : nums) {
            sum += num;
        }
        for (int i = 0; i < nums.length; i++) {
            if(2 * leftSum == sum - nums[i]){
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }

}
