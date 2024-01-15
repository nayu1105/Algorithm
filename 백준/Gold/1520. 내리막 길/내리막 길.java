import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Map.Entry;

class Main {
	static int[][] map, search;
	static int N, M;

	static int[] dy = { 0, 1, -1, 0 };
	static int[] dx = { 1, 0, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		search = new int[N][M];
		for (int i = 0; i < N; i++) {
			Arrays.fill(search[i], -1);
		}

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		System.out.println(solution());

	}

	static int solution() {
		return dfs(new Node(0, 0));
	}

	static int dfs(Node node) {
		if (node.y == N - 1 && node.x == M - 1) {
			return 1;
		}

		if (search[node.y][node.x] != -1) {
			return search[node.y][node.x];
		}

		search[node.y][node.x] = 0;

		for (int i = 0; i < 4; i++) {
			int nx = node.x + dx[i];
			int ny = node.y + dy[i];

			if (!check(ny, nx))
				continue;

			if (map[ny][nx] < map[node.y][node.x]) {
				search[node.y][node.x] += dfs(new Node(ny, nx));

			}

		}

		return search[node.y][node.x];
	}

	static boolean check(int y, int x) {
		return y >= 0 && y < N && x >= 0 && x < M;
	}

	public static class Node {
		int y, x;

		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}

	}

}