import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        
        
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<tangerine.length; i++){
            if(map.containsKey(tangerine[i])){
                map.put(tangerine[i], map.get(tangerine[i])+1);
            }else{
                map.put(tangerine[i], 1);
            }
        }
        
        List<Integer> valueList = new ArrayList<>(map.values());
        Collections.sort(valueList, Collections.reverseOrder());
        
        int answer = 0;
        int index = 0;
        int count = 0;
        
        while(count<k){
            count += valueList.get(index);
            answer ++;
            index ++;
        }
        
        return answer;
    }
    
}