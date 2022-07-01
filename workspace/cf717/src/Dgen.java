import java.util.*;
import java.io.*;
public class Dgen {

	public static void main(String...strings) {
		Random r = new Random();
		int n = 20, q = 100;
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = r.nextInt(100)+1;
		}
		System.out.println(n+" "+q);
		for(int i = 0; i < n; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println("");
		for(int i = 0; i < q; i++) {
			int a = r.nextInt(n)+1;
			int b = r.nextInt(n-a+1)+a;
			System.out.println(a+" "+b);
		}
	}
}