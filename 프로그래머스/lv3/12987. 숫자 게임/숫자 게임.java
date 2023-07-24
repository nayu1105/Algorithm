import java.util.*;
class Solution {
    public int solution(int[] A, int[] B) {
        
        Arrays.sort(A);
        Arrays.sort(B);
        
        int answer=0;
        int indexB = B.length-1
            ;
        for(int i=A.length-1; i>=0;i--){
            if(B[indexB]>A[i]){
                answer++;
                indexB--;
            }
            if(indexB==-1)break;
        }
        return answer;
    }
}