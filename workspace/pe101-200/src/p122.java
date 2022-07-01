import java.util.*;
public class p122 {
	
	public static void main(String...strings) {
		dp2 = new long[201][201];
		for(int i = 0; i <= 200; i++) {
			for(int j = 0; j <= 200; j++) {
				dp2[i][j] = -1;
			}
		}
		dp1 = new long[201];
		Arrays.fill(dp1, -1);
		dp1[1] = 0;
		long tot = 0;
		for(int i = 1; i <= 200; i++) {
			long v = calc1(i);
			tot += v;
			System.out.println(i+" "+v);
		}
		System.out.println(tot);
	}
	static long[][] dp2;
	static long[] dp1;
	static long calc1(int n) {
		if(dp1[n] >= 0) return dp1[n];
		long min = n;
		for(int i = 1; i <= n/2; i++) {
			min = Math.min(min, calc2(i, n-i) + 1);
		}
		return dp1[n] = min;
	}
	static long calc2(int a, int b) {
		if(b < a) return calc2(b, a);
		if(a == b) return dp2[a][b] = calc1(a);
		if(dp2[a][b] >= 0) return dp2[a][b];
		else {
			long min = calc2(b-a, a) + 1;
			if(b % 2 == 0) min = Math.min(min, calc2(a, b/2) + 1);
			return dp2[a][b] = min;
		} 
		
	}
}
