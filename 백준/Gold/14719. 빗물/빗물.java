import java.util.*;
import java.io.*;

public class Main {
	static int[] FLOOR, LEFTMAX, RIGHTMAX;
	static int H, W;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());

		FLOOR = new int[W];
		LEFTMAX = new int[W];
		RIGHTMAX = new int[W];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < W; i++) {
			FLOOR[i] = Integer.parseInt(st.nextToken());
		}

		int max = FLOOR[W - 1];
		for (int i = W - 1; i >= 0; i--) {
			if (FLOOR[i] < max)
				LEFTMAX[i] = max;
			else {
				max = LEFTMAX[i] = FLOOR[i];
			}
		}

		max = FLOOR[0];
		for (int i = 0; i < W; i++) {
			if (FLOOR[i] < max)
				RIGHTMAX[i] = max;
			else {
				max = RIGHTMAX[i] = FLOOR[i];
			}
		}
		
		int answer =0;
		for(int i=0; i<W; i++) {
			int temp = Math.min(LEFTMAX[i], RIGHTMAX[i]);
			answer += Math.abs(FLOOR[i] - temp);
		}
		
		System.out.println(answer);
	}


}