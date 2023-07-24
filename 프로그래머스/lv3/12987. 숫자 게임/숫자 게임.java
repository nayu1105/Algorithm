import java.util.*;
class Solution {
    public int solution(int[] A, int[] B) {
        Integer[] arrA = Arrays.stream(A).boxed().toArray(Integer[]::new);
         Integer[] arrB = Arrays.stream(B).boxed().toArray(Integer[]::new);
        Arrays.sort(arrA, Collections.reverseOrder());
        Arrays.sort(arrB, Collections.reverseOrder());
        
        int answer=0;
        int indexB =0;
        for(int i=0; i<A.length;i++){
            if(arrB[indexB]>arrA[i]){
                answer++;
                indexB++;
            }
        }
        return answer;
    }
}