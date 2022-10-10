import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int R, C, N;
	static char[][] map;
	static List<Stack<Node>> stack;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][];

		stack = new ArrayList<Stack<Node>>();

		for (int i = 0; i < C; i++) {
			stack.add(new Stack<Node>());
		}

		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}

		N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			int idx = Integer.parseInt(br.readLine()); // 화산탄이 떨어지는 열
			int x = idx - 1; // 가장 왼쪽이 1이기 때문에 map에서는 0번이 맨 왼쪽

			if (stack.get(x).isEmpty() && map[0][x] == '.') { // 한번도 탐색 한 적 없고, 돌을 떨어트릴 수 있으면 탐색
				stack.get(x).add(new Node(0, x));
				simulation(0, x, x);

			} else { // 가본적 있으면 빈칸 나올때까지 경로 pop()후 탐색
				Node node = null;
				while (!stack.get(x).isEmpty()) { // 돌을 넣을 수 있는 공간찾을 때까지
					node = stack.get(x).peek();
					if (map[node.y][node.x] == '.')
						break;
					stack.get(x).pop();
				}

				if (node == null)
					continue; // 스택이 비었으면 다음 명령문 실행

				simulation(node.y, node.x, x); // . 을 만났으면 그 자리에서 simulation
			}

		}

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}

	static class route {
		int col[];;
		int r;

		public route() {
			this.col = new int[30000];
			this.r = 1;
		}

	}

	static boolean check(int y, int x) { // 더 이상 갈 수 없거나 장애물이 있으면 false, 갈 수 있고 비었다면 true
		return x >= 0 && x < C && y >= 0 && y < R;
	}

	static void simulation(int y, int x, int sd) {
		while (check(y + 1, x) && map[y + 1][x] != 'X') {
			// 더 이상 갈 수 없거나 장애물이 있으면 그 자리에 굳기.
			// ===========================================//

			// 아래칸이 빈 경우
			if (map[y + 1][x] == '.') {
				stack.get(sd).add(new Node(++y, x));
			}
			// 아래가 굳은 화산탄인 경우
			else { // 현재는 y,x 위치

				// 왼쪽, 왼쪽아래 탐색, idx 0 파라미터로 주기

				if (check(y + 1, x - 1) && map[y][x - 1] == '.' && map[y + 1][x - 1] == '.') {
					// 갈 수 있다면 위치 갱신 후 continue;
					stack.get(sd).add(new Node(++y, --x));
				}
				// 오른쪽, 오른쪽아래 탐색, idx 2 파라미터로 주기
				else if (check(y + 1, x + 1) && map[y][x + 1] == '.' && map[y + 1][x + 1] == '.') {
					stack.get(sd).add(new Node(++y, ++x));
				} else
					break;

			}

		}
		map[y][x] = 'O';
	}

	static class Node {
		int y, x;

		Node() {

		}

		Node(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

}
