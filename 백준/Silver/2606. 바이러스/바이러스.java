import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int C, N;
	static List<List<Integer>> list;
	static boolean[] visit;
	static int ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		C = Integer.parseInt(br.readLine());
		N = Integer.parseInt(br.readLine());
		list=  new ArrayList<>();
		visit = new boolean[C+1];
		for (int i = 0; i <= C; i++) { // 0 dummy
			list.add(new ArrayList<Integer>());
		}
		StringTokenizer st = null;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b= Integer.parseInt(st.nextToken());
			
			list.get(a).add(b);
			list.get(b).add(a);
		}
		
		bfs(1);
		System.out.println(ans);
	}

	private static void bfs(int i) {
		Queue<Integer> queue = new ArrayDeque<Integer>();
		queue.add(i);
		visit[i]=true;
		
		while(!queue.isEmpty()) {
			int computer = queue.poll();
			List<Integer> temp = list.get(computer);
			for (int j = 0; j < temp.size(); j++) {
				int n =temp.get(j);
				if(visit[n]==false) {
				queue.add(n);				
				visit[n]=true;
				ans++;
				}
			}
		}
	}
	
	
}
