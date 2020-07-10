package study.sort;

/**
 * @description: 665. 非递减数列
 *
 * 给你一个长度为 n 的整数数组，请你判断在 最多 改变 1 个元素的情况下，该数组能否变成一个非递减数列。
 *
 * 我们是这样定义一个非递减数列的： 对于数组中所有的 i (0 <= i <= n-2)，总满足 nums[i] <= nums[i + 1]。
 *
 * @author: Xdp
 * @time: 2020/7/10
 */
public class start6 {


    public static void main(String[] args) {
        int[] nums1 = new int[]{3 ,4,2,3};
        boolean b = checkPossibility(nums1);
        System.out.println(b);
    }

    /**
     *
     *
     * @description: 665. 非递减数列
     *
     * @author: xiedp
     * @time: 2020/7/10
     * @return:
     */
    public static boolean checkPossibility(int[] nums) {
        // 数组长度少于3 为非递减数列
        if(nums.length < 3){
           return true;
        }
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i+1]) {
                count++;
                if (count > 1){
                    return  false;
                }
                // 理解非递减数列
                // a b c
                // a>b
                // 假如 a > c    a c 的值处于递减  故改变 c 的值  a b b 为非递减数列
                // 假如 a <= c   a c 的值非递减  不需要处理 只需要记录 count 次数
                if(i >= 1 && nums[i-1] > nums[i+1]){
                    nums[i+1] = nums[i];
                }
            }

        }
        return  true;
    }


}
