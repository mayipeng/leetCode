import java.util.HashMap;
/*
1. 两数之和

给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。

你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。

你可以按任意顺序返回答案。

示例 1：
输入：nums = [2,7,11,15], target = 9
输出：[0,1]
解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1]
。
示例 2：
输入：nums = [3,2,4], target = 6
输出：[1,2]

示例 3：
输入：nums = [3,3], target = 6
输出：[0,1]
 
提示：
2 <= nums.length <= 103
-109 <= nums[i] <= 109
-109 <= target <= 109
只会存在一个有效答案

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/two-sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class hashTable_top1 {
    public static int[] twoSum(int[] nums, int target) {
        HashMap hm = new HashMap();
        int[] result = new int[2];
        for(int i=0; i<nums.length; i++){
            if(!hm.containsKey(nums[i])){
                hm.put(target-nums[i], i);
            }else {
                result[0] = (int) hm.get(nums[i]);
                result[1] = i;
                return result;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = {4,1,2,1,2};
        int[] result = twoSum(nums, 5);
        for(int num:result){
            System.out.println("result: "+num);
        }

        // write your code here
    }
}
/*
python:
class Solution:
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        hashmap = {}
        for index, num in enumerate(nums):
            another_num = target - num
            if another_num in hashmap:
                return [hashmap[another_num], index]
            hashmap[num] = index
        return None
 */