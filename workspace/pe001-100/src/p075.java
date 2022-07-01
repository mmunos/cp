import java.util.*;
public class p075 {

	public static void main(String[] args) {
		
		long _t1 = System.currentTimeMillis();
		
		long N = 1500000;
		long last = 1;
		int[] count = new int[(int)N+1];
		for(long a = 1; a <= N/3; a++) {
			long lowlim = (long)Math.sqrt(a * a + N * N) - N;
			for(long x = Math.max(1, lowlim); x < a; x++) {
				if(a * a % x == 0) {
					long y = a * a / x; // y > x
					if((x + y) % 2 == 1) continue;
					long b = (y-x)/2;
					if(b <= a) break;
					long c = (y+x)/2;
					if(a + b + c <= N) {
						count[(int)(a+b+c)]++;
					}
				}
			}
			if(a > 2 * last) {
				last = a;
				System.out.println(a);
			}
		}
		int tot = 0;
		for(int i = 0; i <= N; i++) {
			if(count[i] == 1) tot++;
		}
		System.out.println(tot);
		long _t2 = System.currentTimeMillis();
		
		System.out.println(_t2 - _t1 +" ms");
	}
	

}
