import java.util.HashSet;

public class hashTable_Tencent217 {
    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(Integer num:nums){
            if(set.contains(num)){
                return true;
            }else set.add(num);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {4,1,2,1,2};
        boolean result = containsDuplicate(nums);
        System.out.println("result: "+result);
        // write your code here
    }
}
