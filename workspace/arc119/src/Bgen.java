import java.util.*;
public class Bgen {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		int n = 2;
		int T = 0;
		for(int a = 0; a < (1 << n); a++) {
			for(int b = 0; b < (1 << n); b++) {
				sb.append(n+"\n");
				sb.append(pad(n, Integer.toBinaryString(a))+"\n");
				sb.append(pad(n, Integer.toBinaryString(b))+"\n"); T++;
			}
		}
		System.out.println(T);
		System.out.print(sb.toString());
	}
	static String pad(int n, String s) {
		return String.format("%"+n+"s", s).replaceAll(" ", "0");
	}
}
