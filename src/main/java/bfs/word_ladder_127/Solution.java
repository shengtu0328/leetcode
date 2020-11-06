package bfs.word_ladder_127;

import java.util.*;

/**
 * @author ：rqxiao
 * @description：TODO
 * @date ：2020/11/5 16:49
 * <p>
 * 127. 单词接龙
 * 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
 * <p>
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 * 说明:
 * <p>
 * 如果不存在这样的转换序列，返回 0。
 * 所有单词具有相同的长度。
 * 所有单词只由小写字母组成。
 * 字典中不存在重复的单词。
 * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 * 示例 1:
 * <p>
 * 输入:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * <p>
 * 输出: 5
 * <p>
 * 解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * 返回它的长度 5。
 * 示例 2:
 * <p>
 * 输入:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * <p>
 * 输出: 0
 * <p>
 * 解释: endWord "cog" 不在字典中，所以无法进行转换。
 */
public class Solution {


    /**
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return 思路：可以通过题目中给的数据构造出图的模型进行一次bfs操作就可以完获得 从 beginWord 到 endWord 的最短转换序列的长度
     * 由题可知  * 每次转换只能改变一个字母。* 转换过程中的中间单词必须是字典中的单词。
     * 有两种办法找到下一层元素
     * 办法一：根据上一层元素 直接对wordList里其他元素判断其是否能只能改变一个字母成为它的下层，但是如果wordList元素很多 ，这样时间复杂度是O(N*单词长度)  题目说过所有单词具有相同的长度。
     * 办法二：根据上一层元素，对上层元素每个位置列举所有小写英文字可能出现的情况，判断其他元素是否满足其中（这一步可以用hashset来实现,hashset本质上是hashmap，hashmap本质上是数组，从hashmap获得元素亦可以看做是O(1)），这样时间复杂度是O(26*单词长度)
     * 每次找到下层元素后长度就加一，找到endWord就结束
     * 如果遇到了已经访问过的元素就不需要再访问了
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        //结果
        int ladderLength = 0;

        //单词长度
        int wordLength = endWord.length();

        //用于判断是否有符合条件的下层元素
        HashSet<String> hashSet = new HashSet<String>(wordList);
        if (!hashSet.contains(endWord) || hashSet.size() == 0) {
            return 0;
        }

        //bfs中最主要的队列
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        //bfs时访问到的元素,访问过一次就不需要再访问
        HashSet<String> visited = new HashSet<String>();
        visited.add(beginWord);

        while (!queue.isEmpty()) {

            int queueSize = queue.size();

            //遍历当前队列中的元素
            for (int j = 0; j < queueSize; j++) {
                String poll = queue.poll();


                //下面两个for就是对上层元素每个位置列举所有小写英文字可能出现的情况，判断其他元素是否满足其中
                for (int i = 0; i < wordLength; i++) {

                    char[] charArray = poll.toCharArray();

                    //保存一下需要需改的字符
                    char originChar = charArray[i];

                    for (char k = 'a'; k <= 'z'; k++) {


                        charArray[i] = k;
                        String nextWord = String.valueOf(charArray);

                        if (hashSet.contains(nextWord)) {
                            if (!visited.contains(nextWord)) {

                                if (nextWord.equals(endWord)) {
                                    return ladderLength + 1 + 1;
                                }

                                queue.add(nextWord);
                                visited.add(nextWord);

                            }
                        }

                    }

                    //恢复字符串
                    charArray[i] = originChar;

                }
            }

            if (queue.size() > 0) {
                ladderLength++;
            } else {
                return 0;
            }
        }

        return ++ladderLength;
    }


    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");


//        String beginWord = "hot";
//        String endWord = "dog";
//        List<String> wordList = new ArrayList<>();
//        wordList.add("hot");
//        wordList.add("dog");


        Solution solution = new Solution();
        System.out.println(solution.ladderLength(beginWord, endWord, wordList));


    }

}
