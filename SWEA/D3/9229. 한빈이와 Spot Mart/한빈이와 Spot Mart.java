import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
	static int T, N, M;
	static Integer[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			arr = new Integer[N];
			int weight = -1, temp = 0;
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr); // sort

			for (int i = 0; i < N; i++) {
				for (int j = i + 1; j < N; j++) {
					temp = arr[i] + arr[j];
					if (temp <= M) {
						if (weight < temp) // 계산한 값이 현재 무게보다 크면 바꾸기
							weight = temp;
						if (weight == M) { // 무게가 M과 같아지면 최댓값이기에 이중 포문 break;
							break;
						}
					} else // 정렬을 했기에 두 숫자의 합이 M보다 커지면 그 이후의 합도 M보다 크기에 들고갈 수 없음.
						break; //이중 포문 중 바깥 for문을 돌기 위해 나가기

				}
				if (temp == M) {// 무게가 M과 같아지면 최댓값이기에 이중 포문 break;
					break;
				}
			}

			System.out.println("#" + t + " " + weight);
		}

	}
}
