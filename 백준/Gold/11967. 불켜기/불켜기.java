import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static List<Edge> list = new ArrayList<>();
	static Queue<Node> queue = new LinkedList<>();
	static boolean[][] visited;
	static boolean[][] isvalid;
	static int N, M;
	static int ty = 1, tx = 1;
	static int[] dy = { 0, 0, 1, -1 };
	static int[] dx = { 1, -1, 0, 0 };

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N + 1][N + 1];
		visited = new boolean[N + 1][N + 1];
		isvalid = new boolean[N + 1][N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int ax = Integer.parseInt(st.nextToken());
			int ay = Integer.parseInt(st.nextToken());

			int bx = Integer.parseInt(st.nextToken());
			int by = Integer.parseInt(st.nextToken());

			list.add(new Edge(new Node(ay, ax), new Node(by, bx)));
		}

		queue.offer(new Node(1, 1));
		visited[1][1] = true;
		isvalid[1][1] = true;
		simul();

		while (true) {
			simul();

			if (!find())
				break;
		}

		int answer = 0;

		for (int i = 1; i < N + 1; i++) {
			for (int j = 1; j < N + 1; j++) {
				if (isvalid[i][j])
					answer++;
			}
		}

		System.out.println(answer);
	}

	static boolean find() {
		Queue<Node> tempQueue = new LinkedList<>();
		tempQueue.offer(new Node(1, 1));
		boolean[][] tempVisit = new boolean[N+1][N+1];

		boolean answer = false;

		while (!tempQueue.isEmpty()) {
			Node node = tempQueue.poll();
			for (int i = 0; i < 4; i++) {
				int ny = node.y + dy[i];
				int nx = node.x + dx[i];

				if (ny >= 1 && ny <= N && nx >= 1 && nx <= N) {
					if (!tempVisit[ny][nx] && isvalid[ny][nx]) {
						tempQueue.offer(new Node(ny, nx));
						tempVisit[ny][nx] = true;
						if (!visited[ny][nx]) {
							queue.offer(new Node(ny, nx));
							visited[ny][nx] = true;
							answer = true;
						}
					}
				}

			}
		}

		return answer;
	}

	static void simul() {
		while (!queue.isEmpty()) {
			Node node = queue.poll();

			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).a.x == node.x && list.get(i).a.y == node.y) {
					isvalid[list.get(i).b.y][list.get(i).b.x] = true;
					list.remove(i);
					i--;
				}
			}

			for (int i = 0; i < 4; i++) {
				int nx = node.x + dx[i];
				int ny = node.y + dy[i];
				if (ny >= 1 && ny <= N && nx >= 1 && nx <= N) {
					if (isvalid[ny][nx] && !visited[ny][nx]) {
						queue.offer(new Node(ny, nx));
						visited[ny][nx] = true;
					}
				}
			}
		}

	}

	static class Edge {
		Node a, b;

		public Edge(Node a, Node b) {
			this.a = a;
			this.b = b;
		}
	}

	static class Node {
		int y, x;

		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
}