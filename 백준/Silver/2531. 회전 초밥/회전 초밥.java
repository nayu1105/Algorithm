import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, d, k, c;
	static int[] arr, visit;
	static int max = Integer.MIN_VALUE;
	static int cnt = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		arr = new int[N + k]; // 전체 초밥 순서
		visit = new int[d + 1]; // 고른 초밥 종류별 갯수
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		visit[c]++;
		cnt++;

		for (int i = 0; i < k; i++) {
			arr[N + i] = arr[i];
			if (visit[arr[i]] == 0) {
				cnt++;
			}
			visit[arr[i]]++;
		}
		// 초기화
		max = Math.max(max, cnt);

		eat();

		System.out.println(max);
	}

	private static void eat() {
		for (int i = 0; i < N; i++) {
			visit[arr[i]]--;
			if (visit[arr[i]] == 0) {
				cnt--;
			}

			visit[arr[i + k]]++;
			if (visit[arr[i + k]] == 1) {
				cnt++;
			}

			max = Math.max(max, cnt);
		}

	}

}
