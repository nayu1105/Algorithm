package algorithm_assignments;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class snail_sw_1954 {
	static int T;
	static int[] dx = { 0, 1, 0, -1 }; // 우, 하, 좌, 상 순서
	static int[] dy = { 1, 0, -1, 0 };
	static int[][] snail;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			int s = Integer.parseInt(br.readLine());


			snail = new int[s][s];
			int cnt = 1;

			int d = 0; // 방향
			int x = 0, y = 0; // 현재 위치

			while (cnt <= s * s) {
				snail[x][y] = cnt; // 현재 위치에 숫자 넣기
				// 다음 방향 설정
				int nx = x + dx[d];
				int ny = y + dy[d];
				if (nx < 0 || nx >= s || ny < 0 || ny >= s || snail[nx][ny] != 0) {
					d = (d + 1) % 4;
					x = x + dx[d];
					y = y + dy[d];
				} else {
					x = nx;
					y = ny;

				}
				cnt++;
			}

			System.out.println("#" + t);
			for (int i = 0; i < s; i++) {
				for (int j = 0; j < s; j++) {
					System.out.print(snail[i][j] + " ");
				}
				System.out.println();
			}

		}

	}

}
