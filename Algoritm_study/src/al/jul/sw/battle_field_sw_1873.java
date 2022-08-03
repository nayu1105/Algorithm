package algorithm_assignments;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class battle_field_sw_1873 {
	static int T, H, W; // test_case, 맵의 크기 세로, 가로
	static char[][] field; // 맵
	static int dir, x, y; // 바라보는 방향, 현재 전차 위치 x, y
	static int[] dx = { -1, 1, 0, 0 }; // 상, 하, 좌, 우
	static int[] dy = { 0, 0, -1, 1 };
	static char[] train = { '^', 'v', '<', '>' }; // 상, 하, 좌, 우 필드 표시 char 값

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {

			StringTokenizer st = new StringTokenizer(br.readLine());

			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());

			field = new char[H][W]; // 입력받은 필드 크기로 field 할당

			for (int i = 0; i < H; i++) {
				char[] c = br.readLine().toCharArray();
				for (int j = 0; j < W; j++) {
					field[i][j] = c[j];
					if (c[j] == '^') {
						dir = 0;
						x = i;
						y = j;
					} else if (c[j] == 'v') {
						dir = 1;
						x = i;
						y = j;
					} else if (c[j] == '<') {
						dir = 2;
						x = i;
						y = j;
					} else if (c[j] == '>') {
						dir = 3;
						x = i;
						y = j;

					}
				}
			} // field 입력받으며 x, y, dir 초기화

			int len = Integer.parseInt(br.readLine());
			char[] s = br.readLine().toCharArray();
			for (int i = 0; i < len; i++) {
				switch (s[i]) { // 입력받으며 field 변화
				case 'S':
					int nx = x; // nx, ny 포탄 위치
					int ny = y;

					while (true) { // 벽을 만나거나, 맵을 벗어날 때까지 계속 전진
						nx += dx[dir]; // 방향만큼 전진
						ny += dy[dir];

						if (nx < 0 || nx >= H || ny < 0 || ny >= W)
							break; // 맵을 벗어나면 그냥 break;
						else if (field[nx][ny] == '#' || field[nx][ny] == '*') { // 벽돌이나 강철 벽을 만나면 break;
							if (field[nx][ny] == '*') { // 벽돌 벽이면 평지로 만들고 break;
								field[nx][ny] = '.';
							}
							break;
						}
					}

					continue; // 바로 다음 입력받으러 가기

				case 'U': // shoot이 아니면 입력대로 방향 바꾸기
					dir = 0;
					break;
				case 'D':
					dir = 1;
					break;
				case 'L':
					dir = 2;
					break;
				case 'R':
					dir = 3;
					break;
				}

				int nx = x + dx[dir]; // 전진 가능한지 살펴보기
				int ny = y + dy[dir];

				if (nx >= 0 && nx < H && ny >= 0 && ny < W && field[nx][ny] == '.') { // 맵을 벗어나지 않고 평지이면 전진
					field[x][y] = '.'; // 이전 위치는 평지로
					x = nx; // 위치 이동
					y = ny;
				}
				field[x][y] = train[dir]; // 위치와 방향의 변화 field 에 표시

			}

			System.out.print("#" + t + " "); // 출력문
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					System.out.print(field[i][j]);
				}
				System.out.println();
			}
		}

	}
}
