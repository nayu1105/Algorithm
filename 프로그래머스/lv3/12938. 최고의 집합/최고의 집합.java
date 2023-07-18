class Solution {
    public int[] solution(int n, int s) {
        int[] answer = {-1};
        if(s/n == 0) return answer;
        else {
            answer = new int[n];   
            int quotient = s/n;
            int reminder = s%n;
            for(int index = 0 ; index < n-reminder; index++){
                answer[index] = quotient;
            }
            for(int index = n-reminder ; index < n; index++){
                answer[index] = quotient + 1;
            }
            
            return answer;
        }
        
    }
}