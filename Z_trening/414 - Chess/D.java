import java.io.*;
import java.util.*;
public class D {
	
	static int[] nextval = new int[683];
	static boolean[][] comp = new boolean[683][683];
	static int[] rank = new int[683];
	static int M = 1000007;
	public static void main(String[] args) throws Exception {
		int lastval = 0;
		Arrays.fill(nextval, -1);
		for(int h = 1; h < 683; h++){
			if(valid(h)){
				nextval[lastval] = h;
				lastval = h;
			}
			rank[h] = rank(h);
			int g = 0;
			while(g >= 0 && g < h){
				comp[h][g] = compatible(h,g);
				g = nextval[g];
			}
		}
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int maxm = (1 << m);
		if(m == 8) maxm = 171;
		if(m == 9) maxm = 342;
		if(m == 10) maxm = 683;
		int[][][] dp = new int[n][maxm][k+1];
		for(int i = 0; i < n; i++){
			if(i == 0){
				int hash = 0;
				while(hash >= 0 && hash < maxm){
					int r = rank[hash];
					if(r <= k) dp[0][hash][r] = 1;
					hash = nextval[hash];
				}
			}
			else{
				int hash = 0;
				while(hash >= 0 && hash < maxm){
					int r = rank[hash];
					for(int s = 0; s+r <= k; s++){
						int h = 0;
						while(h >= 0 && h < maxm){
							if(comp(hash,h)){
								dp[i][hash][s+r] = sum(dp[i][hash][s+r], dp[i-1][h][s]);
							}
							h = nextval[h];
						}
					}
					hash = nextval[hash];
				}
			}
		}
		int res = 0, hash = 0;
		while(hash >= 0 && hash < maxm){
			res = sum(res, dp[n-1][hash][k]); 
			hash = nextval[hash];
		}
		System.out.println(res);
	}
	static boolean comp(int h1, int h2){
		if(h1 == 0 && h2 == 0) return true;
		else if(h1 == h2) return false;
		if(h1 < h2) return comp[h2][h1];
		else return comp[h1][h2];
	}
	static int sum(int a, int b){
		return (a+b)%M;
	}
	static boolean king(int hash, int pos){
		return (hash & (1 << pos)) > 0;
	}
	static boolean valid(int hash){
		for(int i = 0; i < 10; i++){
			if(king(hash, i) && king(hash, i+1)) return false;
		}
		return true;
	}
	static boolean compatible(int h1, int h2){
		for(int i = 0; i < 10; i++){
			if(i > 0){
				if(king(h1, i) && king(h2, i-1)) return false;
				if(king(h1, i-1) && king(h2, i)) return false;
			}
			if(king(h1, i) && king(h2, i)) return false;
			if(i < 9){
				if(king(h1, i) && king(h2, i+1)) return false;
				if(king(h1, i+1) && king(h2, i)) return false;
			}
		}
		return true;
	}
	static int rank(int x){
		int res = 0;
		while(x > 0){
			if((x&1)==1) res++;
			x >>= 1;
		}
		return res;
	}
}
