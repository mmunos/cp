import java.util.*;
public class A {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		long n = sc.nextLong();
		int e = 0;
		long res = n;
		while((1L << e) <= n) {
			res = Math.min(res, e + n / (1L << e) + n % (1L << e));
			e++;
		}
		System.out.println(res);

	}

}
