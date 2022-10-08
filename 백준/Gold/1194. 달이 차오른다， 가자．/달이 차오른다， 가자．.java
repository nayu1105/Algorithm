import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static boolean[][][] visit;
	static char[][] map;
	static int sx, sy;
	static int ans = -1;

	static int[] dy = { 0, 0, 1, -1 };
	static int[] dx = { 1, -1, 0, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new char[N][M];
		visit = new boolean[N][M][1 << 6 + 1];

		for (int i = 0; i < N; i++) {
			char[] arr = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				char c = arr[j];
				if (c == '0') {
					sy = i;
					sx = j;
				}
				map[i][j] = c;
			}
		}

		bfs();

		System.out.println(ans);

	}

	private static void bfs() {
		Queue<Node> queue = new ArrayDeque<>();

		queue.offer(new Node(sy, sx, 0, 0));

		while (!queue.isEmpty()) {
			Node node = queue.poll();

			for (int i = 0; i < 4; i++) {
				int ny = node.y + dy[i];
				int nx = node.x + dx[i];
				int key = node.key;

				if (!check(ny, nx))
					continue;

				if (map[ny][nx] == '1') {
					ans = node.d + 1;
					return;
				} // min 값 구하고 break;

				if (map[ny][nx] == '#')
					continue;

				if ('a' <= map[ny][nx] && map[ny][nx] <= 'f') {
					key |= (1 << (map[ny][nx] - 'a'));
				}

				if ('A' <= map[ny][nx] && map[ny][nx] <= 'F') {
					if ((key & (1 << (map[ny][nx] - 'A'))) == 0)
						continue;
				}

				if (visit[ny][nx][key])
					continue;
				visit[ny][nx][key] = true;
				queue.offer(new Node(ny, nx, key, node.d + 1));
			}
		}
		ans = -1;
	}

	private static boolean check(int y, int x) {
		return y >= 0 && y < N && x >= 0 && x < M;
	}

	static class Node {
		int y, x;
		int key;
		int d;

		public Node(int y, int x, int key, int d) {
			super();
			this.y = y;
			this.x = x;
			this.key = key;
			this.d = d;
		}

		@Override
		public String toString() {
			return "Node [y=" + y + ", x=" + x + ", key=" + key + ", d=" + d + "]";
		}

	}

}
