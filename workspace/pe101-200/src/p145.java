
public class p145 {

	public static void main(String[] args) {
		int n = 1000000000;
		int c = 0;
		for(int i = 0; i < n; i++) {
			if(i % 10 != 0 && check(i)) c++;
		}
		System.out.println(c);
	}
//	static boolean check(long x) {
//		String s = ""+x;
//		StringBuilder sb = new StringBuilder(s);
//		String t = sb.reverse().toString();
//		char[] u = (""+(x + Long.parseLong(t))).toCharArray();
//		for(char c: u) {
//			if((c - '0') % 2 == 0) return false;
//		}
//		return true;
//	}
	static boolean check(long x) {
		char[] s = (""+x).toCharArray();
		long y = 0;
		for(int i = 0; i < s.length; i++) {
			y *= 10;
			y += (s[s.length-1-i]-'0');
		}
		y += x;
		while(y > 0) {
			long d = y % 10;
			if(d % 2 == 0) return false;
			y /= 10;
		}
		return true;
	}

}
