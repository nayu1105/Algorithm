package algorithm_assignments;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ladder_sw_1210 {
	static int gx, gy; // goal_x, goal_y;
	static int[] dx = { 0, 0, -1 }; // goal 부터 출발점을 향해 탐색할 방향 : 오른쪽, 왼쪽, 위쪽
	static int[] dy = { 1, -1, 0 };

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= 10; t++) {
			br.readLine();

			int[][] arr = new int[100][100];

			for (int i = 0; i < 100; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 100; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					if (arr[i][j] == 2) {
						gx = i;
						gy = j;
					}
				}
			}

			int x = gx, y = gy; // 현재 위치
			int direction = 2;

			while (true) {

				if (direction == 2) { // 바라보는 방향이 위일 경우 좌우로 갈 수 있는 지 탐색
					for (int j = 0; j < 2; j++) { // 좌우 탐색
						int nx = x + dx[j];
						int ny = y + dy[j];
						if (nx >= 0 && nx < 100 && ny >= 0 && ny < 100) {
							if (arr[x + dx[j]][y + dy[j]] == 1) { // 갈수 있다면 방향 바꾸고 for문 break;
								direction = j;
								break;
							}
						}
					}
					if (x < 0)
						break; // 지도 끝이면 break; 해서 출력하러 가기
					x += dx[direction]; // 바라보는 방향으로 한칸 이동
					y += dy[direction];

				} else { // 가로 방향일 경우( 좌우 상관없음)
					int nx = x + dx[2]; // 위쪽 탐색
					int ny = y + dy[2];

					if (nx >= 0 && nx < 100 && ny >= 0 && ny < 100) {
						if (arr[nx][ny] != 0) // 위로 갈 수 있다면 방향 전환
							direction = 2;

						x += dx[direction]; // 바라보는 방향으로 한칸 이동
						y += dy[direction];

					}
				}

			}

			System.out.println("#" + t + " " + y);

		}
	}
}
