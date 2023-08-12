import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		long N = Long.parseLong(st.nextToken());
		long M = Long.parseLong(st.nextToken());

		List<Long> list = new ArrayList<>();
		st = new StringTokenizer(br.readLine());

		long start = 1, end = 0;

		for (int i = 0; i < N; i++) {
			list.add(Long.parseLong(st.nextToken()));
			end = list.get(i) > end ? list.get(i) : end;
		}

		long answer = 0;

		while (start <= end) {
			long mid = (start + end) / 2;
			long sum = 0;

			for (int i = 0; i < N; i++) {
				if (list.get(i) <= mid)
					continue;
				else {
					sum += list.get(i) - mid;
				}
			}

			if (sum < M) {
				end = mid - 1;
			} else {
				start = mid + 1;
				answer = Math.max(answer, mid);
			}
		}

		System.out.println(answer);

	}

}