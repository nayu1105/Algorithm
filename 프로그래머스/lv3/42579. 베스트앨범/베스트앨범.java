import java.util.*;
class Solution {
    public static void main(String[] args) {
		String[] genres = new String[] { "classic", "pop", "classic", "classic", "pop" };
		int[] plays = new int[] { 500, 600, 150, 800, 2500 };
		int[] answer = solution(genres, plays);
		for (int i = 0; i < answer.length; i++) {
			System.out.println(answer[i]);
		}
	}

	static public int[] solution(String[] genres, int[] plays) {
		HashMap<String, Integer> map = new HashMap<>();
		List<Integer> sum = new ArrayList<>();
		List<PriorityQueue<Music>> pqList = new ArrayList<>();

		for (int i = 0; i < genres.length; i++) {
			if (!map.containsKey(genres[i])) {
				int index = map.size();
				map.put(genres[i], index);
				sum.add(plays[i]);
				pqList.add(new PriorityQueue<Music>());
				pqList.get(index).add(new Music(genres[i], plays[i], i));
			}
			else {
				int genresIndex = map.get(genres[i]);
				sum.set(genresIndex, sum.get(genresIndex) + plays[i]);
				pqList.get(genresIndex).add(new Music(genres[i], plays[i], i));
			}
		}

		List<Integer> answer = new ArrayList();

		for (int i = 0; i < sum.size(); i++) {
			int index = findMax(sum);
			if (pqList.get(index).size() == 1) {
				answer.add(pqList.get(index).poll().index);
			} else {
				answer.add(pqList.get(index).poll().index);
				answer.add(pqList.get(index).poll().index);
			}
			sum.set(index, 0);

		}

		int[] answerArray = new int[answer.size()];

		for (int i = 0; i < answer.size(); i++) {
			answerArray[i] = answer.get(i);
		}

		return answerArray;
	}

	static public int findMax(List<Integer> list) {
		int max = list.get(0);
		int index = 0;
		for (int i = 1; i < list.size(); i++) {
			if (list.get(i) > max) {
				max = list.get(i);
				index = i;
			}
		}
		return index;
	}

	static class Music implements Comparable<Music> {
		String genre;
		int play;
		int index;

		public Music(String genre, int play, int index) {
			this.genre = genre;
			this.play = play;
			this.index = index;
		}

		@Override
		public int compareTo(Music m1) {
			return m1.play == this.play ? this.index - m1.index : m1.play - this.play;
		}
	}
}