import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	final static long P = 1000000007;
	static long factMod[] = new long[4000001];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		factMod[0] = 1;

		for (int i = 1; i <= 4000000; i++) {
			factMod[i] = (factMod[i - 1] * i) % P;
		}

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());

		long numer = factMod[N];
		long denom = factMod[R] * factMod[N - R] % P;
		System.out.println(numer * pow(denom, P - 2) % P);

	}

	static long pow(long base, long expo) {
		if (expo == 0)
			return 1;

		if (expo % 2 == 0) {
			long temp = pow(base, expo / 2) % P;
			return (temp * temp) % P;
		} else {
			long temp = pow(base, expo - 1);
			return (temp * base) % P;
		}

	}
}
