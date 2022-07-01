
public class p150 {

	public static void main(String[] args) {
		int n = 1000;
		long[][] mat = new long[n][n];
		long t = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j <= i; j++) {
				t = next(t);
				mat[i][j] = t - 524288L;
			}
		}
		long[][] acc = new long[n][n];
		for(int i = 0; i < n; i++) {
			long a = 0;
			for(int j = 0; j <= i; j++) {
				a += mat[i][j];
				acc[i][j] = a;
			}
		}
		long res = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j <= i; j++) {
				long curr = 0;
				for(int k = 0; i+k < n; k++) {
					curr += acc[i+k][j+k];
					if(j > 0) curr -= acc[i+k][j-1];
					res = Math.min(res, curr);
				}
			}
		}
		System.out.println(res);
	}
	static long next(long t) {
		return (615949L * t + 797807) % 1048576L;
	}

}
