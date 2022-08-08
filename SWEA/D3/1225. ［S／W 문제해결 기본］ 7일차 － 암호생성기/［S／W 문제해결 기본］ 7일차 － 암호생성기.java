import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<Integer> q = new LinkedList<>();

		for (int t = 1; t <= 10; t++) {
			br.readLine();
			String [] s = br.readLine().split(" ");
			for (int i = 0; i < 8; i++) {
				q.offer(Integer.parseInt(s[i]));
			}
			int temp = 1;
			while (true) {
				int n = q.poll();
				if (n - temp <= 0) {
					q.offer(0);
					break;
				}
				q.offer(n - temp);
				temp = temp % 5 + 1;
			}
			
			System.out.print("#"+t);
			while(!q.isEmpty()) {
				System.out.print(" "+q.poll());
			}
			System.out.println();
			
			q.clear();
		}
	}
}
