import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
/*
剑指 Offer 59 - II. 队列的最大值

请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
若队列为空，pop_front 和 max_value 需要返回 -1

示例 1：
输入:
["MaxQueue","push_back","push_back","max_value","pop_front","max_value"]
[[],[1],[2],[],[],[]]
输出: [null,null,null,2,1,2]

示例 2：
输入:
["MaxQueue","pop_front","max_value"]
[[],[],[]]
输出: [null,-1,-1]
 

限制：

1 <= push_back,pop_front,max_value的总操作数 <= 10000
1 <= value <= 10^5

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/dui-lie-de-zui-da-zhi-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class slidingWindows_queue_offer59_2 {
    static class MaxQueue {
        Deque<Integer> deque = new LinkedList<>();
        public MaxQueue() {

        }

        public int max_value() {
            if(deque.isEmpty()) {
                return -1;
            }
            int tmp = deque.getFirst();
            for(int n : deque){
                if(n>tmp)
                    tmp = n;
            }
            return tmp;
        }

        public void push_back(int value) {
            deque.addLast(value);
        }

        public int pop_front() {
            int ret = -1;
            if(!deque.isEmpty()) {
                ret = deque.removeFirst();
            }
            return ret;
        }
    }
    class MaxQueue2 {
        private Deque<Integer> queue;
        private Deque<Integer> help;

        public MaxQueue2() {
            queue = new ArrayDeque<>();
            help = new ArrayDeque<>();
        }

        public int max_value() {
            return queue.isEmpty() ? -1 : help.peek();
        }

        public void push_back(int value) {  //保证help队首永远是当前queue中最大的元素
            queue.offer(value);  //offer()向队尾添加元素，失败返回false，不会抛异常
            while(!help.isEmpty() && value > help.peekLast()) { //peekLast(): 获取队尾元素但不移除，如果队列无元素，则返回null
                help.pollLast();  //pollLast(): 返回并移除队尾元素，如果队列无元素，则返回null
            }
            help.offer(value);
        }

        public int pop_front() {
            if(queue.isEmpty()) {
                return -1;
            }
            int val = queue.pop();
            if(help.peek() == val) {
                help.pop();
            }
            return val;
        }
    }

    /**
     * Your MaxQueue object will be instantiated and called as such:
     * MaxQueue obj = new MaxQueue();
     * int param_1 = obj.max_value();
     * obj.push_back(value);
     * int param_3 = obj.pop_front();
     */

    public static void main(String[] args) {
        MaxQueue obj = new MaxQueue();
        int param_1 = obj.max_value();
        obj.push_back(1);
        int param_3 = obj.pop_front();

        // write your code here
    }
}
/*
python：
class MaxQueue:

    def __init__(self):
        self.queue = [] #数据队列
        self.sort = [] #记录最大值
        self.start = 0 #队列起始位置
        self.sort_start = 0 #sort起始位置
    def max_value(self) -> int:
        if len(self.sort) == self.sort_start:
            return -1
        elem = self.sort[self.sort_start]
        return elem
    def push_back(self, value: int) -> None:
        self.queue.append(value)
        while self.sort[self.sort_start:] and value > self.sort[-1]: #保证队列是降序排列的，如果新入队的数值比较大，那么sort_start之后比它小的数字可以不要
            self.sort.pop()
        self.sort.append(value)
    def pop_front(self) -> int:
        if len(self.queue) == self.start:
            return -1
        elem = self.queue[self.start]
        if elem == self.sort[self.sort_start]:#如果弹出的是最大值，则sort的起始位置向后移动一位
            self.sort_start += 1
        self.start += 1 #队列的起始位置向后移动一位
        return elem
 */
