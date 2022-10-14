import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;

	static int[][] map;
	static boolean[][] visit;
	static int[] dy = { 0, 0, 1, -1 };
	static int[] dx = { 1, -1, 0, 0 };

	static int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
	static int ans = 1;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		map = new int[N][N];
		visit = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int n = Integer.parseInt(st.nextToken());
				map[i][j] = n;
				min = Math.min(min, n);
				max = Math.max(max, n);
			}
		}

		for (int i = min; i < max; i++) {
			ans = Math.max(ans, simul(i));
		}

		System.out.println(ans);
	}

	private static int simul(int flood) {

		CleanVisit();

		int cnt = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visit[i][j] && map[i][j] > flood) {
					dfs(new Node(i, j), flood);
					cnt++;
				}
			}
		}

		return cnt;

	}

	private static void dfs(Node start, int flood) {
		Queue<Node> queue = new ArrayDeque<>();
		queue.offer(start);
		visit[start.y][start.x] = true;

		while (!queue.isEmpty()) {
			Node node = queue.poll();
			for (int i = 0; i < 4; i++) {
				int ny = node.y + dy[i];
				int nx = node.x + dx[i];

				if (!check(ny, nx))
					continue;

				if (visit[ny][nx] || map[ny][nx] <= flood)
					continue;

				queue.offer(new Node(ny, nx));
				visit[ny][nx] = true;
			}
		}
	}

	private static void CleanVisit() {
		for (int i = 0; i < N; i++) {
			Arrays.fill(visit[i], false);
		}
	}

	private static boolean check(int y, int x) {
		return y >= 0 && y < N && x >= 0 && x < N;
	}

	static class Node {
		int y, x;

		Node(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
}
