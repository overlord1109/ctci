public class RotateMatrix {
	public static void main(String[] args) {
		int[][] num4 = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12},{13,14,15,16}};
		int[][] num3 = {{1,2,3}, {4,5,6}, {7,8,9}};

		int[][] num = num4;
		rotateMatrix(num);
		int n = num[0].length;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j<n; j++) {
				System.out.print(num[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void rotateMatrix(int[][] matrix) {
		int n = matrix[0].length;
		for(int ring = 0; ring < (n + 1) / 2; ring++) {			
			for(int i = ring; i < n - ring - 1; i++) {
				int temp1 = matrix[i][n - 1 - ring];
				matrix[i][n - 1 - ring] = matrix[ring][i];
				int temp2 = matrix[n - 1 - ring][n - 1 - i];
				matrix[n - 1 - ring][n - 1 - i] = temp1;
				temp1 = matrix[n - 1 - i][ring];
				matrix[n - 1 - i][ring] = temp2;
				matrix[ring][i] = temp1;
			}
		}
	}
}