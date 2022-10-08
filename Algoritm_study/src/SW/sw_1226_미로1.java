package SW;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sw_1226_미로1 {
	static int[][] map;
	static boolean[][] visit;
	static int sx, sy, ex, ey;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int t = 1; t <= 10; t++) {

			// 초기화

			visit = new boolean[16][16];
			map = new int[16][16];

			br.readLine();
			for (int i = 0; i < 16; i++) {
				char[] c = br.readLine().toCharArray();
				for (int j = 0; j < 16; j++) {
					int n = c[j] - '0';
					map[i][j] = n;
					if (n == 2) {
						sy = i;
						sx = j;
					}
					if (n == 3) {
						ey = i;
						ex = j;
					}
				}
			}
			// 입력 끝
			sb.append("#").append(t).append(" ");
			if (dfs(sy, sx))
				sb.append(1);
			else
				sb.append(0);

			sb.append("\n");

		}
		System.out.println(sb);
	}

	static boolean dfs(int y, int x) {
		if (y == ey && x == ex)
			return true;

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (!check(ny, nx))
				continue;

			if (map[ny][nx] != 1 && !visit[ny][nx]) {
				visit[ny][nx] = true;
				if (dfs(ny, nx))
					return true;
			}
		}

		return false;

	}

	static boolean check(int y, int x) {
		return y >= 0 && y < 16 && x >= 0 && x < 16;
	}
}
