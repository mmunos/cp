
public class p135 {

	static int N = 50000000;
	static int[] sieve;
	public static void main(String[] args) {
		sieve = new int[N+1];  //is prime iff sieve[i] == i
		int sqN = (int)Math.sqrt(N);
		for(int i = 2; i <= N; i++) {
			if(sieve[i] == 0) {
				sieve[i] = i;
				if(i > sqN) continue;
				for(int j = i*i; j <= N; j += i) {
					sieve[j] = i;
				}
			}
		}
		sieve[1] = 1;
		int tot = 0;
		for(int i = 0; i <= N; i++) {
			if(fastcheck(i)) {
				tot++;
			}
		}
		System.out.println(tot);
	}
	static boolean fastcheck(int n) {
		if(n == 8 || n == 32) return false;
		if(sieve[n] == n) {
			if(n % 4 == 3) return true;
			else return false;
		}
		if(n % 4 == 0 && sieve[n / 4] == n / 4) return true;
		if(n % 16 == 0 && sieve[n / 16] == n / 16) return true;
		return false;
	}
	static int count(long n) {
		int res = 0;
		for(int d = 1; d*d <= n; d++) {
			if(n % d == 0) {
				if((n / d + d) % 4 == 0) {
					long a = (n / d + d) / 4;
					if(check(d + a, d, d - a)) res++;
					if(d*d != n) {
						if(check(n / d + a, n / d, n / d - a)) res++;
					}
				}
			}
		}
		return res;
	}
	static boolean check(long x, long y, long z) {
		return x > 0 && y > 0 && z > 0;
	}

}
