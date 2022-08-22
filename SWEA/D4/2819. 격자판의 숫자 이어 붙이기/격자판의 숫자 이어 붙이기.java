import java.util.Scanner;
import java.util.TreeSet;

// 문자열 중복 제거 >> set
// Hashset >> 중복제거!!! 
public class Solution {
	static int T;
	static int N = 4;
	static int[][] map;
	static int[] dr = { 1, 0, -1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	static TreeSet<String> ts;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			map = new int[N][N];
			ts = new TreeSet<>();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			// 로직
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					npr(i, j, 0, new int[] { map[i][j], 0, 0, 0, 0, 0, 0 });
				}
			}

			System.out.println("#" + t + " " + ts.size());
		}
	}

	private static void npr(int r, int c, int cnt, int[] ls) {
		if (cnt == 7) {
			String s = "";
			for (int i = 0; i < ls.length; i++) {
				s += ls[i];
			}

			ts.add(s);

			return;
		}

		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];

			if (!check(nr, nc))
				continue;

			ls[cnt] = map[nr][nc];
			npr(nr, nc, cnt + 1, ls);
		}

	}

	private static boolean check(int y, int x) {
		return y >= 0 && y < N && x >= 0 && x < N;
	}

}
