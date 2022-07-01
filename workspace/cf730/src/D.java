import java.util.*;
import java.io.*;
public class D {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T-->0) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			for(int i = 1; i <= n; i += 2) {
				System.out.println(i);
				int r = sc.nextInt();
				if(r == 1) break;
				System.out.println(i);
				r = sc.nextInt();
				if(r == 1) break;
			}
		}
			
	}

}
