import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/*
剑指 Offer 59 - I. 滑动窗口的最大值

给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。

示例:
输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
输出: [3,3,5,5,6,7]
解释:

  滑动窗口的位置                最大值
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
 
提示：
你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class slidingWindows_offer59_1 {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length==0){
            int[] ret = new int[0];
            return ret;
        }
        int l = 0;
        int r = k-1;
        int[] ret = new int[nums.length-k+1];

        for(; r<nums.length;){
            int max = (int) (-1/0.0);
            int tmp = (int) (-1/0.0);
            for(int j=l; j<=r; j++){
                max = Math.max(tmp, nums[j]);
                tmp = max;
                System.out.println(max);
            }
            ret[r-k+1] = max;
            l++;
            r++;
        }
        return ret;
    }
    //单调双向队列，时间复杂度O(n)
    public static int[] maxSlidingWindow2(int[] nums, int k) {
        if (nums.length == 0){
            return new int[0];
        }
        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        // i是右指针，j是左指针
        // 队列中存储最大值的下标
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            // 判断队头元素是否在当前窗口内
            if (!deque.isEmpty() && i - deque.peekFirst() >= k) {
                deque.removeFirst();
            }
            //进队前，队尾出队比当前元素小的，保持递减序列
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.removeLast();
            }
            deque.add(i);
            // 队头元素一直是当前窗口最大值
            if (i - k + 1 >= 0) {
                res[j] = nums[deque.peekFirst()];
                j++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int[] a = maxSlidingWindow2(nums, 3);
        for(int i=0; i<a.length; i++) {
            System.out.println("result: " + a[i]);
        }
        // write your code here
    }
}

/*
python:
def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        res,q = [], collections.deque()
        for i in range(1 - k, len(nums) - k + 1):
            if i > 0 and q[0] < i : q.popleft()
            while q and nums[i + k - 1] > nums[q[-1]]: q.pop()
            q.append(i + k - 1)
            if i >= 0 : res.append(nums[q[0]])
        return res
 */


