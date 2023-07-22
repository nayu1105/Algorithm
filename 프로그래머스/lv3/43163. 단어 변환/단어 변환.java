import java.util.*;
class Solution {
   	static boolean[][] map;
	static boolean[] visited;
	static int answer = 0;
	static int mapSize = 0;
	static int targetIndex = -1;

    public int solution(String begin, String target, String[] words) { 
		mapSize = words.length + 1;
		map = new boolean[mapSize][mapSize];
		visited = new boolean[mapSize];

		String[] arr = initArray(begin, target, words);
		if (targetIndex == -1)
			return 0;

		setMap(arr);
		bfs(arr.length);

		if (visited[targetIndex])
			return answer;
		else
			return 0;
    }
    
	static String[] initArray(String begin, String target, String[] words) {
		String[] arr = new String[mapSize];

		arr[0] = begin;
		for (int i = 1; i < mapSize; i++) {
			arr[i] = words[i - 1];
			if (arr[i].equals(target))
				targetIndex = i;
		}

		return arr;

	}

	static void setMap(String[] strArray) {
		for (int i = 0; i < strArray.length; i++) {
			for (int j = 0; j < strArray.length; j++) {
				if (i == j)
					continue;
				if (isConvert(strArray[i], strArray[j]))
					map[i][j] = true;
			}
		}
	}

	static boolean isConvert(String str1, String str2) {
		char[] str1Array = str1.toCharArray();
		char[] str2Array = str2.toCharArray();
		int cnt = 0;

		for (int i = 0; i < str2Array.length; i++) {
			if (str1Array[i]!=str2Array[i])
				cnt++;

			if (cnt >= 2)
				break;
		}

		if (cnt <= 1)
			return true;
		else
			return false;
	}

	static void bfs(int mapSize) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(0); // begin index
		visited[0] = true;
		
		while (!queue.isEmpty()) {
			int queueSize = queue.size();
			answer++;
			for (int i = 0; i < queueSize; i++) {
				int temp = queue.poll();
				for (int j = 0; j < mapSize; j++) {
					if (!visited[j] && map[temp][j]) {
						queue.offer(j);
						visited[j] = true;
						if (j == targetIndex)
							return;
					}
				}
			}
		}
	}
    
}