import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int[][] maze = new int[100][100];
	static int[] start = new int[2];
	static int[] end = new int[2];
	static int ans;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static boolean[][] visit = new boolean[100][100];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int t = 1; t <= 10; t++) {
			br.readLine(); // 테스트 케이스 넘버
			ans = 0;
			visit = new boolean[100][100];
			for (int i = 0; i < 100; i++) {
				char[] c = br.readLine().toCharArray();
				for (int j = 0; j < 100; j++) {
					int n = c[j] - '0';
					maze[i][j] = n;
					if (n == 2) {
						start[0] = i;
						start[1] = j;
					}
					if (n == 3) {
						end[0] = i;
						end[1] = j;
					}
				}
			}

			dfs(start[0], start[1]);
			System.out.println("#" + t + " " + ans);

		}
	}

	static void dfs(int n, int m) {
		visit[n][m] = true;
		if (n == end[0] && m == end[1]) {
			ans = 1;
			return;
		}
		for (int i = 0; i < 4; i++) {
			int nx = n + dx[i];
			int ny = m + dy[i];

			if (!check(nx, ny))continue;

			if (maze[nx][ny] != 1 && !visit[nx][ny])
				dfs(nx, ny);
		}
	}

	static void bfs(int n, int m) {
		Queue<int[]> q = new LinkedList<>();

		q.offer(new int[] { n, m });

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			visit[cur[0]][cur[1]] = true;
			if (cur[0] == end[0] && cur[1] == end[1]) {
				ans = 1;
				return;
			}

			for (int i = 0; i < 4; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];

				if (!check(nx, ny))continue;

				if (maze[nx][ny] != 1 && !visit[nx][ny])
					q.offer(new int[] { nx, ny });
			}
		}
	}

	static boolean check(int n, int m) {
		return n >= 0 && n < 100 && m >= 0 && m < 100;
	}
}
