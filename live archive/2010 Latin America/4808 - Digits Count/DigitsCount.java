import java.util.*;
public class DigitsCount {
	public static void main(String...thegame) {
		Scanner seer = new Scanner(System.in);
		while(true){
			int a = seer.nextInt();
			int b = seer.nextInt();
			if(a == 0 && b == 0) return;
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < 10; i++){
				sb.append((count(b,i)-count(a-1,i))+" ");
			}
			System.out.println(sb.toString().trim());
		}
	}
	public static long count(int n, int d){
		long res = 0;
		for(int r = 0; r < Math.floor(Math.log10(n))+1; r++){
			res += count(n, d, r);
		}
		return res;
	}
	/**
	 * Counts the number of times the digit d appears at position r
	 * (from right to left) in the numbers from 1 to n
	 */
	public static long count(int n, int d, int r){
		// example: n = 1234567, r = 2
		long res = 0;
		long e = (int)Math.pow(10, r);
		long k = (n/e)%10; // digit of n in position r (ex: k = 5)
		long l = n/e/10; // number at the left of r (ex: l = 1234)
		long s = n%e; // number at the right of r (ex: s = 67)
		res += l*e;
		if(k == d) res += s+1;
		else if (k > d) res += e;
		if(d == 0) res -= e;
		return res;
	}
}
