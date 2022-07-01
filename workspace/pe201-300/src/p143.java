import java.util.*;
public class p143 {

//	static HashSet<Long> sqs = new HashSet<>();
	public static void main(String[] args) {
		long _t = System.currentTimeMillis();
		int N = 120000;
		HashSet<Long>[] g = new HashSet[N+1];
		for(int i = 1; i <= N; i++) {
			g[i] = new HashSet<>();
			fill(g[i], i);
		}
		tstat(_t);
		TreeSet<Long> res = new TreeSet<>();
		for(int i = 1; i <= N; i++) {
			for(long u: g[i]) {
				for(long v: g[i]) {
					if(g[(int)u].contains(v)) res.add(i + u + v);
				}
			}
		}
		System.out.println(res);
		long tot = 0;
		for(long r: res) {
			if(r > N) break;
			tot += r;
		}
		System.out.println(tot);
		tstat(_t);
	}
	static void fill(HashSet<Long> vals, long N) {
		for(long i = 1; i < N; i++) {
			long a2 = N*N + i*i + N*i;
			if(issq(a2)) vals.add(i);
		}
	}
	static void check(long N) {
		for(long p = 1; p < N; p++){
			for(long q = p; N-p-q >= q; q++){
				long r = N-p-q;
				long a = q*q+r*r+q*r;
				long b = q*q+p*p+p*q;
				long c = p*p+r*r+p*r;
				if(issq(a) && issq(b) && issq(c)) {
					System.out.printf("%d=%d+%d+%d, %d %d %d\n", N, p, q, r, (long)Math.sqrt(a), (long)Math.sqrt(b), (long)Math.sqrt(c)); 
				}
			}
		}
	}
	static void tstat(long t1) {
		long _t2 = System.currentTimeMillis();
		double _dt = _t2 - t1;
		System.out.println(_dt/1000 + " secs");
	}
	
	static boolean issq(long x) {
//		return sqs.contains(x);
		long y = (long)Math.sqrt(x);
		return y * y == x;
	}
}
