import java.util.*;

class Solution {
    public boolean canJump(int[] nums) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        boolean[] visited = new boolean[nums.length];

        queue.add(0);
        visited[0] = true;

        while(!queue.isEmpty()){
            int temp = queue.poll();

            if(temp == nums.length -1) return true;

            for(int i=1; i<=nums[temp]; i++){
                int index = temp + i;

                if(index < nums.length&& !visited[index]){
                    queue.add(index);
                    visited[index] = true;
                }
            }
        }

        return false;
    }
}