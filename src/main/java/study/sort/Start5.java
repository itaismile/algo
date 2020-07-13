package study.sort;

/**
 * @description: 209. 长度最小的子数组
 *
 *  给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的子数组，并返回其长度。如果不存在符合条件的子数组，返回 0。
 *
 * @author: Xdp
 * @time: 2020/7/9
 */
public class Start5 {


    public static void main(String[] args) {
        int[] nums1 = new int[]{1,0,1,1};
        int min = minSubArrayLen(4,nums1);
        System.out.println(min);
    }

    /**
     *
     *
     * @description: 209. 长度最小的子数组
     *
     * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的子数组，并返回其长度。如果不存在符合条件的子数组，返回 0。
     *
     * 暴力破解 循环累加 得到是否满足需求的值
     *
     * @author: xiedp
     * @time: 2020/7/9
     * @return:
     */
    public static int minSubArrayLen(int s, int[] nums) {
        if (nums.length < 1){
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length-1; i++) {
            int sum = nums[i];
            if (sum >= s){
                return 1;
            }
            for (int j = i + 1; j < nums.length&& i!=j; j++) {
                sum += nums[j];
                if (sum >= s){
                    min = Math.min(min,j-i+1);
                        break;
                }
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }


}
