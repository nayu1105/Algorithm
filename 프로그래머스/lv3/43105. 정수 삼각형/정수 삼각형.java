import java.util.*;

class Solution {    
    public int solution(int[][] triangle) {
		int COL = triangle.length;
		int ROW = triangle[triangle.length - 1].length;


		for (int col = 1; col < COL; col++) {
            triangle[col][0] += triangle[col-1][0];
            triangle[col][col] += triangle[col-1][col-1];
			for (int row = 1; row < col; row++) {
                triangle[col][row] += Math.max(triangle[col - 1][row - 1], triangle[col - 1][row]);
			}
		}

		int max = 0;
		for (int index = 0; index < triangle[triangle.length - 1].length; index++) {
			int temp = triangle[COL - 1][index];
			if (max < temp)
				max = temp;
		}

		return max;
    }

}