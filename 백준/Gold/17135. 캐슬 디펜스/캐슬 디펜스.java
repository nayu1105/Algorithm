import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static int N, M, D, max = Integer.MIN_VALUE;
	static int[][] map, backup;
	static int[] tgt;
	static int[] dx = { -1, 0, 1 }; // 좌- 상 - 우 순서
	static int[] dy = { 0, -1, 0 };
	static Set<Node> set = new HashSet<>();
	static boolean[][] visit;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		tgt = new int[3];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		comb(0, 0);

		System.out.println(max);
	}

	static void comb(int src, int tgtIdx) {
		if (src > M)
			return;

		if (tgtIdx == 3) {
			// complete code
			simul();
			return;
		}

		tgt[tgtIdx] = src;

		comb(src + 1, tgtIdx + 1);
		comb(src + 1, tgtIdx);
	}

	static void simul() {

		backup = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				backup[i][j] = map[i][j];
			}
		}

		int ans = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 3; j++) {
				bfs(tgt[j]);
			}

			ans += set.size();
			Iterator<Node> iterator = set.iterator();
			while (iterator.hasNext()) {
				Node node = iterator.next();
				backup[node.y][node.x] = 0;
			}

			for (int j = N - 1; j >= 0; j--) {
				for (int k = 0; k < M; k++) {
					if (j == 0)
						backup[j][k] = 0;
					else
						backup[j][k] = backup[j - 1][k];
				}
			}

			set.clear();

		}
		max = Math.max(max, ans);

		// N번 for문하며
		// 궁수 위치에서 bfs 로 적3개 선택
		// 0으로 없애고 그만큼 ++;

		// 다 돈후 max 선택
		// 다시 comb

	}

	static void bfs(int x) {
		Queue<Node> queue = new ArrayDeque<Node>();

		int sy = N; // 궁수 위치 (N+1, x)
		int sx = x;

		visit = new boolean[N][M];

		if (backup[sy - 1][x] == 1) {// 거리가 1인 적
			set.add(new Node(sy - 1, x));
			return;
		} else {
			int y = sy - 1;
			queue.offer(new Node(y, x));
			visit[y][x] = true;

			while (!queue.isEmpty()) {
				Node n = queue.poll();
				if (backup[n.y][n.x] == 1) {
					set.add(new Node(n.y, n.x));
					return;
				}
				for (int j = 0; j < 3; j++) {
					int nx = n.x + dx[j];
					int ny = n.y + dy[j];

					if (!check(nx, ny))
						continue;
					
					if (distance(sx, sy, nx, ny) <= D) {
						queue.offer(new Node(ny, nx));
						visit[ny][nx] = true;
					}
				}
			}
		}
	}

	static boolean check(int x, int y) {
		return x >= 0 && x < M && y >= 0 && y < N && !visit[y][x];
	}

	static int distance(int x1, int y1, int x2, int y2) {
		return Math.abs(x1 - x2) + Math.abs(y1 - y2);
	}

	static class Node {
		int y, x;

		public Node(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}

		@Override
		public String toString() {
			return "Node [y=" + y + ", x=" + x + "]";
		}

		@Override
		public int hashCode() {
			return Objects.hash(y, x);
		}

		@Override
		public boolean equals(Object obj) {
			if (obj != null) {
				if (obj instanceof Node) {
					Node n = (Node) obj;
					if (this.y == n.y && this.x == n.x)
						return true;
				}
			}
			return false;
		}

	}
}
