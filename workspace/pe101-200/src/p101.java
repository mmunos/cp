import java.util.*;
public class p101 {

	public static void main(String[] args) {
		int N = 12;
		for(int n = 1; n <= N; n++) {
			double[] poly = getpoly(n);
			for(int i = 1; i <= N; i++) {
				System.out.println(eval(poly, i));
			}
			System.out.println("");
		}
	}
	static double eval(double[] poly, double x) {
		double xi = 1;
		double res = 0;
		for(double d: poly) {
			res += d * xi;
			xi *= x;
		}
		return res;
	}
	static double[] getpoly(int n) {
		double[][] mat = new double[n][n+1];
		for(int i = 0; i < n; i++) {
			double x = i+1;
			for(int j = 0; j < n; j++) {
				mat[i][j] = Math.pow(x, j);
			}
			mat[i][n] = f(x);
		}
		double[] res = new double[n];
		int ress = gauss(mat, res);
		if(ress == 1) {
			return res;
		}
		else {
			return null;
		}
	}
	static double f(double x) {
		return (Math.pow(x, 11) + 1) / (x + 1);
	}
	
	static double EPS = 1e-9;
	static int INF = 2; // it doesn't actually have to be infinity or a big number

	static int gauss (double[][] a, double[] ans) {
	    int n = (int) a.length;
	    int m = (int) a[0].length - 1;

	    int[] where = new int[m];
	    Arrays.fill(where, -1);
	    for (int col=0, row=0; col<m && row<n; ++col) {
	        int sel = row;
	        for (int i=row; i<n; ++i) {
	            if (Math.abs(a[i][col]) > Math.abs(a[sel][col])) {
	                sel = i;
	            }
	        }
	        if (Math.abs(a[sel][col]) < EPS) {
	            continue;
	        }
	        for (int i=col; i<=m; ++i) {
	        	double aux = a[sel][i]; a[sel][i] = a[row][i]; a[row][i] = aux;
	        }
	        where[col] = row;

	        for (int i=0; i<n; ++i) {
	            if (i != row) {
	                double c = a[i][col] / a[row][col];
	                for (int j=col; j<=m; ++j) {
	                    a[i][j] -= a[row][j] * c;
	                }
	            }
	        }
	        ++row;
	    }

	    for (int i=0; i<m; ++i) {
	        if (where[i] != -1) {
	            ans[i] = a[where[i]][m] / a[where[i]][i];
	        }
	    }
	    for (int i=0; i<n; ++i) {
	        double sum = 0;
	        for (int j=0; j<m; ++j) {
	            sum += ans[j] * a[i][j];
	        }
	        if (Math.abs(sum - a[i][m]) > EPS) {
	            return 0;
	        }
	    }

	    for (int i=0; i<m; ++i) {
	        if (where[i] == -1) {
	            return INF;
	        }
	    }
	    return 1;
	}

}
