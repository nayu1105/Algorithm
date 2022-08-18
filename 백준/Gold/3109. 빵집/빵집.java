import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int R, C, cnt;
	static char[][] map;
	static boolean[][] visit;
	static int[] dy = { -1, 0, 1 }; // 오른쪽 위, 오른쪽, 오른쪽 아래
	static int[] dx = { 1, 1, 1 };

	public static void main(String[] args) throws Exception {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];
		visit = new boolean[R][C];

		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}

		for (int i = 0; i < R; i++) {
			if (dfs(i, 0)) {
				cnt++;
			}
		}

		System.out.println(cnt);
	}

	static boolean dfs(int y, int x) {
		visit[y][x] = true;
		if (x == C - 1) {
			return true;
		}
		for (int i = 0; i < 3; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (check(nx, ny)) {
				if (map[ny][nx] == '.')
					if(dfs(ny,nx)) return true;
			}

		}
		return false;
	}

	static boolean check(int x, int y) {
		return x >= 0 && x < C && y >= 0 && y < R && !visit[y][x];
	}

}
