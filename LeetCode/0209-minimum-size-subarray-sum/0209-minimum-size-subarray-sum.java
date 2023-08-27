class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int start = 0;
        int end = 1;
        int sum = nums[0];        
        int min = Integer.MAX_VALUE;

        while(start<nums.length){
            if(sum >= target){
                if(min > end-start) min =  end - start;
                sum -= nums[start];
                start++;
            }
            else{
                if(end==nums.length) break;
                sum += nums[end];
                end++;
            }
        }   

        return min == Integer.MAX_VALUE ? 0 : min;

    }
}