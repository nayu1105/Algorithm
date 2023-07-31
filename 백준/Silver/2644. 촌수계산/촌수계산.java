import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int N;
	static int A, B;
	static int M;

	static List<List> list = new ArrayList<>();

	static int answer = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N + 1; i++) {
			list.add(new ArrayList<Integer>());
		}

		st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list.get(a).add(b);
			list.get(b).add(a);
		}

		if (bfs()) {
			System.out.print(answer);
		} else {
			System.out.print(-1);
		}

	}

	static public boolean bfs() {
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[N + 1];

		queue.add(A);
		visited[A] = true;

		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				int temp = queue.poll();
				if (temp == B) {
					return true;
				}
				List<Integer> temp_list = list.get(temp);
				for (int j = 0; j < temp_list.size(); j++) {
					if (!visited[temp_list.get(j)]) {
						queue.add(temp_list.get(j));
						visited[temp_list.get(j)] = true;
					}
				}
			}
			answer++;
		}

		return false;

	}

}