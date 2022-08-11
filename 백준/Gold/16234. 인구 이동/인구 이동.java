import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, L, R;
	static int[][] arr;
	static boolean[][] visit;

	static Queue<int[]> q = new LinkedList<>();
	static int[] dx = { 1, -1, 0, 0 }; // 하 - 상 - 우- 좌
	static int[] dy = { 0, 0, 1, -1 };
	static int ans = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		arr = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		while (true) {
			visit = new boolean[N][N];
			boolean check = false;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!visit[i][j]) {
						int n = dfs(i, j);
						if (q.size()!=1) {
							check = true;
							move(n);
						}
						q.clear();
					}
				}
			}

			if (check == false)
				break;
			ans++;
		}

		System.out.println(ans);

	}

	static void move(int n) {
		int avg = n / q.size();
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			arr[cur[0]][cur[1]] = avg;
		}
	}

	static int dfs(int n, int m) {
		int ans = arr[n][m];
		visit[n][m] = true;
		q.offer(new int[] { n, m });

		for (int i = 0; i < 4; i++) {
			int nx = n + dx[i];
			int ny = m + dy[i];

			if (!check(nx, ny))
				continue;

			if (!visit[nx][ny] && Math.abs(arr[n][m] - arr[nx][ny]) >= L && Math.abs(arr[n][m] - arr[nx][ny]) <= R) {
				ans += dfs(nx, ny);
			}

		}

		return ans;
	}

	static boolean check(int n, int m) {
		return n >= 0 && n < N && m >= 0 && m < N;
	}
}
