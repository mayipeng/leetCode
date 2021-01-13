import javax.swing.text.html.parser.Entity;
import java.util.*;

/*
剑指 Offer 03. 数组中重复的数字：

找出数组中重复的数字。
在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。

示例 1：
输入：
[2, 3, 1, 0, 2, 5, 3]
输出：2 或 3
 
限制：
2 <= n <= 100000

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class hashTable_offer03 {
    public static int findRepeatNumber(int[] nums) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(Integer num : nums){
            boolean flag = map.containsKey(num);
            if(flag){
                map.put(num, map.get(num)+1);
            }else{
                map.put(num, 1);
            }
        }
        for(Map.Entry<Integer, Integer> ent : map.entrySet()){
            Integer key = ent.getKey();
            Integer value = ent.getValue();
            System.out.println("key: "+key.toString()+"  value: "+value.toString());
            if(value>1){
                return key;
            }
        }
        return -1;
    }
    public static int findRepeatNumber2(int[] nums) {
        //方法一：用Set
        //时间复杂度：O(n) 空间复杂度O(n)
        Set<Integer> set = new HashSet();
        for (int num : nums) {
            if (!set.add(num)){
                return num;
            }
        }
        return -1;
    }
    public static int findRepeatNumber3(int[] nums) {
        int[] arr = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            arr[nums[i]]++;
            if(arr[nums[i]] > 1) return nums[i];
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 0, 2, 5, 3};
        int a = findRepeatNumber3(nums);
        System.out.println("result: "+a);
        // write your code here
    }
}
/*
python:
class Solution:
    def findRepeatNumber(self, nums: List[int]) -> int:  //:后面是入参类型，->是出参类型
        repeatDict = {}
        for num in nums:
            if num not in repeatDict:
                repeatDict[num] = 1  //修改字典
            else:
                return nu
 */
