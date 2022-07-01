import java.util.*;

public class fw {

	public static void main(String[] args) {
		long[][] mat = {
				{0, 5, 8},
				{1000, 0, 1},
				{1000, 1000, 0}
		};
		long[][] mat2 = {
				{0, 3, 8, 1000, -4},
				{1000, 0, 1000, 1, 7},
				{1000, 4, 0, 1000, 1000},
				{2, 1000, -5, 0, 1000},
				{1000, 1000, 1000, 6, 0}
		};
		Matrix2 m2 = new Matrix2(mat2);
		Matrix2 m3 = m2.mult(m2);
		System.out.println(m3);
		Matrix2 m4 = m2.mult(m3);
		System.out.println(m4);
		Matrix2 m5 = m2.mult(m4);
		System.out.println(m5);
		
		long[] vec = {0, 1000, 1000};
		for(int i = 0; i < 3; i++) {
			Matrix2 m = new Matrix2(mat);
			vec = m.lmult(vec);
			System.out.println(Arrays.toString(vec));
		}
	}
	
	static class Matrix2{
		long[][] mat; int n;
		public Matrix2(long[][] mat) {
			n = mat.length;
			this.mat = mat;
		}
		Matrix2 mult(Matrix2 m) {
			long[][] res = new long[n][n];
			for(int i = 0; i < n; i++) {
				Arrays.fill(res[i], 1000);
			}
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					long val = 1000;
					for(int k = 0; k < n; k++) {
						val = Math.min(val, mat[i][k] + m.mat[k][j]);
					}
					res[i][j] = val;
				}
			}
			return new Matrix2(res);
		}
		public String toString(){
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < n; i++) {
				sb.append(Arrays.toString(mat[i])+"\n");
			}
			return sb.toString();
		}
		long[] lmult(long[] vec) {
			long[] res = new long[n];
			Arrays.fill(res, 1000);
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					res[j] = Math.min(res[j], vec[i] + mat[i][j]);
				}
			}
			return res;
		}
	}
	
	static class Matrix{
		long[][] mat; int n;
		public Matrix(long[][] mat) {
			n = mat.length;
			this.mat = mat;
		}
		public Matrix(int n) {
			mat = new long[n][n];
			this.n = n;
			for(int i = 0; i < n; i++) mat[i][i] = 1;
		}
		Matrix mult(Matrix m) {
			long[][] res = new long[n][n];
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					long val = 0;
					for(int k = 0; k < n; k++) {
						val += (mat[i][k] * m.mat[k][j]);
					}
					res[i][j] = val;
				}
			}
			return new Matrix(res);
		}
		public String toString(){
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < n; i++) {
				sb.append(Arrays.toString(mat[i])+"\n");
			}
			return sb.toString();
		}
		long[] lmult(long[] vec) {
			long[] res = new long[n];
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					res[j] += vec[i] * mat[i][j];
				}
			}
			return res;
		}
	}

}
