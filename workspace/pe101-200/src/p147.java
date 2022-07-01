
public class p147 {

	public static void main(String[] args) {
		int n = 47, m = 43;
		long tot = 0;
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= m; j++) {
				tot += calc(i, j) + calc2(i, j);
			}
		}
		System.out.println(tot);
	}
	static long calc2(long n, long m) {
		long res = 0;
		for(long i = 1; i <= n; i++) {
			for(long j = 1; j <= m; j++) {
				res += (n-i+1) * (m-j+1);
			}
		}
		return res;
	}
	static long calc(long n, long m) {
		long res = 0;
		long af = n-1, bf = m, cf = n, df = m-1;
		for(int i = 1; af * bf + cf * df > 0; i++) {
			long a = af, b = bf, c = cf, d = df;
			for(int j = 1; a * b + c * d > 0; j++) {
				res += a * b + c * d;
				if(i % 2 == 1) {
					if(j % 2 == 1) {
						b--; c--;
					}
					else {
						a--; d--;
					}
				}
				else {
					if(j % 2 == 1) {
						c--; d--;
					}
					else {
						a--; b--;
					}
				}
			}
			if(i % 2 == 1) {
				bf--; cf--;
			}
			else {
				af--; df--;
			}
		}
		return res;
	}

}
