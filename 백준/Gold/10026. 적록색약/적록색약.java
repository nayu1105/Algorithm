import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{
	static int N, nm, rg;
	static char[][] map;
	static boolean[][] visit;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][];
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		visit = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visit[i][j]) {
					visit[i][j] = true;
					nm_dfs(i, j, map[i][j]);
					nm++;
				}
			}
		}
		visit = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visit[i][j]) {
					visit[i][j] = true;
					rg_dfs(i, j, map[i][j]);
					rg++;
				}
			}
		}

		System.out.println(nm + " " + rg);
	}

	static void nm_dfs(int y, int x, char c) { // normla dfs. 일반 사람의 탐색
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];

			if (!check(ny, nx))
				continue;

			if (!visit[ny][nx] && map[ny][nx] == c) {
				visit[ny][nx] = true;
				nm_dfs(ny, nx, c);
			}
		}
	}

	static void rg_dfs(int y, int x, char c) { // red-green colore bfs. 적록색약인 사람의 탐색
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];

			if (!check(ny, nx))
				continue;

			if (!visit[ny][nx]) {
				if ((c == 'R' || c == 'G') && (map[ny][nx] == 'R' || map[ny][nx] == 'G')) {
					visit[ny][nx] = true;
					rg_dfs(ny, nx, c);
				} else if (c == 'B' && map[ny][nx] == 'B') {
					visit[ny][nx] = true;
					rg_dfs(ny, nx, c);
				}
			}
		}
	}

	static boolean check(int y, int x) {
		return y >= 0 && y < N && x >= 0 && x < N;
	}
}
