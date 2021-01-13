/*
剑指 Offer 48. 最长不含重复字符的子字符串

请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。

示例 1:
输入: "abcabcbb"
输出: 3
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。

示例 2:
输入: "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。

示例 3:
输入: "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 
提示：
s.length <= 40000

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class hashTable_twoPoint_offer48 {
    public static int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        int l = 0;
        int r = 0;
        int cLen = s.length();
        int[] dic = new int[256];
        if(s==null || s.length()==0)
            return 0;
        while(l<=r && l<cLen){
            while(r<cLen && dic[s.charAt(r)]==0){
                dic[s.charAt(r)] = 1;
                r++;
            }
            maxLen = Math.max(maxLen, r-l);
            dic[s.charAt(l)] = 0;  //当左指针指向前面的重复元素时，将字典中对应的字符出现次数置零，这样右指针就可以继续往前走了
            l++;
        }
        return maxLen;
    }
    public static void main(String[] args) {
        String str = "";
        int a = lengthOfLongestSubstring(str);
        System.out.println("result: " + a);
        // write your code here
    }
}
//python可以使用ord()函数取得字符的ASCII码，其他都一样