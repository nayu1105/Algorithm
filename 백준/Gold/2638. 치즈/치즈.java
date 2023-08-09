import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[][] map;
	static int Total;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		Total = 0;
		int indexX = -1, indexY = -1;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1)
					Total++;
				if (map[i][j] == 0 && indexX == -1 && indexY == -1) {
					indexX = j;
					indexY = i;
				}
			}
		}

		int answer = 0;

		while (Total > 0) {
			bfs(indexX, indexY);
			answer++;
		}

		System.out.println(answer);

	}

	public static void bfs(int x, int y) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(x, y));
		boolean[][] visited = new boolean[N][M];
		visited[y][x] = true;
		int[][] count = new int[N][M];

		while (!queue.isEmpty()) {
			Node node = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nx = node.x + dx[i];
				int ny = node.y + dy[i];

				if (isValid(nx, ny)) {

					if (!visited[ny][nx] && map[ny][nx] == 0) {
						queue.offer(new Node(nx, ny));
						visited[ny][nx] = true;
					}

					if (map[ny][nx] == 1) {
						count[ny][nx]++;
					}
				}

			}

		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (count[i][j] >= 2) {
					map[i][j] = 0;
					Total--;
				}

			}
		}

	}

	public static boolean isValid(int x, int y) {
		return x >= 0 && x < M && y >= 0 && y < N;
	}

	public static class Node {
		int x, y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}