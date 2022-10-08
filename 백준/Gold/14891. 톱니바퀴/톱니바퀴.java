import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] margnet = new int[5][8]; // margnet[0] dummy

	// 양쪽 margnet과 겹치는 톱니바퀴 idx
	static int d1 = 2; // index 2번 톱니바퀴
	static int d2 = 6; // index 6번 톱니바퀴

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 1; i <= 4; i++) {
			char[] str = br.readLine().toCharArray();
			for (int j = 0; j < 8; j++) {
				margnet[i][j] = str[j] - '0';
			}
		}

		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) { // N번 회전 수행
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken()); // 톱니바퀴 번호
			int dir = Integer.parseInt(st.nextToken()); // 회전 방향

			int[] op = new int[5]; // 0 dummy
			// 톱니바퀴 회전 방향들 기록 후 한번에 회전
			// 1 : 시계 , -1 : 반시계, 0 :회전 X

			int temp = num;
			int temp_d = dir;

			op[num] = dir;
			while (--temp >= 1) { // 왼쪽 톱니바퀴들 비교
				if (margnet[temp][d1] == margnet[temp + 1][d2])
					break; // 같은 극이면 더이상 톱니바퀴 회전 X
				temp_d *= -1; // 다른 극이면 temp+1 과 반대방향으로 회전
				op[temp] = temp_d;
			}

			temp = num;
			temp_d = dir;
			while (++temp <= 4) { // 오른쪽 톱니바퀴들 비교
				if (margnet[temp][d2] == margnet[temp - 1][d1])
					break; // 같은 극이면 더이상 톱니바퀴 회전 X
				temp_d *= -1;
				op[temp] = temp_d;
			}

			for (int j = 1; j <= 4; j++) {
				round(j, op[j]);
			}
		}

		int ans = 0;

		for (int i = 1; i <= 4; i++) {
			if (margnet[i][0] == 1)
				ans += Math.pow(2, (i - 1));
		}

		System.out.println(ans);

	}

	private static void round(int num, int dir) {
		int temp;
		if (dir == 1) {
			temp = margnet[num][7]; // 회전 마지막 톱니바퀴 저장
			for (int i = 7; i > 0; i--) {
				margnet[num][i] = margnet[num][i - 1];
			}
			margnet[num][0] = temp;
		} else if (dir == -1) {
			temp = margnet[num][0]; // 회전 마지막 톱니바퀴 저장
			for (int i = 0; i < 7; i++) {
				margnet[num][i] = margnet[num][i + 1];
			}
			margnet[num][7] = temp;
		} else
			return;

	}
}
