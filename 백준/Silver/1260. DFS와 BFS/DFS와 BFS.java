package algorithm_assignments;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

//이차원 배열, 인접 행렬
public class bj_1260_DFS와BFS {
	static int N, M, V;
	static boolean[] visited;
	static boolean[][] map;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());

		map = new boolean[N + 1][N + 1];
		visited = new boolean[N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			map[from][to] = true;
			map[to][from] = true;
		} 

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
		for (int i = 1; i <= N; i++) {
			if (map[n][i] == true && !visited[i]) {
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

			for (int i = 1; i <= N; i++) {
				if (map[temp][i] == true && !visited[i]) {
					visited[i] = true;
					q.offer(i);
				}
			}
		}
	}
}
