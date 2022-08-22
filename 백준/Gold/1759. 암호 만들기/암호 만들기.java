import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int L, C;
	static char[] arr; // 모음, 자음
	static ArrayList<String> ans = new ArrayList<>();
	static char[] tgt;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		tgt = new char[L];
		arr = new char[C];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < C; i++) {
			arr[i] = st.nextToken().charAt(0);
		}

		Arrays.sort(arr);
		comb(0, 0);

		for (String string : ans) {
			System.out.println(string);
		}

	}

	static void comb(int arrIdx, int tgtIdx) {
		if (tgtIdx == L) {
			int a = 0, b = 0;
			String s = "";
			for (int i = 0; i < tgtIdx; i++) {
				s += tgt[i];
				if (tgt[i] == 'a' || tgt[i] == 'e' || tgt[i] == 'i' || tgt[i] == 'o' || tgt[i] == 'u') {
					a++;
				} else
					b++;
			}
			if (a >= 1 && b >= 2)
				ans.add(s);
			return;
		}

		if (arrIdx == C)
			return;

		tgt[tgtIdx] = arr[arrIdx];

		comb(arrIdx + 1, tgtIdx + 1);
		comb(arrIdx + 1, tgtIdx);

	}

}
