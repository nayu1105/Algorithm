package SW;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Stack;

public class sw_1218_괄호 {
	static Stack<Character> stack = new Stack<>();
	static int ans = 1;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int t = 1; t <= 10; t++) {
			int n = Integer.parseInt(br.readLine());
			String s = br.readLine();
			stack.clear();
			ans = 1;

			for (int j = 0; j < n; j++) {
				char c = s.charAt(j);
				if (c == '(' || c == '[' || c == '{' || c == '<') {
					stack.push(c);
				} else {
					if (!stack.isEmpty()) {
						char top = stack.pop();
						if ((top == '(' && c == ')') || (top == '{' && c == '}') || (top == '[' && c == ']')
								|| (top == '<' && c == '>')) {
							continue;
						} else {
							ans = 0;
							break;
						}
					} else {
						ans = 0;
						break;
					}

				}
			}

			if (!stack.isEmpty())
				ans = 0;

			System.out.println("#" + t + " " + ans);

		}

	}
}
