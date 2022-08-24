import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int R, C, ans;
	static char[][] map;
	static int[] dy = { 0, 1, 0, -1 };
	static int[] dx = { 1, 0, -1, 0 };
	static Queue<Node> water = new ArrayDeque<>();
	static boolean[][] wm, dm;
	static Queue<Node> dochi = new ArrayDeque<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];
		wm = new boolean[R][C];
		dm = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			char[] c = br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				char cc = c[j];
				map[i][j] = cc;
				if (cc == 'S') {
					dochi.add(new Node(i, j));
				}
				if (cc == '*') {
					water.add(new Node(i, j));
					wm[i][j] = true;
				}
			}
		}

		flood();
		if (ans == 0)
			System.out.println("KAKTUS");
		else
			System.out.println(ans);
	}

	static class Node {
		int y, x;

		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	static void flood() { // water bfs 후 dochi bfs 반복
		int d = 0;
		while (!dochi.isEmpty() && ans == 0) {
			int w_size = water.size();
			for (int i = 0; i < w_size; i++) {
				Node n = water.poll();

				for (int j = 0; j < 4; j++) {
					int nx = n.x + dx[j];
					int ny = n.y + dy[j];

					if (!check(ny, nx))
						continue;

					if (map[ny][nx] != 'X' && map[ny][nx] != 'D' && !wm[ny][nx]) {
						map[ny][nx] = '*';
						wm[ny][nx] = true;
						water.offer(new Node(ny, nx));
					}

				}
			}
			d++;
			int d_size = dochi.size();
			for (int i = 0; i < d_size && ans == 0; i++) {
				Node n = dochi.poll();

				for (int j = 0; j < 4; j++) {
					int nx = n.x + dx[j];
					int ny = n.y + dy[j];

					if (!check(ny, nx))
						continue;

					if (map[ny][nx] == 'D') {
						ans = d;
						break;
					}

					if (map[ny][nx] == '.' && !dm[ny][nx]) {
						map[ny][nx] = 'S';
						dm[ny][nx] = true;
						dochi.offer(new Node(ny, nx));
					}
				}
			}

		}
	}

	static boolean check(int y, int x) {
		return y >= 0 && y < R && x >= 0 && x < C;
	}
}
