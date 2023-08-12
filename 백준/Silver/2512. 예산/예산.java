import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());

		int[] list = new int[N];
		int max = 0;
		int total = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			list[i] = Integer.parseInt(st.nextToken());
			total += list[i];
			max = list[i] > max ? list[i] : max;
		}

		long M = Long.parseLong(br.readLine());

		if (total <= M)
			System.out.println(max);
		else {
			long start = 0, end = max;
			long answer = 0;
			while (start <= end) {
				long mid = (start + end) / 2;
				long sum = 0;
				for (int i = 0; i < N; i++) {
					sum += list[i] > mid ? mid : list[i];
				}

				if (sum <= M) {
					answer = Math.max(answer, mid);
					start = mid + 1;
				} else {
					end = mid - 1;
				}
			}

			System.out.println(answer);
		}

	}

}