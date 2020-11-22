public class ZeroMatrix {

	public static void main(String[] args) {
		int[][] mat = {{1,2,3,4},{4,0,6,7},{1,2,3,4},{4,5,6,0}};
		zeroMatrix(mat);
		int nRows = mat.length, nCols = mat[0].length;
		for(int i = 0; i < nRows; i++) {
			for(int j = 0; j < nCols; j++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void zeroMatrix(int[][] mat) {
		int nRows = mat.length, nCols = mat[0].length;
		for(int i = 0; i < nRows; i++) {
			for(int j = 0; j < nCols; j++) {
				if(mat[i][j] == 0) {
					//Mark first elements of the rows and columns to be zero'd out later
					mat[i][0] = 0;
					mat[0][j] = 0;
				}
			}
		}
		
		for(int i = 1; i < nRows; i++) {
			if(mat[i][0] == 0) {
				for(int j = 0; j < nCols; j++) {
					//Zero out rows
					mat[i][j] = 0;
				}
			}
		}
		
		for(int i = 1; i < nCols; i++) {
			if(mat[0][i] == 0) {
				for(int j = 0; j < nRows; j++) {
					//Zero out columns
					mat[j][i] = 0;
				}
			}
		}
		
		//Check mat[0][0] to avoid overwriting your O(m*n) work
		if(mat[0][0] == 0) {
			for(int i = 1; i < nRows; i++)
				mat[i][0] = 0;
			for(int j = 1; j < nCols; j++)
				mat[0][j] = 0;
		}
	}
}