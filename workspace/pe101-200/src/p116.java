
public class p116 {

	public static void main(String[] args) {
		
		System.out.println(count(2, 50)-1);
		System.out.println(count(3, 50)-1);
		System.out.println(count(4, 50)-1);

	}
	static long count(int m, int n) {
		long[][] dp = new long[n+2][m+1];
		dp[0][0] = 1;
		for(int i = 0; i <= n; i++) {
			//do not put a thing
			dp[i+1][0] = dp[i][0] + dp[i][m];
			//put a thing
			dp[i+1][1] = dp[i][0] + dp[i][m];
			for(int j = 2; j <= m; j++) {
				dp[i+1][j] = dp[i][j-1];
			}
		}
		return dp[n+1][0];
	}

}
