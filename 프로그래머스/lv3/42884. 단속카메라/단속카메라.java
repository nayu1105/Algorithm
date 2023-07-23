import java.util.*;

class Solution {
    static int MIN = -30001;
    
    public int solution(int[][] routes) {
        
        // routes = new int[][] {{0, -30000}, {1, -30000}, {2, -30000}};
        
        for(int i=0; i<routes.length; i++){
            if(routes[i][0] < routes[i][1]) {
                continue;
            }
            else {
                int temp = routes[i][0];
                routes[i][0] = routes[i][1];
                routes[i][1] = temp;
            }
        }
        
        Arrays.sort(routes, Comparator.comparingInt((int[] o) -> o[1]));
        
        
        int camera = MIN;
        int count = 0;
        
        for(int i=0; i<routes.length; i++){
            
            if(camera==MIN){
                camera=routes[i][1];
            }
            else{
                if(camera<routes[i][0]){
                    camera = routes[i][1];
                }
                else continue;
            }
            count++;
        }
        
        return count;
    }
}