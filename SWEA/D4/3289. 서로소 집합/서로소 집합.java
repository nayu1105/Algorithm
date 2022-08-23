import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int T, N, M;
	static int[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringBuilder sb = new StringBuilder();
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			arr = new int[N + 1];

			for (int i = 0; i <= N; i++) {
				arr[i] = i;
			}

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int op = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				if (op == 0) {
					if (a < b)
						Union(a, b);
					else
						Union(b, a);
				} else {
					int ap = FindSet(a);
					int bp = FindSet(b);

					if (ap == bp)
						sb.append(1);
					else
						sb.append(0);
				}
			}

			System.out.println("#" + t + " " + sb);
		}

	}

	static int FindSet(int n) {
		if (arr[n] == n)
			return n;
		return arr[n] = FindSet(arr[n]);
	}

	static void Union(int a, int b) {
		int ap = FindSet(a);
		int bp = FindSet(b);

		arr[ap] = bp;
	}
}
