import java.util.*;
import java.math.*;

public class CRTSolver {
	
	public static void main(String... thegame) {
		int[] ps = {3, 5, 7};
		int[] arr = {0, 2, 0};
		long res = solve(arr, ps);
		System.out.println(res);
	}
	static long solve(int[] a, int[] p) {
		int n = a.length;
		long[][] r = new long[n][n];
		for(int i = 0; i < n; ++i)
	        for(int j = i + 1; j < n; ++j)
	            r[i][j] = inv(p[i], p[j]);
		
		long result = 0, mult = 1;
        long x[] = new long[n];
        for (int i = 0; i < n; ++i) {
            x[i] = a[i];
            for (int j = 0; j < i; ++j) {
                long cur = (x[i] - x[j]) * 1l * r[j][i];
                x[i] = (cur % p[i] + p[i]) % p[i];
            }
            result += mult * x[i];
            mult *= p[i];
        }
        return result;
	}
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
