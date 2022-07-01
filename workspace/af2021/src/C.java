import java.util.*;
public class C {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		s += s.charAt(0);
		boolean valid = false;
		for(int i = 0; i < s.length()-1; i++) {
			String t = s.substring(i, i+2);
			if(ccheck(t)) valid = true;
		}
		if(valid) System.out.println("YES");
		else System.out.println("NO");
	}
	static boolean ccheck(String str) {
		char[] s = str.toCharArray();
		int[] count = new int[26];
		for(char c: s) {
			count[c-'A']++;
		}
		return check(count);
	}
	static boolean check(int[] c) {
		if(c[0] >= 2) return true;
		if(c[0] > 0 && c[1] > 0) return true;
		if(c[1] > 0 && c[2] > 0) return true;
		if(c[2] > 0 && c[4] > 0) return true;
		if(c[4] > 0 && c[7] > 0) return true;
		if(c[7] > 0 && c[12] > 0) return true;
		if(c[12] > 0 && c[20] > 0) return true;
		if(c[20] > 0 && c[0] > 0) return true;
		return false;
	}

}
