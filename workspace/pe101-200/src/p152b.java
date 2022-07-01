import java.util.*;
public class p152b {

	static int N = 45; //idea: meet in the middle
	static long[] mod = {
			196709,196717
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
//		list = new LinkedList<>();
		int[] s = new int[p];
		for(int i = 0; i < p; i++) {
			s[i] = (int)inv(2, mod[i]);
		}
		metadp = new HashMap[N+1];
		for(int i = 0; i <= N; i++) {
			metadp[i] = new HashMap<>();
		}
		System.out.println(thing(N, s));
	}
	static long[][] f;
//	static LinkedList<Integer> list;
//	static double err = 0.00000001;
	static HashMap<Long, Integer>[] metadp;
	static int thing(int n, int[] s) {
		if(metadp[n].containsKey(toLong(s))) {
			return metadp[n].get(toLong(s));
		}
		else if(n == 1) {
			metadp[n].put(toLong(s), 1);
			return 1;
		}
		else {
			int res = 0;
			//do not add n
			boolean doit = true;
			for(int k = 0; k < p; k++) {
				if(!dp[k][n-1][s[k]]) doit = false;
			}
			if(doit) {
				res += thing(n-1, s);
			}
			//add n
//			list.add(n);
			int[] news = new int[p];
			doit = true;
			for(int k = 0; k < p; k++) {
				news[k] = (int)((s[k] - f[k][n] + mod[k]) % mod[k]);
				if(!dp[k][n-1][news[k]]) doit = false;
			}
			if(doit) {
				res += thing(n-1, news);
			}
			metadp[n].put(toLong(s), res);
			return res;
//			list.removeLast();
		}
	}
	static long toLong(int[] s) {
		return s[0] + mod[0] * s[1] + mod[0] * mod[1] * s[2];
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
