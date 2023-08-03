import java.util.*;
import java.io.*;


public class Main
{
    static HashMap<String, Integer> MAP = new HashMap<>();
    static List<List<Node>> LIST = new ArrayList<>();
    static int N, M;
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i=0; i<N; i++){
            String str = br.readLine();
            MAP.put(str, i);
            LIST.add(new ArrayList<Node>());
            LIST.get(i).add(new Node(9,18));
        }


        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            String room = st.nextToken();
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            simul(room, start, end);
        }

        List<String> keyList = new ArrayList(MAP.keySet());
        Collections.sort(keyList);
        boolean check = false;
        for(String str : keyList){
            if(check)System.out.println("-----");
            check = true;
            System.out.println("Room " + str +":");
            
            int list_index = MAP.get(str);

            if(LIST.get(list_index).size()==0) System.out.println("Not available");
            else {
                System.out.println(LIST.get(list_index).size() + " available:");
                for(int i=0; i<LIST.get(list_index).size(); i++){
                    int start = LIST.get(list_index).get(i).start;
                    int end = LIST.get(list_index).get(i).end;

                    if(start < 10) System.out.print("0"+start+"-");
                    else System.out.print(start+"-");

                    if(end < 10) System.out.println("0"+end);
                    else System.out.println(end);
                }
            }
        }
    }

    static void simul(String room, int start, int end){
        int list_index = MAP.get(room);
        
        if(LIST.get(list_index).size()==0)return;

        int index = 0;
        while(index < LIST.get(list_index).size()){
            int list_start = LIST.get(list_index).get(index).start;
            int list_end = LIST.get(list_index).get(index).end;

            if(start >= list_start && start <= list_end){

                LIST.get(list_index).remove(index);

                
                if(end!=list_end){
                    LIST.get(list_index).add(index, new Node(end, list_end));
                }
                if(start!=list_start){
                    LIST.get(list_index).add(index, new Node(list_start, start));
                }
                break;
            }
            else index ++;
        }
    }

    static class Node{
        int start;
        int end;

        public Node(){}
        
        public Node(int start, int end){
            this.start = start;
            this.end = end;
        }
    }
}
