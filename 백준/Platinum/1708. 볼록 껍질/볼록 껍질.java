import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static long sx, sy;
	static long[][] point; // point[3][0] 4번째 정점의 x좌표

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		point = new long[N][2];

		// point 배열에 입력 저장
		StringTokenizer st = null;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			point[i][0] = Long.parseLong(st.nextToken());
			point[i][1] = Long.parseLong(st.nextToken());
		}

		// 시작점 sx, sy 지정(맨 앞 point[0] 을 시작점으로)
		sx = point[0][0];
		sy = point[0][1];
		// 시작점을 y가 가장 작은 점, y가 같은 점이 있다면 x가 가장 작은 점 계산
		for (int i = 1; i < N; i++) {
			if (sy > point[i][1]) {
				sx = point[i][0];
				sy = point[i][1];
			} else if (sy == point[i][1] && sx > point[i][0]) {
				sx = point[i][0];
				sy = point[i][1];
			}
		}

		// point배열을 반시게 반향으로 정렬
		Arrays.sort(point, (p1, p2) ->

		{
			int ret = ccw(sx, sy, p1[0], p1[1], p2[0], p2[1]);
			if (ret > 0) { // 반시계
				return -1;
			} else if (ret < 0) { // 시계방향
				return 1;
			} else {
				long diff = distance(sx, sy, p1[0], p1[1]) - distance(sx, sy, p2[0], p2[1]);
				return diff > 0 ? 1 : -1;
			}
		});

		// stack 객체 생성
		// 시작점을 stack에 넣는다.
		Stack<long[]> stack = new Stack<>();
		stack.add(new long[] { sx, sy });
		// 시작점을 제외한 모든 점을 순회
		// for문을 이용해서 각 i점 대해서
		// stack에 들어가있는 이전 2개의 점과 i 점과의 ccw 확인
		// 반시계 방향이 아니면 계속 꺼내기 -> stack에 i점 저장
		int length = point.length;
		
		for (int i = 1; i < length; i++) {
			long[] next = point[i];
			//next 가 이전 2개의 점과 반시계방향인지 따져봐서 아니면 계속 반시계방향이 만들어지도록 기존 점을 삭제
			while(stack.size()>1) {
				long[] first = stack.get(stack.size()-2);
				long[] second = stack.get(stack.size()-1);
				int ret = ccw(first[0],first[1],second[0],second[1],next[0],next[1]);
				if(ret<=0)stack.pop();
				else break;
			}
			stack.add(point[i]); // 새로 추가
		}

		// stack에 들어가 있는 점들이 바로 볼록껍질을 구성하는 점들이므로 Stack의 크기를 출력
		System.out.println(stack.size());
	}

	private static long distance(long x1, long y1, long x2, long y2) {
		return (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);
	}

	private static int ccw(long x1, long y1, long x2, long y2, long x3, long y3) {
		// ret는 양수 음수 여부를 따져서 반시계방향, 시계방향여부 리턴. 같으면 0 리턴
		long ccw = (x1 * y2 + x2 * y3 + x3 * y1) - (x2 * y1 + x3 * y2 + x1 * y3);

		if (ccw > 0) {
			return 1;
		} else if (ccw < 0) {
			return -1;
		} else {
			return 0;
		}
	}
}
