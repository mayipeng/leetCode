import java.util.HashMap;

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
