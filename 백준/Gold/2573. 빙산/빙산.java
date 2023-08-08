import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static boolean[][] visited;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };
	static int N, M;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		int[][] map = new int[N][M];
		int count = 0;
		int indexX = 0, indexY = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] != 0) {
					indexY = i;
					indexX = j;
				}
			}
		}

		int answer = 0;

		while (true) {
			int temp = 0;
			visited = new boolean[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (!visited[i][j] && map[i][j] != 0) {
						bfs(i, j, map);
						temp++;
					}
				}
			}

			if (temp == 0) {
				answer = 0;
				break;
			} else if (temp == 1) {
				answer++;
				continue;
			} else {
				break;
			}
		}

		System.out.print(answer);
	}

	public static void bfs(int y, int x, int[][] map) {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(y, x));
		visited[y][x] = true;
		int[][] copy = copyMap(map);

		while (!queue.isEmpty()) {
			Node temp = queue.poll();
			int count = 0;
			for (int i = 0; i < 4; i++) {
				int ny = temp.y + dy[i];
				int nx = temp.x + dx[i];

				if (!isValid(ny, nx))
					continue;

				if (copy[ny][nx] == 0) {
					count++;
				} else {
					if (!visited[ny][nx]) {
						visited[ny][nx] = true;
						queue.offer(new Node(ny, nx));
					}
				}
			}

			map[temp.y][temp.x] -= count;
			if (map[temp.y][temp.x] < 0)
				map[temp.y][temp.x] = 0;

		}
	}

	public static boolean isValid(int y, int x) {
		return x >= 0 && x < M && y >= 0 && y < N;
	}

	public static int[][] copyMap(int[][] map) {
		int[][] copy = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				copy[i][j] = map[i][j];
			}
		}
		return copy;
	}

	public static class Node {
		int y;
		int x;

		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
}