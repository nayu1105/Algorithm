import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	static int T, N, max;
	static int[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N];
			boolean check = false;

			StringTokenizer st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			arr[0] = Math.abs(y) + Math.abs(x);
			// max 도 첫번째 값으로 시작
			max = arr[0];

			for (int i = 1; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				y = Integer.parseInt(st.nextToken());
				x = Integer.parseInt(st.nextToken());

				arr[i] = Math.abs(y) + Math.abs(x);
				max = Math.max(max, arr[i]);
				if (arr[i - 1] % 2 != arr[i] % 2)
					check = true;
			}
			if (check == true) {
				System.out.println("#" + t + " -1");
				continue;
			}

			int sum = 0;// 총 이동거리의 합
			int cnt = 0;// 움직이는 횟수
			while (true) {
				if (sum == max || (sum > max) && (sum - max) % 2 == 0)
					break;
				sum += ++cnt;
			}

			System.out.println("#" + t + " " + cnt);
		}
	}

}
