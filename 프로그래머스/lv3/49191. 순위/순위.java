class Solution {
    public int solution(int n, int[][] results) {
        int[][] score = new int[101][101];
        
        for(int index=0; index<results.length; index++){
            int a = results[index][0];
            int b = results[index][1];
            score[a][b] = 1;
        }
        
        for(int k = 1; k<=n; k++){
            for(int i = 1; i<=n; i++){
                if(i==k)continue;
                for(int j = 1; j<=n; j++){
                    if(j==i || j==k) continue;
                    if(score[i][k]==1&&score[k][j]==1){
                        score[i][j] = 1;
                    }
                }
            }
        }
        
        int answer= 0;
        for(int i=1; i<=n; i++){
            int game = 0;
            for(int j=1; j<=n; j++){
                 if(score[i][j]==1||score[j][i]==1){
                     game++;
                 }
            }
            if(game==n-1)answer++;
        }       
        
        return answer;
    }
}