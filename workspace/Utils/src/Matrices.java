import java.util.*;
public class Matrices {

	public static void main(String[] args) {
		
		double a = Math.cos(Math.PI * 0.105 / 2);
		double b = Math.sin(Math.PI * 0.105 / 2);
		double[][] mat = {{a,-b},{b,a}};
		MatrixD m = new MatrixD(mat);
		MatrixD curr = new MatrixD(2);//I_2
		System.out.println(pow(m, 9));
		System.out.println(pow(m, 10));
		System.out.println(pow(m, 11));
		
	}
	static MatrixD pow(MatrixD m, long exp) {
		MatrixD res = new MatrixD(m.n);
		MatrixD mapow = m;
		while(exp > 0) {
			if((exp & 1L) == 1) {
				res = res.mult(mapow);
			}
			mapow = mapow.mult(mapow);
			exp >>= 1;
		}
		return res;
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
		long[] mult(long[] vec) {
			long[] res = new long[n];
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					res[i] += vec[j] * mat[i][j];
				}
			}
			return res;
		}
	}
	
	static class MatrixD{
		double[][] mat; int n;
		public MatrixD(double[][] mat) {
			n = mat.length;
			this.mat = mat;
		}
		public MatrixD(int n) {
			mat = new double[n][n];
			this.n = n;
			for(int i = 0; i < n; i++) mat[i][i] = 1;
		}
		MatrixD mult(MatrixD m) {
			double[][] res = new double[n][n];
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					double val = 0;
					for(int k = 0; k < n; k++) {
						val += (mat[i][k] * m.mat[k][j]);
					}
					res[i][j] = val;
				}
			}
			return new MatrixD(res);
		}
		public String toString(){
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < n; i++) {
				sb.append(Arrays.toString(mat[i])+"\n");
			}
			return sb.toString();
		}
		double[] mult(double[] vec) {
			double[] res = new double[n];
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					res[i] += vec[i] * mat[i][j];
				}
			}
			return res;
		}
	}
	 
	Matrix inverse(Matrix A) { 
		   
		  int n = A.n; 
		  Matrix B = new Matrix(n); 
		 
		  for(int i = 0; i < n; ++i) { 
		    int l = i; 
		    for(int k = i+1; k < n; ++k) 
		      if(abs(A.mat[k][i]) > abs(A.mat[l][i])) 
		        l = k; 
		    if(l != i) { 
		      swap(A.mat[i], A.mat[l]); swap(B.mat[i], B.mat[l]); 
		    } 
		 
		    double a = 1.0/A.mat[i][i]; 
		    for(int j = i; j < n; ++j) A.mat[i][j] *= a; 
		    for(int j = 0; j < n; ++j) B.mat[i][j] *= a; 
		 
		    for(int k = i+1; k < n; ++k) { 
		      double a = A.mat[k][i]; 
		      for(int j = i; j < n; ++j) A.mat[k][j] -= a*A.mat[i][j]; 
		      for(int j = 0; j < n; ++j) B.mat[k][j] -= a*B.mat[i][j]; 
		    } 
		  } 
		 
		  for(int i = n-1; i >= 0; --i) { 
		    for(int k = i-1; k >= 0; --k) { 
		      double a = A.mat[k][i]; 
		      for(int j = i; j > k; --j) A.mat[k][j] -= a*A.mat[i][j]; 
		      for(int j = 0; j < n; ++j) B.mat[k][j] -= a*B.mat[i][j]; 
		    } 
		  } 
		 
		  return B; 
		}

}
