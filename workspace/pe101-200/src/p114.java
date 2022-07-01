
public class p114 {

	public static void main(String[] args) {
		int n = 29;
		long[][] dp = new long[n+2][4];
		dp[0][0] = 1;
		for(int i = 0; i <= n; i++) {
			//put a thing
			dp[i+1][3] = dp[i][3] + dp[i][2];
			dp[i+1][2] = dp[i][1];
			dp[i+1][1] = dp[i][0];
			//do not put a thing
			dp[i+1][0] = dp[i][0] + dp[i][3]; 
		}
		System.out.println(dp[n+1][0]);

	}

}
