import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int M, N, H;
	static int[][][] box;
	static boolean[][][] visit;
	static int[] dy = { 0, 0, 1, -1 };
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dz = { 1, -1 };
	static int day = 0; // 토마토가 모두 익는 데 걸리는 최소 일 수
	static int tomato; // 안익은 토마토 수
	static Queue<Node> queue = new ArrayDeque<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		box = new int[H][N][M];
		visit = new boolean[H][N][M];

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < M; k++) {
					int n = Integer.parseInt(st.nextToken());
					if (n == 0)
						tomato++;
					else if (n == 1)
						queue.add(new Node(i, j, k));
					box[i][j][k] = n;
				}
			}
		}

		dfs();

		if (tomato == 0)
			System.out.println(day - 1);
		else
			System.out.println(-1);

	}

	private static void dfs() {
		while (!queue.isEmpty()) {
			int size = queue.size();
			while (size-- > 0) {
				Node node = queue.poll();

				int nz, ny, nx;
				for (int i = 0; i < 4; i++) {
					ny = node.y + dy[i];
					nx = node.x + dx[i];

					if (!check(ny, nx))
						continue;

					if (box[node.h][ny][nx] == -1)
						continue;

					if (box[node.h][ny][nx] == 0 && !visit[node.h][ny][nx]) {
						visit[node.h][ny][nx] = true;
						box[node.h][ny][nx] = 1;
						queue.add(new Node(node.h, ny, nx));
						tomato--;
					}

				}

				for (int i = 0; i < 2; i++) {
					nz = node.h + dx[i];

					if (!check2(nz))
						continue;

					if (box[nz][node.y][node.x] == -1)
						continue;

					if (box[nz][node.y][node.x] == 0 && !visit[nz][node.y][node.x]) {
						visit[nz][node.y][node.x] = true;
						box[nz][node.y][node.x] = 1;
						queue.add(new Node(nz, node.y, node.x));
						tomato--;
					}
				}
			}
			day++;
		}
	}

	private static boolean check2(int z) {
		return z >= 0 && z < H;
	}

	private static boolean check(int y, int x) {
		return y >= 0 && x >= 0 && y < N && x < M;
	}

	static class Node {
		int h, y, x;

		public Node(int h, int y, int x) {
			this.h = h;
			this.y = y;
			this.x = x;
		}

	}

}
