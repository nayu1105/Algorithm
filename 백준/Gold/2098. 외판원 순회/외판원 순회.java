import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, allMask, INF = 987654321; // INFINITE 충분히 큰수 저장
	static int[][] W;
	static int[][] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		W = new int[N][N];
		allMask = (1 << N) - 1; // 5개 도시 1<<5 -1 : 100000 -1 : 11111
		dp = new int[N][allMask];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				W[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		System.out.println(tsp(0, 1)); // 0 번째 도시 0000...1

	}

	static int tsp(int x, int mask) {
		// 기저조건
		if (mask == allMask) {
			if (W[x][0] == 0)
				return INF;
			else
				return W[x][0];
		}

		// 이미 계산된 dp가 있으면 그걸 return
		if (dp[x][mask] != 0)
			return dp[x][mask];

		// 이미 계산된 dp가 없으면 따진다.
		dp[x][mask] = INF; // 충분히 큰 값으로 초기화

		// x로부터 갈 수 있는 남은 도시를 탐색
		for (int i = 0; i < N; i++) {
			// 경로가 없거나, 또는 이미 방문했으면 skip
			if (W[x][i] == 0 || (mask & (1 << i)) != 0)
				continue;

			dp[x][mask] = Math.min(dp[x][mask], tsp(i, mask | 1 << i) + W[x][i]);

		}

		return dp[x][mask];

	}
}