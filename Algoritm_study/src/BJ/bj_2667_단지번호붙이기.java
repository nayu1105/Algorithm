package BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class bj_2667_단지번호붙이기 {
	static int N;
	static int[][] map;
	static boolean[][] visit;
	static ArrayList<Integer> ans;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { -1, 0, 1, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		map = new int[N][N];
		visit = new boolean[N][N];
		ans = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			char[] c = br.readLine().toCharArray();
			for (int j = 0; j < N; j++) {
				map[i][j] = c[j] - '0';
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1 && !visit[i][j]) {
					visit[i][j] = true;
					ans.add(dfs(i, j, 1));
				}

			}
		}

		Collections.sort(ans);

		System.out.println(ans.size());
		for (int s : ans) {
			System.out.println(s);
		}
	}

	static int dfs(int y, int x, int d) {
		int ans = d;
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];

			if (!check(ny, nx))
				continue;

			if (map[ny][nx] == 1 && !visit[ny][nx]) {
				visit[ny][nx] = true;
				ans += dfs(ny, nx, 1);
			}
		}
		return ans;
	}

	static boolean check(int y, int x) {
		return y >= 0 && y < N && x >= 0 && x < N;
	}
}
