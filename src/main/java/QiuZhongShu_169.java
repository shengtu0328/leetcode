/**
 * @Auther: rqxiao
 * @Date: 2019-7-4 11:18
 * @Description:
 *
 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在众数。
 *
 * 示例 1:
 *
 * 输入: [3,2,3]
 * 输出: 3
 * 示例 2:
 *
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/majority-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class QiuZhongShu_169 {


    //解法一 放入hashmap

    //解法二 二次循环，记录每种数字的个数（实属脑瘫做法）

    //解法三 摩尔投票
    //此题的意思可以抽象成，每种数字可以代表一个国家，单种数字出现的个数代表着各个国家的兵力,且每一国的单兵战斗力都相同(即 一个2 和一个1 的战斗力是相同的)
    //因此可分为干个小国，和一个大国(大国的兵力最强大 并超过其他国总和 )
    //想要得到谁是大国这个答案，可以让众国进行火拼(任意两个国家的单个兵力火拼会湮灭)，火拼结束后，必定只会留下大国的兵力
    public static int majorityElement(int[] nums) {

        int numsi = nums[0];

        int count=1;

        for (int i = 1; i < nums.length; i++) {
             if(count==0){
                 numsi=nums[i];

             }
             if(nums[i]!=numsi){

                 count--;
             }
             else {
                 count++;
             }

        }
        return numsi;
    }





    public static void main(String[] args) {

        int[] nums={2,2,1,1,1,2,2};
        System.out.println(QiuZhongShu_169.majorityElement(nums));
    }

}
