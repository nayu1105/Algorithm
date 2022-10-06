import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int T, N;
	static List<Node> list;
	static boolean[][] visit;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());
			StringTokenizer st;

			visit = new boolean[N + 2][N + 2];

			list = new ArrayList<Node>();
			for (int i = 0; i < N + 2; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				list.add(new Node(x, y));
			}

			// 방문 가능 체크

			for (int i = 0; i < N + 2; i++) {
				for (int j = 0; j < N + 2; j++) {
					if ((Math.abs(list.get(i).x - list.get(j).x) + Math.abs(list.get(i).y - list.get(j).y)) <= 1000)
						visit[i][j] = true;
				}
			}

			// 플로이드 알고리즘으로 도착지까지 방문가능한지 체크

			floyd();

			if (visit[0][N + 1]) {
				System.out.println("happy");
			} else {
				System.out.println("sad");
			}
		}
	}

	private static void floyd() {
		for (int k = 0; k < N + 2; k++) {
			for (int i = 0; i < N + 2; i++) {
				if (k == i)
					continue;
				for (int j = 0; j < N + 2; j++) {
					if (i == j || j == k)
						continue;
					if (visit[i][k] && visit[k][j])
						visit[i][j] = true;
				}
			}
		}
	}

	static class Node {
		int x, y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + "]";
		}

	}
}
