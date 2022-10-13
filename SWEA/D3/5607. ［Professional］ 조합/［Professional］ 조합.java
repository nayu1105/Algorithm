import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int T;
	final static long P = 1234567891;
	static long factMod[] = new long[1000001];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		factMod[0] = 1;

		for (int i = 1; i <= 1000000; i++) {
			factMod[i] = (factMod[i - 1] * i) % P;
		}

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());

			long numer = factMod[N];
			long denom = factMod[R] * factMod[N - R] % P;
			System.out.println("#" + t + " " + numer * pow(denom, P - 2) % P);
		}
	}

	static long pow(long base, long expo) {
		if (expo == 0)
			return 1;
		else if (expo == 1)
			return base;

		if (expo % 2 == 0) {
			long temp = pow(base, expo / 2);
			return (temp * temp) % P;
		} else {
			long temp = pow(base, expo - 1) % P;
			return (temp * base) % P;
		}

	}
}
