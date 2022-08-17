import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.StringTokenizer;

public class Solution {
	static int T, M, C;
	static int[] A, B;
	static int[] dx = { 0, 0, 1, 0, -1 }; // 이동 X - 상 - 우 - 하 - 좌
	static int[] dy = { 0, -1, 0, 1, 0 }; // 이동 X - 상 - 우 - 하 - 좌

	static int ans;
	static int[] a;
	static int[] b;

	static Battery[] batteries;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());

			A = new int[M + 1];
			B = new int[M + 1];
			A[0] = B[0] = 0;
			batteries = new Battery[C];
			a = new int[] { 1, 1 }; // x, y 현 위치
			b = new int[] { 10, 10 };
			ans = 0;

			st = new StringTokenizer(br.readLine());
			for (int m = 1; m <= M; m++) {
				A[m] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(br.readLine());
			for (int m = 1; m <= M; m++) {
				B[m] = Integer.parseInt(st.nextToken());
			}

			for (int i = 0; i < C; i++) {
				st = new StringTokenizer(br.readLine());
				batteries[i] = new Battery(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}

			// 입력

			// 시간에 따라 A위치 B위치 조정 -> Battery를 모두 보며 현재 배터리 범위에 있는지 조회 - > 같은 배터리 내라면 최대합 경우
			// 저장 -> ans에 더하기 -> m시간만큼 반복

			for (int m = 0; m <= M; m++) { // 사용자가 지도밖으로 나가는 경우가 없다고 했으니 유효성검사 건너뛰기

				// new 위치 조정
				a[0] += dx[A[m]];
				a[1] += dy[A[m]];
				b[0] += dx[B[m]];
				b[1] += dy[B[m]];

				List<Battery> AC = new ArrayList<>(); // A와 거리 C미만인 배터리를 담을 공간 . 후 sort 할 거임.
				List<Battery> BC = new ArrayList<>(); // B와 거리 C미만인 배터리를 담을 공간 . 후 sort 할 거임.
				for (int c = 0; c < C; c++) {
					int d = Math.abs(batteries[c].x - a[0]) + Math.abs(batteries[c].y - a[1]);
					if (d <= batteries[c].c) {
						AC.add(batteries[c]);
					}
					d = Math.abs(batteries[c].x - b[0]) + Math.abs(batteries[c].y - b[1]);
					if (d <= batteries[c].c) {
						BC.add(batteries[c]);
					}
				}

				AC.sort((o1, o2) -> o2.p - o1.p);
				BC.sort((o1, o2) -> o2.p - o1.p);

				if (AC.size() != 0 && BC.size() != 0 && AC.get(0).equals(BC.get(0))) {
					if (AC.size() == 1 && BC.size() == 1) { // 둘이 반띵 해야하는 경우
						ans += AC.get(0).p;
						AC.remove(0);
						BC.remove(0);
					}

					else if (AC.size() == 1 && BC.size() > 1) {
						BC.remove(0);
					}

					else if (BC.size() == 1 && AC.size() > 1) {
						AC.remove(0);
					}

					else if (AC.get(1).p < BC.get(1).p) {
						BC.remove(0);
					} else {
						AC.remove(0);

					}

				}

				// index 0 이 가장 높음

				if (BC.size() != 0)
					ans += BC.get(0).p;
				if (AC.size() != 0)
					ans += AC.get(0).p;

				// 초기화
				AC.clear();
				BC.clear();

			}

			System.out.println("#" + t + " " + ans);

		}

	}

	static class Battery {
		int x, y, c, p;

		public Battery(int x, int y, int c, int p) {
			super();
			this.x = x;
			this.y = y;
			this.c = c;
			this.p = p;
		}

		@Override
		public String toString() {
			return "Battery [x=" + x + ", y=" + y + ", c=" + c + ", p=" + p + "]";
		}

		@Override
		public int hashCode() {
			return Objects.hash(x, y, c, p);
		}

		@Override
		public boolean equals(Object obj) {
			if (obj != null && obj instanceof Battery) {
				Battery b = (Battery) obj;
				if (this.c == b.c && this.p == b.p && this.x == b.x && this.y == b.y)
					return true;
			}
			return false;
		}
	}

}
