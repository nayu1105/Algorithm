import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[] parents;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());

		List<Node> list = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			list.add(new Node(a, b, cost));
		}

		Collections.sort(list, (n1, n2) -> {
			return n1.cost - n2.cost;
		});

		initParents();

		int cost = 0;
		int index = 0;

		while (index < list.size()) {
			Node node = list.get(index);
			if (find(node.a) != find(node.b)) {
				cost += node.cost;
				union(node.a, node.b);
			}

			index++;
		}

		System.out.println(cost);
	}

	public static void initParents() {
		parents = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}
	}

	public static void union(int a, int b) {
		if (a < b)
			parents[find(b)] = find(a);
		else
			parents[find(a)] = find(b);
	}

	public static int find(int a) {
		if (parents[a] == a)
			return a;
		else
			return parents[a] = find(parents[a]);
	}

	public static class Node {
		int a, b;
		int cost;

		public Node(int a, int b, int cost) {
			this.a = a;
			this.b = b;
			this.cost = cost;
		}
	}
}