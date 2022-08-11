import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] dx = { -1, 0, 1, 0 }; // 상 -우 -하- 좌
	static int[] dy = { 0, 1, 0, -1 };
	static boolean[][] visit;
	static char[][] arr;
	static Queue<Node> queue = new ArrayDeque<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new char[N][M];
		visit = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			arr[i] = br.readLine().toCharArray();
		}

		queue.offer(new Node(0, 0));
		int d = 1;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				Node node = queue.poll();
				if (node.x == N - 1 && node.y == M - 1) {
					System.out.println(d);
					return;
				}
				bfs(node.x, node.y, d);
			}
			++d;
		}

	}

	static void bfs(int x, int y, int d) {
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx >= 0 && ny >= 0 && nx < N && ny < M && arr[nx][ny] == '1' && !visit[nx][ny]) {
				queue.offer(new Node(nx, ny));
				visit[nx][ny] = true;
			}
		}

	}

	static class Node {
		int x, y;

		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + "]";
		}

	}
}
