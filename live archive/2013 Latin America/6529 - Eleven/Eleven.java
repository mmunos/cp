import java.util.*;
import java.io.*;
public class Eleven {
	static final long M = (long)1e9+7;
	static long[][] C = new long[51][51];
	public static void main(String...thegame) throws Exception{
		precalc();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true){
			String line = br.readLine();
			if(line == null) break;
			System.out.println(process(line.trim()));
		}
	}
	public static long process(String str){
		int[] q = new int[10];
		char[] num = str.toCharArray();
		for(char c: num) q[c-'0']++;
		int L = str.length();
		int n = (L+1)/2; int m = L-n; //n = odd slots, m = even slots
		//dp[s][d][r] stores the number of ways of using numbers in {0,...,s} to fill
		//d odd slots and (L-n)-(q[0]+...+q[s]-d) even slots such that the sum of the numbers in
		//the odd slots minus the sum of the numbers in the even slots is equal to r (mod 11).
		long[][][] dp = new long[10][n+1][11];
		for(int k = 0; k <= q[0]; k++){
			int l = q[0] - k;
			if(l > m || k > n-1) continue;
			dp[0][k][0] = (C[n-1][k] * C[m][l]) % M; // n-1 is to ignore numbers that start with 0
		}
		int totq = q[0];
		for(int s = 1; s <= 9; s++){
			for(int d = 0; d <= totq; d++){
				for(int k = 0; k <= q[s]; k++){
					int f = n - d; 			//free even slots
					int g = m - totq + d; 	//free odd slots
					int l = q[s] - k;
					if(f < k || g < l) continue;
					for(int r = 0; r < 11; r++){
						int dif = (s*(k-l) %11)+ 11;
						dp[s][d+k][(r+dif)%11] += (dp[s-1][d][r]*((C[f][k]*C[g][l])%M))%M;
						dp[s][d+k][(r+dif)%11] %= M;
					}
				}
			}
			totq += q[s];
		}
		return dp[9][n][0];
	}
	public static void precalc(){
		C[0][0] = 1; C[1][0] = 1; C[1][1] = 1;
		for(int n = 2; n <= 50; n++){
			C[n][0] = 1; C[n][n] = 1;
			for(int m = 1; m <= n; m++){
				C[n][m] = (C[n-1][m-1] + C[n-1][m]) % M;
			}
		}
	}
}
