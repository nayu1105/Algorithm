import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
	static int T, N;
	static int[][] arr;
	static int[][] min;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			min = new int[N][N];
			for (int i = 0; i < N; i++) {
				String temp = br.readLine();

				for (int j = 0; j < N; j++) {

					arr[i][j] = temp.charAt(j) - '0';
				}
			}

			for (int i = 0; i < N; i++) {
				Arrays.fill(min[i], Integer.MAX_VALUE);
			}

			restore();

			System.out.println("#" + t + " " + min[N - 1][N - 1]);
		}

	}

	static void restore() {
		PriorityQueue<Cord> pq = new PriorityQueue<>((p1, p2) -> p1.w - p2.w);

		pq.offer(new Cord(0, 0, arr[0][0]));
		min[0][0] = 0;

		while (!pq.isEmpty()) {
			Cord cord = pq.poll();
			int x = cord.x;
			int y = cord.y;


			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (!checked(ny, nx))
					continue;

				if (min[y][x] + arr[ny][nx] < min[ny][nx]) {
					min[ny][nx] = min[y][x] + arr[ny][nx];
					pq.offer(new Cord(ny, nx, arr[ny][nx]));
				}
			}
		}
	}

	static class Cord {
		int y, x, w;

		public Cord(int y, int x, int w) {
			super();
			this.y = y;
			this.x = x;
			this.w = w;
		}

		@Override
		public String toString() {
			return "Cord [y=" + y + ", x=" + x + ", w=" + w + "]";
		}

	}

	static boolean checked(int y, int x) {
		return x >= 0 && x < N && y >= 0 && y < N;
	}
}
