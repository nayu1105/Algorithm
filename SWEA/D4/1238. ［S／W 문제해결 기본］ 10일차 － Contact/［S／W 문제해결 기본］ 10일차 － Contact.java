import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int N, K;
	static boolean[][] arr;
	static boolean[] visit;
	static Queue<Integer> queue = new ArrayDeque<>();
	static ArrayList<Integer> list = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int t = 1; t <= 10; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			arr = new boolean[101][101];
			visit = new boolean[101];

			st = new StringTokenizer(br.readLine());

			for (int i = 0; i < N / 2; i++) {
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				arr[a][b] = true;
			}
			queue.clear();
			list.clear();

			bfs(K);

			Collections.sort(list);

			System.out.println("#" + t+ " " +list.get(list.size() - 1));
		}

	}

	static void bfs(int n) {
		
		visit[n] = true;
		queue.offer(n);
		
		while(true) {
			int size= queue.size();
			for (int i = 0; i < size; i++) {
				int num = queue.poll();
				list.add(num);
				
				for (int j = 1; j < 101; j++) {
					if(arr[num][j] == true && !visit[j]) {
						queue.offer(j);
						visit[j]=true;
					}
				}
			}
			
			if(queue.isEmpty())break;
			
			list.clear();
		}		
	}
}
