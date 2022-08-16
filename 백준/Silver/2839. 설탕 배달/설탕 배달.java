import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int N, min = Integer.MAX_VALUE;
	static int b1 = 5, b2 = 3;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

	
		for (int i = N / b1; i >= 0; i--) {
			int n = N;
			n -= i * b1;
			if (n % 3 == 0) { // 딱 나눠 떨어질때
				min = Integer.min(min, i + n / 3);
			}
		}

		if (min == Integer.MAX_VALUE)
			System.out.println("-1");
		else {
			System.out.println(min);
		}
	}
}
