package string.partition_labels_763;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author ：rqxiao
 * @description：TODO
 * @date ：2020/10/23 16:50
 * 763. 划分字母区间
 * 字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。返回一个表示每个字符串片段的长度的列表。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：S = "ababcbacadefegdehijhklij"
 * 输出：[9,7,8]
 * 解释：
 * 划分结果为 "ababcbaca", "defegde", "hijhklij"。
 * 每个字母最多出现在一个片段中。
 * 像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
 */
public class Solution {


    public List<Integer> partitionLabels(String S) {
        List<Integer> list = new ArrayList<>();

        HashMap<Character, Integer> map = new HashMap<>();
        int length = S.length();
        for (int i = 0; i < length; i++) {
            map.put(S.charAt(i), i);
        }

        int maxIndex = 0;
        int lastIndex = 0;
        for (int i = 0; i < length; i++) {
            Integer nowIndex = map.get(S.charAt(i));
            maxIndex = Math.max(nowIndex, maxIndex);
            if (i == maxIndex) {
                list.add(maxIndex - lastIndex + 1);
                lastIndex = maxIndex + 1;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        String S = "ababcbacadefegdehijhklij";
        Solution solution = new Solution();
        List<Integer> list = solution.partitionLabels(S);
    }
}
