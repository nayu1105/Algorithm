import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Solution {
	static int T, N, M;
	static Integer[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			arr = new Integer[N];
			int weight = -1, temp = 0;
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr, Collections.reverseOrder());

			for (int i = 0; i < N; i++) {
				for (int j = i+1; j < N; j++) {
					temp = arr[i] + arr[j];

					if (weight < temp && temp <= M)
						weight = temp;

					if (weight == M) {
						break;
					}

				}
				if (temp == M) {
					break;
				}
			}
			
			System.out.println("#" + t + " " + weight);
		}

	}
}
