import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;

public class Main {
	static int[][] map = new int[9][9];
	static ArrayList<int[]> list = new ArrayList<>();
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 9; i++) {
			char[] c = br.readLine().toCharArray();
			for (int j = 0; j < 9; j++) {
				map[i][j] = c[j] - '0';
				if (map[i][j] == 0) {
					list.add(new int[] { i, j });
				}
			}
		}

		go(list.get(0)[0], list.get(0)[1], 0);

		print();

	}

	private static void print() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				sb.append(map[i][j]);
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}

	private static boolean go(int y, int x, int idx) {
		if (idx == list.size() - 1) {
			for (int i = 0; i < 9; i++) {
				if (check(y, x, i)) {
					map[y][x] = i;
					return true;
				}
			}
			return false;
		}
		for (int i = 1; i <= 9; i++) {
			if (!check(y, x, i))
				continue;

			map[y][x] = i;
			int ny = list.get(idx + 1)[0];
			int nx = list.get(idx + 1)[1];
			if(go(ny, nx, idx + 1))return true;
			map[y][x] = 0;

		}
		return false;
	}

	private static boolean check(int y, int x, int v) {
		HashSet<Integer> set = new HashSet<>();
		for (int i = 0; i < 9; i++) { // 가로
			set.add(map[i][x]);
		}
		if (set.contains(v))
			return false;

		set.clear();
		for (int i = 0; i < 9; i++) { // 세로
			set.add(map[y][i]);
		}
		if (set.contains(v))
			return false;

		set.clear();
		for (int i = (y / 3) * 3; i < (y / 3) * 3 + 3; i++) { // 3*3
			for (int j = (x / 3) * 3; j < (x / 3) * 3 + 3; j++) {
				set.add(map[i][j]);
			}
		}
		if (set.contains(v))
			return false;
		else
			return true;
	}

}
