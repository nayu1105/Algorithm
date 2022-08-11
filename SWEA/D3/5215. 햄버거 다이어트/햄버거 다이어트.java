import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static int T, N, L;
	static int[][] arr;
	static int[][] food;
	static int max;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());

			arr = new int[N + 1][L + 1];
			food = new int[N][2];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				food[i][0] = Integer.parseInt(st.nextToken());
				food[i][1] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(food, (o1, o2) -> o1[1] - o2[1]); // 무게순으로 sort

			for (int i = 1; i <= N; i++) {
				int v = food[i - 1][0]; // 가치
				int w = food[i - 1][1]; // 칼로리
				for (int j = food[0][1]; j <= L; j++) {
					if (w < j)
						arr[i][j] = Math.max(arr[i-1][j], arr[i - 1][j - w] + v);
					else
						arr[i][j] = arr[i-1][j];
				}
			}

			System.out.println("#" + t + " " + arr[N][L]);
		}
	}
}
