import java.util.*;

class Solution {
    
static int answer = 0;
    static int size = 0;
    static Set<Set<String>> answer_set = new HashSet<>();
    static List<List<String>> list = new ArrayList<>();
        
    public int solution(String[] user_id, String[] banned_id) {
     
        size = banned_id.length;
        
        for(int i=0; i<banned_id.length; i++){
            list.add(setList(user_id, banned_id[i]));
        }
        
        dfs(new HashSet<>(), list);
        
        
        return answer_set.size();
    }
    
    static public List<String> setList(String[] user_id, String banned_id){
        List<String> list = new ArrayList<>();
        
        for(int i=0; i<user_id.length; i++){
            if(isBanned(user_id[i],banned_id))list.add(user_id[i]);
        }
        
        return list;
    }
    
    static public boolean isBanned(String user_id, String banned_id){
        char[] user_id_Array = user_id.toCharArray();
        char[] banned_id_Array = banned_id.toCharArray();
        
        if(user_id_Array.length != banned_id_Array.length)return false;
        else{
            boolean check = true;
            for(int i=0; i<user_id_Array.length; i++){
                if(user_id_Array[i]==banned_id_Array[i]||banned_id_Array[i]=='*')continue;
                else {
                    check= false;
                    break;
                }
            }
            return check;
        }
    }
    
    static public void dfs(Set<String> set, List<List<String>> list){
        if(set.size() == size){
        	Set<String> temp_set = new HashSet<>();
        	Iterator<String> iterator_set = set.iterator();
        	while(iterator_set.hasNext()) {
        		temp_set.add(iterator_set.next());
        	}
            answer_set.add(temp_set);
            return;
        }
        
        int list_index = set.size();
        List<String> temp_list = list.get(list_index);
        
        for(int i=0; i<temp_list.size(); i++){
            if(set.contains(temp_list.get(i)))continue;
            else {
                set.add(temp_list.get(i));
                dfs(set, list);
                set.remove(temp_list.get(i));
            }
        }        
    }
           
}