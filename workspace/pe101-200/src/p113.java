import java.util.Arrays;

public class p113 {

	public static void main(String[] args) {
		int n = 100;
		long[][] dp = new long[n+1][10];
		Arrays.fill(dp[0], 1);
		for(int i = 1; i <= n; i++) {
			for(int d = 0; d <= 9; d++) {
				dp[i][d] = dp[i-1][d];
				if(d > 0) dp[i][d] += dp[i][d-1];
			}
		}
		long res = dp[n][9];
		for(int i = 1; i <= n; i++) {
			res += count(i);
		}
		System.out.println(res - 9 * n - 1);
	}
	
	static long count(int n) {
		long[][] dp = new long[n+1][10];
		Arrays.fill(dp[0], 1);
		for(int i = 1; i <= n; i++) {
			for(int d = 0; d <= 9; d++) {
				if(i == n && d == 0) continue;
				dp[i][d] = dp[i-1][d];
				if(d > 0) dp[i][d] += dp[i][d-1];
			}
		}
		return dp[n][9];
	}
	
	static boolean isbouncy(int x) {
		char[] s = (x+"").toCharArray();
		Arrays.sort(s);
		if((x+"").equals(new String(s))) return false;
		StringBuilder sb = new StringBuilder(x+"");
		sb.reverse();
		if(sb.toString().equals(new String(s))) return false;
		return true;
	}

}
