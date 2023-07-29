import java.util.*;
class Solution {
    static int time = 0;

	public int solution(int[][] jobs) {
		int answer = 0;
		PriorityQueue<int[]> pq = new PriorityQueue<>((p1, p2) -> p1[1] == p2[1] ? p1[0] - p2[0] : p1[1] - p2[1]);
		PriorityQueue<int[]> sortArray = new PriorityQueue<>((p1, p2) -> p1[0] - p2[0]);

		for (int i = 0; i < jobs.length; i++) {
			sortArray.add(jobs[i]);
		}

		while (!(sortArray.isEmpty() && pq.isEmpty())) {
			if (pq.isEmpty()) {
				int[] temp = sortArray.poll();
				time = temp[0];
				pq.add(temp);
				while (!sortArray.isEmpty() && sortArray.peek()[0] <= time) {
					int[] temp2 = sortArray.poll();
					pq.add(temp2);
				}
			} else {
				int[] temp = pq.poll();
				answer += (time - temp[0]) + temp[1];
				time += temp[1];
				while (!sortArray.isEmpty() && sortArray.peek()[0] <= time) {
					int[] temp2 = sortArray.poll();
					pq.add(temp2);
				}
			}

		}

		answer /= jobs.length;
		return answer;
	}
}