import java.util.*;
public class p078b {

	public static void main(String[] args) {
		int N = 1000000;
		long mod = 1000000;
		long[] f = new long[N];
		f[0] = 1;
		f[1] = 1;
		for(int i = 2; i <= N; i++) {
			long curr = 0;
			for(int k = 1; ; k++) {
				int d = k * (3 * k - 1)/2;
				if(d > i) break;
				if(k % 2 == 1) {
					curr += f[i-d];
				}
				else {
					curr -= f[i-d];
				}
				curr %= mod;
				int e = k * (3 * k + 1)/2;
				if(e > i) break;
				if(k % 2 == 1) {
					curr += f[i-e];
				}
				else {
					curr -= f[i-e];
				}
				curr %= mod;
			}
			f[i] = curr;
			if(curr == 0) System.out.println(i);
		}
	}

}
