import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int T, N;
	static int[][] map;
	static int[] src;
	static int[] tgt;
	static int min;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {

			N = Integer.parseInt(br.readLine());
			tgt = new int[N / 2];
			src = new int[N];
			map = new int[N][N];
			min = Integer.MAX_VALUE;
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}

				for (int j = 0; j < N; j++) {
					src[j] = j;
				}
			}
			comb(0, 0);

			System.out.println("#" + t + " " + min);

		}
	}

	static void comb(int srcIdx, int tgtIdx) { // N/2개 선택 select true끼리 false 끼리 sum하고 차이구하고 min 값 갱신
		if (tgtIdx == N / 2) {
			int[] tgt2 = new int[N / 2];			
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				boolean A = true;
				for (int j = 0; j < tgtIdx; j++) {
					if (i == tgt[j]) { // 음식 
						A = false;
						break;
					}
				}
				if (A) {
					tgt2[cnt] = i;
					cnt++;
				}
			}

			
			// tgt: 음식 A. tgt 2 = 음식 B

			int sumA = 0, sumB = 0;

			for (int i = 0; i < tgt.length; i++) {
				for (int j = 0; j < tgt.length; j++) {
					sumA += map[tgt[i]][tgt[j]];
					sumB += map[tgt2[i]][tgt2[j]];
				}
			}

			min = Math.min(min, Math.abs(sumA - sumB));

			return;
		}

		if (srcIdx == N)
			return;

		tgt[tgtIdx] = src[srcIdx];

		comb(srcIdx + 1, tgtIdx + 1);
		comb(srcIdx + 1, tgtIdx);

	}
}
