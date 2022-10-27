import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	static int X;
	static Stack<Integer> stack;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		X = Integer.parseInt(br.readLine());
		stack = new Stack<>();
		int sum = 64; // 막대 길이의 합
		stack.add(64); // 스택 초기화 
		
		// 전략
		// cut 함수
		// stack에서 맨위의 막대를 꺼내서 반으로 나누고 이를 sum에서 뺀다.
		// 1) 만약 그 합이 X보다 작으면 반으로 나눈 막대를 두번 push 한다.
		// 2) 만약 그 합이 X보다 크거나 같으면 한번만 push 한다.
		// 리턴 값 sum이 X가 될때까지 이를 반복한다,.
		
		// X와 sum이 같아질 경우 while문을 빠져나오고, stack의 사이즈가 막대의 갯수가 된다.
		while (sum != X) { // 총 막대 길이의 합이 X가 될 때까지 자르기 진행
			sum = cut(sum); // 자른 후 결과 sum에 넣기
		}

		System.out.println(stack.size()); // 결과 출력
		
	}

	private static int cut(int sum) {
		int n = stack.pop();
		sum -= n / 2;
		if (sum < X) { // 모든 막대의 길이의 합이 Xcm 보다 작은 경우 push 2번
			stack.add(n / 2);
			stack.add(n / 2);
			sum += n / 2; // 막대 길이 그대로
		} else { // 모든 막대의 길이의 합이 Xcm 보다 크거나 같은 경우. 막대 버리기. push 1번
			stack.add(n / 2);
		}
		return sum;
	}
}
