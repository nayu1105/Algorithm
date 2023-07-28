class Solution {
    
    static int[] dp;
    
    public int solution(int sticker[]) {
        int answer = 0;
        int length = sticker.length;
        dp = new int[length];
        
        if(length==1){
            return sticker[0];
        }
        else if(length==2){
            return Math.max(sticker[0], sticker[1]);
        }
        else{
            // 1번째 스티커 뜯음
            dp[0] = sticker[0];
            dp[1] = sticker[0];

            simul(length, sticker);

            answer = Math.max(answer, dp[length-2]);

             // 1번재 스티커 뜯지않음
            dp[0] = 0;
            dp[1] = sticker[1];

            simul(length, sticker);

            answer = Math.max(answer, dp[length-1]);


            return answer;
        }
        
    }
    
    static public void simul(int length, int[] sticker){
        for(int i=2; i<length; i++){
            dp[i] = Math.max(dp[i-2]+sticker[i], dp[i-1]);
        }
    }
}