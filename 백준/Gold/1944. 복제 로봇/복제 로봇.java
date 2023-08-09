import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static char[][] map;

	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };

	static List<Node> nodeList = new ArrayList<>();
	static List<Edge> edgeList = new ArrayList<>();

	static int[] parents;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new char[N][N];
		parents = new int[M + 1];

		for (int i = 0; i <= M; i++) {
			parents[i] = i;
		}

		for (int i = 0; i < N; i++) {
			char[] arr = br.readLine().toCharArray();
			for (int j = 0; j < N; j++) {
				map[i][j] = arr[j];
				if (map[i][j] == 'S' || map[i][j] == 'K')
					nodeList.add(new Node(i, j));
			}
		}

		for (int i = 0; i < nodeList.size(); i++) {
			bfs(nodeList.get(i));
		}

		Collections.sort(edgeList, (e1, e2) -> {
			return e1.cost - e2.cost;
		});

		int index = 0;
		int answer = 0;
		int cnt = 0;

		while (index < edgeList.size()) {
			Edge edge = edgeList.get(index);
			int parentsA = findParents(findIndex(edge.a));
			int parentsB = findParents(findIndex(edge.b));

			if (parentsA != parentsB) {
				union(parentsA, parentsB);
				answer += edge.cost;
				cnt++;
			}
			index++;
		}

		if (cnt != M)
			System.out.println(-1);
		else
			System.out.println(answer);

	}

	public static void union(int a, int b) {
		if (a < b)
			parents[findParents(a)] = findParents(b);
		else
			parents[findParents(b)] = findParents(a);
	}

	public static int findParents(int index) {
		if (parents[index] == index)
			return index;
		else
			return parents[index] = findParents(parents[index]);
	}

	public static int findIndex(Node node) {
		for (int i = 0; i < nodeList.size(); i++) {
			Node temp = nodeList.get(i);
			if (temp.x == node.x && temp.y == node.y)
				return i;
		}
		return -1;
	}

	public static void bfs(Node node) {
		Queue<Node> queue = new LinkedList<>();
		boolean[][] visited = new boolean[N][N];
		visited[node.y][node.x] = true;
		queue.offer(node);

		int depth = 0;

		while (!queue.isEmpty()) {
			int size = queue.size();
			depth++;
			for (int d = 0; d < size; d++) {
				Node temp = queue.poll();
				for (int i = 0; i < 4; i++) {
					int ny = temp.y + dy[i];
					int nx = temp.x + dx[i];
					if (isValid(ny, nx) && !visited[ny][nx]) {
						if (map[ny][nx] == 'K' || map[ny][nx] == 'S') {
							visited[ny][nx] = true;
							queue.offer(new Node(ny, nx));
							edgeList.add(new Edge(node, new Node(ny, nx), depth));
						}

						if (map[ny][nx] == '0') {
							visited[ny][nx] = true;
							queue.offer(new Node(ny, nx));
						}
					}
				}
			}

		}
	}

	public static boolean isValid(int y, int x) {
		return y >= 0 && y < N && x >= 0 && x < N;
	}

	public static class Node {
		int y, x;

		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	public static class Edge {
		Node a, b;
		int cost;

		public Edge(Node a, Node b, int cost) {
			this.a = a;
			this.b = b;
			this.cost = cost;
		}
	}
}