import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Map.Entry;

class Main {

	/*
 	  DFS 		    : O((N * M)^4)
 	  DFS + Memoization : O(N * M ) 
 	*/
	
	/* 
 	   map : 입력 받는 지도
	   serach : 탐색하며 도착점까지 갈 수 있는 경우의 저장 ( default : -1. 탐색하지 않은 경우.) 
    							   -> 설정하는 이유 : 노드 탐색의 유무 구분
	   N : 세로 , M : 가로
	*/
	
	static int[][] map, search;
	static int N, M;

	// 탐색할 수 있는 방향 (우, 하, 상, 좌)
	static int[] dy = { 0, 1, -1, 0 };
	static int[] dx = { 1, 0, 0, -1 };

	public static void main(String[] args) throws IOException {
		// 입력 시작
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 세로
		N = Integer.parseInt(st.nextToken());
		// 가로
		M = Integer.parseInt(st.nextToken());

		// map, search 크기 설정
		map = new int[N][M];
		search = new int[N][M];

		// search -1 default 설정
		for (int i = 0; i < N; i++) {
			Arrays.fill(search[i], -1);
		}

		// map 에 입력값 넣기
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 입력 끝

		// 솔루션 시작 및 정답 출력
		System.out.println(solution());

	}

	// 문제 솔루션
	static int solution() {
		// 시작점(0,0) 부터 도착점(N-1,M-1)까지 모든 경우 dfs 탐색하며 가보기.
		// 백트래킹으로 모든 탐색이 끝나면 search(0,0)에 저장 된 값 리턴받기.
		return dfs(new Node(0, 0));
	}

	static int dfs(Node node) {
		// end 조건 1 : 도착점에 도달했을 때. 1가지 경우의 수 리턴.
		if (node.y == N - 1 && node.x == M - 1) {
			return 1;
		}

		// end 조건 2 : 이미 탐색한 적이 있는 노드 일 경우 '도착점까지 갈 수 있는 경우의 수'(search[node.y][node.x]) 리턴.
		if (search[node.y][node.x] != -1) {
			return search[node.y][node.x];
		}

		// end 조건에서 빠져나가지 못한 경우 : 한번도 탐색한 적 없는 노드 -> 탐색 시켜야 함
		// 0으로 초기화
		search[node.y][node.x] = 0;

		// 4방향 탐색
		for (int i = 0; i < 4; i++) {
			// 새로운 경로 설정
			int nx = node.x + dx[i];
			int ny = node.y + dy[i];

			// map크기 벗어낫는지 체크
			if (!check(ny, nx))
				continue;

			/* 
   			   문제 조건 : 언제나 자신보다 낮은 숫자로만 갈 수 있다.
			
			   map[ny][nx] : 새로 갈 수 있는 노드
			   map[node.y][node.x] : 현재 노드

			   새로 갈 수 있는 노드 < 현재 노드
			*/
			
			if (map[ny][nx] < map[node.y][node.x]) {
				// 다음 경로로 이동하여 탐색
				// 리턴 값을 누적
				search[node.y][node.x] += dfs(new Node(ny, nx));
				
			}
			
		}

		// 누적된 경우의 수 리턴
		return search[node.y][node.x];
	}

	// map의 크기( N * M )를 벗어낫는지 체크하는 함수
	static boolean check(int y, int x) {
		return y >= 0 && y < N && x >= 0 && x < M;
	}

	// map, search의 한 정점. Node(y,x)
	public static class Node {
		int y, x;

		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}

	}

}
