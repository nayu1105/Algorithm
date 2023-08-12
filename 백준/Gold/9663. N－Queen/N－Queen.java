import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int[] map;
	static int N;
	static int count = 0;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			map = new int[N];
			map[0] = i;
			dfs(1);
		}

		System.out.println(count);

	}

	static void dfs(int depth) {
		if (depth == N) {
			count++;
			return;
		}

		for (int i = 0; i < N; i++) {
			map[depth] = i;
			if (check(depth))
				dfs(depth + 1);

		}
	}

	// col 이전 퀸 배치 살펴보며 해당 col에 퀸을 놓을 수 있는지 살펴보기

	static boolean check(int col) {
		for (int i = 0; i < col; i++) {
			if (map[i] == map[col])
				return false;
			if (Math.abs(i - col) == Math.abs(map[i] - map[col]))
				return false;
		}
		return true;
	}

	static class Node {
		int y, x;

		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
}