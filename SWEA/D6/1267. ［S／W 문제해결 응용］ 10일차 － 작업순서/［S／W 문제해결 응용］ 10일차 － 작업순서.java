import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int V, E;
	static ArrayList<ArrayList<Node>> list;
	static int[] inDegree;
	static ArrayList<Integer> ans ;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int t = 1; t <= 10; t++) {
			list =new ArrayList<>();
			ans = new ArrayList<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());

			for (int i = 0; i < V + 1; i++) {
				list.add(new ArrayList<Node>());
			}

			inDegree = new int[V + 1];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < E; i++) {
				int v1 = Integer.parseInt(st.nextToken());
				int v2 = Integer.parseInt(st.nextToken());

				list.get(v1).add(new Node(v2));
				inDegree[v2]++;

			}

			// list 완성
			topoloySort();

			sb.append("#").append(t);
			for (int i : ans) {
				sb.append(" ").append(i);
			}
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
			ans.add(cur);
			ArrayList<Node> l = list.get(cur);
			int size = l.size();
			for (int i = 0; i < size; i++) {
				if (--inDegree[l.get(i).v] == 0) {
					queue.offer(l.get(i).v);
				}
			}
		}
	}

	static class Node {
		int v;

		public Node(int v) {
			this.v = v;
		}

	}
}
