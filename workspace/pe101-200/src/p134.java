import java.util.*;
public class p134 {
	
	static int N = 1000100;
	public static void main(String[] args) {
		sieve = new int[N+1];  //is prime iff sieve[i] == i
		int sqN = (int)Math.sqrt(N);
		ArrayList<Integer> ps = new ArrayList<>();
		for(int i = 2; i <= N; i++) {
			if(sieve[i] == 0) {
				ps.add(i);
				sieve[i] = i;
				if(i > sqN) continue;
				for(int j = i*i; j <= N; j += i) {
					sieve[j] = i;
				}
			}
		}
		int m = ps.size();
		long res = 0;
		for(int i = 0; i < m; i++) {
			int p = ps.get(i);
			if(p >= 5 && p <= 1000000) {
				int q = ps.get(i+1);
				long pow10 = 1;
				while(pow10 <= p) pow10 *= 10;
				long pow10inv = inv(pow10 % q, q);
				long a = (q-p) * pow10inv % q;
				long s = pow10 * a + p;
				System.out.println(s);
				res += s;
			}
		}
		System.out.println(res);
	}
	static int[] sieve;
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
