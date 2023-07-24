import java.util.*;
class Solution {
	static boolean[] used;
	static Stack<String> stack;
	static boolean end = false;
    
    public String[] solution(String[][] tickets) {
		used = new boolean[tickets.length];
		stack = new Stack<>();

		String start = "ICN";

		dfs(tickets, start);

		int size = stack.size();
		String[] answer = new String[size+1];
		while (!stack.isEmpty()) {
			answer[size] = stack.peek();
			stack.pop();
			size--;
		}
		answer[0] ="ICN";
		return answer;
	}

	static public void dfs(String[][] tickets, String str) {
		// 티켓을 모두 소진했는지 확인
		int count = 0;
		for (int i = 0; i < tickets.length; i++) {
			if (used[i])
				count++;
		}

		if (count == tickets.length) {
			end = true;
			return;
		}
		
		// 다음 티켓 찾고 정렬하기

		List<Ticket> next = new LinkedList<>();
		for (int i = 0; i < tickets.length; i++) {
			if (!used[i] && tickets[i][0].equals(str)) {
				next.add(new Ticket(i, tickets[i][0], tickets[i][1]));
			}
		}

		Collections.sort(next);
		
		// 찾은 티켓으로 dfs 하기

		for (int i = 0; i < next.size(); i++) {
			used[next.get(i).index] = true;
			stack.push(next.get(i).end);
			dfs(tickets, next.get(i).end);
			if (end)
				return;
			used[next.get(i).index] = false;
			stack.pop();
		}
	}

	static class Ticket implements Comparable<Ticket> {
		int index;
		String start, end;

		public Ticket(int index, String start, String end) {
			this.index = index;
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Ticket t) {
			int compareResult = this.end.compareTo(t.end);
			if (compareResult < 0)
				return -1;
			else if (compareResult > 0)
				return 1;
			else
				return 0;
		}
	}
}
