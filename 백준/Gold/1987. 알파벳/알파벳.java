import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int R, C, max = Integer.MIN_VALUE;
	static char[][] map;
	static boolean[] visit = new boolean[26];
	static int[] dx = { 0, 1, 0, -1 }; // CW
	static int[] dy = { -1, 0, 1, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];

		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		// 입력 끝

		dfs(0, 0, 1);

		System.out.println(max);

	}

	static void dfs(int y, int x, int d) {
		if (visit[(int) (map[y][x] - 'A')]) {
			max = Math.max(max, d -1);
			return;
		}
		visit[(int) (map[y][x] - 'A')] = true;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (!check(ny, nx))
				continue;

			dfs(ny, nx, d + 1);

		}
		visit[(int) (map[y][x] - 'A')] = false;

	}

	static boolean check(int y, int x) {
		return x >= 0 && x < C && y >= 0 && y < R;
	}
}
