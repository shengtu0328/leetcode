package find_common_characters_1002;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。例如，如果一个字符在每个字符串中出现 3 次，但不是 4 次，则需要在最终答案中包含该字符 3 次。
 * <p>
 * 你可以按任意顺序返回答案。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：["bella","label","roller"]
 * 输出：["e","l","l"]
 * 示例 2：
 * <p>
 * 输入：["cool","lock","cook"]
 * 输出：["c","o"]
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length <= 100
 * 1 <= A[i].length <= 100
 * A[i][j] 是小写字母
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-common-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {


    public List<String> commonChars(String[] A) {

        List<String> list = new ArrayList<String>();
        HashMap<Character, Integer> resultMap = getAllCharsMap(1);


        for (String s : A) {

            HashMap<Character, Integer> tempMap = getAllCharsMap(2);
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                tempMap.put(c, tempMap.get(c) + 1);
            }

            for (Map.Entry<Character, Integer> entry : resultMap.entrySet()) {
                resultMap.put(entry.getKey(), Math.min(entry.getValue(), tempMap.get(entry.getKey())));
            }
        }
        for (Map.Entry<Character, Integer> entry : resultMap.entrySet()) {

            for (Integer i = 0; i < entry.getValue(); i++) {
                list.add(String.valueOf(entry.getKey()));
            }

        }
        return list;
    }


    public HashMap<Character, Integer> getAllCharsMap(Integer flag) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 1; i <= 26; i++) {
            if (flag == 1) {
                map.put((char) (96 + i), Integer.MAX_VALUE);
            } else if (flag == 2) {
                map.put((char) (96 + i), 0);
            }
        }
        return map;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> list = solution.commonChars(new String[]{"bella", "label", "roller"});
        System.out.println(list);
    }
}
