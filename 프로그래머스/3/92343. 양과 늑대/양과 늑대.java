import java.util.*;

class Solution {
    int answer = 0;
    public int solution(int[] info, int[][] edges) {
        dfs(0, new boolean[info.length], 0, 0, info, edges);
        return answer;
    }
    
    public void dfs(int idx, boolean[] visited, int sheep, int wolf, int[] info, int[][] edges){
        visited[idx] =true;
        
        if(info[idx] ==0){
            sheep++;
            answer = Math.max(sheep, answer);
        }else{
            wolf++;
        }
        
        if(sheep <= wolf){
            return;
        }
        
        for(int[] edge : edges){
            if(visited[edge[0]] && !visited[edge[1]]){
                boolean[] newVisited = visited.clone();
                dfs(edge[1], newVisited, sheep, wolf, info, edges);
            }
        }
    }   
}
    
