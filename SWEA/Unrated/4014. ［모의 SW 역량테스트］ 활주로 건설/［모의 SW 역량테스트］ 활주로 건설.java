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
				int flag = 0; // 0 : 직선, -1: 내려가는 길
				for (int j = 1; j < N; j++) {
					if (map[i][j] == temp) {
						cnt++;
						if (flag == -1) { // 내려가는 활주로 건설 시 지금까지 cnt로 건설 가능 여부 판단
							if (cnt >= X) { // 가능하다면 flag 변경, cnt 초기화
								flag = 0;
								cnt = 0;
							}
						}
					} else if (map[i][j] - temp == 1 && flag != -1) { // 올라가는 활주로 건설 해야 한다면 이때까지 cnt 와 비교하며 true false
																		// 결정
						if (cnt >= X) {// 활주로 건설 가능하면 자기 자신부터 다시 cnt 시작
							cnt = 1;
						} else { // 건설 불가능 하면 false 체크하고 탐색 종료
							check = false;
							break;
						}
					} else if (map[i][j] - temp == -1 && flag != -1) { // 내려가는 활주로 건설해야 한다면 지금부터 cnt 시작. 활주로 건설가능은 첫번째
																		// 이프문에서 판단.
						cnt = 1;
						flag = -1; // 자기 자신부터 cnt 시작. flag 변경
					} else { // 이 모든 경우가 아니면 건설 불가능
						check = false;
						break;
					}
					temp = map[i][j]; // 이전 값 저장
				}

				if (check == true && flag == -1 && cnt < X) // 탐색이 끝났는데도 아직 내려가는 활주로 건설 중이고 cnt가 부족하다면 false 체크
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
