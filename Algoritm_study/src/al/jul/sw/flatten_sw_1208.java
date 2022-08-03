package algorithm_assignments;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class flatten_sw_1208 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int t = 1; t <= 10; t++) {

			int dump = Integer.parseInt(br.readLine());
			int[] arr = new int[100];

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 100; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(arr);
			
			while (dump != 0 && arr[99] - arr[0] > 1) {				
				arr[0]++;
				arr[99]--;
				dump--;
				Arrays.sort(arr);
			}
			System.out.println("#" + t +" " + (arr[99] - arr[0]));
		}
	}
}
