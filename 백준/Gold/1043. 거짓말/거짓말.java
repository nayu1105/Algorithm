import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] parents;
	static boolean[] truth;
	static List<Party> list = new ArrayList<>();
	static int ans;

	// 전략 : union-find
	// 파티있는 사람들 다 유니온 파인드로 집합 만들기
	// 이후 진실을 아는 사람들 find_parent 해서 최상 부모를 true로 만들기
	// party 탐색하며 과장된 말 할 수 있는 파티 세기

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		parents = new int[N + 1]; // 0 dummy
		truth = new boolean[N + 1]; // 0 dummy

		// 진실을 아는 사람 true 로 변환
		st = new StringTokenizer(br.readLine());
		int truth_n = Integer.parseInt(st.nextToken());

		for (int i = 1; i <= truth_n; i++) {
			truth[Integer.parseInt(st.nextToken())] = true;
		}

		makeParents();

		// 파티 읽으며 진실을 듣게 되는 사람 체크
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int n = Integer.parseInt(st.nextToken());
			List<Integer> party = new ArrayList<>();
			int standard = Integer.parseInt(st.nextToken());
			party.add(standard);

			for (int j = 1; j < n; j++) {
				int temp = Integer.parseInt(st.nextToken());
				union(standard, temp);
				party.add(temp);
			}
			// 엮여있는 파티 모두 계산됨.

			list.add(new Party(party));
		}

		// 최상위 부모 모두 true 로 만들기
		for (int i = 1; i <= N; i++) {
			if (truth[i] == true)
				truth[find(i)] = true;
		}

		// 거짓말쟁이 파티 갯수
		liarParty();

		System.out.println(ans);

	}

	private static void liarParty() {
		ans = 0;
		for (int i = 0; i < list.size(); i++) {
			Party party = list.get(i);
			boolean check = true;
			for (int p : party.list) {
				if (!truth[find(p)])
					continue;
				else {
					check = false;
					break;
				}
			}
			if (check)
				ans++;
		}

	}

	private static void union(int standard, int temp) {
		int p1 = find(standard);
		int p2 = find(temp);

		if (p1 != p2)
			parents[p2] = p1;
	}

	private static int find(int n) {
		if (parents[n] == n)
			return n;
		else
			return parents[n] = find(parents[n]);

	}

	private static void makeParents() {
		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}
	}

	static class Party {
		List<Integer> list;

		public Party(List<Integer> list) {
			super();
			this.list = list;
		}

	}
}
