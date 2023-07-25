import java.util.*;
class Solution {
    static boolean[] visited;
    static List<List<Integer>> list = new ArrayList<>();
    public int solution(int n, int[][] edge) {
        for(int i=0; i<=n; i++){
            list.add(new ArrayList<Integer>());
        }
        
        for(int i=0; i<edge.length; i++){
            list.get(edge[i][0]).add(edge[i][1]);
            list.get(edge[i][1]).add(edge[i][0]);
        }
        
        visited = new boolean[n+1];
        
        int answer =bfs(1);

        return answer;
    }
    
    static int bfs(int startIndex){
        
        int answer = 0;
        
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startIndex);
        visited[startIndex] = true;
        
        while(!queue.isEmpty()){
            int size = queue.size();
            answer= size;
            
            for(int i=0; i<size; i++){
                int temp = queue.poll();
                List<Integer> tempList = list.get(temp);
                int listSize = tempList.size();
                for(int j=0; j<listSize; j++){
                    int temp2 = tempList.get(j);
                    if(!visited[temp2]){
                        queue.offer(temp2);
                        visited[temp2]=true;
                    }
                }
            }
        }
        
        return answer;
        
    }
}