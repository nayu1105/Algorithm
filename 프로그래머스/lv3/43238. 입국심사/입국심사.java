import java.util.*;
class Solution {
        public long solution(int n, int[] times) {
		Arrays.sort(times);
		long low = 0;
		long high = times[times.length - 1] * (long) n;

		long answer = 0;

		while (low <= high) {
			long mid = (low + high) / 2;

			long cnt = 0;
			for (int i = 0; i < times.length; i++) {
				cnt += mid / times[i];
			}

			if (cnt < n) {
				low = mid + 1;
			} else {
				high = mid - 1;
				answer = mid;
			}
		}

		return answer;
	}
}