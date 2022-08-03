package BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj_17478_recursive_function {
	static int N, r; // 재귀해야하는 수, 재귀 스택 수

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
		recursive(r,"");
	}
	
	static void recursive(int n, String s) {
		System.out.println(s+"\"재귀함수가 뭔가요?\"");
		if(n==N) {
			System.out.println(s+"\"재귀함수는 자기 자신을 호출하는 함수라네\"");
			System.out.println(s+"라고 답변하였지.");
			return;
		}
		System.out.println(s+"\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.");
		System.out.println(s+"마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.");
		System.out.println(s+"그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"");
		
		recursive(n+1,s+"____");
		System.out.println(s+"라고 답변하였지.");
	}
	
//	static void recursive(int num) {
//		for (int i = 0; i < num; i++) {
//			System.out.print("____");
//		}
//		System.out.println("\"재귀함수가 뭔가요?\"");
//		
//		
//		if(num==N) {
//			for (int i = 0; i < num; i++) {
//				System.out.print("____");
//			}
//			System.out.println("\"재귀함수는 자기 자신을 호출하는 함수라네\"");
//			for (int i = 0; i < num; i++) {
//				System.out.print("____");
//			}
//			System.out.println("라고 답변하였지.");
//			return;
//		}
//		for (int i = 0; i < num; i++) {
//			System.out.print("____");
//		}
//		System.out.println("\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.");
//		for (int i = 0; i < num; i++) {
//			System.out.print("____");
//		}
//		System.out.println("마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.");
//		for (int i = 0; i < num; i++) {
//			System.out.print("____");
//		}
//		System.out.println("그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"");
//	
//		recursive(num+1);
//	
//		for (int i = 0; i < num; i++) {
//			System.out.print("____");
//		}
//		System.out.println("라고 답변하였지.");
//	
//	}
}