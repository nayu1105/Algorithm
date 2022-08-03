package BJ;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_2343_guitar_lesson {
	static int N, M;
	static int[] Array;
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		String[] s  = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		
		s = br.readLine().split(" ");
		
		Array = new int[s.length];
		int n = 0; // 배열 저장에만 쓰일 idx 변수
		int ini = 0; // 배열 중 최대 값 저장할 변수, 이진 탐색 초기 mid
		int ini_idx = 0; // 이진 탐색 초기 mid_idx
		
		for (String string : s) {
			Array[n++] = Integer.parseInt(string);
		}
		
		
		
		
	}
}
