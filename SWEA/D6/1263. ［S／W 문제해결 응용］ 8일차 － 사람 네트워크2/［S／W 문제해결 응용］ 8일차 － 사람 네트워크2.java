import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int T, N;
	static final int BIG = 999999;
	static int[][] matrix; // <- dp

	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {

			StringTokenizer st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			matrix = new int[N][N];
			// 입력으로부터 인접행렬 완성
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int n = Integer.parseInt(st.nextToken());
					if (n == 0 && i != j)
						matrix[i][j] = BIG;
					else
						matrix[i][j] = n;
				}
			}

			for (int k = 0; k < N; k++) {
				for (int i = 0; i < N; i++) {
					if (i != k) {
						for (int j = 0; j < N; j++) {
							if (i != j && j != k) {
								if (matrix[i][k] != BIG && matrix[k][j] != BIG) {
									matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
								}
							}
						}
					}
				}
			}
			int min = Integer.MAX_VALUE;

			for (int i = 0; i < N; i++) {
				int temp = 0;
				for (int j = 0; j < N; j++) {
					if (matrix[i][j] != BIG)
						temp += matrix[i][j];
				}
				min = Math.min(min, temp);
			}

			sb.append("#").append(t).append(" ").append(min).append("\n");

		}
		System.out.println(sb);

	}
}
