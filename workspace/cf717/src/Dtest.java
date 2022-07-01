import java.util.*;
import java.math.*;
import java.io.*;
public class Dtest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int q = sc.nextInt();
		long[] arr = new long[n];
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextLong();
		}	
		for(int qi = 0; qi < q; qi++) {
			int L = sc.nextInt()-1;
			int R = sc.nextInt()-1;
			int res = 1;
			BigInteger tot = BigInteger.ONE;
			for(int i = L; i <= R; i++) {
				BigInteger a = BigInteger.valueOf(arr[i]);
				if(!tot.gcd(a).equals(BigInteger.ONE)) {
					res++;
					tot = a;
				}
				else tot = tot.multiply(a);
			}
			System.out.println(res);
		}
		
	}
	
	static long gcd(long a, long b) {
		if(b > a) return gcd(b, a);
		else if(b == 0) return a;
		else return gcd(b, a % b);
	}

}
