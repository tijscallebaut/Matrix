package matrix;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class MatrixTest {

	@Test
	void test() {
		double[] elements = {3.1,5.1,1.1,2.2,3.2,1.3,1.1,2.2,3.3,1.1,1.2,1.3};
		Matrix myMatrix = new Matrix(4,3,elements);
		assertTrue(Arrays.deepEquals(
				new double[][] {{3.1,5.1,1.1},{2.2,3.2,1.3},{1.1,2.2,3.3},{1.1,1.2,1.3}},
				myMatrix.toMatrix()
			));
		assertArrayEquals(
				new double[] {3.1,5.1,1.1,2.2,3.2,1.3,1.1,2.2,3.3,1.1,1.2,1.3},
				myMatrix.toRowMajor()
			);
		assertArrayEquals(
				new double[] {3.1,2.2,1.1,1.1,5.1,3.2,2.2,1.2,1.1,1.3,3.3,1.3},
				myMatrix.toColumnMajor()
			);
		double[] scaled_elements = {6.2,10.2,2.2,4.4,6.4,2.6,2.2,4.4,6.6,2.2,2.4,2.6};
		Matrix myMatrix_scaled = new Matrix(4,3,scaled_elements);
		assertTrue(Arrays.deepEquals(myMatrix_scaled.toMatrix(), myMatrix.scale(2)));
		assertTrue(Arrays.deepEquals(myMatrix.scale(3), myMatrix.plus(myMatrix_scaled.toMatrix())));
	}

}
