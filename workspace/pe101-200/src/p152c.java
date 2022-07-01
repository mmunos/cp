import java.util.*;
public class p152c { //same thing but backwards

	static int N = 35;
	static long[] mod = {
			10000019, 10000079
	};
	static int p = mod.length;
	public static void main(String[] args) {
		
		System.out.println(inv(1*1, 3*3));
		System.out.println(inv(4*4, 3*3));
		System.out.println(inv(5*5, 3*3));
		
		f = new long[p][N+1];
		for(int j = 0; j < p; j++) {
			for(int i = 2; i < N+1; i++) {
				f[j][i] = inv(i * i, mod[j]);
			}
		}
		F = new double[N+1];
		double acc = 0;
		for(int i = 2; i <= N; i++) {
			acc += (1.0/i/i);
			F[i] = acc;
		}
		dp = new boolean[p][N+2][];
		for(int k = 0; k < p; k++) {
			dp[k] = new boolean[N+2][(int)mod[k]];
			dp[k][N+1][0] = true;
		}
		for(int i = N; i >= 2; i--) {
			for(int k = 0; k < p; k++) {
				for(int j = 0; j < mod[k]; j++) {
					if(dp[k][i+1][j]) {
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
		thing(0, 2, s);
		System.out.println(_t);
	}
	static long _t = 0;
	static long[][] f;
	static double[] F;
	static LinkedList<Integer> list;
	static double err = 0.000000001;
	static void thing(double sum, int n, int[] s) {
		_t++;
		if(_t % 100000000L == 0) {
			System.out.print("just checking ");
			System.out.println(list);
		}
		if(sum > 0.5 + err) return;
		if(sum + F[N] - F[n-1] < 0.5 - err) return;
		if(n > N) {
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
				if(!dp[k][n+1][s[k]]) {
					doit = false; break;
				}
			}
			if(doit) {
				thing(sum, n+1, s);
			}
			//add n
			int[] news = new int[p];
			doit = true;
			for(int k = 0; k < p; k++) {
				news[k] = (int)((s[k] - f[k][n] + mod[k]) % mod[k]);
				if(!dp[k][n+1][news[k]]) {
					doit = false; break;
				}
			}
			if(doit) {
				list.add(n);
				thing(sum + 1.0/n/n, n+1, news);
				list.removeLast();
			}
		}
	}
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
