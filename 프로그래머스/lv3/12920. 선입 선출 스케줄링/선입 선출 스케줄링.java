import java.util.*;

class Solution {
    public int solution(int n, int[] cores) {
        int answer = 0;
        
        int min = 0;
        int max = 10000*n;
        
        int time = 0;
        int jobs = 0;
        
        while(min<=max){
            int mid = (min+max)/2;
            
            int count = countWork(mid, cores);
            
            if(count >= n){
                max = mid-1;
                time = mid;
                jobs = count;
            }
            else{
                min = mid+1;
            }
        }
        
        jobs-=n;
        for(int i=cores.length-1; i>=0; i--){
            if(time%cores[i] == 0){
                if(jobs==0){
                    answer = i+1;
                    break;
                }
                jobs--;
            }
        }
        
        return answer;
    }
    
    static int countWork(int time, int[] cores){
        if(time==0){
            return cores.length;
        }
        int count = cores.length;
        
        for(int i=0; i< cores.length; i++){
            count += (time/cores[i]);
        }
        
        return count;
    }
}