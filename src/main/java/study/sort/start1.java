package study.sort;

/**
 * @description: 169. 多数元素
 *
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * @author: Xdp
 * @time: 2020/7/4
 */
public class start1 {


    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,3,2,1,1};
        int i = majorityElement(nums1);
        System.out.println(i);
    }


    /**
     *
     *
     * @description: 多数元素
     *  使用的摩尔投票法
     * @author: xiedp
     * @time: 2020/7/4
     * @return:
     */
    public static  int majorityElement(int[] nums) {
        int most = nums[0];
        int mostNum = 1;
        for (int i = 1; i < nums.length; i++) {
            if (most == nums[i]){
                mostNum++;
            }else if(mostNum == 0){
                most = nums[i];
                mostNum = 1;
            }else {
                mostNum--;
            }
        }
        return most;
    }

}
