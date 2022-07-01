import java.util.*;
public class p126b {

	public static void main(String[] args) {
		System.out.println(f(1, 1, 1, 2));
		int n = 5000;
		int N = 10000000;
		int[] count = new int[4*n+1];
		for(int a = 1; a <= n; a++) {
			for(int b = a; b <= n; b++) {
				for(int c = b; c <= n; c++) {
					for(int k = 1; k <= n; k++) {
						long v = f(a, b, c, k);
						if(v >= count.length) break;
						else count[(int)v]++;
					}
				}
			}
		}
		System.out.println("printing");
		for(int i = 1; i <= n*4; i++) {
			if(count[i] == 1000) System.out.println(i);
		}
	}
	static long f(int a, int b, int c, int k) {
		long u = 2 * (a * b + a * c + b * c);
		long v = 4 * (k - 1) * (a + b + c + k-2);
		return u + v;
	}

}
