import java.util.*;
public class p126 {

	public static void main(String[] args) {
		int n = 40;
		dp = new long[n+1][n+1][n+1];
		ArrayList[] count = new ArrayList[10000000];
		for(int i = 0; i < count.length; i++) {
			count[i] = new ArrayList<>();
		}
		for(int a = 1; a <= n; a++) {
			for(int b = a; b <= n; b++) {
				for(int c = b; c <= n; c++) {
					for(int k = 1; k <= n; k++) {
						long v = calc(a, b, c, k);
						if(v < count.length) {
							count[(int)v].add(String.format("%dx%dx%d-%d", a, b, c, k));
						}
					}
				}
			}
		}
		for(int i = 1; i <= 200; i++) {
			System.out.println(i+" "+count[i]);
		}
	}
	static long calc(int a, int b, int c, int k) {
		long v1 = c * lev(a, b, k);
		long v2 = 2 * levacc(a, b, k-1);
		return v1 + v2;
	}
	static long[][][] dp;
	static long levacc(int n, int m, int k) {
		if(dp[n][m][k] > 0) return dp[n][m][k];
		else if(k == 0) return dp[n][m][k] = lev(n, m, k);
 		else return dp[n][m][k] = dp[n][m][k-1] + lev(n, m, k);
	}
	static long lev(int n, int m, int k) { // m <= n
		if(k == 0) return n * m;
		else return 2*(n + m) + 4*(k-1);
	}

}
