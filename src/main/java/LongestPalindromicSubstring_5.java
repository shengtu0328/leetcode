/**
 * @Author: rqxiao
 * @Date: 2020-8-7 17:45
 * @Description: 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * <p>
 * 示例 2：
 * <p>
 * 输入: "cbbd"
 * 输出: "bb"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestPalindromicSubstring_5 {

    static int max = 0;

    static String maxString;

    public String longestPalindrome(String s) {

        maxString = s;
        for (int i = 0; i < s.length(); i++) {
            findThisCharLongestPalindrome(i, s);

        }
        return maxString;
    }

    /**
     * 找出以当前这个下标为中心扩算的起点的能满足的最大长度的回文串
     */
    public void findThisCharLongestPalindrome(int index, String s) {

        int startBefore1 = index - 1;
        int startAfter1 = index + 1;

        int startBefore2 = index;
        int startAfter2 = index + 1;


        //情况1： abcbc
        while (startBefore1 > 0 && startAfter1 < s.length()) {

            String substring = s.substring(startBefore1, startAfter1 + 1);
            boolean b1 = ifPalindrome(substring);
            if (b1) {
                if (startAfter1 - startBefore1 + 1 > max) {
                    max = startAfter1 - startBefore1 + 1;
                    maxString = substring;

                }
                startBefore1--;
                startAfter1++;
            } else {
                break;
            }
        }
        //情况2：abbc
        while (startBefore2 > 0 && startAfter2 < s.length()) {
            String substring = s.substring(startBefore2, startAfter2 + 1);
            boolean b2 = ifPalindrome(substring);
            if (b2) {
                if (startAfter2 - startBefore2 + 1 > max) {
                    max = startAfter2 - startBefore2 + 1;
                    maxString = substring;
                }
                startBefore2--;
                startAfter2++;
            } else {
                break;
            }
        }

    }


    /**
     * 判断是否是回文串
     */
    //abcbc
    //01234
    //abbc
    //0123
    public boolean ifPalindrome(String s) {

        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            } else {
                start++;
                end--;
            }
        }
        return true;
    }


    public static void main(String[] args) {


        String s = "cbbd";

        LongestPalindromicSubstring_5 longestPalindrome_409 = new LongestPalindromicSubstring_5();

        System.out.println(longestPalindrome_409.longestPalindrome(s));


    }


}
