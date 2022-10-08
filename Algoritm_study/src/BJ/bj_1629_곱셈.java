package BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_1629_곱셈 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a, b, c;
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		long ans = pow(a, b, c);

		System.out.println(ans);
	}

	static long pow(int a, int b, int c) {
		if (b == 0)
			return 1;

		long n = pow(a, b / 2, c);
		if (b % 2 == 0) // 짝수면 그냥 n*n
			return n * n % c;
		else // 홀수면 한번 더 곱해줘야함
			return (n * n % c) * a % c;
	}
}
