import java.util.*;
class Solution {
    static int[] parents;
    public int solution(int n, int[][] costs) {
		boolean[] visited = new boolean[n];
		parents = new int[n];

		Arrays.sort(costs, (c1, c2) -> {
			return c1[2] - c2[2];
		});

		initParents(n);

		int index = -1;
		int answer = 0;

		while (index < costs.length-1) {
			index++;
			int a = costs[index][0];
			int b = costs[index][1];
			int cost = costs[index][2];

			int parentA = findParent(a);
			int parentB = findParent(b);

			if (parentA == parentB)
				continue;
			else {
				if (parentA < parentB)
					union(parentA, parentB);
				else
					union(parentB, parentA);
				answer += cost;
			}
		}

		return answer;
	}

	static public void initParents(int n) {
		for (int i = 0; i < n; i++) {
			parents[i] = i;
		}
	}

	static public void union(int a, int b) {
		int parentA = findParent(a);
		int parentB = findParent(b);

		parents[a] = parentB;
	}

	static public int findParent(int a) {
		if (parents[a] == a)
			return a;
		else
			return parents[a] = findParent(parents[a]);
	}
}