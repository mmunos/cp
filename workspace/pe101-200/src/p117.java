
public class p117 {

	public static void main(String[] args) {
		System.out.println(count(50));
	}
	static long count(int n) {
		long[][] dp = new long[n+1][7]; //0 1 1 2 1 2 3
										//0 1 2 3 4 5 6
		dp[0][0] = 1;
		for(int i = 0; i < n; i++) {
			//do not put a thing
			dp[i+1][0] = dp[i][0] + dp[i][1] + dp[i][3] + dp[i][6];
			//put a thing
			dp[i+1][1] = dp[i+1][2] = dp[i+1][4] = dp[i][0];
			dp[i+1][3] = dp[i][2];
			dp[i+1][5] = dp[i][4];
			dp[i+1][6] = dp[i][5];
		}
		return dp[n][0];
	}

}
