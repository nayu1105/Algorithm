import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int T, N, X;
	static int[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			map = new int[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int ans = 0;

			for (int i = 0; i < N; i++) {
				int temp = map[i][0];
				int cnt = 1;
				boolean check = true;
				int flag = 0; // 0 : 직선, 1:올라가는 길, -1: 내려가는 길
				for (int j = 1; j < N; j++) {
					if (map[i][j] == temp) {
						cnt++;
						if (flag == -1) {
							if (cnt >= X) {
								flag = 0;
								cnt = 0;
							}
						}
					} else if (map[i][j] - temp == 1 && flag != -1) {
						if (cnt >= X) {
							cnt = 1;
						} else {
							check = false;
							break;
						}
					} else if (map[i][j] - temp == -1 && flag != -1) {
						if (flag == -1) {
							check = false;
							break;
						}
						cnt = 1;
						flag = -1;
					} else {
						check = false;
						break;
					}
					temp = map[i][j];
				}

				if (check == true && flag == -1 && cnt < X)
					check = false;

				if (check)
					ans++;
			}
			// 가로 탐색

			for (int j = 0; j < N; j++) {
				int temp = map[0][j];
				int cnt = 1;
				boolean check = true;
				int flag = 0; // 0 : 직선, 1:올라가는 길, -1: 내려가는 길
				for (int i = 1; i < N; i++) {
					if (map[i][j] == temp) {
						cnt++;
						if (flag == -1) {
							if (cnt >= X) {
								flag = 0;
								cnt = 0;
							}
						}
					} else if (map[i][j] - temp == 1 && flag != -1) {
						if (cnt >= X) {
							cnt = 1;
						} else {
							check = false;
							break;
						}
					} else if (map[i][j] - temp == -1 && flag != -1) {
						cnt = 1;
						flag = -1;
					} else {
						check = false;
						break;
					}
					temp = map[i][j];
				}

				if (check == true && flag == -1 && cnt < X)
					check = false;

				if (check)
					ans++;
			}
			// 세로 탐색

			System.out.println("#" + t + " " + ans);
		}

	}
}
