import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static boolean visit[];
	static int parent[];
	static int child[];
	static List<List<Integer>> list = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		child = new int[N + 1];
		parent = new int[N + 1];
		for (int i = 0; i <= N; i++) { // 0 dummy
			list.add(new ArrayList<>());
		}

		for (int i = 1; i <= M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list.get(a).add(b);
		}

		for (int i = 1; i <= N; i++) {
			visit = new boolean[N + 1];
			dfs(i);
		}

		for (int i = 1; i <= N; i++) {
			System.out.println((N - parent[i] - child[i] - 1));
		}

	}

	private static void dfs(int i) {
		Queue<Integer> queue = new ArrayDeque<>();

		queue.add(i);
		int cnt = 0;

		while (!queue.isEmpty()) {
			int n = queue.poll();
			List<Integer> parent = list.get(n);
			for (int j = 0; j < parent.size(); j++) {
				int p = parent.get(j);
				if (!visit[p]) {
					queue.add(p);
					visit[p] = true;
					cnt++;
					child[p]++;
				}
			}
		}

		parent[i] = cnt;
	}
}
