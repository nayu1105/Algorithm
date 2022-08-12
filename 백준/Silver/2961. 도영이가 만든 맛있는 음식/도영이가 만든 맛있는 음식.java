import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//dfs
public class Main {
	static int T;
	static int[][] src;
	static boolean[] select;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());

		src = new int[T][2];
		select = new boolean[T];
		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			src[i][0] = Integer.parseInt(st.nextToken());
			src[i][1] = Integer.parseInt(st.nextToken());
		}

		dfs(0, 1, 0);

		System.out.print(min);
	}

	static void dfs(int srcIdx, int sour, int bitter) {

		if (srcIdx == T) {
			int cnt = 0;
			while (cnt < T && !select[cnt]) {
				cnt++;
			}
			if (cnt == T)
				return;

			min = Math.min(min, Math.abs(sour - bitter));

			return;
		}

		select[srcIdx] = false;
		dfs(srcIdx + 1, sour, bitter); // 선택 X
		select[srcIdx] = true;
		dfs(srcIdx + 1, sour *= src[srcIdx][0], bitter + src[srcIdx][1]); // 선택 O
	}
}
