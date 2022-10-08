package BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class bj_1377_버블소트 {
	static int N, max = Integer.MIN_VALUE;
	static ArrayList<Node> arr = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(br.readLine());
			arr.add(new Node(n, i));
		}

		Collections.sort(arr, (o1, o2) -> o1.num - o2.num);

		for (int i = 0; i < N; i++) {
			max = Math.max(max, arr.get(i).idx - i);
		}

		System.out.println(max + 1);

	}

	static class Node {
		int num, idx;

		public Node(int num, int idx) {
			super();
			this.num = num;
			this.idx = idx;
		}

	}
}
