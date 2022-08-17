import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, r, c;
	static int ans = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		while (N != 0) {
			int size = (int) Math.pow(2, N) - 1;
			if (size / 2 < r) { // 반절 아래 (3,4분면)

				ans += (int) Math.pow(2, N) * (int) Math.pow(2, N) / 2;
				r -= (int)Math.pow(2, N-1);
			}

			if (size / 2 < c) { // 반절 왼쪽 ( 1, 4분면)
				ans += (int) Math.pow(2, (N - 1)) * (int) Math.pow(2, (N - 1));
				c -= (int)Math.pow(2, N-1);
			}

			N--;

		}

		System.out.println(ans);

	}
}
