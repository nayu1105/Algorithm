import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, F;
	static int[][] map;

	static Node taxi;
	static Node[] list;

	static int[] dy = { 0, 0, 1, -1 };
	static int[] dx = { 1, -1, 0, 0 };

	static int D;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		F = Integer.parseInt(st.nextToken());

		map = new int[N + 1][N + 1]; // 0 dummy

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken()) - 2;
			}
		}

		st = new StringTokenizer(br.readLine());
		taxi = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

		list = new Node[M];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int sy = Integer.parseInt(st.nextToken());
			int sx = Integer.parseInt(st.nextToken());
			int ey = Integer.parseInt(st.nextToken());
			int ex = Integer.parseInt(st.nextToken());

			map[sy][sx] = i;

			list[i] = new Node(ey, ex);
		}

		if (simul())
			System.out.println(F);
		else
			System.out.println(-1);

	}

	static boolean simul() {
		int cnt = 0;
		while (true) {
			PriorityQueue<Node> guest = searchGuest(taxi);

			Node G = guest.poll();
			if (G == null)
				break;
			cnt++;
			if (!moveguest(G))
				return false;
			map[G.y][G.x] = -2;
			taxi.y = list[G.s].y;
			taxi.x = list[G.s].x;
		}
		if (cnt == M)
			return true;
		else
			return false;
	}

	static PriorityQueue<Node> searchGuest(Node t) {
		boolean[][] visit = new boolean[N + 1][N + 1]; // 0 dummy
		Queue<Node> queue = new ArrayDeque<>();
		PriorityQueue<Node> pq = new PriorityQueue<>((p1, p2) -> p1.y == p2.y ? p1.x - p2.x : p1.y - p2.y);

		visit[t.y][t.x] = true;
		queue.offer(t);

		D = 0; // distance

		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				Node temp = queue.poll();
				if (map[temp.y][temp.x] != -1 && map[temp.y][temp.x] != -2) { // 벽도 아니고 빈칸도 아님 >> 손님 만남
					temp.s = map[temp.y][temp.x];
					pq.offer(temp);
				} else {
					for (int j = 0; j < 4; j++) {
						int ny = temp.y + dy[j];
						int nx = temp.x + dx[j];

						if (!check(ny, nx))
							continue;

						if (map[ny][nx] != -1 && !visit[ny][nx]) {
							queue.offer(new Node(ny, nx));
							visit[ny][nx] = true;
						}
					}
				}
			}

			if (!pq.isEmpty())
				break;
			D++;
		}

		return pq;
	}

	static boolean searchDestination(Node guest) {
		boolean[][] visit = new boolean[N + 1][N + 1]; // 0 dummy
		Queue<Node> queue = new ArrayDeque<>();
		visit[guest.y][guest.x] = true;
		queue.offer(guest);
		D = 0; // distance

		int gy = list[guest.s].y;
		int gx = list[guest.s].x;

		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				Node temp = queue.poll();
				if (temp.y == gy && temp.x == gx) { // 목적지 도착
					return true;
				} else {
					for (int j = 0; j < 4; j++) {
						int ny = temp.y + dy[j];
						int nx = temp.x + dx[j];

						if (!check(ny, nx))
							continue;

						if (map[ny][nx] != -1 && !visit[ny][nx]) {
							queue.offer(new Node(ny, nx));
							visit[ny][nx] = true;
						}
					}
				}
			}
			D++;
		}

		return false;

	}

	private static boolean check(int y, int x) {
		return y > 0 && y <= N && x > 0 && x <= N;
	}

	static boolean moveguest(Node node) { // distance 빼고, 손님 위치에서 dfs 다시. destination 도착하면 연료 *2 채우고 못가면 실패
		F -= D;
		if (F < 0)
			return false;

		if (searchDestination(node)) {
			F -= D;
			if (F < 0)
				return false;
			F += D * 2;
			return true;
		} else
			return false;
	}

	static class Guest {
		Node destination;
	}

	static class Node {
		int y, x;
		int s;

		public Node() {
		}

		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}

		@Override
		public String toString() {
			return "Node [y=" + y + ", x=" + x + ", s=" + s + "]";
		}

	}
}
