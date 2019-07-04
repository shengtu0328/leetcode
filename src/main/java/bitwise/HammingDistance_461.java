package bitwise;

/**
 * @Auther: rqxiao
 * @Date: 2019-7-1 15:51
 * @Description:
 * 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
 *
 * 给出两个整数 x 和 y，计算它们之间的汉明距离。
 *
 * 注意：
 * 0 ≤ x, y < 231.
 *
 * 示例:
 *
 * 输入: x = 1, y = 4
 *
 * 输出: 2
 *
 * 解释:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 *        ↑   ↑
 *
 * 上面的箭头指出了对应二进制位不同的位置。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/hamming-distance
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class HammingDistance_461 {

    public static int hammingDistance(int x, int y) {
        int i = x ^ y;  //先异或  相同0 不同1
        int result=0;

         while (i!=0){             //一直右移到最后会变成0

             if((i&1)==1){        //和1也就是 0000 0001 做与运算，就可以判断次位数是否是1
                 result++;
             }
             i=i>>1;
        }


        return result;
    }


    public static void main(String[] args) {
//        4   100
//        3   011
//     4 ^ 3  111
//        6   110
//        5   101
        //        6 ^ 5  100

        System.out.println(HammingDistance_461.hammingDistance(4, 3));

//        System.out.println(Integer.toBinaryString(4 ^ 3).replaceAll("0", "").length());
//        System.out.println(Integer.toBinaryString(4 ^ 3));


    }
}
