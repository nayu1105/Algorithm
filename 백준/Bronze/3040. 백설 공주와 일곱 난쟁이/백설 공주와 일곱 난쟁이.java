import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int[] src = new int[9];
	static int[] tgt = new int[7];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 9; i++) {
			src[i] = Integer.parseInt(br.readLine());
		}
		comb(0, 0);
	}

	static void comb(int srcIdx, int tgtIdx) {
		if (tgtIdx == 7) {
			// complete code
			int sum = 0;
			for (int i = 0; i < tgtIdx; i++) {
				sum += tgt[i];
			}

			if (sum == 100) {
				for (int i = 0; i < tgtIdx; i++) {
					System.out.println(tgt[i]);
				}
			}

			return;
		}

		if (srcIdx == 9)
			return;

		tgt[tgtIdx] = src[srcIdx];

		comb(srcIdx + 1, tgtIdx + 1);
		comb(srcIdx + 1, tgtIdx);
	}
}
