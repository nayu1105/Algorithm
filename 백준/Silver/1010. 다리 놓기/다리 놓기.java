import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int T, N, M;
	static int[][] dp = new int[30][30];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			sb.append(combi(M, N)).append("\n");

		}
		System.out.println(sb);
	}

	static int combi(int n, int r) {
		if (dp[n][r] > 0) {
			return dp[n][r];
		}

		// nC0 or nCn =1
		if (n == r || r == 0) {
			return dp[n][r] = 1;
		}

		return dp[n][r] = combi(n - 1, r - 1) + combi(n - 1, r);
	}
}