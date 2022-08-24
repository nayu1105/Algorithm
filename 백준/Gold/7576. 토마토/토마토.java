import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, day;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static int[][] map;
	static boolean[][] visit;
	static Queue<int[]> tomato;
	static int total; // 안익은 토마토 갯수

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		visit = new boolean[N][M];
		tomato = new ArrayDeque<>();
		total = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int n = Integer.parseInt(st.nextToken());
				map[i][j] = n;
				if (n == 1) {
					visit[i][j] = true;
					tomato.offer(new int[] { i, j }); // 익은 토마토 큐에 삽입
				}
				if (n == 0)
					total++; // 안익은 토마토 갯수
			}
		}

		bfs();

		System.out.println(day);
	}

	static void bfs() {
		day = 0;
		while (!tomato.isEmpty()) { // 현재 익은 토마토들
			int size = tomato.size(); // 같은 날에 익었던 토마토들
			for (int i = 0; i < size; i++) {
				int[] n = tomato.poll();

				for (int j = 0; j < 4; j++) {
					int ny = n[0] + dy[j];
					int nx = n[1] + dx[j];

					if (!check(ny, nx)) // map 범위 체크
						continue;

					if (!visit[ny][nx] && map[ny][nx] == 0) {
						tomato.offer(new int[] { ny, nx });
						total--; // 안익은 토마토 갯수 차감
						visit[ny][nx] = true;
					}
				}
			}
			day++;
		}

		if (total != 0)
			day = -1; // 빈칸이 있는 경우 -1 출력
		else
			day--; // 마지막 탐색에서 토마토를 못찾아도 day++ 되기 때문에 하나 빼주기

	}

	static boolean check(int y, int x) {
		return y >= 0 && y < N && x >= 0 && x < M;
	}
}
