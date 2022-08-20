import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M, r, c, d, ans = 0;
	static int[][] map;
	static int[] dx = { -1, 0, 1, 0 }; // 왼쪽으로 돌거임. 0 : 좌(서) , 1 : 하(남), 2 : 우(동), 3 : 상(북)
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];

		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		map[r][c] = -1;
		ans++;
		// 입력값 0 : 북 , 1 : 동, 2: 남, 3: 서
		switch (d) {
		case 0:
			d = 3;
			break;
		case 1:
			d = 2;
			break;
		case 2:
			d = 1;
			break;
		case 3:
			d = 0;
			break;
		}
		// 탐색 방향 설정

		clean();

		System.out.println(ans);

	}

	static boolean check(int y, int x) {
		return y >= 0 && y < N && x >= 0 && x < M;
	}

	static void clean() {
		while (true) {
			int turn = 0;

			for (int i = 0; i < 4; i++) {
				
				d = (d + 1) % 4;
				int nr = r + dy[d];
				int nc = c + dx[d];

				if (map[nr][nc]!=0) {
					turn++;
					continue;
				}
					

				r = nr;
				c = nc;
				map[r][c] = -1;
				ans++;
				break;
			}

			if (turn == 4) {
				int nr = r - dy[d];
				int nc = c - dx[d];

				if(map[nr][nc] == 1)return;

				r = nr;
				c = nc;

			} // 뒤로 가기. 만약 갈수 없으며 작동 멈춤

		}
	}
}
