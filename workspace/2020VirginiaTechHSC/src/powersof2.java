import java.util.*;
public class powersof2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long nin = sc.nextLong();
		if(nin < 10) {
			int e = sc.nextInt();
			int pow = 1 << e;
			int res = 0;
			for(int i = 0; i <= nin; i++) {
				if(i == pow) res++;
			}
			System.out.println(res);
		}
		else {
			char[] bign = (nin+"").toCharArray();
			int n = bign.length;
			int e = sc.nextInt();
			long pow = 1L << e;
			char[] s = (pow+"").toCharArray();
			g = new int[2*n+1][10];
			//first char
			int cd = bign[0] - '0';
			for(int d = 0; d <= 9; d++) {
				if(d < cd) g[0][d] = 1;
				else if(d == cd) g[0][d] = 2;
				else g[0][d] = 2*n;
			}
			//next chars
			int u = 1;
			for(int i = 1; i < n-1; i++) {
				for(int d = 0; d <= 9; d++) {
					g[u][d] = u + 2;
				}
				cd = bign[i] - '0';
				for(int d = 0; d <= 9; d++) {
					if(d < cd) g[u+1][d] = u+2;
					else if(d == cd) g[u+1][d] = u+3;
					else g[u+1][d] = 2*n;
				}
				u += 2;
			}
			//last char
			for(int d = 0; d <= 9; d++) {
				g[u][d] = u+2;
			}
			cd = bign[n-1] - '0';
			for(int d = 0; d <= 9; d++) {
				if(d <= cd) g[u+1][d] = 2*n-1;
				else g[u+1][d] = 2*n;
			}
			int m = s.length;
			int[] kmp = kmp(s);
			h = new int[m+1][10];
			for(int d = 0; d <= 9; d++) {
				if(d+'0' == s[0]) h[0][d] = 1;
				else h[0][d] = 0;
			}
			for(int i = 1; i < m; i++) {
				for(int d = 0; d <= 9; d++) {
					if(d+'0' == s[i]) h[i][d] = i+1;
					else if(d+'0' == s[kmp[i-1]]) h[i][d] = kmp[i-1] + 1;
					else if(d+'0' == s[0]) h[i][d] = 1;
					else h[i][d] = 0;
				}
			}
			for(int d = 0; d <= 9; d++) {
				h[m][d] = m;
			}
			dp = new long[2*n+1][m+1];
			for(int i = 0; i < 2*n-1; i++) {
				for(int j = 0; j < m+1; j++) {
					dp[i][j] = -1;
				}
			}
			for(int j = 0; j < m; j++) {
				dp[2*n-1][j] = 0;
			}
			dp[2*n-1][m] = 1;
			for(int j = 0; j <= m; j++) {
				dp[2*n][j] = 0;
			}
			System.out.println(dp(0, 0));
		}
	}
	static int[] kmp(char[] s) {
		int n = (int)s.length;
		int[] res = new int[n];
		for(int i = 1; i < n; i++) {
			int j = res[i-1];
			while (j > 0 && s[i] != s[j])
				j = res[j-1];
			if (s[i] == s[j])
				j++;
			res[i] = j;
		}
		return res;
	}
	static int[][] g, h;
	static long[][] dp; 
	static long dp(int i, int j) {
		if(dp[i][j] >= 0) return dp[i][j];
		else {
			long res = 0;
			for(int d = 0; d <= 9; d++) {
				res += dp(g[i][d], h[j][d]);
			}
			return dp[i][j] = res;
		}
	}
	
	

}

