import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class hashTable_offer50 {
/*
剑指 Offer 50. 第一个只出现一次的字符

在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。

示例:
s = "abaccdeff"
返回 "b"
s = ""
返回 " "
 

限制：
0 <= s 的长度 <= 50000

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/
    public static char firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        Set isRepeat = new HashSet();
        ArrayList<Character> rets = new ArrayList<>();
        for(Character c : chars){
            System.out.println(c);
            if(isRepeat.add(c)){
                rets.add(c);
            }else {
                if(rets.contains(c)){
                rets.remove(c);
                }
            }
        }
        if(rets.isEmpty()){
            return ' ';
        }else {
            char ret = rets.get(0);
            return ret;
        }
    }

    public static char firstUniqChar2(String s) {
        if (s.equals("")) return ' ';
        //创建‘a'-'z'的字典
        int[] target = new int[26];
        //第一次遍历，将字符统计到字典数组
        for (int i = 0; i < s.length(); i++) {
            target[s.charAt(i) - 'a']++;
        }
        //第二次遍历，从字典数组获取次数
        for (int i = 0; i < s.length(); i++) {
            if (target[s.charAt(i) - 'a'] == 1) return s.charAt(i);
        }

        return ' ';
    }

        public static void main(String[] args) {
        String str = "aadadaads";
        char a = firstUniqChar2(str);
        System.out.println("result: " + a);
        // write your code here
    }
}
/*
python:
class Solution:
    def firstUniqChar(self, s: str) -> str:
        if s == "":
            return " "
        for i in range(0, len(s)):
            if s.count(s[i]) == 1:  //str.count()可以统计单个/多个字符
                return s[i]
        return " "
字典法：
class Solution(object):
    def firstUniqChar(self, s):
        """
        :type s: str
        :rtype: str
        """
        dct = {}
        for c in s:
            if c not in dct:
                dct[c] = 1
            else:
                dct[c] += 1
        for c in s:
            if dct[c] == 1:
                return c
        return " "
 */