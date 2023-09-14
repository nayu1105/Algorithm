class Solution {
    public static int snakesAndLadders(int[][] board) {
		// Convert board to one-dimensional array(map)

		int[] map = new int[board.length * board.length + 1];
		boolean check = true;
		int index = 1;

		for (int i = board.length - 1; i >= 0; i--) {
			if (check) {
				for (int j = 0; j < board.length; j++) {
					map[index++] = board[i][j];
				}
			} else {
				for (int j = board.length - 1; j >= 0; j--) {
					map[index++] = board[i][j];
				}
			}
			check = !check;
		}

		boolean[] visited = new boolean[board.length * board.length + 1];
		Queue<Integer> queue = new LinkedList<>();

		queue.offer(map[1] == -1 ? 1 : map[1]);
		visited[1] = true;
		int count = 0;

		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				Integer curr = queue.poll();
				if (curr == board.length * board.length)
					return count;

				for (int j = curr + 1; j <= Math.min(curr + 6, board.length * board.length); j++) {
					if (map[j] == -1) {
						if (!visited[j]) {
							queue.add(j);
							visited[j] = true;
						}
					} else {
						if (!visited[map[j]]) {
							queue.add(map[j]);
							visited[j] = true;
							visited[map[j]] = true;
						}
					}
				}

			}
			count++;
		}

		return -1;
	}


    public boolean check(int destination, int size){
        return destination>=0 && destination<size;
    }
}