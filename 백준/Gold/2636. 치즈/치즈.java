import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int H, W;
	static int time, sum, cheese;
	static int[][] map;
	static boolean[][] visit;
	static int[] dy = { 0, 0, 1, -1 };
	static int[] dx = { 1, -1, 0, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());

		map = new int[H][W];

		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				int n = Integer.parseInt(st.nextToken());
				map[i][j] = n;
				if (n == 1)
					cheese++;
			}
		}

		do {
			bfs();
		} while (cheese != 0);

		System.out.println(time);
		System.out.println(sum);
	}

	static void bfs() {
		List<Node> list = new ArrayList<>();
		visit = new boolean[H][W];

		Queue<Node> queue = new ArrayDeque<Node>();

		queue.offer(new Node(0, 0));

		while (!queue.isEmpty()) {
			Node node = queue.poll();

			for (int i = 0; i < 4; i++) {
				int ny = node.y + dy[i];
				int nx = node.x + dx[i];

				if (!check(ny, nx))
					continue;

				if (visit[ny][nx])
					continue;

				if (map[ny][nx] == 0) {
					queue.offer(new Node(ny, nx));
				} else {
					list.add(new Node(ny, nx));
				}

				visit[ny][nx] = true;
			}
		}

		sum = list.size();
		cheese -= sum;
		time++;

		for (int i = 0; i < list.size(); i++) {
			Node node = list.get(i);
			map[node.y][node.x] = 0;
		}
	}

	static boolean check(int y, int x) {
		return x >= 0 && x < W && y >= 0 & y < H;
	}

	static class Node {
		int y, x;

		public Node(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}

	}
}
