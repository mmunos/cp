import java.util.*;
public class p112 {
	
	public static void main(String...strings) {
		int cb = 0;
		int N = 1588304;
		for(int i = 1; i <= N; i++) {
			if(isbouncy(i)) cb++;
			System.out.println(i+" "+cb*1.0/i);
		}
	}
	static boolean isbouncy(int x) {
		char[] s = (x+"").toCharArray();
		Arrays.sort(s);
		if((x+"").equals(new String(s))) return false;
		StringBuilder sb = new StringBuilder(x+"");
		sb.reverse();
		if(sb.toString().equals(new String(s))) return false;
		return true;
	}
}
