import java.util.*;
import java.math.*;
public class p085 {

	public static void main(String[] args) {
		int n = 20000;
		int m = 20000;
		long nearest = 2000000;
		int x = -1, y = -1;
		for(int i = 1; i <= n; i++){
			for(int j = 1; j <= m; j++){
				long val = calc(i, j);
				long diff = Math.abs(val - 2000000);
				if(diff < nearest) {
					x = i; y = j; nearest = diff;
				}
			}
		}
		System.out.println(calc(x, y));
		System.out.println(x+" "+y);
		System.out.println(x * y);
	}
	public static long calc(long n, long m) {
		return n * (n+1) * m * (m+1) / 4;
	}
}
