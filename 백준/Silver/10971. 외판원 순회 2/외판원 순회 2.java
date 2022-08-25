import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, min = Integer.MAX_VALUE;
	static int[][] map;
	static boolean[] visit;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 입력 끝

		for (int i = 0; i < N; i++) {
			visit = new boolean[N];
			visit[i] = true;
			dfs(i, 0, 0, i);
		}

		System.out.println(min);

	}

	static void dfs(int n, int c, int d, int st) {
		if (d == N - 1) {
			if(map[n][st]==0)return;
			min = Math.min(min, c + map[n][st]);

		}

		for (int i = 0; i < N; i++) {
			if (visit[i] || map[n][i] + c > min || map[n][i] == 0)
				continue;

			visit[i] = true;
			dfs(i, map[n][i] + c, d + 1, st);
			visit[i] = false;

		}
	}
}
