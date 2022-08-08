package PG;

import java.util.Arrays;

public class pg_무지의먹방라이브 {
	public static void main(String[] args) {
		Solution s =new Solution();
		int[] input = { 2, 1, 2 };
		s.solution(input, 5);
	}


}

class Solution {
	public Solution() {}
	public int solution(int[] food_times, long k) {
		int answer = 0;
		int [] sort = food_times;
		Arrays.sort(sort);
		int s_idx = 0;
		int len = food_times.length;

		while (sort[s_idx] < k) {
			s_idx++;
			
		}

		return answer;
	}
}

class food{
	int idx;
	int quantity;
	
	public food(int idx, int quantity) {
		super();
		this.idx = idx;
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "food [idx=" + idx + ", quantity=" + quantity + "]";
	}
	
	
	
}
