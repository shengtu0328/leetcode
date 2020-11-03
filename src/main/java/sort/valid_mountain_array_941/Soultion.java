package sort.valid_mountain_array_941;

/**
 * @author ：rqxiao
 * @description：TODO
 * @date ：2020/11/3 14:22
 * 给定一个整数数组 A，如果它是有效的山脉数组就返回 true，否则返回 false。
 * <p>
 * 让我们回顾一下，如果 A 满足下述条件，那么它是一个山脉数组：
 * <p>
 * A.length >= 3
 * 在 0 < i < A.length - 1 条件下，存在 i 使得：
 * A[0] < A[1] < ... A[i-1] < A[i]
 * A[i] > A[i+1] > ... > A[A.length - 1]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-mountain-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Soultion {


    public boolean validMountainArray(int[] A) {

        int i = 0;
        int lastIndex = A.length - 1;

        while (i < lastIndex && A[i + 1] > A[i]) {
            i++;
        }


        if (i == 0 || i == lastIndex) {
            return false;
        }


        while (i < lastIndex && A[i] > A[i + 1]) {
            i++;
        }

        return i == lastIndex;
    }


    public static void main(String[] args) {
        Soultion soultion = new Soultion();
        soultion.validMountainArray(new int[]{3, 5, 5});
    }

}
