import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int F, S, G, U, D;
	static int cnt;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		F = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		U = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		if (dfs()) {
			System.out.println("use the stairs");
		} else {
			System.out.println(cnt);
		}

	}

	static boolean dfs() {
		Queue<Integer> queue = new ArrayDeque<>();
		boolean[] visit = new boolean[1000001];
		queue.add(S);
		cnt = 0;
		boolean flag = true;

		while (!queue.isEmpty() && flag) {
			int size = queue.size();

			for (int i = 0; i < size; i++) {
				int floor = queue.poll();

				if (floor == G)
					flag = false;
				visit[floor] = true;
				if (floor + U <= F && !visit[floor + U]) {
					queue.offer(floor + U);
					visit[floor + U] = true;
				}

				if (floor - D >= 1 && !visit[floor - D]) {
					queue.offer(floor - D);
					visit[floor - D] = true;
				}
			}
			if (!flag)
				break;
			cnt++;
		}

		return flag;

	}
}
