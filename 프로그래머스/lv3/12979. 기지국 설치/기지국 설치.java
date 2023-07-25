class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;

        for(int i = 0; i < stations.length; i++){
            int start;
            int end;
            
            if(i==0){
                start = 1;
                end = stations[i]-w;
                answer += getNeedStations(end-start, w);
            }
            
            if(i==stations.length-1){
                start = stations[i]+w;
                end = n;
                answer += getNeedStations(end-start, w);
            }
            else{
                start = stations[i]+w+1;
                end = stations[i+1]-w;
                answer += getNeedStations(end-start, w);
            }            
        }
        return answer;
    }
    
    
    static public int getNeedStations(int distance, int w){
        if(distance<=0)return 0;
        if(distance%(w*2+1) == 0) return distance/(w*2+1);
        else return distance/(w*2+1) +1;
    }
}