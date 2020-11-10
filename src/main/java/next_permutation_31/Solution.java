package next_permutation_31;

/**
 * @author ：rqxiao
 * @description：TODO
 * @date ：2020/11/10 15:36
 * <p>
 * 31. 下一个排列
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 * <p>
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 * <p>
 * 必须原地修改，只允许使用额外常数空间。
 * <p>
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 */
public class Solution {


    /**
     * 想要找出下一个排列的解决入口 既首先要找到这个排列中从后往前找到第一个  “相邻升序对“” （即有升序关系 的两个位置，左边的数a比右边b的小）
     * 然后从右边开始找第一个比 这个a大的数（因为这时候 b后面从左到右都是降序 所以从右找第一个比a大的既是所需要的数，并且和a互换位置）
     * 而且这时候后面部分必定是全降序排列，所以进行一次对这部分数据进行一次逆置操作即可
     */
    public void nextPermutation(int[] nums) {

        int length = nums.length;

        int i = length - 1 - 1;


        while (i >= 0 && nums[i] > nums[i + 1]) {
            i--;
        }

        if(i<=0){
            reverse(nums,0);
            return;
        }

        int small = nums[i];

        int big = nums[i + 1];


        int j = length - 1;

        while (nums[j] <=small) {
            j--;
        }

        nums[i] = nums[j];

        nums[j] = small;

        reverse(nums,i+1);

    }

    public void reverse(int[] nums,int startIndex){
        int endIndex = nums.length - 1;
        while(startIndex<endIndex){
            int start = nums[startIndex];
            nums[startIndex]= nums[endIndex];
            nums[endIndex]=start;
            startIndex++;
            endIndex--;
        }
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{1, 2, 3, 8, 5, 7, 6, 4};
//        int[] nums = new int[]{3,2,1};
//        int[] nums = new int[]{1,5,1};
//        int[] nums = new int[]{1,1};
        int[] nums = new int[]{1,3,2};


        Solution solution = new Solution();
        solution.nextPermutation(nums);
    }

}
