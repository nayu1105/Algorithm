package algorithm_assignments;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class prefix_sum_bj_11659 {
	static int N, M;
	static int[] arr = new int[100001];

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());

		for (int i = 1; i <= N; i++) {
			arr[i] = arr[i-1]+Integer.parseInt(st.nextToken());
		}

		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()); //start
			int y = Integer.parseInt(st.nextToken()); //end 
			
			sb.append(arr[y]-arr[x-1]).append("\n");
		}
		System.out.println(sb);

	}
}
