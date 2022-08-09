import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int T, N, Idx, max;
	static int[][] arr;
	static int[] dx = { -1, 0, 1, 0 }; // 상 - 우 - 하 - 좌
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());


		
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			max = Integer.MIN_VALUE;
			int temp;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					temp = dfs(i, j, 1);
					if (temp >= max) {
						if(temp==max) {
							if(Idx>arr[i][j])Idx=arr[i][j];
						}
						else{
							max = temp;
							Idx= arr[i][j];
						}
					}
				}
			}
			System.out.println("#" + t + " " + Idx + " " + max);
		}
	}

	static int dfs(int x, int y, int d) {
		int max = d;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			int deep = d;
			if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
				if (arr[x][y] + 1 == arr[nx][ny]) {
					deep = dfs(nx, ny, d + 1);
					max = deep;

				}
			}

		}
		return max;
	}
}
