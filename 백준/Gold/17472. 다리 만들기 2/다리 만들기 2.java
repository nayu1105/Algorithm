import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[][] map;
	static int[][] cost;

	// makeMap
	static int island = 1;
	static Queue<Node> queue = new ArrayDeque<>();
	static boolean[][] visit;

	// prim
	static PriorityQueue<Edge> pq = new PriorityQueue<>((e1, e2) -> e1.w - e2.w);
	static boolean[] select;
	static int min = 0;

	static int[] dy = { 0, 0, 1, -1 }; // 우 - 좌 - 하 - 상
	static int[] dx = { 1, -1, 0, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		visit = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// makeMap

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1 && !visit[i][j]) {
					visit[i][j] = true;
					map[i][j] = island;
					queue.offer(new Node(i, j));
					bfs();
				}
			}
		}

		// makeBridge & cost
		makeBridge();

		// prim
		if (prim())
			System.out.println(min);
		else
			System.out.println(-1);

		// 1. dfs 섬 갯수만큼 1,2,3,... map에 체크해놓기
		// 2. map 탐색하며 바다가 아닌 경우(!=0) 다리 놓기 시작
		// 4. 다리 건설 비용 cost[][]에 기록
		// 5. 계산된 모든 비용으로 mst 계산하기 (prim 사용)
		// 6. 연결되었으면 비용합 출력, 안되면 -1 출력

	}

	private static boolean prim() {
		select = new boolean[island];
		for (int i = 2; i < island; i++) { // 0은 dummy 1은 자기 자신이기에 X
			if (cost[1][i] != Integer.MAX_VALUE) {
				pq.add(new Edge(i, cost[1][i]));
			}
		} // pq 초기화

		select[1] = true;
		int cntSelected = 1;

		while (cntSelected != island - 1) {

			Edge edge = null;
			while (!pq.isEmpty()) { // 선택 안된 섬의 최소 비용 edge 선택
				edge = pq.poll();
				if (select[edge.v])
					continue; // select 한 edge는 제외
				break;
			}
			if (edge == null)
				break;

			if (select[edge.v]) // edge 선택 X
				break;

			select[edge.v] = true;
			min += edge.w;
			for (int i = 1; i < island; i++) {
				if (cost[edge.v][i] != Integer.MAX_VALUE) {
					pq.add(new Edge(i, cost[edge.v][i]));
				}
			}

			cntSelected++;

		}

		if (cntSelected == island - 1)
			return true;
		else
			return false;

	}

	private static void makeBridge() {

		cost = new int[island][island];// 0 dummy. island는 총 섬 갯수 + 1 이 되어있기때문에.
		for (int i = 0; i < island; i++) {
			Arrays.fill(cost[i], Integer.MAX_VALUE);
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != 0) {
					dfs(new Node(i, j), map[i][j]);
				}
			}
		}
	}

	private static void dfs(Node node, int num) {
		for (int i = 0; i < 4; i++) { // 4방 dfs 탐색
			int ny = node.y;
			int nx = node.x;
			int d = 0;
			while (true) {
				ny += dy[i]; // 탐색 좌표
				nx += dx[i];

				if (!check(ny, nx))
					break; // 범위 체크
				if (map[ny][nx] == num)
					break; // 자기 자신의 섬이면 break;

				if (map[ny][nx] != 0) { // 다른 섬을 만나면
					if (d < 2) // distance 2이상만 다리 건설
						break;

					cost[num][map[ny][nx]] = Math.min(cost[num][map[ny][nx]], d); // 현재 섬에서 map[ny][nx]로 가는 최소 비용 갱신
					break;
				}

				d++; // distance 갱신. 0이면 계속 탐색
			}
		}
	}

	private static void bfs() {

		while (!queue.isEmpty()) {
			Node node = queue.poll();
			for (int i = 0; i < 4; i++) {
				int ny = node.y + dy[i];
				int nx = node.x + dx[i];

				if (!check(ny, nx))
					continue;

				if (visit[ny][nx])
					continue;

				if (map[ny][nx] == 1) {
					queue.add(new Node(ny, nx));
					visit[ny][nx] = true;
					map[ny][nx] = island;
				}
			}
		}

		island++;
	}

	private static boolean check(int y, int x) {
		return y >= 0 && y < N && x >= 0 && x < M;
	}

	static class Edge {
		int v, w;

		Edge(int v, int w) {
			this.v = v;
			this.w = w;
		}

		@Override
		public String toString() {
			return "Edge [v=" + v + ", w=" + w + "]";
		}

	}

	static class Node {
		int y, x;

		Node(int y, int x) {
			this.y = y;
			this.x = x;
		}

		@Override
		public String toString() {
			return "Node [y=" + y + ", x=" + x + "]";
		}

	}

}
