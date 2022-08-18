import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// 인접 리스트
public class Main {
	static int N, M, V;
	static boolean[] visited;
	static ArrayList<List<Integer>> list = new ArrayList<>();
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());

		visited = new boolean[N + 1];

		for (int i = 0; i <= N; i++) {
			List<Integer> l = new ArrayList<>(Collections.emptyList());
			list.add(l);
		}
    //인접 리스트 초기화

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			list.get(from).add(to);
			list.get(to).add(from);
		}

		for (int i = 1; i <= N; i++) {
			Collections.sort(list.get(i));
		}
    //작은 수 부터 뜨도록 정렬

		Arrays.fill(visited, false);
		dfs(V);
		sb.append("\n");

		Arrays.fill(visited, false);
		bfs(V);

		System.out.println(sb);

	}

	static void dfs(int n) {
		visited[n] = true;
		sb.append(n).append(" ");
		for (int i : list.get(n)) {
			if (!visited[i]) {
				dfs(i);
			}
		}
	}

	static void bfs(int n) {
		Queue<Integer> q = new ArrayDeque<Integer>();

		q.offer(n);
		visited[n] = true;

		while (!q.isEmpty()) {
			int temp = q.poll();
			sb.append(temp).append(" ");

			for (int i : list.get(temp)) {
				if (!visited[i]) {
					visited[i] = true;
					q.offer(i);
				}
			}
		}
	}
}
