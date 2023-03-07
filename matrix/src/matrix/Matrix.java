package matrix;

/** 
 * @invar | 0 <= getRows()
 * @invar | 0 <= getColumns()
 * @invar | toMatrix() != null
 * @invar | toMatrix().length == getRows()
 * @invar | Arrays.stream(toMatrix()).allMatch(row -> row != null && row.length == getColumns())
 * 
 * @immutable
 */

public class Matrix {
	
	/**
	 * 
	 * @invar | 0 <= rows
     * @invar | 0 <= columns
     * @invar | Matrix != null
     * @invar | Matrix.length == rows
     * 
	 */
	
	private double[][] Matrix;
	private int rows;
	private int columns;
	
	/**
	 * @throws IllegalArgumentException | rows < 0
	 * @throws IllegalArgumentException | columns < 0
	 * @throws IllegalArgumentException | elements == null
	 * @throws IllegalArgumentException | elements.length != rows * columns
	 * @inspects | elements
	 * @post | getRows() == rows
	 * @post | getColumns() == columns
	 * @post | Arrays.equals(toRowMajor(), elements)
	 */
	public Matrix(int rows, int columns, double[] elements) {
		double[][] matrix = new double[rows][columns];
		for (int row = 0; row < rows; row++)
		    for (int column = 0; column < columns; column++)
		    	matrix[row][column] = elements[row*columns + column];
		this.Matrix = matrix;
		this.rows = rows;
		this.columns = columns;
	}
	/**
	 * @pre | 0 <= rowIndex && rowIndex < getRows()
	 * @pre | 0 <= columnIndex && columnIndex < getColumns()
	 * @post | result == toMatrix()[rowIndex][columnIndex]
	 */
	public double getElementAt(int rowIndex, int columnIndex) {
		return Matrix[rowIndex][columnIndex]
	}
	/**
	 * @post | result != null
	 * @post | result.length == getRows()
	 * @post | IntStream.range(0, getRows()).allMatch(i ->
	 *       |     IntStream.range(0, getColumns()).allMatch(j ->
	 *       |         toRowMajor[i * getColumns() + j] == result()[i][j]
	 *       |     )
	 *       | )
	 * @creates | result
	 */
	public double[][] toMatrix() {
		return Matrix.clone();
	}
	public int getColumns() {
		return columns;
	}
	public int getRows() {
		return rows;
	}
	/**
	 * @post | result != null
	 * @post | result.length == getRows()*getColumns()
	 * @post | IntStream.range(0, getRows()).allMatch(i ->
	 *       |     IntStream.range(0, getColumns()).allMatch(j ->
	 *       |         result[i * getColumns() + j] == toMatrix()[i][j]
	 *       |     )
	 *       | )
	 * @creates | result
	 */
	public double[] toRowMajor() {
		double[] array = new double[rows*columns];
		for (int row = 0; row < rows; row++)
		    for (int column = 0; column < columns; column++)
		    	array[row*columns + column] = Matrix[row][column];
		return array;
	}
	/**
	 * @post | result != null
	 * @post | result.length == getRows()*getColumns()
	 * @post | IntStream.range(0, getRows()).allMatch(i ->
	 *       |     IntStream.range(0, getColumns()).allMatch(j ->
	 *       |         result[j * getRows() + i] == toMatrix()[i][j]
	 *       |     )
	 *       | )
	 * @creates | result
	 */
	public double[] toColumnMajor() {
		double[] array = new double[rows*columns];
		for (int column = 0; column < columns; column++)
		    for (int row = 0; row < rows; row++)
		    	array[rows*column + row] = Matrix[row][column];
		return array;
	}
	/**
	 * @inspects | this
	 * @post | result != null
	 * @post | result.getRowCount() == getRowCount()
	 * @post | result.getColumnCount() == getColumnCount()
	 * @post | IntStream.range(0, getRowCount()).allMatch(i ->
	 *       |     IntStream.range(0, getColumnCount()).allMatch(j ->
	 *       |         result.getElementAt(i, j) == getElementAt(i, j) * factor
	 *       |     )
	 *       | )
	 * @creates | result
	 */
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
