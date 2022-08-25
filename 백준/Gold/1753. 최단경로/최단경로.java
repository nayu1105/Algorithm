import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int V, E, K;
	static int[] cost;
	static boolean[] visit;
	static ArrayList<ArrayList<Edge>> list = new ArrayList<>();
	static PriorityQueue<Edge> pq = new PriorityQueue<>((p1, p2) -> p1.weight - p2.weight);

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());

		cost = new int[V + 1];
		visit = new boolean[V + 1];

		for (int i = 0; i <= V; i++) {
			list.add(new ArrayList<Edge>());
			cost[i] = Integer.MAX_VALUE;
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());

			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			list.get(from).add(new Edge(to, w));
		}
		// 입력 끝

		dijkstra();

		for (int i = 1; i <= V; i++) {
			System.out.println(cost[i] == Integer.MAX_VALUE ? "INF" : cost[i]);
		}
	}

	private static void dijkstra() {
		cost[K] = 0; // 출발 노드 비용 0
		pq.offer(new Edge(K, 0));

		while (!pq.isEmpty()) {
			Edge e = pq.poll();

			if (e.weight > cost[e.v])
				continue;

			if (visit[e.v])
				continue;

			visit[e.v] = true;

			for (Edge edge : list.get(e.v)) {
				if (!visit[edge.v] && cost[e.v] + edge.weight < cost[edge.v]) {
					cost[edge.v] = cost[e.v] + edge.weight;
					pq.offer(new Edge(edge.v, cost[edge.v]));
				}
			}
		}

	}

	static class Edge {
		int v;
		int weight;

		public Edge(int v, int weight) {
			this.v = v;
			this.weight = weight;
		}
	}
}
