import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
	static int T, N, M;
	static int[][] height;
	static ArrayList<ArrayList<Integer>> list;
	static boolean[] visit; // dfs 쓸 visit
	static int cnt;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());

			height = new int[N + 1][2]; // 0 dummy
			// 키 : 자기보다 작은 사람 수[0] 자기보다 큰 사람 수 [1]

			list = new ArrayList<>();
			for (int i = 0; i <= N; i++) {
				list.add(new ArrayList<>());
			}
			// 인접 리스트 초기화. 0은 dummy

			for (int i = 1; i <= M; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				list.get(a).add(b);
			}

			for (int i = 1; i <= N; i++) {
				cnt = 0;
				visit = new boolean[N + 1]; // 0 dummy
				dfs(i);
				height[i][1] = cnt; // dfs 하며 얻은 부모 수
			}

			int ans = 0;
			for (int i = 1; i <= N; i++) {
				int sum = 0;
				for (int j = 0; j < 2; j++) {
					sum += height[i][j];
				}
				if (sum == N - 1)
					ans++;
			}

			System.out.println("#" + t + " " + ans);
		}
	}

	private static void dfs(int idx) {
		int size = list.get(idx).size();
		for (int i = 0; i < size; i++) {
			int n = list.get(idx).get(i);

			if (visit[n])
				continue; // 이미 방문한 노드

			cnt++; // 부모 수 추가
			height[n][0]++; // n의 자식수 추가
			visit[n] = true;
			dfs(n);

		}
	}
}
