import java.util.*;
class Solution {
    public int solution(int n, int[][] costs) {
		boolean[] visited = new boolean[n];

		Arrays.sort(costs, (c1, c2) -> {
			return c1[2] - c2[2];
		});

		int temp = 0;
		int index = 0;
		int answer = 0;

		while (temp < n) {
			int a = costs[index][0];
			int b = costs[index][1];
			int cost = costs[index][2];

			int cnt = 0;
			for (int i = 0; i < n; i++) {
				if (visited[i])
					cnt++;
				else
					break;
			}

			if (cnt == n)
				break;

			if (visited[a] && visited[b])
				index++;
			else {
				visited[a] = true;
				visited[b] = true;
				answer += cost;
				index++;
			}
		}

		return answer;
	}
}