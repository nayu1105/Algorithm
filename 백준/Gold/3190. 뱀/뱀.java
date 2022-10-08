import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, K, L;
	static int[][] map; // 1은 뱀 위치(몸통까지), 2는 사과

	static int[] head = { 1, 1 }; // head y, x좌표
	static int[] tail = { 1, 1 }; // tail y, x좌표
	static int time = 0;
	static int d = 1; // 뱀 머리 방향
	static int len = 1; // 뱀 몸 길이

	static int[] dx = { 0, 1, 0, -1 }; // 상-우-하-좌 (시계방향)
	static int[] dy = { -1, 0, 1, 0 };

	static Queue<op> op_queue = new ArrayDeque<>(); // 명령어 담은 큐
	static Queue<Integer> queue = new ArrayDeque<>(); // 꼬리 없애기 방향 큐

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		map = new int[N + 1][N + 1]; // 0 dummy

		StringTokenizer st;
		K = Integer.parseInt(br.readLine());
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 2;
		}

		L = Integer.parseInt(br.readLine());
		for (int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			char c = st.nextToken().charAt(0);

			op_queue.offer(new op(t, c));
		}

		queue.offer(d); // 초기 머리 방향 큐에 담기 ( 꼬리 삭제를 위해 )

		map[1][1] = 1; 

        /* 게임시작 */
		dummy();

		System.out.println(time);

		// 1. 머리 한칸 움직이기
		// 2. 몸과 부딫혔는지 판단
		// 2-1. map[y][x] 가 1 이면 부딫혀서 종료
		// 2-2. map[y][x] 가 2 이면 사과 먹고 몸길이 변경
		// 2-3. map[y][x] 가 0 이면 몸길이 유지

		// 몸 길이 변경 : 꼬리 그대로
		// 몸 길이 유지 : 꼬리도 한칸 움직이기
        
        /* 주의 할 점 */
        // 몸 길이가 길어졌을 때 머리 방향이 바뀌어도 꼬리 방향은 그대로 있어야 꼬리 삭제 가능.
        // 머리를 움직일때마다 방향을 큐에 담아 기록.
        // 꼬리는 큐만 확인하며 자기 자신 삭제 및 좌표 갱신

	}

	private static void dummy() {
		while (true) {
			time++; // 시간 증가

			head[0] += dy[d];
			head[1] += dx[d];
            // 머리 좌표 갱신

			if (!check(head[0], head[1])) // 범위 체크. 벽을 넘으면 게임 종료
				return;

			if (map[head[0]][head[1]] == 1) // 몸에 부딫혔으면 게임 종료
				return;

			else if (map[head[0]][head[1]] == 2) { // 사과가 있는 경우
				map[head[0]][head[1]] = 1; // 머리 이동
				len++; // 몸 길이 늘리기
			}

			else if (map[head[0]][head[1]] == 0) {
				map[head[0]][head[1]] = 1; // 머리 이동
				int dir = queue.poll(); // 큐에 담긴 꼬리방향 꺼내기
				map[tail[0]][tail[1]] = 0; // 꼬리 삭제
				tail[0] += dy[dir]; // 꼬리 좌표 갱신
				tail[1] += dx[dir];
			}

			if (!op_queue.isEmpty()) { // 명령어 유무 확인
				if (time == op_queue.peek().time) { // 명령어 실행시간 확인
					if (op_queue.poll().dir == 'L') { // 꺼내서 방향 갱신
						d--; //시계 반대 방향
						if (d == -1) // 범위체크
							d = 3;
					} else {
						d++; //시계방향
						if (d == 4) // 범위체크
							d = 0;
					}
				}
			}

			queue.offer(d); // 현재의 머리 방향 기록 (나중에 꼬리 삭제에 쓰일)

		}
	}

	private static boolean check(int y, int x) { // 범위 체크 함수
		return y >= 1 && y <= N && x >= 1 && x <= N;
	}

	static class op { // operation. 명령어
		int time; // 명령어 실행 시간
		char dir; // 방향

		public op(int time, char dir) {
			super();
			this.time = time;
			this.dir = dir;
		}

	}
}
