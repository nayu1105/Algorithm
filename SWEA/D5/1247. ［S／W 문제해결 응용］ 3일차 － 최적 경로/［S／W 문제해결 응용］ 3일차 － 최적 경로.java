import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution{
	static int T, N, min;
	static int[] company = new int[2], house = new int[2];
	static boolean[] visited;
	static ArrayList<int[]> client;
	static int[] tgt;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			tgt = new int[N];
			visited = new boolean[N];
			min = Integer.MAX_VALUE;
			StringTokenizer st = new StringTokenizer(br.readLine());

			company[0] = Integer.parseInt(st.nextToken());
			company[1] = Integer.parseInt(st.nextToken());
			house[0] = Integer.parseInt(st.nextToken());
			house[1] = Integer.parseInt(st.nextToken());

			client = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				client.add(new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) });
			}
			// 입력 끝

			Perm(0);

			System.out.println("#" + t + " " + min);

		}
	}

	static void Perm(int tgtIdx) {
		if (tgtIdx == N) {
			int sum = 0;
			sum += Math.abs(company[0] - client.get(tgt[0])[0]) + Math.abs(company[1] - client.get(tgt[0])[1]);
			for (int i = 0; i < tgtIdx - 1; i++) {
				sum += Math.abs(client.get(tgt[i])[0] - client.get(tgt[i + 1])[0])
						+ Math.abs(client.get(tgt[i])[1] - client.get(tgt[i + 1])[1]);
			}
			sum += Math.abs(client.get(tgt[tgtIdx - 1])[0] - house[0])
					+ Math.abs(client.get(tgt[tgtIdx - 1])[1] - house[1]);

			min = Math.min(min, sum);
			return;
		}

		for (int i = 0; i < N; i++) {
			if (visited[i])
				continue;
			visited[i] = true;
			tgt[tgtIdx] = i;
			Perm(tgtIdx + 1);
			visited[i] = false;
		}

	}
}
