package bitwise;

/**
 * @Auther: rqxiao
 * @Date: 2019-7-4 10:19
 * @Description:
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 说明：
 *
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例 1:
 *
 * 输入: [2,2,1]
 * 输出: 1
 * 示例 2:
 *
 * 输入: [4,1,2,1,2]
 * 输出: 4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/single-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SingleNumber_136 {


    public static int singleNumber(int[] nums) {

        int result = 0;

        for (int i = 0; i < nums.length; i++) {
            result = result ^ nums[i];           //两个相同的数进行异或运算结果是0，并且任意数与0进行异或结果还是这个数，所以挨个执行异或运算后，结果就是只出现了一次的元素
        }

        return result;

    }


    public static void main(String[] args) {
        int[] nums = {4, 1, 2, 1,2};
        System.out.println(SingleNumber_136.singleNumber(nums));
    }


}
