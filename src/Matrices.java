
public class Matrices {
	
	public static int[][] createRandomMatrix(int rows, int columns, int minValue, int maxValue){
		int res[][] = new int [rows][columns];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				res[i][j] = (int) SportLotoAppl.getRandomInt(minValue, maxValue);
			}
		}
		return res;
	}
	public static int[][] transp(int[][] matrix) {
		int res[][] = new int[matrix[1].length][matrix.length];
		for(int i=0; i<res.length; i++) {
			for(int j=0; j<res[1].length; j++) {
				res[i][j]=matrix[j][i];				
			}			
		}
		return res;
	}
}
