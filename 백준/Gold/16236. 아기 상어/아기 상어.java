import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] map;
	static Node shark;
	static int size = 2, eat = 0, time = 0;
	static int[] dy = { 0, 0, 1, -1 };
	static int[] dx = { 1, -1, 0, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int n = Integer.parseInt(st.nextToken());
				map[i][j] = n;
				if (n == 9) {
					shark = new Node(i, j);
				}
			}
		}

		// 전략
		// 상어 위치로 부터 bfs 하며 갈 수 있는 priority queue에 담기
		// ! pq.isEmpty : pq poll 해서 자리 옮기기
		// pq.isEmpty : bfs
		// bfs 가 모두 종료했음에도 pq가 비었다면 종료

		simul();

		System.out.println(time);
	}

	static void simul() {
		while (bfs()) {
		}
	}

	static boolean bfs() {
		Queue<Node> queue = new ArrayDeque<>();
		PriorityQueue<Node> pq = new PriorityQueue<>((p1, p2) -> p1.y == p2.y ? p1.x - p2.x : p1.y - p2.y);

		boolean[][] visit = new boolean[N][N];
		queue.offer(shark);
		visit[shark.y][shark.x] = true;
		int temp = 0;
		while (!queue.isEmpty()) {
			int qSize = queue.size();
			temp++;
			for (int s = 0; s < qSize; s++) {
				Node node = queue.poll();

				for (int i = 0; i < 4; i++) {
					int ny = node.y + dy[i];
					int nx = node.x + dx[i];

					if (!check(ny, nx))
						continue;

					if (visit[ny][nx])
						continue;

					if (map[ny][nx] == 0 || map[ny][nx] == size) {
						queue.offer(new Node(ny, nx));
						visit[ny][nx] = true;
						continue;
					}

					if (map[ny][nx] < size) {
						pq.offer(new Node(ny, nx));
						visit[ny][nx] = true;
						continue;
					}

				}
			}

			if (!pq.isEmpty())
				break;
		}

		if (pq.isEmpty())
			return false;
		else {
			map[shark.y][shark.x] = 0;
			shark = pq.poll();
			map[shark.y][shark.x] = 9;
			time += temp;
			eat++;

			if (size == eat) {
				size++;
				eat = 0;
			}

			return true;
		}
	}

	private static boolean check(int y, int x) {
		return y >= 0 && y < N && x >= 0 && x < N;
	}

	static class Node {
		int y, x;

		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}

		@Override
		public String toString() {
			return "Node [y=" + y + ", x=" + x + "]";
		}

	}
}
