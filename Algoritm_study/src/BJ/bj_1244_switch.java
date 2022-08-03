package BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//입력을 받으면서 처리할 수 있는 문제는 반드시 그렇게 처리하도록 노력( 입력을 위한 자료구조를 만들 필요 X)
public class bj_1244_switch {

	static int N, COUNT;
	static int[] switches; // 스위치 배열
	static int gender, num; // 남여, 부여받은 숫자... // 입력 자료구조를 만들어서 받아놓고 하나씩 X 입력 받으면 바로 처리

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		switches = new int[N + 1]; // 0 dummy, 문제의 번호가 1부터 시작

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 1; i <= N; i++) {
			switches[i] = Integer.parseInt(st.nextToken());
		}

		COUNT = Integer.parseInt(br.readLine());

		for (int i = 0; i < COUNT; i++) {
			st = new StringTokenizer(br.readLine());
			gender = Integer.parseInt(st.nextToken());
			num = Integer.parseInt(st.nextToken());

			if (gender == 1) {
				male();
			} else if (gender == 2) {
				female();
			}
		}

		// 결과 출력
		for (int i = 1; i <= N; i++) {
			System.out.print(switches[i]);
			if (i != N) {
				if (i % 20 == 0)
					System.out.println(); // 개행
				else {
					System.out.print(" ");
				}
			}
		}
	}

	// 자기가 받은 번호의 배수를 바꿔야 함
	//
	static void male() {
//		for (int i = 1; i <= N; i++) {
//			if (i % num == 0) {
//				switches[i] = switches[i] == 0 ? 1 : 0;
//			}
//		} // 1 부터 N까지 다 검색

		for (int i = num; i <= N; i += num) {
			switches[i] = switches[i] == 0 ? 1 : 0;
			// num 부터 num의 배수만 검색 -> 첫번째 이득 : 배수 idx만 찾아 감
			// if 비교 X -> 두번째 이득
		}

	}

	static void female() {
		// 자신이 받은 버호의 스위치를 우선 변경
		// 자신 좌우 대사인 것을 찾아서 변경
		switches[num] = switches[num] == 0 ? 1 : 0;
//		int cnt = 1;
//
//		while (num - cnt >= 1 && num + cnt <= N) {
//			if (switches[num - cnt] == switches[num + cnt]) {
//				switches[num - cnt] = switches[num - cnt] == 0 ? 1 : 0;
//				switches[num + cnt] = switches[num + cnt] == 0 ? 1 : 0;
//
//			} else {
//				break;
//			}
//			cnt++;
//		}

		int left = num - 1, right = num + 1;

		while (left >= 1 && right <= N) {
			if (switches[left] == switches[right]) {
				switches[left] = switches[left] == 0 ? 1 : 0;
				switches[right] = switches[right] == 0 ? 1 : 0;

				// switches[right] = switches[left] = switches[left] ==0 ? 1 :0;
				// 위와 같이 쓸 수도 있음
			} else {
				break;
			}
			left--;
			right++;
		}

	}
}
