import java.util.*;
import java.io.*;

public class Main {
	static int[][] map, plus;
	static int N, M;
	static int[] dx = { -1, -1, 0 };
	static int[] dy = { -1, 0, -1 };

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		map = new int[M][M];

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = 1;
			}
		}

		for (int i = 0; i < N; i++) {
			int[] op = new int[M * 2 - 1];
			plus = new int[M][M];
			st = new StringTokenizer(br.readLine());
			
			// op 저장
			int index = 0;
			for (int j = 0; j < 3; j++) {
				int num = Integer.parseInt(st.nextToken());
				for (int k = 0; k < num; k++) {
					op[index] = j;
					index++;
				}
			}

			// 가장 자리 더하기
			index = 0;
			for (int j = M - 1; j >= 0; j--) {
				map[j][0] += op[index];
				plus[j][0] = op[index];
				index++;
			}
			for (int j = 1; j < M; j++) {
				map[0][j] += op[index];
				plus[0][j] = op[index];
				index++;
			}

			// 나머지 더하기
			for (int j = 1; j < M; j++) {
				for (int k = 1; k < M; k++) {
					int max = 0;
					for (int h = 0; h < 3; h++) {
						int ny = j + dx[h];
						int nx = k + dy[h];

						if (isValid(nx, ny) && max < plus[ny][nx]) {
							max = plus[ny][nx];
						}
					}

					map[j][k] += max;
					plus[j][k] = max;
				}
			}

		}

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}

	}

	static boolean isValid(int x, int y) {
		return x >= 0 && x < M && y >= 0 && y < M;
	}

}