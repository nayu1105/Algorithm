import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, T = 0, min;
	static int[][] map;
	static int[] dy = { 1, -1, 0, 0 };
	static int[] dx = { 0, 0, 1, -1 };
	static StringBuilder sb = new StringBuilder();
	static int[][] coin;
	static boolean[][] visit;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			N = Integer.parseInt(br.readLine());

			if (N == 0)
				break;
			T++; // 테스트케이스 번호 ++

			map = new int[N][N];
			coin = new int[N][N];
			visit = new boolean[N][N];

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					coin[i][j] = Integer.MAX_VALUE;
				}
			}

			min = Integer.MAX_VALUE;

			dijkstra();

			sb.append("Problem ").append(T).append(": ").append(coin[N - 1][N - 1]).append('\n');
		}
		System.out.println(sb);
	}

	private static void dijkstra() {
		PriorityQueue<int[]> queue = new PriorityQueue<>((p1, p2) -> p1[2] - p2[2]);

		coin[0][0] = map[0][0];
		queue.offer(new int[] { 0, 0, coin[0][0] });

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			visit[cur[0]][cur[1]] = true;

			for (int i = 0; i < 4; i++) {
				int ny = cur[0] + dy[i];
				int nx = cur[1] + dx[i];

				if (!check(ny, nx))
					continue;

				if (visit[ny][nx])
					continue;

				if (coin[cur[0]][cur[1]] + map[ny][nx] < coin[ny][nx]) {
					coin[ny][nx] = coin[cur[0]][cur[1]] + map[ny][nx];
					queue.offer(new int[] { ny, nx, coin[ny][nx] });
				}
			}
		}
	}

	static boolean check(int y, int x) {
		return y >= 0 && y < N && x >= 0 && x < N;
	}

}
