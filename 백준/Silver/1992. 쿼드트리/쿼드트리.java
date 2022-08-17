import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int N, sub, ans; // 크기, string에 저장할 문자 0 또는 1
	static int[][] map;
	static String s="";
	static int x, y;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			char[] c= br.readLine().toCharArray();
			for (int j = 0; j < N; j++) {
				map[i][j] = c[j]-'0';
			}
		}
		rec(0, 0, N);
		
		System.out.println(s);
	}

	static void rec(int x, int y, int size) {
		if (!check(x, y, size)) { // 4등분
			s+="(";
			rec(x, y, size / 2);			
			rec(x, y + size / 2, size / 2);
			rec(x + size / 2, y, size / 2);
			rec(x + size / 2, y + size / 2, size / 2);
			s+=")";
		} else {
			s+=map[x][y];
		}
	}

	static boolean check(int x, int y, int n) {
		int num = map[x][y];
		boolean ans = true;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (num != map[x + i][y + j]) {
					ans = false;
					break;
				}
			}
			if(!ans)break;
		}
		return ans;
	}
}
