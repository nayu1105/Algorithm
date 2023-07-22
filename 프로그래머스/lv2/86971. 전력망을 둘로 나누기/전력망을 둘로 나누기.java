import java.util.*;
class Solution {
	static List<List<Integer>> list = new LinkedList<>();

	public int solution(int n, int[][] wires) {

		initList(n + 1, wires);

		int answer = -1;

		for (int i = 0; i < wires.length; i++) {
			if (answer == -1)
				answer = simul(n + 1, wires[i]);
			else
				answer = Math.min(answer, simul(n + 1, wires[i]));
		}

		return answer;
	}

	static public void initList(int n, int[][] wires) {
		for (int i = 0; i <= n; i++) {
			list.add(new LinkedList<>());
		}

		for (int i = 0; i < wires.length; i++) {
			list.get(wires[i][0]).add(wires[i][1]);
			list.get(wires[i][1]).add(wires[i][0]);
		}
	}

	static public int simul(int n, int[] node) {
		int a = bfs(n, node[0], node[1]);
		int b = bfs(n, node[1], node[0]);
		return Math.abs(a - b);
	}

	static public int bfs(int n, int start, int node) {
		boolean[] visited = new boolean[n];
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(start);

		int count = 0;

		while (!queue.isEmpty()) {
			int temp = queue.poll();
			visited[temp] = true;
			count++;

			for (int i = 0; i < list.get(temp).size(); i++) {
				int temp2 = list.get(temp).get(i);

				if (temp2 == node)
					continue;

				if (!visited[temp2])
					queue.offer(temp2);
			}
		}

		return count;
	}
}