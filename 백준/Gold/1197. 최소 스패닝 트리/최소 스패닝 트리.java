import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int[] parents;
	static List<Edge> list = new ArrayList<>();

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());

		parents = new int[V + 1];

		for (int i = 1; i <= V; i++) {
			parents[i] = i;
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			list.add(new Edge(a, b, c));
		}

		Collections.sort(list, (l1, l2) -> {
			return l1.cost - l2.cost;
		});

		int answer = 0;

		for (int i = 0; i < E; i++) {
			Edge edge = list.get(i);

			int parentsA = find(edge.a);
			int parentsB = find(edge.b);

			if (parentsA == parentsB)
				continue;

			union(parentsA, parentsB);
			answer += edge.cost;
		}

		System.out.println(answer);
	}

	static void union(int a, int b) {
		if (a < b)
			parents[a] = b;
		else
			parents[b] = a;
	}

	static int find(int a) {
		if (parents[a] == a)
			return a;
		else
			return parents[a] = find(parents[a]);
	}

	static class Edge {
		int a, b;
		int cost;

		public Edge(int a, int b, int cost) {
			this.a = a;
			this.b = b;
			this.cost = cost;
		}
	}
}