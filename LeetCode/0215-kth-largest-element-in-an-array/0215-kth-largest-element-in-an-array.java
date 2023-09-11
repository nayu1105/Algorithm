class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((p1,p2)->p2-p1);
        for(int i=0; i<nums.length; i++){
            pq.add(nums[i]);
        }

        int answer = 0;
        for(int i=0; i<k; i++){
            answer = pq.poll();
        }

        return answer;

    }
}