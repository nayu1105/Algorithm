package TC;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class tc_explorer_guild {
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());

		ArrayList<Integer> arr = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			arr.add(Integer.parseInt(st.nextToken()));
		}

		Collections.sort(arr);

		int ans, idx, fear, max = Integer.MIN_VALUE;

		for (int i = N - 1; i >= 0; i--) {
			ans = 0;
			idx = i;
			fear = arr.get(idx) - 1;
			while (idx >= 0) {
				if (fear == 0) {
					ans++;
					if(idx==0)break;
					fear = arr.get(--idx) - 1;
					continue;
				} else {
					fear--;
				}
				idx--;
			}
			if (ans > max)
				max = ans;
		}

		System.out.println(max);

	}
}
