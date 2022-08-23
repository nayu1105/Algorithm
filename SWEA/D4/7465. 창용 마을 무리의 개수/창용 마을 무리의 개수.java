import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Solution {
	static int T, N, M;
	static int[] parent;
	static TreeSet<Integer> ts;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			parent = new int[N+1];

			for (int i = 1; i <= N; i++) {
				parent[i] = i;
			}
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				if(a<b)Union(a, b);
				else Union(b, a);
			}
			
			ts = new TreeSet<Integer>();
			for (int i = 1; i <= N; i++) {
				ts.add(FindSet(i));
			}
			
			System.out.println("#"+ t +" " + ts.size());
		}
	}

	static int FindSet(int x) {
		if (parent[x] == x)
			return x;
		return parent[x] = FindSet(parent[x]);
	}

	static void Union(int a, int b) {
		int ap = FindSet(a);
		int bp = FindSet(b);

		parent[ap] = bp;
	}
}
