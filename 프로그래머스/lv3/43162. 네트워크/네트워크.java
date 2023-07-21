import java.util.*;

class Solution {    
    
    public int solution(int n, int[][] computers) {
        
        int answer = 0;
        boolean[] visited = new boolean[200];
        
        for(int i=0; i<n; i++){            
            if(!visited[i]){
                
                Queue<Integer> queue = new LinkedList<>();
                queue.offer(i);
                visited[i]=true;

                while(!queue.isEmpty()){
                    int temp = queue.poll();
                    for(int j=0; j<n; j++){
                       if(computers[temp][j]==1&&!visited[j]){
                           queue.offer(j);
                           visited[j]=true;
                       }
                    }
                }
                answer++;
            }
        }
        return answer;
    }

    
}