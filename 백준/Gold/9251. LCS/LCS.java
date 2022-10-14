import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int[][] lcs;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] str1 = br.readLine().toCharArray();
		char[] str2 = br.readLine().toCharArray();

		lcs = new int[str2.length + 1][str1.length + 1];

		for (int i = 1; i <= str2.length; i++) {
			char temp = str2[i - 1];
			for (int j = 1; j <= str1.length; j++) {
				if (temp == str1[j - 1]) {
					lcs[i][j] = lcs[i - 1][j - 1] + 1;
				} else {
					lcs[i][j] = Math.max(lcs[i - 1][j], lcs[i][j - 1]);
				}
			}
		}

		System.out.println(lcs[str2.length][str1.length]);
	}
}
