import java.util.*;
class Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i<works.length; i++){
            pq.offer(works[i]);
        }
        
        for(int i=0; i<n; i++){
            if(pq.isEmpty())break;
            
            int temp = pq.poll();
            if(temp-1==0)continue;
            pq.offer(temp-1);
        }
        
        long answer =0;
        long pqSize = pq.size();
        
        for(int i=0; i<pqSize; i++){
            int temp = pq.poll();
            answer += temp*temp;
        }
        
        
        return answer;
    }
}