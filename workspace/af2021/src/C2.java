import java.util.*;
public class C2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] s = sc.next().toCharArray();
		if(s.length < 3) System.out.println("YES");
		else {
			int a = s[0] - 'A';
			int b = s[1] - 'A';
			int c = s[2] - 'A';
			if((a + b) % 26 == c) {
				System.out.println("YES");
			}
			else {
				System.out.println("NO");
			}
		}
	}

}
