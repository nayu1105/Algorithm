class Solution {
    public int findPeakElement(int[] nums) {
       int index = 0;

       int distance = 0;
       int answer = 0;

       if(nums.length == 1) return 0;
       else if(nums.length == 2) return nums[0] > nums[1] ? 0 : 1;

       while(index < nums.length){
           int pre = index, before, next;
           if(index == 0){
               before = nums.length - 1;
               next = index + 1;
           }
           
           else if(index == nums.length - 1){
               before = index - 1;
               next = 0;
           }
           else {
               before = index - 1;
               next = index + 1;
           }

           if(nums[before] < nums[index] && nums[next] < nums[index]){
               return index;
           }
           else index++;
       }
       
       return answer;


    }
}