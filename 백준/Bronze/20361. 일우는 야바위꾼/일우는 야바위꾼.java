import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, X, K, ans; // 테스트 케이스 수(T), 종이컵 수 (N), 간식이 있는 위치(X), swap 횟수(K), 결과 저장 변수
	static boolean[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		arr = new boolean[N + 1]; // 0 dummy
		arr[X] = true;
		// 간식이 있는 위치만 true
		ans = 0; // 초기화

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			// 맞바꾸는 위치 a,b 입력

			swap(a, b);
		}

		for (int i = 1; i <= N; i++) {
			if (arr[i] == true) { // 간식이 있는 위치 찾는 for문
				ans = i;
				break;
			}
		}

		System.out.println(ans);

	}

	static void swap(int a, int b) { // swap 함수
		boolean temp = arr[a]; // temp에 arr[a] 임시 저장
		arr[a] = arr[b];
		arr[b] = temp; // 임시저장 한 arr[a] 값 b에 저장
	}
}
