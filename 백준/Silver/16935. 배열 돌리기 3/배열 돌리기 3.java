import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M, R, O;
	static int ARRAY[][];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		ARRAY = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				ARRAY[i][j] =  Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < R; i++) {
			int n = Integer.parseInt(st.nextToken());
			switch(n) {
			case 1: op1(); break;
			case 2: op2(); break;
			case 3: op3(); break;
			case 4: op4(); break;
			case 5: op5(); break;
			case 6: op6(); break;			
			}
		}
		
		for (int i = 0; i < ARRAY.length; i++) {
			for (int j = 0; j < ARRAY[0].length; j++) {
				System.out.print(ARRAY[i][j]+" ");
			}
			System.out.println();
		}
	}

	static void op1() { // 상하 반전
		int n = ARRAY.length; // ARRAY : 기존 입력값 배열 static
		int m = ARRAY[0].length;
	    int[][] result = new int[n][m];
	    for (int i = 0; i < n; i++) {
	        for (int j = 0; j < m; j++) {
	            result[n - 1 - i][j] = ARRAY[i][j];
	        }
	    }

	    ARRAY = result;

	    return;
	}

	static void op2() { // 좌우 반전
		int n = ARRAY.length; // ARRAY : 기존 입력값 배열 static
		int m = ARRAY[0].length;
	    int[][] result = new int[n][m];

	    for (int i = 0; i < n; i++) {
	        for (int j = 0; j < m; j++) {
	            result[i][m - 1 - j] = ARRAY[i][j];
	        }
	    }

	    ARRAY = result;

	    return;
	}

	static void op3() { // rot_right
		int n = ARRAY.length; // ARRAY : 기존 입력값 배열 static
		int m = ARRAY[0].length;
		
		int[][] arr = new int[m][n];
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j <n; j++) {
				arr[i][n-1-j] = ARRAY[j][i];
			}
		}
		
		ARRAY = arr;
		
		return;
	}

	static void op4() { // rot_left
		int n = ARRAY.length;
		int m = ARRAY[0].length;
		
		int[][] arr = new int[m][n];
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j <n; j++) {
				arr[i][j] = ARRAY[j][m-1-i];
			}
		}
		
		ARRAY = arr;
		
		return;
	}
	
	static void op6() {
		int n = ARRAY.length;
		int m = ARRAY[0].length;
		
		int[][] arr = new int[n][m];
		
		for (int i = 0; i < n/2; i++) {
			for (int j = 0; j < m/2; j++) {
				arr[n/2+i][j] = ARRAY[i][j];
			}
		}
		
		for (int i = 0; i < n/2; i++) {
			for (int j = m/2; j < m; j++) {
				arr[i][j-m/2] = ARRAY[i][j];
			}
		}
		
		for (int i = n/2; i < n; i++) {
			for (int j = m/2; j < m; j++) {
				arr[i-n/2][j] = ARRAY[i][j];
			}
		}
		
		for (int i = n/2; i < n; i++) {
			for (int j = 0; j < m/2; j++) {
				arr[i][m/2+j] = ARRAY[i][j];
			}
		}
		
		ARRAY = arr;
		
	}
	
	static void op5() {
		int n = ARRAY.length;
		int m = ARRAY[0].length;
		
		int[][] arr = new int[n][m];
		
		for (int i = 0; i < n/2; i++) {
			for (int j = 0; j < m/2; j++) {
				arr[i][m/2+j] = ARRAY[i][j];
			}
		}
		
		for (int i = 0; i < n/2; i++) {
			for (int j = m/2; j < m; j++) {
				arr[i+n/2][j] = ARRAY[i][j];
			}
		}
		
		for (int i = n/2; i < n; i++) {
			for (int j = m/2; j < m; j++) {
				arr[i][j-m/2] = ARRAY[i][j];
			}
		}
		
		for (int i = n/2; i < n; i++) {
			for (int j = 0; j < m/2; j++) {
				arr[i-n/2][j] = ARRAY[i][j];
			}
		}
		
		ARRAY = arr;
		
	}
}
