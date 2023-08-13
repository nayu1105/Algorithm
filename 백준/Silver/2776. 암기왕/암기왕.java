import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());

			StringTokenizer st = new StringTokenizer(br.readLine());
			HashSet<Integer> set = new HashSet<>();

			for (int i = 0; i < N; i++) {
				set.add(Integer.parseInt(st.nextToken()));
			}

			int M = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				if (set.contains(Integer.parseInt(st.nextToken())))
					bw.write("1\n");
				else
					bw.write("0\n");
			}

		}

		bw.flush();

	}

}