
public class p115 {

	public static void main(String[] args) {
		int n = 168;
		int m = 50;
		long[][] dp = new long[n+2][m+1];
		dp[0][0] = 1;
		for(int i = 0; i <= n; i++) {
			//put a thing
			dp[i+1][0] = dp[i][0] + dp[i][m];
			for(int j = 1; j < m; j++) {
				dp[i+1][j] = dp[i][j-1];
			}
			dp[i+1][m] = dp[i][m] + dp[i][m-1];
		}
		System.out.println(dp[n+1][0]);

	}

}
