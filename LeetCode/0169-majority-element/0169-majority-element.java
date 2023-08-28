import java.util.HashMap;
import java.util.Map;

class Solution {
    public int majorityElement(int[] nums) {
        
        Map<Integer, Integer> map = new HashMap<>();

        int check = nums.length/2;
        if(nums.length % 2 !=0){
            check++;
        }

        for(int i=0; i<nums.length; i++){
            if(map.containsKey(nums[i])){
                if(map.get(nums[i])+1==check){
                    return nums[i];
                }
                map.put(nums[i], map.get(nums[i]) + 1 );
            }else{
                map.put(nums[i], 1);
            }
        }

        return nums[0];        
    }
}