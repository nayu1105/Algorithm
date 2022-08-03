package algorithm_assignments;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class crops_sw_2805 {
	static int[][] crops;
	static int size;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			int ans = 0;

			int N = Integer.parseInt(br.readLine());

			crops = new int[N][N];

			

			for (int i = 0; i < N; i++) {
				char[] temp = br.readLine().toCharArray();
				for (int j = 0; j < N; j++) {
					crops[i][j] = temp[j]-'0';
				}
			}

			int x = N / 2;
			size = 1;
			boolean flag = false;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < size; j++) {
					ans += crops[i][x + j];
				}
				if (size == N)
					flag = true;

				if (flag) {
					size -= 2;
					x++;
				} else {
					size += 2;
					x--;
				}
			}
			
			System.out.println("#"+t+" " + ans);
		}

	}
}
