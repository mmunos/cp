import java.util.*;
public class p078 {

	public static void main(String[] args) {
		int N = 100000;
		int mod = 1000000;
		int[][] dp = new int[N+1][];
		dp[0] = new int[] {1};
		for(int i = 1; i < N; i++){
			dp[i] = new int[i+1];
			for(int j = 1; j <= i; j++) {
				if(j <= i-j) {
					dp[i][j] = (dp[i][j-1] + dp[i-j][j]) % mod;
				}
				else {
					dp[i][j] = (dp[i][j-1] + dp[i-j][i-j]) % mod;
				}
			}
//			System.out.println(Arrays.toString(dp[i]));
			if(dp[i][i] == 0) {
				System.out.println(i);
			}
		}

	}

}
