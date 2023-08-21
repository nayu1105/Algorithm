import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());

		PriorityQueue<Node> list = new PriorityQueue<>((p1, p2) -> {
			return p1.cost - p2.cost;
		});

		int[] answer = new int[N];
		int[] array = new int[200001];
		int sum = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int color = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			list.add(new Node(i, color, cost));
		}

		int before = 0;
		int beforeSum = 0;
		HashMap<Integer, Integer> colorMap = new HashMap<>();
		boolean check = false;
		int beforeColor = 0;

		for (int i = 0; i < N; i++) {
			Node node = list.poll();
			if (i != 0 && node.cost == before) {
				if (check) {
					colorMap = new HashMap<>();
					colorMap.put(beforeColor, 1);
					check = false;
				}
				if (colorMap.isEmpty()) {
					answer[node.index] = sum - array[node.color] - beforeSum;
					colorMap.put(node.color, 1);

				} else {
					if (colorMap.containsKey(node.color)) {
						answer[node.index] = sum - array[node.color] - beforeSum
								+ (colorMap.get(node.color) * node.cost);
						colorMap.put(node.color, colorMap.get(node.color) + 1);

					} else {
						answer[node.index] = sum - array[node.color] - beforeSum;
						colorMap.put(node.color, 1);
					}
				}
				beforeSum += node.cost;

			} else {				
				answer[node.index] = sum - array[node.color];
				before = node.cost;
				beforeSum = node.cost;
				beforeColor = node.color;
				check = true;
			}

			sum += node.cost;
			array[node.color] += node.cost;

		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
            sb.append(answer[i] + "\n");
        }
        System.out.print(sb.toString());
	}

	static class Node {
		int index;
		int color;
		int cost;

		public Node(int index, int color, int cost) {
			this.index = index;
			this.color = color;
			this.cost = cost;
		}
	}
}