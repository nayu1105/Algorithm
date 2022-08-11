import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int N, M, R, min = Integer.MAX_VALUE;
	static int[][] arr, backup;
	static ArrayList<operator> op;
	static int[] npIdx;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		arr = new int[N + 1][M + 1];
		backup = new int[N + 1][M + 1];
		npIdx = new int[R];
		op = new ArrayList<>();

		// 배열 저장
		for (int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < M + 1; j++) {
				int num = Integer.parseInt(st.nextToken());
				arr[i][j] = num;
				backup[i][j] = num;
			}
		}

		// 명령문 저장
		for (int k = 0; k < R; k++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());

			op.add(new operator(n, m, r));
		}

		// np초기화
		for (int i = 0; i < R; i++) {
			npIdx[i] = i;
		}

		// 명령문 np 계산 -> 회전 -> 최소값 -> 초기화

		while (true) {
			for (int idx : npIdx) {
				rotate(op.get(idx).n, op.get(idx).m, op.get(idx).r);
			}

			for (int i = 1; i < N + 1; i++) {
				int sum = 0;
				for (int j = 1; j < M + 1; j++) {
					sum += arr[i][j];
				}
				min = Math.min(min, sum);
			}

			for (int i = 1; i < N + 1; i++) {
				for (int j = 1; j < M + 1; j++) {
					arr[i][j] = backup[i][j];
				}
			}
			if(!np(npIdx))break;
		}

		System.out.println(min);
	}

	// next perm 순열
	static boolean np(int array[]) {
		int i = array.length - 1;

		while (i > 0 && array[i - 1] >= array[i])
			--i;

		if (i == 0)
			return false;

		int j = array.length - 1;

		while (array[i - 1] >= array[j])
			--j;

		swap(array, i - 1, j);

		int k = array.length - 1;

		while (i < k) {
			swap(array, i++, k--);
		}
		return true;
	}

	static void swap(int numbers[], int i, int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}

	static class operator {
		int n, m, r;

		public operator(int n, int m, int r) {
			super();
			this.n = n;
			this.m = m;
			this.r = r;
		}

		@Override
		public String toString() {
			return "operator [n=" + n + ", m=" + m + ", r=" + r + "]";
		}

	}

	// 회전
	static void rotate(int r, int c, int s) {
		int sy = r - s, ey = r + s;
		int sx = c - s, ex = c + s;

		while (true) {
			if (ey - sy < 1 || ex - sx < 1)
				return;

			int temp = arr[sy][sx];

			for (int i = sy; i < ey; i++) { // left : 아래 값이 위로
				arr[i][sx] = arr[i + 1][sx];
			}
			for (int i = sx; i < ex; i++) { // bottom : 오른쪽값이 왼쪽으로
				arr[ey][i] = arr[ey][i + 1];
			}
			for (int i = ey; i > sy; i--) { // right: 위쪽값이 아래쪽으로
				arr[i][ex] = arr[i - 1][ex];
			}
			for (int i = ex; i > sx; i--) { // top: 왼쪽값이 오른쪽으로
				arr[sy][i] = arr[sy][i - 1];
			}

			arr[sy][sx + 1] = temp;

			sy++;
			sx++;
			ey--;
			ex--;
		}
	}
}
