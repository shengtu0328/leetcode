import java.util.HashMap;

/**
 * @Auther: rqxiao
 * @Date: 2019-6-14 09:59
 * @Description:
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TwoSum_1 {

    /*
     *脑瘫做法 时间复杂度O(n^2)
     */
    public int[] twoSum1(int[] nums, int target) {
        int[] result=new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j <nums.length ; j++) {
                if(nums[i]+nums[j]==target){
                    result[0]= i;
                    result[1]= j;
                }
            }
        }
        return result;
    }


    /*两遍哈希表
     *
     *利用hashmap存储数组，map.containsKey方法时间复杂度是O(1)，所以总体的时间复杂度是O(n)
     *通过以空间换取速度的方式，我们可以将查找时间从 O(n) 降低到 O(1)。哈希表正是为此目的而构建的，它支持以 近似 恒定的时间进行快速查找。我用“近似”来描述，是因为一旦出现冲突，查找用时可能会退化到 O(n)。但只要你仔细地挑选哈希函数，在哈希表中进行查找的用时应当被摊销为 O(1)。
     *至于hashmap查找一个元素为什么是O(1)，接近O(1),或者map.containsKey方法为什么要这么写(n - 1) & hash 可以参考https://blog.csdn.net/a2615381/article/details/78151061
     */
    public int[] twoSum2(int[] nums, int target) {
        int[] result=new int[2];

        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        for (int i = 0; i <nums.length ; i++) {
            map.put(nums[i],i);
        }

        for (int i = 0; i < nums.length; i++) {
            int element=target-nums[i];
            if(map.containsKey(element)){
                result[0]= i;
                result[1]= map.get(element);
            }
        }
        return result;
    }

    /*
     *一遍哈希表
     */
    public int[] twoSum3(int[] nums, int target) {
        int[] result=new int[2];
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        for (int i = 0; i <nums.length ; i++) {
            int element=target-nums[i];
            if(map.containsKey(element)){
                result[0]= i;
                result[1]= map.get(element);
            }
            map.put(nums[i],i);
        }
        return result;
    }


    public static void main(String[] args) {
        int[ ] nums={2, 7, 11, 15};
        int target=9;
        TwoSum_1 twoSum_1=new TwoSum_1();
        int[] result = twoSum_1.twoSum3(nums, 9);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
