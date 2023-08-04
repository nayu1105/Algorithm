import java.util.*;
import java.io.*;

public class Main {
	static Node Tree;
	static int H, K, R;
	static int answer;

	static BufferedReader br;
	static StringTokenizer st;

	public static void main(String args[]) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());

		H = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		Tree = new Node(0);
		makeTree(Tree, H);

		for (int day = 1; day <= R; day++) {
			answer += doWork(Tree, day);
		}

		System.out.print(answer);

	}

	static int doWork(Node node, int day) {
		if (node.depth == H) {
			return node.work(day);
		}
		int pre = node.work(day);

		int temp = doWork(node.left, day);
		if (temp != 0) {
			node.workLeft.offer(temp);
		}

		temp = doWork(node.right, day);
		if (temp != 0) {
			node.workRight.offer(temp);
		}

		return pre;

	}

	static void makeTree(Node node, int high) throws Exception {
		if (node.depth == high) {
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < K; i++) {
				node.workLeft.offer(Integer.parseInt(st.nextToken()));
			}
			return;
		}
		node.left = new Node(node.depth + 1);
		makeTree(node.left, high);
		node.right = new Node(node.depth + 1);
		makeTree(node.right, high);
	}

	static class Node {
		int depth;
		Node left;
		Node right;

		Queue<Integer> workLeft;
		Queue<Integer> workRight;

		public Node(int depth) {
			this.depth = depth;
			workLeft = new LinkedList<>();
			workRight = new LinkedList<>();
		}

		public int work(int day) {
			// 자신이 말단 노드라면 workLeft에 다 담아뒀음.
			if (depth == H) {
				if (workLeft.size() == 0)
					return 0;
				else
					return workLeft.poll();
				// 0 은 할 업무가 없음을 의미
			}

			if (day % 2 == 0) { // 짝수 날은 right work 수행
				if (workRight.size() != 0)
					return workRight.poll();
				else
					return 0;
			} else { // 홀수 날은 right work 수행
				if (workLeft.size() != 0)
					return workLeft.poll();
				else
					return 0;
			}
		}
	}

}
