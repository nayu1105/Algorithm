import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N, cnt;
	static List<Meeting> ans = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		Meeting[] meetings = new Meeting[N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			meetings[i] = new Meeting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		Arrays.sort(meetings, (o1, o2) -> o1.end != o2.end ? o1.end - o2.end : o1.start - o2.start);

		ans.add(meetings[0]);
		cnt = 1;

		for (int i = 1; i < meetings.length; i++) {
			if (ans.get(ans.size() - 1).end <= meetings[i].start) {
				ans.add(meetings[i]);
				cnt++;
			}
		}

		System.out.println(cnt);
	}

	static class Meeting {
		int start, end;

		public Meeting(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public String toString() {
			return "Meeting [start=" + start + ", end=" + end + "]";
		}

	}
}
