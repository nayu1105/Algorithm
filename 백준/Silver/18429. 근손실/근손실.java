import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int N, K;
	static int answer = 0;

	static boolean[] check;
	static int[] health;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		health = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			health[i] = Integer.parseInt(st.nextToken());
		}

		solution(health);

		System.out.print(answer);
	}

	static public void solution(int[] health) {
		for (int i = 0; i < health.length; i++) {
			check = new boolean[health.length];
			if (500 - K + health[i] >= 500)
				dfs(i, 1, 500 - K + health[i]);
		}
	}

	static public void dfs(int index, int count, int weight) {
		if (count == health.length) {
			answer++;
			return;
		}

		check[index] = true;

		for (int i = 0; i < health.length; i++) {
			if (!check[i] && (weight - K + health[i]) >= 500)
				dfs(i, count + 1, weight - K + health[i]);
		}

		check[index] = false;

	}

}
