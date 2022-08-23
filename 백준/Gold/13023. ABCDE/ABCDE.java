import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main{
	static int N, M, ans;
	static ArrayList<ArrayList<Integer>> friend = new ArrayList<>();
	static boolean[] visit;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			friend.add(new ArrayList<Integer>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			friend.get(a).add(b);
			friend.get(b).add(a);

		}

		// 입력 끝

		for (int i = 0; i < N; i++) {
			visit = new boolean[N];
			visit[i] = true;
			if (dfs(i, 1)) {
				ans = 1;
				break;
			}
		}

		System.out.println(ans);

	}

	static boolean dfs(int i, int d) {
		if (d == 5) {
			// complete code
			return true;
		}

		boolean result = false;
		for (int f : friend.get(i)) {
			if (!visit[f]) {
				visit[f] = true;
				result = dfs(f, d + 1);
				if (result == true)
					break;
				visit[f] = false;
			}
		}

		return result;

	}
}
