import java.util.*;
public class p111 {
	
	public static void main(String...strings) {
		long tot = 0;
		for(int d = 0; d <= 9; d++) {
			long v = s(10, d);
			System.out.println(v);
			tot += v;
		}
		System.out.println(tot);
	}
	static long s(int n, int d) {
		long res = 0;
		if(d == 0) {
			for(int i = 0; i < n; i++) {
				for(int k = 1; k <= 9; k++) {
					for(int k2 = 1; k2 <= 9; k2++) {
						char[] s = new char[n];
						Arrays.fill(s, (char)('0'+d));
						s[0] = (char)('0'+k);
						s[i] = (char)('0'+k2);
						long x = Long.parseLong(new String(s));
						if(isPrime(x)) {
							System.out.println("hey " + x);
							res += x;
						}
					}
				}
			}
		}
		else {
			for(int i = 0; i < n; i++) {
				for(int k = 0; k <= 9; k++) {
					char[] s = new char[n];
					Arrays.fill(s, (char)('0'+d));
					s[i] = (char)('0'+k);
					long x = Long.parseLong(new String(s));
					if(isPrime(x)) {
						System.out.println("hey " + x);
						res += x;
					}
				}
			}
			if(res == 0) {
				for(int i = 0; i < n; i++) {
					for(int j = i+1; j < n; j++) {
						for(int k = 0; k <= 9; k++) {
							for(int k2 = 0; k2 <= 9; k2++) {
								char[] s = new char[n];
								Arrays.fill(s, (char)('0'+d));
								s[i] = (char)('0'+k);
								s[j] = (char)('0'+k2);
								long x = Long.parseLong(new String(s));
								if(isPrime(x)) {
									System.out.println("hey " + x);
									res += x;
								}
							}
						}
					}
				}
			}
		}
		return res;
	}
	static boolean isPrime(long x) {
		for(long d = 2; d*d <= x; d++) {
			if(x % d == 0) return false;
		}
		return true;
	}

}
