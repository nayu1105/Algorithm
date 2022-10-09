import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class Main {
	static int T;
	static char[] tgt;
	static char[] str;
	static int[] src = new int[26];
	static TreeSet<String> ts = new TreeSet<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			str = br.readLine().toCharArray();

			for (int i = 0; i < str.length; i++) {
				src[str[i] - 'a']++;
			}

			tgt = new char[str.length];
			perm(0);

			int size = ts.size();
			for (int i = 0; i < size; i++) {
				sb.append(ts.pollFirst().toString()).append("\n");
			}

			ts.clear();
			for (int i = 0; i < 26; i++) {
				src[i] = 0;
			}
		}

		System.out.println(sb);
	}

	private static void perm(int tgtIdx) {
		if (tgtIdx == tgt.length) {
			ts.add(String.valueOf(tgt));
			return;
		}

		for (int i = 0; i < 26; i++) {
			if (src[i] > 0) {
				src[i]--;
				tgt[tgtIdx] = (char) ('a' + i);
				perm(tgtIdx + 1);
				src[i]++;
			}
		}

	}
}
