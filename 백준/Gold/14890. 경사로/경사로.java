import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, L;
	static int[][] map1, map2;
	static int ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());

		map1 = new int[N][N];
		map2 = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map2[j][i] = map1[i][j] = Integer.parseInt(st.nextToken());

			}
		}

		simul(map1);
		simul(map2);

		System.out.println(ans);

	}

	private static void simul(int[][] map) {
		for (int i = 0; i < N; i++) {
			boolean ch = true;
			int pre, temp;
			int cnt = 1;
			int flag = 0;
			for (int j = 1; j < N; j++) {
				pre = map[i][j - 1];
				temp = map[i][j];

				if (pre - temp == 1 && flag == 0) {
					cnt = 1;
					flag = 1;
				} else if (pre - temp == -1) {
					if (cnt >= L) {
						cnt = 1;
						flag = 0;
					} else {
						ch = false;
						break;
					}
				} else if (pre == temp) {
					cnt++;
				} else {
					ch = false;
					break;
				}

				if (cnt == L && flag != 0) {
					cnt = 0;
					flag = 0;
				}
			}

			if (flag == 1 && cnt < L)
				ch = false;
			if (ch)
				ans++;
		}
	}
}
