import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//부분집합
public class Main {
	static int T;
	static Item[] src;
	static boolean[] select;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());

		src = new Item[T];
		select = new boolean[T];
		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			src[i] = new Item(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		subset(0);

		System.out.print(min);
	}

	static void subset(int srcIdx) {
		if (srcIdx == T) {
			int sour = 0;
			int bitter = 0;

			for (int i = 0; i < srcIdx; i++) {
				if (select[i]) {
					if (sour == 0)
						sour = 1;
					sour *= src[i].s;
					bitter += src[i].b;
				}
			}

			if (sour == 0)
				return;

			min = Math.min(min, Math.abs(sour - bitter));

			return;
		}

		select[srcIdx] = true;
		subset(srcIdx + 1);

		select[srcIdx] = false;
		subset(srcIdx + 1);
	}

	static class Item {
		int s; // 신맛
		int b; // 쓴맛

		public Item(int s, int b) {
			this.s = s;
			this.b = b;
		}

		@Override
		public String toString() {
			return "Item [s=" + s + ", b=" + b + "]";
		}

	}
}
