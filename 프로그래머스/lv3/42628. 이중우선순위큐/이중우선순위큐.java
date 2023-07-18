import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
		List<Integer> list = new ArrayList<Integer>();
        for(int index = 0; index < operations.length; index++){
            String[] ops = operations[index].split(" ");
            if(ops[0].equals("D")){
            	if(list.size()!=0) {
            		Collections.sort(list);
                    if(ops[1].equals("1")) list.remove(list.size()-1);
                    else list.remove(0);
            	}
            }
            else list.add(Integer.parseInt(ops[1]));
        }
        
        Collections.sort(list);
        int size = list.size();
        int[] answer = new int[2];
        
        if (size == 1){
            answer[0] = answer[1] = list.get(0);
        }
        else if(size != 0 && size != 1){
            answer[0] = list.get(size-1);
             answer[1] = list.get(0);            
        }
        
        return answer;
    }
}