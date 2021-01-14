/*
136. 只出现一次的数字
给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。

说明：
你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？

示例 1:
输入: [2,2,1]
输出: 1

示例 2:
输入: [4,1,2,1,2]
输出: 4

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/single-number
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class bitOperation_Tencent136 {
    public static int singleNumber(int[] nums) {
        /*
        1.交换律：a ^ b ^ c <=> a ^ c ^ b
        2.任何数于0异或为任何数 0 ^ n => n
        3.相同的数异或为0: n ^ n => 0

        var a = [2,3,2,4,4]
        2 ^ 3 ^ 2 ^ 4 ^ 4等价于 2 ^ 2 ^ 4 ^ 4 ^ 3 => 0 ^ 0 ^3 => 3
        */
        int res = 0;
        for(int i:nums){
            res ^= i;
        }
        return res;

    }

    public static void main(String[] args) {
        int[] nums = {4,1,2,1,2};
        int result = singleNumber(nums);
        System.out.println("result: "+result);
        // write your code here
    }
}
/*
java中：
&：按位与。
|：按位或。
~：按位非。
^：按位异或。
<<：左位移运算符。
>>：右位移运算符。
<<<：无符号右移运算符。

位运 算 符 中 ,除 ～ 以 外 ,其余 均 为 二 元 运 算 符 。 操 作 数 只 能 为 整 型 和字 符 型 数 据 。
 */

/*
python:
class Solution:
    def singleNumber(self, nums: List[int]) -> int:
        return reduce(int.__xor__, nums)  # reduce(function, iterable[, initializer])用传给 reduce 中的函数 function（有两个参数）先对集合中的第 1、2 个元素进行操作，得到的结果再与第三个数据用 function 函数运算，最后得到一个结果。
 */