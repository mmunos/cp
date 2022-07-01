import java.util.*;
import java.math.*;
public class p080 {

	public static void main(String[] args) {
		int tot = 0;
		for(int i = 2; i < 100; i++) {
			tot += sum(i);
		}
		System.out.println(tot);
	}
	static long sum(int x) {
		BigInteger curr = BigInteger.valueOf((long)Math.sqrt(x));
		if(curr.multiply(curr).equals(BigInteger.valueOf(x))) return 0;
		BigInteger pow10 = BigInteger.valueOf(100);
		for(int iter = 0; iter < 100; iter++) {
			int d = 9;
			for(; d >= 0; d--) {
				BigInteger test = curr.multiply(BigInteger.TEN).add(BigInteger.valueOf(d));
				if(test.multiply(test).compareTo(pow10.multiply(BigInteger.valueOf(x))) <= 0) {
					break;
				}
			}
			curr = curr.multiply(BigInteger.TEN).add(BigInteger.valueOf(d));
			pow10 = pow10.multiply(BigInteger.TEN).multiply(BigInteger.TEN);
		}
		char[] s = curr.toString().toCharArray();
		int res = 0;
		for(int i = 0; i < 100; i++) {
			res += s[i]-'0';
		}
		return res;
	}

}
