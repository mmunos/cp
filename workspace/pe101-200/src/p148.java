import java.util.*;
public class p148 {

	public static void main(String[] args) {
		long n = 1000000000;
		System.out.println(calc(n, 7));
	}
	
	static long calc(long n, int p) {
		if(n == 0) return 0;
		long pind = 1;
		long prev = 1;
		while(true) {
			long curr = 0;
			long ind = 0;
			for(int i = 1; i <= p; i++) {
				if(ind + pind > n) {
					long x = calc(n - ind, p) * i;
					return x + curr;
				}
				ind += pind;
				curr += prev * i;
			}
			prev = curr;
			pind = ind;
		}
	}

}
