import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static Queue<Integer> q = new ArrayDeque<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		sb.append("<");

		int N, M;
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for (int i = 1; i <= N; i++) {
			q.offer(i);
		}
		
		int cnt=0;
		while(q.size()!=1) {
			int i = q.poll();
			if(cnt==M-1) {
				sb.append(i).append(", ");
				cnt=0;
				continue;
			}
			q.offer(i);
			cnt++;
		}
		
		sb.append(q.poll()).append(">");
		
		System.out.println(sb);
	}
}
