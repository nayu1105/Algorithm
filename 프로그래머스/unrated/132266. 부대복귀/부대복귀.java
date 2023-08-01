import java.util.*;
class Solution {
    static List<List<Integer>> list = new ArrayList<>();
    static int[] depth;
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        
        for(int i=0; i<=n; i++){
            list.add(new ArrayList<>());
        }
        
        for(int i=0; i<roads.length; i++){
            int a = roads[i][0];
            int b = roads[i][1];
            list.get(a).add(b);
            list.get(b).add(a);
        }
        
        int[] answer = new int[sources.length];
        depth = new int[n+1];
        Arrays.fill(depth, -1);
        
        bfs(destination, n);
        
        for(int i=0; i<sources.length; i++){
            answer[i] = depth[sources[i]];
        }
        
        return answer;
    }
    
    static public void bfs(int destination, int n){
        
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(destination);
        
        
        boolean[] visited = new boolean[n+1];
        visited[destination] = true;
        
        int d = 0;
        
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0; i<size; i++){
                int temp = queue.poll();
                depth[temp] = d;
                List<Integer> temp_list = list.get(temp);
                for(int j=0; j<temp_list.size(); j++){
                    if(!visited[temp_list.get(j)]) {
                        queue.offer(temp_list.get(j));
                        visited[temp_list.get(j)] = true;
                    }
                }
            }
            d++;
        }
    }
}