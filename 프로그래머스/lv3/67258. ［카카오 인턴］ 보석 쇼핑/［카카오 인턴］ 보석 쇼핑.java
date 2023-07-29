import java.util.*;

class Solution {
	public int[] solution(String[] gems) {
        HashSet<String> set = new HashSet<>();
        Collections.addAll(set, gems);
        
        HashMap<String, Integer> map = new HashMap<>();
        
        int distance = Integer.MAX_VALUE;
        
        int type = set.size();
        int length = gems.length;
        
        int start = 0, end = 0;
        int left = 0, right = 0;
        
        while(true){
        	if(map.size()==type) { // left 이동
        		String gem = gems[left];
        		map.put(gem, map.get(gem)-1);
        		if(map.get(gem) == 0) {
        			map.remove(gem);
        		}
        		left++;
        	}
        	else if(right == length) break;
        	else { 
        		String gem = gems[right];
        		map.put(gem, map.getOrDefault(gem, 0) + 1);
        		right++;
        	}
        	
        	if(map.size()==type) {
        		if(right - left < distance) {
        			distance = right - left;
        			start = left + 1;
        			end = right;
        		}
        	}

        }
        
        int[] answer = new int[2];
        
        answer[0] = start;
        answer[1] = end;
        
        return answer;
    }
}