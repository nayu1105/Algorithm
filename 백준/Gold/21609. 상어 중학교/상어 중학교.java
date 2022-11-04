import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
	static int[][] map;
	static int N, M;

	static final int BLANK = 9;
	static int score = 0;

	static int[] dy = { 0, 0, 1, -1 };
	static int[] dx = { 1, -1, 0, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		simul();

		System.out.println(score);
	}

	static void simul() {
		// #1. 가장 큰 블록 찾아서 삭제

		while (searchBigGroup()) {
			gravity();
			rotation();
			gravity();
		}
	}

	static boolean searchBigGroup() {
		Block max = new Block();
		boolean[][] visit = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visit[i][j] && map[i][j] != BLANK && map[i][j] != -1 && map[i][j] != 0) {
					Block temp = dfs(visit, new Node(i, j));
					if (temp == null)
						continue;
					if (temp.list.size() > max.list.size())
						max = temp;
					else if (temp.list.size() == max.list.size()) {
						if (temp.rainbow.size() > max.rainbow.size())
							max = temp;
						else if (temp.rainbow.size() == max.rainbow.size()) {
							if (max.standard == null) {
								max = temp;
							} else if (temp.standard.y > max.standard.y) {
								max = temp;
							} else if (temp.standard.y == max.standard.y) {
								if (temp.standard.x > max.standard.x) {
									max = temp;
								}
							}
						}
					}
				}
			}
		}

		if (max.list.size() == 0)
			return false;

		deleteBlock(max.list);
		return true;

	}

	static void rotation() {
		int[][] nmap = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				nmap[i][j] = map[j][N - 1 - i];
			}
		}
		map = nmap;
	}

	static void gravity() {
		for (int i = 0; i < N; i++) {
			for (int j = N - 1; j > 0; j--) {
				if (map[j][i] == BLANK) {
					// 중력 시작
					int temp = j;
					while (temp >= 0 && map[temp][i] == BLANK) {
						temp--;
					}
					if (temp == -1)
						continue;
					if (map[temp][i] == -1)
						continue;

					map[j][i] = map[temp][i];
					map[temp][i] = BLANK;
				}
			}
		}
	}

	static void deleteBlock(List<Node> list) {
		score += list.size() * list.size();
		for (Node node : list) {
			map[node.y][node.x] = BLANK;
		}
	}

	static Block dfs(boolean[][] visit, Node node) {
		// dfs 준비
		Queue<Node> queue = new ArrayDeque<>();

		Block block = new Block(node);

		queue.offer(node);
		visit[node.y][node.x] = true;
		block.list.add(node);
		int color = map[node.y][node.x];

		while (!queue.isEmpty()) {
			Node temp = queue.poll();
			for (int i = 0; i < 4; i++) {
				int ny = temp.y + dy[i];
				int nx = temp.x + dx[i];

				if (!check(ny, nx))
					continue;

				if (visit[ny][nx])
					continue;

				if (map[ny][nx] == color || map[ny][nx] == 0) { // 같은 블록 그룹
					Node nNode = new Node(ny, nx);
					if (map[ny][nx] == 0) {
						block.rainbow.add(nNode);
					}
					queue.offer(nNode);
					visit[ny][nx] = true;
					block.list.add(nNode);
				}
			}
		}

		if (block.list.size() < 2)
			return null;

		for (Node rb : block.rainbow) {
			visit[rb.y][rb.x] = false;
		}

		return block;

	}

	private static boolean check(int y, int x) {
		return y >= 0 && y < N && x >= 0 && x < N;
	}

	static class Block {
		List<Node> list = new ArrayList<>();
		List<Node> rainbow = new ArrayList<>();
		Node standard = null;

		public Block() {
		};

		public Block(Node standard) {
			this.standard = standard;
		};

		@Override
		public String toString() {
			return "Block [list=" + list + "]";
		};

	}

	static class Node {
		int y, x;

		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}

		@Override
		public String toString() {
			return "Node [y=" + y + ", x=" + x + "]";
		}

	}
}
