import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int R, C, T;
	static int[][] map;

	static int[] dy1 = { -1, 0, 1, 0 }; // 상, 우, 하, 좌 순 -> 먼지를 반대방향에 더하기 위해서
	static int[] dx1 = { 0, 1, 0, -1 };

	static int[] dy2 = { 1, 0, -1, 0 };
	static int[] dx2 = { 0, 1, 0, -1 };
	static int[][] air_cleaner = new int[2][2];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		map = new int[R][C];

		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == -1) {
					air_cleaner[0][0] = i;
					air_cleaner[0][1] = j;
					air_cleaner[1][0] = i - 1;
					air_cleaner[1][1] = j;

				}
			}
		}

		for (int t = 0; t < T; t++) {
			diffusion();
			airclean();
		}

		int ans = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] != -1)
					ans += map[i][j];
			}
		}

		System.out.println(ans);

	}

	private static void airclean() {

		int y = air_cleaner[1][0];
		int x = air_cleaner[1][1];
		// 위로 돌기
		for (int i = 0; i < 4; i++) {
			int nx = x + dx1[i];
			int ny = y + dy1[i];

			while (check(ny, nx)) {
				if (i == 2 && ny > air_cleaner[1][0])
					break;
				if (map[y][x] != -1) {
					map[y][x] = map[ny][nx];
				}
				x = nx;
				y = ny;
				nx = x + dx1[i];
				ny = y + dy1[i];
			}
		}

		map[air_cleaner[1][0]][air_cleaner[1][1] + 1] = 0;

		// 아래로 돌기

		y = air_cleaner[0][0];
		x = air_cleaner[0][1];

		for (int i = 0; i < 4; i++) {
			int nx = x + dx2[i];
			int ny = y + dy2[i];

			while (check(ny, nx)) {
				if (i == 2 && ny < air_cleaner[0][0])
					break;
				if (map[y][x] != -1) {
					map[y][x] = map[ny][nx];
				}
				x = nx;
				y = ny;
				nx = x + dx2[i];
				ny = y + dy2[i];
			}
		}

		map[air_cleaner[0][0]][air_cleaner[0][1] + 1] = 0;
	}

	private static void diffusion() {
		int[][] calc = new int[R][C];
		calc[air_cleaner[1][0]][air_cleaner[1][1]] = -1;
		calc[air_cleaner[0][0]][air_cleaner[0][1]] = -1;

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == -1 || map[i][j] == 0)
					continue;

				// 먼지가 있으면 나누기 5
				int temp = map[i][j] / 5;
				// 4방에 더하기

				for (int d = 0; d < 4; d++) {
					int ny = i + dy1[d];
					int nx = j + dx1[d];

					if (!check(ny, nx))
						continue;

					if (map[ny][nx] == -1)
						continue;

					calc[ny][nx] += temp;
					map[i][j] -= temp;
				}

				calc[i][j] += map[i][j];
			}
		}

		for (int i = 0; i < R; i++) {
			map[i] = Arrays.copyOfRange(calc[i], 0, C);
		}

	}

	static boolean check(int y, int x) {
		return y >= 0 && y < R && x >= 0 && x < C;
	}
}
