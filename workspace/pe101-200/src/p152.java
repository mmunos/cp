import java.util.*;
public class p152 {

	static int N = 80;
	static long[] mod = {
			1299817, 1299821, 1299827
	};
	static int p = mod.length;
	public static void main(String[] args) {
		f = new long[p][N+1];
		for(int j = 0; j < p; j++) {
			for(int i = 2; i < N+1; i++) {
				f[j][i] = inv(i * i, mod[j]);
			}
		}
		dp = new boolean[p][N+1][];
		for(int k = 0; k < p; k++) {
			dp[k] = new boolean[N+1][(int)mod[k]];
			dp[k][1][0] = true;
		}
		for(int i = 2; i <= N; i++) {
			for(int k = 0; k < p; k++) {
				for(int j = 0; j < mod[k]; j++) {
					if(dp[k][i-1][j]) {
						dp[k][i][j] = true;
						dp[k][i][(int)((j + f[k][i]) % mod[k])] = true;
					}
				}
			}
		}
		list = new LinkedList<>();
		int[] s = new int[p];
		for(int i = 0; i < p; i++) {
			s[i] = (int)inv(2, mod[i]);
		}
		thing(0, N, s);
	}
	static long[][] f;
	static LinkedList<Integer> list;
	static double err = 0.000000001;
	static void thing(double sum, int n, int[] s) {
		if(sum > 0.5 + err) return;
		if(n == 1) {
			System.out.println(list + " " + sum);
//			long res = 0;
//			for(int a: list) {
//				res = (res + f[a]) % mod;
//			}
//			System.out.println(list+" "+res);
//			if(Math.abs(sum - 0.5) < err) {
//				System.out.println(list+" "+sum);
////				System.out.println(sum);
//			}
		}
		else {
			//do not add n
			boolean doit = true;
			for(int k = 0; k < p; k++) {
				if(!dp[k][n-1][s[k]]) {
					doit = false; break;
				}
			}
			if(doit) {
				thing(sum, n-1, s);
			}
			//add n
			int[] news = new int[p];
			doit = true;
			for(int k = 0; k < p; k++) {
				news[k] = (int)((s[k] - f[k][n] + mod[k]) % mod[k]);
				if(!dp[k][n-1][news[k]]) {
					doit = false; break;
				}
			}
			if(doit) {
				list.add(n);
				if(n > lastn) {
					System.out.println("seeing "+n);
					lastn = n;
				}
				thing(sum + 1.0/n/n, n-1, news);
				list.removeLast();
			}
		}
	}
	static int lastn = 0;
	static boolean[][][] dp;
	static long inv(long a, long mod){
		return (gcdex(a, mod)[0] + mod) % mod;
	}
	static long[] gcdex(long a, long b){
		if(b > a) {
			long[] p = gcdex(b, a);
			return new long[] {p[1], p[0]};
		}
		else if(b == 0) return new long[] {1, 0};
		else{
			long[] p = gcdex(b, a % b);
			return new long[] {p[1], p[0] - p[1]*(a/b)};
		}
	}
	
}
