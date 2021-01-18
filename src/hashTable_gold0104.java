import java.util.HashSet;
import java.util.Set;

/*
面试题 01.04. 回文排列

给定一个字符串，编写一个函数判定其是否为某个回文串的排列之一。
回文串是指正反两个方向都一样的单词或短语。排列是指字母的重新排列。
回文串不一定是字典当中的单词。

示例1：
输入："tactcoa"
输出：true（排列有"tacocat"、"atcocta"，等等

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/palindrome-permutation-lcci
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class hashTable_gold0104 {
    public static boolean canPermutePalindrome(String s) {
        if(s.length()==0)
            return false;
        int[] nums = new int[256];
        int singleNum = 0;
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            nums[c]++;
        }
        for(int i=0; i<nums.length; i++){
            if(nums[i]%2==1)
                singleNum++;
            System.out.println((char)(i+'a') + ": " + nums[i]);
        }
        if(singleNum>1)
            return false;
        return true;
    }
    public boolean canPermutePalindrome2(String s) {
        if(s == null){
            return false;
        }
        char[] chars = s.toCharArray();
        Set<Character> set = new HashSet<>();
        for(char c : chars){
            if(set.contains(c)){
                set.remove(c);
            }else{
                set.add(c);
            }
        }
        return set.size() <= 1;
    }
    public static void main(String[] args) {
        String str = "";
        boolean res = canPermutePalindrome(str);
        System.out.println("result: " + res);
        // write your code here
    }
}
/*
python:
class Solution(object):
    def canPermutePalindrome(self, s):
        """
        :type s: str
        :rtype: bool
        """
        odd = {}

        for ch in s:
            if ch in odd.keys():
                del odd[ch]
            else:
                odd[ch] = 0
        if len(odd.keys()) > 1:
            return False
        else:
            return True
 */
