import java.util.*;
import java.io.*;


public class Main
{


	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		PriorityQueue<Node> all = new PriorityQueue<>((p1, p2)-> p2.score - p1.score);
		int[] sum = new int[N];
		for(int i=0; i<3; i++){
			PriorityQueue<Node> round = new PriorityQueue<>((p1, p2)-> p2.score - p1.score);
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++){
				int temp =Integer.parseInt(st.nextToken());
				round.add(new Node(j, temp));
				sum[j] += temp;
			}

			calcRank(N, round);

		}

		for(int i=0; i<N; i++){
			all.add(new Node(i, sum[i]));
		}

		calcRank(N, all);
	}

	static void calcRank(int N, PriorityQueue<Node> pq){
		int[] answer= new int[N];
		
		Node before = pq.poll();
		int count = 1;
		int rank = 1;
		answer[before.index] = rank;

		while(!pq.isEmpty()){
			Node pre = pq.poll();
			if(pre.score == before.score){
				count++;
				answer[pre.index] = rank;
			}
			else{
				rank+= count;
				count = 1;
				answer[pre.index] = rank;
				before=pre;
			}
		}

		for(int i=0; i<N; i++){
			if(i==0){
				System.out.print(answer[i]);
			}
			else{
				System.out.print(" "+answer[i]);
			}
		}
		System.out.println();
	}

	static class Node{
		int index;
		int score;

		public Node(int index, int score){
			this.index = index;
			this.score = score;
		}
	}

}
