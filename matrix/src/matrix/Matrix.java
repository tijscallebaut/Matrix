package matrix;

public class Matrix {
	
	private double[][] Matrix;
	private int rows;
	private int columns;
	
	
	public Matrix(int rows, int columns, double[] elements) {
		double[][] matrix = new double[rows][columns];
		for (int row = 0; row < rows; row++)
		    for (int column = 0; column < columns; column++)
		    	matrix[row][column] = elements[row*columns + column];
		this.Matrix = matrix;
		this.rows = rows;
		this.columns = columns;
	}
	public double[][] toMatrix() {
		return Matrix.clone();
	}
	public int getColumns() {
		return columns;
	}
	public int getRows() {
		return rows;
	}
	public double[] toRowMajor() {
		double[] array = new double[rows*columns];
		for (int row = 0; row < rows; row++)
		    for (int column = 0; column < columns; column++)
		    	array[row*columns + column] = Matrix[row][column];
		return array;
	}
	public double[] toColumnMajor() {
		double[] array = new double[rows*columns];
		for (int column = 0; column < columns; column++)
		    for (int row = 0; row < rows; row++)
		    	array[rows*column + row] = Matrix[row][column];
		return array;
	}
	public double[][] scale(double scalar) {
		double[][] matrix = new double[rows][columns];
		for (int row = 0; row < rows; row++)
		    for (int column = 0; column < columns; column++)
		    	matrix[row][column] = scalar * Matrix[row][column];
		return matrix;
	}
	public double[][] plus(double[][] matrix2) {
		double[][] result = new double[rows][columns];
		for (int row = 0; row < rows; row++)
		    for (int column = 0; column < columns; column++)
		    	result[row][column] = matrix2[row][column] + Matrix[row][column];
		return result;
	}
	public double[][] mutate_scale(double scalar) {
		for (int row = 0; row < rows; row++)
		    for (int column = 0; column < columns; column++)
		    	Matrix[row][column] = scalar * Matrix[row][column];
		return Matrix;
	}
	public double[][] mutate_plus(double[][] matrix2) {
		for (int row = 0; row < rows; row++)
		    for (int column = 0; column < columns; column++)
		    	Matrix[row][column] = matrix2[row][column] + Matrix[row][column];
		return Matrix;
	}


}
