import java.util.*;

public class p149 {

	public static void main(String[] args) {
		int n = 2000;
		long[] seq = new long[n*n];
		long mod = 1000000, off = 500000;
		for(int i = 0; i < 55; i++) {
			long k = i+1;
			seq[i] = (100003L - 200003L*k + 300007L*k*k*k) % mod - off;
		}
		for(int i = 55; i < n*n; i++) {
			seq[i] = (seq[i-24] + seq[i-55] + 1000000) % mod - off;
		}
		long[][] map = new long[n][n];
		int ind = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				map[i][j] = seq[ind++];
			}
		}
		long res = 0;
		for(int i = 0; i < n; i++) {
			long curr = 0;
			for(int j = 0; j < n; j++) {
				curr += map[i][j];
				res = Math.max(res, curr);
				if(curr < 0) curr = 0;
			}
			curr = 0;
			for(int j = 0; j < n; j++) {
				curr += map[j][i];
				res = Math.max(res, curr);
				if(curr < 0) curr = 0;
			}
		}
		
		System.out.println(res);
	} 
	
}
