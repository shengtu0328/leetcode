package binarysearch;

/**
 * @Author: rqxiao
 * @Date: 2020-7-22 16:18
 * @Description: --------
 * [6,7,8,9,1,2,3,4,5]
 * [4,5,6,7,8,9,0,1,2]
 * [8,9,1,2,3,4,5,6,7],
 *
 *
 *
假设按照升序排序的数组在预先未知的某个点上进行了旋转。

( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。

请找出其中最小的元素。

你可以假设数组中不存在重复元素。

示例 1:

输入: [3,4,5,1,2]
输出: 1
示例 2:

输入: [4,5,6,7,0,1,2]
输出: 0
 */
public class FindMinimumInRotatedSortedArray_153 {


    public static int findMin(int[] nums) {

        int start = 0;
        int end = nums.length - 1;

        int mid = (start + end) / 2;


        while (!(nums[mid - 1] > nums[mid]
                &&
                nums[mid] < nums[mid + 1])
        ) {

            if (nums[mid] < nums[end]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
            mid = (start + end) / 2;
        }


        return nums[mid];
    }


    public static void main(String[] args) {


        System.out.println(FindMinimumInRotatedSortedArray_153.findMin(new int[]{4, 5, 6, 7, 8, 9, 0, 1, 2}));
        System.out.println(FindMinimumInRotatedSortedArray_153.findMin(new int[]{8, 9, 1, 2, 3, 4, 5, 6, 7}));
        System.out.println(FindMinimumInRotatedSortedArray_153.findMin(new int[]{6, 7, 8, 9, 1, 2, 3, 4, 5}));


    }

}
