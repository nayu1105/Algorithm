import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int V, E;
	static ArrayList<ArrayList<Integer>> Edge;
	static int[] inDegree;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int t = 1; t <= 10; t++) {
			Edge = new ArrayList<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());

			for (int i = 0; i < V + 1; i++) {
				Edge.add(new ArrayList<Integer>());
			}

			inDegree = new int[V + 1];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < E; i++) {
				int v1 = Integer.parseInt(st.nextToken());
				int v2 = Integer.parseInt(st.nextToken());

				Edge.get(v1).add(v2);
				inDegree[v2]++;

			}

			// list 완성

			sb.append("#").append(t);
			topoloySort(); // 위상정렬
			sb.append('\n');
		}

		System.out.println(sb);
	}

	static void topoloySort() {
		Queue<Integer> queue = new ArrayDeque<Integer>();

		for (int i = 1; i <= V; i++) {
			if (inDegree[i] == 0) {
				queue.offer(i);
			}
		}

		while (!queue.isEmpty()) {
			int cur = queue.poll();
			sb.append(" ").append(cur);
			ArrayList<Integer> e = Edge.get(cur);
			int size = e.size();
			for (int i = 0; i < size; i++) {
				if (--inDegree[e.get(i)] == 0) {
					queue.offer(e.get(i));
				}
			}
		}
	}
}
